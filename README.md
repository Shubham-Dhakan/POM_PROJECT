# POM_PROJECT

1) In PageObjects Folder --> 5 different classes of 5 different phases(pages) of a E-commerce website  
LoginPage | ProductCatalogue | CartPage | CheckOutPage | OrderPlacedMessage

2) In RahulShettyQaClass --> Main POM file(StandAloneTest) is there and run that main file. 

3) In RahulShettyAcademy.Data --> There is json file of Data which is used for Login and Product we are selecting in website for End-to-end testing.
Also there is dataReader.java file ---> which coverts the json file to String and From string to HashMaps to pass multiple values in test case with 
the Help of  TestNG @DataProvider method annotation. 
