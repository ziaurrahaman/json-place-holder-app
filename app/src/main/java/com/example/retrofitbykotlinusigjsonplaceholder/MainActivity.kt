package com.example.retrofitbykotlinusigjsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitbykotlinusigjsonplaceholder.adapter.MainActivityRecyclerViewAdapter

import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.PostsDataModel
import com.example.retrofitbykotlinusigjsonplaceholder.dataModel.UsersDataModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity()  {
//    private lateinit var users: List<UsersDataModel>
//    private lateinit var posts: List<PostsDataModel>


    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



            val placeHolderService = retrofit.create(PlaceHolderInterface::class.java)
            val postCall = placeHolderService.getUserPosts()
            postCall.enqueue(object : Callback<List<PostsDataModel>> {
                override fun onFailure(call: Call<List<PostsDataModel>>, t: Throwable) {
                    Log.d("ErrorMessage", t.message.toString())
                    Log.d("error", "Failed")
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<PostsDataModel>>,
                    response: Response<List<PostsDataModel>>
                ) {
                    val posts = if (response.isSuccessful) response.body()!! else emptyList()
                    setRecyclerViewWithTwoList(posts)
                }
            })








    }


    fun setRecyclerViewWithTwoList(potsFromFirstCall: List<PostsDataModel>){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val placeHolderService = retrofit.create(PlaceHolderInterface::class.java)
        val userCall = placeHolderService.getUserProfile()
        userCall.enqueue(object : Callback<List<UsersDataModel>> {
            override fun onFailure(call: Call<List<UsersDataModel>>, t: Throwable) {
                Log.d("ErrorMessage", t.message.toString())
                Log.d("error", "Failed")

                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<UsersDataModel>>,
                response: Response<List<UsersDataModel>>
            ) {
               val users = if (response.isSuccessful) response.body()!! else emptyList()
                Log.d("MAIN", potsFromFirstCall.toString())
                Log.d("MAIN", users.toString())

                main_activity_recycler_view.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    RecyclerView.VERTICAL, false
                )
                val adapter = MainActivityRecyclerViewAdapter(potsFromFirstCall, users)
                main_activity_recycler_view.adapter = adapter
                Log.d("posts",potsFromFirstCall.toString() )
                Log.d("users",users.toString() )
            }
        })

    }
}
