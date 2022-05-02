package com.talo.mvvmbasic.ui.quotes

import androidx.lifecycle.ViewModel
import com.talo.mvvmbasic.data.Quote
import com.talo.mvvmbasic.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}