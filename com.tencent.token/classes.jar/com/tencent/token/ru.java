package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.UserTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ru
{
  private static int d = 20;
  private static int e = 30;
  private static int f = d;
  private static ru g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask<String, String, wz> k = null;
  
  public static ru a()
  {
    if (g == null) {
      g = new ru();
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
    //   0: new 75	com/tencent/token/wz
    //   3: dup
    //   4: invokespecial 76	com/tencent/token/wz:<init>	()V
    //   7: astore_3
    //   8: invokestatic 81	com/tencent/token/ta:a	()Lcom/tencent/token/ta;
    //   11: invokevirtual 83	com/tencent/token/ta:i	()Z
    //   14: ifne +26 -> 40
    //   17: aload_0
    //   18: getfield 85	com/tencent/token/ru:j	Z
    //   21: ifeq +8 -> 29
    //   24: aload_0
    //   25: invokevirtual 87	com/tencent/token/ru:b	()Z
    //   28: pop
    //   29: aload_3
    //   30: sipush 30001
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 90	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: areturn
    //   40: new 92	java/util/concurrent/CountDownLatch
    //   43: dup
    //   44: iconst_1
    //   45: invokespecial 95	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   48: astore 5
    //   50: new 97	java/util/concurrent/atomic/AtomicReference
    //   53: dup
    //   54: aconst_null
    //   55: invokespecial 100	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   58: astore 4
    //   60: invokestatic 105	com/tencent/token/qz:a	()Lcom/tencent/token/qz;
    //   63: aload_1
    //   64: new 6	com/tencent/token/ru$1
    //   67: dup
    //   68: aload_0
    //   69: aload 4
    //   71: aload 5
    //   73: invokespecial 108	com/tencent/token/ru$1:<init>	(Lcom/tencent/token/ru;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   76: invokevirtual 111	com/tencent/token/qz:c	(Ljava/lang/String;Lcom/tencent/token/qz$a;)V
    //   79: aload 5
    //   81: invokevirtual 114	java/util/concurrent/CountDownLatch:await	()V
    //   84: goto +8 -> 92
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 117	java/lang/InterruptedException:printStackTrace	()V
    //   92: aload 4
    //   94: invokevirtual 121	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   97: checkcast 123	com/tencent/token/rb
    //   100: astore_1
    //   101: aload_1
    //   102: ifnonnull +26 -> 128
    //   105: aload_0
    //   106: getfield 85	com/tencent/token/ru:j	Z
    //   109: ifeq +8 -> 117
    //   112: aload_0
    //   113: invokevirtual 87	com/tencent/token/ru:b	()Z
    //   116: pop
    //   117: aload_3
    //   118: sipush -766
    //   121: aconst_null
    //   122: aconst_null
    //   123: invokevirtual 90	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: areturn
    //   128: aload_1
    //   129: getfield 125	com/tencent/token/rb:b	I
    //   132: istore_2
    //   133: iload_2
    //   134: ifeq +18 -> 152
    //   137: aload_1
    //   138: getfield 127	com/tencent/token/rb:d	Ljava/lang/String;
    //   141: astore_1
    //   142: aload_3
    //   143: iload_2
    //   144: aload_1
    //   145: aload_1
    //   146: invokevirtual 90	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   149: goto +101 -> 250
    //   152: aload_3
    //   153: iconst_0
    //   154: putfield 129	com/tencent/token/wz:a	I
    //   157: aload_0
    //   158: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   161: invokevirtual 133	org/json/JSONArray:length	()I
    //   164: getstatic 135	com/tencent/token/ru:e	I
    //   167: if_icmple +10 -> 177
    //   170: getstatic 135	com/tencent/token/ru:e	I
    //   173: istore_2
    //   174: goto +11 -> 185
    //   177: aload_0
    //   178: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   181: invokevirtual 133	org/json/JSONArray:length	()I
    //   184: istore_2
    //   185: iload_2
    //   186: getstatic 135	com/tencent/token/ru:e	I
    //   189: if_icmpgt +17 -> 206
    //   192: aload_0
    //   193: new 50	org/json/JSONArray
    //   196: dup
    //   197: invokespecial 51	org/json/JSONArray:<init>	()V
    //   200: putfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   203: goto +47 -> 250
    //   206: new 50	org/json/JSONArray
    //   209: dup
    //   210: invokespecial 51	org/json/JSONArray:<init>	()V
    //   213: astore_1
    //   214: iload_2
    //   215: aload_0
    //   216: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   219: invokevirtual 133	org/json/JSONArray:length	()I
    //   222: if_icmpge +23 -> 245
    //   225: aload_1
    //   226: aload_0
    //   227: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   230: iload_2
    //   231: invokevirtual 138	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   234: invokevirtual 142	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   237: pop
    //   238: iload_2
    //   239: iconst_1
    //   240: iadd
    //   241: istore_2
    //   242: goto -28 -> 214
    //   245: aload_0
    //   246: aload_1
    //   247: putfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   250: aload_0
    //   251: getfield 85	com/tencent/token/ru:j	Z
    //   254: ifeq +162 -> 416
    //   257: aload_0
    //   258: invokevirtual 87	com/tencent/token/ru:b	()Z
    //   261: pop
    //   262: aload_3
    //   263: areturn
    //   264: astore_1
    //   265: goto +153 -> 418
    //   268: astore_1
    //   269: new 144	java/lang/StringBuilder
    //   272: dup
    //   273: ldc 146
    //   275: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: astore 4
    //   280: aload 4
    //   282: aload_1
    //   283: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   286: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 4
    //   292: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 162	com/tencent/token/xb:c	(Ljava/lang/String;)V
    //   298: new 144	java/lang/StringBuilder
    //   301: dup
    //   302: ldc 164
    //   304: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: astore 4
    //   309: aload 4
    //   311: aload_1
    //   312: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   315: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: sipush 10021
    //   323: aload 4
    //   325: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aconst_null
    //   329: invokevirtual 90	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 85	com/tencent/token/ru:j	Z
    //   336: ifeq +80 -> 416
    //   339: goto -82 -> 257
    //   342: astore_1
    //   343: new 144	java/lang/StringBuilder
    //   346: dup
    //   347: ldc 166
    //   349: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: astore 4
    //   354: aload 4
    //   356: aload_1
    //   357: invokevirtual 167	org/json/JSONException:toString	()Ljava/lang/String;
    //   360: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 4
    //   366: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 162	com/tencent/token/xb:c	(Ljava/lang/String;)V
    //   372: new 144	java/lang/StringBuilder
    //   375: dup
    //   376: ldc 164
    //   378: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: astore 4
    //   383: aload 4
    //   385: aload_1
    //   386: invokevirtual 167	org/json/JSONException:toString	()Ljava/lang/String;
    //   389: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_3
    //   394: sipush 10020
    //   397: aload 4
    //   399: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: aconst_null
    //   403: invokevirtual 90	com/tencent/token/wz:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: getfield 85	com/tencent/token/ru:j	Z
    //   410: ifeq +6 -> 416
    //   413: goto -156 -> 257
    //   416: aload_3
    //   417: areturn
    //   418: aload_0
    //   419: getfield 85	com/tencent/token/ru:j	Z
    //   422: ifeq +8 -> 430
    //   425: aload_0
    //   426: invokevirtual 87	com/tencent/token/ru:b	()Z
    //   429: pop
    //   430: aload_1
    //   431: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	ru
    //   0	432	1	paramString	String
    //   132	110	2	m	int
    //   7	410	3	localwz	wz
    //   58	340	4	localObject	Object
    //   48	32	5	localCountDownLatch	CountDownLatch
    // Exception table:
    //   from	to	target	type
    //   79	84	87	java/lang/InterruptedException
    //   128	133	264	finally
    //   137	149	264	finally
    //   152	174	264	finally
    //   177	185	264	finally
    //   185	203	264	finally
    //   206	214	264	finally
    //   214	238	264	finally
    //   245	250	264	finally
    //   269	332	264	finally
    //   343	406	264	finally
    //   128	133	268	java/lang/Exception
    //   137	149	268	java/lang/Exception
    //   152	174	268	java/lang/Exception
    //   177	185	268	java/lang/Exception
    //   185	203	268	java/lang/Exception
    //   206	214	268	java/lang/Exception
    //   214	238	268	java/lang/Exception
    //   245	250	268	java/lang/Exception
    //   128	133	342	org/json/JSONException
    //   137	149	342	org/json/JSONException
    //   152	174	342	org/json/JSONException
    //   177	185	342	org/json/JSONException
    //   185	203	342	org/json/JSONException
    //   206	214	342	org/json/JSONException
    //   214	238	342	org/json/JSONException
    //   245	250	342	org/json/JSONException
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/token/wx:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 44	com/tencent/token/ru:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 178	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   20: ldc 180
    //   22: invokevirtual 186	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
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
    //   40: invokevirtual 192	java/io/FileInputStream:read	([B)I
    //   43: pop
    //   44: aload_0
    //   45: new 50	org/json/JSONArray
    //   48: dup
    //   49: new 194	java/lang/String
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 197	java/lang/String:<init>	([B)V
    //   57: invokespecial 198	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   60: putfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   63: aload_1
    //   64: invokevirtual 201	java/io/FileInputStream:close	()V
    //   67: iconst_1
    //   68: ireturn
    //   69: aload_1
    //   70: invokevirtual 201	java/io/FileInputStream:close	()V
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
    //   0	88	0	this	ru
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
  
  public final void a(long paramLong, int paramInt)
  {
    if (wx.j()) {
      return;
    }
    if (this.b == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("t", paramLong / 1000L);
        localJSONObject.put("e", paramInt);
        localObject2 = ta.a().k.b();
        if (localObject2 != null) {
          localJSONObject.put("u", ((QQUser)localObject2).mUin);
        }
        m = 0;
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        Object localObject2;
        int m;
        continue;
        m += 1;
        continue;
        paramInt = 1;
        continue;
      }
      try
      {
        if (m >= this.b.length()) {
          continue;
        }
        localObject2 = this.b.getJSONObject(m);
        if ((((JSONObject)localObject2).getInt("e") != paramInt) || (((JSONObject)localObject2).getLong("t") != paramLong / 1000L)) {
          continue;
        }
        paramInt = 0;
        if (paramInt != 0) {
          this.b.put(localJSONObject);
        }
      }
      finally {}
    }
    if (this.b.length() >= f) {
      a(false);
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/token/wx:j	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 85	com/tencent/token/ru:j	Z
    //   12: aload_0
    //   13: getfield 46	com/tencent/token/ru:h	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield 44	com/tencent/token/ru:a	Z
    //   24: ifeq +250 -> 274
    //   27: aload_0
    //   28: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   31: invokevirtual 133	org/json/JSONArray:length	()I
    //   34: ifne +4 -> 38
    //   37: return
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 46	com/tencent/token/ru:h	Z
    //   43: new 50	org/json/JSONArray
    //   46: dup
    //   47: invokespecial 51	org/json/JSONArray:<init>	()V
    //   50: astore 6
    //   52: aload_0
    //   53: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   56: invokevirtual 133	org/json/JSONArray:length	()I
    //   59: istore_3
    //   60: getstatic 135	com/tencent/token/ru:e	I
    //   63: istore_2
    //   64: iload_3
    //   65: iload_2
    //   66: if_icmple +6 -> 72
    //   69: goto +11 -> 80
    //   72: aload_0
    //   73: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   76: invokevirtual 133	org/json/JSONArray:length	()I
    //   79: istore_2
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_3
    //   83: iload_2
    //   84: if_icmpge +24 -> 108
    //   87: aload 6
    //   89: aload_0
    //   90: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   93: iload_3
    //   94: invokevirtual 138	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   97: invokevirtual 142	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   100: pop
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: istore_3
    //   105: goto -23 -> 82
    //   108: aload_0
    //   109: monitorenter
    //   110: new 204	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 205	org/json/JSONObject:<init>	()V
    //   117: astore 7
    //   119: lconst_0
    //   120: lstore 4
    //   122: invokestatic 81	com/tencent/token/ta:a	()Lcom/tencent/token/ta;
    //   125: astore 8
    //   127: aload 8
    //   129: invokevirtual 249	com/tencent/token/ta:f	()Lcom/tencent/token/core/bean/QQUser;
    //   132: astore 9
    //   134: aload 9
    //   136: ifnull +13 -> 149
    //   139: aload 9
    //   141: getfield 232	com/tencent/token/core/bean/QQUser:mUin	J
    //   144: lstore 4
    //   146: goto +25 -> 171
    //   149: aload 8
    //   151: getfield 219	com/tencent/token/ta:k	Lcom/tencent/token/ahh;
    //   154: invokevirtual 224	com/tencent/token/ahh:b	()Lcom/tencent/token/core/bean/QQUser;
    //   157: astore 8
    //   159: aload 8
    //   161: ifnull +10 -> 171
    //   164: aload 8
    //   166: getfield 232	com/tencent/token/core/bean/QQUser:mUin	J
    //   169: lstore 4
    //   171: aload 7
    //   173: ldc 251
    //   175: invokestatic 105	com/tencent/token/qz:a	()Lcom/tencent/token/qz;
    //   178: invokevirtual 254	com/tencent/token/qz:h	()J
    //   181: l2i
    //   182: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   185: pop
    //   186: getstatic 257	com/tencent/token/sb:b	I
    //   189: iconst_1
    //   190: iadd
    //   191: istore_2
    //   192: iload_2
    //   193: putstatic 257	com/tencent/token/sb:b	I
    //   196: aload 7
    //   198: ldc_w 259
    //   201: iload_2
    //   202: invokevirtual 216	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload 7
    //   208: ldc_w 261
    //   211: lload 4
    //   213: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 7
    //   219: ldc_w 263
    //   222: aload 6
    //   224: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload_0
    //   229: aload 7
    //   231: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   234: putfield 269	com/tencent/token/ru:c	Ljava/lang/String;
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_0
    //   240: new 8	com/tencent/token/ru$2
    //   243: dup
    //   244: aload_0
    //   245: invokespecial 272	com/tencent/token/ru$2:<init>	(Lcom/tencent/token/ru;)V
    //   248: putfield 48	com/tencent/token/ru:k	Lcom/tencent/token/utils/UserTask;
    //   251: aload_0
    //   252: getfield 48	com/tencent/token/ru:k	Lcom/tencent/token/utils/UserTask;
    //   255: iconst_0
    //   256: anewarray 194	java/lang/String
    //   259: invokevirtual 277	com/tencent/token/utils/UserTask:a	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   262: pop
    //   263: return
    //   264: aload_0
    //   265: monitorexit
    //   266: return
    //   267: astore 6
    //   269: aload_0
    //   270: monitorexit
    //   271: aload 6
    //   273: athrow
    //   274: return
    //   275: astore 7
    //   277: goto -169 -> 108
    //   280: astore 6
    //   282: goto -18 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	ru
    //   0	285	1	paramBoolean	boolean
    //   63	139	2	m	int
    //   59	46	3	n	int
    //   120	92	4	l	long
    //   50	173	6	localJSONArray	JSONArray
    //   267	5	6	localObject1	Object
    //   280	1	6	localJSONException	org.json.JSONException
    //   117	113	7	localJSONObject	JSONObject
    //   275	1	7	localException	Exception
    //   125	40	8	localObject2	Object
    //   132	8	9	localQQUser	QQUser
    // Exception table:
    //   from	to	target	type
    //   110	119	267	finally
    //   122	134	267	finally
    //   139	146	267	finally
    //   149	159	267	finally
    //   164	171	267	finally
    //   171	228	267	finally
    //   228	239	267	finally
    //   264	266	267	finally
    //   269	271	267	finally
    //   87	101	275	java/lang/Exception
    //   122	134	280	org/json/JSONException
    //   139	146	280	org/json/JSONException
    //   149	159	280	org/json/JSONException
    //   164	171	280	org/json/JSONException
    //   171	228	280	org/json/JSONException
  }
  
  /* Error */
  public final boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 61	com/tencent/token/wx:j	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 38	com/tencent/token/ru:i	Z
    //   21: aload_0
    //   22: getfield 44	com/tencent/token/ru:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc 180
    //   33: iconst_0
    //   34: invokevirtual 282	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 53	com/tencent/token/ru:b	Lorg/json/JSONArray;
    //   49: invokevirtual 283	org/json/JSONArray:toString	()Ljava/lang/String;
    //   52: invokevirtual 287	java/lang/String:getBytes	()[B
    //   55: invokevirtual 292	java/io/FileOutputStream:write	([B)V
    //   58: aload_1
    //   59: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   62: iconst_1
    //   63: ireturn
    //   64: aload_1
    //   65: invokevirtual 293	java/io/FileOutputStream:close	()V
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
    //   0	83	0	this	ru
    //   0	83	1	paramContext	android.content.Context
    //   73	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	70	java/io/FileNotFoundException
    //   44	58	73	java/lang/Exception
    //   58	62	77	java/io/IOException
    //   64	68	80	java/io/IOException
  }
  
  public final boolean b()
  {
    if (wx.j()) {
      return false;
    }
    return a(RqdApplication.n());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ru
 * JD-Core Version:    0.7.0.1
 */