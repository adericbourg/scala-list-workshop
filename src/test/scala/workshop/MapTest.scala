package workshop

import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec

class MapTest extends FunSuite with Matchers {

  test("map should create a new list where provided function is applied to each elements") {
    val initialList = workshop.List(1, 2, 3)

    val mappedList1 = initialList.map(x => x + 1)
    val mappedList2 = initialList.map(x => x.toString)

    mappedList1 shouldBe workshop.List(2, 3, 4)
    mappedList2 shouldBe workshop.List("1", "2", "3")
  }

  test("map should return an empty list when initial list is empty") {
    val initialList = workshop.List[Int]()

    val mappedList = initialList.map(x => x + 1)

    mappedList shouldBe workshop.List()
  }

  ignore("map should handle big lists") {
    val elementCount = 1000000
    val initialList = mkBigListOfInt(1, elementCount)

    val mappedList = initialList.map(item => item + 1)

    assertAreSame(mappedList, mkBigListOfInt(2, elementCount + 1))
  }

  private def mkBigListOfInt(start: Int, end: Int) = (start to end).foldRight(workshop.List[Int]()) {
    case (item, acc) => Cons(item, acc)
  }

  @tailrec
  private def assertAreSame[T](a: List[T], b: List[T]): Unit = {
    a match {
      case Cons(aHead, aTail) => b match {
        case Cons(bHead, bTail) =>
          aHead shouldBe bHead
          assertAreSame(aTail, bTail)
        case Empty              =>
          fail("right is shorter than left")
      }
      case Empty              => a shouldBe b
    }
  }
}
