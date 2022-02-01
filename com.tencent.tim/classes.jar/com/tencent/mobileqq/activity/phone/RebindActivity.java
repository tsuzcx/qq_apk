package com.tencent.mobileqq.activity.phone;

import acfp;
import akwl;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aqiw;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import zrc;

public class RebindActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private TextView Ni;
  public String baz;
  private int bindType = 0;
  private boolean bsj;
  private boolean bsk;
  private Button cancelBtn;
  private Button confirmBtn;
  private String countryCode;
  private akwl j;
  public int mSource;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559749);
    this.bsj = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.bsk = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.mSource = getIntent().getIntExtra("kSrouce", -1);
    this.countryCode = getIntent().getStringExtra("k_country_code");
    this.baz = getIntent().getStringExtra("k_number");
    this.bindType = getIntent().getIntExtra("kBindType", 0);
    setTitle(acfp.m(2131713650));
    this.Ni = ((TextView)findViewById(2131373035));
    paramBundle = this.countryCode + " " + this.baz;
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getResources().getString(2131696844, new Object[] { paramBundle, getIntent().getStringExtra("k_uin"), this.app.getCurrentAccountUin() }));
    localSpannableStringBuilder.setSpan(localForegroundColorSpan, 4, paramBundle.length() + 4, 33);
    this.Ni.setText(localSpannableStringBuilder);
    this.confirmBtn = ((Button)findViewById(2131373034));
    this.confirmBtn.setOnClickListener(this);
    this.cancelBtn = ((Button)findViewById(2131373033));
    this.cancelBtn.setOnClickListener(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.j != null)
    {
      this.app.unRegistObserver(this.j);
      this.j = null;
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.confirmBtn) {
      if (!aqiw.isNetSupport(this)) {
        showToast(2131696348);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.j == null)
      {
        this.j = new zrc(this);
        this.app.registObserver(this.j);
      }
      this.f.b(this.countryCode, this.baz, this.bindType, this.bsj, this.bsk);
      j(2131719519, 1000L, true);
      continue;
      if (paramView == this.cancelBtn) {
        finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity
 * JD-Core Version:    0.7.0.1
 */