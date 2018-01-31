# MongoJRepo

Introduction
Libary meant to ease the setup of a mongodb repository


#How to use

Adding to project
1. Clone or pull down the repositiory.
2. Add the jar folder target/kavzor-mognodb-1.0-SNAPSHOT.jar to your build path

Usage
For POC see src/ProofOfConcept.java

Criteras for using MongoJ Repo
- Entity must implement com.kavzor.mongo.repository.MongoDBCritera
- Entity must override equals method (to prevent adding the same object twice)

#License
[MIT License](https://github.com/Kavzor/MongoJRepo/blob/master/LICENSE)
