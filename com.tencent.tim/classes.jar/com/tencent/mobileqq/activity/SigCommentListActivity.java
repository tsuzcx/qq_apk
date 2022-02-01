package com.tencent.mobileqq.activity;

import abgb;
import acfp;
import aclv;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import aqfo;
import aqiw;
import aurf;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import vuo;
import vup;
import vuq;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public abgb a;
  aclv a;
  TextView bI;
  private aurf d;
  View mEmptyView;
  XListView mListView;
  Drawable mLoadingDrawable;
  ImageView mO;
  
  public SigCommentListActivity()
  {
    this.jdField_a_of_type_Aclv = new vuo(this);
  }
  
  private void Bz(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        this.bI.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167385)));
        this.bI.setText(acfp.m(2131714538));
        this.mO.setImageDrawable(this.mLoadingDrawable);
        this.mLoadingDrawable.setVisible(true, true);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SigCommentListActivity", 2, localException1.toString());
          }
        }
      }
    }
    try
    {
      this.bI.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167385)));
      this.mLoadingDrawable.setVisible(false, false);
      this.mO.setImageResource(2130851444);
      if (paramInt == 3)
      {
        this.bI.setText(acfp.m(2131714539));
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException2.toString());
        }
      }
      this.bI.setText(acfp.m(2131714535));
    }
    try
    {
      this.bI.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166781)));
      this.bI.setOnClickListener(new vup(this));
      this.mO.setOnClickListener(new vuq(this));
      return;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException3.toString());
        }
      }
    }
  }
  
  public void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    Bz(1);
    Object localObject;
    if (aqiw.isNetSupport(this))
    {
      localObject = (SignatureHandler)this.app.getBusinessHandler(41);
      if (localObject != null) {
        ((SignatureHandler)localObject).FG(paramBoolean2);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        startTitleProgress();
      }
      return;
      localObject = this.d.obtainMessage(1, 1, 0);
      this.d.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_Abgb.Ha(2131720325);
    }
  }
  
  void bVw()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if ((localSystemBarCompact != null) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      if (!ThemeUtil.isInNightMode(getAppRuntime())) {
        break label80;
      }
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme())) {
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label80:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562247);
    super.setTitle(acfp.m(2131714536));
    this.leftView.setTextColor(getResources().getColor(2131165381));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840658));
    this.centerView.setTextColor(getResources().getColor(2131165381));
    bVw();
    this.mEmptyView = LayoutInflater.from(this).inflate(2131563110, this.mListView, false);
    this.mO = ((ImageView)this.mEmptyView.findViewById(2131366414));
    this.bI = ((TextView)this.mEmptyView.findViewById(2131366429));
    this.mLoadingDrawable = getResources().getDrawable(2130839657);
    this.mListView = ((XListView)findViewById(2131378395));
    this.mListView.setScrollbarFadingEnabled(true);
    this.mListView.setDivider(null);
    this.jdField_a_of_type_Abgb = new abgb(this, this.app, this.mListView, this.mEmptyView);
    this.mListView.setAdapter(this.jdField_a_of_type_Abgb);
    this.d = new aurf(this);
    this.app.setHandler(SigCommentListActivity.class, this.d);
    if (this.jdField_a_of_type_Aclv != null) {
      this.app.addObserver(this.jdField_a_of_type_Aclv);
    }
    paramBundle = this.d.obtainMessage(0, 1, 1);
    this.d.sendMessageDelayed(paramBundle, 500L);
    Bz(1);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aclv != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Aclv);
      this.jdField_a_of_type_Aclv = null;
    }
    this.app.removeHandler(SigCommentListActivity.class);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      if (paramMessage.arg1 == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramMessage.arg2 == 1) {
          bool2 = true;
        }
        aV(bool1, bool2);
        return true;
      }
      stopTitleProgress();
    } while (1 != paramMessage.arg1);
    if (isResume()) {
      QQToast.a(this, 0, getResources().getString(2131720326), 0).show(getTitleBarHeight());
    }
    Bz(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */