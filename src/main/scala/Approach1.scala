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


  var min = 500.0
  var max = -1.0
  var max_name :String = ""
  var min_name :String = ""

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

  def convert_list_to_k(in:List[Any]): Any =  {

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

      }

      );
      return newlst
    }

    if(newin2.size > 0 ){
      var newlst: List[Double] = List[Double]()
        newin2.foreach( x => {
            var i =  x * 0.45.toDouble
            newlst = newlst ::: List(i)
          }
        )
      return newlst
    }

  }
  def find_max_and_min(in: List[Any]): Any = {

    var newin1  = in.collect{case personD(x:String, y:Double) => (x:String, y:Double)}
    var newin2  = in.collect{case (x:Double) => (x:Double) }

    println("in:"+in)
    println("newin1:"+newin1)
    println("newin2:"+newin2)

    if(newin1.size > 0 ){
      var newlst: List[personD] = List[personD]()
      newin1.foreach( x  => {

        println("inside personI: " + x+" "+x._1 +" "+x._2)

        var nname = extractString(x._1 )

        if(x._2 > max){
          max = x._2
          max_name = nname
        }
        if(x._2 < min){
          min = x._2
          min_name = nname
        }


      }

      );
      return (max_name, max, min_name, min)
    }

    if(newin2.size > 0 ){
      var newlst: List[Double] = List[Double]()
      newin2.foreach( x => {
        if(x > max){
          max = x
        }
        if(x < min){
          min = x
        }
      }
      )
      (max_name, max, min_name, min)
    }
    println("31:"+ min_name +" 41:"+max_name);
    (max_name, max, min_name, min)
  }

  def main(args: Array[String]): Unit = {

    val p1 = Approach1.personD("lenin", 90.9)
    val p2 = Approach1.personD("name1", 70.2)
    val p3 = Approach1.personD("name4a", 60.1)

    var lstD = List(p1, p2 , p3)

    println("Hello world 1!")
    // given object <name,weight>, find the min and max weight along with the person name
    var ret = Approach1.find_max_and_min(lstD);
    println("---->res1:"+ret)

    // convert given a list of double weights (kgs to lbs)
    ret = convert_list_to_k(List[Double](1.1,2.2,1.1));
    println("---->res2:"+ret)

    // given list of <weight>,  find the min and max
    ret = Approach1.find_max_and_min(List(ret));
    println("---->res3:"+ret)


    //  convert from kgs to lbs
    ret = convert_list_to_k(lstD);
    println("---->res4:"+ret)



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



