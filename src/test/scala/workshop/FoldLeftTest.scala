package workshop

import org.scalatest.{FunSuite, Matchers}

class FoldLeftTest extends FunSuite with Matchers {

  test("foldLeft should accumulate items from non-empty list according to the provided function") {
    val initialList = workshop.List(1, 2, 3)

    val foldedResult1 = initialList.foldLeft(0) { case (acc, item) => acc + item }
    val foldedResult2 = initialList.foldLeft("Numbers:") { case (acc, item) => s"$acc $item" }

    foldedResult1 shouldBe 6
    foldedResult2 shouldBe "Numbers: 1 2 3"
  }

  test("foldLeft should return the initial value of the accumulator when list is empty") {
    val initialList = workshop.List[Int]()

    val foldedResult1 = initialList.foldLeft(0) { case (acc, item) => acc + item }
    val foldedResult2 = initialList.foldLeft("Numbers:") { case (acc, item) => s"$acc $item" }

    foldedResult1 shouldBe 0
    foldedResult2 shouldBe "Numbers:"
  }
}
