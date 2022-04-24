package com.example.ezinvoicecustomer.ui.scan_invoices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezinvoicecustomer.databinding.FragmentScanInvoiceBinding;

public class ScanInvoicesFragment extends Fragment {

    private ScanInvoicesViewModel scanInvoicesViewModel;
    private FragmentScanInvoiceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scanInvoicesViewModel =
                new ViewModelProvider(this).get(ScanInvoicesViewModel.class);

        binding = FragmentScanInvoiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
        scanInvoicesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}