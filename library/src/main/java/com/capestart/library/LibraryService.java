package com.capestart.library;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LibraryService {

	
	public int addBookList(LibraryModel librarymodel);
	
	public int editBook(LibraryModel librarymodel);
	
	public int deleteBook(LibraryModel librarymodel);

	
	public List<Map<String,Object>> searchAuthors(LibraryModel librarymodel);
	
	public List<Map<String,Object>> showFullDetails(LibraryModel librarymodel);
	
}
