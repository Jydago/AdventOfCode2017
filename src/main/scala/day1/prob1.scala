package day1

import utils.FileUtil

/**
  * Created by Johnny Dang on 2017-12-06.
  */
object prob1 {

  def main(args: Array[String]): Unit = {
    val input = FileUtil.getFile("day1", "input1.txt")
    val numbers = input.head.map(i => i.asDigit).toList
    println(numbers)
    println("First day: " + calcNumberSum(numbers, 1))
    println("Second day: " + calcNumberSum(numbers, numbers.length / 2))
  }

  def calcNumberSum(numbers: List[Int], stepLength: Int): Int =
    numbers.zip(rotatedView(numbers, stepLength))
      .foldLeft(0)((sum, e) => if (e._1 == e._2) sum + e._1 else sum)

  def rotatedView(list: List[Int], rotationSteps: Int): List[Int] = list.view.toList.drop(rotationSteps) ++ list.view.toList.take(rotationSteps)

  def calcNumberSum1(numbers: List[Int]): Int = {
    val qq = numbers.foldLeft((0, 0))((sum, next) => {
      if (sum._2 == next) (sum._1 + next, next) else (sum._1, next)
    })

    if (qq._2 == numbers.head) qq._1 + numbers.head else qq._1
  }

  def calcNumberSum2(numbers: List[Int]): Int = {
    val stepLength = numbers.length / 2
    val rotatedList = rotatedView(numbers, stepLength)

    numbers.zip(rotatedList).foldLeft(0)((sum, e) => {
      if (e._1 == e._2) sum + e._1 else sum
    })
  }


}
