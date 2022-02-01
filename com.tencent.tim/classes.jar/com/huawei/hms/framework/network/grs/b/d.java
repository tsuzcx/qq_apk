package com.huawei.hms.framework.network.grs.b;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static final String a = d.class.getSimpleName();
  private Map<String, List<String>> b;
  private byte[] c;
  private int d = 0;
  private long e;
  private long f;
  private long g;
  private String h;
  private int i = 2;
  private int j = 9001;
  private String k = "";
  private String l = "";
  private String m = "";
  private long n = 0L;
  private Exception o;
  private String p;
  private int q;
  
  public d(int paramInt, Map<String, List<String>> paramMap, byte[] paramArrayOfByte, long paramLong)
  {
    this.d = paramInt;
    this.b = paramMap;
    this.c = paramArrayOfByte;
    this.e = paramLong;
    n();
  }
  
  public d(Exception paramException, long paramLong)
  {
    this.o = paramException;
    this.e = paramLong;
  }
  
  /* Error */
  private void a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 83 1 0
    //   10: ifgt +12 -> 22
    //   13: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   16: ldc 85
    //   18: invokestatic 91	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   21: return
    //   22: aload_1
    //   23: ldc 93
    //   25: invokeinterface 97 2 0
    //   30: ifeq +146 -> 176
    //   33: aload_1
    //   34: ldc 93
    //   36: invokeinterface 101 2 0
    //   41: checkcast 103	java/lang/String
    //   44: astore_1
    //   45: aload_1
    //   46: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +273 -> 322
    //   52: aload_1
    //   53: ldc 111
    //   55: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +264 -> 322
    //   61: aload_1
    //   62: aload_1
    //   63: ldc 111
    //   65: invokevirtual 118	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   68: ldc 111
    //   70: invokevirtual 121	java/lang/String:length	()I
    //   73: iadd
    //   74: invokevirtual 125	java/lang/String:substring	(I)Ljava/lang/String;
    //   77: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   80: lstore_2
    //   81: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   84: ldc 133
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: lload_2
    //   93: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: aastore
    //   97: invokestatic 141	com/huawei/hms/framework/common/Logger:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: lload_2
    //   101: lconst_0
    //   102: lcmp
    //   103: ifle +14 -> 117
    //   106: lload_2
    //   107: lstore 4
    //   109: lload_2
    //   110: ldc2_w 142
    //   113: lcmp
    //   114: ifle +8 -> 122
    //   117: ldc2_w 144
    //   120: lstore 4
    //   122: lload 4
    //   124: ldc2_w 146
    //   127: lmul
    //   128: lstore_2
    //   129: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   132: ldc 149
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: lload_2
    //   141: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aastore
    //   145: invokestatic 141	com/huawei/hms/framework/common/Logger:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: lload_2
    //   150: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   153: ladd
    //   154: invokestatic 158	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   157: invokespecial 161	com/huawei/hms/framework/network/grs/b/d:d	(Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: lconst_0
    //   163: lstore_2
    //   164: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   167: ldc 163
    //   169: aload_1
    //   170: invokestatic 166	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: goto -73 -> 100
    //   176: aload_1
    //   177: ldc 168
    //   179: invokeinterface 97 2 0
    //   184: ifeq +143 -> 327
    //   187: aload_1
    //   188: ldc 168
    //   190: invokeinterface 101 2 0
    //   195: checkcast 103	java/lang/String
    //   198: astore 8
    //   200: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   203: ldc 170
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 8
    //   213: aastore
    //   214: invokestatic 141	com/huawei/hms/framework/common/Logger:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: new 172	java/text/SimpleDateFormat
    //   220: dup
    //   221: ldc 174
    //   223: getstatic 180	java/util/Locale:ROOT	Ljava/util/Locale;
    //   226: invokespecial 183	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   229: astore 7
    //   231: aconst_null
    //   232: astore 6
    //   234: aload_1
    //   235: ldc 185
    //   237: invokeinterface 97 2 0
    //   242: ifeq +16 -> 258
    //   245: aload_1
    //   246: ldc 185
    //   248: invokeinterface 101 2 0
    //   253: checkcast 103	java/lang/String
    //   256: astore 6
    //   258: aload 7
    //   260: aload 8
    //   262: invokevirtual 191	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   265: astore 8
    //   267: aload 6
    //   269: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifeq +29 -> 301
    //   275: new 193	java/util/Date
    //   278: dup
    //   279: invokespecial 194	java/util/Date:<init>	()V
    //   282: astore_1
    //   283: aload 8
    //   285: invokevirtual 197	java/util/Date:getTime	()J
    //   288: aload_1
    //   289: invokevirtual 197	java/util/Date:getTime	()J
    //   292: lsub
    //   293: ldc2_w 146
    //   296: ldiv
    //   297: lstore_2
    //   298: goto -198 -> 100
    //   301: aload 7
    //   303: aload 6
    //   305: invokevirtual 191	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   308: astore_1
    //   309: goto -26 -> 283
    //   312: astore_1
    //   313: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   316: ldc 199
    //   318: aload_1
    //   319: invokestatic 166	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: lconst_0
    //   323: lstore_2
    //   324: goto -224 -> 100
    //   327: getstatic 38	com/huawei/hms/framework/network/grs/b/d:a	Ljava/lang/String;
    //   330: ldc 201
    //   332: invokestatic 203	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   335: goto -13 -> 322
    //   338: astore_1
    //   339: goto -175 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	d
    //   0	342	1	paramMap	Map<String, String>
    //   80	244	2	l1	long
    //   107	16	4	l2	long
    //   232	72	6	str	String
    //   229	73	7	localSimpleDateFormat	java.text.SimpleDateFormat
    //   198	86	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	81	161	java/lang/NumberFormatException
    //   258	283	312	java/text/ParseException
    //   283	298	312	java/text/ParseException
    //   301	309	312	java/text/ParseException
    //   81	100	338	java/lang/NumberFormatException
  }
  
  private void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  private void b(String paramString)
  {
    this.l = paramString;
  }
  
  private void b(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
      return;
    }
    if (paramMap.containsKey("Retry-After"))
    {
      paramMap = (String)paramMap.get("Retry-After");
      if (TextUtils.isEmpty(paramMap)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramMap);
        l1 *= 1000L;
        Logger.v(a, "convert retry-afterTime{%s}", new Object[] { Long.valueOf(l1) });
        c(l1);
        return;
      }
      catch (NumberFormatException paramMap)
      {
        Logger.w(a, "getRetryAfter addHeadersToResult NumberFormatException", paramMap);
      }
      long l1 = 0L;
    }
  }
  
  private void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  private void c(long paramLong)
  {
    this.n = paramLong;
  }
  
  private void c(String paramString)
  {
    this.h = paramString;
  }
  
  private void d(String paramString)
  {
    this.m = paramString;
  }
  
  private void e(String paramString)
  {
    this.k = paramString;
  }
  
  private void n()
  {
    o();
    q();
  }
  
  private void o()
  {
    if ((!h()) && (!i())) {}
    for (;;)
    {
      return;
      Map localMap = p();
      try
      {
        if (h()) {
          a(localMap);
        }
        if (i())
        {
          b(localMap);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Logger.w(a, "parseHeader catch JSONException", localJSONException);
      }
    }
  }
  
  private Map<String, String> p()
  {
    HashMap localHashMap = new HashMap(16);
    if ((this.b == null) || (this.b.size() <= 0))
    {
      Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
      return localHashMap;
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put((String)localEntry.getKey(), ((List)localEntry.getValue()).get(0));
    }
    return localHashMap;
  }
  
  private void q()
  {
    if (!h())
    {
      Logger.i(a, "GRSSDK parse server body all failed.");
      b(2);
      return;
    }
    JSONObject localJSONObject;
    int i2;
    for (;;)
    {
      try
      {
        str1 = StringUtils.byte2Str(this.c);
        localJSONObject = new JSONObject(str1);
        if (!localJSONObject.has("isSuccess")) {
          break label146;
        }
        i1 = localJSONObject.getInt("isSuccess");
        b(i1);
        if ((i1 != 0) || (!str1.contains("services"))) {
          break label257;
        }
        i2 = 1;
      }
      catch (JSONException localJSONException)
      {
        String str1;
        label123:
        Logger.w(a, "GrsResponse GrsResponse(String result) JSONException", localJSONException);
        b(2);
        return;
      }
      c(localJSONObject.getJSONObject("services").toString());
      if (i2 == 0) {
        break;
      }
      if (!localJSONObject.has("errorList")) {
        break label262;
      }
      str1 = localJSONObject.getString("errorList");
      b(str1);
      return;
      label146:
      if (localJSONObject.has("resultCode"))
      {
        i1 = localJSONObject.getInt("resultCode");
      }
      else
      {
        Logger.e(a, "sth. wrong because server errorcode's key.");
        i1 = -1;
        continue;
        label183:
        b(2);
        if (!localJSONObject.has("errorCode")) {
          break label268;
        }
      }
    }
    label257:
    label260:
    label262:
    label268:
    for (int i1 = localJSONObject.getInt("errorCode");; i1 = 9001)
    {
      c(i1);
      if (localJSONObject.has("errorDesc")) {}
      for (String str2 = localJSONObject.getString("errorDesc");; str2 = "")
      {
        e(str2);
        return;
      }
      for (;;)
      {
        if (i1 == 1) {
          break label260;
        }
        if (i2 == 0) {
          break label183;
        }
        break;
        i2 = 0;
      }
      break;
      str2 = "";
      break label123;
    }
  }
  
  public long a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public long b()
  {
    return this.g;
  }
  
  public void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public String d()
  {
    return this.m;
  }
  
  public long e()
  {
    return this.n;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.d == 200;
  }
  
  public boolean i()
  {
    return this.d == 503;
  }
  
  public Exception j()
  {
    return this.o;
  }
  
  public String k()
  {
    return this.p;
  }
  
  public int l()
  {
    return this.d;
  }
  
  public long m()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.d
 * JD-Core Version:    0.7.0.1
 */