package workshop

import org.scalatest.{FunSuite, Ignore, Matchers}

@Ignore
class PrependTest extends FunSuite with Matchers {

  test("prepend should create a new list with provided element as head when initial list is filled") {
    val initialList = workshop.List(1, 2, 3) // Cons(1, Cons(2, Cons(3, Empty)))

    val prependedList = initialList.prepend(0)

    prependedList shouldBe workshop.List(0, 1, 2, 3)
  }

  test("prepend should create a new list with provided element as head when initial list is empty") {
    val initialList = workshop.List() // Empty

    val prependedList = initialList.prepend(0)

    prependedList shouldBe workshop.List(0)
  }
}
