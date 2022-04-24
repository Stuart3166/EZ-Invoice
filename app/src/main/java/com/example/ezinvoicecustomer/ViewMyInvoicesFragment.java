package com.example.ezinvoicecustomer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ViewMyInvoicesFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public static ViewMyInvoicesFragment newInstance() {
        return new ViewMyInvoicesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_invoices, container, false);
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
        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView myInvoiceTitle;
        myInvoiceTitle = getActivity().findViewById(R.id.myInvoiceTitle);
//        myInvoiceTitle.setText("Invoices saved: number");
//        if (myInvoiceTitle.getVisibility() == View.VISIBLE) {

        db.collection("invoices")
                .document(user.getUid())
                .get()
                .addOnCompleteListener(task -> {

                });

        db.collection("invoices")
                .document(user.getUid())
                .get()
                .addOnCompleteListener(task -> {
//                                checkUserExists.addOnCompleteListener(task -> {
//                                        @Override
//                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

//                    if (task.isSuccessful()) {
//                    int invoiceCount = 1;

                    // Set variables to be used by multiple threads
                    AtomicInteger invoiceCount = new AtomicInteger(1);
                    AtomicBoolean countedInvoices = new AtomicBoolean(false);
//                    myInvoiceTitle = getActivity().findViewById(R.id.myInvoiceTitle);
//                    Log.d("C checkpoint 1", "welcome");
//                    myInvoiceTitle.setText("Invoice saved: " + invoiceCount);
                    AtomicReference<Double> totalCost = new AtomicReference<>(0.0);
                    DocumentSnapshot customer = task.getResult();
                    List<InvoiceModel> lstSavedInvoices = new ArrayList<>();
                    AtomicReference<String> businessNameAtomic = new AtomicReference<>();

                    while (countedInvoices.get() == false) {
//                        try {
                        customer.getData().get(String.valueOf(invoiceCount.get()));
                        if (customer.getData().get(String.valueOf(invoiceCount.get())) == null) {
                            Log.d("Next available ID: ", String.valueOf(invoiceCount.get()));
                            Log.d(" Cloud Firestore", "loading " + invoiceCount + "invoices");
//                                    newInvoiceWithID.put(String.valueOf(invoiceCount), newInvoice);
//                                                Map<String, Object> map = new HashMap<>();
//                                                map.put("customerIDs", user.getUid());
//                                    db.collection("invoices").document(user.getUid()).update(String.valueOf(invoiceCount), newInvoice);
//                                                if (db.collection("customerList").document(finalStrArray[0]) == null) {
//                                    db.collection("customerList").document(finalStrArray[0]).update(map);
//                                                } else {
//                                                    db.collection("customerList").document(finalStrArray[0]).update("customerIDs", FieldValue.arrayUnion(user.getUid()));
//                                                }
//                                invoiceCount = 0;
//                                myInvoiceTitle.setText("Invoice saved: " + invoiceCount);
                            invoiceCount.getAndDecrement();
                            myInvoiceTitle.setText("You have saved " + (invoiceCount.get()) + " invoices");
//                            myInvoiceTitle.setText("Total Cost: ");
//                            TextView lblTotalCost;
//                            lblTotalCost = getView().findViewById(R.id.totalCost);
//                            lblTotalCost.setVisibility(View.VISIBLE);
//                            lblTotalCost.bringToFront();
//                            lblTotalCost.setText("Total Cost: £" + totalCost.get());
//                            try {
//                                TimeUnit.SECONDS.sleep(3);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                            countedInvoices.set(true);
//                                           break;
                        } else {
//                            int currentInvoiceNumber = invoiceCount.get();
                            HashMap selectedInvoice = (HashMap) customer.getData().get(String.valueOf(invoiceCount));
//                            HashMap testhash = new HashMap<>();
//                            List<InvoiceModel> lstSavedInvoices = new ArrayList<>();
//                            lstSavedInvoices = new ArrayList<>();

//                            selectedInvoice.get("price");
                            Log.d(" The current invoice number is ", String.valueOf(invoiceCount));
                            String businessID = String.valueOf(selectedInvoice.get("businessID"));
                            Log.d(" findbusiness id", businessID);

//                            String businessID = String.valueOf(selectedInvoice.get("businessID"));
//                            Task<DocumentSnapshot> lookupBusiness = db.collection("businesses").document(businessID).get().addOnCompleteListener(checkBusiness -> {
                            db.collection("businesses").document(businessID).get().addOnCompleteListener(checkBusiness -> {
                                if (checkBusiness.isSuccessful()) {
                                    DocumentSnapshot business = checkBusiness.getResult();
//                                    Log.d(" findbusiness", String.valueOf(business.getClass()));
//                                    Log.d(" findbusiness", String.valueOf(business.getData()));
//                                    Log.d(" findbusiness", String.valueOf(business.get("businessName")));
//                                    Object matchedName = business.get("businessName");
//                                    String some = matchedName.toString();

                                    String matchedName = String.valueOf(business.get("businessName"));
//                                    String spicy = String.valueOf(business.get("businessName"));
                                    businessNameAtomic.getAndSet(matchedName);
//                                    if (business.getData().get(String.valueOf(invoiceCount)) == null) {
                                    Log.d(" The current invoice businessName is ", matchedName);
//                                    Log.d(" The current invoice businessName is ", String.valueOf(businessNameAtomic));
//                                    TextView lblTotalCost;
//                                    lblTotalCost = getView().findViewById(R.id.totalCost);
//                                    lblTotalCost.setVisibility(View.VISIBLE);
//                                    lblTotalCost.setText("Total Cost: £" + totalCost);
                                    Log.d(" The current cost is £", String.valueOf(totalCost));
//                                    }
//                                }
//                            });
//                            Task<DocumentSnapshot> lookupBusiness = db.collection("businesses").document(businessID).get();
//                            lookupBusiness.getResult().getData();

//                            String businessName = String.valueOf(task);
                                    String description = String.valueOf(selectedInvoice.get("description"));
                                    String price = String.valueOf(selectedInvoice.get("price"));
                                    String paidStatus = String.valueOf(selectedInvoice.get("paidStatus")).trim();
                                    String date = String.valueOf(selectedInvoice.get("date"));
                                    String businessName = (businessNameAtomic.toString());
                                    TextView lblTotalCost, lblReminder;

                                    totalCost.getAndUpdate(v -> v + Double.parseDouble(price));

                                    lblTotalCost = getView().findViewById(R.id.totalCost);
                                    lblTotalCost.setVisibility(View.VISIBLE);
                                    lblTotalCost.bringToFront();
                                    DecimalFormat decimalFormat = new DecimalFormat("###.##");
                                    lblTotalCost.setText("Total Cost: £" + decimalFormat.format(totalCost.get()));

                                    // Calculate how many days until the next unpaid invoice is due
//                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                                    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//
//                                    Date dueDate = new Date();
//                                    Date today = new Date();
//                                    String[] dueDate = date.split("/");
//                                    System.out.println(dueDate[1]);
//                                    Integer dueDay, dueMonth, dueYear;
//                                    dueDay = Integer.parseInt(dueDate[0]);
//                                    dueMonth = Integer.parseInt(dueDate[1]);
//                                    dueYear = Integer.parseInt(dueDate[2]);
//                                    LocalDate.of( dueYear , dueMonth , dueDay );
//                                    dueDate.setDate(Integer.parseInt(dateFormat.format(date)));
//                                    Calendar c = Calendar.getInstance();
//                                    today = dateFormat.format(Calendar.getInstance());
////                                    dateFormat.format(dueDate);
////                                    dateFormat.format(today);
////                                    long diff = dueDate.getTime() - today.getTime();
//                                    long diff = today.getTime() - today.getTime();


                                    if (paidStatus.equals("Unpaid")) {
                                        lblReminder = getView().findViewById(R.id.unpaidInvoiceReminder);
                                        lblReminder.setVisibility(View.VISIBLE);
                                        lblReminder.setText("You have an unpaid invoice due on " + date.trim());
//                                        int days = Days.daysBetween(dueDate, Date.).getDays();


                                    }
//                                    Log.d(" total cost is ", decimalFormat.format(totalCost.get()));

//                                Log.d(" The current invoice businessID is ", String.valueOf(selectedInvoice.get("businessID")));
//                                Log.d(" The current invoice businessName is ", String.valueOf(businessName));
//                                Log.d(" The current invoice businessName is ", String.valueOf(businessNameAtomic));
//                                Log.d(" The current invoice description is ", String.valueOf(selectedInvoice.get("description")));
                                    Log.d(" The current invoice price is ", String.valueOf(selectedInvoice.get("price")));
//                                Log.d(" The current invoice paidStatus is ", String.valueOf(selectedInvoice.get("paidStatus")));
//                                Log.d(" The current invoice date is ", String.valueOf(selectedInvoice.get("date")));
                                    AtomicReference<RecyclerView> recyclerView = new AtomicReference<>();
                                    recyclerView.set(getActivity().findViewById(R.id.recyclerView));
                                    InvoiceModel InvoiceModel = new InvoiceModel(businessName, description, price, paidStatus, date);
                                    lstSavedInvoices.add(InvoiceModel);

                                    CustomAdapter customAdapter;
                                    customAdapter = new CustomAdapter(getActivity(), lstSavedInvoices);
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    recyclerView.get().setLayoutManager(layoutManager);
                                    Log.d("Array List length: ", String.valueOf(lstSavedInvoices.size()));
                                    CardView unpaidInvoiceReminder;

                                    customAdapter.setOnItemClickListener(new ClickListener<InvoiceModel>() {
                                        @Override
                                        public void onItemClick(com.example.ezinvoicecustomer.InvoiceModel data) {
                                            Toast.makeText(getActivity(), "Price: £" + data.getprice().trim(), Toast.LENGTH_SHORT).show();
                                        }

//                                        @Override
//                                        public void onItemClick(Movie data) {
//                                            Toast.makeText(getActivity(), data.getTitle(), Toast.LENGTH_SHORT).show();
//                                        }
                                    });
                                    unpaidInvoiceReminder = getActivity().findViewById(R.id.cardViewReminder);
                                    unpaidInvoiceReminder.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(getActivity(), "This invoice is for " + businessName.trim(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                    recyclerView.get().setAdapter(customAdapter);


//                                    NestedScrollView nestedScroll;
//                                    nestedScroll =  getActivity().findViewById(R.id.nestedScroll);
//                                    final int[] count = {0};
//
//                                    nestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//                                        @Override
//                                        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                                            // on scroll change we are checking when users scroll as bottom.
//                                            if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                                                // in this method we are incrementing page number,
//                                                // making progress bar visible and calling get data method.
//                                                count[0]++;
//                                                // on below line we are making our progress bar visible.
////                                                loadingPB.setVisibility(View.VISIBLE);
////                                                if (count[0] < 20) {
////                                                    // on below line we are again calling
////                                                    // a method to load data in our array list.
////                                                    getData();
////                                                }
//                                            }
//                                        }
//                                    });
                                }
                            });

                            invoiceCount.getAndIncrement();
                        }
                    }
                });
    }

    public interface OnFragmentInteractionListener {
    }
}

//        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//        movie = new Movie("Coco", R.drawable.common_google_signin_btn_icon_dark_normal);
//        movieList.add(movie);
//        customAdapter = new CustomAdapter(getActivity(), movieList);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        Log.d("Array List length: ", String.valueOf(movieList.size()));
//        recyclerView.setAdapter(customAdapter);
//        ArrayList lstSavedInvoices = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));
//        CustomAdapter customAdapter;

// get the reference of RecyclerView
//        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
//        // set a LinearLayoutManager with default orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

//  call the constructor of CustomAdapterOld to send the reference and data to Adapter
//        recyclerView = getView().findViewById(R.id.recyclerView);
//        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.common_google_signin_btn_icon_dark_normal);
////        movieList.add(movie);
//////        movieList.add();
//        customAdapter = new CustomAdapter(this, lstSavedInvoices);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        CustomAdapter customAdapter = new CustomAdapter(getActivity(), lstSavedInvoices);
//        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
