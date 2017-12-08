package day3

/**
  * Created by Johnny Dang on 2017-12-06.
  */
object prob {

  def main(args: Array[String]): Unit = {
    val input = 277678
    println(calcAnswer(input))
  }

  // Prob 2


  // Prob 1
  def calcAnswer(input: Int): Int = {
    val quad = findQuadNumber(input)
    val distToMiddleNumber = findMiddleNumbers(quad).map(middle => math.abs(input - middle)).min
    distToMiddleNumber + calcMiddleNumberCenterDist(quad)
  }

  def calcMiddleNumberCenterDist(quad: Int): Int = (quad - 1) / 2

  def findMiddleNumbers(quad: Int): List[Int] = {
    val sq = math.pow(quad, 2)
    val firstMiddle = sq - calcMiddleNumberCenterDist(quad)
    val nextMiddle = quad - 1
    (0 to 3).map(i => firstMiddle.toInt - nextMiddle * i).toList
  }

  def findQuadNumber(goal: Int): Int = findQuadNumber(goal, 1)

  def findQuadNumber(goal: Int, curr: Int): Int = if (math.pow(curr, 2) >= goal) curr else findQuadNumber(goal, curr+2)
}
