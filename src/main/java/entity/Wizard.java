package entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wizard {

    private int id;
    private String firstName;
    private String lastName;
	private Date birthday;
	private String birthPlace;
	private String biography;
	private boolean muggle;

    public Wizard(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public Wizard(ResultSet resultSet) throws SQLException{
		this.id = resultSet.getInt("id");
		this.firstName = resultSet.getString("first_name");
		this.lastName = resultSet.getString("last_name");
		this.birthday = resultSet.getDate("birthday");
		this.birthPlace = resultSet.getString("birth_place");
		this.biography = resultSet.getString("biography");
		this.muggle = resultSet.getBoolean("is_muggle");
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) { 
	       return true; 
	    } 
		   
		if (!(o instanceof Wizard)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Wizard c = (Wizard) o; 
          
        // Compare the data members and return accordingly  
        return this.id == c.id;
	}
	
	public Wizard() {
		// TODO Auto-generated constructor stub
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public boolean isMuggle() {
		return muggle;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public void setMuggle(boolean muggle) {
		this.muggle = muggle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}    
}