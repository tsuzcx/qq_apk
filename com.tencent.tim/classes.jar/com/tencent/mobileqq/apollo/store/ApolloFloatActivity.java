package com.tencent.mobileqq.apollo.store;

import ablp;
import abmt;
import abos;
import afjy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;

public class ApolloFloatActivity
  extends ApolloBaseActivity
{
  private boolean YA;
  private int crv = 1500;
  TextView er;
  private int mFrom;
  private int mGameId;
  private int mOrientation;
  
  private void cEG()
  {
    if (this.mFrom == 1)
    {
      if (this.mOrientation == 2) {
        ApolloUtil.j(this, 0, 0);
      }
    }
    else {
      return;
    }
    if (this.mOrientation == 3)
    {
      ApolloUtil.j(this, 4, 4);
      return;
    }
    ApolloUtil.j(this, 1, 1);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    overridePendingTransition(0, 0);
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (this.YA) {
      this.mNeedStatusTrans = false;
    }
    super.doOnCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.c = super.b(null);
    this.c.setBackgroundColor(0);
    Intent localIntent = super.getIntent();
    int i;
    if (localIntent != null)
    {
      this.mGameId = localIntent.getIntExtra("extra_key_gameid", -1);
      abos localabos = abmt.a(this.mGameId);
      i = localIntent.getIntExtra("extra_key_taskid", 0);
      if (localabos != null)
      {
        localabos.a(this, i);
        this.mFrom = localIntent.getIntExtra("extra_key_from", -1);
        if (this.mFrom != 1) {
          break label478;
        }
        getWindow().getDecorView().setSystemUiVisibility(5894);
        i = abmt.ga(localIntent.getIntExtra("extra_key_entratation", 1));
        setRequestedOrientation(i);
        localIntent.getIntExtra("extra_key_transparent", 1);
        this.crv = 0;
        this.mOrientation = localIntent.getIntExtra("extra_key_entratation", 1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloFloatActivity", 2, ((RelativeLayout.LayoutParams)localObject).width + "#" + ((RelativeLayout.LayoutParams)localObject).height + "#" + ((RelativeLayout.LayoutParams)localObject).leftMargin);
        }
        paramBundle.addView(this.c, (ViewGroup.LayoutParams)localObject);
        setRequestedOrientation(i);
        label256:
        if (this.c.getBackground() != null) {
          this.c.getBackground().setAlpha(0);
        }
        if (localIntent == null) {
          break label537;
        }
        localObject = localIntent.getStringExtra("extra_key_weburl");
        this.YP = ((String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label507;
        }
        this.mTimeBeforeLoadUrl = System.currentTimeMillis();
        this.c.loadUrl((String)localObject);
      }
    }
    label537:
    for (;;)
    {
      localObject = super.getResources();
      if (this.mSystemBarComp != null)
      {
        i = ((Resources)localObject).getColor(2131167595);
        this.mSystemBarComp.setStatusColor(i);
        this.mSystemBarComp.setStatusBarColor(i);
      }
      if (super.getIntent().getBooleanExtra("extra_key_close_btn", false)) {
        paramBundle.postDelayed(new ApolloFloatActivity.1(this, (Resources)localObject, paramBundle), this.crv);
      }
      super.setContentView(paramBundle);
      if (!this.YA) {
        super.hideTitleBar();
      }
      if (!afjy.a().ajq()) {
        afjy.a().a().doBindService(paramBundle.getContext().getApplicationContext());
      }
      this.onCreateTime = (System.currentTimeMillis() - this.mOnCreateMilliTimeStamp);
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloFloatActivity", 2, "[doOnCreate] can not found for id " + this.mGameId);
      break;
      label478:
      setRequestedOrientation(1);
      paramBundle.addView(this.c, (ViewGroup.LayoutParams)localObject);
      break label256;
      QLog.e("ApolloFloatActivity", 1, "[doOnCreate] intent is null background trans");
      break label256;
      label507:
      if (QLog.isColorLevel())
      {
        QQToast.a(this, "透明浮层url为空", 0).show();
        QLog.e("ApolloFloatActivity", 2, "ApolloFloat WebUrl is empty!");
        continue;
        if (QLog.isColorLevel()) {
          QQToast.a(this, "透明浮层url为空", 0).show();
        }
        QLog.e("ApolloFloatActivity", 2, "[doOnCreate] intent is null url null");
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mFrom == 1) {
      ablp.setActivityFullScreen(this);
    }
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.er)
    {
      super.onBackEvent();
      finish();
      cEG();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    this.YA = paramIntent.getBooleanExtra("extra_key_fullscreen", false);
    if (this.YA) {
      getWindow().setFlags(1024, 1024);
    }
    super.requestWindowFeature(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity
 * JD-Core Version:    0.7.0.1
 */