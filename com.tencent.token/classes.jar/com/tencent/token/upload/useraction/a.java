package com.tencent.token.upload.useraction;

import android.content.ContentValues;
import android.view.MotionEvent;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.ez;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  private static int j = 20;
  private static int k = 20;
  private static int l = j;
  private static boolean m = false;
  private static a n = null;
  private static boolean p = false;
  public boolean a = true;
  protected JSONArray g = new JSONArray();
  protected String h;
  private int i;
  private boolean o = false;
  private QQUser q = null;
  private boolean r;
  private UserTask<String, String, e> s = null;
  private MotionEvent t;
  private int u = b;
  
  private e a(String paramString)
  {
    e locale = new e();
    if (!cr.a().o())
    {
      if (this.r) {
        e();
      }
      locale.b(30001);
    }
    for (;;)
    {
      return locale;
      g.a("useraction data=" + paramString);
      Object localObject = l.b(paramString.getBytes());
      paramString = c.e() + "/cn/mbtoken3/mbtoken3_user_action_report_encrypt";
      ContentValues localContentValues = new ContentValues(3);
      localContentValues.put("aq_base_sid", cr.c);
      localContentValues.put("data", (String)localObject);
      g.a("useraction aq_base_sid=" + cr.c);
      g.a("useraction data=" + (String)localObject);
      localObject = new ez();
      paramString = ((ez)localObject).a(paramString, localContentValues);
      if (paramString == null)
      {
        if (this.r) {
          e();
        }
        locale.a(((ez)localObject).a());
        return locale;
      }
      try
      {
        paramString = new JSONObject(new String(paramString));
        i1 = paramString.getInt("err");
        if (i1 != 0)
        {
          paramString = paramString.getString("info");
          locale.a(i1, paramString, paramString);
        }
        for (;;)
        {
          return locale;
          locale.c();
          if (this.g.length() <= k) {
            break;
          }
          i1 = k;
          if (i1 > k) {
            break label389;
          }
          this.g = new JSONArray();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          g.c("parse json failed: " + paramString.toString());
          locale.a(10020, "JSONException:" + paramString.toString());
          return locale;
          int i1 = this.g.length();
          continue;
          paramString = new JSONArray();
          while (i1 < this.g.length())
          {
            paramString.put(this.g.get(i1));
            i1 += 1;
          }
          this.g = paramString;
        }
      }
      catch (Exception paramString)
      {
        label389:
        g.c("unknown err: " + paramString.toString());
        locale.a(10021, "JSONException:" + paramString.toString());
        return locale;
      }
      finally
      {
        if (this.r) {
          e();
        }
      }
    }
  }
  
  public static a a()
  {
    if (n == null) {
      n = new a();
    }
    if ((!c.l()) && (!p))
    {
      p = true;
      n.f();
    }
    return n;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, long paramLong)
  {
    if (c.l()) {}
    while (this.g == null) {
      return;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          this.q = cr.a().e();
          if (this.q != null)
          {
            localJSONObject.put("real_uin", this.q.b());
            localJSONObject.put("type", paramInt1);
            localJSONObject.put("cgi_name", paramString1);
            localJSONObject.put("page_name", paramString2);
            localJSONObject.put("ctrl_name", paramString3);
            localJSONObject.put("optional_A", paramString4);
            localJSONObject.put("optional_B", paramString5);
            localJSONObject.put("touch_x", paramInt2);
            localJSONObject.put("touch_y", paramInt3);
            localJSONObject.put("touch_time", paramLong);
          }
        }
        catch (Exception paramString1)
        {
          JSONObject localJSONObject;
          continue;
        }
        try
        {
          this.g.put(localJSONObject);
          if ((this.g.length() < l) || (!m)) {
            break;
          }
          b(false);
          return;
        }
        finally {}
      }
      localJSONObject.put("real_uin", 0L);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.t = paramMotionEvent;
  }
  
  public void a(boolean paramBoolean)
  {
    m = paramBoolean;
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 220	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 60	com/tencent/token/upload/useraction/a:p	Z
    //   19: aload_0
    //   20: getfield 66	com/tencent/token/upload/useraction/a:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc_w 276
    //   32: iconst_0
    //   33: invokevirtual 282	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -32 -> 6
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   46: invokevirtual 283	org/json/JSONArray:toString	()Ljava/lang/String;
    //   49: invokevirtual 129	java/lang/String:getBytes	()[B
    //   52: invokevirtual 288	java/io/FileOutputStream:write	([B)V
    //   55: aload_1
    //   56: invokevirtual 291	java/io/FileOutputStream:close	()V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 291	java/io/FileOutputStream:close	()V
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
    //   0	78	0	this	a
    //   0	78	1	paramContext	android.content.Context
    //   61	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	55	61	java/lang/Exception
    //   62	66	68	java/io/IOException
    //   55	59	71	java/io/IOException
    //   28	37	75	java/io/FileNotFoundException
  }
  
  public MotionEvent b()
  {
    return this.t;
  }
  
  public void b(boolean paramBoolean)
  {
    if (c.l()) {}
    do
    {
      return;
      this.r = paramBoolean;
    } while ((this.o) || (!this.a) || (this.g.length() == 0));
    int i1 = cb.a + 1;
    cb.a = i1;
    this.i = i1;
    this.o = true;
    JSONArray localJSONArray = new JSONArray();
    if (this.g.length() > k) {}
    for (i1 = k;; i1 = this.g.length())
    {
      int i2 = 0;
      for (;;)
      {
        if (i2 >= i1) {
          break label123;
        }
        try
        {
          localJSONArray.put(this.g.get(i2));
          i2 += 1;
        }
        catch (Exception localException2) {}
      }
    }
    try
    {
      label123:
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (cr.a().e() != null) {
          localJSONObject.put("uin", cr.a().e().mUin);
        }
        localJSONObject.put("seq_id", this.i);
        localJSONObject.put("op_time", (int)(cc.c().s() / 1000L));
        localJSONObject.put("token_seq", cc.c().k());
        localJSONObject.put("action_list", localJSONArray);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          g.c("JSONException:" + localException1.getMessage());
        }
      }
      this.h = localJSONObject.toString();
      this.s = new UserTask()
      {
        public e a(String... paramAnonymousVarArgs)
        {
          return a.a(a.this, a.this.h);
        }
        
        public void a()
        {
          a.a(a.this, false);
        }
        
        public void a(e paramAnonymouse)
        {
          if (paramAnonymouse.b()) {
            a.b(a.g());
          }
          for (;;)
          {
            a.a(a.this, false);
            return;
            g.c("post click flow msg failed:" + paramAnonymouse.a + "-" + paramAnonymouse.b);
            if (a.h() < a.i()) {}
            try
            {
              a.b(a.i());
            }
            catch (Exception paramAnonymouse)
            {
              continue;
              a.b(a.g());
            }
            catch (Error paramAnonymouse) {}
          }
        }
      };
      this.s.c(new String[0]);
      return;
    }
    finally {}
  }
  
  public int c()
  {
    return this.u;
  }
  
  public void d()
  {
    this.t = null;
    this.u = b;
  }
  
  public boolean e()
  {
    if (c.l()) {
      return false;
    }
    return a(RqdApplication.l());
  }
  
  /* Error */
  public boolean f()
  {
    // Byte code:
    //   0: invokestatic 220	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 66	com/tencent/token/upload/useraction/a:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 345	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   20: ldc_w 276
    //   23: invokevirtual 351	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -22 -> 6
    //   31: sipush 2000
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 357	java/io/FileInputStream:read	([B)I
    //   42: pop
    //   43: aload_0
    //   44: new 76	org/json/JSONArray
    //   47: dup
    //   48: new 125	java/lang/String
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 173	java/lang/String:<init>	([B)V
    //   56: invokespecial 358	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   59: putfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   62: aload_1
    //   63: invokevirtual 359	java/io/FileInputStream:close	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 359	java/io/FileInputStream:close	()V
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
    //   0	85	0	this	a
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
 * Qualified Name:     com.tencent.token.upload.useraction.a
 * JD-Core Version:    0.7.0.1
 */