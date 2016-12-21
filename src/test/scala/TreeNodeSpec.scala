import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import Prop.forAll

import Display._

object TreeNodeSpec extends Properties("TreeNode") {

  type StringNode = TreeNode[String]

  //MAY CAUSE Stackoverflow
  val genStringNode: Gen[StringNode] = for {
    data <- alphaNumStr
    children <- frequency((9, const(Nil)), (1, listOfN(2,genStringNode)))
  } yield TreeNode(data, children)

  property("String TreeNode") = forAll(genStringNode) { (x: StringNode) => 
    asciiDisplay(x).head == "+-" + x.data 
  }

  //TODO
  //more specs

}