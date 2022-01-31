package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.ep;
import com.tencent.token.es;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dd;
import com.tencent.token.utils.w;
import java.util.ArrayList;

public class UtilsMailProtectActivity
  extends BaseActivity
{
  private String A2 = null;
  private com.tencent.token.core.bean.h curOpItem;
  private LinearLayout ll;
  private View ll_contentView;
  private LinearLayout ll_tips;
  private SwitchButton mCommonProtectCB;
  private ProgressBar mCommonProtectProgress;
  private View mContentView;
  private ErrorView mErrorView;
  private Handler mHandler = new acz(this);
  private TextView mMailNameText;
  private dd mNeedVerifyView;
  private View mProgressView;
  private boolean mQueryMobile = false;
  private View.OnClickListener mRetryListener = new acw(this);
  private TextView tv_del_tip;
  
  private View createTableCol(DeviceInfo paramDeviceInfo)
  {
    View localView = getLayoutInflater().inflate(2130968792, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131559360);
    TextView localTextView2 = (TextView)localView.findViewById(2131559361);
    localTextView1.setText(paramDeviceInfo.dname);
    localTextView2.setText(paramDeviceInfo.dtype);
    localView.setOnClickListener(new adf(this, paramDeviceInfo));
    return localView;
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void init()
  {
    this.mMailNameText = ((TextView)findViewById(2131559394));
    this.ll_contentView = findViewById(2131559117);
    this.mProgressView = findViewById(2131559119);
    this.ll = ((LinearLayout)findViewById(2131559118));
    this.ll_tips = ((LinearLayout)findViewById(2131559397));
    this.tv_del_tip = ((TextView)findViewById(2131559399));
    this.mContentView = findViewById(2131559393);
    this.mCommonProtectCB = ((SwitchButton)findViewById(2131559395));
    this.mCommonProtectProgress = ((ProgressBar)findViewById(2131559396));
    this.mCommonProtectCB.setOnCheckedChangeListener(new acy(this));
    refreshContentView();
  }
  
  private void judgeNextStep()
  {
    queryCommonProtectStatus();
  }
  
  private void modifyPhone()
  {
    Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
    localIntent.putExtra("op_type", 1);
    localIntent.putExtra("title", getResources().getString(2131230869));
    localIntent.putExtra("page_id", 10);
    startActivity(localIntent);
  }
  
  private void queryCommonProtectStatus()
  {
    refreshContentView();
    QQUser localQQUser = do.a().e();
    if (localQQUser == null)
    {
      finish();
      return;
    }
    if (!this.mQueryMobile)
    {
      cw.a().e(0L, this.mHandler);
      return;
    }
    cp localcp = cp.a(RqdApplication.l());
    byte[] arrayOfByte = localcp.b(do.a().e().mRealUin);
    com.tencent.token.global.h.a("mailprotect data=" + arrayOfByte);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (!localcp.b("" + localQQUser.mRealUin, 523005419L)))
    {
      this.A2 = w.a(arrayOfByte);
      cw.a().a(0L, 70, w.a(cp.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", this.A2, this.mHandler);
      return;
    }
    cp.a(RqdApplication.l()).a("" + localQQUser.mRealUin, this.mHandler, 523005419L, 64);
  }
  
  private void refreshContentView()
  {
    boolean bool = true;
    this.mContentView.setVisibility(0);
    Object localObject1 = dr.a().h();
    com.tencent.token.global.h.a("busybusy:" + ((com.tencent.token.core.bean.h)localObject1).e);
    Object localObject2;
    if (((com.tencent.token.core.bean.h)localObject1).e)
    {
      this.mCommonProtectProgress.setVisibility(0);
      this.mCommonProtectCB.setVisibility(0);
      this.mCommonProtectCB.setEnabled(false);
      if ((((com.tencent.token.core.bean.h)localObject1).b != null) && (((com.tencent.token.core.bean.h)localObject1).b.length() > 0)) {
        this.mMailNameText.setText(((com.tencent.token.core.bean.h)localObject1).b);
      }
      if (!((com.tencent.token.core.bean.h)localObject1).c) {
        break label289;
      }
      localObject1 = dr.a().f.b;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.ll_tips.setVisibility(0);
        this.ll.setVisibility(0);
        this.ll.removeAllViews();
        int i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localObject2 = (DeviceInfo)((ArrayList)localObject1).get(i);
          this.ll.addView(createTableCol((DeviceInfo)localObject2));
          i += 1;
        }
      }
    }
    else
    {
      this.mCommonProtectProgress.setVisibility(4);
      this.mCommonProtectCB.setVisibility(0);
      this.mCommonProtectCB.setEnabled(true);
      localObject2 = this.mCommonProtectCB;
      if (!((com.tencent.token.core.bean.h)localObject1).c) {}
      for (;;)
      {
        ((SwitchButton)localObject2).a(bool, false);
        break;
        bool = false;
      }
      this.tv_del_tip.setVisibility(0);
      return;
    }
    this.ll_tips.setVisibility(8);
    this.ll.setVisibility(8);
    this.ll.removeAllViews();
    this.tv_del_tip.setVisibility(8);
    return;
    label289:
    this.ll.setVisibility(8);
    this.ll.removeAllViews();
    this.ll_tips.setVisibility(8);
    this.tv_del_tip.setVisibility(8);
  }
  
  private void setCommonProtectStatus()
  {
    com.tencent.token.core.bean.h localh = dr.a().h();
    if (localh.e) {
      return;
    }
    localh.e = true;
    refreshContentView();
    handleCommonProtect();
  }
  
  private void showTipView(int paramInt)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.setErrorType(paramInt);
    this.mErrorView.setAction(this.mRetryListener);
    this.mErrorView.a();
    bringChildToFront(this.mErrorView);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((c.f()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      finish();
      return true;
    }
  }
  
  public void handleCommonProtect()
  {
    Object localObject = dr.a().h();
    int j = ((com.tencent.token.core.bean.h)localObject).a;
    if (((com.tencent.token.core.bean.h)localObject).c) {}
    for (int i = 0;; i = 1)
    {
      UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
      AccountPageActivity.mNeedRefreshEval = true;
      localObject = cw.a();
      String str = this.A2;
      Handler localHandler = this.mHandler;
      ((cw)localObject).a(0L, new int[] { j }, new int[] { i }, str, localHandler);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, 3);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new acx(this));
      dr.a().h.a("mail_protect").a();
      return;
      setContentView(2130968802);
      init();
      queryCommonProtectStatus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMailProtectActivity
 * JD-Core Version:    0.7.0.1
 */