package com.tencent.token;

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
  
  /* Error */
  private e a(String paramString)
  {
    // Byte code:
    //   0: new 74	com/tencent/token/global/e
    //   3: dup
    //   4: invokespecial 75	com/tencent/token/global/e:<init>	()V
    //   7: astore_3
    //   8: invokestatic 80	com/tencent/token/cr:a	()Lcom/tencent/token/cr;
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 83	com/tencent/token/cr:o	()Z
    //   18: ifne +24 -> 42
    //   21: aload_3
    //   22: sipush 30001
    //   25: invokevirtual 86	com/tencent/token/global/e:b	(I)V
    //   28: aload_0
    //   29: getfield 88	com/tencent/token/by:j	Z
    //   32: ifeq +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 90	com/tencent/token/by:b	()Z
    //   39: pop
    //   40: aload_3
    //   41: areturn
    //   42: aload 4
    //   44: invokevirtual 93	com/tencent/token/cr:k	()Lcom/tencent/token/core/bean/QQUser;
    //   47: ifnull +6 -> 53
    //   50: goto +9 -> 59
    //   53: aload 4
    //   55: invokevirtual 95	com/tencent/token/cr:e	()Lcom/tencent/token/core/bean/QQUser;
    //   58: pop
    //   59: new 97	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: ldc 100
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 113	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 119	java/lang/String:getBytes	()[B
    //   95: invokestatic 124	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   98: astore_1
    //   99: new 97	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: invokestatic 126	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   113: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: ldc 128
    //   121: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 4
    //   127: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore 4
    //   132: new 130	android/content/ContentValues
    //   135: dup
    //   136: iconst_3
    //   137: invokespecial 132	android/content/ContentValues:<init>	(I)V
    //   140: astore 5
    //   142: aload 5
    //   144: ldc 134
    //   146: getstatic 136	com/tencent/token/cr:c	Ljava/lang/String;
    //   149: invokevirtual 140	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 5
    //   154: ldc 142
    //   156: aload_1
    //   157: invokevirtual 140	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: new 97	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   167: astore 6
    //   169: aload 6
    //   171: ldc 144
    //   173: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: getstatic 136	com/tencent/token/cr:c	Ljava/lang/String;
    //   182: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 6
    //   188: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 113	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   194: new 97	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   201: astore 6
    //   203: aload 6
    //   205: ldc 100
    //   207: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_1
    //   214: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 6
    //   220: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 113	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   226: new 146	com/tencent/token/ez
    //   229: dup
    //   230: invokespecial 147	com/tencent/token/ez:<init>	()V
    //   233: astore_1
    //   234: aload_1
    //   235: aload 4
    //   237: aload 5
    //   239: invokevirtual 150	com/tencent/token/ez:a	(Ljava/lang/String;Landroid/content/ContentValues;)[B
    //   242: astore 4
    //   244: aload 4
    //   246: ifnonnull +25 -> 271
    //   249: aload_0
    //   250: getfield 88	com/tencent/token/by:j	Z
    //   253: ifeq +8 -> 261
    //   256: aload_0
    //   257: invokevirtual 90	com/tencent/token/by:b	()Z
    //   260: pop
    //   261: aload_3
    //   262: aload_1
    //   263: invokevirtual 153	com/tencent/token/ez:a	()Lcom/tencent/token/global/e;
    //   266: invokevirtual 156	com/tencent/token/global/e:a	(Lcom/tencent/token/global/e;)V
    //   269: aload_3
    //   270: areturn
    //   271: new 158	org/json/JSONObject
    //   274: dup
    //   275: new 115	java/lang/String
    //   278: dup
    //   279: aload 4
    //   281: invokespecial 161	java/lang/String:<init>	([B)V
    //   284: invokespecial 163	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   287: astore_1
    //   288: aload_1
    //   289: ldc 165
    //   291: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   294: istore_2
    //   295: iload_2
    //   296: ifeq +20 -> 316
    //   299: aload_1
    //   300: ldc 171
    //   302: invokevirtual 175	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: astore_1
    //   306: aload_3
    //   307: iload_2
    //   308: aload_1
    //   309: aload_1
    //   310: invokevirtual 178	com/tencent/token/global/e:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   313: goto +100 -> 413
    //   316: aload_3
    //   317: invokevirtual 180	com/tencent/token/global/e:c	()V
    //   320: aload_0
    //   321: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   324: invokevirtual 184	org/json/JSONArray:length	()I
    //   327: getstatic 186	com/tencent/token/by:e	I
    //   330: if_icmple +10 -> 340
    //   333: getstatic 186	com/tencent/token/by:e	I
    //   336: istore_2
    //   337: goto +11 -> 348
    //   340: aload_0
    //   341: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   344: invokevirtual 184	org/json/JSONArray:length	()I
    //   347: istore_2
    //   348: iload_2
    //   349: getstatic 186	com/tencent/token/by:e	I
    //   352: if_icmpgt +17 -> 369
    //   355: aload_0
    //   356: new 48	org/json/JSONArray
    //   359: dup
    //   360: invokespecial 49	org/json/JSONArray:<init>	()V
    //   363: putfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   366: goto +47 -> 413
    //   369: new 48	org/json/JSONArray
    //   372: dup
    //   373: invokespecial 49	org/json/JSONArray:<init>	()V
    //   376: astore_1
    //   377: iload_2
    //   378: aload_0
    //   379: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   382: invokevirtual 184	org/json/JSONArray:length	()I
    //   385: if_icmpge +23 -> 408
    //   388: aload_1
    //   389: aload_0
    //   390: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   393: iload_2
    //   394: invokevirtual 190	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   397: invokevirtual 193	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   400: pop
    //   401: iload_2
    //   402: iconst_1
    //   403: iadd
    //   404: istore_2
    //   405: goto -28 -> 377
    //   408: aload_0
    //   409: aload_1
    //   410: putfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   413: aload_0
    //   414: getfield 88	com/tencent/token/by:j	Z
    //   417: ifeq +184 -> 601
    //   420: aload_0
    //   421: invokevirtual 90	com/tencent/token/by:b	()Z
    //   424: pop
    //   425: aload_3
    //   426: areturn
    //   427: astore_1
    //   428: goto +175 -> 603
    //   431: astore_1
    //   432: new 97	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   439: astore 4
    //   441: aload 4
    //   443: ldc 195
    //   445: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 4
    //   451: aload_1
    //   452: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   455: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 4
    //   461: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 198	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   467: new 97	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   474: astore 4
    //   476: aload 4
    //   478: ldc 200
    //   480: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 4
    //   486: aload_1
    //   487: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   490: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: sipush 10021
    //   498: aload 4
    //   500: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokevirtual 203	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   506: aload_0
    //   507: getfield 88	com/tencent/token/by:j	Z
    //   510: ifeq +91 -> 601
    //   513: goto -93 -> 420
    //   516: astore_1
    //   517: new 97	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   524: astore 4
    //   526: aload 4
    //   528: ldc 205
    //   530: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 4
    //   536: aload_1
    //   537: invokevirtual 206	org/json/JSONException:toString	()Ljava/lang/String;
    //   540: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 4
    //   546: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 198	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   552: new 97	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   559: astore 4
    //   561: aload 4
    //   563: ldc 200
    //   565: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 4
    //   571: aload_1
    //   572: invokevirtual 206	org/json/JSONException:toString	()Ljava/lang/String;
    //   575: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_3
    //   580: sipush 10020
    //   583: aload 4
    //   585: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokevirtual 203	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   591: aload_0
    //   592: getfield 88	com/tencent/token/by:j	Z
    //   595: ifeq +6 -> 601
    //   598: goto -178 -> 420
    //   601: aload_3
    //   602: areturn
    //   603: aload_0
    //   604: getfield 88	com/tencent/token/by:j	Z
    //   607: ifeq +8 -> 615
    //   610: aload_0
    //   611: invokevirtual 90	com/tencent/token/by:b	()Z
    //   614: pop
    //   615: aload_1
    //   616: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	by
    //   0	617	1	paramString	String
    //   294	111	2	m	int
    //   7	595	3	locale	e
    //   11	573	4	localObject	Object
    //   140	98	5	localContentValues	android.content.ContentValues
    //   167	52	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   271	295	427	finally
    //   299	313	427	finally
    //   316	337	427	finally
    //   340	348	427	finally
    //   348	366	427	finally
    //   369	377	427	finally
    //   377	401	427	finally
    //   408	413	427	finally
    //   432	506	427	finally
    //   517	591	427	finally
    //   271	295	431	java/lang/Exception
    //   299	313	431	java/lang/Exception
    //   316	337	431	java/lang/Exception
    //   340	348	431	java/lang/Exception
    //   348	366	431	java/lang/Exception
    //   369	377	431	java/lang/Exception
    //   377	401	431	java/lang/Exception
    //   408	413	431	java/lang/Exception
    //   271	295	516	org/json/JSONException
    //   299	313	516	org/json/JSONException
    //   316	337	516	org/json/JSONException
    //   340	348	516	org/json/JSONException
    //   348	366	516	org/json/JSONException
    //   369	377	516	org/json/JSONException
    //   377	401	516	org/json/JSONException
    //   408	413	516	org/json/JSONException
  }
  
  public void a(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    if (c.l()) {
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
      label106:
      break label106;
    }
    if (this.b.length() >= f) {
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (c.l()) {
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
        localJSONObject.put("tkn_seq", String.valueOf(cc.c().k()));
        if (cr.a().e() != null) {
          localJSONObject.put("uin", cr.a().e().mRealUin);
        }
        localObject2 = l.c(RqdApplication.l());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("mac", localObject2);
        }
        localObject2 = l.b(RqdApplication.l());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("device_id", localObject2);
        }
        localJSONObject.put("model", URLEncoder.encode(Build.MODEL));
        localJSONObject.put("release", URLEncoder.encode(Build.VERSION.RELEASE));
        localJSONObject.put("platfrom", "android");
        localJSONObject.put("guid", l.a(bz.a(RqdApplication.l()).b()));
        localObject2 = l.d(RqdApplication.l());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localJSONObject.put("router_id", localObject2);
        }
        localJSONObject.put("event_list", localJSONArray);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("JSONException:");
        ((StringBuilder)localObject2).append(localException2.getMessage());
        g.c(((StringBuilder)localObject2).toString());
      }
      this.c = localJSONObject.toString();
      this.k = new UserTask()
      {
        public e a(String... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = by.this;
          return by.a(paramAnonymousVarArgs, paramAnonymousVarArgs.c);
        }
        
        public void a()
        {
          by.a(by.this, false);
        }
        
        public void a(e paramAnonymouse)
        {
          if (paramAnonymouse.b())
          {
            by.b(by.d());
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("post click flow msg failed:");
            localStringBuilder.append(paramAnonymouse.a);
            localStringBuilder.append("-");
            localStringBuilder.append(paramAnonymouse.b);
            g.c(localStringBuilder.toString());
            if (by.e() >= by.f()) {}
          }
          try
          {
            by.b(by.f());
          }
          catch (Exception|Error paramAnonymouse)
          {
            break label90;
          }
          by.b(by.d());
          label90:
          by.a(by.this, false);
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
    //   0: invokestatic 62	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: iconst_0
    //   18: putstatic 36	com/tencent/token/by:i	Z
    //   21: aload_0
    //   22: getfield 42	com/tencent/token/by:a	Z
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_1
    //   31: ldc_w 336
    //   34: iconst_0
    //   35: invokevirtual 342	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   50: invokevirtual 343	org/json/JSONArray:toString	()Ljava/lang/String;
    //   53: invokevirtual 119	java/lang/String:getBytes	()[B
    //   56: invokevirtual 348	java/io/FileOutputStream:write	([B)V
    //   59: aload_1
    //   60: invokevirtual 351	java/io/FileOutputStream:close	()V
    //   63: iconst_1
    //   64: ireturn
    //   65: aload_1
    //   66: invokevirtual 351	java/io/FileOutputStream:close	()V
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
    //   0	84	0	this	by
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
    return a(RqdApplication.l());
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 62	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 42	com/tencent/token/by:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 258	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   20: ldc_w 336
    //   23: invokevirtual 357	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
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
    //   41: invokevirtual 363	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: aload_0
    //   46: new 48	org/json/JSONArray
    //   49: dup
    //   50: new 115	java/lang/String
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 161	java/lang/String:<init>	([B)V
    //   58: invokespecial 364	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   61: putfield 51	com/tencent/token/by:b	Lorg/json/JSONArray;
    //   64: aload_1
    //   65: invokevirtual 365	java/io/FileInputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 365	java/io/FileInputStream:close	()V
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
    //   0	89	0	this	by
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
 * Qualified Name:     com.tencent.token.by
 * JD-Core Version:    0.7.0.1
 */