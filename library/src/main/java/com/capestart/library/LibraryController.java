package com.capestart.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class LibraryController {

	

	
	@Autowired
	LibraryService libraryservice;
	
	@RequestMapping(value="/addBooks",method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)
	{
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		ModelAndView modelAndView =  new ModelAndView("redirect:/AddBooks.jsp");
		//mav.setViewName("AddBooks.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addBookList",method=RequestMethod.POST)
	public void addBookList(@ModelAttribute LibraryModel libraryModel,String bookName,String bookPrice,String authorName,HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws IOException
	{
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		libraryModel.setAuthorName(authorName);
		libraryModel.setBookName(bookName);
		libraryModel.setBookPrice(bookPrice);
		libraryservice.addBookList(libraryModel);
		httpServletResponse.getOutputStream().print("success");
		
		
	}
	
	
	@RequestMapping(value="/searchAuthors",method=RequestMethod.POST)
	public void searchAuthors(@ModelAttribute LibraryModel libraryModel,String bookName,String bookPrice,String authorName,HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws IOException
	{
		
		List<Map<String, Object>> authorList = new LinkedList<Map<String,Object>>();
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		libraryModel.setAuthorName(authorName);
		libraryModel.setBookName(bookName);
		libraryModel.setBookPrice(bookPrice);
		authorList=	libraryservice.searchAuthors(libraryModel);
		
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();

		for(Map<String, Object> data : authorList) {
		    JSONObject obj = new JSONObject(data);
		    jsonObj.add(obj);
		}

		JSONArray test = new JSONArray(jsonObj);

		httpServletResponse.getOutputStream().print(test.toString());
		//ModelAndView modelAndView =  new ModelAndView("redirect:/AddBooks.jsp");
		//mav.setViewName("AddBooks.jsp");
		
	}
	
	
	@RequestMapping(value="/showFullDetails",method=RequestMethod.POST)
	public void showFullDetails(@ModelAttribute LibraryModel libraryModel,String authorName,HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws IOException
	{
		
		List<Map<String, Object>> authorList = new LinkedList<Map<String,Object>>();
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		libraryModel.setAuthorName(authorName);
		
		authorList=	libraryservice.showFullDetails(libraryModel);
		
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();

		for(Map<String, Object> data : authorList) {
		    JSONObject obj = new JSONObject(data);
		    jsonObj.add(obj);
		}

		JSONArray test = new JSONArray(jsonObj);

		httpServletResponse.getOutputStream().print(test.toString());
		//ModelAndView modelAndView =  new ModelAndView("redirect:/AddBooks.jsp");
		//mav.setViewName("AddBooks.jsp");
		
	}
	
	
	@RequestMapping(value="/editBook",method=RequestMethod.POST)
	public ModelAndView updateBook(@ModelAttribute LibraryModel libraryModel,String bookName,String bookPrice,String authorName,HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)
	{
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		libraryModel.setAuthorName(authorName);
		libraryModel.setBookName(bookName);
		libraryModel.setBookPrice(bookPrice);
		libraryservice.editBook(libraryModel);
		
		
		ModelAndView modelAndView =  new ModelAndView("redirect:/AddBooks.jsp");
		//mav.setViewName("AddBooks.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteBook",method=RequestMethod.POST)
	public ModelAndView deleteBook(@ModelAttribute LibraryModel libraryModel,String bookName,String bookPrice,String authorName,HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)
	{
		//ModelAndView mav= new ModelAndView();
		System.out.println("welcome");
		libraryModel.setAuthorName(authorName);
		libraryModel.setBookName(bookName);
		libraryModel.setBookPrice(bookPrice);
		libraryservice.deleteBook(libraryModel);
		
		
		ModelAndView modelAndView =  new ModelAndView("redirect:/AddBooks.jsp");
		//mav.setViewName("AddBooks.jsp");
		return modelAndView;
	}
	
	
	
}
