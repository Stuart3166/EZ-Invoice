//package com.example.ezinvoicecustomer;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class CustomAdapterOld extends RecyclerView.Adapter {
//    ArrayList lstSavedInvoices;
//    Context context;
//
//    public CustomAdapterOld(Context context, ArrayList lstSavedInvoices) {
//        this.context = context;
//        this.lstSavedInvoices = lstSavedInvoices;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // infalte the item Layout
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
//        return vh;
//    }
//
////    @Override
////    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
////
////    }
//
//    @Override
//    public int getItemCount() {
//        return lstSavedInvoices.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView name;// init the item view's
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            // get the reference of item view's
//            name = (TextView) itemView.findViewById(R.id.recyclerViewMyInvoice);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        // set the data in items
////        holder.examName
////                .setText(list.get(position).name);
////        holder.examDate
////                .setText(list.get(position).date);
////        holder.examMessage
////                .setText(list.get(position).message);
////        holder.itemView.setText(lstSavedInvoices.get(position));
//        position = holder.getAdapterPosition();
//        // implement setOnClickListener event on item view.
//        int finalPosition = position;
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // display a toast with person name on item click
//                Toast.makeText(context, (CharSequence) lstSavedInvoices.get(finalPosition), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
////    @Override
////    public void onBindViewHolder(MyViewHolder holder, final int position) {
////        // set the data in items
////        holder.name.setText(lstSavedInvoices.get(position));
////        // implement setOnClickListener event on item view.
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                // display a toast with person name on item click
////                Toast.makeText(context, lstSavedInvoices.get(position), Toast.LENGTH_SHORT).show();
////            }
////        });
////    }
//}
