# MongoJRepo

Introduction
Libary meant to ease the setup of a mongodb repository


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

//Declaring class
public class User implements MongoDBCritera
//Code
  
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
    //code
    
    //main
    //using the repo
    Repository<User> userRepo = new MongoDBRepository<>(User.class);
    userRepo.add(new User("Lars");
    userRepo.add(new User("Karl");
    
    for(User user : userRepo.findAll()) {
			System.out.println("User's name: " + user.getName());
	  }

```

# License
[MIT License](https://github.com/Kavzor/MongoJRepo/blob/master/LICENSE)
