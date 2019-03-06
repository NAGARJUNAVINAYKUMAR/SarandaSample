package com.saranda.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private AppCompatButton btn_4X4, btn_6X6, btn_10X10;
    private RecyclerView mRecyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        if (list != null) {
            list.clear();
        }

        btn_4X4.setOnClickListener(this);
        btn_6X6.setOnClickListener(this);
        btn_10X10.setOnClickListener(this);
    }

    private void initViews() {
        btn_4X4 = findViewById(R.id.btn_4X4);
        btn_6X6 = findViewById(R.id.btn_6X6);
        btn_10X10 = findViewById(R.id.btn_10X10);
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_4X4:
                if (list != null) {
                    list.clear();
                }
                list = new ArrayList<>();
                for (int i = 0; i < 16; i++) {
                    list.add(String.valueOf(i));
                }
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 4);
                gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(MainActivity.this, list);
                mRecyclerView.setAdapter(mRecyclerAdapter);
                break;
            case R.id.btn_6X6:
                if (list != null) {
                    list.clear();
                }
                list = new ArrayList<>();
                for (int i = 0; i < 36; i++) {
                    list.add(String.valueOf(i));
                }
                gridLayoutManager = new GridLayoutManager(MainActivity.this,6);
                gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mRecyclerAdapter = new RecyclerAdapter(MainActivity.this, list);
                mRecyclerView.setAdapter(mRecyclerAdapter);
                break;
            case R.id.btn_10X10:
                if (list != null) {
                    list.clear();
                }
                list = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    list.add(String.valueOf(i));
                }
                gridLayoutManager = new GridLayoutManager(MainActivity.this,10);
                gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mRecyclerAdapter = new RecyclerAdapter(MainActivity.this, list);
                mRecyclerView.setAdapter(mRecyclerAdapter);
                break;
            default:
                break;
        }
    }
}
