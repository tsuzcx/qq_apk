package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.tencent.token.af;
import java.util.ArrayList;

public class JLAppealListActivity
  extends BaseActivity
{
  private my adapter;
  private ArrayList appealInfo;
  private ListView listView;
  LinearLayout ll;
  private Handler mHandler = new mw(this);
  private af mTokenCore = af.a();
  ProgressBar pb;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903114);
    this.mTokenCore.j(0L, this.mHandler);
    this.listView = ((ListView)findViewById(2131296731));
    this.pb = ((ProgressBar)findViewById(2131296732));
    this.ll = ((LinearLayout)findViewById(2131296733));
    this.adapter = new my(this, this);
    this.listView.setAdapter(this.adapter);
    this.listView.setOnItemClickListener(new mv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JLAppealListActivity
 * JD-Core Version:    0.7.0.1
 */