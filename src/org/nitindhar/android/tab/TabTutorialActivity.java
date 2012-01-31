package org.nitindhar.android.tab;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class TabTutorialActivity extends TabActivity {

    private static final LayoutParams params = new LinearLayout.LayoutParams(
            LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0.5f);
    
    private static TabHost tabHost;
    private static TabHost.TabSpec spec;
    private static Intent intent;
    private static LayoutInflater inflater;
    
    private View tab;
    private TextView label;
    private TextView divider;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tabHost = getTabHost();
        
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        tab.setLayoutParams(params);
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("HOME");
        divider = (TextView) tab.findViewById(R.id.tabSelectedDivider);
        divider.setVisibility(View.VISIBLE);
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        intent.putExtra("content", "Content for HOME");
        spec = tabHost.newTabSpec("home").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
        
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        tab.setLayoutParams(params);
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("USERS");
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        intent.putExtra("content", "Content for USERS");
        spec = tabHost.newTabSpec("users").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tag) {
                clearTabStyles();
                View tabView = null;
                if (tag.equals("home")) {
                    tabView = getTabWidget().getChildAt(0);
                }
                else if (tag.equals("users")) {
                    tabView = getTabWidget().getChildAt(1);
                }
                tabView.findViewById(R.id.tabSelectedDivider).setVisibility(View.VISIBLE);
            }       
        });
    }
    
    private void clearTabStyles() {
        for (int i = 0; i < getTabWidget().getChildCount(); i++) {
            tab = getTabWidget().getChildAt(i);
            tab.findViewById(R.id.tabSelectedDivider).setVisibility(View.GONE);
        }
    }
}