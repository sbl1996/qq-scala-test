import Display._

object Main extends App {
  asciiDisplay(TreeNode("Root",
      children = List(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3")))).foreach(println)
  asciiDisplay(TreeNode("Root",
  children = List(
    TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
    TreeNode("level1-2"),
    TreeNode("level1-3")))).foreach(println)
}