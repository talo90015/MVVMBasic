package com.talo.mvvmbasic.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.talo.mvvmbasic.data.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  QuotesViewModel(quoteRepository) as T
    }
}