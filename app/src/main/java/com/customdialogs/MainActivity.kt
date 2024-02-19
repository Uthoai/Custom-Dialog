package com.customdialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.customdialogs.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SnackBar
        binding.btnSnackBar.setOnClickListener {view->
            Snackbar.make(view,"You have clicked SnackBar Button",Snackbar.LENGTH_LONG).show()
        }
        //Alert Dialog
        binding.btnAlertDialog.setOnClickListener {
            alertDialogFunction()
        }
        //Custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            customDialogFunction()
        }
        //Custom Progress Dialog
        binding.btnCustomProgressDialog.setOnClickListener {
            customProgressDialogFunction()
        }

    }

    private fun customProgressDialogFunction() {
        val customProgressDialog = Dialog(this)
        //set the screen content from a layout resource.
        //the resource will be inflated, adding all top-level views to the screen.
        customProgressDialog.setContentView(R.layout.custom_progress_dialog)
        customProgressDialog.show()
    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        //set the screen content from a layout resource.
        //the resource will be inflated, adding all top-level views to the screen.
        customDialog.setContentView(R.layout.custom_dialog)

        customDialog.show()
    }

    private fun alertDialogFunction() {
        // use the builder class for convenient dialog construction
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Alert")
        //set message for alert dialog
        builder.setMessage("This is Alert Dialog.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){ dialogInterface, which->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        //performing cancel acton
        builder.setNeutralButton("Cancel"){ dialogInterface, which->
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        //performing negative action
        builder.setNegativeButton("No"){ dialogInterface, which->
            Toast.makeText(applicationContext, "clicked no", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        //set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}

