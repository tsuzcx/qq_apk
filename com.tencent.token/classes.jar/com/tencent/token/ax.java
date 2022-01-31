package com.tencent.token;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ax
{
  public static final fu b = new fu("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static ax o = null;
  public byte[] a = null;
  public long h = 0L;
  public long i = 0L;
  public boolean j = true;
  public boolean k = false;
  public gj l = null;
  public long m = 0L;
  private fu n = new fu("-1");
  private QQUser p = null;
  private long q = 0L;
  private long r = 0L;
  private HashMap s = new HashMap();
  
  public static ax a()
  {
    if (o == null) {
      o = new ax();
    }
    return o;
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tkn_seq", String.valueOf(paramLong));
      localJSONObject.put("code", paramString);
      localJSONObject.put("pm", URLEncoder.encode(Build.MODEL));
      localJSONObject.put("pb", URLEncoder.encode(Build.BRAND));
      localJSONObject.put("ps", Build.VERSION.SDK);
      localJSONObject.put("pr", URLEncoder.encode(Build.VERSION.RELEASE));
      localJSONObject.put("net_type", s.i());
      paramString = s.d(RqdApplication.i());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("router_id", paramString);
      }
      paramString = s.c(RqdApplication.i());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("mac", paramString);
      }
      paramString = s.a(RqdApplication.i());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("android_id", paramString);
      }
      paramString = s.b(RqdApplication.i());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("device_id", paramString);
      }
      paramString = localJSONObject.toString();
      e.a("plain:" + paramString);
      paramString = s.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      e.c("JSONException:" + paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: getstatic 217	com/tencent/token/af:a	I
    //   3: iconst_1
    //   4: iadd
    //   5: istore_2
    //   6: iload_2
    //   7: putstatic 217	com/tencent/token/af:a	I
    //   10: new 101	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 102	org/json/JSONObject:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 219
    //   21: aload_0
    //   22: invokevirtual 114	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: getstatic 217	com/tencent/token/af:a	I
    //   29: iconst_1
    //   30: iadd
    //   31: istore_1
    //   32: iload_1
    //   33: putstatic 217	com/tencent/token/af:a	I
    //   36: aload_3
    //   37: ldc 221
    //   39: iload_1
    //   40: invokevirtual 224	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_3
    //   45: ldc 226
    //   47: invokestatic 231	com/tencent/token/ag:c	()Lcom/tencent/token/ag;
    //   50: invokevirtual 234	com/tencent/token/ag:r	()J
    //   53: ldc2_w 235
    //   56: ldiv
    //   57: invokevirtual 239	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload_3
    //   62: ldc 241
    //   64: aconst_null
    //   65: invokevirtual 114	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload_3
    //   70: invokevirtual 184	org/json/JSONObject:toString	()Ljava/lang/String;
    //   73: astore_0
    //   74: new 186	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   81: ldc 189
    //   83: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 198	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 202	java/lang/String:getBytes	()[B
    //   100: invokestatic 205	com/tencent/token/utils/s:b	([B)Ljava/lang/String;
    //   103: astore_0
    //   104: new 186	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   111: ldc 243
    //   113: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: getstatic 46	com/tencent/token/ax:c	Ljava/lang/String;
    //   119: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 245
    //   124: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore_0
    //   135: new 186	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   142: invokestatic 249	com/tencent/token/global/b:c	()Ljava/lang/String;
    //   145: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 251
    //   150: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore_0
    //   161: new 253	com/tencent/token/gv
    //   164: dup
    //   165: invokespecial 254	com/tencent/token/gv:<init>	()V
    //   168: aload_0
    //   169: invokevirtual 257	com/tencent/token/gv:a	(Ljava/lang/String;)[B
    //   172: astore_0
    //   173: aload_0
    //   174: ifnonnull +38 -> 212
    //   177: aconst_null
    //   178: areturn
    //   179: astore_0
    //   180: iload_2
    //   181: istore_1
    //   182: new 186	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   189: ldc 207
    //   191: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: invokevirtual 210	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 212	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -105 -> 104
    //   212: new 106	java/lang/String
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 260	java/lang/String:<init>	([B)V
    //   220: astore_0
    //   221: new 186	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 262
    //   231: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 198	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   244: new 101	org/json/JSONObject
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 263	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   252: astore_0
    //   253: aload_0
    //   254: ldc_w 265
    //   257: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   260: ifne -83 -> 177
    //   263: aload_0
    //   264: ldc_w 271
    //   267: invokevirtual 274	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   270: invokestatic 276	com/tencent/token/utils/s:d	(Ljava/lang/String;)[B
    //   273: astore_0
    //   274: aload_0
    //   275: ifnull +80 -> 355
    //   278: new 101	org/json/JSONObject
    //   281: dup
    //   282: new 106	java/lang/String
    //   285: dup
    //   286: aload_0
    //   287: invokespecial 260	java/lang/String:<init>	([B)V
    //   290: invokespecial 263	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   293: astore_0
    //   294: aload_0
    //   295: ldc 221
    //   297: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   300: istore_2
    //   301: iload_2
    //   302: iload_1
    //   303: if_icmpeq +44 -> 347
    //   306: new 186	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 278
    //   316: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload_2
    //   320: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: ldc_w 283
    //   326: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: astore_3
    //   330: invokestatic 286	com/tencent/token/af:a	()Lcom/tencent/token/af;
    //   333: pop
    //   334: aload_3
    //   335: invokestatic 289	com/tencent/token/af:b	()I
    //   338: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 212	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   347: aload_0
    //   348: ldc_w 291
    //   351: invokevirtual 274	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: areturn
    //   355: new 186	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 293
    //   365: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_0
    //   369: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 212	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   378: aconst_null
    //   379: areturn
    //   380: astore_0
    //   381: new 186	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 298
    //   391: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: invokevirtual 299	org/json/JSONException:toString	()Ljava/lang/String;
    //   398: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 212	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   407: aconst_null
    //   408: areturn
    //   409: astore_0
    //   410: goto -228 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString	String
    //   31	273	1	i1	int
    //   5	315	2	i2	int
    //   17	318	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	36	179	org/json/JSONException
    //   212	274	380	org/json/JSONException
    //   278	301	380	org/json/JSONException
    //   306	347	380	org/json/JSONException
    //   347	355	380	org/json/JSONException
    //   355	378	380	org/json/JSONException
    //   36	104	409	org/json/JSONException
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("server_time");
      ag.c();
      ag.b(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      e.c("correct time error");
    }
  }
  
  public static Bitmap b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new gv().a(paramString);
    } while (paramString == null);
    return t.a(paramString);
  }
  
  public static QQUser b(d paramd)
  {
    boolean bool = true;
    paramd.a = -1;
    paramd.b = "";
    paramd.c = "";
    paramd.d = null;
    if (o == null) {
      o = new ax();
    }
    ax localax = o;
    if (localax.l.b() == null)
    {
      e.c("there is no user bind");
      paramd.a(110, "there is no user bind", null);
      return null;
    }
    QQUser localQQUser = localax.k();
    if (localQQUser != null)
    {
      paramd.a = 0;
      return localQQUser;
    }
    Object localObject = localQQUser;
    if (localQQUser == null)
    {
      localObject = localax.r();
      if (((d)localObject).a == 0) {}
      for (int i1 = 1; i1 == 0; i1 = 0)
      {
        e.c("user login failed:" + ((d)localObject).a + ((d)localObject).b);
        paramd.a(((d)localObject).a, ((d)localObject).b, ((d)localObject).c);
        return null;
      }
      localObject = localax.k();
      if (localObject == null) {
        break label195;
      }
    }
    for (;;)
    {
      e.a(bool);
      return localObject;
      label195:
      bool = false;
    }
  }
  
  private static String b(String paramString, long paramLong)
  {
    ag localag = ag.c();
    localag.m();
    String str = localag.o();
    try
    {
      long l1 = Long.parseLong(paramString);
      paramString = new JSONObject();
      paramString.put("uin", l1);
      paramString.put("tkn_seq", String.valueOf(localag.k()));
      paramString.put("tkn_code", str);
      paramString.put("pt_appid", paramLong);
      paramString = paramString.toString();
      e.a("plain: " + paramString);
      paramString = s.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void b()
  {
    o = null;
  }
  
  private d c(d paramd)
  {
    int i2 = 1;
    int i1 = 1;
    localObject1 = new d((byte)0);
    paramd.a = -1;
    paramd.b = "";
    paramd.c = "";
    paramd.d = null;
    if (o == null) {
      o = new ax();
    }
    localObject3 = o;
    if (!((ax)localObject3).o())
    {
      if (!((ax)localObject3).p())
      {
        localObject2 = ((ax)localObject3).q();
        if (((d)localObject2).a == 0) {}
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 != 0) {
            break;
          }
          return localObject2;
          i1 = 0;
        }
      }
      localObject1 = ((ax)localObject3).t();
      if (((d)localObject1).a != 0) {
        break label158;
      }
    }
    label158:
    for (i1 = i2;; i1 = 0)
    {
      localObject2 = localObject1;
      if (i1 == 0) {
        break;
      }
      localObject2 = ((ax)localObject3).l.b();
      if (localObject2 != null) {
        break label163;
      }
      ((d)localObject1).a(110, null, null);
      return localObject1;
    }
    label163:
    Object localObject5;
    try
    {
      localObject3 = ag.c();
      localObject4 = ((ag)localObject3).o();
      localObject4 = "?uin=" + ((QQUser)localObject2).mUin + "&sess_id=" + c + "&tkn_code=" + (String)localObject4 + "&ksid=" + ((ag)localObject3).h();
      localObject5 = b.c() + "/cn/mbtoken3/mbtoken3_login" + (String)localObject4;
      e.a((String)localObject5);
      localObject4 = new gv();
      localObject5 = ((gv)localObject4).a((String)localObject5);
      if (localObject5 == null)
      {
        paramd = ((gv)localObject4).a();
        ((d)localObject1).a(paramd.a, paramd.b, paramd.c);
        return localObject1;
      }
    }
    finally {}
    for (;;)
    {
      try
      {
        localObject4 = new String((byte[])localObject5);
        e.a("response: " + (String)localObject4);
        localObject4 = new JSONObject((String)localObject4);
        l1 = ((JSONObject)localObject4).getLong("uin");
        if (l1 != ((QQUser)localObject2).mUin)
        {
          ((d)localObject1).a(10000, "uin not match=" + l1 + ":" + ((QQUser)localObject2).mUin, null);
          return localObject1;
        }
      }
      catch (JSONException paramd)
      {
        long l1;
        long l2;
        e.c("parse json failed: " + paramd.toString());
        ((d)localObject1).a(10020, "JSONException:" + paramd.toString(), null);
        continue;
        if (o != null) {
          continue;
        }
        o = new ax();
        o.h = (System.currentTimeMillis() / 1000L);
        if (this.l.a(l1)) {
          continue;
        }
        ((d)localObject1).a(10000, "mUserStorage.setCurrentUserByUin failed", null);
        return localObject1;
        this.p = ((QQUser)localObject2);
        this.q = (System.currentTimeMillis() / 1000L);
        this.r = ((JSONObject)localObject4).getInt("valid_time");
        if (((ag)localObject3).h().length() != 0) {
          continue;
        }
        ((ag)localObject3).c(((JSONObject)localObject4).getString("ksid"));
        ((d)localObject1).a = 0;
        continue;
      }
      try
      {
        l2 = ((JSONObject)localObject4).getLong("server_time");
        ag.c();
        ag.b(l2);
      }
      catch (Exception localException)
      {
        e.c("correct time error");
      }
    }
    i1 = ((JSONObject)localObject4).getInt("err");
    if (i1 != 0)
    {
      localObject2 = ((JSONObject)localObject4).getString("info");
      ((d)localObject1).a(i1, (String)localObject2, (String)localObject2);
      paramd.a(i1, null, null);
      e.c("server errcode=" + i1);
      return localObject1;
    }
  }
  
  private byte[] d(String paramString)
  {
    try
    {
      paramString = new a().a(ap.a(paramString), this.a);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String g()
  {
    return c;
  }
  
  private void v()
  {
    if (RqdApplication.g) {
      switch (b.a())
      {
      default: 
        e = null;
        c = null;
      }
    }
    for (;;)
    {
      c = null;
      this.k = false;
      this.h = 0L;
      this.i = 0L;
      this.p = null;
      this.q = 0L;
      this.r = 0L;
      return;
      d = null;
      c = null;
      continue;
      e = null;
      c = null;
      continue;
      f = null;
      c = null;
      continue;
      g = null;
      c = null;
    }
  }
  
  public final int a(Handler paramHandler)
  {
    new ay(this, paramHandler).a(new String[] { "" });
    return 0;
  }
  
  public final QQUser a(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public final d a(String paramString, long paramLong)
  {
    d locald = new d((byte)0);
    if (o == null) {
      o = new ax();
    }
    Object localObject = o;
    ((ax)localObject).v();
    ((ax)localObject).j = true;
    localObject = ((ax)localObject).s();
    if (((d)localObject).a == 0) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return localObject;
    }
    localObject = new gv();
    String str = b(paramString, paramLong);
    if (str == null)
    {
      locald.a(10000, "encrypt get mibao info failed", null);
      return locald;
    }
    str = "?aq_base_sid=" + c + "&data=" + str;
    str = b.c() + "/cn/mbtoken3/mbtoken3_verify_mb_for_login" + str;
    byte[] arrayOfByte = ((gv)localObject).a(str);
    if (arrayOfByte == null)
    {
      paramString = ((gv)localObject).a();
      locald.a(paramString.a, paramString.b, paramString.c);
      e.c("client request url: " + str + " failed, reasion: " + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      localObject = new JSONObject(new String(arrayOfByte));
      i1 = ((JSONObject)localObject).getInt("err");
      if (i1 != 0) {
        if (102 == i1)
        {
          long l1 = System.currentTimeMillis() + ag.c().p();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          e.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            ag.c().m();
            return a(paramString, paramLong);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              e.c(localException.getMessage());
            }
          }
        }
      }
      paramString = new JSONObject(new String(d(localException.getString("data"))));
    }
    catch (JSONException paramString)
    {
      e.c("parse json failed: " + paramString.toString());
      locald.a(10020, "JSONException:" + paramString.toString(), null);
      return locald;
      paramString = localException.getString("info");
      locald.a(i1, paramString, paramString);
      return locald;
    }
    catch (Exception paramString)
    {
      e.c("unknown err: " + paramString.toString());
      locald.a(10021, "JSONException:" + paramString.toString(), null);
      return locald;
    }
    e.a(true);
    e.a("data hex: " + paramString);
    az localaz = new az(this);
    localaz.a = ("" + paramString.getLong("uin"));
    localaz.b = paramString.getString("sig");
    if (paramString.getInt("is_login_prot_set") == 0)
    {
      bool = false;
      localaz.c = bool;
      if (paramString.getInt("is_game_prot_set") != 0) {
        break label759;
      }
    }
    label759:
    for (boolean bool = false;; bool = true)
    {
      localaz.d = bool;
      localaz.e = paramString.getInt("is_tkn_set");
      if (localaz.e == 2) {
        localaz.f = paramString.getString("other_tkn_seq");
      }
      this.s.put(localaz.a, localaz);
      locald.a = 0;
      return locald;
      bool = true;
      break;
    }
  }
  
  /* Error */
  public final d a(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 322	com/tencent/token/global/d
    //   3: dup
    //   4: iconst_0
    //   5: invokespecial 375	com/tencent/token/global/d:<init>	(B)V
    //   8: astore 4
    //   10: new 533	java/util/LinkedList
    //   13: dup
    //   14: invokespecial 534	java/util/LinkedList:<init>	()V
    //   17: astore 5
    //   19: iconst_0
    //   20: istore_2
    //   21: iload_2
    //   22: aload_1
    //   23: invokevirtual 537	org/json/JSONArray:length	()I
    //   26: if_icmpge +180 -> 206
    //   29: aload_1
    //   30: iload_2
    //   31: invokevirtual 541	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   34: astore 7
    //   36: new 186	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 543
    //   46: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 7
    //   51: invokevirtual 184	org/json/JSONObject:toString	()Ljava/lang/String;
    //   54: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 198	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   63: new 391	com/tencent/token/core/bean/QQUser
    //   66: dup
    //   67: invokespecial 544	com/tencent/token/core/bean/QQUser:<init>	()V
    //   70: astore 6
    //   72: aload 6
    //   74: aload 7
    //   76: ldc 219
    //   78: invokevirtual 308	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   81: putfield 394	com/tencent/token/core/bean/QQUser:mUin	J
    //   84: aload 6
    //   86: aload 7
    //   88: ldc_w 546
    //   91: invokevirtual 274	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: putfield 549	com/tencent/token/core/bean/QQUser:mUinMask	Ljava/lang/String;
    //   97: aload 6
    //   99: aload 7
    //   101: ldc_w 551
    //   104: invokevirtual 274	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 554	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   110: aload 6
    //   112: aload 7
    //   114: ldc_w 556
    //   117: invokevirtual 308	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   120: putfield 559	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   123: aload 7
    //   125: ldc_w 561
    //   128: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   131: iconst_1
    //   132: if_icmpne +133 -> 265
    //   135: iconst_1
    //   136: istore_3
    //   137: aload 6
    //   139: iload_3
    //   140: putfield 564	com/tencent/token/core/bean/QQUser:mIsSupperQQ	Z
    //   143: aload 6
    //   145: iconst_1
    //   146: putfield 567	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   149: aload 7
    //   151: ldc_w 569
    //   154: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   157: iconst_1
    //   158: if_icmpne +112 -> 270
    //   161: iconst_1
    //   162: istore_3
    //   163: aload 6
    //   165: iload_3
    //   166: putfield 572	com/tencent/token/core/bean/QQUser:mIsRegisterFacePwd	Z
    //   169: aload 7
    //   171: ldc_w 574
    //   174: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   177: iconst_1
    //   178: if_icmpne +97 -> 275
    //   181: iconst_1
    //   182: istore_3
    //   183: aload 6
    //   185: iload_3
    //   186: putfield 577	com/tencent/token/core/bean/QQUser:mIsZzb	Z
    //   189: aload 5
    //   191: aload 6
    //   193: invokeinterface 583 2 0
    //   198: pop
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -182 -> 21
    //   206: aload_0
    //   207: getfield 78	com/tencent/token/ax:l	Lcom/tencent/token/gj;
    //   210: aload 5
    //   212: invokevirtual 586	com/tencent/token/gj:a	(Ljava/util/List;)V
    //   215: aload 4
    //   217: iconst_0
    //   218: putfield 323	com/tencent/token/global/d:a	I
    //   221: aload 4
    //   223: areturn
    //   224: astore_1
    //   225: aload 4
    //   227: sipush 10020
    //   230: new 186	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 588
    //   240: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 299	org/json/JSONException:toString	()Ljava/lang/String;
    //   247: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: aconst_null
    //   254: invokevirtual 339	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   257: aload 4
    //   259: areturn
    //   260: astore 7
    //   262: goto -73 -> 189
    //   265: iconst_0
    //   266: istore_3
    //   267: goto -130 -> 137
    //   270: iconst_0
    //   271: istore_3
    //   272: goto -109 -> 163
    //   275: iconst_0
    //   276: istore_3
    //   277: goto -94 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ax
    //   0	280	1	paramJSONArray	org.json.JSONArray
    //   20	183	2	i1	int
    //   136	141	3	bool	boolean
    //   8	250	4	locald	d
    //   17	194	5	localLinkedList	java.util.LinkedList
    //   70	122	6	localQQUser	QQUser
    //   34	136	7	localJSONObject	JSONObject
    //   260	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   21	135	224	org/json/JSONException
    //   137	149	224	org/json/JSONException
    //   149	161	224	org/json/JSONException
    //   163	181	224	org/json/JSONException
    //   183	189	224	org/json/JSONException
    //   189	199	224	org/json/JSONException
    //   206	221	224	org/json/JSONException
    //   149	161	260	java/lang/Exception
    //   163	181	260	java/lang/Exception
    //   183	189	260	java/lang/Exception
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    QQUser localQQUser = this.l.c(paramLong1);
    if (localQQUser != null)
    {
      this.p = localQQUser;
      this.q = (System.currentTimeMillis() / 1000L);
      this.r = paramLong2;
    }
  }
  
  public final void a(List paramList)
  {
    this.l.b(paramList);
  }
  
  public final boolean a(long paramLong)
  {
    return this.l.a(paramLong);
  }
  
  public final boolean a(QQUser paramQQUser)
  {
    return this.l.b(paramQQUser);
  }
  
  public final boolean a(d paramd)
  {
    if (!o())
    {
      d locald = q();
      if (locald.a == 0) {}
      for (int i1 = 1; i1 == 0; i1 = 0)
      {
        paramd.a(locald.a, locald.b, locald.c);
        return false;
      }
      e.a(o());
    }
    return true;
  }
  
  public final QQUser b(int paramInt)
  {
    return this.l.b(paramInt);
  }
  
  public final boolean b(long paramLong)
  {
    return this.l.b(paramLong);
  }
  
  public final boolean b(QQUser paramQQUser)
  {
    if ((paramQQUser == null) || (paramQQUser.mRealUin == 0L)) {
      return false;
    }
    return this.l.c(paramQQUser);
  }
  
  public final az c(String paramString)
  {
    return (az)this.s.get(paramString);
  }
  
  public final QQUser c(long paramLong)
  {
    return this.l.c(paramLong);
  }
  
  public final void c(QQUser paramQQUser)
  {
    if (paramQQUser == null) {
      return;
    }
    this.l.a(paramQQUser);
  }
  
  public final boolean c(int paramInt)
  {
    if (104 == paramInt) {
      if (q().a == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label29;
        }
      }
    }
    for (;;)
    {
      return false;
      paramInt = 0;
      break;
      label29:
      if (r().a == 0) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0) {
        return true;
      }
      continue;
      if (109 == paramInt)
      {
        if (r().a == 0) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0) {
          return true;
        }
      }
    }
  }
  
  public final byte[] c()
  {
    return this.a;
  }
  
  public final int d()
  {
    return this.l.a();
  }
  
  public final QQUser d(long paramLong)
  {
    return this.l.d(paramLong);
  }
  
  public final QQUser e()
  {
    return this.l.b();
  }
  
  public final void e(long paramLong)
  {
    QQUser localQQUser = this.l.d(paramLong);
    if (localQQUser != null)
    {
      this.p = localQQUser;
      this.q = this.h;
      this.r = this.i;
    }
  }
  
  public final long f()
  {
    return this.l.d();
  }
  
  public final void f(long paramLong)
  {
    this.k = false;
    com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
    com.tencent.token.ui.SettingPageActivity.mNeedRefreshMbInfo = true;
    this.m = paramLong;
  }
  
  public final boolean h()
  {
    return this.l.e();
  }
  
  public final boolean i()
  {
    return this.l.c();
  }
  
  public final boolean j()
  {
    return this.l.f();
  }
  
  public final QQUser k()
  {
    if (!o())
    {
      e.a("not prepare");
      return null;
    }
    QQUser localQQUser = this.l.b();
    if ((localQQUser != null) && (this.p == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      e.a("mLoginTime =" + this.q + ",mLoginValidInterval= " + this.r + ",nowTime=" + l1);
      if (this.q + this.r > l1) {
        return this.p;
      }
    }
    e.a("user not login, login_user=" + this.p + ",current_user=" + localQQUser);
    this.p = null;
    this.q = 0L;
    this.r = 0L;
    return null;
  }
  
  public final QQUser l()
  {
    QQUser localQQUser = this.l.b();
    if ((localQQUser != null) && (this.p == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if (this.q + this.r > l1) {
        return this.p;
      }
    }
    e.a("user not login, login_user=" + this.p + ",current_user=" + localQQUser);
    this.p = null;
    this.q = 0L;
    this.r = 0L;
    return null;
  }
  
  public final void m()
  {
    this.h = (System.currentTimeMillis() / 1000L);
  }
  
  public final void n()
  {
    v();
    this.j = true;
  }
  
  public final boolean o()
  {
    if (c == null)
    {
      e.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      e.a("session time is expire");
      return false;
    }
    if (!this.k)
    {
      e.a("uinlist not queryed");
      return false;
    }
    return true;
  }
  
  public final boolean p()
  {
    if (c == null)
    {
      e.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      e.a("session time is expire");
      return false;
    }
    return true;
  }
  
  public final d q()
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        e.a("start syncPrepare process");
        v();
        int i1;
        if (!p())
        {
          locald = s();
          i1 = locald.a;
          if (i1 == 0)
          {
            i1 = 1;
            if (i1 == 0) {
              return locald;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
        }
        d locald = t();
        if (locald.a == 0)
        {
          i1 = i2;
          if (i1 != 0)
          {
            e.a(o());
            locald = new d();
          }
        }
        else
        {
          i1 = 0;
        }
      }
      finally {}
    }
  }
  
  public final d r()
  {
    int i1 = 1;
    for (;;)
    {
      d locald3;
      try
      {
        e.a("start syncLogin process");
        new d((byte)0);
        locald3 = new d((byte)0);
        d locald1 = c(locald3);
        int i2 = locald1.a;
        if (i2 == 0)
        {
          if (i1 != 0) {
            return locald1;
          }
        }
        else
        {
          i1 = 0;
          continue;
        }
        if (locald3.a == 102)
        {
          long l1 = System.currentTimeMillis() + ag.c().p();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          e.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            locald1 = c(locald3);
          }
          catch (Exception localException)
          {
            e.c(localException.getMessage());
            continue;
          }
        }
        if (locald3.a != 104) {
          break label206;
        }
      }
      finally {}
      v();
      this.j = true;
      d locald2 = c(locald3);
      continue;
      label206:
      if (locald3.a == 112) {
        locald2 = c(locald3);
      }
    }
  }
  
  public final d s()
  {
    try
    {
      d locald = bi.a("mbtoken3_exchange_key_v3").c(new fs("mbtoken3_exchange_key_v3", 1, null, -1));
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final d t()
  {
    int i1 = 1;
    for (;;)
    {
      try
      {
        e.a("start syncQueryUinList process");
        d locald = new d((byte)0);
        Object localObject2 = ag.c();
        ((ag)localObject2).m();
        Object localObject4 = ((ag)localObject2).o();
        if ((localObject4 == null) || (((String)localObject4).length() == 0) || (((String)localObject4).equals("0")))
        {
          locald.a(106, "tokennull", null);
          return locald;
        }
        localObject2 = a(((ag)localObject2).k(), (String)localObject4);
        localObject2 = "?aq_base_sid=" + c + "&data=" + (String)localObject2;
        localObject4 = b.c() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + (String)localObject2;
        localObject2 = new gv();
        localObject4 = ((gv)localObject2).a((String)localObject4);
        if (localObject4 == null)
        {
          localObject2 = ((gv)localObject2).a();
          locald.a(((d)localObject2).a, ((d)localObject2).b, ((d)localObject2).c);
        }
        else
        {
          try
          {
            localObject2 = new JSONObject(new String((byte[])localObject4));
            int i2 = ((JSONObject)localObject2).getInt("err");
            if (i2 == 0) {
              break;
            }
            if (i2 == 104)
            {
              v();
              this.j = true;
            }
            localObject2 = ((JSONObject)localObject2).getString("info");
            localObject1.a(i2, "server errcode=" + i2 + ":" + (String)localObject2, (String)localObject2);
          }
          catch (JSONException localJSONException)
          {
            e.c("parse json failed: " + localJSONException.toString());
            localObject1.a(10020, "JSONException:" + localJSONException.toString(), null);
          }
        }
      }
      finally {}
    }
    Object localObject3 = s.d(localJSONException.getString("data"));
    if (localObject3 != null)
    {
      localObject3 = a(new JSONObject(new String((byte[])localObject3)).getJSONArray("uinlist"));
      if (((d)localObject3).a != 0) {
        break label553;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.k = true;
        if (this.m != 0L)
        {
          long l1 = this.m;
          this.l.b(l1);
          this.m = 0L;
        }
        localObject1.a = 0;
        break;
      }
      localObject1.a(((d)localObject3).a, ((d)localObject3).b, ((d)localObject3).c);
      break;
      e.c("parseJSON error decodeData=" + localObject3);
      localObject1.a(10022, "parseJSON error decodeData= " + localObject3, null);
      break;
      label553:
      i1 = 0;
    }
  }
  
  public final void u()
  {
    this.p = null;
    this.q = 0L;
    this.r = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ax
 * JD-Core Version:    0.7.0.1
 */