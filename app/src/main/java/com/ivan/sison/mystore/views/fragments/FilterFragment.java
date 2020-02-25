package com.ivan.sison.mystore.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Supplier;
import com.ivan.sison.mystore.utils.DummyUtils;
import com.ivan.sison.mystore.utils.ViewUtils;
import com.ivan.sison.mystore.views.adapters.ManufacturerAdapter;
import com.ivan.sison.mystore.views.adapters.ProductCategoryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends BottomSheetDialogFragment implements View.OnClickListener, ManufacturerAdapter.ManufacturerDelegate {

    private View mView;

    public FilterFragment() {
        // Required empty public constructor
    }

    public interface FilterDelegate{
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_filter, container, false);

        Button btnApply = (Button) mView.findViewById(R.id.btn_apply);
        btnApply.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.rcy_manufacturer);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);

        ManufacturerAdapter mAdapter = new ManufacturerAdapter(getContext(), DummyUtils.getSuppliers(), this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        return mView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apply:
                onApplyFilters();
                break;
            default:
                break;
        }
    }

    private void onApplyFilters() {
        dismiss();
    }

    // MARK: - Manufacturer Interface
    @Override
    public void onSelectedCategory(Supplier Supplier) {

    }
}
