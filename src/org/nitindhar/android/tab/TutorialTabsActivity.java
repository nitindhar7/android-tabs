package org.nitindhar.android.tab;

import junit.framework.Test;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class TutorialTabsActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Intent intent = new Intent(this, Test.class);
        
        View tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        spec = tabHost.newTabSpec("tab").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
        
        tab = inflater.inflate(R.layout.tab, getTabWidget(), false);
        spec = tabHost.newTabSpec("tab").setIndicator(tab).setContent(intent);
        tabHost.addTab(spec);
    }
}