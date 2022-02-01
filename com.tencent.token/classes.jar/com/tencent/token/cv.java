package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

public class cv
  extends bs
{
  static cv a;
  int b;
  private final String c = "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2";
  private final String d = "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt";
  private int e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  
  public static cv a()
  {
    if (a == null) {
      a = new cv();
    }
    return a;
  }
  
  private void f()
  {
    this.e = 0;
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = 0;
  }
  
  public e a(int paramInt)
  {
    f();
    e locale = new e();
    Object localObject3 = cq.a();
    if (!((cq)localObject3).a(locale)) {
      return locale;
    }
    if (((cq)localObject3).e() == null)
    {
      locale.b(103);
      return locale;
    }
    Object localObject2 = ((cq)localObject3).k();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((cq)localObject3).r();
      if (!((e)localObject1).b())
      {
        locale.a((e)localObject1);
        return locale;
      }
      localObject2 = ((cq)localObject3).k();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        locale.b(103);
        return locale;
      }
    }
    boolean bool = l.a(RqdApplication.l(), "de.robv.android.xposed.installer");
    long l = ((QQUser)localObject1).mUin;
    if (bool) {}
    for (int k = 1;; k = 0)
    {
      localObject1 = l.a(new Object[] { "uin", Long.valueOf(l), "action_type", Integer.valueOf(paramInt), "nosafe", Integer.valueOf(k) });
      if (localObject1 != null) {
        break;
      }
      locale.a(10000, "encrypt  failed");
      return null;
    }
    localObject2 = "?aq_base_sid=" + ((cq)localObject3).g() + "&data=" + (String)localObject1;
    localObject1 = new ey();
    g.b("&nosafe: " + bool);
    localObject2 = c.e() + "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2" + (String)localObject2;
    localObject3 = ((ey)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      locale.a(((ey)localObject1).a());
      g.c("client request url: " + (String)localObject2 + " failed, reason: " + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      paramInt = ((JSONObject)localObject1).getInt("err");
      if (paramInt != 0)
      {
        localObject1 = ((JSONObject)localObject1).getString("info");
        locale.a(paramInt, (String)localObject1, (String)localObject1);
        g.c("query2ndVerify, errcode: " + paramInt + ", info: " + (String)localObject1);
      }
      else
      {
        localObject1 = l.c(((JSONObject)localObject1).getString("data"));
        if (localObject1 != null)
        {
          localObject1 = new JSONObject(new String((byte[])localObject1));
          this.e = ((JSONObject)localObject1).getInt("need_2nd_verify");
          if (this.e == 1)
          {
            this.f = ((JSONObject)localObject1).getString("verify_tips");
            this.g = ((JSONObject)localObject1).getString("verify_input_tips");
            this.h = ((JSONObject)localObject1).getString("cancel_btn_text");
            this.i = ((JSONObject)localObject1).getString("confirm_btn_text");
            this.j = ((JSONObject)localObject1).getInt("verify_type");
          }
          locale.c();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      g.c("parse json failed: " + localJSONException.toString());
      locale.a(10020, "JSONException:" + localJSONException.toString());
      break label710;
      locale.b(10022);
      return locale;
    }
    catch (Exception localException)
    {
      g.c("unknown err: " + localException.toString());
      locale.a(10021, "JSONException:" + localException.toString());
    }
    label710:
    return locale;
  }
  
  public e a(String paramString, int paramInt)
  {
    e locale = new e();
    Object localObject1 = cq.a();
    if ((localObject1 == null) || (((cq)localObject1).e() == null))
    {
      locale.b(110);
      return locale;
    }
    int k = (int)(cb.c().s() / 1000L);
    int m = ca.a + 1;
    ca.a = m;
    this.b = m;
    Object localObject2 = a(cq.a().c(), new String[] { "input_data", paramString, "op_time", String.valueOf(k), "seq_id", String.valueOf(this.b), "uin", String.valueOf(((cq)localObject1).e().mUin), "verify_type", Integer.toString(this.j), "action_type", Integer.toString(paramInt) });
    if (localObject2 == null)
    {
      locale.a(10000, "encrypt imei failed");
      return locale;
    }
    paramString = new ey();
    localObject1 = "?aq_base_sid=" + ((cq)localObject1).g() + "&data=" + (String)localObject2;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt" + (String)localObject1;
    localObject2 = paramString.a((String)localObject1);
    if (localObject2 == null)
    {
      locale.a(paramString.a());
      g.c("client request url: " + (String)localObject1 + " failed, reason: " + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      paramString = new JSONObject(new String((byte[])localObject2));
      paramInt = paramString.getInt("err");
      if (paramInt != 0)
      {
        paramString = paramString.getString("info");
        locale.a(paramInt, paramString, paramString);
        return locale;
      }
    }
    catch (JSONException paramString)
    {
      g.c("parse json failed: " + paramString.toString());
      locale.a(10020, "JSONException:" + paramString.toString());
      return locale;
      paramInt = new JSONObject(new String(l.c(paramString.getString("data")))).getInt("seq_id");
      if (this.b != paramInt)
      {
        locale.b(10030);
        g.c("parseJSON error seq is wrong seq=" + paramInt + ",right = " + this.b);
        return locale;
      }
    }
    catch (Exception paramString)
    {
      g.c("unknown err: " + paramString.toString());
      locale.a(10021, "JSONException:" + paramString.toString());
      return locale;
    }
    cq.a().m();
    locale.c();
    return locale;
  }
  
  public void a(final int paramInt, final Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        return cv.this.a(paramInt);
      }
      
      public void a(e paramAnonymouse)
      {
        Message localMessage = new Message();
        localMessage.arg1 = paramInt;
        if ((paramAnonymouse.b()) && (1 == cv.a(cv.this))) {}
        for (localMessage.what = 1011;; localMessage.what = 1010)
        {
          if (paramHandler != null) {
            paramHandler.sendMessage(localMessage);
          }
          return;
        }
      }
    }.c(new String[] { "" });
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cv
 * JD-Core Version:    0.7.0.1
 */