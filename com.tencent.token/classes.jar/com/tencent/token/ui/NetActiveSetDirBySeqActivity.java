package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;

public class NetActiveSetDirBySeqActivity
  extends BaseActivity
{
  private int bindType;
  private View.OnClickListener mButtonListener = new qh(this);
  private View.OnClickListener mCompleteButtonListener = new qf(this);
  private String mCountryCode = "+86";
  private int mCountryIndex = -1;
  private View.OnClickListener mCountryListener = new qg(this);
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Dialog mDialog;
  UserTask mDnaBindTask = null;
  private Handler mHandler = new qe(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  private QQUser mUser;
  private int mVerifyFactorId = -1;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private View mcountry;
  
  private void displayBindSuccess(boolean paramBoolean)
  {
    cx.c().i();
    String str = this.mUser.mRealUin + "";
    Intent localIntent = new Intent(this, VerifySuccActivity.class);
    localIntent.putExtra("mRealUin", Long.parseLong(str));
    localIntent.putExtra("mMobile", this.mMobile);
    if (!this.mVerifyResult.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isHaveMobie", bool);
      localIntent.putExtra("bindMobileSucc", paramBoolean);
      if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
        localIntent.putExtra("mSourceId", 1);
      }
      startActivity(localIntent);
      finish();
      return;
    }
  }
  
  private void init()
  {
    findViewById(2131558965).setOnClickListener(this.mButtonListener);
    this.mMobileText = ((EditText)findViewById(2131558964));
    if (this.mMobileText != null) {
      this.mMobileText.clearFocus();
    }
    this.mcountry = findViewById(2131558960);
    this.mcountry.setOnClickListener(this.mCountryListener);
    this.mCountry_name = ((TextView)findViewById(2131558961));
    this.mCountry_number = ((TextView)findViewById(2131558963));
    this.mIsActiveSuccess = false;
    if (this.mVerifyResult.b()) {
      finish();
    }
  }
  
  public void cancelRequest()
  {
    cw.a().a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = ("+" + paramInt2);
    this.mCountry_name.setText(paramIntent);
    this.mCountry_number.setText(this.mCountryCode);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.bindType = getIntent().getIntExtra("bindType", 2);
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    if ((this.mUser == null) || (this.mVerifyResult == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    if (this.mVerifyFactorId != -1)
    {
      if (this.mVerifyType == null)
      {
        finish();
        return;
      }
      this.bindType = this.mVerifyType.a();
    }
    setContentView(2130968676);
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveSetDirBySeqActivity
 * JD-Core Version:    0.7.0.1
 */