package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.cx;

public class VerifyMobilePhoneActivity
  extends BaseActivity
{
  private EditText et;
  private boolean isFirstFactor = false;
  public Handler mHandler = new aeu(this);
  private boolean mIsActiveSuccess = false;
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      ((Intent)localObject).putExtra("mSourceId", 1);
    }
    startActivity((Intent)localObject);
    finish();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0)) {}
          switch (paramKeyEvent.getKeyCode())
          {
          case 4: 
            return super.dispatchKeyEvent(paramKeyEvent);
          }
          break;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      startActivity(abi.a().a(this));
      return true;
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    setContentView(2130968623);
    ((TextView)findViewById(2131558736)).setText(this.mVerifyResult.g());
    this.et = ((EditText)findViewById(2131558737));
    if (this.et != null) {
      this.et.clearFocus();
    }
    ((Button)findViewById(2131558738)).setOnClickListener(new aer(this));
    ((TextView)findViewById(2131558740)).setOnClickListener(new aet(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    abi.c();
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new aez(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.VerifyMobilePhoneActivity
 * JD-Core Version:    0.7.0.1
 */