object convertKg2lbs    {
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

    // filter as per type
    var newin1  = in.collect{case personD(x:String, y:Double) => (x:String, y:Double)}
    var newin2  = in.collect{case (x:Double) => (x:Double) }

    println("input:"+in)

    var newlst : List[Any] = List[Any]()
    if(newin1.size > 0 ){
      newin1.foreach( x  => {
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

    var newlst : List[Any] = List[Any]()
    if(newin1.size > 0 ){
      newin1.foreach( x  => {

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

  def format_weight(in:List[Any]): Any ={
    var ret = convertKg2lbs.convert_list_to_k(in)
    print_weight(ret)
    ret = convertKg2lbs.find_max_and_min(List(ret))
    var res = print_max_and_min(ret)
    res
  }

  def print_weight(in: Any): Unit = {
    println("Printing converted weights => " + in)
  }

  def print_max_and_min(in: Any): Any = {
    println("{max weight, min weight} => " + in)
    in
  }

  def main(args: Array[String]): Unit = {
      println("Main method")

  }

}




