package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Wizard;

public class WizardRepository {
	
	public List<Wizard> findAll() {

        try {
	        Connection connection = Database.getInstance().getConnection();
	        
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM wizard;"
            );
            ResultSet resultSet = statement.executeQuery();

            List<Wizard> wizards = new ArrayList<>();

            while (resultSet.next()) {
                wizards.add(new Wizard(resultSet));
            }
            return wizards;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public Wizard findById(int id) {
		return removeNull(findBy("id", id)).get(0);
	}
	
	public List<Wizard> removeNull(List<Wizard> list) {
		list.removeIf(w -> (w == null));
		return list;
	}
	
	public List<Wizard> findByLastName(String name) {
		return findBy("last_name", name);
	}
	
	public List<Wizard> findByFirstName(String name) {
		return findBy("first_name", name);
	}
	
	
	public <T> 	List<Wizard> findBy(String col, T val){
		try {	        
			List<Wizard> list = new ArrayList<>();
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM wizard WHERE "+ col + " LIKE ?;"
            );
            statement.setString(1,"%"+val.toString()+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
            	
             list.add(new Wizard(resultSet));
            }
            return list;
            
		} catch(SQLException e) {
            e.printStackTrace();
		}
		return null;
	}
	
	
}
