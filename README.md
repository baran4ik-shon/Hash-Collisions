# Hash-Collisions
# Application start
  1. clone the project;
  2. cd Hash-Collisions
  3. execute: mvn spring-boot:run
  4. make post request using Http client like curl,
  for exemple: curl -X POST -H 'Content-Type:application/json' -d '{"inList" : [ "Bob", "boj", "obb", "job", "BOB", "foo" ]}' http://localhost:8080/searchCollisions
  
Goal:
Write an HTTP service which accepts an array of strings and returns the sets of strings which collide in the hash table in the order they appeared in the input list.

Problem: 

Receive as input an array of strings.  
Return the set of strings which collide in the hash table in the order they appear in the input list.  
The hash algorithm should be implemented as the sum of the ASCII values of the lower-cased letters.  For example, “Bob”, “bob”, and “obb” all hash to the same number.

Example input: 
{ "inList" : [ "Bob", "boj", "obb", "job", "BOB", "foo" ] }  
Example output: 	
{"outList": [   [ "Bob", "obb", "BOB" ] ,   [ "boj", "job" ]    ]   }

Do not output strings which do not collide, such as “foo” in the example above.  If the table has no collisions, return the empty array.  { "outList" : [ ] }
