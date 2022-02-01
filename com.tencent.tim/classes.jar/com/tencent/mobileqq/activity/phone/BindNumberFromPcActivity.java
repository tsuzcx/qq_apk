package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acfp;
import akwl;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aqiw;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Date;
import zqc;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private TextView Nb;
  private TextView Nc;
  private boolean bsp;
  private akwl c;
  public Button confirmBtn;
  public String countryCode;
  private Button eI;
  private akwl h;
  public String mobileNo;
  private String time;
  
  private void crc()
  {
    if (!aqiw.isNetSupport(this))
    {
      showToast(2131696348);
      return;
    }
    if (this.h == null)
    {
      this.h = new zqc(this);
      this.app.registObserver(this.h);
    }
    this.confirmBtn.setEnabled(false);
    this.f.dP(this.countryCode, this.mobileNo);
    j(2131719519, 1000L, true);
  }
  
  private void crd()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_change_number", true);
    startActivityForResult(localIntent, 1);
  }
  
  private void initViews()
  {
    setTitle(acfp.m(2131703215));
    if (this.bsp) {
      setLeftButton(2131721059, null);
    }
    this.Nb = ((TextView)findViewById(2131373039));
    int i = this.mobileNo.length();
    String str = this.mobileNo.substring(0, i - 5) + "****" + this.mobileNo.substring(i - 1);
    this.Nb.setText(this.countryCode + " " + str);
    this.Nc = ((TextView)findViewById(2131373038));
    this.Nc.setText(getResources().getString(2131696793, new Object[] { this.time }));
    this.confirmBtn = ((Button)findViewById(2131373037));
    this.confirmBtn.setOnClickListener(this);
    this.eI = ((Button)findViewById(2131373036));
    this.eI.setOnClickListener(this);
  }
  
  public void finish()
  {
    super.finish();
    if (this.bsp) {
      overridePendingTransition(2130772002, 2130772369);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
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
      crc();
      continue;
      crd();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559739);
    int i = this.f.xy();
    paramBundle = this.f.a();
    if ((i != 5) || (paramBundle == null))
    {
      dV(acfp.m(2131703214), acfp.m(2131703217));
      return;
    }
    this.countryCode = paramBundle.nationCode;
    this.mobileNo = paramBundle.mobileNo;
    this.time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramBundle.bindingTime * 1000L));
    this.bsp = getIntent().getBooleanExtra("key_is_first_activity", true);
    initViews();
  }
  
  public void onDestroy()
  {
    if (this.h != null)
    {
      this.app.unRegistObserver(this.h);
      this.h = null;
    }
    if (this.c != null)
    {
      this.app.unRegistObserver(this.c);
      this.c = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */