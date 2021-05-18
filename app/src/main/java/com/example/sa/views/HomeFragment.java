package com.example.sa.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sa.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button ordernow;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.slide);
        List<SlideModel> SlideModels = new ArrayList<>();
        SlideModels.add(new SlideModel("https://www.coffeepressthailand.com/wp-content/uploads/2020/04/home-2-2.png","1"));
        SlideModels.add(new SlideModel("https://f.btwcdn.com/store-40850/frontend-banner/584aad96-cc48-689a-ce69-59d732e1b776.png","2"));
        SlideModels.add(new SlideModel("https://4.bp.blogspot.com/-AJEsEtRawYI/WJPwveeGVFI/AAAAAAAAATU/9TYSVJx3chYATbg3ERzo6l_nIqcZRzxjACLcB/s640/Coffee%2Bor%2BMe.jpg","3"));
        SlideModels.add(new SlideModel("https://www.nescafe.com/th/sites/default/files/styles/homepage_teaser_large/public/2020-04/C008-Product%20Facts%20-%20ClassicStocksy_txp62060114viY200_728x526%28desktop%29_0.jpg?itok=rOjV5X4G","4"));
        imageSlider.setImageList(SlideModels,true);

        ordernow = view.findViewById(R.id.ordernow);
        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_shopFragment);
            }
        });
        return view;
    }
}