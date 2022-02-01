package com.tencent.token;

import android.content.ContentValues;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.l;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class by
{
  private static int d = 10;
  private static int e = 15;
  private static int f = d;
  private static by g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask<String, String, e> k = null;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 40001;
    case 10003: 
      return 10003;
    case 10002: 
      return 10002;
    case 100004: 
      return 10004;
    case 10005: 
      return 10005;
    case 103: 
      return 30001;
    }
    return 10001;
  }
  
  public static by a()
  {
    if (g == null) {
      g = new by();
    }
    if ((!c.l()) && (!i))
    {
      i = true;
      g.c();
    }
    return g;
  }
  
  private e a(String paramString)
  {
    e locale = new e();
    Object localObject1 = cr.a();
    if (!((cr)localObject1).o())
    {
      locale.b(30001);
      if (this.j) {
        b();
      }
    }
    for (;;)
    {
      return locale;
      if (((cr)localObject1).k() != null) {}
      for (;;)
      {
        g.a("netflow data=" + paramString);
        Object localObject2 = l.b(paramString.getBytes());
        paramString = c.e() + "/cn/mbtoken3/mbtoken3_qos_report";
        localObject1 = new ContentValues(3);
        ((ContentValues)localObject1).put("aq_base_sid", cr.c);
        ((ContentValues)localObject1).put("data", (String)localObject2);
        g.a("netflow aq_base_sid=" + cr.c);
        g.a("netflow data=" + (String)localObject2);
        localObject2 = new ez();
        paramString = ((ez)localObject2).a(paramString, (ContentValues)localObject1);
        if (paramString != null) {
          break;
        }
        if (this.j) {
          b();
        }
        locale.a(((ez)localObject2).a());
        return locale;
        ((cr)localObject1).e();
      }
      try
      {
        paramString = new JSONObject(new String(paramString));
        m = paramString.getInt("err");
        if (m != 0)
        {
          paramString = paramString.getString("info");
          locale.a(m, paramString, paramString);
        }
        for (;;)
        {
          return locale;
          locale.c();
          if (this.b.length() <= e) {
            break;
          }
          m = e;
          if (m > e) {
            break label410;
          }
          this.b = new JSONArray();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          g.c("parse json failed: " + paramString.toString());
          locale.a(10020, "JSONException:" + paramString.toString());
          return locale;
          int m = this.b.length();
          continue;
          paramString = new JSONArray();
          while (m < this.b.length())
          {
            paramString.put(this.b.get(m));
            m += 1;
          }
          this.b = paramString;
        }
      }
      catch (Exception paramString)
      {
        label410:
        g.c("unknown err: " + paramString.toString());
        locale.a(10021, "JSONException:" + paramString.toString());
        return locale;
      }
      finally
      {
        if (this.j) {
          b();
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    if (c.l()) {}
    for (;;)
    {
      return;
      if (this.b == null) {
        continue;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("t", paramLong);
          localJSONObject.put("e", paramInt1);
          localJSONObject.put("p", paramString1);
          localJSONObject.put("s", paramInt2);
          localJSONObject.put("d", paramString2);
          localJSONObject.put("nt", paramString3);
        }
        catch (Exception paramString1)
        {
          JSONObject localJSONObject;
          continue;
        }
        try
        {
          this.b.put(localJSONObject);
          if (this.b.length() < f) {
            break;
          }
          a(false);
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (c.l()) {}
    do
    {
      return;
      this.j = paramBoolean;
    } while ((this.h) || (!this.a) || (this.b.length() == 0));
    this.h = true;
    JSONArray localJSONArray = new JSONArray();
    if (this.b.length() > e) {}
    for (int m = e;; m = this.b.length())
    {
      int n = 0;
      for (;;)
      {
        if (n >= m) {
          break label108;
        }
        try
        {
          localJSONArray.put(this.b.get(n));
          n += 1;
        }
        catch (Exception localException2) {}
      }
    }
    try
    {
      label108:
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("tkn_seq", String.valueOf(cc.c().k()));
        if (cr.a().e() != null) {
          localJSONObject.put("uin", cr.a().e().mRealUin);
        }
        String str = l.c(RqdApplication.l());
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.put("mac", str);
        }
        str = l.b(RqdApplication.l());
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.put("device_id", str);
        }
        localJSONObject.put("model", URLEncoder.encode(Build.MODEL));
        localJSONObject.put("release", URLEncoder.encode(Build.VERSION.RELEASE));
        localJSONObject.put("platfrom", "android");
        localJSONObject.put("guid", l.a(bz.a(RqdApplication.l()).b()));
        str = l.d(RqdApplication.l());
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.put("router_id", str);
        }
        localJSONObject.put("event_list", localJSONArray);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          g.c("JSONException:" + localException1.getMessage());
        }
      }
      this.c = localJSONObject.toString();
      this.k = new UserTask()
      {
        public e a(String... paramAnonymousVarArgs)
        {
          return by.a(by.this, by.this.c);
        }
        
        public void a()
        {
          by.a(by.this, false);
        }
        
        public void a(e paramAnonymouse)
        {
          if (paramAnonymouse.b()) {
            by.b(by.d());
          }
          for (;;)
          {
            by.a(by.this, false);
            return;
            g.c("post click flow msg failed:" + paramAnonymouse.a + "-" + paramAnonymouse.b);
            if (by.e() < by.f()) {}
            try
            {
              by.b(by.f());
            }
            catch (Exception paramAnonymouse)
            {
              continue;
              by.b(by.d());
            }
            catch (Error paramAnonymouse) {}
          }
        }
      };
      this.k.c(new String[0]);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 36	com/tencent/token/by:i	Z
    //   19: aload_0
    //   20: getfield 42	com/tencent/token/by:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc_w 333
    //   32: iconst_0
    //   33: invokevirtual 339	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -32 -> 6
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   46: invokevirtual 340	org/json/JSONArray:toString	()Ljava/lang/String;
    //   49: invokevirtual 116	java/lang/String:getBytes	()[B
    //   52: invokevirtual 345	java/io/FileOutputStream:write	([B)V
    //   55: aload_1
    //   56: invokevirtual 348	java/io/FileOutputStream:close	()V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 348	java/io/FileOutputStream:close	()V
    //   66: iconst_0
    //   67: ireturn
    //   68: astore_1
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: goto -13 -> 59
    //   75: astore_1
    //   76: iconst_0
    //   77: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	by
    //   0	78	1	paramContext	android.content.Context
    //   61	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	55	61	java/lang/Exception
    //   62	66	68	java/io/IOException
    //   55	59	71	java/io/IOException
    //   28	37	75	java/io/FileNotFoundException
  }
  
  public boolean b()
  {
    if (c.l()) {
      return false;
    }
    return a(RqdApplication.l());
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 42	com/tencent/token/by:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 255	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   20: ldc_w 333
    //   23: invokevirtual 354	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -22 -> 6
    //   31: sipush 2000
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 360	java/io/FileInputStream:read	([B)I
    //   42: pop
    //   43: aload_0
    //   44: new 48	org/json/JSONArray
    //   47: dup
    //   48: new 112	java/lang/String
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 160	java/lang/String:<init>	([B)V
    //   56: invokespecial 361	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   59: putfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   62: aload_1
    //   63: invokevirtual 362	java/io/FileInputStream:close	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 362	java/io/FileInputStream:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: goto -13 -> 66
    //   82: astore_1
    //   83: iconst_0
    //   84: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	by
    //   26	44	1	localFileInputStream	java.io.FileInputStream
    //   75	1	1	localIOException1	java.io.IOException
    //   78	1	1	localIOException2	java.io.IOException
    //   82	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   36	17	2	arrayOfByte	byte[]
    //   68	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	62	68	java/lang/Exception
    //   69	73	75	java/io/IOException
    //   62	66	78	java/io/IOException
    //   17	27	82	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.by
 * JD-Core Version:    0.7.0.1
 */