package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
    TextView localTextView = (TextView)findViewById(2131165907);
    Object localObject = (TextView)findViewById(2131165902);
    Button localButton = (Button)findViewById(2131165901);
    if (this.mSourceId == 1) {
      ((TextView)localObject).setText(2131493508);
    } else {
      ((TextView)localObject).setText(2131493507);
    }
    localObject = this.mErrInfoString;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localTextView.setText(this.mErrInfoString);
    }
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RealNameFindFailActivity.this.mSourceId == 1)
        {
          paramAnonymousView = new Intent(RealNameFindFailActivity.this, FindPasswdActivity.class);
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("real_uin", RealNameFindFailActivity.this.mRealUin);
          paramAnonymousView.putExtra("not_showLockVerify", true);
          paramAnonymousView.putExtra("canchange_uin", RealNameFindFailActivity.this.canchange_uin);
          RealNameFindFailActivity.this.startActivity(paramAnonymousView);
          return;
        }
        RealNameFindFailActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296308);
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