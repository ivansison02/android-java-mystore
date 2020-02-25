package com.ivan.sison.mystore.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Product;
import com.ivan.sison.mystore.data.entities.ProductCategory;
import com.ivan.sison.mystore.utils.DummyUtils;
import com.ivan.sison.mystore.utils.ViewUtils;
import com.ivan.sison.mystore.views.activities.CartActivity;
import com.ivan.sison.mystore.views.activities.HomeActivity;
import com.ivan.sison.mystore.views.activities.ProductDetailActivity;
import com.ivan.sison.mystore.views.adapters.ProductCategoryAdapter;
import com.ivan.sison.mystore.views.adapters.ProductListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeUserFragment extends Fragment implements View.OnClickListener,
        ProductCategoryAdapter.ProductCategoryDelegate, ProductListAdapter.ProductListDelegate {

    private View mView;
    private RecyclerView recyclerCategory, recyclerProduct;

    private ProductCategoryAdapter mCategoryAdapter;
    private ProductListAdapter mProductAdapter;
    

    public HomeUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home_user, container, false);

        ImageView imgFilter = (ImageView) mView.findViewById(R.id.img_filter);
        imgFilter.setOnClickListener(this);

        ImageView imgViewType = (ImageView) mView.findViewById(R.id.img_view_type);
        imgViewType.setOnClickListener(this);

        recyclerCategory = (RecyclerView) mView.findViewById(R.id.rcy_category);
        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        mCategoryAdapter = new ProductCategoryAdapter(getContext(), DummyUtils.getProductCategories(),this);

        recyclerCategory.setLayoutManager(categoryLayoutManager);
        recyclerCategory.setAdapter(mCategoryAdapter);

        recyclerProduct = (RecyclerView) mView.findViewById(R.id.rcy_product);
        GridLayoutManager productLayoutManager = new GridLayoutManager(getContext(), 2);

        mProductAdapter = new ProductListAdapter(getContext(), DummyUtils.getProducts(), ViewUtils.TYPE_GRID, this);

        recyclerProduct.setLayoutManager(productLayoutManager);
        recyclerProduct.setAdapter(mProductAdapter);

        return mView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_filter:
                onShowFilters();
                break;
            case R.id.img_view_type:
                onChangeViewType();
                break;
            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        ((HomeActivity) getActivity()).onAddScrollFlags();
        ((HomeActivity) getActivity()).setActivityTitle(getString(R.string.title_home));
    }

    private void onChangeViewType() {
        int viewType = mProductAdapter.getViewType();
        if (viewType == ViewUtils.TYPE_GRID) {
            viewType = ViewUtils.TYPE_LIST;
            recyclerProduct.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        }
        else {
            viewType = ViewUtils.TYPE_GRID;
            recyclerProduct.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        mProductAdapter = new ProductListAdapter(getContext(), DummyUtils.getProducts(), viewType, this);
        recyclerProduct.setAdapter(mProductAdapter);
    }

    private void onShowFilters() {
        FilterFragment fragment = new FilterFragment();
        fragment.show(getActivity().getSupportFragmentManager(), "");
    }

    // MARK: - Product Category Interface
    @Override
    public void onSelectedCategory(ProductCategory ProductCategory) {

    }

    // MARK: - Product List Interface
    @Override
    public void onSelectedProduct(Product product) {
        startActivity(new Intent(getActivity(), ProductDetailActivity.class));
    }
}
