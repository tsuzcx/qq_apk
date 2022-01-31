package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.push.a;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

public class VerifyMobilePhoneActivity
  extends BaseActivity
{
  private EditText et;
  private View.OnClickListener mCompleteButtonListener = new agl(this);
  public Handler mHandler = new agg(this);
  private boolean mIsActiveSuccess = false;
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = ag.c();
    ((ag)localObject).i();
    ((ag)localObject).n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    setContentView(2130903050);
    this.mBackArrow.setVisibility(4);
    ax.a().f(Long.parseLong((String)localObject));
    ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
    setTitle(2131361842);
    ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
    a.a().a(8);
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
        return true;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903060);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    ((TextView)findViewById(2131296452)).setText(this.mUpDetermin.mMobileMask);
    this.et = ((EditText)findViewById(2131296453));
    if (this.et != null) {
      this.et.clearFocus();
    }
    ((Button)findViewById(2131296454)).setOnClickListener(new agd(this));
    ((TextView)findViewById(2131296455)).setOnClickListener(new agf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.VerifyMobilePhoneActivity
 * JD-Core Version:    0.7.0.1
 */