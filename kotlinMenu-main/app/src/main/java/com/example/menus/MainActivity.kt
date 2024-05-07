package com.example.menus

import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    /*private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.menu_ui_elements_actions, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.item_edit -> {
                    Toast.makeText(this@MainActivity, "Edit", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    true
                }

                R.id.item_delete -> {
                    Toast.makeText(this@MainActivity, "Delete", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    true
                }

                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }
    var actionMode:ActionMode? = TODO()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var item1:TextView = findViewById(R.id.p1)
        val item2:TextView = findViewById(R.id.p2)
        var item3:TextView = findViewById(R.id.p3)
        registerForContextMenu(item1)
        registerForContextMenu(item2)
        //registerForContextMenu(item3)
        /*item2.setOnLongClickListener{view->
            when(actionMode){
                null->{
                    actionMode = this.startActionMode(actionModeCallback)
                    item2.isSelected = true
                    true
                }
                else->false
            }
        }*/
        item3.setOnClickListener{
            /*val popup = PopupMenu(this,it)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_popup, popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()*/
            showMenu(item3)
        }
    }

    fun showMenu(v:View){
        PopupMenu(this,v).apply {
            setOnMenuItemClickListener(this@MainActivity)
            inflate(R.menu.menu_popup)
            show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //val inflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_app_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemSettings->{
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
                //Log.d("Options menu","Settings picked")
                true}
            R.id.itemLogout->{
                Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show()
                //Log.d("Options menu" ,"Logout clicked")
            true}
            else->super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_ui_elements_actions,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_edit->{
                Toast.makeText(this,"Edit",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item_delete->{
                Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show()
                true
            }
            else->super.onContextItemSelected(item)
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item1->{
                Toast.makeText(this,"Opcion uno",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item2->{
                Toast.makeText(this,"Opcion dos",Toast.LENGTH_SHORT).show()
                true
            }
            else->false
        }
    }


}