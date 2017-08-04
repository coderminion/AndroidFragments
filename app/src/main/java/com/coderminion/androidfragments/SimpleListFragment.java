package com.coderminion.androidfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleListFragment extends ListFragment {

    List<HashMap<String, String>> flavours;
    String[] id, name, code;

    public SimpleListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        id = getActivity().getResources().getStringArray(R.array.ids);
        code = getActivity().getResources().getStringArray(R.array.code);
        name = getActivity().getResources().getStringArray(R.array.name);
        return inflater.inflate(R.layout.fragment_simple_list, container, false);
    }

    //Method Get Called onViewCreated
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        flavours = new ArrayList<>();
        prepareData();

        //Create SimpleListAdapter
        String[] from = {"id", "name", "code"};
        int[] to = {R.id.id, R.id.name, R.id.code};
        ListAdapter listAdapter = new SimpleAdapter(getContext(), flavours, R.layout.list_item, from, to);
        //SetAdapter
        setListAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Create framgment to access setText method
        SingleFlavourFragment txt = (SingleFlavourFragment) getFragmentManager().findFragmentById(R.id.simpletext);
        txt.setTexts(name[position], "Version : " + code[position]);
    }

    //Add data to flavours
    private void prepareData() {

        for (int i = 0; i < id.length; i++) {
            HashMap<String, String> androidHashMap = new HashMap<>();
            androidHashMap.put("id", "ID : " + id[i]);
            androidHashMap.put("name", "Name : " + name[i]);
            androidHashMap.put("code", "Code : " + code[i]);
            flavours.add(androidHashMap);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
