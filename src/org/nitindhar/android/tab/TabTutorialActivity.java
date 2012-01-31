package org.nitindhar.android.tab;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class TabTutorialActivity extends TabActivity {

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
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("HOME");
        divider = (TextView) tab.findViewById(R.id.tabSelectedDivider);
        divider.setVisibility(View.VISIBLE);
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        spec = tabHost.newTabSpec("home").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
        
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("HOME");
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        spec = tabHost.newTabSpec("home").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
    }
}