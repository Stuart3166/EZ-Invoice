package com.example.ezinvoicecustomer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezinvoicecustomer.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class ViewMyInvoicesActivity extends AppCompatActivity {
//    public class ViewMyInvoicesActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener {

    TextView displayInvoiceDetails, myInvoiceTitle;
    //        ArrayList lstSavedInvoices = new ArrayList<>();
    BottomNavigationView navView;
    private ActivityMainBinding binding;
    private CustomAdapter customAdapter;
    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_my_invoices);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        movieList = new ArrayList<>();
//        Log.d(" invoicez", "are kewl");
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        myInvoiceTitle = findViewById(R.id.myInvoiceTitle);
//        myInvoiceTitle.setText("Invoice saved: number");
////        if (myInvoiceTitle.getVisibility() == View.VISIBLE) {
//            db.collection("invoices")
//                    .document(user.getUid())
//                    .get()
//                    .addOnCompleteListener(task -> {
////                                checkUserExists.addOnCompleteListener(task -> {
////                                        @Override
////                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
////                    if (task.isSuccessful()) {
//                        int invoiceCount = 1;
//                        boolean countedInvoices = false;
//                        myInvoiceTitle = findViewById(R.id.myInvoiceTitle);
//                        Log.d("C checkpoint 1", "welcome");
//                        myInvoiceTitle.setText("Invoice saved: " + invoiceCount);
//
//                        DocumentSnapshot customer = task.getResult();
//                        while (countedInvoices == false) {
//                            try {
//                                customer.getData().get(String.valueOf(invoiceCount));
//                                if (customer.getData().get(String.valueOf(invoiceCount)) == null) {
//                                    Log.d("Next available ID: ", String.valueOf(invoiceCount));
//                                    Log.d("Database", "Uploading new Invoice");
////                                    newInvoiceWithID.put(String.valueOf(invoiceCount), newInvoice);
////                                                Map<String, Object> map = new HashMap<>();
////                                                map.put("customerIDs", user.getUid());
////                                    db.collection("invoices").document(user.getUid()).update(String.valueOf(invoiceCount), newInvoice);
////                                                if (db.collection("customerList").document(finalStrArray[0]) == null) {
////                                    db.collection("customerList").document(finalStrArray[0]).update(map);
////                                                } else {
////                                                    db.collection("customerList").document(finalStrArray[0]).update("customerIDs", FieldValue.arrayUnion(user.getUid()));
////                                                }
//                                    myInvoiceTitle.setText("Invoice saved: " + invoiceCount);
//                                    countedInvoices = true;
////                                           break;
//                                } else {
//                                    Log.d("The current invoice number is ", String.valueOf(invoiceCount));
//                                    Log.d("Contents of invoice: ", String.valueOf(customer.getData().get(String.valueOf(invoiceCount))));
//                                    invoiceCount++;
//                                }
//
//                            } catch (Exception e) {
//                                Log.d("tot totally", "unique log");
////                                newInvoiceWithID.put(String.valueOf(firstInvoiceID), newInvoice);
////                                db.collection("invoices").document(user.getUid()).set(newInvoiceWithID);
////                                db.collection("customerList").document(finalStrArray[0]).set(map);
//                                myInvoiceTitle.setText("Invoice saved catch: " + invoiceCount);
//                                countedInvoices = true;
//                            }
//                        }
////                    }
//                    });
//        }

//        prepareMovie();
//        recyclerView = findViewById(R.id.recyclerView);
//        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//////        movieList.add();
//        customAdapter = new CustomAdapter(this, movieList);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        Log.d("Array List length: ", String.valueOf(movieList.size()));
//        recyclerView.setAdapter(customAdapter);
//
//        customAdapter.setOnItemClickListener(new ClickListener<Movie>() {
//            @Override
//            public void onItemClick(Movie data) {
//                Toast.makeText(ViewMyInvoicesActivity.this, data.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerView.setAdapter(customAdapter);

//        lstSavedInvoices.add(new InvoiceModel("SpaceX", "Rocket to mars", "£87,428", "Paid", "01/01/2025"));
//        lstSavedInvoices.add(new InvoiceModel("AppleX", "Rocket to mars", "£99", "Paid", "01/01/2025"));
//        lstSavedInvoices.add(new InvoiceModel("GoogleX", "Rocket to mars", "£87,428", "Paid", "01/01/2025"));
        // we are initializing our adapter class and passing our arraylist to it.
//        CustomAdapter customAdapter = new CustomAdapter(this, lstSavedInvoices);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(customAdapter);


//        binding = ActivityMainBinding.inflate(getLayoutInflater());

//        setContentView(binding.getRoot());
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(ViewMyInvoicesActivity.this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupWithNavController(binding.navView, navController);

//        SecondFragment.newInstance();

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        setContentView(R.layout.fragment_my_invoices);

//            Fragment fragment = null;
//            fragment = ViewMyInvoicesFragment.newInstance();
//            if (fragment != null) {
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                System.out.println(fragmentTransaction);
//                fragmentTransaction.replace(R.id.container, fragment);
//                fragmentTransaction.commit();
//            }
//        }

//        // get the reference of RecyclerView
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMyInvoice);
////        // set a LinearLayoutManager with default orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
//
//        //  call the constructor of CustomAdapterOld to send the reference and data to Adapter
//        CustomAdapter customAdapter = new CustomAdapter(ViewMyInvoicesActivity.this, lstSavedInvoices);
//        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

//        setContentView(binding.getRoot());
//        createNavbar();
    }

    private void prepareMovie() {
        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.common_google_signin_btn_icon_dark_normal);
        movieList.add(movie);
        movie = new Movie("Coco", R.drawable.common_google_signin_btn_icon_dark_normal);
        movieList.add(movie);
        movie = new Movie("Justice League ", R.drawable.common_google_signin_btn_icon_dark_normal);
        movieList.add(movie);
//        movie = new Movie("Thor: Ragnarok",R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//        movie = new Movie("Star Wars The Last Jedi",R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//        movie = new Movie("Coco",R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//        movie = new Movie("Justice League ",R.drawable.justice_league);
//        movieList.add(movie);
//        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
//        movieList.add(movie);
//        movie = new Movie("Star Wars The Last Jedi",R.drawable.star_war);
//        movieList.add(movie);
//        movie = new Movie("Coco",R.drawable.coco);
//        movieList.add(movie);
//        movie = new Movie("Justice League ",R.drawable.justice_league);
//        movieList.add(movie);
//        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
//        movieList.add(movie);
        customAdapter.notifyDataSetChanged();
    }

//    public void createNavbar() {
////        setContentView(binding.getRoot());
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupWithNavController(binding.navView, navController);
//
//        navView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.navigation_scan_invoice:
//                    startActivity(new Intent(ViewMyInvoicesActivity.this, IgnoreScanInvoiceActivity.class));
////                case R.id.navigation_my_invoices:
////                    startActivity(new Intent(AccountDetailsActivity.this, ViewMyInvoicesActivity.class));
////                            return true;
//                case R.id.navigation_account_details:
//                    startActivity(new Intent(ViewMyInvoicesActivity.this, AccountDetailsActivity.class));
//            }
//            return false;
//        });
//    }
}