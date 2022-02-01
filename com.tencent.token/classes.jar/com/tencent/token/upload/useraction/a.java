package com.tencent.token.upload.useraction;

import android.view.MotionEvent;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import org.json.JSONArray;
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
  
  /* Error */
  private e a(String paramString)
  {
    // Byte code:
    //   0: new 89	com/tencent/token/global/e
    //   3: dup
    //   4: invokespecial 90	com/tencent/token/global/e:<init>	()V
    //   7: astore_3
    //   8: invokestatic 95	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   11: invokevirtual 98	com/tencent/token/cs:o	()Z
    //   14: ifne +24 -> 38
    //   17: aload_0
    //   18: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   21: ifeq +8 -> 29
    //   24: aload_0
    //   25: invokevirtual 102	com/tencent/token/upload/useraction/a:e	()Z
    //   28: pop
    //   29: aload_3
    //   30: sipush 30001
    //   33: invokevirtual 105	com/tencent/token/global/e:b	(I)V
    //   36: aload_3
    //   37: areturn
    //   38: new 107	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 110
    //   51: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: aload_1
    //   58: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 129	java/lang/String:getBytes	()[B
    //   74: invokestatic 134	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   77: astore_1
    //   78: new 107	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   85: astore 4
    //   87: aload 4
    //   89: invokestatic 138	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   92: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: ldc 140
    //   100: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 4
    //   111: new 142	android/content/ContentValues
    //   114: dup
    //   115: iconst_3
    //   116: invokespecial 144	android/content/ContentValues:<init>	(I)V
    //   119: astore 5
    //   121: aload 5
    //   123: ldc 146
    //   125: getstatic 148	com/tencent/token/cs:c	Ljava/lang/String;
    //   128: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload 5
    //   133: ldc 154
    //   135: aload_1
    //   136: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: new 107	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload 6
    //   150: ldc 156
    //   152: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: getstatic 148	com/tencent/token/cs:c	Ljava/lang/String;
    //   161: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   173: new 107	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   180: astore 6
    //   182: aload 6
    //   184: ldc 110
    //   186: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: aload_1
    //   193: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   205: new 158	com/tencent/token/fc
    //   208: dup
    //   209: invokespecial 159	com/tencent/token/fc:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: aload 4
    //   216: aload 5
    //   218: invokevirtual 162	com/tencent/token/fc:a	(Ljava/lang/String;Landroid/content/ContentValues;)[B
    //   221: astore 4
    //   223: aload 4
    //   225: ifnonnull +25 -> 250
    //   228: aload_0
    //   229: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   232: ifeq +8 -> 240
    //   235: aload_0
    //   236: invokevirtual 102	com/tencent/token/upload/useraction/a:e	()Z
    //   239: pop
    //   240: aload_3
    //   241: aload_1
    //   242: invokevirtual 165	com/tencent/token/fc:a	()Lcom/tencent/token/global/e;
    //   245: invokevirtual 168	com/tencent/token/global/e:a	(Lcom/tencent/token/global/e;)V
    //   248: aload_3
    //   249: areturn
    //   250: new 170	org/json/JSONObject
    //   253: dup
    //   254: new 125	java/lang/String
    //   257: dup
    //   258: aload 4
    //   260: invokespecial 173	java/lang/String:<init>	([B)V
    //   263: invokespecial 175	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: aload_1
    //   268: ldc 177
    //   270: invokevirtual 181	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   273: istore_2
    //   274: iload_2
    //   275: ifeq +20 -> 295
    //   278: aload_1
    //   279: ldc 183
    //   281: invokevirtual 187	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_1
    //   285: aload_3
    //   286: iload_2
    //   287: aload_1
    //   288: aload_1
    //   289: invokevirtual 190	com/tencent/token/global/e:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   292: goto +100 -> 392
    //   295: aload_3
    //   296: invokevirtual 192	com/tencent/token/global/e:c	()V
    //   299: aload_0
    //   300: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   303: invokevirtual 196	org/json/JSONArray:length	()I
    //   306: getstatic 198	com/tencent/token/upload/useraction/a:k	I
    //   309: if_icmple +10 -> 319
    //   312: getstatic 198	com/tencent/token/upload/useraction/a:k	I
    //   315: istore_2
    //   316: goto +11 -> 327
    //   319: aload_0
    //   320: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   323: invokevirtual 196	org/json/JSONArray:length	()I
    //   326: istore_2
    //   327: iload_2
    //   328: getstatic 198	com/tencent/token/upload/useraction/a:k	I
    //   331: if_icmpgt +17 -> 348
    //   334: aload_0
    //   335: new 76	org/json/JSONArray
    //   338: dup
    //   339: invokespecial 77	org/json/JSONArray:<init>	()V
    //   342: putfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   345: goto +47 -> 392
    //   348: new 76	org/json/JSONArray
    //   351: dup
    //   352: invokespecial 77	org/json/JSONArray:<init>	()V
    //   355: astore_1
    //   356: iload_2
    //   357: aload_0
    //   358: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   361: invokevirtual 196	org/json/JSONArray:length	()I
    //   364: if_icmpge +23 -> 387
    //   367: aload_1
    //   368: aload_0
    //   369: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   372: iload_2
    //   373: invokevirtual 202	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   376: invokevirtual 205	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   379: pop
    //   380: iload_2
    //   381: iconst_1
    //   382: iadd
    //   383: istore_2
    //   384: goto -28 -> 356
    //   387: aload_0
    //   388: aload_1
    //   389: putfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   392: aload_0
    //   393: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   396: ifeq +184 -> 580
    //   399: aload_0
    //   400: invokevirtual 102	com/tencent/token/upload/useraction/a:e	()Z
    //   403: pop
    //   404: aload_3
    //   405: areturn
    //   406: astore_1
    //   407: goto +175 -> 582
    //   410: astore_1
    //   411: new 107	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   418: astore 4
    //   420: aload 4
    //   422: ldc 207
    //   424: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 4
    //   430: aload_1
    //   431: invokevirtual 208	java/lang/Exception:toString	()Ljava/lang/String;
    //   434: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 4
    //   440: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 210	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   446: new 107	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   453: astore 4
    //   455: aload 4
    //   457: ldc 212
    //   459: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 4
    //   465: aload_1
    //   466: invokevirtual 208	java/lang/Exception:toString	()Ljava/lang/String;
    //   469: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_3
    //   474: sipush 10021
    //   477: aload 4
    //   479: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokevirtual 215	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   485: aload_0
    //   486: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   489: ifeq +91 -> 580
    //   492: goto -93 -> 399
    //   495: astore_1
    //   496: new 107	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   503: astore 4
    //   505: aload 4
    //   507: ldc 217
    //   509: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 4
    //   515: aload_1
    //   516: invokevirtual 218	org/json/JSONException:toString	()Ljava/lang/String;
    //   519: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 4
    //   525: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 210	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   531: new 107	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   538: astore 4
    //   540: aload 4
    //   542: ldc 212
    //   544: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 4
    //   550: aload_1
    //   551: invokevirtual 218	org/json/JSONException:toString	()Ljava/lang/String;
    //   554: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_3
    //   559: sipush 10020
    //   562: aload 4
    //   564: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokevirtual 215	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   570: aload_0
    //   571: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   574: ifeq +6 -> 580
    //   577: goto -178 -> 399
    //   580: aload_3
    //   581: areturn
    //   582: aload_0
    //   583: getfield 100	com/tencent/token/upload/useraction/a:r	Z
    //   586: ifeq +8 -> 594
    //   589: aload_0
    //   590: invokevirtual 102	com/tencent/token/upload/useraction/a:e	()Z
    //   593: pop
    //   594: aload_1
    //   595: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	a
    //   0	596	1	paramString	String
    //   273	111	2	i1	int
    //   7	574	3	locale	e
    //   45	518	4	localObject	Object
    //   119	98	5	localContentValues	android.content.ContentValues
    //   146	52	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   250	274	406	finally
    //   278	292	406	finally
    //   295	316	406	finally
    //   319	327	406	finally
    //   327	345	406	finally
    //   348	356	406	finally
    //   356	380	406	finally
    //   387	392	406	finally
    //   411	485	406	finally
    //   496	570	406	finally
    //   250	274	410	java/lang/Exception
    //   278	292	410	java/lang/Exception
    //   295	316	410	java/lang/Exception
    //   319	327	410	java/lang/Exception
    //   327	345	410	java/lang/Exception
    //   348	356	410	java/lang/Exception
    //   356	380	410	java/lang/Exception
    //   387	392	410	java/lang/Exception
    //   250	274	495	org/json/JSONException
    //   278	292	495	org/json/JSONException
    //   295	316	495	org/json/JSONException
    //   319	327	495	org/json/JSONException
    //   327	345	495	org/json/JSONException
    //   348	356	495	org/json/JSONException
    //   356	380	495	org/json/JSONException
    //   387	392	495	org/json/JSONException
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
    if (c.l()) {
      return;
    }
    if (this.g == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.q = cs.a().e();
      if (this.q != null) {
        localJSONObject.put("real_uin", this.q.b());
      } else {
        localJSONObject.put("real_uin", 0L);
      }
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("cgi_name", paramString1);
      localJSONObject.put("page_name", paramString2);
      localJSONObject.put("ctrl_name", paramString3);
      localJSONObject.put("optional_A", paramString4);
      localJSONObject.put("optional_B", paramString5);
      localJSONObject.put("touch_x", paramInt2);
      localJSONObject.put("touch_y", paramInt3);
      localJSONObject.put("touch_time", paramLong);
      try
      {
        this.g.put(localJSONObject);
      }
      finally {}
    }
    catch (Exception paramString1)
    {
      label182:
      break label182;
    }
    if ((this.g.length() >= l) && (m)) {
      b(false);
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
    //   0: invokestatic 222	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 60	com/tencent/token/upload/useraction/a:p	Z
    //   21: aload_0
    //   22: getfield 66	com/tencent/token/upload/useraction/a:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc_w 278
    //   34: iconst_0
    //   35: invokevirtual 284	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   50: invokevirtual 285	org/json/JSONArray:toString	()Ljava/lang/String;
    //   53: invokevirtual 129	java/lang/String:getBytes	()[B
    //   56: invokevirtual 290	java/io/FileOutputStream:write	([B)V
    //   59: aload_1
    //   60: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_1
    //   66: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_2
    //   75: goto -10 -> 65
    //   78: astore_1
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_1
    //   82: iconst_0
    //   83: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	a
    //   0	84	1	paramContext	android.content.Context
    //   74	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	39	71	java/io/FileNotFoundException
    //   45	59	74	java/lang/Exception
    //   59	63	78	java/io/IOException
    //   65	69	81	java/io/IOException
  }
  
  public MotionEvent b()
  {
    return this.t;
  }
  
  public void b(boolean paramBoolean)
  {
    if (c.l()) {
      return;
    }
    this.r = paramBoolean;
    if (this.o) {
      return;
    }
    int i1;
    JSONArray localJSONArray;
    int i2;
    if (this.a)
    {
      if (this.g.length() == 0) {
        return;
      }
      i1 = cc.a + 1;
      cc.a = i1;
      this.i = i1;
      this.o = true;
      localJSONArray = new JSONArray();
      i2 = this.g.length();
      i1 = k;
      if (i2 <= i1) {
        i1 = this.g.length();
      }
      i2 = 0;
    }
    for (;;)
    {
      if (i2 < i1) {}
      try
      {
        localJSONArray.put(this.g.get(i2));
        i2 += 1;
      }
      catch (Exception localException1)
      {
        label123:
        JSONObject localJSONObject;
        StringBuilder localStringBuilder;
        break label123;
      }
    }
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        if (cs.a().e() != null) {
          localJSONObject.put("uin", cs.a().e().mUin);
        }
        localJSONObject.put("seq_id", this.i);
        localJSONObject.put("op_time", (int)(cd.c().s() / 1000L));
        localJSONObject.put("token_seq", cd.c().k());
        localJSONObject.put("action_list", localJSONArray);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSONException:");
        localStringBuilder.append(localException2.getMessage());
        g.c(localStringBuilder.toString());
      }
      this.h = localJSONObject.toString();
      this.s = new UserTask()
      {
        public e a(String... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = a.this;
          return a.a(paramAnonymousVarArgs, paramAnonymousVarArgs.h);
        }
        
        public void a()
        {
          a.a(a.this, false);
        }
        
        public void a(e paramAnonymouse)
        {
          if (paramAnonymouse.b())
          {
            a.b(a.g());
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("post click flow msg failed:");
            localStringBuilder.append(paramAnonymouse.a);
            localStringBuilder.append("-");
            localStringBuilder.append(paramAnonymouse.b);
            g.c(localStringBuilder.toString());
            if (a.h() >= a.i()) {}
          }
          try
          {
            a.b(a.i());
          }
          catch (Exception|Error paramAnonymouse)
          {
            break label90;
          }
          a.b(a.g());
          label90:
          a.a(a.this, false);
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
    return a(RqdApplication.n());
  }
  
  /* Error */
  public boolean f()
  {
    // Byte code:
    //   0: invokestatic 222	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 66	com/tencent/token/upload/useraction/a:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 347	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   20: ldc_w 278
    //   23: invokevirtual 353	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +5 -> 33
    //   31: iconst_0
    //   32: ireturn
    //   33: sipush 2000
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 359	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: aload_0
    //   46: new 76	org/json/JSONArray
    //   49: dup
    //   50: new 125	java/lang/String
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 173	java/lang/String:<init>	([B)V
    //   58: invokespecial 360	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   61: putfield 79	com/tencent/token/upload/useraction/a:g	Lorg/json/JSONArray;
    //   64: aload_1
    //   65: invokevirtual 361	java/io/FileInputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 361	java/io/FileInputStream:close	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_2
    //   80: goto -10 -> 70
    //   83: astore_1
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: iconst_0
    //   88: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	a
    //   26	45	1	localFileInputStream	java.io.FileInputStream
    //   76	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   83	1	1	localIOException1	java.io.IOException
    //   86	1	1	localIOException2	java.io.IOException
    //   38	17	2	arrayOfByte	byte[]
    //   79	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	27	76	java/io/FileNotFoundException
    //   33	64	79	java/lang/Exception
    //   64	68	83	java/io/IOException
    //   70	74	86	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.useraction.a
 * JD-Core Version:    0.7.0.1
 */