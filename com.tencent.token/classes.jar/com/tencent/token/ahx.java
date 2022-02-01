package com.tencent.token;

import com.tencent.turingfd.sdk.qps.throw;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class ahx
{
  public static final aek<?> a = new aek(Object.class);
  public final ThreadLocal<Map<aek<?>, a<?>>> b = new ThreadLocal();
  public final Map<aek<?>, ahh<?>> c = new ConcurrentHashMap();
  public final ahn d;
  public final ada e;
  public final List<ahk> f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  
  public ahx(ahg paramahg, ahl paramahl, Map<Type, agu<?>> paramMap, throw paramthrow, List<ahk> paramList)
  {
    ahn localahn = new ahn(paramMap);
    this.d = localahn;
    this.g = false;
    this.h = false;
    this.i = true;
    this.j = false;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ady.Y);
    localArrayList.add(adh.a);
    localArrayList.add(paramahg);
    localArrayList.addAll(paramList);
    localArrayList.add(ady.D);
    localArrayList.add(ady.m);
    localArrayList.add(ady.g);
    localArrayList.add(ady.i);
    localArrayList.add(ady.k);
    if (paramthrow == throw.a) {
      paramMap = ady.t;
    } else {
      paramMap = new c();
    }
    localArrayList.add(ady.a(Long.TYPE, Long.class, paramMap));
    localArrayList.add(ady.a(Double.TYPE, Double.class, new b()));
    localArrayList.add(ady.a(Float.TYPE, Float.class, new d()));
    localArrayList.add(ady.x);
    localArrayList.add(ady.o);
    localArrayList.add(ady.q);
    localArrayList.add(ady.a(AtomicLong.class, new ahz(new e(paramMap))));
    localArrayList.add(ady.a(AtomicLongArray.class, new ahz(new f(paramMap))));
    localArrayList.add(ady.s);
    localArrayList.add(ady.z);
    localArrayList.add(ady.F);
    localArrayList.add(ady.H);
    localArrayList.add(ady.a(BigDecimal.class, ady.B));
    localArrayList.add(ady.a(BigInteger.class, ady.C));
    localArrayList.add(ady.J);
    localArrayList.add(ady.L);
    localArrayList.add(ady.P);
    localArrayList.add(ady.R);
    localArrayList.add(ady.W);
    localArrayList.add(ady.N);
    localArrayList.add(ady.d);
    localArrayList.add(acz.a);
    localArrayList.add(ady.U);
    localArrayList.add(adp.a);
    localArrayList.add(adk.a);
    localArrayList.add(ady.S);
    localArrayList.add(acm.a);
    localArrayList.add(ady.b);
    localArrayList.add(new acw(localahn));
    localArrayList.add(new adb(localahn));
    paramMap = new ada(localahn);
    this.e = paramMap;
    localArrayList.add(paramMap);
    localArrayList.add(ady.Z);
    localArrayList.add(new adj(localahn, paramahl, paramahg, paramMap));
    this.f = Collections.unmodifiableList(localArrayList);
  }
  
  public static void a(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final <T> ahh<T> a(aek<T> paramaek)
  {
    Object localObject1 = (ahh)this.c.get(paramaek);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = (Map)this.b.get();
    int k = 0;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      this.b.set(localObject1);
      k = 1;
    }
    localObject2 = (a)((Map)localObject1).get(paramaek);
    if (localObject2 != null) {
      return localObject2;
    }
    try
    {
      localObject2 = new a();
      ((Map)localObject1).put(paramaek, localObject2);
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        ahh localahh = ((ahk)localIterator.next()).a(this, paramaek);
        if (localahh != null)
        {
          if (((a)localObject2).a == null)
          {
            ((a)localObject2).a = localahh;
            this.c.put(paramaek, localahh);
            return localahh;
          }
          throw new AssertionError();
        }
      }
      throw new IllegalArgumentException("GSON (2.8.6) cannot handle ".concat(String.valueOf(paramaek)));
    }
    finally
    {
      ((Map)localObject1).remove(paramaek);
      if (k != 0) {
        this.b.remove();
      }
    }
  }
  
  public final <T> ahh<T> a(ahk paramahk, aek<T> paramaek)
  {
    Object localObject1 = paramahk;
    if (!this.f.contains(paramahk)) {
      localObject1 = this.e;
    }
    int k = 0;
    paramahk = this.f.iterator();
    while (paramahk.hasNext())
    {
      Object localObject2 = (ahk)paramahk.next();
      if (k == 0)
      {
        if (localObject2 == localObject1) {
          k = 1;
        }
      }
      else
      {
        localObject2 = ((ahk)localObject2).a(this, paramaek);
        if (localObject2 != null) {
          return localObject2;
        }
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(paramaek)));
  }
  
  /* Error */
  public final void a(Object paramObject, Type paramType, aep paramaep)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 41	com/tencent/token/aek
    //   4: dup
    //   5: aload_2
    //   6: invokespecial 45	com/tencent/token/aek:<init>	(Ljava/lang/reflect/Type;)V
    //   9: invokevirtual 360	com/tencent/token/ahx:a	(Lcom/tencent/token/aek;)Lcom/tencent/token/ahh;
    //   12: astore_2
    //   13: aload_3
    //   14: getfield 364	com/tencent/token/aep:m	Z
    //   17: istore 4
    //   19: aload_3
    //   20: iconst_1
    //   21: putfield 364	com/tencent/token/aep:m	Z
    //   24: aload_3
    //   25: getfield 367	com/tencent/token/aep:n	Z
    //   28: istore 5
    //   30: aload_3
    //   31: aload_0
    //   32: getfield 74	com/tencent/token/ahx:i	Z
    //   35: putfield 367	com/tencent/token/aep:n	Z
    //   38: aload_3
    //   39: getfield 370	com/tencent/token/aep:p	Z
    //   42: istore 6
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 70	com/tencent/token/ahx:g	Z
    //   49: putfield 370	com/tencent/token/aep:p	Z
    //   52: aload_2
    //   53: aload_3
    //   54: aload_1
    //   55: invokevirtual 373	com/tencent/token/ahh:a	(Lcom/tencent/token/aep;Ljava/lang/Object;)V
    //   58: aload_3
    //   59: iload 4
    //   61: putfield 364	com/tencent/token/aep:m	Z
    //   64: aload_3
    //   65: iload 5
    //   67: putfield 367	com/tencent/token/aep:n	Z
    //   70: aload_3
    //   71: iload 6
    //   73: putfield 370	com/tencent/token/aep:p	Z
    //   76: return
    //   77: astore_1
    //   78: goto +54 -> 132
    //   81: astore_1
    //   82: new 262	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 375
    //   89: invokespecial 376	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: astore_2
    //   93: aload_2
    //   94: aload_1
    //   95: invokevirtual 379	java/lang/AssertionError:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: new 334	java/lang/AssertionError
    //   105: dup
    //   106: aload_2
    //   107: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 381	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   113: astore_2
    //   114: aload_2
    //   115: aload_1
    //   116: invokevirtual 385	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   119: pop
    //   120: aload_2
    //   121: athrow
    //   122: astore_1
    //   123: new 387	com/tencent/turingfd/sdk/qps/break
    //   126: dup
    //   127: aload_1
    //   128: invokespecial 390	com/tencent/turingfd/sdk/qps/break:<init>	(Ljava/lang/Throwable;)V
    //   131: athrow
    //   132: aload_3
    //   133: iload 4
    //   135: putfield 364	com/tencent/token/aep:m	Z
    //   138: aload_3
    //   139: iload 5
    //   141: putfield 367	com/tencent/token/aep:n	Z
    //   144: aload_3
    //   145: iload 6
    //   147: putfield 370	com/tencent/token/aep:p	Z
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	ahx
    //   0	152	1	paramObject	Object
    //   0	152	2	paramType	Type
    //   0	152	3	paramaep	aep
    //   17	117	4	bool1	boolean
    //   28	112	5	bool2	boolean
    //   42	104	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   52	58	77	finally
    //   82	122	77	finally
    //   123	132	77	finally
    //   52	58	81	java/lang/AssertionError
    //   52	58	122	java/io/IOException
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",factories:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static final class a<T>
    extends ahh<T>
  {
    public ahh<T> a;
    
    public final void a(aep paramaep, T paramT)
    {
      ahh localahh = this.a;
      if (localahh != null)
      {
        localahh.a(paramaep, paramT);
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  public final class b
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Number)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      ahx.a(paramObject.doubleValue());
      paramaep.a(paramObject);
    }
  }
  
  public final class c
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Number)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      paramaep.b(paramObject.toString());
    }
  }
  
  public final class d
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Number)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      ahx.a(paramObject.floatValue());
      paramaep.a(paramObject);
    }
  }
  
  public final class e
    extends ahh<AtomicLong>
  {
    public e() {}
    
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (AtomicLong)paramObject;
      ahx.this.a(paramaep, Long.valueOf(paramObject.get()));
    }
  }
  
  public final class f
    extends ahh<AtomicLongArray>
  {
    public f() {}
    
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (AtomicLongArray)paramObject;
      paramaep.a();
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        ahx.this.a(paramaep, Long.valueOf(paramObject.get(i)));
        i += 1;
      }
      paramaep.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahx
 * JD-Core Version:    0.7.0.1
 */