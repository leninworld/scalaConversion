object Approach1    {
  println("/**********/")

  trait Something[String, T]{
    def name:String
    def weight:T
  }

  case class personI(name: String, weight: Int) extends Something[String, Int]
  case class personlstI(values: List[personI])

  case class personD(name: String, weight: Double) extends Something[String, Double]
  case class personlstD(values: List[personD])

  case class Strings(values: List[String])
  case class Ints(values: List[Int])
  case class Doubles(values: List[Double])

  val p1 = personD("lenin", 90.9)
  val p2 = personD("name1", 70.2)
  val p3 = personD("name4a", 60.1)

  var lst = List(p1, p2 , p3)

  val p4 = personI("lenin", 90)
  val p5 = personI("name1", 70)
  val p6 = personI("name4a", 60)

  var lst1 = List(p4, p5 , p6)

  var min = 500.0
  var max = -1.0
  var max_name :String = ""
  var min_name :String = ""

//  var ret = find_max_and_min(personlstI(lst1));
     var ret = convert_list_to_k(lst1);
  println("max:"+max +" min:"+min +" "+ ret);

  def printType[T](x:T) :Unit = {
    println(x.getClass.toString())
  }

  def convert_list_to_k(in:List[Any]) : Any = in match{

    case vs:List[person] => {
      var newlst: List[Any] = List[Any]()

      for (person <- in) {
        println("10:" + person+" "+person )

        person match {
          case v:personI => {
            var i = (v.weight).toDouble * 0.45.toDouble
            var p1 = personD(v.name, i)
            newlst = newlst ::: List(p1)
          }
        }

      }

      return newlst
    }
    case _ => {
      println("hi1")
      ("na", 0, "na", 0)
    }


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
