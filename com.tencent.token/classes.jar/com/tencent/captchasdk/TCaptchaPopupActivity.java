package com.tencent.captchasdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import org.json.JSONObject;

public class TCaptchaPopupActivity
  extends Activity
{
  private b a;
  private RelativeLayout b;
  private float c;
  private String d;
  private d e;
  private String f;
  private d.a g = new d.a()
  {
    public void a(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ViewGroup.LayoutParams localLayoutParams = TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).getLayoutParams();
      localLayoutParams.width = ((int)(paramAnonymousInt1 * TCaptchaPopupActivity.b(TCaptchaPopupActivity.this)));
      localLayoutParams.height = ((int)(paramAnonymousInt2 * TCaptchaPopupActivity.b(TCaptchaPopupActivity.this)));
      TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).setLayoutParams(localLayoutParams);
      TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).setVisibility(0);
      TCaptchaPopupActivity.c(TCaptchaPopupActivity.this).setVisibility(4);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString)
    {
      try
      {
        Intent localIntent = new Intent();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramAnonymousInt);
        localJSONObject.put("info", paramAnonymousString);
        localIntent.putExtra("retJson", localJSONObject.toString());
        TCaptchaPopupActivity.this.setResult(-1, localIntent);
        TCaptchaPopupActivity.this.finish();
        return;
      }
      catch (Exception paramAnonymousString)
      {
        paramAnonymousString.printStackTrace();
      }
    }
    
    public void a(String paramAnonymousString)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("retJson", paramAnonymousString);
      TCaptchaPopupActivity.this.setResult(-1, localIntent);
      TCaptchaPopupActivity.this.finish();
    }
  };
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.d = getIntent().getStringExtra("appid");
    this.f = getIntent().getStringExtra("map");
    setContentView(a.b.tcaptcha_popup);
    this.c = getResources().getDisplayMetrics().density;
    paramBundle = (RelativeLayout)findViewById(a.a.tcaptcha_container);
    this.a = new b(this);
    this.a.setLayerType(1, null);
    this.b = ((RelativeLayout)findViewById(a.a.tcaptcha_indicator_layout));
    int i = c.a(this, getWindow(), paramBundle, this.b, this.a);
    this.e = new d(this, this.g, this.d, this.a, this.f, i);
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
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        setResult(0);
        finish();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.TCaptchaPopupActivity
 * JD-Core Version:    0.7.0.1
 */