import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.scalatest._

import Display._

@RunWith(classOf[JUnitRunner])
class DisplayTest extends FunSuite {

  test("Example: has subtree") {
    val right = """+-Root
    |  +-level1-1
    |  +-level1-2
    |  +-level1-3
    |  """.stripMargin
    val res = asciiDisplay(TreeNode("Root",
      children = List(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3")))).mkString("\n")
    assert(res == right)
  }

  test("Example: has vertical lines") {
    val right = """+-Root
    |  +-level1-1
    |  | +-level2-1
    |  |   +-level3-1
    |  |   
    |  +-level1-2
    |  +-level1-3
    |  """.stripMargin
    val res = asciiDisplay(TreeNode("Root",
      children = List(
        TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
        TreeNode("level1-2"),
        TreeNode("level1-3")))).mkString("\n")
    assert(res == right)
  }
}