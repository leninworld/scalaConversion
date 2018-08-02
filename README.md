### This project contains a Scala script to convert a list of weights from kgs to lbs. 

The important part is to not to do any tightly bound static typecasting. It uses Any concept with List in Scala to achieve this.

<b>Scripts Overview:</b>

(1) convertKg2lbs.scala - This file has methods convert_list_to_k(List[Any]), which takes list of any type. This file is found inside src/main/scala.

(2) We basically give two type if inputs to convert_list_to_k, and one is list of weights and other is list of person object. Each person object can have a pair of name and weight (in kgs).

<b>Unit Testing:</b>

Unit Testing is done by script convertSpec.scala. This file is located in src/main/test. It uses ScalaTest framework to test the two input cases discussed in point (2) above. 

<b>How to run:</b>

(1) This project can be opened using IntelliJ IDE or similar.

(2) Run the sbt to get the dependencies before you run convertKg2lbs.scala  or convertSpec.scala.
