package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.b;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class cq
{
  public static final dp b = new dp("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static cq p = null;
  public byte[] a = null;
  public long h = 0L;
  public long i = 0L;
  public boolean j = true;
  public boolean k = false;
  public ep l = null;
  public long m = 0L;
  private dp n = new dp("-1");
  private int o;
  private QQUser q = null;
  private long r = 0L;
  private long s = 0L;
  private HashMap<String, a> t = new HashMap();
  
  public static cq a()
  {
    if (p == null) {
      p = new cq();
    }
    return p;
  }
  
  private String b(String paramString, long paramLong)
  {
    cb localcb = cb.c();
    localcb.m();
    String str = localcb.o();
    try
    {
      long l1 = Long.parseLong(paramString);
      paramString = new JSONObject();
      paramString.put("uin", l1);
      paramString.put("tkn_seq", String.valueOf(localcb.k()));
      paramString.put("tkn_code", str);
      paramString.put("pt_appid", paramLong);
      paramString = paramString.toString();
      g.a("plain: " + paramString);
      paramString = l.b(paramString.getBytes());
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
    g.a("data hex: " + paramJSONObject);
    a locala = new a();
    locala.a = ("" + paramJSONObject.getLong("uin"));
    locala.b = paramJSONObject.getString("sig");
    if (paramJSONObject.getInt("is_login_prot_set") == 0)
    {
      bool1 = false;
      locala.c = bool1;
      if (paramJSONObject.getInt("is_game_prot_set") != 0) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      locala.d = bool1;
      locala.e = paramJSONObject.getInt("is_tkn_set");
      if (locala.e == 2) {
        locala.f = paramJSONObject.getString("other_tkn_seq");
      }
      this.t.put(locala.a, locala);
      return;
      bool1 = true;
      break;
    }
  }
  
  private e c(e parame)
  {
    localObject1 = new e();
    parame.a();
    Object localObject3 = a();
    if (!((cq)localObject3).o()) {
      if (!((cq)localObject3).p())
      {
        localObject2 = ((cq)localObject3).q();
        localObject1 = localObject2;
        if (((e)localObject2).b()) {}
      }
      else
      {
        do
        {
          return localObject2;
          localObject1 = ((cq)localObject3).u();
          localObject2 = localObject1;
        } while (!((e)localObject1).b());
      }
    }
    Object localObject2 = ((cq)localObject3).e();
    if (localObject2 == null)
    {
      ((e)localObject1).b(110);
      return localObject1;
    }
    try
    {
      localObject3 = cb.c();
      localObject5 = ((cb)localObject3).o();
      localObject4 = bz.a().b();
      if (localObject4 == null)
      {
        ((e)localObject1).b(104);
        return localObject1;
      }
    }
    finally {}
    int i1 = ca.a + 1;
    ca.a = i1;
    this.o = i1;
    Object localObject5 = l.a(new Object[] { "tkn_code", localObject5, "ksid", ((cb)localObject3).h(), "channel_id", l.m(), "seq_id", Integer.valueOf(this.o), "op_time", Long.valueOf(cb.c().s() / 1000L) });
    Object localObject4 = "?uin=" + ((QQUser)localObject2).mUin + "&aq_base_sid=" + (String)localObject4 + "&data=" + (String)localObject5;
    localObject5 = c.e() + "/cn/mbtoken3/mbtoken3_login_v2" + (String)localObject4;
    g.a((String)localObject5);
    localObject4 = new ey();
    localObject5 = ((ey)localObject4).a((String)localObject5);
    if (localObject5 == null)
    {
      ((e)localObject1).a(((ey)localObject4).a());
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = new String((byte[])localObject5);
        g.a("response: " + (String)localObject4);
        localObject4 = new JSONObject((String)localObject4);
        i1 = ((JSONObject)localObject4).getInt("err");
        if (i1 == 0) {
          continue;
        }
        localObject2 = ((JSONObject)localObject4).getString("info");
        ((e)localObject1).a(i1, (String)localObject2, (String)localObject2);
        parame.b(i1);
        g.c("server errcode=" + i1);
      }
      catch (JSONException parame)
      {
        long l1;
        g.c("parse json failed: " + parame.toString());
        ((e)localObject1).a(10020, "JSONException:" + parame.toString());
        continue;
        g.c("parseJSON error decodeData=" + parame);
        ((e)localObject1).a(10022, RqdApplication.l().getString(2131230925), RqdApplication.l().getString(2131230925));
        continue;
      }
      return localObject1;
      parame = l.c(((JSONObject)localObject4).getString("data"));
      if (parame == null) {
        continue;
      }
      parame = new JSONObject(new String(parame));
      l1 = parame.getLong("uin");
      if (l1 != ((QQUser)localObject2).mUin)
      {
        ((e)localObject1).a(10000, "uin not match=" + l1 + ":" + ((QQUser)localObject2).mUin);
        return localObject1;
      }
      a(parame);
      i1 = parame.getInt("seq_id");
      if (i1 != this.o)
      {
        ((e)localObject1).b(10030);
        g.c("parseJSON error seq is wrong seq=" + i1 + ",right = " + this.o);
        return localObject1;
      }
      a().m();
      if (!this.l.a(l1))
      {
        ((e)localObject1).a(10000, "mUserStorage.setCurrentUserByUin failed");
        return localObject1;
      }
      this.q = ((QQUser)localObject2);
      this.r = (System.currentTimeMillis() / 1000L);
      this.s = parame.getInt("valid_time");
      if (((cb)localObject3).h().length() == 0) {
        ((cb)localObject3).c(parame.optString("ksid"));
      }
      ((e)localObject1).c();
    }
  }
  
  private byte[] c(String paramString)
  {
    try
    {
      paramString = new a().a(ci.a(paramString), this.a);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void w()
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
  
  public int a(final Handler paramHandler)
  {
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        return cq.this.q();
      }
      
      public void a(e paramAnonymouse)
      {
        Message localMessage = paramHandler.obtainMessage();
        localMessage.what = 1008;
        localMessage.arg1 = paramAnonymouse.a;
        localMessage.obj = paramAnonymouse;
        localMessage.sendToTarget();
      }
    }.c(new String[] { "" });
    return 0;
  }
  
  public Bitmap a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new ey().a(paramString);
    } while (paramString == null);
    return m.a(paramString);
  }
  
  public QQUser a(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public e a(String paramString, long paramLong)
  {
    e locale = new e();
    Object localObject = a();
    ((cq)localObject).n();
    localObject = ((cq)localObject).s();
    if (!((e)localObject).b()) {
      return localObject;
    }
    localObject = new ey();
    String str = b(paramString, paramLong);
    if (str == null)
    {
      locale.a(10000, "encrypt get mibao info failed");
      return locale;
    }
    str = "?aq_base_sid=" + c + "&data=" + str;
    str = c.e() + "/cn/mbtoken3/mbtoken3_verify_mb_for_login" + str;
    byte[] arrayOfByte = ((ey)localObject).a(str);
    if (arrayOfByte == null)
    {
      locale.a(((ey)localObject).a());
      g.c("client request url: " + str + " failed, reasion: " + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      localObject = new JSONObject(new String(arrayOfByte));
      int i1 = ((JSONObject)localObject).getInt("err");
      if (i1 != 0) {
        if (102 == i1)
        {
          long l1 = System.currentTimeMillis() + cb.c().q();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          g.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            cb.c().m();
            return a(paramString, paramLong);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              g.c(localException.getMessage());
            }
          }
        }
      }
      paramString = new JSONObject(new String(c(localException.getString("data"))));
    }
    catch (JSONException paramString)
    {
      g.c("parse json failed: " + paramString.toString());
      locale.a(10020, "JSONException:" + paramString.toString());
      return locale;
      paramString = localException.getString("info");
      locale.a(i1, paramString, paramString);
      return locale;
    }
    catch (Exception paramString)
    {
      g.c("unknown err: " + paramString.toString());
      locale.a(10021, "JSONException:" + paramString.toString());
      return locale;
    }
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      g.a(bool);
      b(paramString);
      locale.c();
      return locale;
    }
  }
  
  /* Error */
  public e a(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 233	com/tencent/token/global/e
    //   3: dup
    //   4: invokespecial 234	com/tencent/token/global/e:<init>	()V
    //   7: astore 4
    //   9: new 489	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 490	java/util/LinkedList:<init>	()V
    //   16: astore 5
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload_1
    //   22: invokevirtual 493	org/json/JSONArray:length	()I
    //   25: if_icmpge +180 -> 205
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual 497	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   33: astore 7
    //   35: new 156	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 499
    //   45: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 7
    //   50: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   53: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 168	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   62: new 303	com/tencent/token/core/bean/QQUser
    //   65: dup
    //   66: invokespecial 500	com/tencent/token/core/bean/QQUser:<init>	()V
    //   69: astore 6
    //   71: aload 6
    //   73: aload 7
    //   75: ldc 129
    //   77: invokevirtual 195	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   80: putfield 306	com/tencent/token/core/bean/QQUser:mUin	J
    //   83: aload 6
    //   85: aload 7
    //   87: ldc_w 502
    //   90: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 505	com/tencent/token/core/bean/QQUser:mUinMask	Ljava/lang/String;
    //   96: aload 6
    //   98: aload 7
    //   100: ldc_w 507
    //   103: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 510	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   109: aload 6
    //   111: aload 7
    //   113: ldc_w 512
    //   116: invokevirtual 195	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   119: putfield 515	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   122: aload 7
    //   124: ldc_w 517
    //   127: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   130: iconst_1
    //   131: if_icmpne +164 -> 295
    //   134: iconst_1
    //   135: istore_3
    //   136: aload 6
    //   138: iload_3
    //   139: putfield 520	com/tencent/token/core/bean/QQUser:mIsSupperQQ	Z
    //   142: aload 6
    //   144: iconst_1
    //   145: putfield 523	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   148: aload 7
    //   150: ldc_w 525
    //   153: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: iconst_1
    //   157: if_icmpne +143 -> 300
    //   160: iconst_1
    //   161: istore_3
    //   162: aload 6
    //   164: iload_3
    //   165: putfield 528	com/tencent/token/core/bean/QQUser:mIsRegisterFacePwd	Z
    //   168: aload 7
    //   170: ldc_w 530
    //   173: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: iconst_1
    //   177: if_icmpne +128 -> 305
    //   180: iconst_1
    //   181: istore_3
    //   182: aload 6
    //   184: iload_3
    //   185: putfield 533	com/tencent/token/core/bean/QQUser:mIsZzb	Z
    //   188: aload 5
    //   190: aload 6
    //   192: invokeinterface 539 2 0
    //   197: pop
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -182 -> 20
    //   205: ldc_w 541
    //   208: new 156	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 543
    //   218: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 5
    //   223: invokeinterface 546 1 0
    //   228: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 551	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   237: pop
    //   238: aload_0
    //   239: getfield 85	com/tencent/token/cq:l	Lcom/tencent/token/ep;
    //   242: aload 5
    //   244: invokevirtual 554	com/tencent/token/ep:a	(Ljava/util/List;)V
    //   247: aload 4
    //   249: invokevirtual 387	com/tencent/token/global/e:c	()V
    //   252: aload 4
    //   254: areturn
    //   255: astore_1
    //   256: aload 4
    //   258: sipush 10020
    //   261: new 156	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 556
    //   271: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 390	org/json/JSONException:toString	()Ljava/lang/String;
    //   278: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 358	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   287: aload 4
    //   289: areturn
    //   290: astore 7
    //   292: goto -104 -> 188
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -161 -> 136
    //   300: iconst_0
    //   301: istore_3
    //   302: goto -140 -> 162
    //   305: iconst_0
    //   306: istore_3
    //   307: goto -125 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	cq
    //   0	310	1	paramJSONArray	org.json.JSONArray
    //   19	183	2	i1	int
    //   135	172	3	bool	boolean
    //   7	281	4	locale	e
    //   16	227	5	localLinkedList	java.util.LinkedList
    //   69	122	6	localQQUser	QQUser
    //   33	136	7	localJSONObject	JSONObject
    //   290	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	134	255	org/json/JSONException
    //   136	148	255	org/json/JSONException
    //   148	160	255	org/json/JSONException
    //   162	180	255	org/json/JSONException
    //   182	188	255	org/json/JSONException
    //   188	198	255	org/json/JSONException
    //   205	252	255	org/json/JSONException
    //   148	160	290	java/lang/Exception
    //   162	180	290	java/lang/Exception
    //   182	188	290	java/lang/Exception
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
      localJSONObject.put("net_type", l.k());
      paramString = l.d(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("router_id", paramString);
      }
      paramString = l.c(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("mac", paramString);
      }
      paramString = l.a(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("android_id", paramString);
      }
      paramString = l.b(RqdApplication.l());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("device_id", paramString);
      }
      int i1 = ca.a + 1;
      ca.a = i1;
      localJSONObject.put("seq_id", i1);
      localJSONObject.put("turingd_ticket_id", k.c());
      paramString = localJSONObject.toString();
      g.a("plain:" + paramString);
      paramString = l.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      g.c("JSONException:" + paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 270	com/tencent/token/ca:a	I
    //   3: iconst_1
    //   4: iadd
    //   5: istore 4
    //   7: iload 4
    //   9: putstatic 270	com/tencent/token/ca:a	I
    //   12: new 126	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 127	org/json/JSONObject:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: ldc 129
    //   25: aload_1
    //   26: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: getstatic 270	com/tencent/token/ca:a	I
    //   33: iconst_1
    //   34: iadd
    //   35: istore_3
    //   36: iload_3
    //   37: putstatic 270	com/tencent/token/ca:a	I
    //   40: aload 5
    //   42: ldc_w 282
    //   45: iload_3
    //   46: invokevirtual 618	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload 5
    //   52: ldc_w 289
    //   55: invokestatic 113	com/tencent/token/cb:c	()Lcom/tencent/token/cb;
    //   58: invokevirtual 291	com/tencent/token/cb:s	()J
    //   61: ldc2_w 292
    //   64: ldiv
    //   65: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 5
    //   71: ldc_w 630
    //   74: aload_2
    //   75: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload 5
    //   81: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: new 156	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 626
    //   95: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 168	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 172	java/lang/String:getBytes	()[B
    //   112: invokestatic 177	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   115: astore_1
    //   116: new 156	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 448
    //   126: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: getstatic 53	com/tencent/token/cq:c	Ljava/lang/String;
    //   132: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 310
    //   138: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_1
    //   149: new 156	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   156: invokestatic 314	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   159: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 632
    //   165: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: astore_1
    //   176: new 318	com/tencent/token/ey
    //   179: dup
    //   180: invokespecial 319	com/tencent/token/ey:<init>	()V
    //   183: aload_1
    //   184: invokevirtual 322	com/tencent/token/ey:a	(Ljava/lang/String;)[B
    //   187: astore_1
    //   188: aload_1
    //   189: ifnonnull +40 -> 229
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: iload 4
    //   197: istore_3
    //   198: new 156	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 392
    //   208: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 627	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 347	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -110 -> 116
    //   229: new 140	java/lang/String
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 330	java/lang/String:<init>	([B)V
    //   237: astore_1
    //   238: new 156	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 332
    //   248: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 168	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   261: new 126	org/json/JSONObject
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 333	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   269: astore_1
    //   270: aload_1
    //   271: ldc_w 335
    //   274: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   277: ifne -85 -> 192
    //   280: aload_1
    //   281: ldc_w 349
    //   284: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 351	com/tencent/token/utils/l:c	(Ljava/lang/String;)[B
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +81 -> 373
    //   295: new 126	org/json/JSONObject
    //   298: dup
    //   299: new 140	java/lang/String
    //   302: dup
    //   303: aload_1
    //   304: invokespecial 330	java/lang/String:<init>	([B)V
    //   307: invokespecial 333	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   310: astore_1
    //   311: aload_1
    //   312: ldc_w 282
    //   315: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   318: istore 4
    //   320: iload 4
    //   322: iload_3
    //   323: if_icmpeq +42 -> 365
    //   326: new 156	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 362
    //   336: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 4
    //   341: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 364
    //   347: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokestatic 635	com/tencent/token/ca:a	()Lcom/tencent/token/ca;
    //   353: invokevirtual 637	com/tencent/token/ca:b	()I
    //   356: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 347	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   365: aload_1
    //   366: ldc_w 639
    //   369: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: areturn
    //   373: new 156	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 394
    //   383: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_1
    //   387: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 347	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   396: aconst_null
    //   397: areturn
    //   398: astore_1
    //   399: new 156	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 389
    //   409: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_1
    //   413: invokevirtual 390	org/json/JSONException:toString	()Ljava/lang/String;
    //   416: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 347	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   425: aconst_null
    //   426: areturn
    //   427: astore_1
    //   428: goto -230 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	cq
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
  
  public void a(List<QQUser> paramList)
  {
    this.l.b(paramList);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      long l1 = paramJSONObject.getLong("server_time");
      cb.c().b(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      g.c("correct time error");
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
  
  public boolean a(e parame)
  {
    if (!o())
    {
      e locale = q();
      if (!locale.b())
      {
        parame.a(locale);
        return false;
      }
      g.a(o());
    }
    return true;
  }
  
  public QQUser b(int paramInt)
  {
    return this.l.b(paramInt);
  }
  
  public QQUser b(e parame)
  {
    parame.a();
    cq localcq = a();
    if (localcq.e() == null)
    {
      g.c("there is no user bind");
      parame.a(110, "there is no user bind");
      localObject = null;
    }
    QQUser localQQUser;
    do
    {
      return localObject;
      localQQUser = localcq.k();
      if (localQQUser != null)
      {
        parame.c();
        return localQQUser;
      }
      localObject = localQQUser;
    } while (localQQUser != null);
    Object localObject = localcq.r();
    if (!((e)localObject).b())
    {
      g.c("user login failed:" + ((e)localObject).a + ((e)localObject).b);
      parame.a((e)localObject);
      return null;
    }
    parame = localcq.k();
    if (parame != null) {}
    for (boolean bool = true;; bool = false)
    {
      g.a(bool);
      return parame;
    }
  }
  
  public a b(String paramString)
  {
    return (a)this.t.get(paramString);
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
    return this.l.g();
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
    return this.l.h();
  }
  
  public boolean i()
  {
    return this.l.e();
  }
  
  public boolean j()
  {
    return this.l.i();
  }
  
  public QQUser k()
  {
    if (!o())
    {
      g.a("not prepare");
      return null;
    }
    QQUser localQQUser = e();
    if ((localQQUser != null) && (this.q == localQQUser))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      g.a("mLoginTime =" + this.r + ",mLoginValidInterval= " + this.s + ",nowTime=" + l1);
      if (this.r + this.s > l1) {
        return this.q;
      }
    }
    g.a("user not login, login_user=" + this.q + ",current_user=" + localQQUser);
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
    g.a("user not login, login_user=" + this.q + ",current_user=" + localQQUser);
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
    w();
    this.j = true;
  }
  
  public boolean o()
  {
    if (c == null)
    {
      g.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      g.a("session time is expire");
      return false;
    }
    if (!this.k)
    {
      g.a("uinlist not queryed");
      return false;
    }
    return true;
  }
  
  public boolean p()
  {
    if (c == null)
    {
      g.a("sessId is null");
      return false;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.h + this.i <= l1)
    {
      g.a("session time is expire");
      return false;
    }
    return true;
  }
  
  /* Error */
  public e q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 723
    //   5: invokestatic 168	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: invokespecial 715	com/tencent/token/cq:w	()V
    //   12: aload_0
    //   13: invokevirtual 243	com/tencent/token/cq:p	()Z
    //   16: ifne +21 -> 37
    //   19: aload_0
    //   20: invokevirtual 442	com/tencent/token/cq:s	()Lcom/tencent/token/global/e;
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 248	com/tencent/token/global/e:b	()Z
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 251	com/tencent/token/cq:u	()Lcom/tencent/token/global/e;
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: invokevirtual 248	com/tencent/token/global/e:b	()Z
    //   48: ifeq -15 -> 33
    //   51: aload_0
    //   52: invokevirtual 241	com/tencent/token/cq:o	()Z
    //   55: invokestatic 484	com/tencent/token/global/g:a	(Z)V
    //   58: new 233	com/tencent/token/global/e
    //   61: dup
    //   62: iconst_0
    //   63: invokespecial 725	com/tencent/token/global/e:<init>	(I)V
    //   66: astore_2
    //   67: goto -34 -> 33
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	cq
    //   28	2	1	bool	boolean
    //   23	44	2	localObject1	Object
    //   70	4	2	localObject2	Object
    //   41	4	3	locale	e
    // Exception table:
    //   from	to	target	type
    //   2	29	70	finally
    //   37	42	70	finally
    //   44	67	70	finally
  }
  
  public e r()
  {
    for (;;)
    {
      e locale3;
      try
      {
        g.a("start syncLogin process");
        locale3 = new e();
        e locale1 = c(locale3);
        boolean bool = locale1.b();
        if (bool) {
          return locale1;
        }
        if (locale3.a == 102)
        {
          long l1 = System.currentTimeMillis() + cb.c().q();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          g.a("sleep " + l2 + "s for dyncode refresh:" + l1);
          try
          {
            Thread.sleep(l2 * 1000L);
            locale1 = c(locale3);
          }
          catch (Exception localException)
          {
            g.c(localException.getMessage());
            continue;
          }
        }
        if (locale3.a != 104) {
          break label180;
        }
      }
      finally {}
      n();
      e locale2 = c(locale3);
      continue;
      label180:
      if (locale3.a == 112) {
        locale2 = c(locale3);
      }
    }
  }
  
  public e s()
  {
    try
    {
      e locale = b.a("mbtoken3_exchange_key_v3").c(new dn("mbtoken3_exchange_key_v3", 1, null, -1));
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void t()
  {
    this.l.f();
  }
  
  public e u()
  {
    for (;;)
    {
      try
      {
        g.a("start syncQueryUinList process");
        Log.i("login_test", "syncQueryUinList");
        e locale = new e();
        Object localObject2 = cb.c();
        ((cb)localObject2).m();
        Object localObject4 = ((cb)localObject2).o();
        if ((localObject4 == null) || (((String)localObject4).length() == 0) || (((String)localObject4).equals("0")))
        {
          locale.a(106, "tokennull");
          return locale;
        }
        localObject2 = a(((cb)localObject2).k(), (String)localObject4);
        localObject2 = "?aq_base_sid=" + c + "&data=" + (String)localObject2;
        localObject4 = c.e() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + (String)localObject2;
        localObject2 = new ey();
        localObject4 = ((ey)localObject2).a((String)localObject4);
        if (localObject4 == null)
        {
          locale.a(((ey)localObject2).a());
          continue;
        }
        try
        {
          localObject2 = new JSONObject(new String((byte[])localObject4));
          int i1 = ((JSONObject)localObject2).getInt("err");
          if (i1 == 0) {
            break label387;
          }
          if (i1 == 104) {
            n();
          }
          localObject2 = ((JSONObject)localObject2).getString("info");
          localObject1.a(i1, "server errcode=" + i1 + ":" + (String)localObject2, (String)localObject2);
          Log.i("uin_list_test", "@syncQueryUinList err retcode:" + i1);
        }
        catch (JSONException localJSONException)
        {
          g.c("parse json failed: " + localJSONException.toString());
          localObject1.a(10020, "JSONException:" + localJSONException.toString());
        }
      }
      finally {}
      continue;
      label387:
      Object localObject3 = l.c(localJSONException.getString("data"));
      if (localObject3 != null)
      {
        localObject3 = new JSONObject(new String((byte[])localObject3));
        try
        {
          long l1 = ((JSONObject)localObject3).getLong("seed_expire_time");
          cb.c().c(l1);
          Log.i("uin_list_test", "syncQueryUinList seed_expire_time:" + l1);
          localObject3 = a(((JSONObject)localObject3).getJSONArray("uinlist"));
          if (((e)localObject3).b())
          {
            this.k = true;
            if (this.m != 0L)
            {
              b(this.m);
              this.m = 0L;
            }
            localObject1.c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          localObject1.a((e)localObject3);
        }
      }
      else
      {
        g.c("parseJSON error decodeData=" + localObject3);
        localObject1.a(10022, "parseJSON error decodeData= " + localObject3);
      }
    }
  }
  
  public void v()
  {
    this.q = null;
    this.r = 0L;
    this.s = 0L;
  }
  
  public class a
  {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public String f;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cq
 * JD-Core Version:    0.7.0.1
 */