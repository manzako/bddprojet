package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

public class Noms {
	
	private Connection connexion;
	public List<Utilisateur> recupererUtilisateurs(){
		List<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
		
		//chargement de driver
		
		loadDatabase();
		
		//Connexion à la base de données
		Statement statement=null;
		ResultSet resultat=null;
		
		try{
			
			
			
			statement=connexion.createStatement();
			 
			//execution de la requete
			
			resultat=statement.executeQuery("SELECT LOGIN, PWD FROM COMPTE;");
			
			//RÉCUPERATION DES DONNÉES
			
			while(resultat.next()){
				String login=resultat.getString("LOGIN");
				String pwd=resultat.getString("PWD");
				
				Utilisateur utilisateur =new Utilisateur();
				utilisateur.setLogin(login);
				utilisateur.setPwd(pwd);
				
				utilisateurs.add(utilisateur);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			//fermeture de la connexion
			
			try{
				if(resultat != null){
					resultat.close();
				}
				
				if(statement != null){
					statement.close();
				}
				
				if(connexion != null){
					connexion.close();
				}
			}
			catch(SQLException ignore){
				ignore.printStackTrace();
				
			}
		}
		
		return utilisateurs;
		
	}
	
	private void loadDatabase(){
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/stage1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","mangombe","1234");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur){
		
		loadDatabase();
		
		try{
			PreparedStatement preparedStatement=connexion.prepareStatement("INSERT INTO COMPTE(LOGIN,PWD) VALUES (?,?);");
			preparedStatement.setString(1, utilisateur.getLogin());
			preparedStatement.setString(2, utilisateur.getPwd());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		
	}


