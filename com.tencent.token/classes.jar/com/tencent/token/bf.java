package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class bf
  extends n
{
  static bf a;
  private final String b = "/cn/mbtoken3/mbtoken3_query_for_2nd_verify";
  private final String c = "/cn/mbtoken3/mbtoken3_perform_2nd_verify";
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  
  public static bf a()
  {
    if (a == null) {
      a = new bf();
    }
    return a;
  }
  
  public final d a(int paramInt)
  {
    this.d = 0;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = 0;
    d locald = new d((byte)0);
    Object localObject3 = ax.a();
    if (!((ax)localObject3).a(locald)) {
      return locald;
    }
    if (((ax)localObject3).e() == null)
    {
      locald.a(103, null, null);
      return locald;
    }
    Object localObject2 = ((ax)localObject3).k();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((ax)localObject3).r();
      if (((d)localObject1).a == 0) {}
      for (int j = 1; j == 0; j = 0)
      {
        locald.a(((d)localObject1).a, ((d)localObject1).b, ((d)localObject1).c);
        return locald;
      }
      localObject2 = ((ax)localObject3).k();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        locald.a(103, null, null);
        return locald;
      }
    }
    localObject3 = new gv();
    localObject2 = "?aq_base_sid=" + ax.g() + "&uin=" + ((QQUser)localObject1).mUin + "&action_type=" + paramInt;
    boolean bool = s.a(RqdApplication.i(), "de.robv.android.xposed.installer");
    localObject1 = localObject2;
    if (bool) {
      localObject1 = (String)localObject2 + "&nosafe=1";
    }
    e.b("&nosafe: " + bool);
    localObject1 = b.c() + "/cn/mbtoken3/mbtoken3_query_for_2nd_verify" + (String)localObject1;
    localObject2 = ((gv)localObject3).a((String)localObject1);
    if (localObject2 == null)
    {
      localObject2 = ((gv)localObject3).a();
      locald.a(((d)localObject2).a, ((d)localObject2).b, ((d)localObject2).c);
      e.c("client request url: " + (String)localObject1 + " failed, reason: " + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject2));
      paramInt = ((JSONObject)localObject1).getInt("err");
      if (paramInt != 0)
      {
        localObject1 = ((JSONObject)localObject1).getString("info");
        locald.a(paramInt, (String)localObject1, (String)localObject1);
        e.c("query2ndVerify, errcode: " + paramInt + ", info: " + (String)localObject1);
      }
      else
      {
        this.d = ((JSONObject)localObject1).getInt("need_2nd_verify");
        if (this.d == 1)
        {
          this.e = ((JSONObject)localObject1).getString("verify_tips");
          this.f = ((JSONObject)localObject1).getString("verify_input_tips");
          this.g = ((JSONObject)localObject1).getString("cancel_btn_text");
          this.h = ((JSONObject)localObject1).getString("confirm_btn_text");
          this.i = ((JSONObject)localObject1).getInt("verify_type");
        }
        locald.a = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      e.c("parse json failed: " + localJSONException.toString());
      locald.a(10020, "JSONException:" + localJSONException.toString(), null);
    }
    catch (Exception localException)
    {
      e.c("unknown err: " + localException.toString());
      locald.a(10021, "JSONException:" + localException.toString(), null);
    }
    return locald;
  }
  
  public final d a(String paramString, int paramInt)
  {
    d locald = new d((byte)0);
    Object localObject1 = ax.a();
    if ((localObject1 == null) || (((ax)localObject1).e() == null))
    {
      locald.a(110, null, null);
      return locald;
    }
    Object localObject2 = a(ax.a().c(), new String[] { "input_data", paramString, "verify_type", Integer.toString(this.i), "action_type", Integer.toString(paramInt) });
    if (localObject2 == null)
    {
      locald.a(10000, "encrypt imei failed", null);
      return locald;
    }
    paramString = new gv();
    localObject1 = "?aq_base_sid=" + ax.g() + "&uin=" + ((ax)localObject1).e().mUin + "&verify_data=" + (String)localObject2;
    localObject1 = b.c() + "/cn/mbtoken3/mbtoken3_perform_2nd_verify" + (String)localObject1;
    localObject2 = paramString.a((String)localObject1);
    if (localObject2 == null)
    {
      paramString = paramString.a();
      locald.a(paramString.a, paramString.b, paramString.c);
      e.c("client request url: " + (String)localObject1 + " failed, reason: " + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      paramString = new JSONObject(new String((byte[])localObject2));
      paramInt = paramString.getInt("err");
      if (paramInt != 0)
      {
        paramString = paramString.getString("info");
        locald.a(paramInt, paramString, paramString);
        return locald;
      }
    }
    catch (JSONException paramString)
    {
      e.c("parse json failed: " + paramString.toString());
      locald.a(10020, "JSONException:" + paramString.toString(), null);
      return locald;
      ax.a().m();
      locald.a = 0;
      return locald;
    }
    catch (Exception paramString)
    {
      e.c("unknown err: " + paramString.toString());
      locald.a(10021, "JSONException:" + paramString.toString(), null);
    }
    return locald;
  }
  
  public final void a(int paramInt, Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    new bg(this, paramInt, paramHandler).a(new String[] { "" });
  }
  
  public final String b()
  {
    return this.f;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final String d()
  {
    return this.g;
  }
  
  public final String e()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bf
 * JD-Core Version:    0.7.0.1
 */