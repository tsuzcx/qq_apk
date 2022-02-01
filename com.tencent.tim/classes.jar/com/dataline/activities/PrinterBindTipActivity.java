package com.dataline.activities;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tar;

public class PrinterBindTipActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button A;
  private String bH;
  private long din;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165572);
    super.setContentView(2131559781);
    super.setTitle(acfp.m(2131709888));
    super.setLeftViewName(2131692614);
    this.A = ((Button)super.findViewById(2131363486));
    this.A.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.bH = paramBundle.getStringExtra("printer_bind_url");
    this.din = paramBundle.getIntExtra("din", 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    tar.a();
    tar.a(this.app, this.din, "printer_hp", 5, 0, 0);
    if (!TextUtils.isEmpty(this.bH))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("url", this.bH);
      super.startActivity(localIntent);
    }
    super.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterBindTipActivity
 * JD-Core Version:    0.7.0.1
 */