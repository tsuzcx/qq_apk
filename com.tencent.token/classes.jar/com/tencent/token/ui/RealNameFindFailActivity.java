package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RealNameFindFailActivity
  extends BaseActivity
{
  private boolean canchange_uin;
  private String mErrInfoString;
  private long mRealUin;
  private int mSourceId;
  
  private void initView()
  {
    this.mBackArrow.setVisibility(4);
    TextView localTextView1 = (TextView)findViewById(2131558753);
    TextView localTextView2 = (TextView)findViewById(2131558754);
    Button localButton = (Button)findViewById(2131558755);
    if (this.mSourceId == 1) {
      localTextView2.setText(2131231365);
    }
    for (;;)
    {
      if ((this.mErrInfoString != null) && (this.mErrInfoString.length() > 0)) {
        localTextView1.setText(this.mErrInfoString);
      }
      localButton.setOnClickListener(new ve(this));
      return;
      localTextView2.setText(2131231364);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968628);
    setNeverShowLockVerifyView();
    this.mSourceId = getIntent().getIntExtra("source_id", 0);
    this.mRealUin = getIntent().getLongExtra("real_uin", 0L);
    this.mErrInfoString = getIntent().getStringExtra("err_info");
    this.canchange_uin = getIntent().getBooleanExtra("canchange_uin", false);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameFindFailActivity
 * JD-Core Version:    0.7.0.1
 */