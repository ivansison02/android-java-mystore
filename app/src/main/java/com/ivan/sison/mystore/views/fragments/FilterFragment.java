package com.ivan.sison.mystore.views.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ivan.sison.mystore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends BottomSheetDialogFragment implements View.OnClickListener {

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
}
