package uz.programmer710.expandablelis_info

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uz.programmer710.expandablelis_info.adapters.MyExpendAdapter

class MainActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, ArrayList<User>>
    lateinit var titleList: ArrayList<String>
    lateinit var myExpendAdapter: MyExpendAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        myExpendAdapter = MyExpendAdapter(this,map, titleList)
        expand_view.setAdapter(myExpendAdapter)

        expand_view.setOnChildClickListener(object : ExpandableListView.OnChildClickListener{
            override fun onChildClick(
                parent: ExpandableListView?,
                v: View?,
                groupPosition: Int,
                childPosition: Int,
                id: Long
            ): Boolean {
                Toast.makeText(this@MainActivity, "${map[titleList[groupPosition]]?.get(childPosition)?.text.toString()}", Toast.LENGTH_SHORT).show()
                return false
            }
        })

    }

    private fun loadData() {

        map = HashMap()
        titleList = ArrayList()

        titleList.add("Fruits")
        val fruitsList = arrayListOf(
            User("Apple", R.drawable.olma),
            User("Orange", R.drawable.orange),
            User("Banana", R.drawable.banana)
        )

        titleList.add("Animals")
        val animalsList = arrayListOf(
            User("Panda", R.drawable.panda),
            User("Monkey", R.drawable.monkey),
            User("Cat", R.drawable.cat),
            User("Dog", R.drawable.dog)
        )

        titleList.add("Cars")
        val carsList = arrayListOf(
            User("Tesla", R.drawable.tesla),
            User("Mercedes Benz", R.drawable.mercedes),
            User("Bmw", R.drawable.bmw),
            User("Range Rover", R.drawable.range_rover)
        )
        
        map[titleList[0]] = fruitsList
        map[titleList[1]] = animalsList
        map[titleList[2]] = carsList

    }
}