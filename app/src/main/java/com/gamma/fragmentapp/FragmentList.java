package com.gamma.fragmentapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.stones, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        InfinityStone stone = new InfinityStone(
                parent.getItemAtPosition(i).toString(),
                getResources().getStringArray(R.array.locations)[i],
                getResources().getStringArray(R.array.descriptions)[i],
                getResources().obtainTypedArray(R.array.cool_images).getResourceId(i,-1)
        );

        Bundle sExtras = new Bundle();
        sExtras.putParcelable("STONE", stone);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent intent = new Intent(getActivity().getApplicationContext(), SecondActivity.class);
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtras(sExtras);
            startActivity(intent);
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentViewer f = new FragmentViewer();
            f.setArguments(sExtras);

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.viewer, f);
            ft.commit();
        }
    }


}
