package com.tencent.captchasdk;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.token.kr.a;
import com.tencent.token.kr.b;
import com.tencent.token.ks;
import com.tencent.token.kt;
import com.tencent.token.ku;
import com.tencent.token.ku.a;

public class TCaptchaDialog
  extends Dialog
{
  private Context a;
  private String b;
  private float c;
  private ks d;
  private String e;
  private RelativeLayout f;
  private ku g;
  private ku.a h;
  
  public void dismiss()
  {
    try
    {
      if (this.g != null) {
        this.g.a();
      }
      if (this.d != null)
      {
        if (this.d.getParent() != null) {
          ((ViewGroup)this.d.getParent()).removeView(this.d);
        }
        this.d.removeAllViews();
        this.d.destroy();
        this.d = null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(kr.b.tcaptcha_popup);
    this.c = this.a.getResources().getDisplayMetrics().density;
    paramBundle = (RelativeLayout)findViewById(kr.a.tcaptcha_container);
    this.d = new ks(this.a);
    this.d.setLayerType(1, null);
    this.f = ((RelativeLayout)findViewById(kr.a.tcaptcha_indicator_layout));
    kt.a(this.a, getWindow(), paramBundle, this.f, this.d);
    this.g = new ku(this.a, this.h, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.TCaptchaDialog
 * JD-Core Version:    0.7.0.1
 */