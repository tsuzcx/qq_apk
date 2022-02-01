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

public final class alf
{
  public final ajo a;
  public akp b;
  public final ajw c;
  public final ajs d;
  public final akc e;
  public alb f;
  public ali g;
  private ale.a i;
  private final Object j;
  private final ale k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public alf(ajw paramajw, ajo paramajo, ajs paramajs, akc paramakc, Object paramObject)
  {
    this.c = paramajw;
    this.a = paramajo;
    this.d = paramajs;
    this.e = paramakc;
    this.k = new ale(paramajo, f(), paramajs, paramakc);
    this.j = paramObject;
  }
  
  private alb a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
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
              if ((localObject1 != null) && (((alb)localObject1).g))
              {
                localObject7 = a(false, false, true);
                if (this.f == null) {
                  break label646;
                }
                localObject6 = this.f;
                if (localObject6 != null) {
                  break label652;
                }
                akr.a.a(this.c, this.a, this, null);
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
                akt.a((Socket)localObject7);
                if (localObject6 != null) {
                  return localObject6;
                }
                if (localObject1 == null)
                {
                  localObject7 = this.i;
                  if ((localObject7 == null) || (!((ale.a)localObject7).a()))
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
                        akp localakp = (akp)localArrayList.get(i3);
                        akr.a.a(this.c, this.a, this, localakp);
                        if (this.f == null) {
                          break label661;
                        }
                        localObject7 = this.f;
                        this.b = localakp;
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
                        if (((ale.a)localObject1).a())
                        {
                          localObject6 = ((ale.a)localObject1).a;
                          i1 = ((ale.a)localObject1).b;
                          ((ale.a)localObject1).b = (i1 + 1);
                          localObject6 = (akp)((List)localObject6).get(i1);
                        }
                        else
                        {
                          throw new NoSuchElementException();
                        }
                      }
                      this.b = ((akp)localObject6);
                      this.l = 0;
                      localObject6 = new alb(this.c, (akp)localObject6);
                      a((alb)localObject6, false);
                    }
                    if (i2 != 0) {
                      return localObject6;
                    }
                    ((alb)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
                    f().b(((alb)localObject6).a);
                    synchronized (this.c)
                    {
                      this.m = true;
                      akr.a.b(this.c, (alb)localObject6);
                      localObject7 = localObject8;
                      localObject1 = localObject6;
                      if (((alb)localObject6).a())
                      {
                        localObject7 = akr.a.a(this.c, this.a, this);
                        localObject1 = this.f;
                      }
                      akt.a((Socket)localObject7);
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
  
  private alb a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      alb localalb = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.c)
      {
        if (localalb.h == 0) {
          return localalb;
        }
        if (!localalb.a(paramBoolean2))
        {
          d();
          continue;
        }
        return localalb;
      }
    }
  }
  
  private void a(alb paramalb)
  {
    int i2 = paramalb.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Reference)paramalb.j.get(i1)).get() == this)
      {
        paramalb.j.remove(i1);
        return;
      }
      i1 += 1;
    }
    throw new IllegalStateException();
  }
  
  private alc f()
  {
    return akr.a.a(this.c);
  }
  
  public final ali a()
  {
    synchronized (this.c)
    {
      ali localali = this.g;
      return localali;
    }
  }
  
  /* Error */
  public final ali a(aki paramaki, akg.a arg2, boolean paramBoolean)
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
    //   25: getfield 223	com/tencent/token/aki:C	I
    //   28: istore 7
    //   30: aload_1
    //   31: getfield 226	com/tencent/token/aki:y	Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 228	com/tencent/token/alf:a	(IIIIZZ)Lcom/tencent/token/alb;
    //   51: astore 9
    //   53: aload 9
    //   55: getfield 231	com/tencent/token/alb:d	Lcom/tencent/token/alz;
    //   58: ifnull +22 -> 80
    //   61: new 233	com/tencent/token/aly
    //   64: dup
    //   65: aload_1
    //   66: aload_2
    //   67: aload_0
    //   68: aload 9
    //   70: getfield 231	com/tencent/token/alb:d	Lcom/tencent/token/alz;
    //   73: invokespecial 236	com/tencent/token/aly:<init>	(Lcom/tencent/token/aki;Lcom/tencent/token/akg$a;Lcom/tencent/token/alf;Lcom/tencent/token/alz;)V
    //   76: astore_1
    //   77: goto +85 -> 162
    //   80: aload 9
    //   82: getfield 239	com/tencent/token/alb:b	Ljava/net/Socket;
    //   85: aload_2
    //   86: invokeinterface 216 1 0
    //   91: invokevirtual 245	java/net/Socket:setSoTimeout	(I)V
    //   94: aload 9
    //   96: getfield 248	com/tencent/token/alb:e	Lcom/tencent/token/amx;
    //   99: invokeinterface 253 1 0
    //   104: aload_2
    //   105: invokeinterface 216 1 0
    //   110: i2l
    //   111: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   114: invokevirtual 264	com/tencent/token/anm:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/anm;
    //   117: pop
    //   118: aload 9
    //   120: getfield 267	com/tencent/token/alb:f	Lcom/tencent/token/amw;
    //   123: invokeinterface 270 1 0
    //   128: aload_2
    //   129: invokeinterface 218 1 0
    //   134: i2l
    //   135: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   138: invokevirtual 264	com/tencent/token/anm:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/anm;
    //   141: pop
    //   142: new 272	com/tencent/token/als
    //   145: dup
    //   146: aload_1
    //   147: aload_0
    //   148: aload 9
    //   150: getfield 248	com/tencent/token/alb:e	Lcom/tencent/token/amx;
    //   153: aload 9
    //   155: getfield 267	com/tencent/token/alb:f	Lcom/tencent/token/amw;
    //   158: invokespecial 275	com/tencent/token/als:<init>	(Lcom/tencent/token/aki;Lcom/tencent/token/alf;Lcom/tencent/token/amx;Lcom/tencent/token/amw;)V
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 50	com/tencent/token/alf:c	Lcom/tencent/token/ajw;
    //   166: astore_2
    //   167: aload_2
    //   168: monitorenter
    //   169: aload_0
    //   170: aload_1
    //   171: putfield 73	com/tencent/token/alf:g	Lcom/tencent/token/ali;
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
    //   184: new 277	com/tencent/token/ald
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 280	com/tencent/token/ald:<init>	(Ljava/io/IOException;)V
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	alf
    //   0	193	1	paramaki	aki
    //   0	193	3	paramBoolean	boolean
    //   6	32	4	i1	int
    //   14	26	5	i2	int
    //   22	20	6	i3	int
    //   28	16	7	i4	int
    //   34	12	8	bool	boolean
    //   51	103	9	localalb	alb
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
        ((alb)localObject).g = true;
      }
      if ((this.g == null) && ((this.n) || (this.f.g)))
      {
        a(this.f);
        if (this.f.j.isEmpty())
        {
          this.f.k = System.nanoTime();
          if (akr.a.a(this.c, this.f))
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
  
  public final void a(alb paramalb, boolean paramBoolean)
  {
    if ((!h) && (!Thread.holdsLock(this.c))) {
      throw new AssertionError();
    }
    if (this.f == null)
    {
      this.f = paramalb;
      this.m = paramBoolean;
      paramalb.j.add(new a(this, this.j));
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
        if ((paramIOException instanceof amg))
        {
          paramIOException = ((amg)paramIOException).a;
          if (paramIOException == alu.e)
          {
            this.l += 1;
            if (this.l <= 1) {
              break label220;
            }
          }
          else
          {
            if (paramIOException == alu.f) {
              break label220;
            }
            this.b = null;
            bool = true;
            continue;
          }
        }
        else
        {
          if ((this.f == null) || ((this.f.a()) && (!(paramIOException instanceof alt)))) {
            break label230;
          }
          if (this.f.h != 0) {
            break label225;
          }
          if ((this.b != null) && (paramIOException != null))
          {
            ale localale = this.k;
            akp localakp = this.b;
            if ((localakp.b.type() != Proxy.Type.DIRECT) && (localale.a.g != null)) {
              localale.a.g.connectFailed(localale.a.a.a(), localakp.b.address(), paramIOException);
            }
            localale.b.a(localakp);
          }
        }
        this.b = null;
        bool = true;
        paramIOException = a(bool, false, true);
        akt.a(paramIOException);
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
  
  public final void a(boolean paramBoolean, ali paramali)
  {
    ajw localajw = this.c;
    if (paramali != null) {}
    try
    {
      if (paramali == this.g)
      {
        if (!paramBoolean)
        {
          paramali = this.f;
          paramali.h += 1;
        }
        paramali = a(paramBoolean, false, true);
        akt.a(paramali);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("expected ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramali);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
  }
  
  public final alb b()
  {
    try
    {
      alb localalb = this.f;
      return localalb;
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
      akt.a(localSocket);
      return;
    }
  }
  
  public final void d()
  {
    synchronized (this.c)
    {
      Socket localSocket = a(true, false, false);
      akt.a(localSocket);
      return;
    }
  }
  
  public final boolean e()
  {
    if (this.b == null)
    {
      ale.a locala = this.i;
      if (((locala == null) || (!locala.a())) && (!this.k.a())) {
        return false;
      }
    }
    return true;
  }
  
  public final String toString()
  {
    alb localalb = b();
    if (localalb != null) {
      return localalb.toString();
    }
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<alf>
  {
    public final Object a;
    
    a(alf paramalf, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alf
 * JD-Core Version:    0.7.0.1
 */