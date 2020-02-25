package com.ivan.sison.mystore.views.fragments;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Product;
import com.ivan.sison.mystore.utils.DummyUtils;
import com.ivan.sison.mystore.views.activities.HomeActivity;
import com.ivan.sison.mystore.views.adapters.CartAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment implements CartAdapter.CartDelegate {

    private View mView;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cart, container, false);

        final int bottomBarHeight = ((HomeActivity) getActivity()).getBottomBarHeight();
        View layout = (View) mView.findViewById(R.id.lyt_cart_footer_view);

        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.rcy_cart);

        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        CartAdapter adapter = new CartAdapter(getContext(), DummyUtils.getCartProducts(),this);

        recyclerView.setLayoutManager(categoryLayoutManager);
        recyclerView.setAdapter(adapter);

        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();

        ((HomeActivity) getActivity()).setActivityTitle(getString(R.string.title_cart));
    }

    // MARK: - Cart Interface
    @Override
    public void onSelectedProduct(Product product) {

    }
}
