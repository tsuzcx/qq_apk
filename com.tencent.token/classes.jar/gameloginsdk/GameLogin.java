package gameloginsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aih;
import com.tencent.token.aij;
import com.tencent.token.ail;
import com.tencent.token.aqr;
import com.tencent.token.aqv;
import com.tencent.token.aqx;
import com.tencent.token.arb;
import com.tencent.token.arc;
import com.tencent.token.are;
import com.tencent.token.asd;
import com.tencent.token.asg;
import com.tencent.token.aso;
import com.tencent.token.ate;
import com.tencent.token.jr;
import com.tencent.token.js;
import com.tencent.token.jt;
import com.tencent.token.jv;
import com.tencent.token.jw;
import com.tencent.token.jx;
import com.tencent.token.jy;
import com.tencent.token.kc;
import com.tencent.token.kf;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tmsdk.common.c.a.b;

public class GameLogin
{
  public static final int GAME_LOGIN_SDK_VERSION = 1;
  public static final String TAG = "GameLogin";
  long a = 1800000L;
  long b = 10000L;
  boolean c = false;
  boolean d = false;
  ail e = null;
  IGameLoginCallback f;
  o g = new o();
  AtomicInteger h = new AtomicInteger();
  Handler i = new Handler(Looper.getMainLooper());
  aij j = new c(this);
  private Object k = new Object();
  private long l = -1L;
  private Stack m = new Stack();
  private AtomicInteger n = new AtomicInteger(0);
  private AtomicLong o = new AtomicLong(0L);
  private AtomicLong p = new AtomicLong(0L);
  private a q = new a();
  private a r = new a();
  private Set s = new HashSet();
  private m t = new m();
  private boolean u = false;
  
  public GameLogin()
  {
    kf.a();
    this.e = ((ail)kc.a());
    int i2 = (int)System.currentTimeMillis();
    int i1 = i2;
    if (i2 < 0) {
      i1 = -i2;
    }
    this.h.set(i1 / 100);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if (paramInt2 == 1) {
      return 2147483647;
    }
    return 0;
  }
  
  private String a(int paramInt)
  {
    switch (arb.filterNetworkCode(paramInt))
    {
    default: 
      return "未知错误";
    case 0: 
      return "";
    case -6: 
      return "需要wifi验证，请先进行wifi验证";
    case -8: 
    case -7: 
      return "服务器繁忙，请稍后重试";
    }
    return "网络错误，请检查网络";
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append(paramArrayOfByte[i1]);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private byte[] a(String paramString)
  {
    if (paramString != null) {
      if ("".equals(paramString)) {
        return null;
      }
    }
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        MessageDigest localMessageDigest;
        localMessageDigest.update(paramString.getBytes("UTF-8"));
        return localMessageDigest.digest();
        return null;
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
      }
      catch (UnsupportedEncodingException paramString)
      {
        break label42;
      }
    }
    localMessageDigest = null;
    if (localMessageDigest == null) {
      return null;
    }
  }
  
  private int e()
  {
    return this.h.incrementAndGet();
  }
  
  private int f()
  {
    if (this.n == null) {
      return -1;
    }
    new StringBuilder("获取计数 : ").append(this.n.get());
    return this.n.get();
  }
  
  private void g()
  {
    AtomicInteger localAtomicInteger = this.n;
    if (localAtomicInteger == null) {
      return;
    }
    if (localAtomicInteger.decrementAndGet() < 0) {
      this.n.set(0);
    }
    new StringBuilder("计数-1 : ").append(this.n.get());
  }
  
  private void h()
  {
    AtomicInteger localAtomicInteger = this.n;
    if (localAtomicInteger == null) {
      return;
    }
    localAtomicInteger.incrementAndGet();
    new StringBuilder("计数+1 : ").append(this.n.get());
  }
  
  private byte[] i()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    byte[] arrayOfByte = new byte[10];
    int i1 = 0;
    while (i1 < 10)
    {
      arrayOfByte[i1] = ((byte)localRandom.nextInt(127));
      i1 += 1;
    }
    return arrayOfByte;
  }
  
  void a()
  {
    this.e.a(10051, new jy(), 1, this.j);
  }
  
  void a(p paramp)
  {
    jt localjt = (jt)paramp.c;
    int i1 = aih.a;
    long l1 = localjt.a;
    l1 = localjt.c;
    a(localjt.d);
    String str = localjt.e;
    str = localjt.b;
    this.e.a(653, localjt, new jx(), 1, paramp);
  }
  
  void b()
  {
    ??? = new StringBuilder("tryCloseConn isKeepConnection : ");
    ((StringBuilder)???).append(this.c);
    ((StringBuilder)???).append(" gameLoginVsPushCount : ");
    ((StringBuilder)???).append(f());
    ((StringBuilder)???).append(" latestGameLoginTimestamp : ");
    ((StringBuilder)???).append(this.o.get());
    ((StringBuilder)???).append(" latestPushInfoTimestamp : ");
    ((StringBuilder)???).append(this.p.get());
    ((StringBuilder)???).append(" qrcodeSet.size() : ");
    ((StringBuilder)???).append(this.s.size());
    synchronized (this.k)
    {
      if ((this.c) && (f() <= 0) && (this.o.get() < this.p.get()) && (this.s.isEmpty())) {
        d();
      }
      return;
    }
  }
  
  void b(p paramp)
  {
    jr localjr = (jr)paramp.c;
    int i1 = aih.a;
    long l1 = localjr.b;
    l1 = localjr.a;
    i1 = localjr.f;
    String str = localjr.c;
    a(localjr.e);
    a(localjr.d);
    this.e.a(654, localjr, new jv(), 1, paramp);
  }
  
  void c()
  {
    ??? = new StringBuilder("tryCloseConn_2 isKeepConnection : ");
    ((StringBuilder)???).append(this.c);
    ((StringBuilder)???).append(" getGameLoginVsPushCount() : ");
    ((StringBuilder)???).append(f());
    ((StringBuilder)???).append(" qrcodeSet.size() : ");
    ((StringBuilder)???).append(this.s.size());
    synchronized (this.k)
    {
      if ((this.c) && (f() <= 0) && (this.s.isEmpty())) {
        d();
      }
      return;
    }
  }
  
  void c(p paramp)
  {
    js localjs = (js)paramp.c;
    int i1 = aih.a;
    long l1 = localjs.b;
    l1 = localjs.a;
    this.e.a(656, localjs, new jw(), 0, paramp);
  }
  
  void d()
  {
    synchronized (this.k)
    {
      this.c = false;
      this.d = false;
      this.e.b();
      this.e.a(10051, 1);
      return;
    }
  }
  
  public boolean init(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    this.u = true;
    return k.a(paramContext, paramInt1, paramString, paramInt2);
  }
  
  public int sendGameConfirm(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.u) {
      return -1;
    }
    if ((paramString != null) && (paramArrayOfByte != null))
    {
      int i1 = e();
      jr localjr = new jr();
      localjr.b = ((Long)this.m.pop()).longValue();
      localjr.a = i1;
      localjr.c = paramString;
      localjr.d = paramArrayOfByte;
      localjr.e = this.q.a();
      localjr.f = j.d(paramInt);
      this.g.a(localjr.a, this.b);
      paramInt = aih.a;
      long l1 = localjr.b;
      l1 = localjr.a;
      paramInt = localjr.f;
      paramString = localjr.c;
      a(localjr.e);
      a(localjr.d);
      new StringBuilder("CSConfirm confirm : ").append(localjr.f);
      new StringBuilder("reqid : ").append(localjr.a);
      new StringBuilder("session : ").append(a(localjr.e));
      this.e.a(654, localjr, new jv(), 1, new g(this, localjr.a, localjr), this.b);
      return i1;
    }
    return -2;
  }
  
  public int sendGameLoginInfo(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!this.u) {
      return -1;
    }
    if ((paramString1 != null) && (paramString2 != null) && (paramArrayOfByte != null))
    {
      if ((!this.c) || (!this.d)) {}
      synchronized (this.k)
      {
        if (!this.c)
        {
          this.c = true;
          this.e.a();
        }
        if (!this.d)
        {
          this.d = true;
          a();
        }
        int i1 = e();
        ??? = new jt();
        ((jt)???).c = this.l;
        ((jt)???).d = paramArrayOfByte;
        ((jt)???).b = paramString1;
        ((jt)???).a = i1;
        paramString1 = a(paramString2);
        if (paramString1 != null)
        {
          ((jt)???).g = aqx.a(paramString1);
          this.t.a(((jt)???).c, ((jt)???).g);
        }
        paramString2 = ((jt)???).g;
        this.s.add(paramString2);
        int i2 = aih.a;
        long l1 = ((jt)???).a;
        l1 = ((jt)???).c;
        a(((jt)???).d);
        paramString1 = ((jt)???).e;
        paramString1 = ((jt)???).b;
        this.g.a(((jt)???).a, this.b);
        new StringBuilder("reqid : ").append(((jt)???).a);
        new StringBuilder("picmd5 : ").append(((jt)???).g);
        paramString1 = aqv.a();
        paramArrayOfByte = ((jt)???).g;
        l1 = this.a;
        Object localObject2 = new e(this, paramString2);
        paramString2 = new StringBuilder("添加闹钟任务 : action : ");
        paramString2.append(paramArrayOfByte);
        paramString2.append("  ");
        paramString2.append(l1 / 1000L);
        paramString2.append("s");
        paramString2 = new b(paramString1);
        paramString1.a.registerReceiver(paramString2, new IntentFilter(paramArrayOfByte));
        paramString2.b = ((Runnable)localObject2);
        paramString2.a = paramArrayOfByte;
        localObject2 = new Intent(paramArrayOfByte);
        localObject2 = PendingIntent.getBroadcast(paramString1.a, 0, (Intent)localObject2, 0);
        AlarmManager localAlarmManager = (AlarmManager)paramString1.a.getSystemService("alarm");
        paramString1.b.put(paramArrayOfByte, paramString2);
        localAlarmManager.set(0, System.currentTimeMillis() + l1, (PendingIntent)localObject2);
        this.e.a(653, (JceStruct)???, new jx(), 1, new h(this, ((jt)???).a, (JceStruct)???), this.b);
        return i1;
      }
    }
    return -2;
  }
  
  public int sendGetFlowType(long paramLong)
  {
    if (!this.u) {
      return -1;
    }
    int i1 = e();
    js localjs = new js();
    localjs.b = paramLong;
    localjs.a = i1;
    new StringBuilder("appid : ").append(localjs.b);
    new StringBuilder("reqid : ").append(localjs.a);
    int i2 = aih.a;
    long l1 = localjs.b;
    l1 = localjs.a;
    this.g.a(localjs.a, this.b);
    this.e.a(656, localjs, new jw(), 0, new i(this, localjs.a, localjs), this.b);
    this.l = paramLong;
    return i1;
  }
  
  public void setNetworkCallback(IGameLoginCallback paramIGameLoginCallback)
  {
    this.f = paramIGameLoginCallback;
  }
  
  public void setRespLimitTime(long paramLong)
  {
    if (paramLong > 0L) {
      this.b = paramLong;
    }
  }
  
  public void setTestServer(boolean paramBoolean)
  {
    Object localObject = (asg)aqr.a(asg.class);
    aso localaso = aso.a();
    if (localaso.b != null) {
      localaso.b.a(paramBoolean);
    }
    localObject = ((asg)localObject).a.c.a;
    ((are)localObject).a = paramBoolean;
    ((are)localObject).b();
    ((are)localObject).a();
  }
  
  public void setWaitPushTime(long paramLong)
  {
    if (paramLong > 0L) {
      this.a = paramLong;
    }
  }
  
  public void testPush(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new f(this, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramString5, paramString6), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.GameLogin
 * JD-Core Version:    0.7.0.1
 */