package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import org.json.JSONArray;
import org.json.JSONObject;

public class bv
{
  private static int d = 20;
  private static int e = 30;
  private static int f = d;
  private static bv g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask<String, String, e> k = null;
  
  public static bv a()
  {
    if (g == null) {
      g = new bv();
    }
    if ((!c.l()) && (!i))
    {
      i = true;
      g.c();
    }
    return g;
  }
  
  /* Error */
  private e a(String paramString)
  {
    // Byte code:
    //   0: new 72	com/tencent/token/global/e
    //   3: dup
    //   4: invokespecial 73	com/tencent/token/global/e:<init>	()V
    //   7: astore_3
    //   8: invokestatic 78	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   11: invokevirtual 81	com/tencent/token/cs:o	()Z
    //   14: ifne +24 -> 38
    //   17: aload_0
    //   18: getfield 83	com/tencent/token/bv:j	Z
    //   21: ifeq +8 -> 29
    //   24: aload_0
    //   25: invokevirtual 85	com/tencent/token/bv:b	()Z
    //   28: pop
    //   29: aload_3
    //   30: sipush 30001
    //   33: invokevirtual 88	com/tencent/token/global/e:b	(I)V
    //   36: aload_3
    //   37: areturn
    //   38: aload_1
    //   39: invokevirtual 94	java/lang/String:getBytes	()[B
    //   42: invokestatic 99	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   45: astore_1
    //   46: new 101	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   53: astore 4
    //   55: aload 4
    //   57: invokestatic 105	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   60: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: ldc 111
    //   68: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: new 116	android/content/ContentValues
    //   82: dup
    //   83: iconst_3
    //   84: invokespecial 118	android/content/ContentValues:<init>	(I)V
    //   87: astore 5
    //   89: aload 5
    //   91: ldc 120
    //   93: getstatic 122	com/tencent/token/cs:c	Ljava/lang/String;
    //   96: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc 128
    //   103: aload_1
    //   104: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: new 101	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: ldc 130
    //   120: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 6
    //   126: getstatic 122	com/tencent/token/cs:c	Ljava/lang/String;
    //   129: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 6
    //   135: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 135	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   141: new 101	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   148: astore 6
    //   150: aload 6
    //   152: ldc 137
    //   154: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: aload_1
    //   161: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 135	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   173: new 139	com/tencent/token/fc
    //   176: dup
    //   177: invokespecial 140	com/tencent/token/fc:<init>	()V
    //   180: astore_1
    //   181: aload_1
    //   182: aload 4
    //   184: aload 5
    //   186: invokevirtual 143	com/tencent/token/fc:a	(Ljava/lang/String;Landroid/content/ContentValues;)[B
    //   189: astore 4
    //   191: aload 4
    //   193: ifnonnull +25 -> 218
    //   196: aload_0
    //   197: getfield 83	com/tencent/token/bv:j	Z
    //   200: ifeq +8 -> 208
    //   203: aload_0
    //   204: invokevirtual 85	com/tencent/token/bv:b	()Z
    //   207: pop
    //   208: aload_3
    //   209: aload_1
    //   210: invokevirtual 146	com/tencent/token/fc:a	()Lcom/tencent/token/global/e;
    //   213: invokevirtual 149	com/tencent/token/global/e:a	(Lcom/tencent/token/global/e;)V
    //   216: aload_3
    //   217: areturn
    //   218: new 151	org/json/JSONObject
    //   221: dup
    //   222: new 90	java/lang/String
    //   225: dup
    //   226: aload 4
    //   228: invokespecial 154	java/lang/String:<init>	([B)V
    //   231: invokespecial 156	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   234: astore_1
    //   235: aload_1
    //   236: ldc 158
    //   238: invokevirtual 162	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: iload_2
    //   243: ifeq +20 -> 263
    //   246: aload_1
    //   247: ldc 164
    //   249: invokevirtual 168	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   252: astore_1
    //   253: aload_3
    //   254: iload_2
    //   255: aload_1
    //   256: aload_1
    //   257: invokevirtual 171	com/tencent/token/global/e:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   260: goto +100 -> 360
    //   263: aload_3
    //   264: invokevirtual 173	com/tencent/token/global/e:c	()V
    //   267: aload_0
    //   268: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   271: invokevirtual 177	org/json/JSONArray:length	()I
    //   274: getstatic 179	com/tencent/token/bv:e	I
    //   277: if_icmple +10 -> 287
    //   280: getstatic 179	com/tencent/token/bv:e	I
    //   283: istore_2
    //   284: goto +11 -> 295
    //   287: aload_0
    //   288: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   291: invokevirtual 177	org/json/JSONArray:length	()I
    //   294: istore_2
    //   295: iload_2
    //   296: getstatic 179	com/tencent/token/bv:e	I
    //   299: if_icmpgt +17 -> 316
    //   302: aload_0
    //   303: new 48	org/json/JSONArray
    //   306: dup
    //   307: invokespecial 49	org/json/JSONArray:<init>	()V
    //   310: putfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   313: goto +47 -> 360
    //   316: new 48	org/json/JSONArray
    //   319: dup
    //   320: invokespecial 49	org/json/JSONArray:<init>	()V
    //   323: astore_1
    //   324: iload_2
    //   325: aload_0
    //   326: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   329: invokevirtual 177	org/json/JSONArray:length	()I
    //   332: if_icmpge +23 -> 355
    //   335: aload_1
    //   336: aload_0
    //   337: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   340: iload_2
    //   341: invokevirtual 183	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   344: invokevirtual 186	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   347: pop
    //   348: iload_2
    //   349: iconst_1
    //   350: iadd
    //   351: istore_2
    //   352: goto -28 -> 324
    //   355: aload_0
    //   356: aload_1
    //   357: putfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   360: aload_0
    //   361: getfield 83	com/tencent/token/bv:j	Z
    //   364: ifeq +184 -> 548
    //   367: aload_0
    //   368: invokevirtual 85	com/tencent/token/bv:b	()Z
    //   371: pop
    //   372: aload_3
    //   373: areturn
    //   374: astore_1
    //   375: goto +175 -> 550
    //   378: astore_1
    //   379: new 101	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   386: astore 4
    //   388: aload 4
    //   390: ldc 188
    //   392: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: aload_1
    //   399: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   402: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 4
    //   408: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 191	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   414: new 101	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   421: astore 4
    //   423: aload 4
    //   425: ldc 193
    //   427: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 4
    //   433: aload_1
    //   434: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   437: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_3
    //   442: sipush 10021
    //   445: aload 4
    //   447: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 196	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   453: aload_0
    //   454: getfield 83	com/tencent/token/bv:j	Z
    //   457: ifeq +91 -> 548
    //   460: goto -93 -> 367
    //   463: astore_1
    //   464: new 101	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   471: astore 4
    //   473: aload 4
    //   475: ldc 198
    //   477: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 4
    //   483: aload_1
    //   484: invokevirtual 199	org/json/JSONException:toString	()Ljava/lang/String;
    //   487: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 4
    //   493: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 191	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   499: new 101	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   506: astore 4
    //   508: aload 4
    //   510: ldc 193
    //   512: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 4
    //   518: aload_1
    //   519: invokevirtual 199	org/json/JSONException:toString	()Ljava/lang/String;
    //   522: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_3
    //   527: sipush 10020
    //   530: aload 4
    //   532: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokevirtual 196	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   538: aload_0
    //   539: getfield 83	com/tencent/token/bv:j	Z
    //   542: ifeq +6 -> 548
    //   545: goto -178 -> 367
    //   548: aload_3
    //   549: areturn
    //   550: aload_0
    //   551: getfield 83	com/tencent/token/bv:j	Z
    //   554: ifeq +8 -> 562
    //   557: aload_0
    //   558: invokevirtual 85	com/tencent/token/bv:b	()Z
    //   561: pop
    //   562: aload_1
    //   563: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	bv
    //   0	564	1	paramString	String
    //   241	111	2	m	int
    //   7	542	3	locale	e
    //   53	478	4	localObject	Object
    //   87	98	5	localContentValues	android.content.ContentValues
    //   114	52	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   218	242	374	finally
    //   246	260	374	finally
    //   263	284	374	finally
    //   287	295	374	finally
    //   295	313	374	finally
    //   316	324	374	finally
    //   324	348	374	finally
    //   355	360	374	finally
    //   379	453	374	finally
    //   464	538	374	finally
    //   218	242	378	java/lang/Exception
    //   246	260	378	java/lang/Exception
    //   263	284	378	java/lang/Exception
    //   287	295	378	java/lang/Exception
    //   295	313	378	java/lang/Exception
    //   316	324	378	java/lang/Exception
    //   324	348	378	java/lang/Exception
    //   355	360	378	java/lang/Exception
    //   218	242	463	org/json/JSONException
    //   246	260	463	org/json/JSONException
    //   263	284	463	org/json/JSONException
    //   287	295	463	org/json/JSONException
    //   295	313	463	org/json/JSONException
    //   316	324	463	org/json/JSONException
    //   324	348	463	org/json/JSONException
    //   355	360	463	org/json/JSONException
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (c.l()) {
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
        localObject2 = cs.a().e();
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
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 83	com/tencent/token/bv:j	Z
    //   12: aload_0
    //   13: getfield 44	com/tencent/token/bv:h	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield 42	com/tencent/token/bv:a	Z
    //   24: ifeq +268 -> 292
    //   27: aload_0
    //   28: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   31: invokevirtual 177	org/json/JSONArray:length	()I
    //   34: ifne +4 -> 38
    //   37: return
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 44	com/tencent/token/bv:h	Z
    //   43: new 48	org/json/JSONArray
    //   46: dup
    //   47: invokespecial 49	org/json/JSONArray:<init>	()V
    //   50: astore 6
    //   52: aload_0
    //   53: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   56: invokevirtual 177	org/json/JSONArray:length	()I
    //   59: istore_3
    //   60: getstatic 179	com/tencent/token/bv:e	I
    //   63: istore_2
    //   64: iload_3
    //   65: iload_2
    //   66: if_icmple +6 -> 72
    //   69: goto +11 -> 80
    //   72: aload_0
    //   73: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   76: invokevirtual 177	org/json/JSONArray:length	()I
    //   79: istore_2
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_3
    //   83: iload_2
    //   84: if_icmpge +24 -> 108
    //   87: aload 6
    //   89: aload_0
    //   90: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   93: iload_3
    //   94: invokevirtual 183	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   97: invokevirtual 186	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   100: pop
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: istore_3
    //   105: goto -23 -> 82
    //   108: aload_0
    //   109: monitorenter
    //   110: new 151	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 202	org/json/JSONObject:<init>	()V
    //   117: astore 7
    //   119: lconst_0
    //   120: lstore 4
    //   122: invokestatic 78	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
    //   125: astore 8
    //   127: aload 8
    //   129: invokevirtual 237	com/tencent/token/cs:k	()Lcom/tencent/token/core/bean/QQUser;
    //   132: astore 9
    //   134: aload 9
    //   136: ifnull +13 -> 149
    //   139: aload 9
    //   141: getfield 224	com/tencent/token/core/bean/QQUser:mUin	J
    //   144: lstore 4
    //   146: goto +22 -> 168
    //   149: aload 8
    //   151: invokevirtual 216	com/tencent/token/cs:e	()Lcom/tencent/token/core/bean/QQUser;
    //   154: astore 8
    //   156: aload 8
    //   158: ifnull +10 -> 168
    //   161: aload 8
    //   163: getfield 224	com/tencent/token/core/bean/QQUser:mUin	J
    //   166: lstore 4
    //   168: aload 7
    //   170: ldc 239
    //   172: invokestatic 244	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   175: invokevirtual 248	com/tencent/token/cd:s	()J
    //   178: ldc2_w 205
    //   181: ldiv
    //   182: l2i
    //   183: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   186: pop
    //   187: getstatic 252	com/tencent/token/cc:a	I
    //   190: iconst_1
    //   191: iadd
    //   192: istore_2
    //   193: iload_2
    //   194: putstatic 252	com/tencent/token/cc:a	I
    //   197: aload 7
    //   199: ldc 254
    //   201: iload_2
    //   202: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload 7
    //   208: ldc_w 256
    //   211: lload 4
    //   213: invokevirtual 209	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 7
    //   219: ldc_w 258
    //   222: invokestatic 244	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   225: invokevirtual 260	com/tencent/token/cd:k	()J
    //   228: invokestatic 264	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   231: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   234: pop
    //   235: aload 7
    //   237: ldc_w 269
    //   240: aload 6
    //   242: invokevirtual 267	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload_0
    //   247: aload 7
    //   249: invokevirtual 270	org/json/JSONObject:toString	()Ljava/lang/String;
    //   252: putfield 271	com/tencent/token/bv:c	Ljava/lang/String;
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_0
    //   258: new 6	com/tencent/token/bv$1
    //   261: dup
    //   262: aload_0
    //   263: invokespecial 274	com/tencent/token/bv$1:<init>	(Lcom/tencent/token/bv;)V
    //   266: putfield 46	com/tencent/token/bv:k	Lcom/tencent/token/utils/UserTask;
    //   269: aload_0
    //   270: getfield 46	com/tencent/token/bv:k	Lcom/tencent/token/utils/UserTask;
    //   273: iconst_0
    //   274: anewarray 90	java/lang/String
    //   277: invokevirtual 279	com/tencent/token/utils/UserTask:c	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   280: pop
    //   281: return
    //   282: aload_0
    //   283: monitorexit
    //   284: return
    //   285: astore 6
    //   287: aload_0
    //   288: monitorexit
    //   289: aload 6
    //   291: athrow
    //   292: return
    //   293: astore 7
    //   295: goto -187 -> 108
    //   298: astore 6
    //   300: goto -18 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	bv
    //   0	303	1	paramBoolean	boolean
    //   63	139	2	m	int
    //   59	46	3	n	int
    //   120	92	4	l	long
    //   50	191	6	localJSONArray	JSONArray
    //   285	5	6	localObject1	Object
    //   298	1	6	localJSONException	org.json.JSONException
    //   117	131	7	localJSONObject	JSONObject
    //   293	1	7	localException	Exception
    //   125	37	8	localObject2	Object
    //   132	8	9	localQQUser	QQUser
    // Exception table:
    //   from	to	target	type
    //   110	119	285	finally
    //   122	134	285	finally
    //   139	146	285	finally
    //   149	156	285	finally
    //   161	168	285	finally
    //   168	246	285	finally
    //   246	257	285	finally
    //   282	284	285	finally
    //   287	289	285	finally
    //   87	101	293	java/lang/Exception
    //   122	134	298	org/json/JSONException
    //   139	146	298	org/json/JSONException
    //   149	156	298	org/json/JSONException
    //   161	168	298	org/json/JSONException
    //   168	246	298	org/json/JSONException
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 36	com/tencent/token/bv:i	Z
    //   21: aload_0
    //   22: getfield 42	com/tencent/token/bv:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc_w 286
    //   34: iconst_0
    //   35: invokevirtual 292	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   50: invokevirtual 293	org/json/JSONArray:toString	()Ljava/lang/String;
    //   53: invokevirtual 94	java/lang/String:getBytes	()[B
    //   56: invokevirtual 298	java/io/FileOutputStream:write	([B)V
    //   59: aload_1
    //   60: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_1
    //   66: invokevirtual 301	java/io/FileOutputStream:close	()V
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
    //   0	84	0	this	bv
    //   0	84	1	paramContext	android.content.Context
    //   74	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   30	39	71	java/io/FileNotFoundException
    //   45	59	74	java/lang/Exception
    //   59	63	78	java/io/IOException
    //   65	69	81	java/io/IOException
  }
  
  public boolean b()
  {
    if (c.l()) {
      return false;
    }
    return a(RqdApplication.n());
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 42	com/tencent/token/bv:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 307	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   20: ldc_w 286
    //   23: invokevirtual 313	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
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
    //   41: invokevirtual 319	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: aload_0
    //   46: new 48	org/json/JSONArray
    //   49: dup
    //   50: new 90	java/lang/String
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 154	java/lang/String:<init>	([B)V
    //   58: invokespecial 320	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   61: putfield 51	com/tencent/token/bv:b	Lorg/json/JSONArray;
    //   64: aload_1
    //   65: invokevirtual 321	java/io/FileInputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 321	java/io/FileInputStream:close	()V
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
    //   0	89	0	this	bv
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
 * Qualified Name:     com.tencent.token.bv
 * JD-Core Version:    0.7.0.1
 */