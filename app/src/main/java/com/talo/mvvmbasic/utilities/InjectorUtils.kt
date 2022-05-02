package com.talo.mvvmbasic.utilities

import com.talo.mvvmbasic.data.FakeDatabase
import com.talo.mvvmbasic.data.QuoteRepository
import com.talo.mvvmbasic.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}