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

    // Divide 1.0 by # of tabs needed
    // In this case: 1.0/2 => 0.5
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
        
        // Get inflator so we can start creating the custom view for tab
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        // Get tab manager
        tabHost = getTabHost();
        
        // This converts the custom tab view we created and injects it into the tab widget
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        // Mainly used to set the weight on the tab so each is equally wide
        tab.setLayoutParams(params);
        // Add some text to the tab
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("HOME");
        // Show a thick line under the selected tab (there are many ways to show
        // which tab is selected, I chose this)
        divider = (TextView) tab.findViewById(R.id.tabSelectedDivider);
        divider.setVisibility(View.VISIBLE);
        // Intent whose generated content will be added to the tab content area
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        // Just some data for the tab content activity to use (just for demonstrating changing content)
        intent.putExtra("content", "Content for HOME");
        // Finalize the tabs specification
        spec = tabHost.newTabSpec("home").setIndicator(tab).setContent(intent);
        // Add the tab to the tab manager
        tabHost.addTab(spec);
        
        
        // Add another tab
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        tab.setLayoutParams(params);
        label = (TextView) tab.findViewById(R.id.tabLabel);
        label.setText("USERS");
        intent = new Intent(TabTutorialActivity.this, TabContentActivity.class);
        intent.putExtra("content", "Content for USERS");
        spec = tabHost.newTabSpec("users").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
        
        
        // Listener to detect when a tab has changed. I added this just to show 
        // how you can change UI to emphasize the selected tab
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tag) {
                // reset some styles
                clearTabStyles();
                View tabView = null;
                // Use the "tag" for the tab spec to determine which tab is selected
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