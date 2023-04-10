package com.geminiboy.localpersistence

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geminiboy.localpersistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("dataprefs", Context.MODE_PRIVATE)
        saveData()
        viewData()
        clearData()
    }

    fun saveData(){
        binding.btnsave.setOnClickListener {
            val name = binding.etName.text.toString()
            val id = binding.etId.text.toString()
            val save = sharedPref.edit()
            save.putString("nameuser", name)
            save.putString("iduser", id)
            save.apply()
            Toast.makeText(this, "Behasil Simpan Data", Toast.LENGTH_LONG).show()
        }
    }

    fun viewData(){
        binding.btnView.setOnClickListener {
            val getNama = sharedPref.getString("nameuser","")
            val getId = sharedPref.getString("iduser","")

            binding.tvId.text = getId
            binding.tvName.text = getNama
        }

    }

    fun clearData(){
        binding.btnClear.setOnClickListener {
            val hapus = sharedPref.edit()
            hapus.clear()
            hapus.apply()
            binding.tvId.setText("")
            binding.tvId.setText("")
            Toast.makeText(this, "Data Berhasil Di Hapus", Toast.LENGTH_LONG).show()
        }
    }

}