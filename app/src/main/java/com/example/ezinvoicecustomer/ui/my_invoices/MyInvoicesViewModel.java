package com.example.ezinvoicecustomer.ui.my_invoices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyInvoicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyInvoicesViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}