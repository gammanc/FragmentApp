package com.gamma.fragmentapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentViewer extends Fragment {

    TextView stone_name, stone_location, stone_description;
    ImageView stone_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_viewer, container, false);

        stone_name = v.findViewById(R.id.stone_name);
        stone_location = v.findViewById(R.id.stone_location);
        stone_description = v.findViewById(R.id.stone_description);
        stone_image = v.findViewById(R.id.stone_image);

        Bundle b = this.getArguments();
        InfinityStone stone;

        if(b != null){
            stone = b.getParcelable("STONE");
            stone_image.setImageDrawable(ContextCompat.getDrawable(getActivity(), stone.getImage()));
            stone_name.setText(stone.getName());
            stone_location.setText(getString(R.string.txt_location) + " " +stone.getLocation());
            stone_description.setText(stone.getDescription());
        }

        return v;
    }
}
