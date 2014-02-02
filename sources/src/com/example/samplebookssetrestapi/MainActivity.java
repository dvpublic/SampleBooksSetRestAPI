package com.example.samplebookssetrestapi;

import org.apache.http.protocol.HTTP;

import com.example.samplebookssetrestapi.data.Book;
import com.example.samplebookssetrestapi.data.ListBooks;
import com.example.samplebookssetrestapi.utils.Common;
import com.squareup.mimecraft.FormEncoding;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.HttpEngine;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.client.Response;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String LOG_TAG = "com.example.samplebookssetrestapi"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		test_retrofit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void test_retrofit() {
		new Thread(new Runnable() {			
			@SuppressWarnings("unused")
			@Override
			public void run() {
				try {
					OkHttpClient okHttpClient = new OkHttpClient();				
					
					RestAdapter restAdapter = new RestAdapter.Builder()
			    		.setServer("http://samplebookssetrestapi.apiary.io")
			    		.setClient(new OkClient(okHttpClient))
			    		.build();

					IBookSetRestAPI rest_api = restAdapter.create(IBookSetRestAPI.class);
				//try row requests
					Response book_response = rest_api.getBookRow(136);
					String book_response_body = Common.convertStreamToString(book_response.getBody().in(), HTTP.UTF_8);
					
					Response books_response = rest_api.getBooksRow();
					String books_response_body = Common.convertStreamToString(books_response.getBody().in(), HTTP.UTF_8);
					
				//try json conversion
					Book book = rest_api.getBook(136);
					ListBooks list = rest_api.getBooks();
					ListBooks list2 = rest_api.getBooks(2, 3);
					
				} catch (Exception ex) {
					Log.d(LOG_TAG, ex.toString());
				}
			}
		}).start();			
	}

}
