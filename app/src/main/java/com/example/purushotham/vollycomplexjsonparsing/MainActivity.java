package com.example.purushotham.vollycomplexjsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    TextView textView_result;
    String TAG=getClass().getSimpleName();
    String BASE_URL="https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesData.txt";
    List<Moviemodel> list;
    List<Moviemodel.cast> castList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        castList=new ArrayList<>();
        loadData();


    }

    private void loadData() {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, BASE_URL, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.d(TAG,response.toString());


                try
                {
                    Moviemodel moviemodel=new Moviemodel();
                    Moviemodel.cast cast=new Moviemodel.cast();


                    JSONArray jsonArray=response.getJSONArray("movies");


                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String movie_name=jsonObject.getString("movie");
                        String movie_duration=jsonObject.getString("duration");
                        String movie_director=jsonObject.getString("director");
                        String movie_tagline=jsonObject.getString("tagline");
                        String image=jsonObject.getString("image");
                        moviemodel.setMovie(movie_name);
                        moviemodel.setDuration(movie_duration);
                        moviemodel.setDirector(movie_director);
                        moviemodel.setTagline(movie_tagline);
                        moviemodel.setImage(image);
                        JSONArray castarry=jsonObject.getJSONArray("cast");
                        for (int j=0;j<castarry.length();j++)
                        {

                            cast.setName(castarry.getJSONObject(j).getString("name"));
                            castList.add(cast);

                        }

                        moviemodel.setCastArrayList(castList);
                        list.add(moviemodel);



                    }

                    MyAdapter myAdapter=new MyAdapter(list,MainActivity.this);
                    recyclerView.setAdapter(myAdapter);







                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                // JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(response)

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
