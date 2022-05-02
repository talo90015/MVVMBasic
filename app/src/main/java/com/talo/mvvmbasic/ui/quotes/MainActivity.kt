package com.talo.mvvmbasic.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.talo.mvvmbasic.R
import com.talo.mvvmbasic.data.Quote
import com.talo.mvvmbasic.databinding.ActivityMainBinding
import com.talo.mvvmbasic.utilities.InjectorUtils
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.txt.text = stringBuilder.toString()
        })
        binding.btnAdd.setOnClickListener {
            val quote = Quote(binding.editQuote.text.toString(), binding.editAnthor.text.toString())
            viewModel.addQuote(quote)
            binding.editQuote.setText("")
            binding.editAnthor.setText("")
        }
    }
}