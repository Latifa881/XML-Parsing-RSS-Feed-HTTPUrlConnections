package com.example.xmlparsingrssfeedhttpurlconnections


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val BASE_URL = "https://www.floretflowers.com/"
    lateinit var rvMain: RecyclerView
    val details = ArrayList<myDetails>()
    var call:Call<RSS?>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMain = findViewById(R.id.rvMain)
        rvMain.adapter = RecyclerViewAdapter(details)
        rvMain.layoutManager = LinearLayoutManager(this@MainActivity)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val rssAPI = retrofit.create(RSSAPI::class.java)
        call = rssAPI.rssFloreFlowers
       callApi(call!!)

    }

    fun callApi(call: Call<RSS?>) {
        call!!.clone().enqueue(object : Callback<RSS?> {
            override fun onResponse(call: Call<RSS?>, response: Response<RSS?>) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString())
                Log.d(TAG, "onResponse: Server Response:")
                val items = response.body()!!.channels!!.items
                for (item in items!!) {
                    //Toast.makeText(this@MainActivity,item.title,Toast.LENGTH_SHORT).show()
                    val title=item.title.toString()
                    val description=(Html.fromHtml(Html.fromHtml(item.description.toString()).toString())).toString()
                    val link=item.link.toString()
                   details.add(myDetails(title,description,link))
                    rvMain.adapter!!.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<RSS?>, t: Throwable) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
    return true}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.getItemId()==R.id.refresh){
            callApi(call!!)

        }
        return super.onOptionsItemSelected(item)
    }
}

