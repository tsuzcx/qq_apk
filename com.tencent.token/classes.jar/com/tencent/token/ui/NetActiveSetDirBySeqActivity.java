package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class NetActiveSetDirBySeqActivity
  extends BaseActivity
{
  private int bindType;
  private View.OnClickListener mBindButtonListener = new ra(this);
  private View.OnClickListener mButtonListener = new qx(this);
  private View.OnClickListener mCompleteButtonListener = new qv(this);
  private String mCountryCode = "+86";
  private int mCountryIndex = -1;
  private View.OnClickListener mCountryListener = new qw(this);
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Dialog mDialog;
  UserTask mDnaBindTask = null;
  private Handler mHandler = new qu(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  private View mcountry;
  
  private void displayBindSuccess(boolean paramBoolean)
  {
    ag.c().i();
    Object localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    int i;
    if (this.mUpDetermin.mHaveMobile == 1)
    {
      i = 1;
      if (i != 0) {
        break label251;
      }
      if (!paramBoolean) {
        break label242;
      }
      setContentView(2130903052);
      label64:
      setTitle(2131361842);
      this.mBackArrow.setVisibility(4);
      ax.a().f(Long.parseLong((String)localObject));
      ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
      ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
      if (this.mUpDetermin.mHaveMobile != 1) {
        break label260;
      }
      i = 1;
      label158:
      if (i == 0)
      {
        localObject = (TextView)findViewById(2131296402);
        if (!paramBoolean) {
          break label265;
        }
        String str = getString(2131361843) + " ";
        ((TextView)localObject).setText(str + this.mMobile);
      }
    }
    for (;;)
    {
      a.a().a(8);
      return;
      i = 0;
      break;
      label242:
      setContentView(2130903051);
      break label64;
      label251:
      setContentView(2130903050);
      break label64;
      label260:
      i = 0;
      break label158;
      label265:
      ((Button)findViewById(2131296403)).setOnClickListener(this.mBindButtonListener);
      ((TextView)localObject).setText(getResources().getString(2131361832));
    }
  }
  
  private void init()
  {
    findViewById(2131296656).setOnClickListener(this.mButtonListener);
    this.mMobileText = ((EditText)findViewById(2131296655));
    if (this.mMobileText != null) {
      this.mMobileText.clearFocus();
    }
    this.mcountry = findViewById(2131296651);
    this.mcountry.setOnClickListener(this.mCountryListener);
    this.mCountry_name = ((TextView)findViewById(2131296652));
    this.mCountry_number = ((TextView)findViewById(2131296654));
    this.mIsActiveSuccess = false;
    if ((this.mUpDetermin.a() != 2) && (this.mUpDetermin.a() != 3)) {
      finish();
    }
  }
  
  public void cancelRequest()
  {
    af.a().a(getClass().getName());
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
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
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
    if (paramInt2 == 1111) {}
    for (paramIntent = "+1";; paramIntent = "+" + paramInt2)
    {
      this.mCountryCode = paramIntent;
      this.mCountryIndex = paramInt2;
      s.a(paramInt2, this.mCountry_name, this.mCountry_number);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    this.bindType = getIntent().getIntExtra("bindType", 2);
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    setContentView(2130903105);
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