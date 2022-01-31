package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.b;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class do
{
  public static final ex b = new ex("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static do p = null;
  public byte[] a = null;
  public long h = 0L;
  public long i = 0L;
  public boolean j = true;
  public boolean k = false;
  public fy l = null;
  public long m = 0L;
  private ex n = new ex("-1");
  private int o;
  private QQUser q = null;
  private long r = 0L;
  private long s = 0L;
  private HashMap t = new HashMap();
  
  public static do a()
  {
    if (p == null) {
      p = new do();
    }
    return p;
  }
  
  private String b(String paramString, long paramLong)
  {
    cx localcx = cx.c();
    localcx.m();
    String str = localcx.o();
    try
    {
      long l1 = Long.parseLong(paramString);
      paramString = new JSONObject();
      paramString.put("uin", l1);
      paramString.put("tkn_seq", String.valueOf(localcx.k()));
      paramString.put("tkn_code", str);
      paramString.put("pt_appid", paramLong);
      paramString = paramString.toString();
      h.a("plain: " + paramString);
      paramString = w.b(paramString.getBytes());
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
  
  private void b(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    h.a("data hex: " + paramJSONObject);
    dq localdq = new dq(this);
    localdq.a = ("" + paramJSONObject.getLong("uin"));
    localdq.b = paramJSONObject.getString("sig");
    if (paramJSONObject.getInt("is_login_prot_set") == 0)
    {
      bool1 = false;
      localdq.c = bool1;
      if (paramJSONObject.getInt("is_game_prot_set") != 0) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      localdq.d = bool1;
      localdq.e = paramJSONObject.getInt("is_tkn_set");
      if (localdq.e == 2) {
        localdq.f = paramJSONObject.getString("other_tkn_seq");
      }
      this.t.put(localdq.a, localdq);
      return;
      bool1 = true;
      break;
    }
  }
  
  private f c(f paramf)
  {
    localObject1 = new f();
    paramf.a();
    Object localObject3 = a();
    if (!((do)localObject3).o()) {
      if (!((do)localObject3).p())
      {
        localObject2 = ((do)localObject3).q();
        localObject1 = localObject2;
        if (((f)localObject2).b()) {}
      }
      else
      {
        do
        {
          return localObject2;
          localObject1 = ((do)localObject3).t();
          localObject2 = localObject1;
        } while (!((f)localObject1).b());
      }
    }
    Object localObject2 = ((do)localObject3).e();
    if (localObject2 == null)
    {
      ((f)localObject1).b(110);
      return localObject1;
    }
    try
    {
      localObject3 = cx.c();
      localObject5 = ((cx)localObject3).o();
      localObject4 = cv.a().b();
      if (localObject4 == null)
      {
        ((f)localObject1).b(104);
        return localObject1;
      }
    }
    finally {}
    int i1 = cw.a + 1;
    cw.a = i1;
    this.o = i1;
    Object localObject5 = w.a(new Object[] { "tkn_code", localObject5, "ksid", ((cx)localObject3).h(), "channel_id", w.m(), "seq_id", Integer.valueOf(this.o), "op_time", Long.valueOf(cx.c().s() / 1000L) });
    Object localObject4 = "?uin=" + ((QQUser)localObject2).mUin + "&aq_base_sid=" + (String)localObject4 + "&data=" + (String)localObject5;
    localObject5 = c.e() + "/cn/mbtoken3/mbtoken3_login_v2" + (String)localObject4;
    h.a((String)localObject5);
    localObject4 = new gk();
    localObject5 = ((gk)localObject4).a((String)localObject5);
    if (localObject5 == null)
    {
      ((f)localObject1).a(((gk)localObject4).a());
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = new String((byte[])localObject5);
        h.a("response: " + (String)localObject4);
        localObject4 = new JSONObject((String)localObject4);
        i1 = ((JSONObject)localObject4).getInt("err");
        if (i1 == 0) {
          continue;
        }
        localObject2 = ((JSONObject)localObject4).getString("info");
        ((f)localObject1).a(i1, (String)localObject2, (String)localObject2);
        paramf.b(i1);
        h.c("server errcode=" + i1);
      }
      catch (JSONException paramf)
      {
        long l1;
        h.c("parse json failed: " + paramf.toString());
        ((f)localObject1).a(10020, "JSONException:" + paramf.toString());
        continue;
        h.c("parseJSON error decodeData=" + paramf);
        ((f)localObject1).a(10022, RqdApplication.l().getString(2131230925), RqdApplication.l().getString(2131230925));
        continue;
      }
      return localObject1;
      paramf = w.c(((JSONObject)localObject4).getString("data"));
      if (paramf == null) {
        continue;
      }
      paramf = new JSONObject(new String(paramf));
      l1 = paramf.getLong("uin");
      if (l1 != ((QQUser)localObject2).mUin)
      {
        ((f)localObject1).a(10000, "uin not match=" + l1 + ":" + ((QQUser)localObject2).mUin);
        return localObject1;
      }
      a(paramf);
      i1 = paramf.getInt("seq_id");
      if (i1 != this.o)
      {
        ((f)localObject1).b(10030);
        h.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.o);
        return localObject1;
      }
      a().m();
      if (!this.l.a(l1))
      {
        ((f)localObject1).a(10000, "mUserStorage.setCurrentUserByUin failed");
        return localObject1;
      }
      this.q = ((QQUser)localObject2);
      this.r = (System.currentTimeMillis() / 1000L);
      this.s = paramf.getInt("valid_time");
      if (((cx)localObject3).h().length() == 0) {
        ((cx)localObject3).c(paramf.optString("ksid"));
      }
      ((f)localObject1).c();
    }
  }
  
  private byte[] c(String paramString)
  {
    try
    {
      paramString = new a().a(dg.a(paramString), this.a);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void v()
  {
    if (RqdApplication.g) {
      switch (c.a())
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
      this.q = null;
      this.r = 0L;
      this.s = 0L;
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
  
  public int a(Handler paramHandler)
  {
    new dp(this, paramHandler).c(new String[] { "" });
    return 0;
  }
  
  public Bitmap a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new gk().a(paramString);
    } while (paramString == null);
    return x.a(paramString);
  }
  
  public QQUser a(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public f a(String paramString, long paramLong)
  {
    f localf = new f();
    Object localObject = a();
    ((do)localObject).n();
    localObject = ((do)localObject).s();
    if (!((f)localObject).b()) {
      return localObject;
    }
    localObject = new gk();
    String str = b(paramString, paramLong);
    if (str == null)
    {
      localf.a(10000, "encrypt get mibao info failed");
      return localf;
    }
    str = "?aq_base_sid=" + c + "&data=" + str;
    str = c.e() + "/cn/mbtoken3/mbtoken3_verify_mb_for_login" + str;
    byte[] arrayOfByte = ((gk)localObject).a(str);
    if (arrayOfByte == null)
    {
      localf.a(((gk)localObject).a());
      h.c("client request url: " + str + " failed, reasion: " + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      localObject = new JSONObject(new String(arrayOfByte));
      int i1 = ((JSONObject)localObject).getInt("err");
      if (i1 != 0) {
        if (102 == i1)
        {
          long l1 = System.currentTimeMillis() + cx.c().q();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          h.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            cx.c().m();
            return a(paramString, paramLong);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              h.c(localException.getMessage());
            }
          }
        }
      }
      paramString = new JSONObject(new String(c(localException.getString("data"))));
    }
    catch (JSONException paramString)
    {
      h.c("parse json failed: " + paramString.toString());
      localf.a(10020, "JSONException:" + paramString.toString());
      return localf;
      paramString = localException.getString("info");
      localf.a(i1, paramString, paramString);
      return localf;
    }
    catch (Exception paramString)
    {
      h.c("unknown err: " + paramString.toString());
      localf.a(10021, "JSONException:" + paramString.toString());
      return localf;
    }
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      b(paramString);
      localf.c();
      return localf;
    }
  }
  
  /* Error */
  public f a(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 230	com/tencent/token/global/f
    //   3: dup
    //   4: invokespecial 231	com/tencent/token/global/f:<init>	()V
    //   7: astore 4
    //   9: new 487	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 488	java/util/LinkedList:<init>	()V
    //   16: astore 5
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload_1
    //   22: invokevirtual 491	org/json/JSONArray:length	()I
    //   25: if_icmpge +180 -> 205
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual 495	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   33: astore 7
    //   35: new 151	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 497
    //   45: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 7
    //   50: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   53: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 163	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   62: new 299	com/tencent/token/core/bean/QQUser
    //   65: dup
    //   66: invokespecial 498	com/tencent/token/core/bean/QQUser:<init>	()V
    //   69: astore 6
    //   71: aload 6
    //   73: aload 7
    //   75: ldc 124
    //   77: invokevirtual 192	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   80: putfield 302	com/tencent/token/core/bean/QQUser:mUin	J
    //   83: aload 6
    //   85: aload 7
    //   87: ldc_w 500
    //   90: invokevirtual 203	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 503	com/tencent/token/core/bean/QQUser:mUinMask	Ljava/lang/String;
    //   96: aload 6
    //   98: aload 7
    //   100: ldc_w 505
    //   103: invokevirtual 203	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 508	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   109: aload 6
    //   111: aload 7
    //   113: ldc_w 510
    //   116: invokevirtual 192	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   119: putfield 513	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   122: aload 7
    //   124: ldc_w 515
    //   127: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   130: iconst_1
    //   131: if_icmpne +131 -> 262
    //   134: iconst_1
    //   135: istore_3
    //   136: aload 6
    //   138: iload_3
    //   139: putfield 518	com/tencent/token/core/bean/QQUser:mIsSupperQQ	Z
    //   142: aload 6
    //   144: iconst_1
    //   145: putfield 521	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   148: aload 7
    //   150: ldc_w 523
    //   153: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: iconst_1
    //   157: if_icmpne +110 -> 267
    //   160: iconst_1
    //   161: istore_3
    //   162: aload 6
    //   164: iload_3
    //   165: putfield 526	com/tencent/token/core/bean/QQUser:mIsRegisterFacePwd	Z
    //   168: aload 7
    //   170: ldc_w 528
    //   173: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: iconst_1
    //   177: if_icmpne +95 -> 272
    //   180: iconst_1
    //   181: istore_3
    //   182: aload 6
    //   184: iload_3
    //   185: putfield 531	com/tencent/token/core/bean/QQUser:mIsZzb	Z
    //   188: aload 5
    //   190: aload 6
    //   192: invokeinterface 537 2 0
    //   197: pop
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -182 -> 20
    //   205: aload_0
    //   206: getfield 80	com/tencent/token/do:l	Lcom/tencent/token/fy;
    //   209: aload 5
    //   211: invokevirtual 540	com/tencent/token/fy:a	(Ljava/util/List;)V
    //   214: aload 4
    //   216: invokevirtual 383	com/tencent/token/global/f:c	()V
    //   219: aload 4
    //   221: areturn
    //   222: astore_1
    //   223: aload 4
    //   225: sipush 10020
    //   228: new 151	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 542
    //   238: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_1
    //   242: invokevirtual 386	org/json/JSONException:toString	()Ljava/lang/String;
    //   245: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokevirtual 354	com/tencent/token/global/f:a	(ILjava/lang/String;)V
    //   254: aload 4
    //   256: areturn
    //   257: astore 7
    //   259: goto -71 -> 188
    //   262: iconst_0
    //   263: istore_3
    //   264: goto -128 -> 136
    //   267: iconst_0
    //   268: istore_3
    //   269: goto -107 -> 162
    //   272: iconst_0
    //   273: istore_3
    //   274: goto -92 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	do
    //   0	277	1	paramJSONArray	org.json.JSONArray
    //   19	183	2	i1	int
    //   135	139	3	bool	boolean
    //   7	248	4	localf	f
    //   16	194	5	localLinkedList	java.util.LinkedList
    //   69	122	6	localQQUser	QQUser
    //   33	136	7	localJSONObject	JSONObject
    //   257	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	134	222	org/json/JSONException
    //   136	148	222	org/json/JSONException
    //   148	160	222	org/json/JSONException
    //   162	180	222	org/json/JSONException
    //   182	188	222	org/json/JSONException
    //   188	198	222	org/json/JSONException
    //   205	219	222	org/json/JSONException
    //   148	160	257	java/lang/Exception
    //   162	180	257	java/lang/Exception
    //   182	188	257	java/lang/Exception
  }
  
  public String a(long paramLong, String paramString)
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
      localJSONObject.put("net_type", w.k());
      paramString = w.d(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("router_id", paramString);
      }
      paramString = w.c(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("mac", paramString);
      }
      paramString = w.a(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("android_id", paramString);
      }
      paramString = w.b(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("device_id", paramString);
      }
      paramString = localJSONObject.toString();
      h.a("plain:" + paramString);
      paramString = w.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      h.c("JSONException:" + paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 266	com/tencent/token/cw:a	I
    //   3: iconst_1
    //   4: iadd
    //   5: istore 4
    //   7: iload 4
    //   9: putstatic 266	com/tencent/token/cw:a	I
    //   12: new 121	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 122	org/json/JSONObject:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: ldc 124
    //   25: aload_1
    //   26: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: getstatic 266	com/tencent/token/cw:a	I
    //   33: iconst_1
    //   34: iadd
    //   35: istore_3
    //   36: iload_3
    //   37: putstatic 266	com/tencent/token/cw:a	I
    //   40: aload 5
    //   42: ldc_w 278
    //   45: iload_3
    //   46: invokevirtual 608	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload 5
    //   52: ldc_w 285
    //   55: invokestatic 108	com/tencent/token/cx:c	()Lcom/tencent/token/cx;
    //   58: invokevirtual 287	com/tencent/token/cx:s	()J
    //   61: ldc2_w 288
    //   64: ldiv
    //   65: invokevirtual 128	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 5
    //   71: ldc_w 610
    //   74: aload_2
    //   75: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload 5
    //   81: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: new 151	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 603
    //   95: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 163	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 167	java/lang/String:getBytes	()[B
    //   112: invokestatic 172	com/tencent/token/utils/w:b	([B)Ljava/lang/String;
    //   115: astore_1
    //   116: new 151	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 446
    //   126: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: getstatic 48	com/tencent/token/do:c	Ljava/lang/String;
    //   132: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 306
    //   138: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_1
    //   149: new 151	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   156: invokestatic 310	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   159: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 612
    //   165: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_1
    //   176: new 314	com/tencent/token/gk
    //   179: dup
    //   180: invokespecial 315	com/tencent/token/gk:<init>	()V
    //   183: aload_1
    //   184: invokevirtual 318	com/tencent/token/gk:a	(Ljava/lang/String;)[B
    //   187: astore_1
    //   188: aload_1
    //   189: ifnonnull +40 -> 229
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: iload 4
    //   197: istore_3
    //   198: new 151	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 388
    //   208: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 604	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 343	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -110 -> 116
    //   229: new 135	java/lang/String
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 326	java/lang/String:<init>	([B)V
    //   237: astore_1
    //   238: new 151	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 328
    //   248: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 163	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   261: new 121	org/json/JSONObject
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 329	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   269: astore_1
    //   270: aload_1
    //   271: ldc_w 331
    //   274: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   277: ifne -85 -> 192
    //   280: aload_1
    //   281: ldc_w 345
    //   284: invokevirtual 203	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 347	com/tencent/token/utils/w:c	(Ljava/lang/String;)[B
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +81 -> 373
    //   295: new 121	org/json/JSONObject
    //   298: dup
    //   299: new 135	java/lang/String
    //   302: dup
    //   303: aload_1
    //   304: invokespecial 326	java/lang/String:<init>	([B)V
    //   307: invokespecial 329	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   310: astore_1
    //   311: aload_1
    //   312: ldc_w 278
    //   315: invokevirtual 211	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   318: istore 4
    //   320: iload 4
    //   322: iload_3
    //   323: if_icmpeq +42 -> 365
    //   326: new 151	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 358
    //   336: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 4
    //   341: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 360
    //   347: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokestatic 615	com/tencent/token/cw:a	()Lcom/tencent/token/cw;
    //   353: invokevirtual 617	com/tencent/token/cw:b	()I
    //   356: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 343	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   365: aload_1
    //   366: ldc_w 619
    //   369: invokevirtual 203	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: areturn
    //   373: new 151	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 390
    //   383: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_1
    //   387: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 343	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   396: aconst_null
    //   397: areturn
    //   398: astore_1
    //   399: new 151	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 385
    //   409: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 386	org/json/JSONException:toString	()Ljava/lang/String;
    //   416: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 343	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   425: aconst_null
    //   426: areturn
    //   427: astore_1
    //   428: goto -230 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	do
    //   0	431	1	paramString1	String
    //   0	431	2	paramString2	String
    //   35	289	3	i1	int
    //   5	335	4	i2	int
    //   19	61	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   12	40	194	org/json/JSONException
    //   229	291	398	org/json/JSONException
    //   295	320	398	org/json/JSONException
    //   326	365	398	org/json/JSONException
    //   365	373	398	org/json/JSONException
    //   373	396	398	org/json/JSONException
    //   40	116	427	org/json/JSONException
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    QQUser localQQUser = c(paramLong1);
    if (localQQUser != null)
    {
      this.q = localQQUser;
      this.r = (System.currentTimeMillis() / 1000L);
      this.s = paramLong3;
    }
  }
  
  public void a(List paramList)
  {
    this.l.b(paramList);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("server_time");
      cx.c().b(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      h.c("correct time error");
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.l.a(paramLong);
  }
  
  public boolean a(QQUser paramQQUser)
  {
    return this.l.b(paramQQUser);
  }
  
  public boolean a(f paramf)
  {
    if (!o())
    {
      f localf = q();
      if (!localf.b())
      {
        paramf.a(localf);
        return false;
      }
      h.a(o());
    }
    return true;
  }
  
  public QQUser b(int paramInt)
  {
    return this.l.b(paramInt);
  }
  
  public QQUser b(f paramf)
  {
    paramf.a();
    do localdo = a();
    if (localdo.e() == null)
    {
      h.c("there is no user bind");
      paramf.a(110, "there is no user bind");
      localObject = null;
    }
    QQUser localQQUser;
    do
    {
      return localObject;
      localQQUser = localdo.k();
      if (localQQUser != null)
      {
        paramf.c();
        return localQQUser;
      }
      localObject = localQQUser;
    } while (localQQUser != null);
    Object localObject = localdo.r();
    if (!((f)localObject).b())
    {
      h.c("user login failed:" + ((f)localObject).a + ((f)localObject).b);
      paramf.a((f)localObject);
      return null;
    }
    paramf = localdo.k();
    if (paramf != null) {}
    for (boolean bool = true;; bool = false)
    {
      h.a(bool);
      return paramf;
    }
  }
  
  public dq b(String paramString)
  {
    return (dq)this.t.get(paramString);
  }
  
  public void b()
  {
    p = null;
  }
  
  public boolean b(long paramLong)
  {
    return this.l.b(paramLong);
  }
  
  public boolean b(QQUser paramQQUser)
  {
    if ((paramQQUser == null) || (paramQQUser.mRealUin == 0L)) {
      return false;
    }
    return this.l.c(paramQQUser);
  }
  
  public QQUser c(long paramLong)
  {
    return this.l.c(paramLong);
  }
  
  public void c(QQUser paramQQUser)
  {
    if (paramQQUser == null) {
      return;
    }
    this.l.a(paramQQUser);
  }
  
  public boolean c(int paramInt)
  {
    if (104 == paramInt) {
      if (q().b()) {}
    }
    while ((109 != paramInt) || (!r().b()))
    {
      do
      {
        return false;
      } while (!r().b());
      return true;
    }
    return true;
  }
  
  public byte[] c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.l.b();
  }
  
  public QQUser d(long paramLong)
  {
    return this.l.d(paramLong);
  }
  
  public QQUser e()
  {
    return this.l.c();
  }
  
  public void e(long paramLong)
  {
    QQUser localQQUser = d(paramLong);
    if (localQQUser != null)
    {
      this.q = localQQUser;
      this.r = this.h;
      this.s = this.i;
    }
  }
  
  public long f()
  {
    return this.l.f();
  }
  
  public void f(long paramLong)
  {
    this.k = false;
    com.tencent.token.ui.AccountPageActivity.mNeedRefreshEval = true;
    this.m = paramLong;
  }
  
  public String g()
  {
    return c;
  }
  
  public boolean h()
  {
    return this.l.g();
  }
  
  public boolean i()
  {
    return this.l.e();
  }
  
  public boolean j()
  {
    return this.l.h();
  }
  
  public QQUser k()
  {
    if (!o())
    {
      h.a("not prepare");
      return null;
    }
    QQUser localQQUser = e();
    if ((localQQUser != null) && (this.q == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      h.a("mLoginTime =" + this.r + ",mLoginValidInterval= " + this.s + ",nowTime=" + l1);
      if (this.r + this.s > l1) {
        return this.q;
      }
    }
    h.a("user not login, login_user=" + this.q + ",current_user=" + localQQUser);
    this.q = null;
    this.r = 0L;
    this.s = 0L;
    return null;
  }
  
  public QQUser l()
  {
    QQUser localQQUser = e();
    if ((localQQUser != null) && (this.q == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if (this.r + this.s > l1) {
        return this.q;
      }
    }
    h.a("user not login, login_user=" + this.q + ",current_user=" + localQQUser);
    this.q = null;
    this.r = 0L;
    this.s = 0L;
    return null;
  }
  
  public void m()
  {
    this.h = (System.currentTimeMillis() / 1000L);
  }
  
  public void n()
  {
    v();
    this.j = true;
  }
  
  public boolean o()
  {
    if (c == null)
    {
      h.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      h.a("session time is expire");
      return false;
    }
    if (!this.k)
    {
      h.a("uinlist not queryed");
      return false;
    }
    return true;
  }
  
  public boolean p()
  {
    if (c == null)
    {
      h.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      h.a("session time is expire");
      return false;
    }
    return true;
  }
  
  /* Error */
  public f q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 701
    //   5: invokestatic 163	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: invokespecial 693	com/tencent/token/do:v	()V
    //   12: aload_0
    //   13: invokevirtual 240	com/tencent/token/do:p	()Z
    //   16: ifne +21 -> 37
    //   19: aload_0
    //   20: invokevirtual 440	com/tencent/token/do:s	()Lcom/tencent/token/global/f;
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 245	com/tencent/token/global/f:b	()Z
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 247	com/tencent/token/do:t	()Lcom/tencent/token/global/f;
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: invokevirtual 245	com/tencent/token/global/f:b	()Z
    //   48: ifeq -15 -> 33
    //   51: aload_0
    //   52: invokevirtual 238	com/tencent/token/do:o	()Z
    //   55: invokestatic 482	com/tencent/token/global/h:a	(Z)V
    //   58: new 230	com/tencent/token/global/f
    //   61: dup
    //   62: iconst_0
    //   63: invokespecial 703	com/tencent/token/global/f:<init>	(I)V
    //   66: astore_2
    //   67: goto -34 -> 33
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	do
    //   28	2	1	bool	boolean
    //   23	44	2	localObject1	Object
    //   70	4	2	localObject2	Object
    //   41	4	3	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	29	70	finally
    //   37	42	70	finally
    //   44	67	70	finally
  }
  
  public f r()
  {
    for (;;)
    {
      f localf3;
      try
      {
        h.a("start syncLogin process");
        localf3 = new f();
        f localf1 = c(localf3);
        boolean bool = localf1.b();
        if (bool) {
          return localf1;
        }
        if (localf3.a == 102)
        {
          long l1 = System.currentTimeMillis() + cx.c().q();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          h.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            localf1 = c(localf3);
          }
          catch (Exception localException)
          {
            h.c(localException.getMessage());
            continue;
          }
        }
        if (localf3.a != 104) {
          break label180;
        }
      }
      finally {}
      n();
      f localf2 = c(localf3);
      continue;
      label180:
      if (localf3.a == 112) {
        localf2 = c(localf3);
      }
    }
  }
  
  public f s()
  {
    try
    {
      f localf = b.a("mbtoken3_exchange_key_v3").c(new ev("mbtoken3_exchange_key_v3", 1, null, -1));
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public f t()
  {
    for (;;)
    {
      try
      {
        h.a("start syncQueryUinList process");
        f localf = new f();
        Object localObject2 = cx.c();
        ((cx)localObject2).m();
        Object localObject4 = ((cx)localObject2).o();
        if ((localObject4 == null) || (((String)localObject4).length() == 0) || (((String)localObject4).equals("0")))
        {
          localf.a(106, "tokennull");
          return localf;
        }
        localObject2 = a(((cx)localObject2).k(), (String)localObject4);
        localObject2 = "?aq_base_sid=" + c + "&data=" + (String)localObject2;
        localObject4 = c.e() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + (String)localObject2;
        localObject2 = new gk();
        localObject4 = ((gk)localObject2).a((String)localObject4);
        if (localObject4 == null)
        {
          localf.a(((gk)localObject2).a());
          continue;
        }
        try
        {
          localObject2 = new JSONObject(new String((byte[])localObject4));
          int i1 = ((JSONObject)localObject2).getInt("err");
          if (i1 == 0) {
            break label322;
          }
          if (i1 == 104) {
            n();
          }
          localObject2 = ((JSONObject)localObject2).getString("info");
          localObject1.a(i1, "server errcode=" + i1 + ":" + (String)localObject2, (String)localObject2);
        }
        catch (JSONException localJSONException)
        {
          h.c("parse json failed: " + localJSONException.toString());
          localObject1.a(10020, "JSONException:" + localJSONException.toString());
        }
      }
      finally {}
      continue;
      label322:
      Object localObject3 = w.c(localJSONException.getString("data"));
      if (localObject3 != null)
      {
        localObject3 = a(new JSONObject(new String((byte[])localObject3)).getJSONArray("uinlist"));
        if (((f)localObject3).b())
        {
          this.k = true;
          if (this.m != 0L)
          {
            b(this.m);
            this.m = 0L;
          }
          localObject1.c();
        }
        else
        {
          localObject1.a((f)localObject3);
        }
      }
      else
      {
        h.c("parseJSON error decodeData=" + localObject3);
        localObject1.a(10022, "parseJSON error decodeData= " + localObject3);
      }
    }
  }
  
  public void u()
  {
    this.q = null;
    this.r = 0L;
    this.s = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.do
 * JD-Core Version:    0.7.0.1
 */