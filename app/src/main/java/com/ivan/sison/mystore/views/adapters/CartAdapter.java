package com.ivan.sison.mystore.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ivan.sison.mystore.R;
import com.ivan.sison.mystore.data.entities.Product;
import com.ivan.sison.mystore.utils.StringUtils;
import com.ivan.sison.mystore.utils.ViewUtils;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private int mViewType = ViewUtils.TYPE_GRID;
    private List<Product> mProducts = null;

    private Context mContext;
    private CartDelegate mInterface;

    public interface CartDelegate {
        void onSelectedProduct(Product product);
    }

    public CartAdapter(Context context, List<Product> products, CartDelegate delegate) {
        this.mContext = context;
        this.mProducts = products;
        this.mInterface = delegate;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cart_item, parent, false);
        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder holder, final int position) {
        final Product product = mProducts.get(position);

        int maxLength = 45;
        if (product.getName().length() > maxLength) holder.mTitle.setText(mContext.getString(R.string.txt_with_ellipsis, product.getName().substring(0, maxLength)));
        else holder.mTitle.setText(product.getName());

        holder.mPrice.setText(mContext.getString(R.string.txt_currency_php_w_val,
                StringUtils.getFormattedPrice(product.getPrice())));
        holder.mQty.setText(String.valueOf(holder.qty));

        holder.mAdd.setOnClickListener(onQtyBtnListener(holder));
        holder.mLess.setOnClickListener(onQtyBtnListener(holder));
    }

    private View.OnClickListener onQtyBtnListener(final ViewHolder holder) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.lyt_btn_add:
                        if (holder.qty < 10) {
                            holder.qty++;
                            holder.mQty.setText(String.valueOf(holder.qty));
                        }
                        break;
                    case R.id.lyt_btn_less:
                        if (holder.qty > 1) {
                            holder.qty--;
                            holder.mQty.setText(String.valueOf(holder.qty));
                        }
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public int getViewType() {
        return mViewType;
    }
    // MARK: - View
    public class ViewHolder extends RecyclerView.ViewHolder {

        private int qty = 1;

        private RadioButton mRb;
        private ImageView mImage;
        private TextView mTitle, mPrice, mQty;
        private ConstraintLayout mLess, mAdd;

        public ViewHolder(View view) {
            super(view);

            mRb = (RadioButton) view.findViewById(R.id.rb_item);
            mImage = (ImageView) view.findViewById(R.id.img_product);
            mTitle = (TextView) view.findViewById(R.id.txt_name);
            mPrice = (TextView) view.findViewById(R.id.txt_price);
            mQty = (TextView) view.findViewById(R.id.txt_qty);
            mLess = (ConstraintLayout) view.findViewById(R.id.lyt_btn_less);
            mAdd = (ConstraintLayout) view.findViewById(R.id.lyt_btn_add);
        }
    }
}
