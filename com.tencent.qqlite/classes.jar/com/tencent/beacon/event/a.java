package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
  implements h
{
  private Context a;
  private boolean b = false;
  private List<i> c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      a.this.a();
    }
  };
  private Runnable e = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.d.a.f(" maxN to up", new Object[0]);
      try
      {
        n.g();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  };
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = new ArrayList(25);
  }
  
  public static i a(Context paramContext, String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    if (paramString == null) {
      return null;
    }
    com.tencent.beacon.a.e locale = com.tencent.beacon.a.e.m();
    if (locale == null)
    {
      com.tencent.beacon.d.a.d("  CommonInfo have not been Created return null!", new Object[0]);
      return null;
    }
    String str1 = UserAction.getUserID();
    long l1 = locale.h();
    long l2 = new Date().getTime();
    String str2 = locale.g();
    Object localObject2 = com.tencent.beacon.d.b.c(paramContext);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    if (UserAction.a != null) {
      ((Map)localObject2).putAll(UserAction.a);
    }
    if (paramMap != null) {
      ((Map)localObject2).putAll(paramMap);
    }
    ((Map)localObject2).put("A1", str1);
    ((Map)localObject2).put("QQ", UserAction.getQQ());
    ((Map)localObject2).put("A19", (String)localObject1);
    ((Map)localObject2).put("A28", str2);
    ((Map)localObject2).put("A25", paramBoolean);
    ((Map)localObject2).put("A26", paramLong1);
    ((Map)localObject2).put("A27", paramLong2);
    ((Map)localObject2).put("A2", locale.i());
    paramMap = d.a(paramContext);
    ((Map)localObject2).put("A4", paramMap.b());
    ((Map)localObject2).put("A6", paramMap.a());
    ((Map)localObject2).put("A7", paramMap.c());
    ((Map)localObject2).put("A3", com.tencent.beacon.b.a.a(paramContext).a());
    ((Map)localObject2).put("A23", paramMap.d());
    ((Map)localObject2).put("A67", com.tencent.beacon.a.a.i(paramContext));
    ((Map)localObject2).put("A76", com.tencent.beacon.a.a.a());
    paramContext = new i();
    paramContext.b(paramString);
    paramContext.b(l1 + l2);
    paramContext.a("UA");
    paramContext.a((Map)localObject2);
    paramContext.c(1L);
    int i = 0;
    if (paramLong1 >= 1200000L) {
      i = 1;
    }
    int j = i;
    if (paramLong2 >= 50000000L) {
      j = i + 1;
    }
    if (j > 0)
    {
      paramContext.d(j);
      paramContext.b(true);
      return paramContext;
    }
    paramContext.d(0L);
    paramContext.b(false);
    return paramContext;
  }
  
  public static com.tencent.beacon.c.d.b b(i parami)
  {
    if ((parami == null) || (!"IP".equals(parami.b()))) {
      return null;
    }
    Map localMap = parami.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.b localb = new com.tencent.beacon.c.d.b();
      localb.a = ((String)localMap.get("A19"));
      String str = (String)localMap.get("A26");
      Object localObject = str;
      if (str == null) {
        localObject = "-1";
      }
      localb.e = Long.parseLong((String)localObject);
      localObject = parami.d().split(":");
      localb.c = localObject[0];
      localb.d = Integer.parseInt(localObject[1]);
      localb.b = ((String)localMap.get("A28"));
      localb.f = parami.c();
      parami = new HashMap();
      parami.put("A33", localMap.get("A33"));
      parami.put("A3", localMap.get("A3"));
      parami.put("A20", localMap.get("A20"));
      parami.put("A74", localMap.get("A74"));
      if (localMap.get("test") != null) {
        parami.put("test", "Y");
      }
      localb.g = g.a(parami);
      return localb;
    }
    catch (Throwable parami)
    {
      parami.printStackTrace();
      com.tencent.beacon.d.a.d(parami.getMessage(), new Object[0]);
    }
    return null;
  }
  
  /* Error */
  private List<i> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   13: invokeinterface 296 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 299	com/tencent/beacon/event/a:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 39	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 300	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   49: invokeinterface 304 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   59: invokeinterface 307 1 0
    //   64: new 101	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 309
    //   71: invokespecial 311	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokeinterface 296 1 0
    //   80: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 316	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -61 -> 32
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   25	2	1	bool	boolean
    //   31	44	2	localObject1	Object
    //   96	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	96	finally
    //   36	93	96	finally
  }
  
  public static com.tencent.beacon.c.d.a c(i parami)
  {
    if ((parami == null) || (!"DN".equals(parami.b()))) {
      return null;
    }
    Map localMap = parami.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.a locala = new com.tencent.beacon.c.d.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = parami.d();
      locala.j = ((String)localMap.get("A34"));
      locala.d = Long.parseLong((String)localMap.get("A35"));
      locala.f = Long.parseLong((String)localMap.get("A36"));
      locala.g = Long.parseLong((String)localMap.get("A37"));
      locala.h = Long.parseLong((String)localMap.get("A38"));
      locala.b = ((String)localMap.get("A28"));
      locala.i = ((String)localMap.get("A39"));
      locala.e = Long.parseLong((String)localMap.get("A40"));
      locala.k = parami.c();
      parami = new HashMap();
      parami.put("A33", localMap.get("A33"));
      parami.put("A3", localMap.get("A3"));
      parami.put("A20", localMap.get("A20"));
      parami.put("A74", localMap.get("A74"));
      if (localMap.get("test") != null) {
        parami.put("test", "Y");
      }
      locala.l = g.a(parami);
      return locala;
    }
    catch (Throwable parami)
    {
      parami.printStackTrace();
      com.tencent.beacon.d.a.d(parami.getMessage(), new Object[0]);
    }
    return null;
  }
  
  private boolean c()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.beacon.c.d.d d(i parami)
  {
    if ((parami == null) || (!"HO".equals(parami.b()))) {
      return null;
    }
    Map localMap = parami.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.d locald = new com.tencent.beacon.c.d.d();
      locald.a = ((String)localMap.get("A19"));
      String[] arrayOfString = ((String)localMap.get("hostip")).split(":");
      locald.m = Integer.parseInt(arrayOfString[1]);
      locald.b = ((String)localMap.get("A28"));
      locald.c = ((String)localMap.get("A34"));
      locald.k = arrayOfString[0];
      locald.l = parami.d();
      locald.d = Long.parseLong((String)localMap.get("A35"));
      locald.e = Long.parseLong((String)localMap.get("A40"));
      locald.f = Long.parseLong((String)localMap.get("A36"));
      locald.g = Long.parseLong((String)localMap.get("A37"));
      locald.h = Long.parseLong((String)localMap.get("A38"));
      locald.j = parami.c();
      locald.i = ((String)localMap.get("A39"));
      parami = new HashMap();
      parami.put("A33", localMap.get("A33"));
      parami.put("A3", localMap.get("A3"));
      parami.put("A20", localMap.get("A20"));
      parami.put("A74", localMap.get("A74"));
      locald.n = g.a(parami);
      return locald;
    }
    catch (Throwable parami)
    {
      parami.printStackTrace();
      com.tencent.beacon.d.a.d(parami.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static com.tencent.beacon.c.b.a e(i parami)
  {
    if ((parami == null) || (!"UA".equals(parami.b()))) {
      return null;
    }
    Map localMap = parami.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.b.a locala = new com.tencent.beacon.c.b.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = parami.d();
      locala.h = parami.c();
      locala.b = ((String)localMap.get("A28"));
      locala.f = Long.parseLong((String)localMap.get("A26"));
      locala.d = Boolean.parseBoolean((String)localMap.get("A25"));
      locala.e = Long.parseLong((String)localMap.get("A27"));
      if (parami.h()) {
        localMap.put("C9", parami.i());
      }
      if (parami.f()) {
        localMap.put("C3", parami.g());
      }
      locala.g = g.a(localMap);
      if (parami.f()) {}
      for (int i = 1;; i = 0)
      {
        locala.i = i;
        com.tencent.beacon.d.a.b("new event record:\neventName:%s\neventResult:%b\neventValue:%s", new Object[] { locala.c, Boolean.valueOf(locala.d), locala.g });
        return locala;
      }
      return null;
    }
    catch (Throwable parami)
    {
      parami.printStackTrace();
      com.tencent.beacon.d.a.d(parami.getMessage(), new Object[0]);
    }
  }
  
  protected final void a()
  {
    if (!c()) {
      com.tencent.beacon.d.a.c(" err su 1R", new Object[0]);
    }
    Object localObject;
    com.tencent.beacon.upload.h localh;
    do
    {
      do
      {
        return;
        localObject = b();
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      localObject = g.a(this.a, (List)localObject);
      localh = com.tencent.beacon.upload.h.a(this.a);
    } while (localObject == null);
    long l2 = n.d().k().e();
    long l1 = l2;
    if (com.tencent.beacon.d.b.a(this.a))
    {
      com.tencent.beacon.d.a.e(" onwifi, so half mSZ " + l2, new Object[0]);
      l1 = l2 / 2L;
    }
    int i;
    if (g.p(this.a) >= l1)
    {
      i = 1;
      label136:
      if ((i == 0) || (!localh.b()) || (!localh.c())) {
        break label214;
      }
      if (localh.a() < 10) {
        break label216;
      }
      com.tencent.beacon.d.a.c(" doUpload request failed 10 times sleep...", new Object[0]);
      com.tencent.beacon.a.d.a().a(this.e, 600000L);
      com.tencent.beacon.upload.h.a(this.a).a(0);
    }
    for (;;)
    {
      com.tencent.beacon.d.a.e(" max Up", new Object[0]);
      return;
      i = 0;
      break label136;
      label214:
      break;
      label216:
      this.e.run();
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/beacon/event/a:b	Z
    //   6: iload_1
    //   7: if_icmpeq +41 -> 48
    //   10: iload_1
    //   11: ifeq +40 -> 51
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 27	com/tencent/beacon/event/a:b	Z
    //   19: invokestatic 444	com/tencent/beacon/event/n:d	()Lcom/tencent/beacon/event/n;
    //   22: invokevirtual 447	com/tencent/beacon/event/n:k	()Lcom/tencent/beacon/event/e;
    //   25: invokevirtual 492	com/tencent/beacon/event/e:d	()I
    //   28: sipush 1000
    //   31: imul
    //   32: i2l
    //   33: lstore_2
    //   34: invokestatic 476	com/tencent/beacon/a/d:a	()Lcom/tencent/beacon/a/d;
    //   37: bipush 102
    //   39: aload_0
    //   40: getfield 32	com/tencent/beacon/event/a:d	Ljava/lang/Runnable;
    //   43: lload_2
    //   44: lload_2
    //   45: invokevirtual 495	com/tencent/beacon/a/d:a	(ILjava/lang/Runnable;JJ)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 476	com/tencent/beacon/a/d:a	()Lcom/tencent/beacon/a/d;
    //   54: bipush 102
    //   56: iconst_1
    //   57: invokevirtual 498	com/tencent/beacon/a/d:a	(IZ)V
    //   60: aload_0
    //   61: invokevirtual 500	com/tencent/beacon/event/a:a	()V
    //   64: aload_0
    //   65: iload_1
    //   66: putfield 27	com/tencent/beacon/event/a:b	Z
    //   69: goto -21 -> 48
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramBoolean	boolean
    //   33	12	2	l	long
    //   72	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	72	finally
    //   14	48	72	finally
    //   51	69	72	finally
  }
  
  public final boolean a(i parami)
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    if (parami == null)
    {
      localObject1 = "null";
      if (parami != null) {
        break label90;
      }
      localObject2 = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.d.a.f(" BF eN:%s   isRT:%b  isCR:%b", new Object[] { localObject1, Boolean.valueOf(false), localObject2 });
        if ((this.a == null) || (parami == null) || (!this.b))
        {
          com.tencent.beacon.d.a.d(" err BF 1R", new Object[0]);
          return bool;
          localObject1 = parami.d();
          break;
          label90:
          localObject2 = Boolean.valueOf(parami.f());
          continue;
        }
        if (!c())
        {
          com.tencent.beacon.d.a.d(" err BF 2R", new Object[0]);
          continue;
        }
        localObject1 = n.d().k();
      }
      finally {}
      int i = ((e)localObject1).c();
      long l = ((e)localObject1).d() * 1000;
      int j = this.c.size();
      if (j >= i)
      {
        com.tencent.beacon.d.a.d(" err BF 3R! list size:" + j, new Object[0]);
      }
      else
      {
        this.c.add(parami);
        if (j + 1 >= i)
        {
          com.tencent.beacon.d.a.f(" BF mN!}", new Object[0]);
          com.tencent.beacon.a.d.a().a(this.d);
          com.tencent.beacon.a.d.a().a(102, this.d, l, l);
        }
        bool = true;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, c... paramVarArgs)
  {
    Object localObject;
    int j;
    int i;
    try
    {
      com.tencent.beacon.d.a.e(" onUAC %s", new Object[] { paramString });
      c localc = null;
      if ((paramString == null) || (this.a == null)) {
        if (" err 1R " + this.a == null)
        {
          paramString = "context";
          com.tencent.beacon.d.a.e(paramString, new Object[0]);
        }
      }
      for (paramBoolean = false;; paramBoolean = false)
      {
        return paramBoolean;
        paramString = "en";
        break;
        Iterator localIterator = this.c.iterator();
        do
        {
          localObject = localc;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (i)localIterator.next();
        } while ((!((i)localObject).f()) || (!((i)localObject).d().equals(paramString)));
        if (localObject != null) {
          break label473;
        }
        com.tencent.beacon.d.a.e(" onUAC add new", new Object[0]);
        localObject = new HashMap();
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          j = paramVarArgs.length;
          i = 0;
          while (i < j)
          {
            localc = paramVarArgs[i];
            ((Map)localObject).put(localc.a, Long.toString(localc.b));
            i += 1;
          }
        }
        paramString = a(this.a, paramString, paramBoolean, paramLong1, paramLong2, (Map)localObject);
        if (paramString != null) {
          break label246;
        }
      }
      label246:
      paramVarArgs = paramString.e();
      paramVarArgs.put("C1", Long.toString(paramString.c()));
      paramVarArgs.put("C2", Long.toString(1L));
      if (paramBoolean)
      {
        paramVarArgs.put("C4", Long.toString(paramLong1));
        paramVarArgs.put("C5", Long.toString(paramLong2));
        paramVarArgs.put("C6", Long.toString(0L));
        paramVarArgs.put("C7", Long.toString(0L));
        paramVarArgs.put("C8", Long.toString(0L));
      }
      for (;;)
      {
        paramString.a(true);
        com.tencent.beacon.d.a.b(" add record, return!", new Object[0]);
        paramBoolean = a(paramString);
        break;
        paramVarArgs.put("C4", Long.toString(0L));
        paramVarArgs.put("C5", Long.toString(0L));
        paramVarArgs.put("C6", Long.toString(1L));
        paramVarArgs.put("C7", Long.toString(paramLong1));
        paramVarArgs.put("C8", Long.toString(paramLong2));
      }
      com.tencent.beacon.d.a.e(" onUAC up O", new Object[0]);
    }
    finally {}
    label473:
    ((i)localObject).c(((i)localObject).g() + 1L);
    if (paramLong1 >= 1200000L)
    {
      ((i)localObject).b(true);
      ((i)localObject).d(((i)localObject).i() + 1L);
    }
    if (paramLong2 >= 50000000L)
    {
      ((i)localObject).b(true);
      ((i)localObject).d(((i)localObject).i() + 1L);
    }
    paramString = ((i)localObject).e();
    if (paramString == null)
    {
      com.tencent.beacon.d.a.c(" err ? ep==null: %s", new Object[] { ((i)localObject).d() });
      paramString = new HashMap();
      ((i)localObject).a(paramString);
    }
    for (;;)
    {
      paramString.put("C1", Long.toString(new Date().getTime()));
      g.a(paramString, "A26", paramLong1);
      g.a(paramString, "A27", paramLong2);
      g.a(paramString, "C2", 1L);
      if (paramBoolean)
      {
        g.a(paramString, "C4", paramLong1);
        g.a(paramString, "C5", paramLong2);
      }
      while ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        j = paramVarArgs.length;
        i = 0;
        while (i < j)
        {
          localObject = paramVarArgs[i];
          g.a(paramString, ((c)localObject).a, ((c)localObject).b);
          i += 1;
        }
        g.a(paramString, "C6", 1L);
        g.a(paramString, "C7", paramLong1);
        g.a(paramString, "C8", paramLong2);
      }
      paramBoolean = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.event.a
 * JD-Core Version:    0.7.0.1
 */