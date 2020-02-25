package com.ivan.sison.mystore.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.views.activities.AboutActivity;
import com.ivan.sison.mystore.views.activities.ContactUsActivity;
import com.ivan.sison.mystore.views.activities.HomeActivity;
import com.ivan.sison.mystore.views.activities.PolicyActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {

    private View mView;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_more, container, false);

        setupMenu(R.id.lyt_menu_policies, getString(R.string.txt_policies));
        setupMenu(R.id.lyt_menu_contact, getString(R.string.txt_contact_us));
        setupMenu(R.id.lyt_menu_about, getString(R.string.txt_about));

        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();

        ((HomeActivity) getActivity()).setActivityTitle(getString(R.string.title_more));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_menu_policies:
                startActivity(new Intent(getContext(), PolicyActivity.class));
                break;
            case R.id.lyt_menu_contact:
                startActivity(new Intent(getContext(), ContactUsActivity.class));
                break;
            case R.id.lyt_menu_about:
                startActivity(new Intent(getContext(), AboutActivity.class));
                break;
            default:
                break;
        }
    }

    private void setupMenu(int layout_id, String title) {
        View viewLayout = (View) mView.findViewById(layout_id);
        viewLayout.setOnClickListener(this);

        TextView txtTitle = (TextView) viewLayout.findViewById(R.id.txt_title);
        txtTitle.setText(title);
    }
}
