object Main extends App {
  println("Hello world")
  class Fruit 
  abstract class Citrus extends Fruit
  class Orange extends Citrus
  class Tangelo extends Citrus
  class Apple extends Fruit
  class Banana extends Fruit

  class MyContainer[-A](a: A)(implicit manifest: scala.reflect.Manifest[A]) {
    private[this] var item = a

    //def get = item
    def set(a: A) {
      item = a
    }

    def contents = manifest.runtimeClass.getSimpleName
  }

  val fruitBasket: MyContainer[Fruit] = new MyContainer[Fruit](new Orange())
  println(fruitBasket.contents) 

  val fruitBasket2: MyContainer[Orange] = new MyContainer[Orange](new Orange())
  println(fruitBasket2.contents) 

  val fruitBasket3: MyContainer[Citrus] = new MyContainer[Citrus](new Orange())
  println(fruitBasket3.contents) 

  val fruitBasket4: MyContainer[Orange] = new MyContainer[Fruit](new Orange())
  println(fruitBasket4.contents) 
  
  val fruitBasket5: MyContainer[Orange] = new MyContainer[Fruit](new Tangelo())
  println(fruitBasket5.contents) 

  val fruitBasket6: MyContainer[Orange] = new MyContainer[Citrus](new Tangelo())
  println(fruitBasket6.contents) 

  val fruitBasket7: MyContainer[Tangelo] = new MyContainer[Citrus](new Tangelo())
  val fruitBasket8 : MyContainer[Orange] = fruitBasket7.asInstanceOf[MyContainer[Orange]]
  fruitBasket8.set(new Orange())
  println(fruitBasket8.contents) 
  

}
