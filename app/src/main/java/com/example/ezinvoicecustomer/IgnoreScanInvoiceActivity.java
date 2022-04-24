package com.example.ezinvoicecustomer;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ezinvoicecustomer.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class IgnoreScanInvoiceActivity extends AppCompatActivity {

    TableLayout displayInvoiceDetails;
    TextView businessName, email, description, price, paidStatus, dueDate, lblScanInvoice;
    Button btnscanqrcode, btnsaveInvoice;
    //    ArrayList lstSavedInvoices = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));
    BottomNavigationView navView;
    private ActivityMainBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_scan_invoice);
//        displayInvoiceDetails = findViewById(R.id.invoiceDetails);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        btnscanqrcode = findViewById(R.id.btnscanqrcode);
//        scanqrcode.setOnClickListener(this);
        btnscanqrcode.setOnClickListener(view -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(IgnoreScanInvoiceActivity.this);
            intentIntegrator.setPrompt("Scan a QR Code");
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.initiateScan();
        });

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

//        businessName = findViewById(R.id.businessName);
//        businessName.setText("22");


//        businessName = findViewById(R.id.businessName);
//        email = findViewById(R.id.email);
//        description = findViewById(R.id.description);
//        price = findViewById(R.id.price);
//        paidStatus = findViewById(R.id.paidStatus);
//
//        btnsaveInvoice = findViewById(R.id.btnsaveInvoice);
//        btnsaveInvoice.setOnClickListener(view -> {
//            Log.d("Cloud Firestore", "beginning write attempt");
//            Map<String, Object> newuser = new HashMap<>();
//            newuser.put("businessID", fullName);
//            newuser.put("description", fullName);
//            newuser.put("price", fullName);
//            newuser.put("paidStatus", fullName);
////            newuser.put("customerEmail", user.getEmail());
////                                String data = user.getDisplayName() + ", " + user.getEmail();
//            FirebaseFirestore db = FirebaseFirestore.getInstance();
////            db.collection("users").add(newuser)
////            db.collection("users").get();
//
//            // get current number of invoices then add one for newly saved invoices id
//            db.collection("invoices").document(user.getUid()).get();
//            db.collection("invoices").document(user.getUid()).update("","");
//            db.collection("invoices").document(user.getUid()).update("","");
//            db.collection("users").document(user.getUid()).update("2", "")
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("TAG", "Error adding document", e);
//                    }
//                });
//        });

//        setContentView(R.layout.fragment_my_invoices);
//        // get the reference of RecyclerView
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMyInvoice);
//        // set a LinearLayoutManager with default orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
//
//        //  call the constructor of CustomAdapterOld to send the reference and data to Adapter
//        CustomAdapterOld customAdapter = new CustomAdapterOld(IgnoreScanInvoiceActivity.this, lstSavedInvoices);
//        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    private void openFragment(Fragment fragment) {
        Log.d(TAG, "openFragment: ");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //this is a helper class that replaces the container with the fragment. You can replace or add fragments.
//        transaction.replace(R.id.nav_host_fragment_container, fragment);
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null); //if you add fragments it will be added to the backStack. If you replace the fragment it will add only the last fragment
        transaction.commit(); // commit() performs the action
    }

    public void navBarClicked() {
        navView = findViewById(R.id.nav_view);
        navView.setOnItemSelectedListener(item -> {
//                Fragment ScanInvoicePage = (Fragment) findViewById(R.layout.fragment_scan_invoice);
//                Fragment fragment = new tasks();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

//                androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
//                if (fm.findFragmentById(R.id.fragmentAccountDetails) !=null)
//                {
//                    loadAccountDetailsPage();
//                    setContentView(R.layout.fragment_scan_invoice);
//                    setContentView(R.layout.activity_main);
//                }

            switch (item.getItemId()) {
                case R.id.navigation_scan_invoice:
//                        TextView shsh = findViewById(R.id.title);
//                        shsh.setVisibility(0);
                    Fragment ScanInvoicePage = getSupportFragmentManager().findFragmentById(R.id.navigation_scan_invoice);
                    openFragment(ScanInvoicePage);
//                        nav_host_fragment_activity_main.re
//                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
//                        getFragmentManager();
//                        ft.replace(R.id.nav_host_fragment_activity_main, getSupportFragmentManager().findFragmentById(R.layout.fragment_scan_invoice));
//                        ft.commit();


//                        Fragment he = getSupportFragmentManager().findFragmentById(R.id.fragmentAccountDetails);
//                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                        assert he != null;
//                        ft.replace(R.id.nav_host_fragment_activity_main, he);
//                        ft.commit();


//                        DataFromDb changeActivity = new DataFromDb();
//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.changeFrg, changeActivity);
//                        transaction.commit();

                    //        View MyInvoicesPage = findViewById(R.layout.fragment_my_invoices);
//        View AccountDetailsPage = findViewById(R.layout.fragment_account_details);
                    setContentView(R.layout.fragment_scan_invoice);
//                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_activity_main);
//                        NavigationUI.setupWithNavController(binding.navView, navController);
//                        navBarClicked();
//                        createNavbar();
                    return true;
                case R.id.navigation_my_invoices:
//                        openFragment(FragmentMyInvoicesBinding.newInstance("",""));
//                        getSupportFragmentManager().findFragmentById(R.layout.fragment_my_invoices);

                    setContentView(R.layout.fragment_my_invoices);
//                        createNavbar();
                    return true;
                case R.id.navigation_account_details:
                    setContentView(R.layout.fragment_account_details);
//                        setContentView(R.layout.activity_main);
//                        openFragment(FragmentAccountDetailsBinding.newInstance("",""));
//                        getSupportFragmentManager().findFragmentById(R.layout.fragment_account_details);

//                        setContentView(R.layout.fragment_scan_invoice);
//                        createNavbar();
                    return true;
//                    case R.id.navigation_library:
//                        openFragment();
//                        return true;
            }
            return false;
        });
    }

//    public void loadScanInvoicePage(){
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.addOnBackStackChangedListener((FragmentManager.OnBackStackChangedListener) this);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        Button scanqrcode = findViewById(R.id.btnscanqrcode);
//        displayInvoiceDetails = findViewById(R.id.invoiceDetails);
//
//        scanqrcode.setOnClickListener(view -> {
//            IntentIntegrator intentIntegrator = new IntentIntegrator(IgnoreScanInvoiceActivity.this);
//            intentIntegrator.setPrompt("Scan a QR Code");
//            intentIntegrator.setOrientationLocked(true);
//            intentIntegrator.initiateScan();
//        });
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                displayInvoiceDetails = findViewById(R.id.displayInvoiceDetails);
                businessName = findViewById(R.id.businessName);
                email = findViewById(R.id.email);
                description = findViewById(R.id.description);
                price = findViewById(R.id.price);
                paidStatus = findViewById(R.id.paidStatus);
                dueDate = findViewById(R.id.dueDate);
                lblScanInvoice = findViewById(R.id.lblScanInvoice);

//                displayInvoiceDetails.setText(intentResult.getContents());
                displayInvoiceDetails.setVisibility(View.VISIBLE);
                lblScanInvoice.setVisibility(View.VISIBLE);
//                convert intentResult.getContents() to list then iterate through it for each item in the table
//                List <String> invoiceDetails = Collections.singletonList(intentResult.getContents());
//                String[] strArray = new String[4];
//                invoiceDetails.toArray(strArray);
//                businessName.setText(strArray[0]);
//                email.setText(strArray[0]);
//                description.setText(strArray[1]);
//                price.setText(strArray[2]);
//                paidStatus.setText(strArray[3]);
                String invoiceDetails = intentResult.getContents();
                String[] strArray = null;
                strArray = invoiceDetails.split(",");

//                invoiceDetails.toArray(strArray);
                businessName.setText(strArray[1]);
                email.setText(strArray[2]);
                description.setText(strArray[3]);
                price.setText(strArray[4]);
                paidStatus.setText(strArray[5]);
                dueDate.setText(strArray[6]);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}