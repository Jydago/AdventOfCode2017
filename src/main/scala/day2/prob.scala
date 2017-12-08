package day2

import utils.FileUtil

/**
  * Created by Johnny Dang on 2017-12-06.
  */
object prob {

  def main(args: Array[String]): Unit = {
    val input = FileUtil.getFile("day2", "input.txt")
    val numbers = input.map(s => s.split("\t").map(_.toInt))
    val sum1 = numbers.map(nbrs => nbrs.max - nbrs.min).sum
    println("Sum1: " + sum1)

    val sum2 = numbers.map(findDivisibles).sum
    println("Sum2: " + sum2)
  }

  def findDivisibles(nbrs: Array[Int]): Int = {
    val divident = findDivisibleInList(nbrs.head, nbrs.tail)
    if (divident == 0) findDivisibles(nbrs.tail)
    else divident
  }

  def findDivisibleInList(head: Int, nbrs: Array[Int]): Int = {
    val next = nbrs.head
    if (head % next == 0) head / next
    else if (next % head == 0) next / head
    else if (nbrs.length == 1) 0
    else findDivisibleInList(head, nbrs.tail)
  }

}
