package gameloginsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.fm;
import com.tencent.token.fo;
import com.tencent.token.fr;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tmsdk.common.c.a.d;
import tmsdk.common.d.a.b.r;

public class GameLogin
{
  public static final int GAME_LOGIN_SDK_VERSION = 1;
  public static final String TAG = "GameLogin";
  long a = 1800000L;
  long b = 10000L;
  boolean c = false;
  boolean d = false;
  fr e = null;
  IGameLoginCallback f;
  o g = new o();
  AtomicInteger h = new AtomicInteger();
  Handler i = new Handler(Looper.getMainLooper());
  fo j = new c(this);
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
    switch (tmsdk.common.d.a.a.a.filterNetworkCode(paramInt))
    {
    default: 
      return "未知错误";
    case 0: 
      return "";
    case -10: 
    case -9: 
    case -5: 
    case -4: 
    case -3: 
    case -2: 
    case -1: 
      return "网络错误，请检查网络";
    case -8: 
    case -7: 
      return "服务器繁忙，请稍后重试";
    }
    return "需要wifi验证，请先进行wifi验证";
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
    if ((paramString == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest == null) {
          continue;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        try
        {
          MessageDigest localMessageDigest;
          localMessageDigest.update(paramString.getBytes("UTF-8"));
          label35:
          return localMessageDigest.digest();
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          Object localObject = null;
        }
        catch (UnsupportedEncodingException paramString)
        {
          break label35;
        }
      }
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
    new StringBuilder().append("获取计数 : ").append(this.n.get()).toString();
    return this.n.get();
  }
  
  private void g()
  {
    if (this.n == null) {
      return;
    }
    if (this.n.decrementAndGet() < 0) {
      this.n.set(0);
    }
    new StringBuilder().append("计数-1 : ").append(this.n.get()).toString();
  }
  
  private void h()
  {
    if (this.n == null) {
      return;
    }
    this.n.incrementAndGet();
    new StringBuilder().append("计数+1 : ").append(this.n.get()).toString();
  }
  
  private byte[] i()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    byte[] arrayOfByte = new byte[10];
    int i1 = 0;
    while (i1 < arrayOfByte.length)
    {
      arrayOfByte[i1] = ((byte)localRandom.nextInt(127));
      i1 += 1;
    }
    return arrayOfByte;
  }
  
  void a()
  {
    this.e.a(10051, new b.a.h(), 1, this.j);
  }
  
  void a(p paramp)
  {
    b.a.c localc = (b.a.c)paramp.c;
    int i1 = fm.a;
    long l1 = localc.a;
    l1 = localc.c;
    a(localc.d);
    String str = localc.e;
    str = localc.b;
    this.e.a(653, localc, new b.a.g(), 1, paramp);
  }
  
  void b()
  {
    new StringBuilder().append("tryCloseConn isKeepConnection : ").append(this.c).append(" gameLoginVsPushCount : ").append(f()).append(" latestGameLoginTimestamp : ").append(this.o.get()).append(" latestPushInfoTimestamp : ").append(this.p.get()).append(" qrcodeSet.size() : ").append(this.s.size()).toString();
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
    b.a.a locala = (b.a.a)paramp.c;
    int i1 = fm.a;
    long l1 = locala.b;
    l1 = locala.a;
    i1 = locala.f;
    String str = locala.c;
    a(locala.e);
    a(locala.d);
    this.e.a(654, locala, new b.a.e(), 1, paramp);
  }
  
  void c()
  {
    new StringBuilder().append("tryCloseConn_2 isKeepConnection : ").append(this.c).append(" getGameLoginVsPushCount() : ").append(f()).append(" qrcodeSet.size() : ").append(this.s.size()).toString();
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
    b.a.b localb = (b.a.b)paramp.c;
    int i1 = fm.a;
    long l1 = localb.b;
    l1 = localb.a;
    this.e.a(656, localb, new b.a.f(), 0, paramp);
  }
  
  void d()
  {
    synchronized (this.k)
    {
      this.c = false;
      this.d = false;
      this.e.b(1);
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
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return -2;
    }
    int i1 = e();
    b.a.a locala = new b.a.a();
    locala.b = ((Long)this.m.pop()).longValue();
    locala.a = i1;
    locala.c = paramString;
    locala.d = paramArrayOfByte;
    locala.e = this.q.a();
    locala.f = j.d(paramInt);
    this.g.a(locala.a, this.b);
    paramInt = fm.a;
    long l1 = locala.b;
    l1 = locala.a;
    paramInt = locala.f;
    paramString = locala.c;
    a(locala.e);
    a(locala.d);
    new StringBuilder().append("CSConfirm confirm : ").append(locala.f).toString();
    new StringBuilder().append("reqid : ").append(locala.a).toString();
    new StringBuilder().append("session : ").append(a(locala.e)).toString();
    this.e.a(654, locala, new b.a.e(), 1, new g(this, locala.a, locala), this.b);
    return i1;
  }
  
  public int sendGameLoginInfo(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!this.u) {
      return -1;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramArrayOfByte == null)) {
      return -2;
    }
    if ((!this.c) || (!this.d)) {}
    synchronized (this.k)
    {
      if (!this.c)
      {
        this.c = true;
        this.e.a(5);
      }
      if (!this.d)
      {
        this.d = true;
        a();
      }
      int i1 = e();
      ??? = new b.a.c();
      ((b.a.c)???).c = this.l;
      ((b.a.c)???).d = paramArrayOfByte;
      ((b.a.c)???).b = paramString1;
      ((b.a.c)???).a = i1;
      paramString1 = a(paramString2);
      if (paramString1 != null)
      {
        ((b.a.c)???).g = d.a(paramString1);
        this.t.a(((b.a.c)???).c, ((b.a.c)???).g);
      }
      paramString1 = ((b.a.c)???).g;
      this.s.add(paramString1);
      int i2 = fm.a;
      long l1 = ((b.a.c)???).a;
      l1 = ((b.a.c)???).c;
      a(((b.a.c)???).d);
      paramArrayOfByte = ((b.a.c)???).e;
      paramArrayOfByte = ((b.a.c)???).b;
      this.g.a(((b.a.c)???).a, this.b);
      new StringBuilder().append("reqid : ").append(((b.a.c)???).a).toString();
      new StringBuilder().append("picmd5 : ").append(((b.a.c)???).g).toString();
      tmsdk.common.c.a.a.a().a(((b.a.c)???).g, this.a, new e(this, paramString1));
      this.e.a(653, (JceStruct)???, new b.a.g(), 1, new h(this, ((b.a.c)???).a, (JceStruct)???), this.b);
      return i1;
    }
  }
  
  public int sendGetFlowType(long paramLong)
  {
    if (!this.u) {
      return -1;
    }
    int i1 = e();
    b.a.b localb = new b.a.b();
    localb.b = paramLong;
    localb.a = i1;
    new StringBuilder().append("appid : ").append(localb.b).toString();
    new StringBuilder().append("reqid : ").append(localb.a).toString();
    int i2 = fm.a;
    long l1 = localb.b;
    l1 = localb.a;
    this.g.a(localb.a, this.b);
    this.e.a(656, localb, new b.a.f(), 0, new i(this, localb.a, localb), this.b);
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
    ((r)tmsdk.common.a.b.a(r.class)).a(paramBoolean);
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