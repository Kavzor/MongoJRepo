# MongoJRepo

Introduction
Libary meant to ease the setup of a mongodb repository. The attempt is to abstract away the database-talk and maintain a clean and neat syntax while still offering the user the ability to choose key value for each entity.


# How to use

Adding to project
1. Install MongoDB on your machine
2. Start MongoDB at port 27017, address localhost (can be changed at runtime)
3. Clone or pull down the repositiory.
4. Add the jar folder target/kavzor-mognodb-1.0-SNAPSHOT.jar to your build path

Usage
* For POC see src/ProofOfConcept.java

Criteras for using MongoJ Repo
- Entity must implement com.kavzor.mongo.repository.MongoDBCritera
- Entity must override equals method (to prevent adding the same object twice)

Example
```java

//Declaring entity which has a MongoDBCritera to dermine the key value for each entity
public class User implements MongoDBCritera {
  private String name;

  public User(String name) {
    this.name = name;
  }
  
  //Using the attribute name for finding the entity, any attribute may be used
  @Override
  public SearchCritera getQueryCritera() {
    return new SearchCritera("name", name);
  }

  @Override
  public boolean equals(Object object) {
    User user = (User) object;
    if(user.getName().equals(this.name)) {
      return true;
    }
    return false;	
  }
}  

//main
//using the repo
public static void main(String[] args) {

  Repository<User> userRepo = new MongoDBRepository<>(User.class);
  userRepo.add(new User("Lars");
  userRepo.add(new User("Karl");
    
  for(User user : userRepo.findAll()) {
    System.out.println("User's name: " + user.getName());
  }
}

```

# License
[MIT License](https://github.com/Kavzor/MongoJRepo/blob/master/LICENSE)
