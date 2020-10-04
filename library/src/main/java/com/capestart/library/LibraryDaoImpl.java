package com.capestart.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDaoImpl implements LibraryDao{

	/*
	 * @Autowired JdbcTemplate jdbctemplate;
	 */
	public int addBookList(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		try
		{
			
			
			DriverManagerDataSource dmd = new DriverManagerDataSource();
			dmd.setDriverClassName("com.mysql.jdbc.Driver");
			dmd.setUrl("jdbc:mysql://localhost:3306/Kindle");
			dmd.setUsername("austin");
			dmd.setPassword("austin");
			
			JdbcTemplate jdbc = new JdbcTemplate(dmd);
			//LocalDate d=java.time.LocalDate.now();
			String sql="insert into Books(AuthorName,Book_id,Bookname,BookPrice,Created_Date)values(?,?,?,?,?)";
			int bookPrice=Integer.parseInt(librarymodel.getBookPrice());
			int result=jdbc.update(sql,librarymodel.getAuthorName(),1,librarymodel.getBookName(),bookPrice,java.time.LocalDate.now());
			
			return result;
			
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); Connection
			 * con=DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/Kindle","austin","austin"); //here sonoo is
			 * database name, root is username and password Statement
			 * stmt=con.createStatement(); ResultSet
			 * rs=stmt.executeQuery("select AuthorName,BookName from Books");
			 * 
			 * while(rs.next()) System.out.println(rs.getString(1)+"  "+rs.getString(2));
			 * con.close();
			 */
		
		}
		catch(Exception e)
		{
		return 0;	
		}
		
	}

	public List<Map<String, Object>> searchAuthors(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> authorList = new LinkedList<Map<String,Object>>();
		
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3306/Kindle");
		dmd.setUsername("austin");
		dmd.setPassword("austin");
		
		JdbcTemplate jdbc = new JdbcTemplate(dmd);
		
		String sql="select AuthorName ,count(BookName) as BookCount from Books group by AuthorName";
		
		authorList=jdbc.queryForList(sql);
		
		
		return authorList;
	}

	public List<Map<String, Object>> showFullDetails(LibraryModel librarymodel) {
List<Map<String, Object>> authorList = new LinkedList<Map<String,Object>>();
		
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3306/Kindle");
		dmd.setUsername("austin");
		dmd.setPassword("austin");
		
		JdbcTemplate jdbc = new JdbcTemplate(dmd);
		
		String sql="select AuthorName,BookName ,BookPrice ,Created_Date from Books where AuthorName="+"'"+librarymodel.getAuthorName()+"'";
		
		authorList=jdbc.queryForList(sql);
		
		
		return authorList;
	}

	public int editBook(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
try
{
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3306/Kindle");
		dmd.setUsername("austin");
		dmd.setPassword("austin");
		
		JdbcTemplate jdbc = new JdbcTemplate(dmd);
		
		String sql="update Books set BookPrice="+"'"+librarymodel.getBookPrice()+"' where BookName="+"'"+librarymodel.getBookName()+"'";
		//int bookPrice=Integer.parseInt(librarymodel.getBookPrice());
		int result=jdbc.update(sql);
		
		return result;
		
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/Kindle","austin","austin"); //here sonoo is
		 * database name, root is username and password Statement
		 * stmt=con.createStatement(); ResultSet
		 * rs=stmt.executeQuery("select AuthorName,BookName from Books");
		 * 
		 * while(rs.next()) System.out.println(rs.getString(1)+"  "+rs.getString(2));
		 * con.close();
		 */
	
	}
	catch(Exception e)
	{
	return 0;	
	}
	
}

	public int deleteBook(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		try
		{
			
			
			DriverManagerDataSource dmd = new DriverManagerDataSource();
			dmd.setDriverClassName("com.mysql.jdbc.Driver");
			dmd.setUrl("jdbc:mysql://localhost:3306/Kindle");
			dmd.setUsername("austin");
			dmd.setPassword("austin");
			
			JdbcTemplate jdbc = new JdbcTemplate(dmd);
			
			String sql="delete from  Books where BookName="+"'"+librarymodel.getBookName()+"'";
		//	int bookPrice=Integer.parseInt(librarymodel.getBookPrice());
			int result=jdbc.update(sql);
			
			return result;
			
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); Connection
			 * con=DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/Kindle","austin","austin"); //here sonoo is
			 * database name, root is username and password Statement
			 * stmt=con.createStatement(); ResultSet
			 * rs=stmt.executeQuery("select AuthorName,BookName from Books");
			 * 
			 * while(rs.next()) System.out.println(rs.getString(1)+"  "+rs.getString(2));
			 * con.close();
			 */
		
		}
		catch(Exception e)
		{
		return 0;	
		}
	}

}
