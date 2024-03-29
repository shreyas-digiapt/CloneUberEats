package com.example.ubereatsclone.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ubereatsclone.R;
import com.example.ubereatsclone.modelClass.HistoryItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HistoryRvAdapter extends RecyclerView.Adapter<HistoryRvAdapter.HistoryHolder> {

    private ArrayList<HistoryItems> mList;
    private Context context;

    public HistoryRvAdapter(ArrayList<HistoryItems> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.snipper_offer_items, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        HistoryItems items = mList.get(position);
        Picasso.get().load(items.getHistoryImage()).into(holder.mHistoryIv);
        holder.mHistoryRestroTitle.setText(items.getHistoryRestroName());
        holder.mHistoryOrderStatus.setText(items.getHistoryOrderStatus());
        holder.mHistoryOrderDate.setText(items.getHistoryOrderDate());
        holder.mHistoryOrderId.setText(items.getHistoryOrderId());
        holder.mHistoryOrderName.setText(items.getHistoryOrderName());
        holder.mHistoryDeliverMan.setText(items.getHistoryDeliverMan());
        holder.mHistoryOrderTotal.setText(items.getHistoryOrderTotal());

        holder.mBtnViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "ViewMenu", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mHistoryViewRecipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Recipt", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mHistoryGetHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Help", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class HistoryHolder extends RecyclerView.ViewHolder {

        private ImageView mHistoryIv;
        private Button mBtnViewMenu;
        private TextView mHistoryRestroTitle, mHistoryOrderStatus, mHistoryOrderDate, mHistoryOrderId;
        private TextView mHistoryOrderName, mHistoryDeliverMan, mHistoryOrderTotal, mHistoryViewRecipt, mHistoryGetHelp;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);

            mHistoryIv = itemView.findViewById(R.id.historyImageView);
            mBtnViewMenu = itemView.findViewById(R.id.btnHistoryViewMenu);
            mHistoryRestroTitle = itemView.findViewById(R.id.historyRestroName);
            mHistoryOrderStatus = itemView.findViewById(R.id.historyOrderStatus);
            mHistoryOrderDate = itemView.findViewById(R.id.historyOrderDate);
            mHistoryOrderId = itemView.findViewById(R.id.historyOrderId);
            mHistoryOrderName = itemView.findViewById(R.id.historyOrderName);
            mHistoryDeliverMan = itemView.findViewById(R.id.historyOrderDeliverName);
            mHistoryOrderTotal = itemView.findViewById(R.id.historyOrderTotal);
            mHistoryViewRecipt = itemView.findViewById(R.id.historyOrderRecipt);
            mHistoryGetHelp = itemView.findViewById(R.id.hidtoryOderHelp);
        }
    }
}
