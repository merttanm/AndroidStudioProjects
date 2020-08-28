package com.prevezene.mezunapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fsmvu_paper#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fsmvu_paper extends Fragment  {



  /*
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public Object currentItem;

        public ViewHolder(View v) {
            super(v);
            view = v;
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                }
            });
        }
    }

    @Override public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.currentItem = items.get(i);
    }

   */
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fsmvu_paper() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fsmvu_paper.
     */
    // TODO: Rename and change types and number of parameters
    public static fsmvu_paper newInstance(String param1, String param2) {
        fsmvu_paper fragment = new fsmvu_paper();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fsmvu_paper, container, false);
    }
}