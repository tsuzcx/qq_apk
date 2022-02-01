package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import org.json.JSONObject;

public final class u
  implements Cloneable
{
  public q a;
  public int b;
  public String c;
  public boolean d;
  public int e;
  
  public static u a()
  {
    u localu = new u();
    localu.a = q.a();
    localu.b = DisplayUtil.parseColor("#ffffff");
    localu.c = "dark";
    localu.d = false;
    localu.e = 50;
    return localu;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str;
    if (paramJSONObject != null)
    {
      this.a.a(paramJSONObject);
      str = paramJSONObject.optString("backgroundColor");
      if (!TextUtils.isEmpty(str)) {
        break label79;
      }
    }
    label79:
    for (int i = this.b;; i = DisplayUtil.parseColor(str))
    {
      this.b = i;
      this.c = paramJSONObject.optString("backgroundTextStyle", this.c);
      this.d = paramJSONObject.optBoolean("enablePullDownRefresh", this.d);
      this.e = paramJSONObject.optInt("onReachBottomDistance", this.e);
      return;
    }
  }
  
  public u b()
  {
    try
    {
      localu = (u)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localu.a = this.a.b();
        return localu;
      }
      catch (Throwable localThrowable2)
      {
        u localu;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localu = null;
    }
    label24:
    return localu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.u
 * JD-Core Version:    0.7.0.1
 */