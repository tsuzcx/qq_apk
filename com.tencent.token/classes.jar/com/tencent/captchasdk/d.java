package com.tencent.captchasdk;

import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import org.json.JSONObject;

class d
  implements l
{
  d(TCaptchaPopupActivity paramTCaptchaPopupActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = TCaptchaPopupActivity.a(this.a).getLayoutParams();
    localLayoutParams.width = ((int)(paramInt1 * TCaptchaPopupActivity.b(this.a)));
    localLayoutParams.height = ((int)(paramInt2 * TCaptchaPopupActivity.b(this.a)));
    TCaptchaPopupActivity.a(this.a).setLayoutParams(localLayoutParams);
    TCaptchaPopupActivity.a(this.a).setVisibility(0);
    TCaptchaPopupActivity.c(this.a).setVisibility(4);
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("info", paramString);
      localIntent.putExtra("retJson", localJSONObject.toString());
      this.a.setResult(-1, localIntent);
      this.a.finish();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retJson", paramString);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.d
 * JD-Core Version:    0.7.0.1
 */