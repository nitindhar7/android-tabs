package org.nitindhar.android.tab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TabContentActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        // Get data passed in from the tab for display
        textview.setText(getIntent().getStringExtra("content"));
        setContentView(textview);
    }
}
