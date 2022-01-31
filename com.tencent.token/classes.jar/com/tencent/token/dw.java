package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

public class dw
  extends cf
{
  static dw a;
  int b;
  private final String c = "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2";
  private final String d = "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt";
  private int e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  
  public static dw a()
  {
    if (a == null) {
      a = new dw();
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
  
  public f a(int paramInt)
  {
    f();
    f localf = new f();
    Object localObject3 = do.a();
    if (!((do)localObject3).a(localf)) {
      return localf;
    }
    if (((do)localObject3).e() == null)
    {
      localf.b(103);
      return localf;
    }
    Object localObject2 = ((do)localObject3).k();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((do)localObject3).r();
      if (!((f)localObject1).b())
      {
        localf.a((f)localObject1);
        return localf;
      }
      localObject2 = ((do)localObject3).k();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localf.b(103);
        return localf;
      }
    }
    boolean bool = w.a(RqdApplication.l(), "de.robv.android.xposed.installer");
    long l = ((QQUser)localObject1).mUin;
    if (bool) {}
    for (int k = 1;; k = 0)
    {
      localObject1 = w.a(new Object[] { "uin", Long.valueOf(l), "action_type", Integer.valueOf(paramInt), "nosafe", Integer.valueOf(k) });
      if (localObject1 != null) {
        break;
      }
      localf.a(10000, "encrypt  failed");
      return null;
    }
    localObject2 = "?aq_base_sid=" + ((do)localObject3).g() + "&data=" + (String)localObject1;
    localObject1 = new gk();
    h.b("&nosafe: " + bool);
    localObject2 = c.e() + "/cn/mbtoken3/mbtoken3_query_for_2nd_verify_v2" + (String)localObject2;
    localObject3 = ((gk)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localf.a(((gk)localObject1).a());
      h.c("client request url: " + (String)localObject2 + " failed, reason: " + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      paramInt = ((JSONObject)localObject1).getInt("err");
      if (paramInt != 0)
      {
        localObject1 = ((JSONObject)localObject1).getString("info");
        localf.a(paramInt, (String)localObject1, (String)localObject1);
        h.c("query2ndVerify, errcode: " + paramInt + ", info: " + (String)localObject1);
      }
      else
      {
        localObject1 = w.c(((JSONObject)localObject1).getString("data"));
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
          localf.c();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      h.c("parse json failed: " + localJSONException.toString());
      localf.a(10020, "JSONException:" + localJSONException.toString());
      break label710;
      localf.b(10022);
      return localf;
    }
    catch (Exception localException)
    {
      h.c("unknown err: " + localException.toString());
      localf.a(10021, "JSONException:" + localException.toString());
    }
    label710:
    return localf;
  }
  
  public f a(String paramString, int paramInt)
  {
    f localf = new f();
    Object localObject1 = do.a();
    if ((localObject1 == null) || (((do)localObject1).e() == null))
    {
      localf.b(110);
      return localf;
    }
    int k = (int)(cx.c().s() / 1000L);
    int m = cw.a + 1;
    cw.a = m;
    this.b = m;
    Object localObject2 = a(do.a().c(), new String[] { "input_data", paramString, "op_time", String.valueOf(k), "seq_id", String.valueOf(this.b), "uin", String.valueOf(((do)localObject1).e().mUin), "verify_type", Integer.toString(this.j), "action_type", Integer.toString(paramInt) });
    if (localObject2 == null)
    {
      localf.a(10000, "encrypt imei failed");
      return localf;
    }
    paramString = new gk();
    localObject1 = "?aq_base_sid=" + ((do)localObject1).g() + "&data=" + (String)localObject2;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_perform_2nd_verify_encrypt" + (String)localObject1;
    localObject2 = paramString.a((String)localObject1);
    if (localObject2 == null)
    {
      localf.a(paramString.a());
      h.c("client request url: " + (String)localObject1 + " failed, reason: " + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      paramString = new JSONObject(new String((byte[])localObject2));
      paramInt = paramString.getInt("err");
      if (paramInt != 0)
      {
        paramString = paramString.getString("info");
        localf.a(paramInt, paramString, paramString);
        return localf;
      }
    }
    catch (JSONException paramString)
    {
      h.c("parse json failed: " + paramString.toString());
      localf.a(10020, "JSONException:" + paramString.toString());
      return localf;
      paramInt = new JSONObject(new String(w.c(paramString.getString("data")))).getInt("seq_id");
      if (this.b != paramInt)
      {
        localf.b(10030);
        h.c("parseJSON error seq is wrong seq=" + paramInt + ",right = " + this.b);
        return localf;
      }
    }
    catch (Exception paramString)
    {
      h.c("unknown err: " + paramString.toString());
      localf.a(10021, "JSONException:" + paramString.toString());
      return localf;
    }
    do.a().m();
    localf.c();
    return localf;
  }
  
  public void a(int paramInt, Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    new dx(this, paramInt, paramHandler).c(new String[] { "" });
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
 * Qualified Name:     com.tencent.token.dw
 * JD-Core Version:    0.7.0.1
 */