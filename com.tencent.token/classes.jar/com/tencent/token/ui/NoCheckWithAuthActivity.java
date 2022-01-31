package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cx;
import com.tencent.token.do;

public class NoCheckWithAuthActivity
  extends BaseActivity
{
  private boolean bindMobileSucc;
  private boolean bindTokenSucc = false;
  private Handler mHandler = new rl(this);
  private boolean mIsActiveSuccess = false;
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  
  private void init()
  {
    findViewById(2131558743).setOnClickListener(new rm(this));
    findViewById(2131558744).setOnClickListener(new rn(this));
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    startActivity((Intent)localObject);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bindTokenSucc = getIntent().getBooleanExtra("bindTokenSucc", false);
    this.bindMobileSucc = getIntent().getBooleanExtra("bindMobileSucc", false);
    if (this.bindTokenSucc)
    {
      this.mUser = do.a().e();
      if (this.mUser == null) {
        finish();
      }
      return;
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    setContentView(2130968624);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NoCheckWithAuthActivity
 * JD-Core Version:    0.7.0.1
 */