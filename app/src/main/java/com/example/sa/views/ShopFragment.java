package com.example.sa.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sa.R;
import com.example.sa.adapters.ShopListAdaptor;
import com.example.sa.databinding.FragmentShopBinding;
import com.example.sa.models.Product;
import com.example.sa.viewmodels.ShopViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ShopFragment extends Fragment implements ShopListAdaptor.ShopInterface {

    private static final String TAG = "ShopFragment";

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdaptor shopListAdapter;
    private ShopViewModel shopViewModel;
    private NavController navController;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = fragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopListAdapter = new ShopListAdaptor(this);
        fragmentShopBinding.shopRecylerview.setAdapter(shopListAdapter);
        fragmentShopBinding.shopRecylerview.addItemDecoration(new DividerItemDecoration(requireContext() , DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecylerview.addItemDecoration(new DividerItemDecoration(requireContext() , DividerItemDecoration.HORIZONTAL));

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProduct().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });

        navController = Navigation.findNavController(view);
    }

    @Override
    public void addItem(Product product) {
        boolean isAdded = shopViewModel.addItemToCart(product);
        if (isAdded){
            Snackbar.make(requireView(),product.getName() + "add to cart", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
                        }
                    })
                    .show();
        }else{
            Snackbar.make(requireView(), "Already have the max quantity in cart." , Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemClick(Product product) {
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productFragment);

    }
}