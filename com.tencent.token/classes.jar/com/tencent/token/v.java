package com.tencent.token;

import android.content.ContentValues;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.s;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v
{
  private static int d = 10;
  private static int e = 15;
  private static int f = d;
  private static v g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask k = null;
  
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
  
  private d a(String paramString)
  {
    d locald = new d((byte)0);
    Object localObject1 = ax.a();
    if (!((ax)localObject1).o())
    {
      locald.a(30001, null, null);
      if ((this.j) && (!b.i())) {
        a(RqdApplication.i());
      }
    }
    for (;;)
    {
      return locald;
      if (((ax)localObject1).k() == null) {
        ((ax)localObject1).e();
      }
      e.a("netflow data=" + paramString);
      Object localObject2 = s.b(paramString.getBytes());
      paramString = b.c() + "/cn/mbtoken3/mbtoken3_qos_report";
      localObject1 = new ContentValues(3);
      ((ContentValues)localObject1).put("aq_base_sid", ax.c);
      ((ContentValues)localObject1).put("data", (String)localObject2);
      e.a("netflow aq_base_sid=" + ax.c);
      e.a("netflow data=" + (String)localObject2);
      localObject2 = new gv();
      paramString = ((gv)localObject2).a(paramString, (ContentValues)localObject1);
      if (paramString == null)
      {
        if ((this.j) && (!b.i())) {
          a(RqdApplication.i());
        }
        paramString = ((gv)localObject2).a();
        locald.a(paramString.a, paramString.b, paramString.c);
        return locald;
      }
      try
      {
        paramString = new JSONObject(new String(paramString));
        m = paramString.getInt("err");
        if (m != 0)
        {
          paramString = paramString.getString("info");
          locald.a(m, paramString, paramString);
        }
        for (;;)
        {
          return locald;
          locald.a = 0;
          if (this.b.length() <= e) {
            break;
          }
          m = e;
          if (m > e) {
            break label461;
          }
          this.b = new JSONArray();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          e.c("parse json failed: " + paramString.toString());
          locald.a(10020, "JSONException:" + paramString.toString(), null);
          return locald;
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
        label461:
        e.c("unknown err: " + paramString.toString());
        locald.a(10021, "JSONException:" + paramString.toString(), null);
        return locald;
      }
      finally
      {
        if ((this.j) && (!b.i())) {
          a(RqdApplication.i());
        }
      }
    }
  }
  
  public static v a()
  {
    if (g == null) {
      g = new v();
    }
    if ((!b.i()) && (!i))
    {
      i = true;
      g.e();
    }
    return g;
  }
  
  /* Error */
  private boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/token/global/b:i	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 48	com/tencent/token/v:b	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 33	com/tencent/token/v:i	Z
    //   19: aload_0
    //   20: getfield 39	com/tencent/token/v:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc 208
    //   31: iconst_0
    //   32: invokevirtual 214	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull -31 -> 6
    //   40: aload_1
    //   41: aload_0
    //   42: getfield 48	com/tencent/token/v:b	Lorg/json/JSONArray;
    //   45: invokevirtual 215	org/json/JSONArray:toString	()Ljava/lang/String;
    //   48: invokevirtual 118	java/lang/String:getBytes	()[B
    //   51: invokevirtual 220	java/io/FileOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 223	java/io/FileOutputStream:close	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_1
    //   71: goto -13 -> 58
    //   74: astore_1
    //   75: iconst_0
    //   76: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	v
    //   0	77	1	paramContext	android.content.Context
    //   60	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   40	54	60	java/lang/Exception
    //   61	65	67	java/io/IOException
    //   54	58	70	java/io/IOException
    //   28	36	74	java/io/FileNotFoundException
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/token/global/b:i	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 39	com/tencent/token/v:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 86	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   20: ldc 208
    //   22: invokevirtual 228	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -21 -> 6
    //   30: sipush 2000
    //   33: newarray byte
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 234	java/io/FileInputStream:read	([B)I
    //   41: pop
    //   42: aload_0
    //   43: new 45	org/json/JSONArray
    //   46: dup
    //   47: new 114	java/lang/String
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 163	java/lang/String:<init>	([B)V
    //   55: invokespecial 235	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   58: putfield 48	com/tencent/token/v:b	Lorg/json/JSONArray;
    //   61: aload_1
    //   62: invokevirtual 236	java/io/FileInputStream:close	()V
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_2
    //   68: aload_1
    //   69: invokevirtual 236	java/io/FileInputStream:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_1
    //   78: goto -13 -> 65
    //   81: astore_1
    //   82: iconst_0
    //   83: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	v
    //   25	44	1	localFileInputStream	java.io.FileInputStream
    //   74	1	1	localIOException1	java.io.IOException
    //   77	1	1	localIOException2	java.io.IOException
    //   81	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   35	17	2	arrayOfByte	byte[]
    //   67	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	61	67	java/lang/Exception
    //   68	72	74	java/io/IOException
    //   61	65	77	java/io/IOException
    //   17	26	81	java/io/FileNotFoundException
  }
  
  public final void a(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    if (b.i()) {}
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
  
  public final void a(boolean paramBoolean)
  {
    if (b.i()) {}
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
        localJSONObject.put("tkn_seq", String.valueOf(ag.c().k()));
        if (ax.a().e() != null) {
          localJSONObject.put("uin", ax.a().e().mRealUin);
        }
        String str = s.c(RqdApplication.i());
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.put("mac", str);
        }
        str = s.b(RqdApplication.i());
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.put("device_id", str);
        }
        localJSONObject.put("model", URLEncoder.encode(Build.MODEL));
        localJSONObject.put("release", URLEncoder.encode(Build.VERSION.RELEASE));
        localJSONObject.put("platfrom", "android");
        localJSONObject.put("guid", s.a(x.a(RqdApplication.i()).c()));
        str = s.d(RqdApplication.i());
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
          e.c("JSONException:" + localException1.getMessage());
        }
      }
      this.c = localJSONObject.toString();
      this.k = new w(this);
      this.k.a(new String[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.v
 * JD-Core Version:    0.7.0.1
 */