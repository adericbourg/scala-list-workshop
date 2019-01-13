package workshop

import org.scalatest.{FunSuite, Ignore, Matchers}

@Ignore
class ReverseTest extends FunSuite with Matchers {

  test("reverse should create a new list with elements in reverse order") {
    val initialList = workshop.List(1, 2, 3)

    val reversedList = initialList.reverse

    reversedList shouldBe workshop.List(3, 2, 1)
  }

  test("reversing an empty list should be empty") {
    val initialList = workshop.List()

    val reversedList = initialList.reverse

    reversedList shouldBe workshop.List()
  }
}
