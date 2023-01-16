package com.example.artbookify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artbookify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private  lateinit var dataList : ArrayList<DataModel>;
    private lateinit var dataAdapter: DataAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);

        binding.recyclerView.layoutManager=LinearLayoutManager(this);

        fetchData();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater;
        menuInflater.inflate(R.menu.art_menu,menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.add_art_item_menu){
            val intent = Intent(this@MainActivity,DetailsActivity::class.java);
            intent.putExtra("info","new");
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item)
    }
    private fun fetchData(){
        try {
            dataList = ArrayList<DataModel>();
            dataAdapter=DataAdapter(dataList);
            val db = this.openOrCreateDatabase("Arts", MODE_PRIVATE,null);
            val cursor = db.rawQuery("SELECT * FROM arts",null);
            val artNameIx = cursor.getColumnIndex("artname");
            val idIx=cursor.getColumnIndex("id");
            while(cursor.moveToNext()){
                val name = cursor.getString(artNameIx);
                val id = cursor.getInt(idIx);
                val data = DataModel(name,id);
                dataList.add(data);
            }

            dataAdapter.notifyDataSetChanged();
            binding.recyclerView.adapter=dataAdapter;
            cursor.close();
        }
        catch(e:Exception){
            e.printStackTrace();
        }
    }
}