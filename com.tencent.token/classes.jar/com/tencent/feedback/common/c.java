package com.tencent.feedback.common;

import android.content.Context;
import com.tencent.feedback.proguard.o;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static c E;
  private boolean A = true;
  private String B = null;
  private List<o> C;
  private Boolean D = null;
  private final long F;
  private int G = -1;
  private int H = -1;
  private Map<String, String> I = new HashMap();
  private Map<String, String> J = new HashMap();
  private final Context a;
  private final byte b;
  private String c;
  private String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private String j = "10000";
  private String k = "unknown";
  private long l = 0L;
  private String m = "";
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  private String t = null;
  private long u = -1L;
  private long v = -1L;
  private long w = -1L;
  private String x = null;
  private String y = null;
  private Map<String, PlugInInfo> z = null;
  
  private c(Context paramContext)
  {
    e.b("rqdp{  init cominfo}", new Object[0]);
    Context localContext1;
    if (paramContext != null)
    {
      Context localContext2 = paramContext.getApplicationContext();
      localContext1 = localContext2;
      if (localContext2 != null) {}
    }
    else
    {
      localContext1 = paramContext;
    }
    this.a = localContext1;
    d.a(this.a);
    this.b = 1;
    this.c = a.b(paramContext);
    this.d = a.c(paramContext);
    this.e = "1.9.9";
    this.f = d.l();
    this.g = d.a();
    paramContext = new StringBuilder("Android ");
    paramContext.append(d.b());
    paramContext.append(",level ");
    paramContext.append(d.c());
    this.h = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(this.g);
    paramContext.append(";");
    paramContext.append(this.h);
    this.F = new Date().getTime();
    this.i = a.i(this.a);
  }
  
  private boolean O()
  {
    try
    {
      boolean bool = this.A;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (E == null) {
        E = new c(paramContext);
      }
      paramContext = E;
      return paramContext;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.A = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<o> A()
  {
    try
    {
      List localList = this.C;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String B()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean C()
  {
    try
    {
      if (this.D == null) {
        this.D = Boolean.valueOf(h.a(this.a).a());
      }
      boolean bool = this.D.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public final long D()
  {
    return this.F;
  }
  
  public final String E()
  {
    return this.i;
  }
  
  public final int F()
  {
    try
    {
      int i1 = this.G;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int G()
  {
    try
    {
      int i1 = this.H;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<String, String> H()
  {
    try
    {
      int i1 = this.I.size();
      if (i1 <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.I);
      return localHashMap;
    }
    finally {}
  }
  
  public final int I()
  {
    try
    {
      int i1 = this.I.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Set<String> J()
  {
    try
    {
      Set localSet = this.I.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<String, String> K()
  {
    try
    {
      int i1 = this.J.size();
      if (i1 <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.J);
      return localHashMap;
    }
    finally {}
  }
  
  public final int L()
  {
    try
    {
      int i1 = this.J.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Set<String> M()
  {
    try
    {
      Set localSet = this.J.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean N()
  {
    try
    {
      boolean bool = a.j(this.a);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte a()
  {
    return 1;
  }
  
  public final void a(int paramInt)
  {
    try
    {
      int i1 = this.G;
      if (i1 != paramInt)
      {
        this.G = paramInt;
        e.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.G) });
      }
      return;
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.l = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString != null) {
      try
      {
        if ((paramString.trim().length() != 0) && (!paramString.equals("10000")))
        {
          this.j = paramString;
          return;
        }
      }
      finally {}
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (paramString1.trim().length() <= 0) {
          break label95;
        }
        i1 = 0;
        if (i1 == 0)
        {
          if ((paramString2 == null) || (paramString2.trim().length() <= 0)) {
            break label100;
          }
          i1 = 0;
          break label102;
          this.I.put(paramString1, paramString2);
          return;
        }
        e.c("key&value should not be empty %s %s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
        return;
      }
      finally
      {
        continue;
      }
      throw paramString1;
      label95:
      int i1 = 1;
      continue;
      label100:
      i1 = 1;
      label102:
      if (i1 == 0) {}
    }
  }
  
  public final void a(List<o> paramList)
  {
    try
    {
      this.C = paramList;
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.D = Boolean.valueOf(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        if (this.z == null) {
          this.z = new HashMap();
        }
        this.z.put(paramString1, new PlugInInfo(paramString1, paramString2, paramString3));
        e.a("add %s %s %s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2), String.valueOf(paramString3) });
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final String b()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.m = String.valueOf(paramString);
      if (paramString != null) {
        b(false);
      }
      return;
    }
    finally {}
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.k = String.valueOf(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.p = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.q = paramString;
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
    return this.h;
  }
  
  public final void f(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (this.z != null)
        {
          this.z.remove(paramString);
          return;
        }
      }
      finally {}
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void g(String paramString)
  {
    this.B = String.valueOf(paramString);
  }
  
  public final String h()
  {
    try
    {
      if ((this.m != null) && (this.m.length() != 0))
      {
        str = this.m;
        return str;
      }
      String str = o();
      return str;
    }
    finally {}
  }
  
  public final void h(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.k;
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
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final long j()
  {
    try
    {
      long l1 = this.l;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String j(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.trim().length() <= 0) {
          break label73;
        }
        i1 = 0;
        if (i1 != 0)
        {
          e.c("key should not be empty %s", new Object[] { String.valueOf(paramString) });
          return null;
        }
        paramString = (String)this.I.remove(paramString);
        return paramString;
      }
      finally
      {
        continue;
      }
      throw paramString;
      label73:
      int i1 = 1;
    }
  }
  
  public final String k()
  {
    try
    {
      if (this.n == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a.d(this.a));
        this.n = ((StringBuilder)localObject1).toString();
      }
      Object localObject1 = this.n;
      return localObject1;
    }
    finally {}
  }
  
  public final String k(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.trim().length() <= 0) {
          break label73;
        }
        i1 = 0;
        if (i1 != 0)
        {
          e.c("key should not be empty %s", new Object[] { String.valueOf(paramString) });
          return null;
        }
        paramString = (String)this.I.get(paramString);
        return paramString;
      }
      finally
      {
        continue;
      }
      throw paramString;
      label73:
      int i1 = 1;
    }
  }
  
  public final String l()
  {
    try
    {
      if (this.p == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a.h(this.a));
        this.p = ((StringBuilder)localObject1).toString();
      }
      Object localObject1 = this.p;
      return localObject1;
    }
    finally {}
  }
  
  public final String l(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.trim().length() <= 0) {
          break label73;
        }
        i1 = 0;
        if (i1 != 0)
        {
          e.c("key should not be empty %s", new Object[] { String.valueOf(paramString) });
          return null;
        }
        paramString = (String)this.J.get(paramString);
        return paramString;
      }
      finally
      {
        continue;
      }
      throw paramString;
      label73:
      int i1 = 1;
    }
  }
  
  /* Error */
  public final boolean m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/tencent/feedback/common/c:p	Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	c
    //   12	7	1	bool	boolean
    //   6	2	2	str	String
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final String n()
  {
    try
    {
      if (this.q == null)
      {
        this.q = a.a(this.a);
        if ((this.q == null) || (this.q.equals(""))) {
          this.q = this.c;
        }
      }
      String str = this.q;
      return str;
    }
    finally {}
  }
  
  public final String o()
  {
    try
    {
      if (!O()) {
        return "";
      }
      if (this.o == null)
      {
        d.a(this.a);
        this.o = d.b(this.a);
      }
      String str = this.o;
      return str;
    }
    finally {}
  }
  
  public final String p()
  {
    try
    {
      if (!O()) {
        return "";
      }
      if (this.r == null)
      {
        d.a(this.a);
        this.r = d.e(this.a);
      }
      String str = this.r;
      return str;
    }
    finally {}
  }
  
  public final String q()
  {
    try
    {
      if (!O()) {
        return "";
      }
      if (this.s == null)
      {
        d.a(this.a);
        this.s = d.c(this.a);
      }
      String str = this.s;
      return str;
    }
    finally {}
  }
  
  public final String r()
  {
    try
    {
      if (!O()) {
        return "";
      }
      if (this.t == null)
      {
        d.a(this.a);
        this.t = d.d(this.a);
      }
      String str = this.t;
      return str;
    }
    finally {}
  }
  
  public final long s()
  {
    try
    {
      if (this.u <= 0L)
      {
        d.a(this.a);
        this.u = d.e();
      }
      long l1 = this.u;
      return l1;
    }
    finally {}
  }
  
  public final long t()
  {
    try
    {
      if (this.v <= 0L)
      {
        d.a(this.a);
        this.v = d.g();
      }
      long l1 = this.v;
      return l1;
    }
    finally {}
  }
  
  public final long u()
  {
    try
    {
      if (this.w <= 0L) {
        this.w = d.a(this.a).i();
      }
      long l1 = this.w;
      return l1;
    }
    finally {}
  }
  
  public final String v()
  {
    try
    {
      if (this.x == null)
      {
        d.a(this.a);
        this.x = d.d();
      }
      String str = this.x;
      return str;
    }
    finally {}
  }
  
  public final String w()
  {
    try
    {
      if (this.y == null) {
        this.y = d.a(this.a).m();
      }
      String str = this.y;
      return str;
    }
    finally {}
  }
  
  public final Map<String, PlugInInfo> x()
  {
    try
    {
      Map localMap = this.z;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<String, PlugInInfo> y()
  {
    try
    {
      if ((this.z != null) && (this.z.size() > 0))
      {
        HashMap localHashMap = new HashMap(this.z.size());
        localHashMap.putAll(this.z);
        return localHashMap;
      }
      return null;
    }
    finally {}
  }
  
  public final String z()
  {
    if (this.B == null)
    {
      d.a(this.a);
      this.B = d.k();
    }
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.c
 * JD-Core Version:    0.7.0.1
 */