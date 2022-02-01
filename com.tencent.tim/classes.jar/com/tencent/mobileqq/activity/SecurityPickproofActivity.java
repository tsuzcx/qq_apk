package com.tencent.mobileqq.activity;

import acfp;
import afka;
import aglz;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anot;
import aqil;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.a
{
  private TextView FD;
  public Long M = Long.valueOf(0L);
  public String aPQ = acfp.m(2131714175);
  private String aPR = "";
  private boolean bai;
  private boolean baj;
  private boolean bak;
  private Button dy;
  private boolean mIsDownloading;
  private TextView si;
  private View uI;
  public String url = "https://qqwx.qq.com/s?aid=index&g_f=436";
  
  private void bVk()
  {
    if (this.baj)
    {
      this.dy.setText(2131719396);
      this.si.setText(2131719393);
      this.FD.setText(2131696975);
      return;
    }
    this.dy.setText(2131719396);
    this.si.setText(2131719393);
    this.FD.setText(2131696975);
  }
  
  private JSONObject getSecurityPayIsOpenJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", aqil.bV(this));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void initParams()
  {
    if (getIntent().hasExtra("fromSecurityPay")) {
      this.bak = getIntent().getBooleanExtra("fromSecurityPay", false);
    }
    String str;
    if (getIntent().hasExtra("options"))
    {
      str = getIntent().getStringExtra("options");
      if (str == null) {}
    }
    try
    {
      this.bak = new JSONObject(str).getBoolean("fromSecurityPay");
      if (this.bak)
      {
        this.url = "https://qqwx.qq.com/s?aid=index&g_f=442";
        anot.a(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPickproofActivity", 2, "fromSecurityPay = " + this.bak);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void initUI()
  {
    if (this.bak) {
      setTitle(2131719397);
    }
    for (;;)
    {
      this.dy = ((Button)findViewById(2131363844));
      this.dy.setOnClickListener(this);
      this.uI = findViewById(2131366102);
      this.uI.setVisibility(8);
      this.FD = ((TextView)findViewById(2131380972));
      this.si = ((TextView)findViewById(2131380747));
      return;
      setTitle(2131696977);
    }
  }
  
  public boolean a(afka paramafka)
  {
    if (paramafka.resultCode == 0)
    {
      this.M = Long.valueOf(paramafka.cRp);
      if ((aqiw.isNetSupport(this)) && (this.M.longValue() > 0L))
      {
        paramafka = new Bundle();
        paramafka.putString("_filename_from_dlg", this.aPQ);
        paramafka.putLong("_filesize_from_dlg", this.M.longValue());
        paramafka.putString("big_brother_source_key", "biz_src_safe");
        paramafka.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        aglz.a().z(this.url, paramafka);
        return true;
      }
    }
    else
    {
      this.M = Long.valueOf(0L);
    }
    runOnUiThread(new SecurityPickproofActivity.2(this));
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563047);
    initParams();
    initUI();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mIsDownloading)
    {
      finish();
      return;
    }
    this.bai = aqil.bQ(this);
    if ((this.bak) && (!this.bai)) {
      this.url = "https://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.baj = aqil.bR(this);
    if (!this.bai)
    {
      if (aglz.a().ms(this.url))
      {
        this.mIsDownloading = true;
        this.si.setText(2131719374);
        this.dy.setVisibility(8);
        this.FD.setVisibility(8);
        this.uI.setVisibility(0);
        return;
      }
      this.dy.setVisibility(0);
      this.FD.setVisibility(0);
      this.uI.setVisibility(8);
      if (this.bak)
      {
        this.si.setText(2131719393);
        this.dy.setText(2131720400);
      }
      for (;;)
      {
        this.FD.setText(2131696971);
        return;
        this.dy.setText(2131696970);
      }
    }
    if ((aqil.bS(this)) || ((this.bak) && (!aqil.bU(this))))
    {
      if (aglz.a().ms(this.url))
      {
        this.mIsDownloading = true;
        this.si.setText(2131719374);
        this.dy.setVisibility(8);
        this.FD.setVisibility(8);
        this.uI.setVisibility(0);
        return;
      }
      this.dy.setVisibility(0);
      this.FD.setVisibility(0);
      this.uI.setVisibility(8);
      if (this.bak)
      {
        if (aqil.bT(this))
        {
          bVk();
          return;
        }
        this.si.setText(2131719393);
        this.dy.setText(2131719398);
        this.FD.setText(2131719392);
        return;
      }
      this.dy.setText(2131696970);
      this.FD.setText(2131696972);
      return;
    }
    if (this.bak)
    {
      bVk();
      return;
    }
    this.dy.setText(2131696974);
    this.FD.setText(2131696975);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.mIsDownloading == true) {
      finish();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.bak)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", getSecurityPayIsOpenJson().toString());
      setResult(-1, localIntent);
    }
    return super.onBackEvent();
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
      this.aPR = this.si.getText().toString();
      if ((!this.bai) || (aqil.bS(this)) || ((this.bak) && (!aqil.bU(this))))
      {
        if ((this.bak) && (aqil.bT(this)))
        {
          aqil.E(this, "mobileqq", 11862017);
          anot.a(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        }
        else
        {
          ThreadManager.executeOnNetWorkThread(new SecurityPickproofActivity.1(this));
          this.mIsDownloading = true;
          this.si.setText(2131719374);
          this.dy.setVisibility(8);
          this.FD.setVisibility(8);
          this.uI.setVisibility(0);
          if (this.bak)
          {
            if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.url)) {
              anot.a(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
            } else if ("https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.url)) {
              anot.a(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
            }
          }
          else if (aqil.bS(this)) {
            anot.a(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
          } else {
            anot.a(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
          }
        }
      }
      else if (this.bak)
      {
        aqil.E(this, "mobileqq", 11862017);
        anot.a(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        aqil.E(this, "mobileqq", 9109505);
        anot.a(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */