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

    println("input:"+in)
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

  def format_weight(in:List[Any]): Unit ={
    var ret = Approach1.convert_list_to_k(in)
    print_weight(ret)
    ret = Approach1.find_max_and_min(List(ret))
    print_max_and_min(ret)
  }

  def print_weight(in: Any): Unit = {
    println("Printing converted weights => " + in)
  }

  def print_max_and_min(in: Any): Unit = {
    println("{max weight, min weight} => " + in)
  }

  def main(args: Array[String]): Unit = {

    // START - wrapper Sequence
    val p1 = Approach1.personD("lenin", 90.9)
    val p2 = Approach1.personD("martin", 70.2)
    val p3 = Approach1.personD("kishore", 60.1)
    val p4 = Approach1.personD("lalitha", 68.1)

    /////// test run for list of weights
    println("----------------------------------")
    println("test run for list of weights")
    var lst = List[Double](65.1, 120.2, 77.1, 54)
    format_weight(lst)
    /////// test run for list of <name, weight>
    println("----------------------------------")
    println("test run for list of <name, weight>")
    var lstND = List(p1, p2 , p3)
    format_weight(lstND)
    println("----------------------------------")

  }

}




