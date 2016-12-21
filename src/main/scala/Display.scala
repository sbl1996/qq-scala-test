object Display {

  case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

  def asciiDisplay(root: TreeNode[String]): Seq[String] = {
    val prefix = "+-"
    val s = prefix + root.data

    def loop(children: Seq[TreeNode[String]]): Seq[String] = children match {
      case Seq(x) => {
        val lines = asciiDisplay(x)
        //ensure no repeated blank lines
        def isBlankLine(line: String) = line forall (c => c == ' ' || c == '|')
        if (isBlankLine(lines.last)) lines //List#last leads to LOW PERFORMANCE
        else lines :+ "" 
      }
      case h :: t => addVerticalLine(asciiDisplay(h)) ++ loop(t)
    }

    root.children match {
      case Nil => Seq(s)
      case xs  => s +: (loop(xs) map ("  " + _))
    }
  }

  private def addVerticalLine(xs: Seq[String]) = xs match {
    case h :: t => h :: (t map (_.updated(0, '|')))
  }

}