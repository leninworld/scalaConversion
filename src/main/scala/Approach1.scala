object Approach1    {
  println("/**********/")

  trait Something[String, T]{
    def name:String
    def weight:T
  }

  case class personD(name: String, weight: Double) extends Something[String, Double]

  var min = 500.0
  var max = -1.0
  var max_name :String = ""
  var min_name :String = ""

  def printType[T](x:T) :Unit = {
    println(x.getClass.toString())
  }

  def convert_list_to_k(in:List[Any]): Any =  {

    var newin1  = in.collect{case personD(x:String, y:Double) => (x:String, y:Double)}
    var newin2  = in.collect{case (x:Double) => (x:Double) }

    println("in:"+in)
//    println("newin1:"+newin1)
//    println("newin2:"+newin2)
    var newlst : List[Any] = List[Any]()
    if(newin1.size > 0 ){
      newin1.foreach( x  => {

           //println("inside personD: " + x+" "+x._1 +" "+x._2)
            var i =  x._2 / 0.45359237
            var nname = x._1
            var p1 = personD(nname, i)
            newlst = newlst ::: List(p1)

      }

      );
      return newlst
    }

    if(newin2.size > 0 ){
        newin2.foreach( x => {
            var i =  x / 0.45359237
            newlst = newlst ::: List(i)
          }
        )
      return newlst
    }
    return newlst
  }
  def flatten(l: List[Any]): List[Any] = l flatMap {
    case ls: List[_] => flatten(ls)
    case h => List(h)
  }

  def find_max_and_min(in: List[Any]): Any = {
    min = 500.0
    max = -1.0
    var  newin = flatten(in)

    var newin1  = newin.collect{case personD(x:String, y:Double) => (x:String, y:Double)}
    var newin2  = newin.collect{case (x:Double) => (x:Double) }

//    println("in:"+in)
//    println("newin1:"+newin1)
//    println("newin2:"+newin2)
    var newlst : List[Any] = List[Any]()
    if(newin1.size > 0 ){
      newin1.foreach( x  => {

//        println("inside personI: " + x+" "+x._1 +" "+x._2)

        if(x._2 > max){
          max = x._2
          max_name = x._1
        }
        if(x._2 < min){
          min = x._2
          min_name = x._1
        }
      }

      );

      return (max_name, max, min_name, min)
    }

    if(newin2.size > 0 ){
      newin2.foreach( x => {
        if(x > max){
          max = x
        }
        if(x < min){
          min = x
        }
      }
      )
      (max, min)
    }
  }

  def main(args: Array[String]): Unit = {

    // START - wrapper Sequence
    val p1 = Approach1.personD("lenin", 90.9)
    val p2 = Approach1.personD("martin", 70.2)
    val p3 = Approach1.personD("kishore", 60.1)
    val p4 = Approach1.personD("lalitha", 68.1)

    var lstD = List(p1, p2 , p3)
    println("------------------------")
    // convert given a list of double weights (kgs to lbs)
    var ret = Approach1.convert_list_to_k(List[Double](65.1,100.2,77.1, 54))
    println("---->res1:"+ret +" "+printType(ret))
    println("------------------------")

    // given list of <weight>,  find the min and max
    ret = Approach1.find_max_and_min(List(ret))
    println("---->res2:"+ret)
    println("------------------------")
    //  convert from kgs to lbs
    ret = Approach1.convert_list_to_k(lstD)
    println("---->res3:"+ret)
    println("------------------------")
    ret = Approach1.find_max_and_min(List(ret));
    println("---->res4:"+ret)
    // END - wrapper Sequence

  }

}


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



