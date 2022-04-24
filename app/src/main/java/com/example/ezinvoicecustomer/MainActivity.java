package com.example.ezinvoicecustomer;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.ezinvoicecustomer.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ScanInvoiceFragment.OnFragmentInteractionListener, ViewMyInvoicesFragment.OnFragmentInteractionListener, AccountDetailsFragment.OnFragmentInteractionListener {

    TableLayout displayInvoiceDetails;
    TextView lblScanInvoice, businessName, email, description, price, paidStatus, dueDate;
    Button btnsaveInvoice;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        FragmentTransaction fragmentTransactionInitial = getSupportFragmentManager().beginTransaction();
        fragmentTransactionInitial.replace(R.id.container, ScanInvoiceFragment.newInstance());
        fragmentTransactionInitial.commit();

        navView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_scan_invoice:
                    fragment = ScanInvoiceFragment.newInstance();
                    break;
                case R.id.navigation_my_invoices:
                    fragment = ViewMyInvoicesFragment.newInstance();
                    break;
                case R.id.navigation_account_details:
                    fragment = AccountDetailsFragment.newInstance();
                    break;
            }
            if (fragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
            return true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Scan Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                displayInvoiceDetails = findViewById(R.id.displayInvoiceDetails);
                businessName = findViewById(R.id.businessName);
                email = findViewById(R.id.email);
                description = findViewById(R.id.description);
                price = findViewById(R.id.price);
                paidStatus = findViewById(R.id.paidStatus);
                dueDate = findViewById(R.id.dueDate);

                btnsaveInvoice = findViewById(R.id.btnsaveInvoice);
                lblScanInvoice = findViewById(R.id.lblScanInvoice);
//                auth = FirebaseAuth.getInstance();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//                displayInvoiceDetails.setText(intentResult.getContents());
                displayInvoiceDetails.setVisibility(View.VISIBLE);
                btnsaveInvoice.setVisibility(View.VISIBLE);
                lblScanInvoice.setVisibility(View.INVISIBLE);
                String qrContents = intentResult.getContents();
                String[] strArray;
                strArray = qrContents.split(",");

//                invoiceDetails.toArray(strArray);
                businessName.setText(strArray[1]);
                email.setText(strArray[2]);
                description.setText(strArray[3]);
                price.setText(strArray[4]);
                paidStatus.setText(strArray[5]);
                dueDate.setText(strArray[6]);

                btnsaveInvoice = findViewById(R.id.btnsaveInvoice);
                String[] finalStrArray = strArray;
                btnsaveInvoice.setOnClickListener(view -> {
                    Log.d("Cloud Firestore", "beginning write attempt");
                    Map<String, Object> newInvoice = new HashMap<>();
//                    newInvoice.put("businessID", user.getUid());
//                    newInvoice.put("businessID", businessID.getText());
                    newInvoice.put("businessID", finalStrArray[0]);
                    newInvoice.put("description", description.getText());
                    newInvoice.put("price", price.getText());
                    newInvoice.put("paidStatus", paidStatus.getText());
                    newInvoice.put("date", dueDate.getText());
                    Map<String, Object> newInvoiceWithID = new HashMap<>();

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
//                    CollectionReference customers = db.collection("invoices");
//
//                    Task<DocumentSnapshot> checkUser = db.collection("invoices").document(user.getUid()).get();

                    //TODO get next available invoice id
//                    Query checkUserExists = db.collection("invoices").whereEqualTo("id", user.getUid());
//                    Task<DocumentSnapshot> checkUserExists = db.collection("invoices").document(user.getUid()).get();
//                    int firstInvoiceID = 1;
                    Map<String, Object> map = new HashMap<>();
                    map.put("customerIDs", FieldValue.arrayUnion(user.getUid()));

                    db.collection("invoices")
                            .document(user.getUid())
                            .get()
                            .addOnCompleteListener(task -> {

                                if (task.isSuccessful()) {
                                    DocumentSnapshot customer = task.getResult();
                                    int invoiceCount = 1;
                                    boolean foundLatest = false;


                                    while (foundLatest == false) {
//                                        try {
//                                            customer.getData().get(String.valueOf(invoiceCount));

                                        if (customer.getData().get(String.valueOf(invoiceCount)) == null) {
                                            Log.d("Next available ID: ", String.valueOf(invoiceCount));
                                            Log.d("Database", "Uploading new Invoice");
                                            newInvoiceWithID.put(String.valueOf(invoiceCount), newInvoice);
//                                                Map<String, Object> map = new HashMap<>();
//                                                map.put("customerIDs", user.getUid());
                                            db.collection("invoices").document(user.getUid()).update(String.valueOf(invoiceCount), newInvoice);
//                                                if (db.collection("customerList").document(finalStrArray[0]) == null) {
                                            db.collection("customerList").document(finalStrArray[0]).update(map);
//                                                } else {
//                                                    db.collection("customerList").document(finalStrArray[0]).update("customerIDs", FieldValue.arrayUnion(user.getUid()));
//                                                }
//                                            SendMail sm = new SendMail(this, email, subject, message);
//                                            sm.execute();
                                            foundLatest = true;
//                                           break;
                                        } else {
                                            Log.d("The current invoice number is ", String.valueOf(invoiceCount));
                                            Log.d("Contents of invoice: ", String.valueOf(customer.getData().get(String.valueOf(invoiceCount))));
                                            invoiceCount++;
                                        }
//                                   }

//                                        } catch (Exception e) {
//                                            Log.d("tot totally", "unique log");
//                                            newInvoiceWithID.put(String.valueOf(firstInvoiceID), newInvoice);
//                                            db.collection("invoices").document(user.getUid()).set(newInvoiceWithID);
//                                            db.collection("customerList").document(finalStrArray[0]).set(map);
//                                            foundLatest = true;
//                                        }
                                    }
                                }
                            });
                });
            }
        }
    }
}