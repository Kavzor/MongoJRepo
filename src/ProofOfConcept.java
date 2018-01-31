import java.util.List;

import com.kavzor.mongo.repository.MongoDBCritera;
import com.kavzor.mongo.repository.MongoDBRepository;
import com.kavzor.mongo.repository.Repository;
import com.kavzor.mongo.translator.SearchCritera;

public class ProofOfConcept {
	
	/**
	 * Note that a mongo client must be running on port 27017 for instant-runs
	 * Multiple runs won't add more instances to the database since MongoDBRepository ensures 
	 * that only one mongoDBCritera can exist in the database at any given time through the objects
	 * equals method, hence you must always override the equals method for all persisted entities.
	 */
	public static void main(String[] args) {
		Repository<User> userRepo = new MongoDBRepository<>(User.class);
		
		System.out.println("BEFORE");
		displayList(userRepo.findAll());
		
		addMockData(userRepo);
		
		System.out.println(" \nAFTER");
		displayList(userRepo.findAll());
	}

	public static void addMockData(Repository<User> repo) {
		User user = new User("Hello World");
		repo.add(user);
		
		user = new User("Lars");
		repo.add(user);
		
		user = new User("Sterotype");
		repo.add(user);
		
	}
	
	public static void displayList(List<User> users) {
		for(User user : users) {
			System.out.println("User's name: " + user.getName());
		}
	}
	
	public static class User implements MongoDBCritera{

		public String name;
		
		public User(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
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
}
