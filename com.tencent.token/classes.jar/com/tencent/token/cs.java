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

public class cs
{
  public static final dr b = new dr("D87898D3A8B8FBB37DD9885F87E8817449FA1EBDBFCF7BDA2FA6DF721E7B99D2AF7A7368637009A6C6675A9180FB0F635400FEF6A64754186CDB72BF0A60B53257336A248A7F7AAF72F160894A60C68528E5FBCDF29D675F262400A656E34FA28C6D3D77357B4BA0B1CD928BFFAB90AA7948B862B167594027AF6DC0B4A16E53", 16);
  public static String c = null;
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static cs p = null;
  public byte[] a = null;
  public long h = 0L;
  public long i = 0L;
  public boolean j = true;
  public boolean k = false;
  public es l = null;
  public long m = 0L;
  private dr n = new dr("-1");
  private int o;
  private QQUser q = null;
  private long r = 0L;
  private long s = 0L;
  private HashMap<String, a> t = new HashMap();
  
  public static cs a()
  {
    if (p == null) {
      p = new cs();
    }
    return p;
  }
  
  private String b(String paramString, long paramLong)
  {
    Object localObject = cd.c();
    ((cd)localObject).m();
    String str = ((cd)localObject).o();
    try
    {
      long l1 = Long.parseLong(paramString);
      paramString = new JSONObject();
      paramString.put("uin", l1);
      paramString.put("tkn_seq", String.valueOf(((cd)localObject).k()));
      paramString.put("tkn_code", str);
      paramString.put("pt_appid", paramLong);
      paramString = paramString.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("plain: ");
      ((StringBuilder)localObject).append(paramString);
      g.a(((StringBuilder)localObject).toString());
      paramString = l.b(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("data hex: ");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.a(((StringBuilder)localObject).toString());
    localObject = new a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramJSONObject.getLong("uin"));
    ((a)localObject).a = localStringBuilder.toString();
    ((a)localObject).b = paramJSONObject.getString("sig");
    int i1 = paramJSONObject.getInt("is_login_prot_set");
    boolean bool2 = false;
    boolean bool1;
    if (i1 == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((a)localObject).c = bool1;
    if (paramJSONObject.getInt("is_game_prot_set") == 0) {
      bool1 = bool2;
    } else {
      bool1 = true;
    }
    ((a)localObject).d = bool1;
    ((a)localObject).e = paramJSONObject.getInt("is_tkn_set");
    if (((a)localObject).e == 2) {
      ((a)localObject).f = paramJSONObject.getString("other_tkn_seq");
    }
    this.t.put(((a)localObject).a, localObject);
  }
  
  private e c(e parame)
  {
    Object localObject1 = new e();
    parame.a();
    Object localObject3 = a();
    if (!((cs)localObject3).o()) {
      if (!((cs)localObject3).p())
      {
        localObject2 = ((cs)localObject3).q();
        localObject1 = localObject2;
        if (!((e)localObject2).b()) {
          return localObject2;
        }
      }
      else
      {
        localObject2 = ((cs)localObject3).u();
        localObject1 = localObject2;
        if (!((e)localObject2).b()) {
          return localObject2;
        }
      }
    }
    Object localObject2 = ((cs)localObject3).e();
    if (localObject2 == null)
    {
      ((e)localObject1).b(110);
      return localObject1;
    }
    try
    {
      localObject3 = cd.c();
      Object localObject5 = ((cd)localObject3).o();
      Object localObject4 = cb.a().b();
      if (localObject4 == null)
      {
        ((e)localObject1).b(104);
        return localObject1;
      }
      int i1 = cc.a + 1;
      cc.a = i1;
      this.o = i1;
      localObject5 = l.a(new Object[] { "tkn_code", localObject5, "ksid", ((cd)localObject3).h(), "channel_id", l.m(), "seq_id", Integer.valueOf(this.o), "op_time", Long.valueOf(cd.c().s() / 1000L) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("?uin=");
      localStringBuilder.append(((QQUser)localObject2).mUin);
      localStringBuilder.append("&aq_base_sid=");
      localStringBuilder.append((String)localObject4);
      localStringBuilder.append("&data=");
      localStringBuilder.append((String)localObject5);
      localObject4 = localStringBuilder.toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(c.e());
      ((StringBuilder)localObject5).append("/cn/mbtoken3/mbtoken3_login_v2");
      ((StringBuilder)localObject5).append((String)localObject4);
      localObject5 = ((StringBuilder)localObject5).toString();
      g.a((String)localObject5);
      localObject4 = new fc();
      localObject5 = ((fc)localObject4).a((String)localObject5);
      if (localObject5 == null)
      {
        ((e)localObject1).a(((fc)localObject4).a());
        return localObject1;
      }
      try
      {
        localObject4 = new String((byte[])localObject5);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("response: ");
        ((StringBuilder)localObject5).append((String)localObject4);
        g.a(((StringBuilder)localObject5).toString());
        localObject4 = new JSONObject((String)localObject4);
        i1 = ((JSONObject)localObject4).getInt("err");
        if (i1 != 0)
        {
          localObject2 = ((JSONObject)localObject4).getString("info");
          ((e)localObject1).a(i1, (String)localObject2, (String)localObject2);
          parame.b(i1);
          parame = new StringBuilder();
          parame.append("server errcode=");
          parame.append(i1);
          g.c(parame.toString());
        }
        else
        {
          parame = l.c(((JSONObject)localObject4).getString("data"));
          if (parame != null)
          {
            parame = new JSONObject(new String(parame));
            long l1 = parame.getLong("uin");
            if (l1 != ((QQUser)localObject2).mUin)
            {
              parame = new StringBuilder();
              parame.append("uin not match=");
              parame.append(l1);
              parame.append(":");
              parame.append(((QQUser)localObject2).mUin);
              ((e)localObject1).a(10000, parame.toString());
              return localObject1;
            }
            a(parame);
            i1 = parame.getInt("seq_id");
            if (i1 != this.o)
            {
              ((e)localObject1).b(10030);
              parame = new StringBuilder();
              parame.append("parseJSON error seq is wrong seq=");
              parame.append(i1);
              parame.append(",right = ");
              parame.append(this.o);
              g.c(parame.toString());
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
            if (((cd)localObject3).h().length() == 0) {
              ((cd)localObject3).c(parame.optString("ksid"));
            }
            ((e)localObject1).c();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parseJSON error decodeData=");
            ((StringBuilder)localObject2).append(parame);
            g.c(((StringBuilder)localObject2).toString());
            ((e)localObject1).a(10022, RqdApplication.n().getString(2131493068), RqdApplication.n().getString(2131493068));
          }
        }
      }
      catch (JSONException parame)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parse json failed: ");
        ((StringBuilder)localObject2).append(parame.toString());
        g.c(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("JSONException:");
        ((StringBuilder)localObject2).append(parame.toString());
        ((e)localObject1).a(10020, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    finally {}
  }
  
  private byte[] c(String paramString)
  {
    try
    {
      paramString = new a().a(ck.a(paramString), this.a);
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
    if (RqdApplication.h) {
      switch (c.a())
      {
      default: 
        e = null;
        c = null;
        break;
      case 3: 
        g = null;
        c = null;
        break;
      case 2: 
        f = null;
        c = null;
        break;
      case 1: 
        e = null;
        c = null;
        break;
      case 0: 
        d = null;
        c = null;
      }
    }
    c = null;
    this.k = false;
    this.h = 0L;
    this.i = 0L;
    this.q = null;
    this.r = 0L;
    this.s = 0L;
  }
  
  public int a(final Handler paramHandler)
  {
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        return cs.this.q();
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
    if (paramString == null) {
      return null;
    }
    paramString = new fc().a(paramString);
    if (paramString == null) {
      return null;
    }
    return m.a(paramString);
  }
  
  public QQUser a(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public e a(String paramString, long paramLong)
  {
    e locale = new e();
    Object localObject1 = a();
    ((cs)localObject1).n();
    localObject1 = ((cs)localObject1).s();
    if (!((e)localObject1).b()) {
      return localObject1;
    }
    localObject1 = new fc();
    String str = b(paramString, paramLong);
    if (str == null)
    {
      locale.a(10000, "encrypt get mibao info failed");
      return locale;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?aq_base_sid=");
    ((StringBuilder)localObject2).append(c);
    ((StringBuilder)localObject2).append("&data=");
    ((StringBuilder)localObject2).append(str);
    str = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(c.e());
    ((StringBuilder)localObject2).append("/cn/mbtoken3/mbtoken3_verify_mb_for_login");
    ((StringBuilder)localObject2).append(str);
    str = ((StringBuilder)localObject2).toString();
    localObject2 = ((fc)localObject1).a(str);
    if (localObject2 == null)
    {
      locale.a(((fc)localObject1).a());
      paramString = new StringBuilder();
      paramString.append("client request url: ");
      paramString.append(str);
      paramString.append(" failed, reasion: ");
      paramString.append(locale.a);
      paramString.append(":");
      paramString.append(locale.b);
      g.c(paramString.toString());
      return locale;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject2));
      int i1 = ((JSONObject)localObject1).getInt("err");
      if (i1 != 0)
      {
        if (102 == i1)
        {
          long l1 = System.currentTimeMillis() + cd.c().q();
          long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sleep ");
          ((StringBuilder)localObject1).append(l2);
          ((StringBuilder)localObject1).append("s for dyncode refresh:");
          ((StringBuilder)localObject1).append(l1);
          g.a(((StringBuilder)localObject1).toString());
          try
          {
            Thread.sleep(l2 * 1000L);
          }
          catch (Exception localException)
          {
            g.c(localException.getMessage());
          }
          cd.c().m();
          return a(paramString, paramLong);
        }
        paramString = localException.getString("info");
        locale.a(i1, paramString, paramString);
        return locale;
      }
      paramString = new JSONObject(new String(c(localException.getString("data"))));
      g.a(true);
      b(paramString);
      locale.c();
      return locale;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown err: ");
      localStringBuilder.append(paramString.toString());
      g.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException:");
      localStringBuilder.append(paramString.toString());
      locale.a(10021, localStringBuilder.toString());
      return locale;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse json failed: ");
      localStringBuilder.append(paramString.toString());
      g.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException:");
      localStringBuilder.append(paramString.toString());
      locale.a(10020, localStringBuilder.toString());
    }
    return locale;
  }
  
  /* Error */
  public e a(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 233	com/tencent/token/global/e
    //   3: dup
    //   4: invokespecial 234	com/tencent/token/global/e:<init>	()V
    //   7: astore 6
    //   9: new 489	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 490	java/util/LinkedList:<init>	()V
    //   16: astore 7
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload_1
    //   22: invokevirtual 493	org/json/JSONArray:length	()I
    //   25: if_icmpge +211 -> 236
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual 497	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   33: astore 8
    //   35: new 156	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   42: astore 9
    //   44: aload 9
    //   46: ldc_w 499
    //   49: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 9
    //   55: aload 8
    //   57: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   60: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 9
    //   66: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 168	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   72: new 303	com/tencent/token/core/bean/QQUser
    //   75: dup
    //   76: invokespecial 500	com/tencent/token/core/bean/QQUser:<init>	()V
    //   79: astore 9
    //   81: aload 9
    //   83: aload 8
    //   85: ldc 129
    //   87: invokevirtual 195	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   90: putfield 306	com/tencent/token/core/bean/QQUser:mUin	J
    //   93: aload 9
    //   95: aload 8
    //   97: ldc_w 502
    //   100: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: putfield 505	com/tencent/token/core/bean/QQUser:mUinMask	Ljava/lang/String;
    //   106: aload 9
    //   108: aload 8
    //   110: ldc_w 507
    //   113: invokevirtual 206	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: putfield 510	com/tencent/token/core/bean/QQUser:mNickName	Ljava/lang/String;
    //   119: aload 9
    //   121: aload 8
    //   123: ldc_w 512
    //   126: invokevirtual 195	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   129: putfield 515	com/tencent/token/core/bean/QQUser:mRealUin	J
    //   132: aload 8
    //   134: ldc_w 517
    //   137: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   140: istore_3
    //   141: iconst_1
    //   142: istore 5
    //   144: iload_3
    //   145: iconst_1
    //   146: if_icmpne +196 -> 342
    //   149: iconst_1
    //   150: istore 4
    //   152: goto +3 -> 155
    //   155: aload 9
    //   157: iload 4
    //   159: putfield 520	com/tencent/token/core/bean/QQUser:mIsSupperQQ	Z
    //   162: aload 9
    //   164: iconst_1
    //   165: putfield 523	com/tencent/token/core/bean/QQUser:mIsBinded	Z
    //   168: aload 8
    //   170: ldc_w 525
    //   173: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   176: iconst_1
    //   177: if_icmpne +171 -> 348
    //   180: iconst_1
    //   181: istore 4
    //   183: goto +3 -> 186
    //   186: aload 9
    //   188: iload 4
    //   190: putfield 528	com/tencent/token/core/bean/QQUser:mIsRegisterFacePwd	Z
    //   193: aload 8
    //   195: ldc_w 530
    //   198: invokevirtual 214	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   201: iconst_1
    //   202: if_icmpne +152 -> 354
    //   205: iload 5
    //   207: istore 4
    //   209: goto +3 -> 212
    //   212: aload 9
    //   214: iload 4
    //   216: putfield 533	com/tencent/token/core/bean/QQUser:mIsZzb	Z
    //   219: aload 7
    //   221: aload 9
    //   223: invokeinterface 539 2 0
    //   228: pop
    //   229: iload_2
    //   230: iconst_1
    //   231: iadd
    //   232: istore_2
    //   233: goto -213 -> 20
    //   236: new 156	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   243: astore_1
    //   244: aload_1
    //   245: ldc_w 541
    //   248: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: aload 7
    //   255: invokeinterface 544 1 0
    //   260: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc_w 546
    //   267: aload_1
    //   268: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 551	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: aload_0
    //   276: getfield 85	com/tencent/token/cs:l	Lcom/tencent/token/es;
    //   279: aload 7
    //   281: invokevirtual 554	com/tencent/token/es:a	(Ljava/util/List;)V
    //   284: aload 6
    //   286: invokevirtual 387	com/tencent/token/global/e:c	()V
    //   289: aload 6
    //   291: areturn
    //   292: astore_1
    //   293: new 156	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   300: astore 7
    //   302: aload 7
    //   304: ldc_w 556
    //   307: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 7
    //   313: aload_1
    //   314: invokevirtual 403	org/json/JSONException:toString	()Ljava/lang/String;
    //   317: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 6
    //   323: sipush 10020
    //   326: aload 7
    //   328: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokevirtual 358	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   334: aload 6
    //   336: areturn
    //   337: astore 8
    //   339: goto -120 -> 219
    //   342: iconst_0
    //   343: istore 4
    //   345: goto -190 -> 155
    //   348: iconst_0
    //   349: istore 4
    //   351: goto -165 -> 186
    //   354: iconst_0
    //   355: istore 4
    //   357: goto -145 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	cs
    //   0	360	1	paramJSONArray	org.json.JSONArray
    //   19	214	2	i1	int
    //   140	7	3	i2	int
    //   150	206	4	bool1	boolean
    //   142	64	5	bool2	boolean
    //   7	328	6	locale	e
    //   16	311	7	localObject1	Object
    //   33	161	8	localJSONObject	JSONObject
    //   337	1	8	localException	Exception
    //   42	180	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	141	292	org/json/JSONException
    //   155	168	292	org/json/JSONException
    //   168	180	292	org/json/JSONException
    //   186	205	292	org/json/JSONException
    //   212	219	292	org/json/JSONException
    //   219	229	292	org/json/JSONException
    //   236	289	292	org/json/JSONException
    //   168	180	337	java/lang/Exception
    //   186	205	337	java/lang/Exception
    //   212	219	337	java/lang/Exception
  }
  
  public String a(long paramLong, String paramString)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("tkn_seq", String.valueOf(paramLong));
      ((JSONObject)localObject).put("code", paramString);
      ((JSONObject)localObject).put("pm", URLEncoder.encode(Build.MODEL));
      ((JSONObject)localObject).put("pb", URLEncoder.encode(Build.BRAND));
      ((JSONObject)localObject).put("ps", Build.VERSION.SDK);
      ((JSONObject)localObject).put("pr", URLEncoder.encode(Build.VERSION.RELEASE));
      ((JSONObject)localObject).put("net_type", l.k());
      paramString = l.d(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("router_id", paramString);
      }
      paramString = l.c(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("mac", paramString);
      }
      paramString = l.a(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("android_id", paramString);
      }
      paramString = l.b(RqdApplication.n());
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("device_id", paramString);
      }
      int i1 = cc.a + 1;
      cc.a = i1;
      ((JSONObject)localObject).put("seq_id", i1);
      ((JSONObject)localObject).put("turingd_ticket_id", k.d());
      paramString = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("plain:");
      ((StringBuilder)localObject).append(paramString);
      g.a(((StringBuilder)localObject).toString());
      paramString = l.b(paramString.getBytes());
      return paramString;
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSONException:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      g.c(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    int i2 = cc.a + 1;
    cc.a = i2;
    int i1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString1);
      i1 = cc.a + 1;
      cc.a = i1;
      try
      {
        localJSONObject.put("seq_id", i1);
        localJSONObject.put("op_time", cd.c().s() / 1000L);
        localJSONObject.put("skey", paramString2);
        paramString1 = localJSONObject.toString();
        paramString2 = new StringBuilder();
        paramString2.append("plain:");
        paramString2.append(paramString1);
        g.a(paramString2.toString());
        paramString1 = l.b(paramString1.getBytes());
      }
      catch (JSONException paramString1) {}
      paramString2 = new StringBuilder();
    }
    catch (JSONException paramString1)
    {
      i1 = i2;
    }
    paramString2.append("JSONException:");
    paramString2.append(paramString1.getMessage());
    g.c(paramString2.toString());
    paramString1 = null;
    paramString2 = new StringBuilder();
    paramString2.append("?aq_base_sid=");
    paramString2.append(c);
    paramString2.append("&data=");
    paramString2.append(paramString1);
    paramString1 = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(c.e());
    paramString2.append("/cn/mbtoken3/mbtoken3_get_photo_v3");
    paramString2.append(paramString1);
    paramString1 = paramString2.toString();
    paramString1 = new fc().a(paramString1);
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = new String(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append("response: ");
      paramString2.append(paramString1);
      g.a(paramString2.toString());
      paramString1 = new JSONObject(paramString1);
      if (paramString1.getInt("err") != 0) {
        return null;
      }
      paramString1 = l.c(paramString1.getString("data"));
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(new String(paramString1));
        i2 = paramString1.getInt("seq_id");
        if (i2 != i1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("parseJSON error seq is wrong seq=");
          paramString2.append(i2);
          paramString2.append(",right = ");
          paramString2.append(cc.a().b());
          g.c(paramString2.toString());
        }
        return paramString1.getString("photo_url");
      }
      paramString2 = new StringBuilder();
      paramString2.append("parseJSON error decodeData=");
      paramString2.append(paramString1);
      g.c(paramString2.toString());
      return null;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("parse json failed: ");
      paramString2.append(paramString1.toString());
      g.c(paramString2.toString());
    }
    return null;
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
      cd.c().b(l1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label16:
      break label16;
    }
    g.c("correct time error");
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
    cs localcs = a();
    if (localcs.e() == null)
    {
      g.c("there is no user bind");
      parame.a(110, "there is no user bind");
      return null;
    }
    Object localObject2 = localcs.k();
    if (localObject2 != null)
    {
      parame.c();
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localcs.r();
      if (!((e)localObject1).b())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("user login failed:");
        ((StringBuilder)localObject2).append(((e)localObject1).a);
        ((StringBuilder)localObject2).append(((e)localObject1).b);
        g.c(((StringBuilder)localObject2).toString());
        parame.a((e)localObject1);
        return null;
      }
      localObject1 = localcs.k();
      boolean bool;
      if (localObject1 != null) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
    }
    return localObject1;
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
    if ((paramQQUser != null) && (paramQQUser.mRealUin != 0L)) {
      return this.l.c(paramQQUser);
    }
    return false;
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
    if (104 == paramInt)
    {
      if (!q().b()) {
        return false;
      }
      return r().b();
    }
    if (109 == paramInt) {
      return r().b();
    }
    return false;
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLoginTime =");
      localStringBuilder.append(this.r);
      localStringBuilder.append(",mLoginValidInterval= ");
      localStringBuilder.append(this.s);
      localStringBuilder.append(",nowTime=");
      localStringBuilder.append(l1);
      g.a(localStringBuilder.toString());
      if (this.r + this.s > l1) {
        return this.q;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user not login, login_user=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",current_user=");
    localStringBuilder.append(localQQUser);
    g.a(localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user not login, login_user=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",current_user=");
    localStringBuilder.append(localQQUser);
    g.a(localStringBuilder.toString());
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
  
  public e q()
  {
    try
    {
      g.a("start syncPrepare process");
      w();
      if (!p())
      {
        locale = s();
        bool = locale.b();
        if (!bool) {
          return locale;
        }
      }
      e locale = u();
      boolean bool = locale.b();
      if (!bool) {
        return locale;
      }
      g.a(o());
      locale = new e(0);
      return locale;
    }
    finally {}
  }
  
  public e r()
  {
    try
    {
      g.a("start syncLogin process");
      e locale2 = new e();
      Object localObject1 = c(locale2);
      boolean bool = ((e)localObject1).b();
      if (bool) {
        return localObject1;
      }
      e locale1;
      if (locale2.a == 102)
      {
        long l1 = System.currentTimeMillis() + cd.c().q();
        long l2 = 30 - (int)(l1 / 1000L % 30L) + 2L;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sleep ");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("s for dyncode refresh:");
        ((StringBuilder)localObject1).append(l1);
        g.a(((StringBuilder)localObject1).toString());
        try
        {
          Thread.sleep(l2 * 1000L);
        }
        catch (Exception localException)
        {
          g.c(localException.getMessage());
        }
        locale1 = c(locale2);
      }
      else if (locale2.a == 104)
      {
        n();
        locale1 = c(locale2);
      }
      else if (locale2.a == 112)
      {
        locale1 = c(locale2);
      }
      return locale1;
    }
    finally {}
  }
  
  public e s()
  {
    try
    {
      e locale = bw.a().b();
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
    try
    {
      g.a("start syncQueryUinList process");
      Log.i("login_test", "syncQueryUinList");
      e locale = new e();
      Object localObject2 = cd.c();
      ((cd)localObject2).m();
      localObject2 = ((cd)localObject2).o();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((String)localObject2).equals("0")))
      {
        locale = bw.a().c();
        return locale;
      }
      locale.a(106, "tokennull");
      return locale;
    }
    finally {}
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
 * Qualified Name:     com.tencent.token.cs
 * JD-Core Version:    0.7.0.1
 */