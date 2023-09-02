package com.osttra.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osttra.to.User;
import com.osttra.utils.DButils;

@Repository
public class UserRepository {
	public void add(User user) {
		try {
		Connection connection = DButils.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?,?,?)");
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getCompleteName());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getRole());
		statement.setString(6, "0");
		statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User getUser(String username,String password) {
		User user=null;
		try {
			Connection connection =DButils.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from user where username = ? and password=? and status=?");
			statement.setString(1,username);
			statement.setString(2, password);
			statement.setString(3, "1");
			ResultSet resultset =  statement.executeQuery();
			if(resultset.next()) {
				user = new User(username,password,resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6));
				System.out.println(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		try {
			Connection connection = DButils.getConnection();
			Statement stat = connection.createStatement();
			ResultSet resultset = stat.executeQuery("select * from user");
			while(resultset.next()) {
				User user = new User(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6));
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	public List<User> getStudents(){
		List<User> students=new ArrayList<>();
		try {
			Connection conn = DButils.getConnection();
			Statement stat = conn.createStatement();
			ResultSet resultset = stat.executeQuery("select * from user where role='student' and status='1'");
			while(resultset.next()) {
				User user = new User(resultset.getString(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6));
				students.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	public User getUser(String username) {

		User user = null;

		try {

			Connection connection = DButils.getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from user where username = ? and status='1'");

			statement.setString(1, username);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String password = resultSet.getString(2);
				String completeName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String role = resultSet.getString(5);
				String status = resultSet.getString(6);

				user = new User(username, password, completeName, email, role,status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	public void update(User user) {
		try {

			Connection connection = DButils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("update user set completeName = ?, email = ? where username = ?");

			statement.setString(1, user.getCompleteName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getUsername());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of update of UserRepository...");
			e.printStackTrace();
		}
	}
	public void delete(String username) {
		try {
			Connection connection = DButils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("delete from user where username = ?");
			statement.setString(1, username);
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void allow(String username) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DButils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("update user set status='1' where username = ?");

			statement.setString(1, username);

			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void block(String username) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DButils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("update user set status='0' where username = ?");

			statement.setString(1, username);

			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
