package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SelectCountryCodeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View mView_HK;
  private View mView_australia;
  private View mView_canada;
  private View mView_china;
  private View mView_indonesia;
  private View mView_italy;
  private View mView_japan;
  private View mView_korea;
  private View mView_macau;
  private View mView_malaysia;
  private View mView_philippines;
  private View mView_singapore;
  private View mView_taiwan;
  private View mView_thailand;
  private View mView_usa;
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296657) {
      setResult(86);
    }
    for (;;)
    {
      finish();
      return;
      if (paramView.getId() == 2131296660) {
        setResult(852);
      } else if (paramView.getId() == 2131296663) {
        setResult(853);
      } else if (paramView.getId() == 2131296666) {
        setResult(886);
      } else if (paramView.getId() == 2131296669) {
        setResult(1111);
      } else if (paramView.getId() == 2131296672) {
        setResult(81);
      } else if (paramView.getId() == 2131296675) {
        setResult(82);
      } else if (paramView.getId() == 2131296678) {
        setResult(65);
      } else if (paramView.getId() == 2131296681) {
        setResult(1);
      } else if (paramView.getId() == 2131296684) {
        setResult(61);
      } else if (paramView.getId() == 2131296687) {
        setResult(39);
      } else if (paramView.getId() == 2131296690) {
        setResult(60);
      } else if (paramView.getId() == 2131296693) {
        setResult(63);
      } else if (paramView.getId() == 2131296696) {
        setResult(66);
      } else if (paramView.getId() == 2131296699) {
        setResult(62);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903106);
    this.mView_china = findViewById(2131296657);
    this.mView_china.setOnClickListener(this);
    this.mView_HK = findViewById(2131296660);
    this.mView_HK.setOnClickListener(this);
    this.mView_macau = findViewById(2131296663);
    this.mView_macau.setOnClickListener(this);
    this.mView_taiwan = findViewById(2131296666);
    this.mView_taiwan.setOnClickListener(this);
    this.mView_usa = findViewById(2131296669);
    this.mView_usa.setOnClickListener(this);
    this.mView_japan = findViewById(2131296672);
    this.mView_japan.setOnClickListener(this);
    this.mView_korea = findViewById(2131296675);
    this.mView_korea.setOnClickListener(this);
    this.mView_singapore = findViewById(2131296678);
    this.mView_singapore.setOnClickListener(this);
    this.mView_canada = findViewById(2131296681);
    this.mView_canada.setOnClickListener(this);
    this.mView_australia = findViewById(2131296684);
    this.mView_australia.setOnClickListener(this);
    this.mView_italy = findViewById(2131296687);
    this.mView_italy.setOnClickListener(this);
    this.mView_malaysia = findViewById(2131296690);
    this.mView_malaysia.setOnClickListener(this);
    this.mView_philippines = findViewById(2131296693);
    this.mView_philippines.setOnClickListener(this);
    this.mView_thailand = findViewById(2131296696);
    this.mView_thailand.setOnClickListener(this);
    this.mView_indonesia = findViewById(2131296699);
    this.mView_indonesia.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SelectCountryCodeActivity
 * JD-Core Version:    0.7.0.1
 */