package com.ivan.sison.mystore.views.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ivan.sison.mystore.R;

import java.util.Set;

public class HomeActivity extends AppCompatActivity {

    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        setupNavigation();
    }

    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitle = (TextView) toolbar.findViewById(R.id.txt_title);
        setTitle("");
    }

    public void setActivityTitle(String title) {
        AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBar.setExpanded(true, false);
        txtTitle.setText(title);
    }

    public void onAddScrollFlags() {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyt_root);
        CoordinatorLayout.LayoutParams coordinatorLayoutParams = (CoordinatorLayout.LayoutParams) layout.getLayoutParams();
        coordinatorLayoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams toolbarLayoutParams = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        toolbarLayoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
    }

    public void onRemoveScrollFlags() {

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyt_root);
        CoordinatorLayout.LayoutParams coordinatorLayoutParams = (CoordinatorLayout.LayoutParams) layout.getLayoutParams();
        coordinatorLayoutParams.setBehavior(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams toolbarLayoutParams = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        toolbarLayoutParams.setScrollFlags(0);
    }

    public int getBottomBarHeight() {
        BottomNavigationView navView = findViewById(R.id.btm_nav_view);
        return navView.getHeight();
    }

    private void setupNavigation(){
        BottomNavigationView navView = findViewById(R.id.btm_nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_cart, R.id.navigation_account, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}

/*
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        setupNavigation();
    }

    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitle = (TextView) toolbar.findViewById(R.id.txt_title);
        setTitle("");
    }

    public void setActivityTitle(String title) {
        AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBar.setExpanded(true, false);
        txtTitle.setText(title);
    }

    public void setupNavigation(){
        BottomNavigationView navView = findViewById(R.id.btm_nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_cart, R.id.navigation_account, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
 */