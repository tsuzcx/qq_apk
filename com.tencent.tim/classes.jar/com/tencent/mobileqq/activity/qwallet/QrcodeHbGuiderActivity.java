package com.tencent.mobileqq.activity.qwallet;

import acfp;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anpc;
import aqcv;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class QrcodeHbGuiderActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private TextView Nq;
  private TextView Nr;
  private Button X;
  private String bbm;
  private int bdj = 2;
  public boolean lg = true;
  private String mAppInfo;
  private long mReportSeq;
  private TextView mTitleText;
  private String mUin;
  
  private void init()
  {
    new ImmersionBar(this, -468046, findViewById(2131378716));
    initView();
    initParams();
    kJ();
  }
  
  private void initParams()
  {
    this.mUin = this.app.getCurrentUin();
    this.mAppInfo = getIntent().getStringExtra("app_info");
    this.mReportSeq = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.mReportSeq == 0L) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "GuiderAct.create", "", 0, null);
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("from_plugin");
      this.bbm = str;
      if ((!TextUtils.isEmpty(str)) && ("131".equals(str))) {
        this.bdj = 1;
      }
      if (TextUtils.isEmpty(str))
      {
        dY(QWalletHelper.readQRTokenConfig(this, this.mUin), "");
        this.lg = false;
        finish();
      }
      return;
      VACDReportUtil.b(this.mReportSeq, null, "GuiderAct.create", null, 0, null);
    }
  }
  
  private void initView()
  {
    this.X = ((Button)findViewById(2131374402));
    this.mTitleText = ((TextView)findViewById(2131369627));
    this.mTitleText.setText(acfp.m(2131712593));
    this.Nq = ((TextView)findViewById(2131369579));
    this.Nr = ((TextView)findViewById(2131369612));
    this.Nr.setText(acfp.m(2131712592));
  }
  
  private void kJ()
  {
    this.X.setOnClickListener(this);
    this.Nq.setOnClickListener(this);
    this.Nr.setOnClickListener(this);
  }
  
  public void csw()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", null, 0, null);
    Intent localIntent = new Intent();
    localIntent.setClass(this, SendHbActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", "2048");
      localJSONObject.put("recv_uin", this.mUin);
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("app_info", this.mAppInfo);
      localIntent.addFlags(536870912);
      localIntent.putExtra("vacreport_key_seq", l);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void csx()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.mUin);
      localJSONObject.put("viewTag", "redgiftRecord");
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("extra_data", new JSONObject().toString());
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.toString());
      localBundle.putString("callbackSn", "0");
      localBundle.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.a(this, 5, localBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void dY(String paramString1, String paramString2)
  {
    paramString2 = new JSONObject();
    if (TextUtils.isEmpty(this.mUin)) {
      return;
    }
    try
    {
      paramString2.put("userId", this.mUin);
      paramString2.put("viewTag", "qrcodeHb");
      paramString2.put("comeForm", 2);
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.putOpt("qrToken", paramString1);
      }
      paramString2.put("extra_data", localJSONObject.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", paramString2.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.a(this, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560723);
    init();
    zS("face2face.index.show");
    return true;
  }
  
  public void finish()
  {
    if ((this.lg) && (this.mReportSeq != 0L)) {
      VACDReportUtil.endReport(this.mReportSeq, "GuiderAct.finish", null, 0, null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      csw();
      zS("face2face.index.go");
      finish();
      continue;
      zS("face2face.index.back");
      finish();
      continue;
      csx();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      zS("face2face.index.keyback");
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void zS(String paramString)
  {
    String str = this.mUin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("||");
    localStringBuilder.append(this.bbm);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(aqcv.gP());
      localStringBuilder.append("|");
      localStringBuilder.append(this.bdj);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(this.mAppInfo)) {
        localStringBuilder.append(this.mAppInfo.replace("|", ","));
      }
      localStringBuilder.append("|");
      VACDReportUtil.b(this.mReportSeq, null, paramString, "op_type=" + this.bbm, 0, "");
      anpc.a(BaseApplication.getContext()).i(this.app, localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity
 * JD-Core Version:    0.7.0.1
 */