package com.example.ezinvoicecustomer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

interface ClickListener<T> {
    void onItemClick(T data);
}

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Viewholder> {
    private Context context;
    private List<InvoiceModel> invoiceModelArrayList;
    private ClickListener<InvoiceModel> clickListener;

    // Constructor
//    public CustomAdapter(Context context, ArrayList<InvoiceModel> invoiceModelArrayList) {
//        this.context = context;
//        this.invoiceModelArrayList = invoiceModelArrayList;
//    }

    CustomAdapter(FragmentActivity activity, List<InvoiceModel> invoiceModelArrayList) {
        this.invoiceModelArrayList = invoiceModelArrayList;
    }

    @NonNull
    @Override
    public CustomAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_card, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
//        InvoiceModel model = invoiceModelArrayList.get(position);
        final InvoiceModel invoice = invoiceModelArrayList.get(position);

        holder.businessName.setText(invoice.getbusinessName());
        holder.description.setText(invoice.getdescription());
//        holder.price.setText(invoice.getprice());
        holder.paidStatus.setText(invoice.getpaidStatus());
        holder.date.setText(invoice.getdate());
//        holder.courseIV.setImageResource(model.getCourse_image());
//        holder.title.setText(movie.getTitle());
//        holder.image.setBackgroundResource(movie.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(invoice);
//                Toast.makeText(context, holder.price.setText(invoice.getprice()), Toast.LENGTH_LONG).show();
//                holder.price.setText(invoice.getprice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return invoiceModelArrayList.size();
    }

    public void setOnItemClickListener(ClickListener<InvoiceModel> clickListener) {
        this.clickListener = clickListener;
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        View view;
        private ImageView courseIV, image;
        private TextView title, businessName, description, price, paidStatus, date;
        private CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
//            courseIV = itemView.findViewById(R.id.image);
//            title = itemView.findViewById(R.id.title);
//            image = itemView.findViewById(R.id.image);
            businessName = itemView.findViewById(R.id.cardViewBusinessName);
            description = itemView.findViewById(R.id.cardViewDescription);
//            price = itemView.findViewById(R.id.cardViewPrice);
            paidStatus = itemView.findViewById(R.id.cardViewPaidStatus);
            date = itemView.findViewById(R.id.cardViewDate);
            cardView = itemView.findViewById(R.id.invoiceCardView);
            view = itemView;
        }
    }
}