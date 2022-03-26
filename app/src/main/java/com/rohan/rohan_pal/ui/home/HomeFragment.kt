package com.rohan.rohan_pal.ui.home

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.rohan.rohan_pal.HomeRecyclerAdapter
import com.rohan.rohan_pal.R
import com.rohan.rohan_pal.database.ProjectDatabase
import com.rohan.rohan_pal.database.ProjectList
import com.rohan.rohan_pal.database.TheProject
import com.rohan.rohan_pal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var btn: Button
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    var idListhome = listOf<TheProject>()
    lateinit var theProject: TheProject

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = root.findViewById(R.id.recyclerView)
        idListhome = RetriveFavourites(activity as Context)
        //******************************recyclerView.adapter = HomeRecyclerAdapter
        btn = root.findViewById(R.id.btn_btn)

        btn.setOnClickListener {
            val async = DBAsyncTask(activity as Context, theProject, 1).execute()


        }



        return root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class DBAsyncTask(val context: Context, val theProject: TheProject, val mode: Int) :
        AsyncTask<Void, Void, Boolean>() {

        val db = Room.databaseBuilder(context, ProjectDatabase::class.java, "yes_thats_me").build()

        override fun doInBackground(vararg p0: Void?): Boolean {
            when (mode) {
                1 -> {
                    db.projectDao().insertEntry(theProject)
                    db.close()
                    return true
                }
            }

            return false
        }

    }
 class RetriveFavourites(val context: Context) : AsyncTask<Void, Void, List<TheProject>>() {
     override fun doInBackground(vararg p0: Void?): List<TheProject> {
         val db = Room.databaseBuilder(context, ProjectDatabase::class.java, "yes_thats_me").build()
         return db.projectDao().getAllIds()
     }
 }


}