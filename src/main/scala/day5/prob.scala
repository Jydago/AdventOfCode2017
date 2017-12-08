package day5

import utils.FileUtil

/**
  * Created by Johnny Dang on 2017-12-08.
  */
object prob {

  def main(args: Array[String]): Unit = {
    val input = FileUtil.getFile("day5", "input.txt").map(_.toInt)
    println(input)
  }

}
