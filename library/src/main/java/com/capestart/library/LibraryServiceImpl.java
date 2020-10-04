package com.capestart.library;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService{
	@Autowired
	LibraryDao librarydao;

	public int addBookList(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		return librarydao.addBookList(librarymodel);
	}

	public List<Map<String, Object>> searchAuthors(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		return librarydao.searchAuthors(librarymodel);
	}

	public List<Map<String, Object>> showFullDetails(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		return librarydao.showFullDetails(librarymodel);
	}

	public int editBook(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		return librarydao.editBook(librarymodel);
	}

	public int deleteBook(LibraryModel librarymodel) {
		// TODO Auto-generated method stub
		return librarydao.deleteBook(librarymodel);
	}

}
