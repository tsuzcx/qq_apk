package com.tencent.token;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.UserTask;
import java.net.URLEncoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ry
{
  private static int d = 10;
  private static int e = 15;
  private static int f = d;
  private static ry g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask<String, String, wz> k = null;
  
  public static int a(int paramInt)
  {
    if (paramInt != 103)
    {
      if (paramInt != 10005)
      {
        if (paramInt != 100004)
        {
          switch (paramInt)
          {
          default: 
            return 40001;
          case 10003: 
            return 10003;
          case 10002: 
            return 10002;
          }
          return 10001;
        }
        return 10004;
      }
      return 10005;
    }
    return 30001;
  }
  
  public static ry a()
  {
    if (g == null) {
      g = new ry();
    }
    if ((!wx.j()) && (!i))
    {
      i = true;
      g.f();
    }
    return g;
  }
  
  /* Error */
  private wz a(String paramString)
  {
    // Byte code:
    //   0: new 77	com/tencent/token/wz
    //   3: dup
    //   4: invokespecial 78	com/tencent/token/wz:<init>	()V
    //   7: astore_3
    //   8: invokestatic 83	com/tencent/token/ta:a	()Lcom/tencent/token/ta;
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 85	com/tencent/token/ta:i	()Z
    //   18: ifne +26 -> 44
    //   21: aload_3
    //   22: sipush 30001
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 88	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 90	com/tencent/token/ry:j	Z
    //   34: ifeq +8 -> 42
    //   37: aload_0
    //   38: invokespecial 92	com/tencent/token/ry:e	()Z
    //   41: pop
    //   42: aload_3
    //   43: areturn
    //   44: aload 4
    //   46: invokevirtual 95	com/tencent/token/ta:f	()Lcom/tencent/token/core/bean/QQUser;
    //   49: ifnonnull +12 -> 61
    //   52: aload 4
    //   54: getfield 98	com/tencent/token/ta:k	Lcom/tencent/token/ahh;
    //   57: invokevirtual 102	com/tencent/token/ahh:b	()Lcom/tencent/token/core/bean/QQUser;
    //   60: pop
    //   61: ldc 104
    //   63: aload_1
    //   64: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokestatic 119	com/tencent/token/xb:a	(Ljava/lang/String;)V
    //   73: new 121	java/util/concurrent/CountDownLatch
    //   76: dup
    //   77: iconst_1
    //   78: invokespecial 124	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   81: astore 5
    //   83: new 126	java/util/concurrent/atomic/AtomicReference
    //   86: dup
    //   87: aconst_null
    //   88: invokespecial 129	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   91: astore 4
    //   93: invokestatic 134	com/tencent/token/qz:a	()Lcom/tencent/token/qz;
    //   96: aload_1
    //   97: new 6	com/tencent/token/ry$1
    //   100: dup
    //   101: aload_0
    //   102: aload 4
    //   104: aload 5
    //   106: invokespecial 137	com/tencent/token/ry$1:<init>	(Lcom/tencent/token/ry;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   109: invokevirtual 140	com/tencent/token/qz:d	(Ljava/lang/String;Lcom/tencent/token/qz$a;)V
    //   112: aload 5
    //   114: invokevirtual 143	java/util/concurrent/CountDownLatch:await	()V
    //   117: goto +8 -> 125
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 146	java/lang/InterruptedException:printStackTrace	()V
    //   125: aload 4
    //   127: invokevirtual 150	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   130: checkcast 152	com/tencent/token/rb
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +26 -> 161
    //   138: aload_0
    //   139: getfield 90	com/tencent/token/ry:j	Z
    //   142: ifeq +8 -> 150
    //   145: aload_0
    //   146: invokespecial 92	com/tencent/token/ry:e	()Z
    //   149: pop
    //   150: aload_3
    //   151: sipush -799
    //   154: aconst_null
    //   155: aconst_null
    //   156: invokevirtual 88	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   159: aload_3
    //   160: areturn
    //   161: aload_1
    //   162: getfield 154	com/tencent/token/rb:b	I
    //   165: istore_2
    //   166: iload_2
    //   167: ifeq +18 -> 185
    //   170: aload_1
    //   171: getfield 156	com/tencent/token/rb:d	Ljava/lang/String;
    //   174: astore_1
    //   175: aload_3
    //   176: iload_2
    //   177: aload_1
    //   178: aload_1
    //   179: invokevirtual 88	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   182: goto +101 -> 283
    //   185: aload_3
    //   186: iconst_0
    //   187: putfield 158	com/tencent/token/wz:a	I
    //   190: aload_0
    //   191: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   194: invokevirtual 162	org/json/JSONArray:length	()I
    //   197: getstatic 164	com/tencent/token/ry:e	I
    //   200: if_icmple +10 -> 210
    //   203: getstatic 164	com/tencent/token/ry:e	I
    //   206: istore_2
    //   207: goto +11 -> 218
    //   210: aload_0
    //   211: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   214: invokevirtual 162	org/json/JSONArray:length	()I
    //   217: istore_2
    //   218: iload_2
    //   219: getstatic 164	com/tencent/token/ry:e	I
    //   222: if_icmpgt +17 -> 239
    //   225: aload_0
    //   226: new 50	org/json/JSONArray
    //   229: dup
    //   230: invokespecial 51	org/json/JSONArray:<init>	()V
    //   233: putfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   236: goto +47 -> 283
    //   239: new 50	org/json/JSONArray
    //   242: dup
    //   243: invokespecial 51	org/json/JSONArray:<init>	()V
    //   246: astore_1
    //   247: iload_2
    //   248: aload_0
    //   249: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   252: invokevirtual 162	org/json/JSONArray:length	()I
    //   255: if_icmpge +23 -> 278
    //   258: aload_1
    //   259: aload_0
    //   260: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   263: iload_2
    //   264: invokevirtual 167	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   267: invokevirtual 171	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   270: pop
    //   271: iload_2
    //   272: iconst_1
    //   273: iadd
    //   274: istore_2
    //   275: goto -28 -> 247
    //   278: aload_0
    //   279: aload_1
    //   280: putfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   283: aload_0
    //   284: getfield 90	com/tencent/token/ry:j	Z
    //   287: ifeq +162 -> 449
    //   290: aload_0
    //   291: invokespecial 92	com/tencent/token/ry:e	()Z
    //   294: pop
    //   295: aload_3
    //   296: areturn
    //   297: astore_1
    //   298: goto +153 -> 451
    //   301: astore_1
    //   302: new 173	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 175
    //   308: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: astore 4
    //   313: aload 4
    //   315: aload_1
    //   316: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   319: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 4
    //   325: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 188	com/tencent/token/xb:c	(Ljava/lang/String;)V
    //   331: new 173	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 190
    //   337: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: astore 4
    //   342: aload 4
    //   344: aload_1
    //   345: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   348: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_3
    //   353: sipush 10021
    //   356: aload 4
    //   358: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: aconst_null
    //   362: invokevirtual 88	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   365: aload_0
    //   366: getfield 90	com/tencent/token/ry:j	Z
    //   369: ifeq +80 -> 449
    //   372: goto -82 -> 290
    //   375: astore_1
    //   376: new 173	java/lang/StringBuilder
    //   379: dup
    //   380: ldc 192
    //   382: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: astore 4
    //   387: aload 4
    //   389: aload_1
    //   390: invokevirtual 193	org/json/JSONException:toString	()Ljava/lang/String;
    //   393: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 4
    //   399: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 188	com/tencent/token/xb:c	(Ljava/lang/String;)V
    //   405: new 173	java/lang/StringBuilder
    //   408: dup
    //   409: ldc 190
    //   411: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: astore 4
    //   416: aload 4
    //   418: aload_1
    //   419: invokevirtual 193	org/json/JSONException:toString	()Ljava/lang/String;
    //   422: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_3
    //   427: sipush 10020
    //   430: aload 4
    //   432: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: aconst_null
    //   436: invokevirtual 88	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   439: aload_0
    //   440: getfield 90	com/tencent/token/ry:j	Z
    //   443: ifeq +6 -> 449
    //   446: goto -156 -> 290
    //   449: aload_3
    //   450: areturn
    //   451: aload_0
    //   452: getfield 90	com/tencent/token/ry:j	Z
    //   455: ifeq +8 -> 463
    //   458: aload_0
    //   459: invokespecial 92	com/tencent/token/ry:e	()Z
    //   462: pop
    //   463: aload_1
    //   464: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	ry
    //   0	465	1	paramString	String
    //   165	110	2	m	int
    //   7	443	3	localwz	wz
    //   11	420	4	localObject	Object
    //   81	32	5	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   112	117	120	java/lang/InterruptedException
    //   161	166	297	finally
    //   170	182	297	finally
    //   185	207	297	finally
    //   210	218	297	finally
    //   218	236	297	finally
    //   239	247	297	finally
    //   247	271	297	finally
    //   278	283	297	finally
    //   302	365	297	finally
    //   376	439	297	finally
    //   161	166	301	java/lang/Exception
    //   170	182	301	java/lang/Exception
    //   185	207	301	java/lang/Exception
    //   210	218	301	java/lang/Exception
    //   218	236	301	java/lang/Exception
    //   239	247	301	java/lang/Exception
    //   247	271	301	java/lang/Exception
    //   278	283	301	java/lang/Exception
    //   161	166	375	org/json/JSONException
    //   170	182	375	org/json/JSONException
    //   185	207	375	org/json/JSONException
    //   210	218	375	org/json/JSONException
    //   218	236	375	org/json/JSONException
    //   239	247	375	org/json/JSONException
    //   247	271	375	org/json/JSONException
    //   278	283	375	org/json/JSONException
  }
  
  /* Error */
  private boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/token/wx:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 38	com/tencent/token/ry:i	Z
    //   21: aload_0
    //   22: getfield 44	com/tencent/token/ry:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc 200
    //   33: iconst_0
    //   34: invokevirtual 206	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   49: invokevirtual 207	org/json/JSONArray:toString	()Ljava/lang/String;
    //   52: invokevirtual 211	java/lang/String:getBytes	()[B
    //   55: invokevirtual 217	java/io/FileOutputStream:write	([B)V
    //   58: aload_1
    //   59: invokevirtual 220	java/io/FileOutputStream:close	()V
    //   62: iconst_1
    //   63: ireturn
    //   64: aload_1
    //   65: invokevirtual 220	java/io/FileOutputStream:close	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_1
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_2
    //   74: goto -10 -> 64
    //   77: astore_1
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_1
    //   81: iconst_0
    //   82: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	ry
    //   0	83	1	paramContext	android.content.Context
    //   73	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	70	java/io/FileNotFoundException
    //   44	58	73	java/lang/Exception
    //   58	62	77	java/io/IOException
    //   64	68	80	java/io/IOException
  }
  
  private boolean e()
  {
    if (wx.j()) {
      return false;
    }
    return a(RqdApplication.n());
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/token/wx:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 44	com/tencent/token/ry:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 227	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   20: ldc 200
    //   22: invokevirtual 233	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: sipush 2000
    //   35: newarray byte
    //   37: astore_2
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 239	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_0
    //   45: new 50	org/json/JSONArray
    //   48: dup
    //   49: new 106	java/lang/String
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 241	java/lang/String:<init>	([B)V
    //   57: invokespecial 242	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   60: putfield 53	com/tencent/token/ry:b	Lorg/json/JSONArray;
    //   63: aload_1
    //   64: invokevirtual 243	java/io/FileInputStream:close	()V
    //   67: iconst_1
    //   68: ireturn
    //   69: aload_1
    //   70: invokevirtual 243	java/io/FileInputStream:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_2
    //   79: goto -10 -> 69
    //   82: astore_1
    //   83: iconst_1
    //   84: ireturn
    //   85: astore_1
    //   86: iconst_0
    //   87: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ry
    //   25	45	1	localFileInputStream	java.io.FileInputStream
    //   75	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   82	1	1	localIOException1	java.io.IOException
    //   85	1	1	localIOException2	java.io.IOException
    //   37	17	2	arrayOfByte	byte[]
    //   78	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	26	75	java/io/FileNotFoundException
    //   32	63	78	java/lang/Exception
    //   63	67	82	java/io/IOException
    //   69	73	85	java/io/IOException
  }
  
  public final void a(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    if (wx.j()) {
      return;
    }
    if (this.b == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", paramLong);
      localJSONObject.put("e", paramInt1);
      localJSONObject.put("p", paramString1);
      localJSONObject.put("s", paramInt2);
      localJSONObject.put("d", paramString2);
      localJSONObject.put("nt", paramString3);
      try
      {
        this.b.put(localJSONObject);
      }
      finally {}
    }
    catch (Exception paramString1)
    {
      label110:
      break label110;
    }
    if (this.b.length() >= f) {
      a(false);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (wx.j()) {
      return;
    }
    this.j = paramBoolean;
    if (this.h) {
      return;
    }
    JSONArray localJSONArray;
    int n;
    int m;
    if (this.a)
    {
      if (this.b.length() == 0) {
        return;
      }
      this.h = true;
      localJSONArray = new JSONArray();
      n = this.b.length();
      m = e;
      if (n <= m) {
        m = this.b.length();
      }
      n = 0;
    }
    for (;;)
    {
      if (n < m) {}
      try
      {
        localJSONArray.put(this.b.get(n));
        n += 1;
      }
      catch (Exception localException1)
      {
        label108:
        JSONObject localJSONObject;
        Object localObject2;
        break label108;
      }
    }
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        if (ta.a().k.b() != null) {
          localJSONObject.put("uin", ta.a().k.b().mRealUin);
        }
        localObject2 = aad.c(RqdApplication.n());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("mac", localObject2);
        }
        localObject2 = aad.b(RqdApplication.n());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("device_id", localObject2);
        }
        localJSONObject.put("model", URLEncoder.encode(Build.MODEL));
        localJSONObject.put("release", URLEncoder.encode(Build.VERSION.RELEASE));
        localJSONObject.put("platfrom", "android");
        localJSONObject.put("guid", aad.a(rz.a(RqdApplication.n()).a.GetGuid()));
        localObject2 = aad.d(RqdApplication.n());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("router_id", localObject2);
        }
        localJSONObject.put("event_list", localJSONArray);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject2 = new StringBuilder("JSONException:");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        xb.c(((StringBuilder)localObject2).toString());
      }
      this.c = localJSONObject.toString();
      this.k = new UserTask()
      {
        public final void a()
        {
          ry.a(ry.this);
        }
      };
      this.k.a(new String[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ry
 * JD-Core Version:    0.7.0.1
 */