package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.PreparedQuery;

import fr.cpe.ha.jbbflight.models.User_to_Connection;

/**
 * Handle data access for the User_to_Connection Object Model.
 * 
 * @author Benjamin Chastanier
 *
 */
public class DALUser_to_Connection {

	/**
	 * Singleton
	 */
	private static DALUser_to_Connection instance = null;
	
	/**
	 * Get datastore instance.
	 */
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	private DALUser_to_Connection(){}
	
	/**
	 * Get the singleton instance.
	 * 
	 * @return singleton instance
	 */
	public static DALUser_to_Connection getInstance() {
		if(instance == null)
			instance = new DALUser_to_Connection();
		return instance;
	}
	
	/**
	 * Get all undeleted User_to_Connections from the datastore.
	 * @return
	 */
	public List<User_to_Connection> GetAllUser_to_Connections() {
		
		Query q = new Query("User_to_Connection")
			.setFilter(new FilterPredicate("utc_is_deleted", FilterOperator.NOT_EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<User_to_Connection> retUser_to_Connections = new ArrayList<User_to_Connection>();
		for(Entity user : pq.asList(FetchOptions.Builder.withDefaults())){
			retUser_to_Connections.add(new User_to_Connection(user));
		}
		
		return retUser_to_Connections;
	}
	
	/**
	 * Get the User_to_Connection corresponding with the identifier.
	 * 
	 * @param id User_to_Connection's Unique identifier
	 * @return
	 */
	public User_to_Connection GetUser_to_ConnectionById(int id) {
		
		Query q =  new Query("User_to_Connection")
        	.setFilter(new FilterPredicate(
        					Entity.KEY_RESERVED_PROPERTY,
        					Query.FilterOperator.EQUAL, 
        					id)
                       );
		PreparedQuery pq = datastore.prepare(q);

		return new User_to_Connection(pq.asSingleEntity());
	}
	
	/**
	 * Add the User_to_Connection in the datastore.
	 * 
	 * @param usr
	 * @return
	 */
	public boolean AddUser_to_Connection(User_to_Connection usr) {
		
		datastore.put(usr.toDatastoreEntity());
		
		return true;
	}
	
	/**
	 * Update the User_to_Connection values in the datastore.
	 * 
	 * @param usr
	 * @return
	 */
	public boolean UpdateUser_to_Connection(User_to_Connection usr) {
		
		return AddUser_to_Connection(usr);
	}
	
	/**
	 * Logical remove the User_to_Connection in the datastore. 
	 * 
	 * @param usr
	 * @return
	 */
	public boolean RemoveUser_to_Connection(User_to_Connection usr) {
		
		usr.setUtc_is_deleted(true);
		UpdateUser_to_Connection(usr);
		
		return true;
	}
}
