package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{
  private static int d = 20;
  private static int e = 30;
  private static int f = d;
  private static p g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask k = null;
  
  private d a(String paramString)
  {
    locald = new d((byte)0);
    Object localObject1 = ax.a();
    if (!((ax)localObject1).o())
    {
      if ((this.j) && (!b.i())) {
        a(RqdApplication.i());
      }
      locald.a(30001, null, null);
      return locald;
    }
    long l = 0L;
    Object localObject2 = ((ax)localObject1).k();
    if (localObject2 != null) {
      l = ((QQUser)localObject2).mUin;
    }
    for (;;)
    {
      localObject2 = s.b(paramString.getBytes());
      paramString = b.c() + "/cn/mbtoken3/mbtoken3_click_flow";
      localObject1 = new ContentValues(3);
      ((ContentValues)localObject1).put("aq_base_sid", ax.c);
      ((ContentValues)localObject1).put("uin", Long.valueOf(l));
      ((ContentValues)localObject1).put("data", (String)localObject2);
      e.a("clickflow aq_base_sid=" + ax.c);
      e.a("clickflow data=" + (String)localObject2);
      localObject2 = new gv();
      paramString = ((gv)localObject2).a(paramString, (ContentValues)localObject1);
      if (paramString != null) {
        break;
      }
      if ((this.j) && (!b.i())) {
        a(RqdApplication.i());
      }
      paramString = ((gv)localObject2).a();
      locald.a(paramString.a, paramString.b, paramString.c);
      return locald;
      localObject1 = ((ax)localObject1).e();
      if (localObject1 != null) {
        l = ((QQUser)localObject1).mUin;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(new String(paramString));
        m = paramString.getInt("err");
        if (m == 0) {
          continue;
        }
        paramString = paramString.getString("info");
        locald.a(m, paramString, paramString);
      }
      catch (JSONException paramString)
      {
        e.c("parse json failed: " + paramString.toString());
        locald.a(10020, "JSONException:" + paramString.toString(), null);
        if ((!this.j) || (b.i())) {
          continue;
        }
        a(RqdApplication.i());
        continue;
        int m = this.b.length();
        continue;
        paramString = new JSONArray();
        if (m >= this.b.length()) {
          continue;
        }
        paramString.put(this.b.get(m));
        m += 1;
        continue;
        this.b = paramString;
        continue;
      }
      catch (Exception paramString)
      {
        e.c("unknown err: " + paramString.toString());
        locald.a(10021, "JSONException:" + paramString.toString(), null);
        if ((!this.j) || (b.i())) {
          continue;
        }
        a(RqdApplication.i());
        continue;
      }
      finally
      {
        if ((!this.j) || (b.i())) {
          continue;
        }
        a(RqdApplication.i());
      }
      if ((this.j) && (!b.i())) {
        a(RqdApplication.i());
      }
      return locald;
      locald.a = 0;
      if (this.b.length() <= e) {
        continue;
      }
      m = e;
      if (m > e) {
        continue;
      }
      this.b = new JSONArray();
    }
  }
  
  public static p a()
  {
    if (g == null) {
      g = new p();
    }
    if ((!b.i()) && (!i))
    {
      i = true;
      g.f();
    }
    return g;
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: invokestatic 77	com/tencent/token/global/b:i	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 39	com/tencent/token/p:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 82	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   20: ldc 225
    //   22: invokevirtual 231	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -21 -> 6
    //   30: sipush 2000
    //   33: newarray byte
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 237	java/io/FileInputStream:read	([B)I
    //   41: pop
    //   42: aload_0
    //   43: new 45	org/json/JSONArray
    //   46: dup
    //   47: new 99	java/lang/String
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 179	java/lang/String:<init>	([B)V
    //   55: invokespecial 238	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   58: putfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   61: aload_1
    //   62: invokevirtual 241	java/io/FileInputStream:close	()V
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_2
    //   68: aload_1
    //   69: invokevirtual 241	java/io/FileInputStream:close	()V
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
    //   0	84	0	this	p
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
  
  public final void a(long paramLong, int paramInt)
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
          localJSONObject.put("t", paramLong / 1000L);
          localJSONObject.put("e", paramInt);
          localObject2 = ax.a().e();
          if (localObject2 != null) {
            localJSONObject.put("u", ((QQUser)localObject2).mUin);
          }
          int i1 = 1;
          m = 0;
          n = i1;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          Object localObject2;
          int m;
          int n;
          continue;
        }
        try
        {
          if (m < this.b.length())
          {
            localObject2 = this.b.getJSONObject(m);
            if ((((JSONObject)localObject2).getInt("e") == paramInt) && (((JSONObject)localObject2).getLong("t") == paramLong / 1000L)) {
              n = 0;
            }
          }
          else
          {
            if (n != 0) {
              this.b.put(localJSONObject);
            }
            if (this.b.length() < f) {
              break;
            }
            a(false);
            return;
          }
          m += 1;
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 77	com/tencent/token/global/b:i	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 73	com/tencent/token/p:j	Z
    //   12: aload_0
    //   13: getfield 41	com/tencent/token/p:h	Z
    //   16: ifne -10 -> 6
    //   19: aload_0
    //   20: getfield 39	com/tencent/token/p:a	Z
    //   23: ifeq -17 -> 6
    //   26: aload_0
    //   27: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   30: invokevirtual 197	org/json/JSONArray:length	()I
    //   33: ifeq -27 -> 6
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 41	com/tencent/token/p:h	Z
    //   41: new 45	org/json/JSONArray
    //   44: dup
    //   45: invokespecial 46	org/json/JSONArray:<init>	()V
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   54: invokevirtual 197	org/json/JSONArray:length	()I
    //   57: getstatic 27	com/tencent/token/p:e	I
    //   60: if_icmple +35 -> 95
    //   63: getstatic 27	com/tencent/token/p:e	I
    //   66: istore_2
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: iload_2
    //   71: if_icmpge +37 -> 108
    //   74: aload 4
    //   76: aload_0
    //   77: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   80: iload_3
    //   81: invokevirtual 208	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   84: invokevirtual 211	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   87: pop
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: goto -23 -> 69
    //   95: aload_0
    //   96: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   99: invokevirtual 197	org/json/JSONArray:length	()I
    //   102: istore_2
    //   103: goto -36 -> 67
    //   106: astore 5
    //   108: aload_0
    //   109: monitorenter
    //   110: new 176	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 243	org/json/JSONObject:<init>	()V
    //   117: astore 5
    //   119: aload 5
    //   121: ldc_w 269
    //   124: invokestatic 274	com/tencent/token/ag:c	()Lcom/tencent/token/ag;
    //   127: invokevirtual 277	com/tencent/token/ag:k	()J
    //   130: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   133: invokevirtual 283	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 5
    //   139: ldc_w 285
    //   142: aload 4
    //   144: invokevirtual 283	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_0
    //   149: aload 5
    //   151: invokevirtual 286	org/json/JSONObject:toString	()Ljava/lang/String;
    //   154: putfield 287	com/tencent/token/p:c	Ljava/lang/String;
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_0
    //   160: new 289	com/tencent/token/q
    //   163: dup
    //   164: aload_0
    //   165: invokespecial 292	com/tencent/token/q:<init>	(Lcom/tencent/token/p;)V
    //   168: putfield 43	com/tencent/token/p:k	Lcom/tencent/token/utils/UserTask;
    //   171: aload_0
    //   172: getfield 43	com/tencent/token/p:k	Lcom/tencent/token/utils/UserTask;
    //   175: iconst_0
    //   176: anewarray 99	java/lang/String
    //   179: invokevirtual 297	com/tencent/token/utils/UserTask:a	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   182: pop
    //   183: return
    //   184: astore 4
    //   186: aload_0
    //   187: monitorexit
    //   188: return
    //   189: astore 4
    //   191: aload_0
    //   192: monitorexit
    //   193: aload 4
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	p
    //   0	196	1	paramBoolean	boolean
    //   66	37	2	m	int
    //   68	24	3	n	int
    //   48	95	4	localJSONArray	JSONArray
    //   184	1	4	localJSONException	JSONException
    //   189	5	4	localObject	Object
    //   106	1	5	localException	Exception
    //   117	33	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   74	88	106	java/lang/Exception
    //   119	148	184	org/json/JSONException
    //   110	119	189	finally
    //   119	148	189	finally
    //   148	159	189	finally
    //   186	188	189	finally
  }
  
  /* Error */
  public final boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 77	com/tencent/token/global/b:i	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 33	com/tencent/token/p:i	Z
    //   19: aload_0
    //   20: getfield 39	com/tencent/token/p:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc 225
    //   31: iconst_0
    //   32: invokevirtual 301	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull -31 -> 6
    //   40: aload_1
    //   41: aload_0
    //   42: getfield 48	com/tencent/token/p:b	Lorg/json/JSONArray;
    //   45: invokevirtual 302	org/json/JSONArray:toString	()Ljava/lang/String;
    //   48: invokevirtual 103	java/lang/String:getBytes	()[B
    //   51: invokevirtual 307	java/io/FileOutputStream:write	([B)V
    //   54: aload_1
    //   55: invokevirtual 308	java/io/FileOutputStream:close	()V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 308	java/io/FileOutputStream:close	()V
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
    //   0	77	0	this	p
    //   0	77	1	paramContext	android.content.Context
    //   60	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   40	54	60	java/lang/Exception
    //   61	65	67	java/io/IOException
    //   54	58	70	java/io/IOException
    //   28	36	74	java/io/FileNotFoundException
  }
  
  public final boolean b()
  {
    if (b.i()) {
      return false;
    }
    return a(RqdApplication.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.p
 * JD-Core Version:    0.7.0.1
 */