package com.ivan.sison.mystore.views.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Supplier;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ManufacturerAdapter extends RecyclerView.Adapter<ManufacturerAdapter.ViewHolder> {

    private int mCurrentIndex = 0;
    private List<Supplier> mSuppliers = null;

    private Context mContext;
    private ManufacturerDelegate mInterface;

    public interface ManufacturerDelegate {
        void onSelectedCategory(Supplier Supplier);
    }

    public ManufacturerAdapter(Context context, List<Supplier> categories, ManufacturerDelegate delegate) {
        this.mContext = context;
        this.mSuppliers = categories;
        this.mInterface = delegate;
    }

    @Override
    public ManufacturerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category_item, parent, false);
        return new ManufacturerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ManufacturerAdapter.ViewHolder holder, final int position) {
        final Supplier supplier = mSuppliers.get(position);
        holder.mTitle.setText(supplier.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = position;
                notifyDataSetChanged();
                mInterface.onSelectedCategory(supplier);
            }
        });

        if (position == mCurrentIndex) {
            int[][] states = new int[][] {
                    new int[] { android.R.attr.state_enabled}, // enabled
                    new int[] {-android.R.attr.state_enabled}, // disabled
                    new int[] {-android.R.attr.state_checked}, // unchecked
                    new int[] { android.R.attr.state_pressed}  // pressed
            };

            int[] colors = new int[] {
                    mContext.getResources().getColor(R.color.colorCategoryActive),
                    mContext.getResources().getColor(R.color.colorCategoryActive),
                    mContext.getResources().getColor(R.color.colorCategoryActive),
                    mContext.getResources().getColor(R.color.colorCategoryActive)
            };

            ColorStateList comboList = new ColorStateList(states, colors);
            holder.mLayout.setBackgroundTintList(comboList);
        }
        else {
            int[][] states = new int[][] {
                    new int[] { android.R.attr.state_enabled}, // enabled
                    new int[] {-android.R.attr.state_enabled}, // disabled
                    new int[] {-android.R.attr.state_checked}, // unchecked
                    new int[] { android.R.attr.state_pressed}  // pressed
            };

            int[] colors = new int[] {
                    mContext.getResources().getColor(R.color.colorCategoryInactive),
                    mContext.getResources().getColor(R.color.colorCategoryInactive),
                    mContext.getResources().getColor(R.color.colorCategoryInactive),
                    mContext.getResources().getColor(R.color.colorCategoryInactive)
            };

            ColorStateList comboList = new ColorStateList(states, colors);
            holder.mLayout.setBackgroundTintList(comboList);
        }
    }

    @Override
    public int getItemCount() {
        return mSuppliers.size();
    }

    // MARK: - View
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout mLayout;
        private TextView mTitle;

        public ViewHolder(View view) {
            super(view);

            mLayout = (ConstraintLayout) view.findViewById(R.id.lyt_root);
            mTitle = (TextView) view.findViewById(R.id.txt_title);
        }
    }
}
