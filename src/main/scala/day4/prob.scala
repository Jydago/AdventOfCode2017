package day4

import utils.FileUtil

/**
  * Created by Johnny Dang on 2017-12-08.
  */
object prob {

  def main(args: Array[String]): Unit = {
    val input = FileUtil.getFile("day4", "input.txt").map(_.split(" ").toList)
    println("Prob1: " + calcValid1(input))

    println("Prob2: " + calcValid2(input))
  }

  def calcValid2(wordLists: List[List[String]]): Int = wordLists.count(checkAnagrams)

  def checkAnagrams(words: List[String]): Boolean = words.combinations(2).forall{ case List(a, b) => a.sorted != b.sorted}

  def calcValid1(wordLists: List[List[String]]): Int = wordLists.count(checkUniques)

  def checkUniques(words: List[String]): Boolean = words.distinct.length == words.length

}
