package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class a
{
  private static a ab = null;
  public boolean A = false;
  public boolean B = false;
  public List<String> C = new ArrayList();
  public boolean D;
  public com.tencent.bugly.crashreport.a E = null;
  public SharedPreferences F;
  private final Context G;
  private String H;
  private String I;
  private String J;
  private String K = "unknown";
  private String L = "";
  private String M = null;
  private long N = -1L;
  private long O = -1L;
  private long P = -1L;
  private String Q = null;
  private String R = null;
  private String S = null;
  private Map<String, PlugInBean> T = null;
  private boolean U = false;
  private String V = null;
  private String W = null;
  private Boolean X = null;
  private String Y = null;
  private Map<String, PlugInBean> Z = null;
  public final long a = System.currentTimeMillis();
  private Map<String, PlugInBean> aa = null;
  private int ac = -1;
  private int ad = -1;
  private Map<String, String> ae = new HashMap();
  private Map<String, String> af = new HashMap();
  private Map<String, String> ag = new HashMap();
  private Boolean ah = null;
  private Boolean ai = null;
  private HashMap<String, String> aj = new HashMap();
  private final Object ak = new Object();
  private final Object al = new Object();
  private final Object am = new Object();
  private final Object an = new Object();
  private final Object ao = new Object();
  private final Object ap = new Object();
  private final Object aq = new Object();
  private int ar = 0;
  public final byte b;
  public String c;
  public final String d;
  public String e;
  public boolean f = true;
  public String g = "3.4.5";
  public final String h;
  public final String i;
  public String j;
  public long k;
  public String l = null;
  public String m = null;
  public String n = null;
  public String o = null;
  public String p = null;
  public List<String> q = null;
  public String r = "unknown";
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public String w = null;
  public String x = null;
  public String y = null;
  public String z = "";
  
  private a(Context paramContext)
  {
    this.G = z.a(paramContext);
    this.b = 1;
    Object localObject = AppInfo.b(paramContext);
    if (localObject != null) {}
    try
    {
      this.l = ((PackageInfo)localObject).versionName;
      this.w = this.l;
      this.x = Integer.toString(((PackageInfo)localObject).versionCode);
      this.c = AppInfo.a(paramContext);
      this.d = AppInfo.a(Process.myPid());
      this.h = b.k();
      this.m = AppInfo.c(paramContext);
      this.i = ("Android " + b.b() + ",level " + b.c());
      new StringBuilder().append(this.I).append(";").append(this.i).toString();
      localObject = AppInfo.d(paramContext);
      if (localObject == null) {}
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.q = AppInfo.a((Map)localObject);
        String str = (String)((Map)localObject).get("BUGLY_APPID");
        if (str != null)
        {
          this.W = str;
          c("APP_ID", this.W);
        }
        str = (String)((Map)localObject).get("BUGLY_APP_VERSION");
        if (str != null) {
          this.l = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_CHANNEL");
        if (str != null) {
          this.n = str;
        }
        str = (String)((Map)localObject).get("BUGLY_ENABLE_DEBUG");
        if (str != null) {
          str.equalsIgnoreCase("true");
        }
        str = (String)((Map)localObject).get("com.tencent.rdm.uuid");
        if (str != null) {
          this.y = str;
        }
        str = (String)((Map)localObject).get("BUGLY_APP_BUILD_NO");
        if (!TextUtils.isEmpty(str)) {
          Integer.parseInt(str);
        }
        localObject = (String)((Map)localObject).get("BUGLY_AREA");
        if (localObject != null) {
          this.z = ((String)localObject);
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            if (!paramContext.getDatabasePath("bugly_db_").exists())
            {
              this.B = true;
              x.c("App is first time to be installed on the device.", new Object[0]);
            }
            this.F = z.a("BUGLY_COMMON_VALUES", paramContext);
            this.R = b.a(paramContext);
            x.c("com info create end", new Object[0]);
            return;
            localThrowable1 = localThrowable1;
            if (!x.a(localThrowable1))
            {
              localThrowable1.printStackTrace();
              continue;
              localThrowable2 = localThrowable2;
              if (!x.a(localThrowable2)) {
                localThrowable2.printStackTrace();
              }
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            if (com.tencent.bugly.b.c) {
              localThrowable3.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static int C()
  {
    return b.c();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (ab == null) {
        ab = new a(paramContext);
      }
      paramContext = ab;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = ab;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("server key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.an)
    {
      this.ag.put(paramString1, paramString2);
      return;
    }
  }
  
  public final int A()
  {
    return this.ad;
  }
  
  public final Map<String, PlugInBean> B()
  {
    try
    {
      Map localMap = this.Z;
      if (this.aa != null) {
        localMap.putAll(this.aa);
      }
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean D()
  {
    if (this.ah == null)
    {
      this.ah = Boolean.valueOf(b.e(this.G));
      x.a("Is it a virtual machine? " + this.ah, new Object[0]);
    }
    return this.ah.booleanValue();
  }
  
  public final boolean E()
  {
    if (this.ai == null)
    {
      this.ai = Boolean.valueOf(b.f(this.G));
      x.a("Does it has hook frame? " + this.ai, new Object[0]);
    }
    return this.ai.booleanValue();
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.ao)
    {
      int i1 = this.ac;
      if (i1 != paramInt)
      {
        this.ac = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.ac) });
      }
      return;
    }
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public final void a(String paramString)
  {
    this.W = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.am)
    {
      this.ae.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void a(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.Z = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    com.tencent.bugly.crashreport.a locala;
    if (paramBoolean)
    {
      this.ar += 1;
      if (this.E != null)
      {
        locala = this.E;
        if (this.ar <= 0) {
          break label57;
        }
      }
    }
    label57:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.setNativeIsAppForeground(paramBoolean);
      return;
      this.ar -= 1;
      break;
    }
  }
  
  public final boolean a()
  {
    return this.ar > 0;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (this.T == null) {
          this.T = new HashMap();
        }
        this.T.put(paramString1, new PlugInBean(paramString1, paramString2, paramString3));
        x.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.ap;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.K = str;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((z.a(paramString1)) || (z.a(paramString2)))
    {
      x.d("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
      return;
    }
    synchronized (this.aq)
    {
      this.af.put(paramString1, paramString2);
      return;
    }
  }
  
  public final void b(Map<String, PlugInBean> paramMap)
  {
    try
    {
      this.aa = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public final void c()
  {
    synchronized (this.ak)
    {
      this.H = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.J = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      z.b("deviceId", paramString);
    }
    synchronized (this.aq)
    {
      this.af.put("E8", paramString);
      return;
    }
  }
  
  public final String d()
  {
    synchronized (this.ak)
    {
      if (this.H == null) {}
      synchronized (this.ak)
      {
        this.H = UUID.randomUUID().toString();
        ??? = this.H;
        return ???;
      }
    }
  }
  
  public final void d(String paramString)
  {
    x.a("change deviceModel，old:%s new:%s", new Object[] { this.I, paramString });
    this.I = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      z.b("deviceModel", paramString);
    }
  }
  
  public final String e()
  {
    if (!z.a(this.e)) {
      return this.e;
    }
    return this.W;
  }
  
  public final void e(String paramString)
  {
    try
    {
      new StringBuilder().append(paramString).toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String f()
  {
    synchronized (this.ap)
    {
      String str = this.K;
      return str;
    }
  }
  
  public final void f(String paramString)
  {
    try
    {
      this.L = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String g()
  {
    Object localObject = null;
    if (this.J != null) {
      return this.J;
    }
    this.J = z.c("deviceId", null);
    if (this.J != null) {
      return this.J;
    }
    if (TextUtils.isEmpty(this.M)) {
      this.M = z.c("androidid", null);
    }
    if (TextUtils.isEmpty(this.M)) {}
    for (;;)
    {
      this.J = ((String)localObject);
      if (TextUtils.isEmpty(this.J))
      {
        String str = UUID.randomUUID().toString();
        localObject = str;
        if (!z.a(str)) {
          localObject = str.replaceAll("-", "");
        }
        this.J = ((String)localObject);
      }
      if (this.J == null) {
        break;
      }
      z.b("deviceId", this.J);
      return this.J;
      localObject = this.M;
    }
    return "";
  }
  
  public final void g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.Q = paramString.trim();
    }
  }
  
  public final String h()
  {
    if (this.I != null) {
      return this.I;
    }
    this.I = z.c("deviceModel", null);
    if (this.I != null) {
      return this.I;
    }
    this.I = b.a();
    z.b("deviceModel", this.I);
    return this.I;
  }
  
  /* Error */
  public final void h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 512 2 0
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	a
    //   0	37	1	paramString	String
    //   10	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   6	11	32	finally
    //   18	29	32	finally
  }
  
  public final String i()
  {
    try
    {
      String str = this.L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void i(String paramString)
  {
    this.V = paramString;
  }
  
  public final long j()
  {
    if (this.N <= 0L) {
      this.N = b.d();
    }
    return this.N;
  }
  
  public final String j(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.am)
    {
      paramString = (String)this.ae.remove(paramString);
      return paramString;
    }
  }
  
  public final long k()
  {
    if (this.O <= 0L) {
      this.O = b.f();
    }
    return this.O;
  }
  
  public final String k(String paramString)
  {
    if (z.a(paramString))
    {
      x.d("key should not be empty %s", new Object[] { paramString });
      return null;
    }
    synchronized (this.am)
    {
      paramString = (String)this.ae.get(paramString);
      return paramString;
    }
  }
  
  public final long l()
  {
    if (this.P <= 0L) {
      this.P = b.h();
    }
    return this.P;
  }
  
  public final String m()
  {
    if (!TextUtils.isEmpty(this.Q))
    {
      x.c("get cpu type from so:%s", new Object[] { this.Q });
      return this.Q;
    }
    if (!TextUtils.isEmpty(this.R))
    {
      x.c("get cpu type from lib dir:%s", new Object[] { this.R });
      return this.R;
    }
    return "unknown";
  }
  
  public final String n()
  {
    if (this.S == null) {
      this.S = b.d(this.G);
    }
    return this.S;
  }
  
  public final String o()
  {
    try
    {
      Object localObject2 = this.G.getSharedPreferences("BuglySdkInfos", 0).getAll();
      if (!((Map)localObject2).isEmpty()) {
        synchronized (this.al)
        {
          localObject2 = ((Map)localObject2).entrySet().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry1 = (Map.Entry)((Iterator)localObject2).next();
              try
              {
                this.aj.put(localEntry1.getKey(), localEntry1.getValue().toString());
              }
              catch (Throwable localThrowable2)
              {
                x.a(localThrowable2);
              }
            }
          }
        }
      }
      StringBuilder localStringBuilder;
      Iterator localIterator;
      Map.Entry localEntry2;
      return null;
    }
    catch (Throwable localThrowable1)
    {
      x.a(localThrowable1);
      while (!this.aj.isEmpty())
      {
        localStringBuilder = new StringBuilder();
        localIterator = this.aj.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localEntry2 = (Map.Entry)localIterator.next();
            localStringBuilder.append("[");
            localStringBuilder.append((String)localEntry2.getKey());
            localStringBuilder.append(",");
            localStringBuilder.append((String)localEntry2.getValue());
            localStringBuilder.append("] ");
            continue;
            break;
          }
        }
        x.c("SDK_INFO = %s", new Object[] { localStringBuilder.toString() });
        c("SDK_INFO", localStringBuilder.toString());
        return localStringBuilder.toString();
      }
      x.c("SDK_INFO is empty", new Object[0]);
    }
  }
  
  /* Error */
  public final Map<String, PlugInBean> p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   13: invokeinterface 586 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 163	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   37: invokeinterface 586 1 0
    //   42: invokespecial 588	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 131	com/tencent/bugly/crashreport/common/info/a:T	Ljava/util/Map;
    //   51: invokeinterface 419 2 0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   18	2	1	i1	int
    //   24	23	2	localObject1	Object
    //   59	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	59	finally
    //   29	56	59	finally
  }
  
  public final String q()
  {
    if (this.V == null) {
      this.V = b.j();
    }
    return this.V;
  }
  
  public final Boolean r()
  {
    if (this.X == null) {
      this.X = Boolean.valueOf(b.l());
    }
    return this.X;
  }
  
  public final String s()
  {
    if (this.Y == null)
    {
      this.Y = b.c(this.G);
      x.a("ROM ID: %s", new Object[] { this.Y });
    }
    return this.Y;
  }
  
  public final Map<String, String> t()
  {
    synchronized (this.am)
    {
      if (this.ae.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ae);
      return localHashMap;
    }
  }
  
  public final void u()
  {
    synchronized (this.am)
    {
      this.ae.clear();
      return;
    }
  }
  
  public final int v()
  {
    synchronized (this.am)
    {
      int i1 = this.ae.size();
      return i1;
    }
  }
  
  public final Set<String> w()
  {
    synchronized (this.am)
    {
      Set localSet = this.ae.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> x()
  {
    synchronized (this.aq)
    {
      if (this.af.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.af);
      return localHashMap;
    }
  }
  
  public final Map<String, String> y()
  {
    synchronized (this.an)
    {
      if (this.ag.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ag);
      return localHashMap;
    }
  }
  
  public final int z()
  {
    synchronized (this.ao)
    {
      int i1 = this.ac;
      return i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.a
 * JD-Core Version:    0.7.0.1
 */