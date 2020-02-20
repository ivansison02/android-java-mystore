package com.ivan.sison.mystore.views.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.ProductCategory;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder> {

    private int mCurrentIndex = 0;
    private List<ProductCategory> mProductCategories = null;

    private Context mContext;
    private ProductCategoryDelegate mInterface;

    public interface ProductCategoryDelegate {
        void onSelectedCategory(ProductCategory ProductCategory);
    }

    public ProductCategoryAdapter(Context context, List<ProductCategory> categories, ProductCategoryDelegate delegate) {
        this.mContext = context;
        this.mProductCategories = categories;
        this.mInterface = delegate;
    }

    @Override
    public ProductCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category_item, parent, false);
        return new ProductCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductCategoryAdapter.ViewHolder holder, final int position) {
        final ProductCategory category = mProductCategories.get(position);
        holder.mTitle.setText(category.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = position;
                notifyDataSetChanged();
                mInterface.onSelectedCategory(category);
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
        return mProductCategories.size();
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