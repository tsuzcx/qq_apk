package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import org.json.JSONObject;

public final class q
  implements Cloneable
{
  public int a;
  public String b;
  public String c;
  public String d;
  
  public static q a()
  {
    q localq = new q();
    localq.a = DisplayUtil.parseColor("#000000");
    localq.b = "white";
    localq.d = "default";
    return localq;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("navigationBarBackgroundColor");
    if (TextUtils.isEmpty(str)) {}
    for (int i = this.a;; i = DisplayUtil.parseColor(str))
    {
      this.a = i;
      this.b = paramJSONObject.optString("navigationBarTextStyle", this.b);
      if ((!"white".equals(this.b)) && (!"black".equals(this.b))) {
        this.b = "white";
      }
      this.c = paramJSONObject.optString("navigationBarTitleText", this.c);
      this.d = paramJSONObject.optString("navigationStyle", this.d);
      return;
    }
  }
  
  public q b()
  {
    try
    {
      q localq = (q)super.clone();
      return localq;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.q
 * JD-Core Version:    0.7.0.1
 */