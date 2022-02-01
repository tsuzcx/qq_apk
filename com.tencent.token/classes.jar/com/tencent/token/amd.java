package com.tencent.token;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class amd
{
  public final akm a;
  public aln b;
  public final aku c;
  public final akq d;
  public final ala e;
  public alz f;
  public amg g;
  private amc.a i;
  private final Object j;
  private final amc k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public amd(aku paramaku, akm paramakm, akq paramakq, ala paramala, Object paramObject)
  {
    this.c = paramaku;
    this.a = paramakm;
    this.d = paramakq;
    this.e = paramala;
    this.k = new amc(paramakm, f(), paramakq, paramala);
    this.j = paramObject;
  }
  
  private alz a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    for (;;)
    {
      int i3;
      synchronized (this.c)
      {
        if (!this.n)
        {
          if (this.g == null)
          {
            if (!this.o)
            {
              if ((!h) && (!Thread.holdsLock(this.c))) {
                throw new AssertionError();
              }
              Object localObject1 = this.f;
              Object localObject8 = null;
              if ((localObject1 != null) && (((alz)localObject1).g))
              {
                localObject7 = a(false, false, true);
                if (this.f == null) {
                  break label646;
                }
                localObject6 = this.f;
                if (localObject6 != null) {
                  break label652;
                }
                alp.a.a(this.c, this.a, this, null);
                if (this.f != null)
                {
                  localObject6 = this.f;
                  localObject1 = null;
                  i1 = 1;
                }
                else
                {
                  localObject1 = this.b;
                  i1 = 0;
                }
                alr.a((Socket)localObject7);
                if (localObject6 != null) {
                  return localObject6;
                }
                if (localObject1 == null)
                {
                  localObject7 = this.i;
                  if ((localObject7 == null) || (!((amc.a)localObject7).a()))
                  {
                    this.i = this.k.b();
                    i3 = 1;
                    continue;
                  }
                }
                i3 = 0;
                synchronized (this.c)
                {
                  if (!this.o)
                  {
                    localObject7 = localObject6;
                    int i2 = i1;
                    if (i3 != 0)
                    {
                      ArrayList localArrayList = new ArrayList(this.i.a);
                      int i4 = localArrayList.size();
                      i3 = 0;
                      localObject7 = localObject6;
                      i2 = i1;
                      if (i3 < i4)
                      {
                        aln localaln = (aln)localArrayList.get(i3);
                        alp.a.a(this.c, this.a, this, localaln);
                        if (this.f == null) {
                          break label661;
                        }
                        localObject7 = this.f;
                        this.b = localaln;
                        i2 = 1;
                      }
                    }
                    localObject6 = localObject7;
                    if (i2 == 0)
                    {
                      localObject6 = localObject1;
                      if (localObject1 == null)
                      {
                        localObject1 = this.i;
                        if (((amc.a)localObject1).a())
                        {
                          localObject6 = ((amc.a)localObject1).a;
                          i1 = ((amc.a)localObject1).b;
                          ((amc.a)localObject1).b = (i1 + 1);
                          localObject6 = (aln)((List)localObject6).get(i1);
                        }
                        else
                        {
                          throw new NoSuchElementException();
                        }
                      }
                      this.b = ((aln)localObject6);
                      this.l = 0;
                      localObject6 = new alz(this.c, (aln)localObject6);
                      a((alz)localObject6, false);
                    }
                    if (i2 != 0) {
                      return localObject6;
                    }
                    ((alz)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
                    f().b(((alz)localObject6).a);
                    synchronized (this.c)
                    {
                      this.m = true;
                      alp.a.b(this.c, (alz)localObject6);
                      localObject7 = localObject8;
                      localObject1 = localObject6;
                      if (((alz)localObject6).a())
                      {
                        localObject7 = alp.a.a(this.c, this.a, this);
                        localObject1 = this.f;
                      }
                      alr.a((Socket)localObject7);
                      return localObject1;
                    }
                  }
                  throw new IOException("Canceled");
                }
              }
            }
            else
            {
              throw new IOException("Canceled");
            }
          }
          else {
            throw new IllegalStateException("codec != null");
          }
        }
        else {
          throw new IllegalStateException("released");
        }
      }
      Object localObject7 = null;
      continue;
      label646:
      Object localObject6 = null;
      continue;
      label652:
      Object localObject5 = null;
      int i1 = 0;
      continue;
      label661:
      i3 += 1;
    }
  }
  
  private alz a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      alz localalz = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.c)
      {
        if (localalz.h == 0) {
          return localalz;
        }
        if (!localalz.a(paramBoolean2))
        {
          d();
          continue;
        }
        return localalz;
      }
    }
  }
  
  private void a(alz paramalz)
  {
    int i2 = paramalz.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Reference)paramalz.j.get(i1)).get() == this)
      {
        paramalz.j.remove(i1);
        return;
      }
      i1 += 1;
    }
    throw new IllegalStateException();
  }
  
  private ama f()
  {
    return alp.a.a(this.c);
  }
  
  public final amg a()
  {
    synchronized (this.c)
    {
      amg localamg = this.g;
      return localamg;
    }
  }
  
  /* Error */
  public final amg a(alg paramalg, ale.a arg2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 214 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 216 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 218 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: getfield 223	com/tencent/token/alg:C	I
    //   28: istore 7
    //   30: aload_1
    //   31: getfield 226	com/tencent/token/alg:y	Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 228	com/tencent/token/amd:a	(IIIIZZ)Lcom/tencent/token/alz;
    //   51: astore 9
    //   53: aload 9
    //   55: getfield 231	com/tencent/token/alz:d	Lcom/tencent/token/amx;
    //   58: ifnull +22 -> 80
    //   61: new 233	com/tencent/token/amw
    //   64: dup
    //   65: aload_1
    //   66: aload_2
    //   67: aload_0
    //   68: aload 9
    //   70: getfield 231	com/tencent/token/alz:d	Lcom/tencent/token/amx;
    //   73: invokespecial 236	com/tencent/token/amw:<init>	(Lcom/tencent/token/alg;Lcom/tencent/token/ale$a;Lcom/tencent/token/amd;Lcom/tencent/token/amx;)V
    //   76: astore_1
    //   77: goto +85 -> 162
    //   80: aload 9
    //   82: getfield 239	com/tencent/token/alz:b	Ljava/net/Socket;
    //   85: aload_2
    //   86: invokeinterface 216 1 0
    //   91: invokevirtual 245	java/net/Socket:setSoTimeout	(I)V
    //   94: aload 9
    //   96: getfield 248	com/tencent/token/alz:e	Lcom/tencent/token/anv;
    //   99: invokeinterface 253 1 0
    //   104: aload_2
    //   105: invokeinterface 216 1 0
    //   110: i2l
    //   111: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   114: invokevirtual 264	com/tencent/token/aok:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/aok;
    //   117: pop
    //   118: aload 9
    //   120: getfield 267	com/tencent/token/alz:f	Lcom/tencent/token/anu;
    //   123: invokeinterface 270 1 0
    //   128: aload_2
    //   129: invokeinterface 218 1 0
    //   134: i2l
    //   135: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   138: invokevirtual 264	com/tencent/token/aok:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/aok;
    //   141: pop
    //   142: new 272	com/tencent/token/amq
    //   145: dup
    //   146: aload_1
    //   147: aload_0
    //   148: aload 9
    //   150: getfield 248	com/tencent/token/alz:e	Lcom/tencent/token/anv;
    //   153: aload 9
    //   155: getfield 267	com/tencent/token/alz:f	Lcom/tencent/token/anu;
    //   158: invokespecial 275	com/tencent/token/amq:<init>	(Lcom/tencent/token/alg;Lcom/tencent/token/amd;Lcom/tencent/token/anv;Lcom/tencent/token/anu;)V
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 50	com/tencent/token/amd:c	Lcom/tencent/token/aku;
    //   166: astore_2
    //   167: aload_2
    //   168: monitorenter
    //   169: aload_0
    //   170: aload_1
    //   171: putfield 73	com/tencent/token/amd:g	Lcom/tencent/token/amg;
    //   174: aload_2
    //   175: monitorexit
    //   176: aload_1
    //   177: areturn
    //   178: astore_1
    //   179: aload_2
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: new 277	com/tencent/token/amb
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 280	com/tencent/token/amb:<init>	(Ljava/io/IOException;)V
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	amd
    //   0	193	1	paramalg	alg
    //   0	193	3	paramBoolean	boolean
    //   6	32	4	i1	int
    //   14	26	5	i2	int
    //   22	20	6	i3	int
    //   28	16	7	i4	int
    //   34	12	8	bool	boolean
    //   51	103	9	localalz	alz
    // Exception table:
    //   from	to	target	type
    //   169	176	178	finally
    //   179	181	178	finally
    //   36	77	183	java/io/IOException
    //   80	162	183	java/io/IOException
    //   162	169	183	java/io/IOException
    //   181	183	183	java/io/IOException
  }
  
  public final Socket a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!h) && (!Thread.holdsLock(this.c))) {
      throw new AssertionError();
    }
    if (paramBoolean3) {
      this.g = null;
    }
    if (paramBoolean2) {
      this.n = true;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      if (paramBoolean1) {
        ((alz)localObject).g = true;
      }
      if ((this.g == null) && ((this.n) || (this.f.g)))
      {
        a(this.f);
        if (this.f.j.isEmpty())
        {
          this.f.k = System.nanoTime();
          if (alp.a.a(this.c, this.f))
          {
            localObject = this.f.b;
            break label155;
          }
        }
        localObject = null;
        label155:
        this.f = null;
        return localObject;
      }
    }
    return null;
  }
  
  public final void a(alz paramalz, boolean paramBoolean)
  {
    if ((!h) && (!Thread.holdsLock(this.c))) {
      throw new AssertionError();
    }
    if (this.f == null)
    {
      this.f = paramalz;
      this.m = paramBoolean;
      paramalz.j.add(new a(this, this.j));
      return;
    }
    throw new IllegalStateException();
  }
  
  public final void a(IOException paramIOException)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        if ((paramIOException instanceof ane))
        {
          paramIOException = ((ane)paramIOException).a;
          if (paramIOException == ams.e)
          {
            this.l += 1;
            if (this.l <= 1) {
              break label220;
            }
          }
          else
          {
            if (paramIOException == ams.f) {
              break label220;
            }
            this.b = null;
            bool = true;
            continue;
          }
        }
        else
        {
          if ((this.f == null) || ((this.f.a()) && (!(paramIOException instanceof amr)))) {
            break label230;
          }
          if (this.f.h != 0) {
            break label225;
          }
          if ((this.b != null) && (paramIOException != null))
          {
            amc localamc = this.k;
            aln localaln = this.b;
            if ((localaln.b.type() != Proxy.Type.DIRECT) && (localamc.a.g != null)) {
              localamc.a.g.connectFailed(localamc.a.a.a(), localaln.b.address(), paramIOException);
            }
            localamc.b.a(localaln);
          }
        }
        this.b = null;
        bool = true;
        paramIOException = a(bool, false, true);
        alr.a(paramIOException);
        return;
      }
      label220:
      boolean bool = false;
      continue;
      label225:
      bool = true;
      continue;
      label230:
      bool = false;
    }
  }
  
  public final void a(boolean paramBoolean, amg paramamg)
  {
    aku localaku = this.c;
    if (paramamg != null) {}
    try
    {
      if (paramamg == this.g)
      {
        if (!paramBoolean)
        {
          paramamg = this.f;
          paramamg.h += 1;
        }
        paramamg = a(paramBoolean, false, true);
        alr.a(paramamg);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("expected ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramamg);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
  }
  
  public final alz b()
  {
    try
    {
      alz localalz = this.f;
      return localalz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c()
  {
    synchronized (this.c)
    {
      Socket localSocket = a(false, true, false);
      alr.a(localSocket);
      return;
    }
  }
  
  public final void d()
  {
    synchronized (this.c)
    {
      Socket localSocket = a(true, false, false);
      alr.a(localSocket);
      return;
    }
  }
  
  public final boolean e()
  {
    if (this.b == null)
    {
      amc.a locala = this.i;
      if (((locala == null) || (!locala.a())) && (!this.k.a())) {
        return false;
      }
    }
    return true;
  }
  
  public final String toString()
  {
    alz localalz = b();
    if (localalz != null) {
      return localalz.toString();
    }
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<amd>
  {
    public final Object a;
    
    a(amd paramamd, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amd
 * JD-Core Version:    0.7.0.1
 */