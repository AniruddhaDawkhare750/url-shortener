# url-shortener

Simple url-shortener build with the java Springboot technology allows to short long-url.

Technology:

Backend: java(17), springboot( 3.4.3)

Database: MySQL(8.0)

Build tool:Maven

 1) This is how PostAPI and GetAPI looks in Swagger User Interface for maven.

![url-shotener.PNG](images%2Furl-shotener.PNG)
 
2) PostAPI : It accepts long-URL and converts in short-URL. 
  Long-URL stored in database .
![url-shotener2.PNG](images%2Furl-shotener2.PNG)

3) GetAPI : Accepts short-URL and gives long-URL .
     Checks short-URL in db and send long-URL to user.
![url-shotener3.PNG](images%2Furl-shotener3.PNG)


4) Long URL of short-URL. 
![url-shotener4.PNG](images%2Furl-shotener4.PNG)


I used base_10 to base_26 conversion Strategy for short-URL.
Short-URL has two parts first is  base-URL which is constant and other is dynamic part of base_26 string of length 7.
Dynamic part of short-URL as shown below,

example:

constant integer= 1000000000

base-link = "https://localhost:8080/"

 Primary key of table is auto increment is long so for first record id(dbid) will 1.
First calculate base_10 number as addition of const integer and db primary key id,
then convert into string. This will generate short-URL of length 7.

for short-link: 

base-link + conversion of integer to base_26 string(const int + dbid). 

                https://localhost:8080/bklnjjm

Conversion from base_10 to base_26 of 1000000001 is bklnjjm.

For getting long-link string is converted into base_10 integer,const integer is subtracted from it and search id in database.


 conversion of base_26 to integer - constant integer.

Search reminder in database.
