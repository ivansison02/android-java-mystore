package com.ivan.sison.mystore.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Product;
import com.ivan.sison.mystore.utils.StringUtils;
import com.ivan.sison.mystore.utils.ViewUtils;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private int mViewType = ViewUtils.TYPE_GRID;
    private List<Product> mProducts = null;

    private Context mContext;
    private ProductListDelegate mInterface;

    public interface ProductListDelegate {
        void onSelectedProduct(Product product);
    }

    public ProductListAdapter(Context context, List<Product> products, int viewType, ProductListDelegate delegate) {
        this.mContext = context;
        this.mProducts = products;
        this.mViewType = viewType;
        this.mInterface = delegate;
    }

    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (mViewType == ViewUtils.TYPE_GRID) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_product_item_grid, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_product_item_list, parent, false);
        }

        return new ProductListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductListAdapter.ViewHolder holder, final int position) {
        final Product product = mProducts.get(position);

        if (mViewType == ViewUtils.TYPE_GRID) {
            int maxLength = 45;
            if (product.getName().length() > maxLength) holder.mTitle.setText(mContext.getString(R.string.txt_with_ellipsis, product.getName().substring(0, maxLength)));
            else holder.mTitle.setText(product.getName());
        }
        else {
            int maxLength = 60;
            if (product.getName().length() > maxLength) holder.mTitle.setText(mContext.getString(R.string.txt_with_ellipsis, product.getName().substring(0, maxLength)));
            else holder.mTitle.setText(product.getName());
        }

        holder.mPrice.setText(mContext.getString(R.string.txt_currency_php_w_val,
                StringUtils.getFormattedPrice(product.getPrice())));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInterface.onSelectedProduct(product);
            }
        });

        /*if (position == mCurrentIndex) {
            int[][] states = new int[][] {
                    new int[] { android.R.attr.state_enabled}, // enabled
                    new int[] {-android.R.attr.state_enabled}, // disabled
                    new int[] {-android.R.attr.state_checked}, // unchecked
                    new int[] { android.R.attr.state_pressed}  // pressed
            };

            int[] colors = new int[] {
                    mView.getResources().getColor(R.color.colorCategoryActive),
                    mView.getResources().getColor(R.color.colorCategoryActive),
                    mView.getResources().getColor(R.color.colorCategoryActive),
                    mView.getResources().getColor(R.color.colorCategoryActive)
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
                    mView.getResources().getColor(R.color.colorCategoryInactive),
                    mView.getResources().getColor(R.color.colorCategoryInactive),
                    mView.getResources().getColor(R.color.colorCategoryInactive),
                    mView.getResources().getColor(R.color.colorCategoryInactive)
            };

            ColorStateList comboList = new ColorStateList(states, colors);
            holder.mLayout.setBackgroundTintList(comboList);
        }*/
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public int getViewType() {
        return mViewType;
    }

    public void onChangeViewType() {
        if (mViewType == ViewUtils.TYPE_GRID) mViewType = ViewUtils.TYPE_LIST;
        else mViewType = ViewUtils.TYPE_GRID;
        notifyDataSetChanged();
    }
    // MARK: - View
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle, mPrice;

        public ViewHolder(View view) {
            super(view);

            mTitle = (TextView) view.findViewById(R.id.txt_name);
            mPrice = (TextView) view.findViewById(R.id.txt_price);
        }
    }
}
