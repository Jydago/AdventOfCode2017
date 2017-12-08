package utils

import scala.io.Source

/**
  * Created by Johnny Dang on 2017-12-06.
  */
object FileUtil {

  val initPath = "E:\\Projects\\IntelliJ\\AdventOfCode\\src\\main\\scala\\"

  def getFile(dir: String, file: String): List[String] = {
    Source.fromFile(initPath + dir + "\\" + file).getLines.toList
  }

}
