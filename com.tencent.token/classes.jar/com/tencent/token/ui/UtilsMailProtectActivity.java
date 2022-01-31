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
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.fm;
import com.tencent.token.fp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.dk;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import java.util.ArrayList;

public class UtilsMailProtectActivity
  extends BaseActivity
{
  private String A2;
  private g curOpItem;
  private LinearLayout ll;
  private View ll_contentView;
  private LinearLayout ll_tips;
  private View.OnClickListener mBindListener = new aei(this);
  private SwitchButton mCommonProtectCB;
  private ProgressBar mCommonProtectProgress;
  private View mContentView;
  private ErrorView mErrorView;
  private Handler mHandler = new aem(this);
  private TextView mMailNameText;
  private dk mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new aej(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  private TextView tv_del_tip;
  
  private View createTableCol(DeviceInfo paramDeviceInfo)
  {
    View localView = getLayoutInflater().inflate(2130903229, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131297200);
    TextView localTextView2 = (TextView)localView.findViewById(2131297201);
    localTextView1.setText(paramDeviceInfo.dname);
    localTextView2.setText(paramDeviceInfo.dtype);
    localView.setOnClickListener(new aeq(this, paramDeviceInfo));
    return localView;
  }
  
  private void init()
  {
    this.mMailNameText = ((TextView)findViewById(2131297235));
    this.ll_contentView = findViewById(2131296909);
    this.mProgressView = findViewById(2131296911);
    this.ll = ((LinearLayout)findViewById(2131296910));
    this.ll_tips = ((LinearLayout)findViewById(2131297238));
    this.tv_del_tip = ((TextView)findViewById(2131297240));
    this.mContentView = findViewById(2131297234);
    this.mCommonProtectCB = ((SwitchButton)findViewById(2131297236));
    this.mCommonProtectProgress = ((ProgressBar)findViewById(2131297237));
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
    this.mCommonProtectCB.setOnCheckedChangeListener(new ael(this));
    refreshContentView();
  }
  
  private void modifyPhone()
  {
    Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
    localIntent.putExtra("op_type", 1);
    localIntent.putExtra("title", getResources().getString(2131361849));
    localIntent.putExtra("page_id", 10);
    startActivity(localIntent);
  }
  
  private void queryCommonProtectStatus()
  {
    if (this.A2 == null) {
      return;
    }
    refreshContentView();
    af.a().b(0L, 70, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", this.A2, this.mHandler);
  }
  
  private void refreshContentView()
  {
    boolean bool = true;
    this.mContentView.setVisibility(0);
    Object localObject1 = ba.a().h();
    Object localObject2;
    if (((g)localObject1).e)
    {
      this.mCommonProtectProgress.setVisibility(0);
      this.mCommonProtectCB.setVisibility(0);
      this.mCommonProtectCB.setEnabled(false);
      if ((((g)localObject1).b != null) && (((g)localObject1).b.length() > 0)) {
        this.mMailNameText.setText(((g)localObject1).b);
      }
      if (!((g)localObject1).c) {
        break label263;
      }
      localObject1 = ba.a().f.b;
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
      if (!((g)localObject1).c) {}
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
    label263:
    this.ll.setVisibility(8);
    this.ll.removeAllViews();
    this.ll_tips.setVisibility(8);
    this.tv_del_tip.setVisibility(8);
  }
  
  private void setCommonProtectStatus()
  {
    g localg = ba.a().h();
    if (localg.e) {
      return;
    }
    localg.e = true;
    refreshContentView();
    handleCommonProtect();
  }
  
  private void showTipDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(paramString);
  }
  
  private void showTipView(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.a(paramInt);
    if (paramBoolean) {
      this.mErrorView.a(this.mBindListener);
    }
    for (;;)
    {
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      return;
      this.mErrorView.a(this.mRetryListener);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
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
    Object localObject = ba.a().h();
    int j = ((g)localObject).a;
    if (((g)localObject).c) {}
    for (int i = 0;; i = 1)
    {
      UtilsLoginProtectActivity.mNeedRefreshLoginProtect = true;
      AccountPageActivity.mNeedRefreshEval = true;
      localObject = af.a();
      String str = this.A2;
      Handler localHandler = this.mHandler;
      ((af)localObject).b(0L, new int[] { j }, new int[] { i }, str, localHandler);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, 2);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new aek(this));
      ba.a().h.a("mail_protect").a();
      return;
      setContentView(2130903239);
      init();
      byte[] arrayOfByte = x.a(RqdApplication.i()).a(ax.a().e().mRealUin);
      if (arrayOfByte != null)
      {
        this.A2 = s.a(arrayOfByte);
        queryCommonProtectStatus();
      }
      else
      {
        x.a(RqdApplication.i()).a(this, "" + paramBundle.mRealUin, this.mHandler, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMailProtectActivity
 * JD-Core Version:    0.7.0.1
 */