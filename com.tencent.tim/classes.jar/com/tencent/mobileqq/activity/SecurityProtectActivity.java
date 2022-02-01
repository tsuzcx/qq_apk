package com.tencent.mobileqq.activity;

import acfp;
import afka;
import aglz;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqil;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SecurityProtectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.a
{
  private TextView FE;
  private TextView FF;
  public Long M = Long.valueOf(0L);
  public String aPQ = acfp.m(2131714174);
  private boolean bai;
  private boolean baj;
  private Button dz;
  private boolean mIsDownloading;
  String mUrl = "https://qqwx.qq.com/s?aid=index&g_f=407";
  private ImageView re;
  
  public boolean a(afka paramafka)
  {
    if (paramafka.resultCode == 0)
    {
      this.M = Long.valueOf(paramafka.cRp);
      if ((aqiw.isNetSupport(getActivity())) && (this.M.longValue() > 0L))
      {
        paramafka = new Bundle();
        paramafka.putString("_filename_from_dlg", this.aPQ);
        paramafka.putLong("_filesize_from_dlg", this.M.longValue());
        paramafka.putString("big_brother_source_key", "biz_src_safe");
        paramafka.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_safe");
        aglz.a().z(this.mUrl, paramafka);
        return true;
      }
    }
    else
    {
      this.M = Long.valueOf(0L);
    }
    new Handler(Looper.getMainLooper()).post(new SecurityProtectActivity.2(this));
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563048);
    setTitle(2131719383);
    this.rightViewText.setVisibility(8);
    this.leftView.setText(2131719389);
    this.leftView.setOnClickListener(this);
    this.re = ((ImageView)findViewById(2131379993));
    this.FE = ((TextView)findViewById(2131368276));
    this.FF = ((TextView)findViewById(2131378104));
    this.dz = ((Button)findViewById(2131381180));
    this.dz.setOnClickListener(this);
    this.dz.setClickable(true);
    this.dz.setFocusable(true);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mIsDownloading == true)
    {
      finish();
      return;
    }
    this.bai = aqil.bQ(this);
    this.baj = aqil.bR(this);
    String str;
    if (!this.bai)
    {
      this.re.setImageResource(2130850636);
      this.FE.setText(2131719377);
      this.FF.setVisibility(0);
      this.dz.setText(2131719371);
      if (!this.baj) {
        break label192;
      }
      str = "qqpimsecure is running";
    }
    for (;;)
    {
      anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
      return;
      if (!this.baj)
      {
        this.re.setImageResource(2130850637);
        this.FE.setText(2131719379);
        this.FF.setVisibility(4);
        this.dz.setText(2131719372);
        break;
      }
      this.re.setImageResource(2130850635);
      this.FE.setText(2131719373);
      this.FF.setVisibility(4);
      this.dz.setText(2131719378);
      break;
      label192:
      if (this.bai) {
        str = "qqpimsecure installed but not running";
      } else {
        str = "qqpimsecure not installed";
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.mIsDownloading == true) {
      finish();
    }
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
      if (!this.bai)
      {
        ThreadManager.executeOnNetWorkThread(new SecurityProtectActivity.1(this));
        this.mIsDownloading = true;
        this.FE.setText(2131719374);
        this.FF.setVisibility(4);
        this.dz.setVisibility(8);
        ((LinearLayout)findViewById(2131366102)).setVisibility(0);
        anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
      }
      else if (!this.baj)
      {
        aqil.E(this, "mobileqq", 7798785);
        anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
      }
      else
      {
        aqil.E(this, "mobileqq", 8716289);
        anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
        continue;
        finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityProtectActivity
 * JD-Core Version:    0.7.0.1
 */