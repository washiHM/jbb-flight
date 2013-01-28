package fr.cpe.ha.jbbflight.models;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;

/**
 * Represents an application User.
 * 
 * @author Benjamin Chastanier
 *
 */
public class User {

	/**
	 * Unique identifier for User
	 */
	int usr_id;

	/**
	 * First name of the User
	 */
	String usr_firstname;
	
	/**
	 * Last name of the User
	 */
	String usr_lastname;
	
	/**
	 * User's birthdate
	 */
	Date usr_birthdate;
	
	/**
	 * User's email
	 */
	String usr_email;
	
	/**
	 * User's login
	 */
	String usr_login;
	
	/**
	 * User's password
	 */
	String usr_password;
	
	/**
	 * True if the User is deleted
	 */
	boolean usr_is_deleted;
	
	/**
	 * True if the user is an admin
	 */
	boolean usr_is_admin;
	
	/**
	 * User's creation date
	 */
	Date usr_date_creation;
	
	/**
	 * User's delete date
	 */
	Date usr_date_delete;
	
	/**
	 * True if the User set his own password string
	 */
	boolean usr_is_password_confirmed;
	
	/**
	 * Construct an User from a datastore entity user
	 * 
	 * @param usr
	 */
	public User(Entity usr) {
		this.usr_birthdate 				= (Date)usr.getProperty("usr_bithdate");
		this.usr_date_creation 			= (Date)usr.getProperty("usr_date_creation");
		this.usr_date_delete 			= (Date)usr.getProperty("usr_date_delete");
		this.usr_email 					= (String)usr.getProperty("usr_email");
		this.usr_firstname 				= (String)usr.getProperty("usr_firstname");
		this.usr_lastname 				= (String)usr.getProperty("usr_lastname");
		this.usr_id 					= (Integer)usr.getProperty("usr_id");
		this.usr_is_admin 				= (Boolean)usr.getProperty("usr_is_admin");
		this.usr_is_deleted 			= (Boolean)usr.getProperty("usr_is_delete");
		this.usr_is_password_confirmed 	= (Boolean)usr.getProperty("usr_is_password_confirmed");
		this.usr_login 					= (String)usr.getProperty("usr_login");
		this.usr_password 				= (String)usr.getProperty("usr_password");
	}
	
	/**
	 * Return the User model as a User datastore entity model
	 * @return
	 */
	public Entity toDatastoreEntity() {
		
		Entity user = new Entity("User", this.usr_id);
		user.setProperty("usr_id", this.usr_id);
		user.setProperty("usr_birthdate", this.usr_birthdate);
		user.setProperty("usr_date_creation", this.usr_date_creation);
		user.setProperty("usr_date_delete", this.usr_date_delete);
		user.setProperty("usr_email", this.usr_email);
		user.setProperty("usr_firstname", this.usr_firstname);
		user.setProperty("usr_lastname", this.usr_lastname);
		user.setProperty("usr_is_admin", this.usr_is_admin);
		user.setProperty("usr_is_deleted", this.usr_is_deleted);
		user.setProperty("usr_is_password_confirmed", this.usr_is_password_confirmed);
		user.setProperty("usr_login", this.usr_login);
		user.setProperty("usr_password", this.usr_password);
		
		return user;
	}

	/**
	 * @return the usr_id
	 */
	public int getUsr_id() {
		return usr_id;
	}

	/**
	 * @param usr_id the usr_id to set
	 */
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	/**
	 * @return the usr_firstname
	 */
	public String getUsr_firstname() {
		return usr_firstname;
	}

	/**
	 * @param usr_firstname the usr_firstname to set
	 */
	public void setUsr_firstname(String usr_firstname) {
		this.usr_firstname = usr_firstname;
	}

	/**
	 * @return the usr_lastname
	 */
	public String getUsr_lastname() {
		return usr_lastname;
	}

	/**
	 * @param usr_lastname the usr_lastname to set
	 */
	public void setUsr_lastname(String usr_lastname) {
		this.usr_lastname = usr_lastname;
	}

	/**
	 * @return the usr_birthdate
	 */
	public Date getUsr_birthdate() {
		return usr_birthdate;
	}

	/**
	 * @param usr_birthdate the usr_birthdate to set
	 */
	public void setUsr_birthdate(Date usr_birthdate) {
		this.usr_birthdate = usr_birthdate;
	}

	/**
	 * @return the usr_email
	 */
	public String getUsr_email() {
		return usr_email;
	}

	/**
	 * @param usr_email the usr_email to set
	 */
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}

	/**
	 * @return the usr_login
	 */
	public String getUsr_login() {
		return usr_login;
	}

	/**
	 * @param usr_login the usr_login to set
	 */
	public void setUsr_login(String usr_login) {
		this.usr_login = usr_login;
	}

	/**
	 * @return the usr_password
	 */
	public String getUsr_password() {
		return usr_password;
	}

	/**
	 * @param usr_password the usr_password to set
	 */
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}

	/**
	 * @return the usr_is_deleted
	 */
	public boolean isUsr_is_deleted() {
		return usr_is_deleted;
	}

	/**
	 * @param usr_is_deleted the usr_is_deleted to set
	 */
	public void setUsr_is_deleted(boolean usr_is_deleted) {
		this.usr_is_deleted = usr_is_deleted;
	}

	/**
	 * @return the usr_is_admin
	 */
	public boolean isUsr_is_admin() {
		return usr_is_admin;
	}

	/**
	 * @param usr_is_admin the usr_is_admin to set
	 */
	public void setUsr_is_admin(boolean usr_is_admin) {
		this.usr_is_admin = usr_is_admin;
	}

	/**
	 * @return the usr_date_creation
	 */
	public Date getUsr_date_creation() {
		return usr_date_creation;
	}

	/**
	 * @param usr_date_creation the usr_date_creation to set
	 */
	public void setUsr_date_creation(Date usr_date_creation) {
		this.usr_date_creation = usr_date_creation;
	}

	/**
	 * @return the usr_date_delete
	 */
	public Date getUsr_date_delete() {
		return usr_date_delete;
	}

	/**
	 * @param usr_date_delete the usr_date_delete to set
	 */
	public void setUsr_date_delete(Date usr_date_delete) {
		this.usr_date_delete = usr_date_delete;
	}

	/**
	 * @return the usr_is_password_confirmed
	 */
	public boolean isUsr_is_password_confirmed() {
		return usr_is_password_confirmed;
	}

	/**
	 * @param usr_is_password_confirmed the usr_is_password_confirmed to set
	 */
	public void setUsr_is_password_confirmed(boolean usr_is_password_confirmed) {
		this.usr_is_password_confirmed = usr_is_password_confirmed;
	}
}
