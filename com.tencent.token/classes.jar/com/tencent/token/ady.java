package com.tencent.token;

import com.tencent.turingfd.sdk.qps.Andromeda;
import com.tencent.turingfd.sdk.qps.Andromeda.c;
import com.tencent.turingfd.sdk.qps.Andromeda.e;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class ady
{
  public static final ahh<String> A;
  public static final ahh<BigDecimal> B;
  public static final ahh<BigInteger> C;
  public static final ahk D;
  public static final ahh<StringBuilder> E;
  public static final ahk F;
  public static final ahh<StringBuffer> G;
  public static final ahk H;
  public static final ahh<URL> I;
  public static final ahk J;
  public static final ahh<URI> K;
  public static final ahk L;
  public static final ahh<InetAddress> M;
  public static final ahk N;
  public static final ahh<UUID> O;
  public static final ahk P;
  public static final ahh<Currency> Q;
  public static final ahk R;
  public static final ahk S;
  public static final ahh<Calendar> T;
  public static final ahk U;
  public static final ahh<Locale> V;
  public static final ahk W;
  public static final ahh<ahu> X;
  public static final ahk Y;
  public static final ahk Z = new aa();
  public static final ahh<Class> a;
  public static final ahk b;
  public static final ahh<BitSet> c;
  public static final ahk d;
  public static final ahh<Boolean> e;
  public static final ahh<Boolean> f;
  public static final ahk g;
  public static final ahh<Number> h;
  public static final ahk i;
  public static final ahh<Number> j;
  public static final ahk k;
  public static final ahh<Number> l;
  public static final ahk m;
  public static final ahh<AtomicInteger> n;
  public static final ahk o;
  public static final ahh<AtomicBoolean> p;
  public static final ahk q;
  public static final ahh<AtomicIntegerArray> r;
  public static final ahk s;
  public static final ahh<Number> t;
  public static final ahh<Number> u;
  public static final ahh<Number> v;
  public static final ahh<Number> w;
  public static final ahk x;
  public static final ahh<Character> y;
  public static final ahk z;
  
  static
  {
    Object localObject = new ahz(new d());
    a = (ahh)localObject;
    b = new ad(Class.class, (ahh)localObject);
    localObject = new ahz(new x());
    c = (ahh)localObject;
    d = new ad(BitSet.class, (ahh)localObject);
    localObject = new k();
    e = (ahh)localObject;
    f = new m();
    g = new h(Boolean.TYPE, Boolean.class, (ahh)localObject);
    localObject = new t();
    h = (ahh)localObject;
    i = new h(Byte.TYPE, Byte.class, (ahh)localObject);
    localObject = new u();
    j = (ahh)localObject;
    k = new h(Short.TYPE, Short.class, (ahh)localObject);
    localObject = new a();
    l = (ahh)localObject;
    m = new h(Integer.TYPE, Integer.class, (ahh)localObject);
    localObject = new ahz(new g());
    n = (ahh)localObject;
    o = new ad(AtomicInteger.class, (ahh)localObject);
    localObject = new ahz(new y());
    p = (ahh)localObject;
    q = new ad(AtomicBoolean.class, (ahh)localObject);
    localObject = new ahz(new i());
    r = (ahh)localObject;
    s = new ad(AtomicIntegerArray.class, (ahh)localObject);
    t = new p();
    u = new n();
    v = new s();
    localObject = new ae();
    w = (ahh)localObject;
    x = new ad(Number.class, (ahh)localObject);
    localObject = new c();
    y = (ahh)localObject;
    z = new h(Character.TYPE, Character.class, (ahh)localObject);
    localObject = new j();
    A = (ahh)localObject;
    B = new o();
    C = new ab();
    D = new ad(String.class, (ahh)localObject);
    localObject = new b();
    E = (ahh)localObject;
    F = new ad(StringBuilder.class, (ahh)localObject);
    localObject = new e();
    G = (ahh)localObject;
    H = new ad(StringBuffer.class, (ahh)localObject);
    localObject = new f();
    I = (ahh)localObject;
    J = new ad(URL.class, (ahh)localObject);
    localObject = new l();
    K = (ahh)localObject;
    L = new ad(URI.class, (ahh)localObject);
    localObject = new z();
    M = (ahh)localObject;
    N = new aec(InetAddress.class, (ahh)localObject);
    localObject = new ac();
    O = (ahh)localObject;
    P = new ad(UUID.class, (ahh)localObject);
    localObject = new ahz(new ag());
    Q = (ahh)localObject;
    R = new ad(Currency.class, (ahh)localObject);
    S = new q();
    localObject = new r();
    T = (ahh)localObject;
    U = new adz(Calendar.class, GregorianCalendar.class, (ahh)localObject);
    localObject = new v();
    V = (ahh)localObject;
    W = new ad(Locale.class, (ahh)localObject);
    localObject = new w();
    X = (ahh)localObject;
    Y = new aec(ahu.class, (ahh)localObject);
  }
  
  public static <TT> ahk a(Class<TT> paramClass, ahh<TT> paramahh)
  {
    return new ad(paramahh);
  }
  
  public static <TT> ahk a(Class<TT> paramClass1, Class<TT> paramClass2, ahh<? super TT> paramahh)
  {
    return new h(paramClass2, paramahh);
  }
  
  public final class a
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class aa
    implements ahk
  {
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      paramaek = paramaek.a;
      if ((Enum.class.isAssignableFrom(paramaek)) && (paramaek != Enum.class))
      {
        paramahx = paramaek;
        if (!paramaek.isEnum()) {
          paramahx = paramaek.getSuperclass();
        }
        return new ady.af(paramahx);
      }
      return null;
    }
  }
  
  public final class ab
    extends ahh<BigInteger>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((BigInteger)paramObject);
    }
  }
  
  public final class ac
    extends ahh<UUID>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (UUID)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class ad
    implements ahk
  {
    public ad(ahh paramahh) {}
    
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      if (paramaek.a == ady.this) {
        return this.b;
      }
      return null;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Factory[type=");
      localStringBuilder.append(ady.this.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public final class ae
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public static final class af<T extends Enum<T>>
    extends ahh<T>
  {
    public final Map<String, T> a = new HashMap();
    public final Map<T, String> b = new HashMap();
    
    public af(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (ahq)paramClass.getField((String)localObject1).getAnnotation(ahq.class);
          if (localObject2 != null)
          {
            String str = ((ahq)localObject2).a();
            localObject2 = ((ahq)localObject2).b();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.a.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.a.put(localObject1, localEnum);
          this.b.put(localEnum, localObject1);
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Enum)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = (String)this.b.get(paramObject);
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class ag
    extends ahh<Currency>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.b(((Currency)paramObject).getCurrencyCode());
    }
  }
  
  public final class b
    extends ahh<StringBuilder>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (StringBuilder)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class c
    extends ahh<Character>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Character)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = String.valueOf(paramObject);
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class d
    extends ahh<Class>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep = (Class)paramObject;
      paramObject = new StringBuilder("Attempted to serialize java.lang.Class: ");
      paramObject.append(paramaep.getName());
      paramObject.append(". Forgot to register a type adapter?");
      throw new UnsupportedOperationException(paramObject.toString());
    }
  }
  
  public final class e
    extends ahh<StringBuffer>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (StringBuffer)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class f
    extends ahh<URL>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (URL)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toExternalForm();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class g
    extends ahh<AtomicInteger>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a(((AtomicInteger)paramObject).get());
    }
  }
  
  public final class h
    implements ahk
  {
    public h(Class paramClass, ahh paramahh) {}
    
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      paramahx = paramaek.a;
      if ((paramahx != ady.this) && (paramahx != this.b)) {
        return null;
      }
      return this.c;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Factory[type=");
      localStringBuilder.append(this.b.getName());
      localStringBuilder.append("+");
      localStringBuilder.append(ady.this.getName());
      localStringBuilder.append(",adapter=");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public final class i
    extends ahh<AtomicIntegerArray>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (AtomicIntegerArray)paramObject;
      paramaep.a();
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        paramaep.a(paramObject.get(i));
        i += 1;
      }
      paramaep.b();
    }
  }
  
  public final class j
    extends ahh<String>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.b((String)paramObject);
    }
  }
  
  public final class k
    extends ahh<Boolean>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Boolean)paramObject);
    }
  }
  
  public final class l
    extends ahh<URI>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (URI)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toASCIIString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class m
    extends ahh<Boolean>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Boolean)paramObject;
      if (paramObject == null) {
        paramObject = "null";
      } else {
        paramObject = paramObject.toString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class n
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class o
    extends ahh<BigDecimal>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((BigDecimal)paramObject);
    }
  }
  
  public final class p
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class q
    implements ahk
  {
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      if (paramaek.a != Timestamp.class) {
        return null;
      }
      paramahx.getClass();
      return new a(paramahx.a(new aek(Date.class)));
    }
    
    public final class a
      extends ahh<Timestamp>
    {
      public a() {}
      
      public final void a(aep paramaep, Object paramObject)
      {
        paramObject = (Timestamp)paramObject;
        ady.q.this.a(paramaep, paramObject);
      }
    }
  }
  
  public final class r
    extends ahh<Calendar>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Calendar)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      paramaep.c();
      paramaep.a("year");
      paramaep.a(paramObject.get(1));
      paramaep.a("month");
      paramaep.a(paramObject.get(2));
      paramaep.a("dayOfMonth");
      paramaep.a(paramObject.get(5));
      paramaep.a("hourOfDay");
      paramaep.a(paramObject.get(11));
      paramaep.a("minute");
      paramaep.a(paramObject.get(12));
      paramaep.a("second");
      paramaep.a(paramObject.get(13));
      paramaep.d();
    }
  }
  
  public final class s
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class t
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class u
    extends ahh<Number>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a((Number)paramObject);
    }
  }
  
  public final class v
    extends ahh<Locale>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Locale)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.toString();
      }
      paramaep.b(paramObject);
    }
  }
  
  public final class w
    extends ahh<ahu>
  {
    private void a(aep paramaep, ahu paramahu)
    {
      if ((paramahu != null) && (!(paramahu instanceof agv)))
      {
        Object localObject;
        if ((paramahu instanceof agx))
        {
          paramahu = paramahu.c();
          localObject = paramahu.a;
          if ((localObject instanceof Number))
          {
            paramaep.a(paramahu.a());
            return;
          }
          bool = localObject instanceof Boolean;
          if (bool)
          {
            if (bool) {
              bool = ((Boolean)localObject).booleanValue();
            } else {
              bool = Boolean.parseBoolean(paramahu.b());
            }
            paramaep.a(bool);
            return;
          }
          paramaep.b(paramahu.b());
          return;
        }
        boolean bool = paramahu instanceof ahb;
        if (bool)
        {
          paramaep.a();
          if (bool)
          {
            paramahu = ((ahb)paramahu).a.iterator();
            while (paramahu.hasNext()) {
              a(paramaep, (ahu)paramahu.next());
            }
            paramaep.b();
            return;
          }
          throw new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(paramahu)));
        }
        bool = paramahu instanceof agw;
        if (bool)
        {
          paramaep.c();
          if (bool)
          {
            Andromeda localAndromeda = ((Andromeda.c)((agw)paramahu).a.entrySet()).a;
            paramahu = localAndromeda.g.d;
            int j = localAndromeda.f;
            for (;;)
            {
              localObject = localAndromeda.g;
              int i;
              if (paramahu != localObject) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0) {
                break label334;
              }
              if (paramahu == localObject) {
                break label326;
              }
              if (localAndromeda.f != j) {
                break;
              }
              localObject = paramahu.d;
              paramaep.a((String)paramahu.f);
              a(paramaep, (ahu)paramahu.g);
              paramahu = (ahu)localObject;
            }
            throw new ConcurrentModificationException();
            label326:
            throw new NoSuchElementException();
            label334:
            paramaep.d();
            return;
          }
          throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(paramahu)));
        }
        paramaep = new StringBuilder("Couldn't write ");
        paramaep.append(paramahu.getClass());
        throw new IllegalArgumentException(paramaep.toString());
      }
      paramaep.e();
    }
  }
  
  public final class x
    extends ahh<BitSet>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  public final class y
    extends ahh<AtomicBoolean>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramaep.a(((AtomicBoolean)paramObject).get());
    }
  }
  
  public final class z
    extends ahh<InetAddress>
  {
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (InetAddress)paramObject;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.getHostAddress();
      }
      paramaep.b(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ady
 * JD-Core Version:    0.7.0.1
 */