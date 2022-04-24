package com.example.ezinvoicecustomer.ui.scan_invoices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScanInvoicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ScanInvoicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}