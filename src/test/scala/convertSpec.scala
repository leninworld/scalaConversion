import Approach1.format_weight
import org.scalatest.FlatSpec

class convertSpec extends FlatSpec {
  // tests go here...

  "An input list of weights (in kgs)" should "have give output of max weight and min weight (in lbs)" in {

    var lst = List[Double](65.1, 120.2, 77.1, 54)
    var out1 = format_weight(lst)

    var res = Approach1.format_weight(lst)
    assert(res == (264.99563914622286,119.04962157983388))

  }

  "An input list of <Name, Weight (in kgs)>" should "return max_person_name, max_weight (in lbs), min_person_name, min_weight (in lbs)" in {

    val p1 = Approach1.personD("lenin", 90.9)
    val p2 = Approach1.personD("martin", 70.2)
    val p3 = Approach1.personD("kishore", 60.1)
    val p4 = Approach1.personD("lalitha", 68.1)
    var lstND = List(p1, p2 , p3)
    var out2 = format_weight(lstND)
    assert(out2 == ("lenin",200.40019632605373,"kishore",132.49781957311143))

  }

}