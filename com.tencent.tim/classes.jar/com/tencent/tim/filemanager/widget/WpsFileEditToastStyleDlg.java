package com.tencent.tim.filemanager.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aufv;
import aufw;
import mqq.app.AppActivity;

public class WpsFileEditToastStyleDlg
  extends AppActivity
{
  public static int TYPE_ERROR = 2;
  public static int ert = 1;
  
  public static void a(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, WpsFileEditToastStyleDlg.class);
    localIntent.putExtra("text", paramString);
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("haveBtn", paramBoolean);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public void doOnBackPressed()
  {
    finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setTitle(null);
    setContentView(2131563381);
    paramBundle = (ImageView)findViewById(2131379948);
    TextView localTextView1 = (TextView)findViewById(2131379951);
    TextView localTextView2 = (TextView)findViewById(2131370917);
    String str = getIntent().getStringExtra("text");
    int j = getIntent().getIntExtra("type", 0);
    if (!getIntent().getBooleanExtra("haveBtn", false)) {
      localTextView2.setVisibility(8);
    }
    localTextView1.setText(str);
    int i = 2130850422;
    if (j == ert) {
      i = 2130850423;
    }
    for (;;)
    {
      paramBundle.setImageResource(i);
      localTextView2.setOnClickListener(new aufv(this));
      ((RelativeLayout)findViewById(2131377546)).setOnClickListener(new aufw(this));
      new Handler().postDelayed(new WpsFileEditToastStyleDlg.3(this), 3000L);
      return true;
      if (j == TYPE_ERROR) {
        i = 2130850421;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      doOnBackPressed();
      return true;
    }
    return false;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.WpsFileEditToastStyleDlg
 * JD-Core Version:    0.7.0.1
 */