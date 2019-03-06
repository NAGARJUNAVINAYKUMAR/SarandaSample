package com.saranda.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mList;
    private String string;

    RecyclerAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_layout,
                viewGroup, false);
        return new RecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder viewHolder, int i) {
        string = mList.get(i);
        try {
            if (i % 2 == 0) {
                viewHolder.et1.setText("2");
            } else {
                viewHolder.et1.setText("4");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private RadioGroup rd_grp;
        private AppCompatRadioButton rbtn1, rbtn2, rbtn3;
        private AppCompatEditText et1;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rbtn1 = itemView.findViewById(R.id.rbtn1);
            rbtn2 = itemView.findViewById(R.id.rbtn2);
            rbtn3 = itemView.findViewById(R.id.rbtn3);
            et1 = itemView.findViewById(R.id.et1);
        }
    }
}
