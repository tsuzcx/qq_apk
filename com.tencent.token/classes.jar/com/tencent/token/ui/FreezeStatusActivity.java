package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.FreezeStatusResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.cn;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;

public class FreezeStatusActivity
  extends BaseActivity
{
  private boolean freeUinSucc = false;
  private String mA2 = null;
  private View.OnClickListener mDoFreezeUinAction = new jp(this);
  private Button mDoFreezeUinBtn;
  private View.OnClickListener mErrorAction = new js(this);
  private ErrorView mErrorView;
  public Handler mHandler = new jt(this);
  private RoundImageView mHeadPortrait;
  private View.OnClickListener mModPwdAction = new jq(this);
  private View.OnClickListener mModPwdH5Action = new jr(this);
  private FreezeStatusResult mResult;
  private boolean mSyncQQSigOK = false;
  private int mSyncQQSigSet;
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void judgeNextStep()
  {
    selectView(null);
    queryFreezeStatus();
  }
  
  private void setHeadPortait()
  {
    Object localObject = do.a().e();
    this.mHeadPortrait = ((RoundImageView)findViewById(2131558923));
    if (localObject != null) {
      this.mHeadPortrait.setImageDrawable(k.a(((QQUser)localObject).b() + "", ((QQUser)localObject).mUin + ""));
    }
    for (;;)
    {
      float f = getResources().getDimension(2131296375) / 2.0F;
      localObject = new cn(getResources().getColor(2131492926), 154, f, f, f);
      ((ImageView)findViewById(2131558925)).setBackgroundDrawable((Drawable)localObject);
      return;
      this.mHeadPortrait.setImageDrawable(getResources().getDrawable(2130837666));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        boolean bool;
        paramKeyEvent.printStackTrace();
        return true;
      }
      if (this.freeUinSucc) {
        break;
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      selectView(null);
      queryFreezeStatus();
    }
    while ((paramInt1 != 1201) && (paramInt1 != 1202)) {
      return;
    }
    cp.a(getApplicationContext()).a(paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    selectView(null);
    queryFreezeStatus();
  }
  
  void queryFreezeStatus()
  {
    if (do.a().k)
    {
      cw.a().n(0L, this.mHandler);
      return;
    }
    cw.a().b(this.mHandler);
  }
  
  public void selectView(Message paramMessage)
  {
    if (paramMessage != null) {
      h.a("selectview message=" + paramMessage + "msg.what=" + paramMessage.what + ",arg1=" + paramMessage.arg1);
    }
    if (paramMessage == null)
    {
      setContentView(2130968666);
      return;
    }
    if (paramMessage.arg1 != 0)
    {
      if (this.mErrorView == null)
      {
        this.mErrorView = new ErrorView(this);
        this.mErrorView.setAction(this.mErrorAction);
        addContentView(this.mErrorView);
      }
      this.mErrorView.setErrorType(paramMessage.arg1);
      this.mErrorView.setTag(Integer.valueOf(paramMessage.what));
      this.mErrorView.a();
      bringChildToFront(this.mErrorView);
      return;
    }
    h.a("statusstatus;" + this.mResult.mFreezeStatus);
    if (this.mResult.mFreezeStatus == 0)
    {
      setContentView(2130968667);
      this.mDoFreezeUinBtn = ((Button)findViewById(2131558930));
      this.mDoFreezeUinBtn.setOnClickListener(this.mDoFreezeUinAction);
      return;
    }
    if (this.mResult.mFreezeStatus == 1)
    {
      setContentView(2130968665);
      setHeadPortait();
      ((TextView)findViewById(2131558926)).setText(String.format(getString(2131231042), new Object[] { w.a(this.mResult.mAutoMeltTime * 1000L, '/') }));
      findViewById(2131558927).setOnClickListener(this.mModPwdAction);
      return;
    }
    if ((this.mResult.mFreezeStatus >= 2) && (this.mResult.mFreezeStatus <= 6))
    {
      setContentView(2130968668);
      setHeadPortait();
      paramMessage = (TextView)findViewById(2131558927);
      if (this.mResult.mFreezeStatus == 2)
      {
        paramMessage.setText(getResources().getString(2131231041));
        ((TextView)findViewById(2131558931)).setText(2131231056);
        findViewById(2131558927).setOnClickListener(this.mModPwdAction);
        return;
      }
      if (this.mResult.mFreezeStatus != 3) {
        ((TextView)findViewById(2131558931)).setText(2131231055);
      }
      paramMessage.setText(getResources().getString(2131231051));
      findViewById(2131558927).setOnClickListener(this.mModPwdH5Action);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FreezeStatusActivity
 * JD-Core Version:    0.7.0.1
 */