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
import com.tencent.token.kn.a;
import com.tencent.token.kn.b;
import com.tencent.token.ko;
import com.tencent.token.kp;
import com.tencent.token.kq;
import com.tencent.token.kq.a;
import org.json.JSONObject;

public class TCaptchaPopupActivity
  extends Activity
{
  private ko a;
  private RelativeLayout b;
  private float c;
  private String d;
  private kq e;
  private String f;
  private kq.a g = new kq.a()
  {
    public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ViewGroup.LayoutParams localLayoutParams = TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).getLayoutParams();
      localLayoutParams.width = ((int)(paramAnonymousInt1 * TCaptchaPopupActivity.b(TCaptchaPopupActivity.this)));
      localLayoutParams.height = ((int)(paramAnonymousInt2 * TCaptchaPopupActivity.b(TCaptchaPopupActivity.this)));
      TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).setLayoutParams(localLayoutParams);
      TCaptchaPopupActivity.a(TCaptchaPopupActivity.this).setVisibility(0);
      TCaptchaPopupActivity.c(TCaptchaPopupActivity.this).setVisibility(4);
    }
    
    public final void a(String paramAnonymousString)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("retJson", paramAnonymousString);
      TCaptchaPopupActivity.this.setResult(-1, localIntent);
      TCaptchaPopupActivity.this.finish();
    }
    
    public final void b(String paramAnonymousString)
    {
      try
      {
        Intent localIntent = new Intent();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", -1001);
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
  };
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.d = getIntent().getStringExtra("appid");
    this.f = getIntent().getStringExtra("map");
    setContentView(kn.b.tcaptcha_popup);
    this.c = getResources().getDisplayMetrics().density;
    paramBundle = (RelativeLayout)findViewById(kn.a.tcaptcha_container);
    this.a = new ko(this);
    this.a.setLayerType(1, null);
    this.b = ((RelativeLayout)findViewById(kn.a.tcaptcha_indicator_layout));
    kp.a(this, getWindow(), paramBundle, this.b, this.a);
    this.e = new kq(this, this.g, this.d, this.a, this.f);
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