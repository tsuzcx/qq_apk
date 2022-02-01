package com.tencent.biz.lebasearch;

import acci;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqju;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import jsb;
import jsc;
import skj;

public class LebaSearchMoreInfoActivity
  extends AbsBaseWebViewActivity
{
  FrameLayout U;
  public String Ui;
  public acci b = new jsc(this);
  View iH;
  public skj mClient;
  Handler mHandler = new jsb(this);
  public boolean mIsOpen = false;
  public String mPluginName = null;
  String mUrl;
  TextView nq;
  aqju q = null;
  long qx;
  
  private void azg()
  {
    if (this.mIsOpen) {}
    label104:
    label244:
    label247:
    for (;;)
    {
      return;
      if (this.Ui == null)
      {
        this.iH.setVisibility(8);
        return;
      }
      SharedPreferences localSharedPreferences = getSharedPreferences("leba_search_more_config", 0);
      String str;
      if (this.app == null)
      {
        str = "";
        if (TextUtils.isEmpty(this.Ui)) {
          break label232;
        }
        this.nq.setText(this.Ui);
        this.nq.setContentDescription(this.Ui + ";" + getString(2131698276));
        long l = localSharedPreferences.getLong("time_" + str + "_" + this.qx, 0L);
        if (System.currentTimeMillis() - l <= 86400000L) {
          break label244;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label247;
        }
        localSharedPreferences.edit().putLong("time_" + str + "_" + this.qx, System.currentTimeMillis());
        this.iH.setVisibility(0);
        return;
        str = this.app.getAccount();
        break;
        this.nq.setContentDescription("");
        break label104;
      }
    }
  }
  
  private void initData()
  {
    this.mClient = skj.a();
    this.mClient.bzj();
    this.mClient.addObserver(this.b);
    Intent localIntent = getIntent();
    if (localIntent == null) {
      finish();
    }
    do
    {
      return;
      this.mUrl = localIntent.getStringExtra("url");
      this.qx = localIntent.getLongExtra("id", -1L);
    } while (!TextUtils.isEmpty(this.mUrl));
    finish();
  }
  
  private void initUI()
  {
    this.iH = findViewById(2131373426);
    this.iH.setVisibility(8);
    this.nq = ((TextView)this.iH.findViewById(2131372411));
    this.nq.setCompoundDrawables(null, null, null, null);
    this.iH.setOnClickListener(this);
    Object localObject = (ImageView)this.iH.findViewById(2131372409);
    ((ImageView)localObject).setImageResource(2130848316);
    ((ImageView)localObject).setOnClickListener(this);
    this.U = ((FrameLayout)findViewById(2131382159));
    this.mHandler.post(new LebaSearchMoreInfoActivity.2(this));
    if (this.qx != -1L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("uiResId", this.qx);
      this.mClient.a(18, (Bundle)localObject, this.b);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560008);
    initData();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.mClient != null)
    {
      this.mClient.bzk();
      this.mClient.removeObserver(this.b);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.iH.setVisibility(8);
      if (this.q == null) {
        this.q = Utils.createPluginSetDialogForWeb(this, this.mClient, this.b, 1, this.qx, this.mPluginName, null);
      }
      if (this.q.isShowing()) {
        this.q.dismiss();
      }
      this.q.show();
      continue;
      this.iH.setVisibility(8);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */