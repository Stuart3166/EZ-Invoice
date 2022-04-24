package com.example.ezinvoicecustomer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.integration.android.IntentIntegrator;

public class ScanInvoiceFragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private FirebaseAuth auth;
    private TextView lblScanInvoice, businessName, email, phoneNumber, details, price, paidStatus;
    private TableLayout displayInvoiceDetails;

    public static ScanInvoiceFragment newInstance() {
        return new ScanInvoiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scan_invoice, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button scanqrcode = getView().findViewById(R.id.btnscanqrcode);
//        displayInvoiceDetails = getView().findViewById(R.id.invoiceDetails);
//        scanqrcode.setOnClickListener(this);
        scanqrcode.setOnClickListener(scanview -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
            intentIntegrator.setPrompt("Scan a QR Code");
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.initiateScan();
        });
//        auth = FirebaseAuth.getInstance();
//        FirebaseUser user = auth.getCurrentUser();
//
//        businessName = getView().findViewById(R.id.businessName);
//        email = getView().findViewById(R.id.email);
//        phoneNumber = getView().findViewById(R.id.phoneNumber);
//        details = getView().findViewById(R.id.details);
//        price = getView().findViewById(R.id.price);
//        paidStatus = getView().findViewById(R.id.paidStatus);
//        lblScanInvoice = getView().findViewById(R.id.lblScanInvoice);
//
//        businessName.setText(user.getDisplayName());
//        email.setText(user.getEmail());
//        phoneNumber.setText(user.getPhoneNumber());
//        details.setText(user.getDisplayName());
//        price.setText(user.getDisplayName());
//        paidStatus.setText(user.getDisplayName());
    }

    public interface OnFragmentInteractionListener {

    }
//    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    Intent data = result.getData();
////                    IntentResult intentResult = IntentIntegrator.parseActivityResult(data);
//
//                    if (result != null) {
//                        if (data == null) {
//                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            displayInvoiceDetails = getView().findViewById(R.id.lblScanInvoice);
////                            displayInvoiceDetails.setText(intentResult.getContents());
//                            displayInvoiceDetails.setVisibility(View.VISIBLE);
//                        }
//                    }
//                    if (intentResult != null) {
//                        if (intentResult.getContents() == null) {
//                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            displayInvoiceDetails = getView().findViewById(R.id.lblScanInvoice);
////                            displayInvoiceDetails.setText(intentResult.getContents());
//                            displayInvoiceDetails.setVisibility(View.VISIBLE);
//                        }
//                    }

//                    else {
//                        super.onActivityResult(requestCode, resultCode, data);
//                    }
}

//                }
//
//                @Override
//                protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//                    super.onActivityResult(requestCode, resultCode, data);
//                    IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//
//                    if (intentResult != null) {
//                        if (intentResult.getContents() == null) {
//                            Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
//                        } else {
//                            displayInvoiceDetails = findViewById(R.id.lblScanInvoice);
//                            displayInvoiceDetails.setText(intentResult.getContents());
//                            displayInvoiceDetails.setVisibility(View.VISIBLE);
//                        }
//                    } else {
//                        super.onActivityResult(requestCode, resultCode, data);
//                    }
//                }
//            });
//
//    public void openSomeActivityForResult() {
//        Intent intent = new Intent(this, SomeActivity.class);
//        someActivityResultLauncher.launch(intent);
//    }

//}