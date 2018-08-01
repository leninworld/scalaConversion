import scala.util.Try

object Approach1    {
  println("/**********/")

  trait Something[String, T]{
    def name:String
    def weight:T
  }

//  case class personI(name: String, weight: Int) extends Something[String, Int]
//  case class personlstI(values: List[personI])

  case class personD(name: String, weight: Double) extends Something[String, Double]
  case class personlstD(values: List[personD])

  case class Strings(values: List[String])
  case class Ints(values: List[Int])
  case class Doubles(values: List[Double])

  val p1 = personD("lenin", 90.9)
  val p2 = personD("name1", 70.2)
  val p3 = personD("name4a", 60.1)

  var lstD = List(p1, p2 , p3)

  var min = 500.0
  var max = -1.0
  var max_name :String = ""
  var min_name :String = ""

//  var ret = find_max_and_min(personlstI(lst1));
//     var ret = convert_list_to_k(lstI);
     var ret = convert_list_to_k(lstD);
//  var ret = convert_list_to_k(List[Double](1.1,2.2,1.1));
  println("max:"+max +" min:"+min +" "+ ret);

  def printType[T](x:T) :Unit = {
    println(x.getClass.toString())
  }

  def extractDouble(expectedNumber: Any): Double = expectedNumber match {
    case i: Int => i.toDouble
    case l: Long => l.toDouble
    case d: Double => d
  }

  def extractString(expectedNumber: Any): String = expectedNumber match {
    case d: String => d
  }



  def convert_list_to_k(in:List[Any]):Any =  {

    var newin1  = in.collect{case personD(x:String, y:Double) => (x:String, y:Double)
                            }
    var newin2  = in.collect{case (x:Double) => (x:Double) }

    println("in:"+in)
    println("newin1:"+newin1)
    println("newin2:"+newin2)


    if(newin1.size > 0 ){
      var newlst: List[personD] = List[personD]()
      newin1.foreach( x  => {

            println("inside personI: " + x+" "+x._1 +" "+x._2)
            var i =  x._2 * 0.45.toDouble
            var nname = extractString(x._1 )
            var p1 = personD(nname, i)
            newlst = newlst ::: List(p1)

//            for ((name, w) <- x) {
//                  var dw = extractDouble(w)
//
//                  var i =  dw * 0.45.toDouble
//                  var nname = extractString(name)
//                  var p1 = personD(nname, i)
//                  newlst = newlst ::: List(p1)
//
//              }
//
      }

      );
      return newlst
    }
//    newin2.filter( _ match {
//
//      case x: ( Double) => {
//        var i =  dw * 0.45.toDouble
//      }
//    )

//    else if( in.isInstanceOf[List[Int]]){
//
//      println("(int)given list: "+in)
//      println("list of integers given")
//      ("na", 0, "na", 0)
//    }


  }

//  def find_max_and_min(in: Any): (String, Double, String, Double) = in match{
//
//    case Strings(vs) => {
//      println("hi1")
//      ("na", 0, "na", 0)
//    }
//    case Ints(vs) => {
//      println("hi2")
//      ("na", 0, "na", 0)
//    }
//    case vs => {
//      println("hi3 "+ vs)
//
//      lst.map{
//        t => {
//          println("1:"+ t.name +" 2:"+t.weight);
//          if(t.weight > max){
//            max = (t.weight).toDouble
//            max_name = t.name
//          }
//          if(t.weight < min){
//            min = (t.weight).toDouble
//            min_name = t.name
//          }
//        }
//      }
//      println("31:"+ min_name +" 41:"+max_name);
//      (max_name, max, min_name, min)
//    }
//
//  }

//  def print_weight(in: Any) = in match {
//
//    case Strings(vs) => {
//      println("hi1")
//      ("na", 0, "na", 0)
//    }
//    case Ints(vs) => {
//      println("hi2")
//      ("na", 0, "na", 0)
//    }
//    case vs => {
//
//    }
//
//  }

  def main(args: Array[String]): Unit = {
    println("Hello world 1!")
  }

}
