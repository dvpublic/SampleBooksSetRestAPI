package com.example.samplebookssetrestapi;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.PATCH;
import retrofit.http.Path;
import retrofit.http.Query;

import com.example.samplebookssetrestapi.data.Book;
import com.example.samplebookssetrestapi.data.ListBooks;

public interface IBookSetRestAPI {
	@Headers("Accept-Encoding: gzip")
	@GET("/v1/books")
	ListBooks getBooks();
	
	@GET("/v1/books")
	Response getBooksRow();
	
	@GET("/v1/books")
	ListBooks getBooks(@Query("limit") int limit);
	
	@GET("/v1/books")
	ListBooks getBooks(@Query("limit") int limit, @Query("offset") int offset);
	
	@GET("/v1/books/{book_id}")
	Book getBook(@Path("book_id") int book_id);
	
	@GET("/v1/books/{book_id}")
	Response getBookRow(@Path("book_id") int book_id);			
}
