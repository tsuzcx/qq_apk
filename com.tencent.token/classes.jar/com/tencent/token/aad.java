package com.tencent.token;

import android.view.MotionEvent;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.UserTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aad
{
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static boolean g = false;
  private static int m = 20;
  private static int n = 20;
  private static int o = m;
  private static aad p = null;
  private static boolean r = false;
  public boolean a = true;
  protected JSONArray h = new JSONArray();
  protected String i;
  public MotionEvent j;
  public int k = b;
  private int l;
  private boolean q = false;
  private QQUser s = null;
  private boolean t;
  private UserTask<String, String, xh> u = null;
  
  public static aad a()
  {
    if (p == null) {
      p = new aad();
    }
    if ((!xf.j()) && (!r))
    {
      r = true;
      p.g();
    }
    return p;
  }
  
  /* Error */
  private xh a(String paramString)
  {
    // Byte code:
    //   0: new 103	com/tencent/token/xh
    //   3: dup
    //   4: invokespecial 104	com/tencent/token/xh:<init>	()V
    //   7: astore_3
    //   8: invokestatic 109	com/tencent/token/th:a	()Lcom/tencent/token/th;
    //   11: invokevirtual 111	com/tencent/token/th:i	()Z
    //   14: ifne +26 -> 40
    //   17: aload_0
    //   18: getfield 113	com/tencent/token/aad:t	Z
    //   21: ifeq +8 -> 29
    //   24: aload_0
    //   25: invokespecial 115	com/tencent/token/aad:f	()Z
    //   28: pop
    //   29: aload_3
    //   30: sipush 30001
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 118	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: areturn
    //   40: ldc 120
    //   42: aload_1
    //   43: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic 135	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   52: new 137	java/util/concurrent/CountDownLatch
    //   55: dup
    //   56: iconst_1
    //   57: invokespecial 140	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   60: astore 5
    //   62: new 142	java/util/concurrent/atomic/AtomicReference
    //   65: dup
    //   66: aconst_null
    //   67: invokespecial 145	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   70: astore 4
    //   72: invokestatic 150	com/tencent/token/rf:a	()Lcom/tencent/token/rf;
    //   75: aload_1
    //   76: new 6	com/tencent/token/aad$1
    //   79: dup
    //   80: aload_0
    //   81: aload 4
    //   83: aload 5
    //   85: invokespecial 153	com/tencent/token/aad$1:<init>	(Lcom/tencent/token/aad;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   88: invokevirtual 156	com/tencent/token/rf:e	(Ljava/lang/String;Lcom/tencent/token/rf$a;)V
    //   91: aload 5
    //   93: invokevirtual 159	java/util/concurrent/CountDownLatch:await	()V
    //   96: goto +8 -> 104
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 162	java/lang/InterruptedException:printStackTrace	()V
    //   104: aload 4
    //   106: invokevirtual 166	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   109: checkcast 168	com/tencent/token/ri
    //   112: astore_1
    //   113: aload_1
    //   114: ifnonnull +26 -> 140
    //   117: aload_0
    //   118: getfield 113	com/tencent/token/aad:t	Z
    //   121: ifeq +8 -> 129
    //   124: aload_0
    //   125: invokespecial 115	com/tencent/token/aad:f	()Z
    //   128: pop
    //   129: aload_3
    //   130: sipush -789
    //   133: aconst_null
    //   134: aconst_null
    //   135: invokevirtual 118	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   138: aload_3
    //   139: areturn
    //   140: aload_1
    //   141: getfield 169	com/tencent/token/ri:b	I
    //   144: istore_2
    //   145: iload_2
    //   146: ifeq +18 -> 164
    //   149: aload_1
    //   150: getfield 171	com/tencent/token/ri:d	Ljava/lang/String;
    //   153: astore_1
    //   154: aload_3
    //   155: iload_2
    //   156: aload_1
    //   157: aload_1
    //   158: invokevirtual 118	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   161: goto +101 -> 262
    //   164: aload_3
    //   165: iconst_0
    //   166: putfield 173	com/tencent/token/xh:a	I
    //   169: aload_0
    //   170: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   173: invokevirtual 177	org/json/JSONArray:length	()I
    //   176: getstatic 179	com/tencent/token/aad:n	I
    //   179: if_icmple +10 -> 189
    //   182: getstatic 179	com/tencent/token/aad:n	I
    //   185: istore_2
    //   186: goto +11 -> 197
    //   189: aload_0
    //   190: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   193: invokevirtual 177	org/json/JSONArray:length	()I
    //   196: istore_2
    //   197: iload_2
    //   198: getstatic 179	com/tencent/token/aad:n	I
    //   201: if_icmpgt +17 -> 218
    //   204: aload_0
    //   205: new 78	org/json/JSONArray
    //   208: dup
    //   209: invokespecial 79	org/json/JSONArray:<init>	()V
    //   212: putfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   215: goto +47 -> 262
    //   218: new 78	org/json/JSONArray
    //   221: dup
    //   222: invokespecial 79	org/json/JSONArray:<init>	()V
    //   225: astore_1
    //   226: iload_2
    //   227: aload_0
    //   228: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   231: invokevirtual 177	org/json/JSONArray:length	()I
    //   234: if_icmpge +23 -> 257
    //   237: aload_1
    //   238: aload_0
    //   239: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   242: iload_2
    //   243: invokevirtual 182	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   246: invokevirtual 186	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -28 -> 226
    //   257: aload_0
    //   258: aload_1
    //   259: putfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   262: aload_0
    //   263: getfield 113	com/tencent/token/aad:t	Z
    //   266: ifeq +162 -> 428
    //   269: aload_0
    //   270: invokespecial 115	com/tencent/token/aad:f	()Z
    //   273: pop
    //   274: aload_3
    //   275: areturn
    //   276: astore_1
    //   277: goto +153 -> 430
    //   280: astore_1
    //   281: new 188	java/lang/StringBuilder
    //   284: dup
    //   285: ldc 190
    //   287: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: astore 4
    //   292: aload 4
    //   294: aload_1
    //   295: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 4
    //   304: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 203	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   310: new 188	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 205
    //   316: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: astore 4
    //   321: aload 4
    //   323: aload_1
    //   324: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   327: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_3
    //   332: sipush 10021
    //   335: aload 4
    //   337: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: aconst_null
    //   341: invokevirtual 118	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 113	com/tencent/token/aad:t	Z
    //   348: ifeq +80 -> 428
    //   351: goto -82 -> 269
    //   354: astore_1
    //   355: new 188	java/lang/StringBuilder
    //   358: dup
    //   359: ldc 207
    //   361: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: astore 4
    //   366: aload 4
    //   368: aload_1
    //   369: invokevirtual 208	org/json/JSONException:toString	()Ljava/lang/String;
    //   372: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 4
    //   378: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 203	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   384: new 188	java/lang/StringBuilder
    //   387: dup
    //   388: ldc 205
    //   390: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: astore 4
    //   395: aload 4
    //   397: aload_1
    //   398: invokevirtual 208	org/json/JSONException:toString	()Ljava/lang/String;
    //   401: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_3
    //   406: sipush 10020
    //   409: aload 4
    //   411: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: aconst_null
    //   415: invokevirtual 118	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   418: aload_0
    //   419: getfield 113	com/tencent/token/aad:t	Z
    //   422: ifeq +6 -> 428
    //   425: goto -156 -> 269
    //   428: aload_3
    //   429: areturn
    //   430: aload_0
    //   431: getfield 113	com/tencent/token/aad:t	Z
    //   434: ifeq +8 -> 442
    //   437: aload_0
    //   438: invokespecial 115	com/tencent/token/aad:f	()Z
    //   441: pop
    //   442: aload_1
    //   443: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	aad
    //   0	444	1	paramString	String
    //   144	110	2	i1	int
    //   7	422	3	localxh	xh
    //   70	340	4	localObject	Object
    //   60	32	5	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   91	96	99	java/lang/InterruptedException
    //   140	145	276	finally
    //   149	161	276	finally
    //   164	186	276	finally
    //   189	197	276	finally
    //   197	215	276	finally
    //   218	226	276	finally
    //   226	250	276	finally
    //   257	262	276	finally
    //   281	344	276	finally
    //   355	418	276	finally
    //   140	145	280	java/lang/Exception
    //   149	161	280	java/lang/Exception
    //   164	186	280	java/lang/Exception
    //   189	197	280	java/lang/Exception
    //   197	215	280	java/lang/Exception
    //   218	226	280	java/lang/Exception
    //   226	250	280	java/lang/Exception
    //   257	262	280	java/lang/Exception
    //   140	145	354	org/json/JSONException
    //   149	161	354	org/json/JSONException
    //   164	186	354	org/json/JSONException
    //   189	197	354	org/json/JSONException
    //   197	215	354	org/json/JSONException
    //   218	226	354	org/json/JSONException
    //   226	250	354	org/json/JSONException
    //   257	262	354	org/json/JSONException
  }
  
  /* Error */
  private boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 89	com/tencent/token/xf:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 62	com/tencent/token/aad:r	Z
    //   21: aload_0
    //   22: getfield 68	com/tencent/token/aad:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc 215
    //   33: iconst_0
    //   34: invokevirtual 221	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   49: invokevirtual 222	org/json/JSONArray:toString	()Ljava/lang/String;
    //   52: invokevirtual 226	java/lang/String:getBytes	()[B
    //   55: invokevirtual 232	java/io/FileOutputStream:write	([B)V
    //   58: aload_1
    //   59: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   62: iconst_1
    //   63: ireturn
    //   64: aload_1
    //   65: invokevirtual 235	java/io/FileOutputStream:close	()V
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
    //   0	83	0	this	aad
    //   0	83	1	paramContext	android.content.Context
    //   73	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	70	java/io/FileNotFoundException
    //   44	58	73	java/lang/Exception
    //   58	62	77	java/io/IOException
    //   64	68	80	java/io/IOException
  }
  
  private boolean f()
  {
    if (xf.j()) {
      return false;
    }
    return a(RqdApplication.p());
  }
  
  /* Error */
  private boolean g()
  {
    // Byte code:
    //   0: invokestatic 89	com/tencent/token/xf:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 68	com/tencent/token/aad:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 241	com/tencent/token/global/RqdApplication:p	()Landroid/content/Context;
    //   20: ldc 215
    //   22: invokevirtual 247	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
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
    //   40: invokevirtual 253	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_0
    //   45: new 78	org/json/JSONArray
    //   48: dup
    //   49: new 122	java/lang/String
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 255	java/lang/String:<init>	([B)V
    //   57: invokespecial 256	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   60: putfield 81	com/tencent/token/aad:h	Lorg/json/JSONArray;
    //   63: aload_1
    //   64: invokevirtual 257	java/io/FileInputStream:close	()V
    //   67: iconst_1
    //   68: ireturn
    //   69: aload_1
    //   70: invokevirtual 257	java/io/FileInputStream:close	()V
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
    //   0	88	0	this	aad
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
  
  private void h()
  {
    if (xf.j()) {
      return;
    }
    this.t = false;
    if (this.q) {
      return;
    }
    int i1;
    JSONArray localJSONArray;
    int i2;
    if (this.a)
    {
      if (this.h.length() == 0) {
        return;
      }
      i1 = si.b + 1;
      si.b = i1;
      this.l = i1;
      this.q = true;
      localJSONArray = new JSONArray();
      i2 = this.h.length();
      i1 = n;
      if (i2 <= i1) {
        i1 = this.h.length();
      }
      i2 = 0;
    }
    for (;;)
    {
      if (i2 < i1) {}
      try
      {
        localJSONArray.put(this.h.get(i2));
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
        if (th.a().k.b() != null) {
          localJSONObject.put("uin", th.a().k.b().mUin);
        }
        localJSONObject.put("seq_id", this.l);
        localJSONObject.put("op_time", (int)rf.a().h());
        localJSONObject.put("action_list", localJSONArray);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localStringBuilder = new StringBuilder("JSONException:");
        localStringBuilder.append(localException2.getMessage());
        xj.c(localStringBuilder.toString());
      }
      this.i = localJSONObject.toString();
      this.u = new UserTask()
      {
        public final void a()
        {
          aad.a(aad.this);
        }
      };
      this.u.a(new String[0]);
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, long paramLong)
  {
    if (xf.j()) {
      return;
    }
    if (this.h == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.s = th.a().k.b();
      if (this.s != null) {
        localJSONObject.put("real_uin", this.s.mRealUin);
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
        this.h.put(localJSONObject);
      }
      finally {}
    }
    catch (Exception paramString1)
    {
      label191:
      break label191;
    }
    if ((this.h.length() >= o) && (g)) {
      h();
    }
  }
  
  public final void b()
  {
    this.j = null;
    this.k = b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aad
 * JD-Core Version:    0.7.0.1
 */