package com.example.jsonparse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class JsonData extends ActionBarActivity {
	ArrayList arrayList;
	ListView listView;
	TextView textView1;
	Database database;
	
	String  assetsdata;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);


		setContentView(R.layout.json);
		
		listView=(ListView)findViewById(R.id.listView);
		database=new Database(this);
		
		String contact = null;
		try {
			InputStream stream = getAssets().open("hollywood_contact1.json");

			int size = stream.available();
			byte[] buffer = new byte[size];
			stream.read(buffer);
			stream.close();
			assetsdata = new String(buffer);
		} catch (IOException e) {
			// exceptions need to handle here
		}

		try
		{
			JSONObject jsonObject=new JSONObject(assetsdata);
			JSONArray jsonArray= jsonObject.getJSONArray("contacts");


			for(int i=0;i<jsonArray.length();i++)
			{

				JSONObject jsonObject1=jsonArray.getJSONObject(i);
				String Name=jsonObject1.getString("firstName").toString()+"  "+jsonObject1.getString("lastName").toString();
				
				String	 age=jsonObject1.getString("age").toString();
				
				JSONArray jsonArrayphno =jsonObject1.getJSONArray("phoneNumber");
				for(int k=0;k<jsonArrayphno.length();k++)
				{
					JSONObject jsonObject2=jsonArrayphno.getJSONObject(k);
					contact=jsonObject2.getString("type").toString()+jsonObject2.getString("number").toString();
					 
				}



				JSONObject jsonObject2=jsonObject1.getJSONObject("address");	
				String address=jsonObject2.getString("streetAddress").toString()+jsonObject2.getString("city").toString()+jsonObject2.getString("state").toString()+jsonObject2.getString("postalCode").toString();
				
				database.insertData(Name,age,address,contact);
			}
			arrayList=database.fetchData();
			ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,arrayList);
			listView.setAdapter(adapter);
			System.out.println(arrayList);
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
	}
}





