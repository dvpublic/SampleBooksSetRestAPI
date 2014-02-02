package com.example.samplebookssetrestapi.data;

import java.util.List;

/**
{
    "books": [
        {
            "book" : { 
                "id":"1234", 
                "title": "Война и мир", 
                "author": "Л.Н. Толстой", 
                "released": "1868"
            }
        }, 
        {
            "book" : { 
                "id":"1235", 
                "title":"Господин Ау", 
                "author": "Э. Успенский",  
                "released" : "1980"
            }
        }
    ]
    , "_metadata" : [
        {
            "totalCount":250,
            "limit":10,
            "offset":20
        }
    ] 
    , "_links" : [
        {
            "rel": "next",
            "href": "/v1/books?offset=30&limit=10"
        }, 
        {
            "rel": "prev",
            "href": "/v1/books?offset=10"
        }, 
        {
            "rel": "first",
            "href": "/v1/books?offset=0"
        }, 
        {
            "rel": "last",
            "href": "/v1/books?offset=240"
        } 
    ] 
}
*/
public class ListBooks {
	public List<ListBooksBook> books;
	public List<ListBooksMetadata> _metadata;
	public List<ListBooksLink> _links;
	
	public static class ListBooksBook {
		public Book book;
	}
	
	public static class ListBooksMetadata {
		public int totalCount;
		public int limit;
		public int offset;
	}
	
	public static class ListBooksLink {
		public String rel;
		public String href;
	}
}
