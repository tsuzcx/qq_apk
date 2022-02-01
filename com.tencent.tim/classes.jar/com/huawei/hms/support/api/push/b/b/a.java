package com.huawei.hms.support.api.push.b.b;

import android.text.TextUtils;
import com.huawei.hms.support.api.push.b.c.b;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements Serializable
{
  private String A;
  private String B;
  private String C;
  private String D;
  private String E = "";
  private int F = 1;
  private int G = 0;
  private String H;
  private String I;
  private String J;
  private int K = b.b.ordinal();
  private int L = 0;
  private String[] M = null;
  private String[] N = null;
  private String[] O = null;
  private int P = 0;
  private String[] Q = null;
  private String R = "";
  private String S = "";
  public int a = 1;
  public String b = "";
  private String c = "";
  private String d;
  private String e;
  private String f;
  private String g;
  private int h;
  private String i;
  private int j;
  private String k;
  private int l;
  private int m;
  private String n;
  private String o = "";
  private String p = "";
  private String q;
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v;
  private String w;
  private String x;
  private String y;
  private String z;
  
  public a() {}
  
  public a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      this.I = new String(paramArrayOfByte1, "UTF-8");
      this.J = new String(paramArrayOfByte2, "UTF-8");
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      HMSLog.e("PushSelfShowLog", "get msg byte arr error");
    }
  }
  
  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("group"))
    {
      this.c = paramJSONObject.getString("group");
      HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.c);
    }
    if (paramJSONObject.has("badgeClass"))
    {
      this.b = paramJSONObject.getString("badgeClass");
      HMSLog.d("PushSelfShowLog", "BADGE_CLASS:" + this.b);
    }
    if (paramJSONObject.has("badgeAddNum"))
    {
      this.a = paramJSONObject.getInt("badgeAddNum");
      HMSLog.d("PushSelfShowLog", "BADGE_ADD_NUM:" + this.a);
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("msgId"))
    {
      paramJSONObject = paramJSONObject.get("msgId");
      if ((paramJSONObject instanceof String)) {
        this.o = ((String)paramJSONObject);
      }
      for (;;)
      {
        return true;
        if ((paramJSONObject instanceof Integer)) {
          this.o = String.valueOf(((Integer)paramJSONObject).intValue());
        }
      }
    }
    HMSLog.i("PushSelfShowLog", "msgId == null");
    return false;
  }
  
  private void c(JSONObject paramJSONObject)
    throws JSONException
  {
    int i1 = 0;
    if (paramJSONObject.has("ap"))
    {
      paramJSONObject = paramJSONObject.getString("ap");
      StringBuilder localStringBuilder = new StringBuilder();
      if ((!TextUtils.isEmpty(paramJSONObject)) && (paramJSONObject.length() < 48))
      {
        int i2 = paramJSONObject.length();
        while (i1 < 48 - i2)
        {
          localStringBuilder.append("0");
          i1 += 1;
        }
        localStringBuilder.append(paramJSONObject);
        this.n = localStringBuilder.toString();
      }
    }
    else
    {
      return;
    }
    this.n = paramJSONObject.substring(0, 48);
  }
  
  private boolean d(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("psContent"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("psContent");
      if (paramJSONObject != null) {}
    }
    else
    {
      return false;
    }
    this.r = paramJSONObject.getString("cmd");
    if (paramJSONObject.has("content"))
    {
      this.s = paramJSONObject.getString("content");
      label51:
      if (!paramJSONObject.has("notifyIcon")) {
        break label147;
      }
    }
    label147:
    for (this.t = paramJSONObject.getString("notifyIcon");; this.t = ("" + this.o))
    {
      if (paramJSONObject.has("statusIcon")) {
        this.v = paramJSONObject.getString("statusIcon");
      }
      if (paramJSONObject.has("notifyTitle")) {
        this.u = paramJSONObject.getString("notifyTitle");
      }
      if (paramJSONObject.has("notifyParam")) {
        i(paramJSONObject);
      }
      if (!paramJSONObject.has("param")) {
        break;
      }
      return e(paramJSONObject);
      this.s = "";
      break label51;
    }
  }
  
  private boolean e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("param");
      if (paramJSONObject.has("autoClear")) {}
      for (this.h = paramJSONObject.getInt("autoClear"); ("app".equals(this.r)) || ("cosa".equals(this.r)); this.h = 0)
      {
        f(paramJSONObject);
        break label168;
      }
      if (!"phone".equals(this.r)) {
        break label127;
      }
    }
    catch (Exception paramJSONObject)
    {
      HMSLog.e("PushSelfShowLog", "ParseParam error ", paramJSONObject);
      return false;
    }
    if (paramJSONObject.has("phoneNum"))
    {
      this.y = paramJSONObject.getString("phoneNum");
    }
    else
    {
      HMSLog.d("PushSelfShowLog", "phoneNum is null");
      return false;
      label127:
      if ("url".equals(this.r)) {
        g(paramJSONObject);
      } else if ("rp".equals(this.r)) {
        h(paramJSONObject);
      }
    }
    label168:
    return true;
  }
  
  private boolean f(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (paramJSONObject.has("acn")) {
      this.A = paramJSONObject.getString("acn");
    }
    if (paramJSONObject.has("intentUri")) {
      this.i = paramJSONObject.getString("intentUri");
    }
    if (paramJSONObject.has("appPackageName"))
    {
      this.z = paramJSONObject.getString("appPackageName");
      return true;
    }
    HMSLog.d("PushSelfShowLog", "appPackageName is null");
    return false;
  }
  
  private boolean g(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (paramJSONObject.has("url"))
    {
      this.B = paramJSONObject.getString("url");
      if (paramJSONObject.has("inBrowser")) {
        this.F = paramJSONObject.getInt("inBrowser");
      }
      if (paramJSONObject.has("needUserId")) {
        this.G = paramJSONObject.getInt("needUserId");
      }
      if (paramJSONObject.has("sign")) {
        this.H = paramJSONObject.getString("sign");
      }
      if ((paramJSONObject.has("rpt")) && (paramJSONObject.has("rpl")))
      {
        this.C = paramJSONObject.getString("rpl");
        this.D = paramJSONObject.getString("rpt");
        if (paramJSONObject.has("rpct")) {
          this.E = paramJSONObject.getString("rpct");
        }
      }
      return true;
    }
    HMSLog.d("PushSelfShowLog", "url is null");
    return false;
  }
  
  private boolean h(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      return false;
    }
    if ((paramJSONObject.has("rpt")) && (paramJSONObject.has("rpl")))
    {
      this.C = paramJSONObject.getString("rpl");
      this.D = paramJSONObject.getString("rpt");
      if (paramJSONObject.has("rpct")) {
        this.E = paramJSONObject.getString("rpct");
      }
      if (paramJSONObject.has("needUserId")) {
        this.G = paramJSONObject.getInt("needUserId");
      }
      return true;
    }
    HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
    return false;
  }
  
  private boolean i(JSONObject paramJSONObject)
  {
    boolean bool = false;
    HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("notifyParam");
      if (paramJSONObject.has("style"))
      {
        k(paramJSONObject);
        j(paramJSONObject);
        bool = true;
      }
      return bool;
    }
    catch (JSONException paramJSONObject)
    {
      HMSLog.i("PushSelfShowLog", paramJSONObject.toString());
    }
    return false;
  }
  
  private void j(JSONObject paramJSONObject)
    throws JSONException
  {
    this.K = paramJSONObject.getInt("style");
    HMSLog.d("PushSelfShowLog", "style:" + this.K);
    b localb = b.b;
    Object localObject = localb;
    if (this.K >= 0)
    {
      localObject = localb;
      if (this.K < b.values().length) {
        localObject = b.values()[this.K];
      }
    }
    switch (a.1.a[localObject.ordinal()])
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramJSONObject.has("iconCount")) {
            this.P = paramJSONObject.getInt("iconCount");
          }
          if (this.P > 0)
          {
            if (this.P > 6) {
              this.P = 6;
            }
            HMSLog.d("PushSelfShowLog", "iconCount:" + this.P);
            this.Q = new String[this.P];
            int i1 = 0;
            while (i1 < this.P)
            {
              localObject = "icon" + (i1 + 1);
              if (paramJSONObject.has((String)localObject)) {
                this.Q[i1] = paramJSONObject.getString((String)localObject);
              }
              i1 += 1;
            }
          }
        }
      } while (!paramJSONObject.has("subTitle"));
      this.R = paramJSONObject.getString("subTitle");
      HMSLog.d("PushSelfShowLog", "subTitle:" + this.R);
      return;
    } while (!paramJSONObject.has("bigPic"));
    this.S = paramJSONObject.getString("bigPic");
    HMSLog.d("PushSelfShowLog", "bigPicUrl:" + this.S);
  }
  
  private void k(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("btnCount")) {
      this.L = paramJSONObject.getInt("btnCount");
    }
    if (this.L > 0)
    {
      if (this.L > 3) {
        this.L = 3;
      }
      HMSLog.d("PushSelfShowLog", "btnCount:" + this.L);
      this.M = new String[this.L];
      this.N = new String[this.L];
      this.O = new String[this.L];
      int i1 = 0;
      while (i1 < this.L)
      {
        String str1 = "btn" + (i1 + 1) + "Text";
        String str2 = "btn" + (i1 + 1) + "Image";
        String str3 = "btn" + (i1 + 1) + "Event";
        if (paramJSONObject.has(str1)) {
          this.M[i1] = paramJSONObject.getString(str1);
        }
        if (paramJSONObject.has(str2)) {
          this.N[i1] = paramJSONObject.getString(str2);
        }
        if (paramJSONObject.has(str3)) {
          this.O[i1] = paramJSONObject.getString(str3);
        }
        i1 += 1;
      }
    }
  }
  
  public String a()
  {
    HMSLog.d("PushSelfShowLog", "msgId =" + this.o);
    return this.o;
  }
  
  public boolean b()
  {
    int i2 = 1;
    try
    {
      if (TextUtils.isEmpty(this.J))
      {
        HMSLog.d("PushSelfShowLog", "token is null");
        return false;
      }
      this.k = this.J;
      if (TextUtils.isEmpty(this.I))
      {
        HMSLog.d("PushSelfShowLog", "msg is null");
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
      HMSLog.d("PushSelfShowLog", "parse message exception.");
      return false;
      JSONObject localJSONObject1 = new JSONObject(this.I);
      this.j = localJSONObject1.getInt("msgType");
      if (this.j != 1)
      {
        HMSLog.d("PushSelfShowLog", "not a selefShowMsg");
        return false;
      }
    }
    catch (Exception localException)
    {
      HMSLog.d("PushSelfShowLog", localException.toString());
      return false;
    }
    a(localException);
    JSONObject localJSONObject2 = localException.getJSONObject("msgContent");
    if (localJSONObject2 == null)
    {
      HMSLog.i("PushSelfShowLog", "msgObj == null");
      return false;
    }
    if (b(localJSONObject2))
    {
      if (localJSONObject2.has("dispPkgName")) {
        this.p = localJSONObject2.getString("dispPkgName");
      }
      if (localJSONObject2.has("rtn")) {}
      for (int i1 = localJSONObject2.getInt("rtn");; i1 = 1)
      {
        this.m = i1;
        i1 = i2;
        if (localJSONObject2.has("fm")) {
          i1 = localJSONObject2.getInt("fm");
        }
        this.l = i1;
        c(localJSONObject2);
        if (localJSONObject2.has("extras")) {
          this.q = localJSONObject2.getJSONArray("extras").toString();
        }
        boolean bool = d(localJSONObject2);
        return bool;
      }
    }
    return false;
  }
  
  public byte[] c()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("autoClear", this.h);
      localJSONObject3.put("s", this.d);
      localJSONObject3.put("r", this.e);
      localJSONObject3.put("smsC", this.f);
      localJSONObject3.put("mmsUrl", this.g);
      localJSONObject3.put("url", this.B);
      localJSONObject3.put("inBrowser", this.F);
      localJSONObject3.put("needUserId", this.G);
      localJSONObject3.put("sign", this.H);
      localJSONObject3.put("rpl", this.C);
      localJSONObject3.put("rpt", this.D);
      localJSONObject3.put("rpct", this.E);
      localJSONObject3.put("appPackageName", this.z);
      localJSONObject3.put("acn", this.A);
      localJSONObject3.put("intentUri", this.i);
      localJSONObject3.put("phoneNum", this.y);
      localJSONObject3.put("replyToSms", this.x);
      localJSONObject3.put("smsNum", this.w);
      localJSONObject2.put("cmd", this.r);
      localJSONObject2.put("content", this.s);
      localJSONObject2.put("notifyIcon", this.t);
      localJSONObject2.put("notifyTitle", this.u);
      localJSONObject2.put("statusIcon", this.v);
      localJSONObject2.put("param", localJSONObject3);
      localJSONObject1.put("dispPkgName", this.p);
      localJSONObject1.put("msgId", this.o);
      localJSONObject1.put("fm", this.l);
      localJSONObject1.put("ap", this.n);
      localJSONObject1.put("rtn", this.m);
      localJSONObject1.put("psContent", localJSONObject2);
      if ((this.q != null) && (this.q.length() > 0)) {
        localJSONObject1.put("extras", new JSONArray(this.q));
      }
      ((JSONObject)localObject).put("msgType", this.j);
      ((JSONObject)localObject).put("msgContent", localJSONObject1);
      ((JSONObject)localObject).put("group", this.c);
      ((JSONObject)localObject).put("badgeClass", this.b);
      ((JSONObject)localObject).put("badgeAddNum", this.a);
      localObject = ((JSONObject)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException");
      return new byte[0];
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        HMSLog.e("PushSelfShowLog", "getMsgData failed UnsupportedEncodingException");
      }
    }
  }
  
  public byte[] d()
  {
    try
    {
      if ((this.k != null) && (this.k.length() > 0))
      {
        byte[] arrayOfByte = this.k.getBytes("UTF-8");
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      HMSLog.w("PushSelfShowLog", "getToken getByte failed ");
    }
    return new byte[0];
  }
  
  public String e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.n;
  }
  
  public String i()
  {
    return this.p;
  }
  
  public String j()
  {
    return this.r;
  }
  
  public String k()
  {
    return this.s;
  }
  
  public String l()
  {
    return this.t;
  }
  
  public String m()
  {
    return this.u;
  }
  
  public String n()
  {
    return this.y;
  }
  
  public String o()
  {
    return this.z;
  }
  
  public String p()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.b.b.a
 * JD-Core Version:    0.7.0.1
 */