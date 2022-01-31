package com.tencent.captchasdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TCaptchaPopupActivity
  extends Activity
{
  private e a;
  private RelativeLayout b;
  private float c;
  private String d;
  private g e;
  private String f;
  private l g = new d(this);
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.d = getIntent().getStringExtra("appid");
    this.f = getIntent().getStringExtra("map");
    setContentView(c.tcaptcha_popup);
    this.c = getResources().getDisplayMetrics().density;
    paramBundle = (RelativeLayout)findViewById(b.tcaptcha_container);
    this.a = new e(this);
    this.a.setLayerType(1, null);
    this.b = ((RelativeLayout)findViewById(b.tcaptcha_indicator_layout));
    int i = f.a(this, getWindow(), paramBundle, this.b, this.a);
    this.e = new g(this, this.g, this.d, this.a, this.f, i);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.e != null) {
        this.e.a();
      }
      if (this.a != null)
      {
        if (this.a.getParent() != null) {
          ((ViewGroup)this.a.getParent()).removeView(this.a);
        }
        this.a.removeAllViews();
        this.a.destroy();
        this.a = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {}
    try
    {
      setResult(0);
      finish();
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.TCaptchaPopupActivity
 * JD-Core Version:    0.7.0.1
 */