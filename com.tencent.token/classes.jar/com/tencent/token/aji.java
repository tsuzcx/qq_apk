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

public final class aji
{
  public final ahr a;
  public ais b;
  public final ahz c;
  public final ahv d;
  public final aif e;
  public aje f;
  public ajl g;
  private ajh.a i;
  private final Object j;
  private final ajh k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public aji(ahz paramahz, ahr paramahr, ahv paramahv, aif paramaif, Object paramObject)
  {
    this.c = paramahz;
    this.a = paramahr;
    this.d = paramahv;
    this.e = paramaif;
    this.k = new ajh(paramahr, f(), paramahv, paramaif);
    this.j = paramObject;
  }
  
  private aje a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
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
              if ((localObject1 != null) && (((aje)localObject1).g))
              {
                localObject7 = a(false, false, true);
                if (this.f == null) {
                  break label646;
                }
                localObject6 = this.f;
                if (localObject6 != null) {
                  break label652;
                }
                aiu.a.a(this.c, this.a, this, null);
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
                aiw.a((Socket)localObject7);
                if (localObject6 != null) {
                  return localObject6;
                }
                if (localObject1 == null)
                {
                  localObject7 = this.i;
                  if ((localObject7 == null) || (!((ajh.a)localObject7).a()))
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
                        ais localais = (ais)localArrayList.get(i3);
                        aiu.a.a(this.c, this.a, this, localais);
                        if (this.f == null) {
                          break label661;
                        }
                        localObject7 = this.f;
                        this.b = localais;
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
                        if (((ajh.a)localObject1).a())
                        {
                          localObject6 = ((ajh.a)localObject1).a;
                          i1 = ((ajh.a)localObject1).b;
                          ((ajh.a)localObject1).b = (i1 + 1);
                          localObject6 = (ais)((List)localObject6).get(i1);
                        }
                        else
                        {
                          throw new NoSuchElementException();
                        }
                      }
                      this.b = ((ais)localObject6);
                      this.l = 0;
                      localObject6 = new aje(this.c, (ais)localObject6);
                      a((aje)localObject6, false);
                    }
                    if (i2 != 0) {
                      return localObject6;
                    }
                    ((aje)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
                    f().b(((aje)localObject6).a);
                    synchronized (this.c)
                    {
                      this.m = true;
                      aiu.a.b(this.c, (aje)localObject6);
                      localObject7 = localObject8;
                      localObject1 = localObject6;
                      if (((aje)localObject6).a())
                      {
                        localObject7 = aiu.a.a(this.c, this.a, this);
                        localObject1 = this.f;
                      }
                      aiw.a((Socket)localObject7);
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
  
  private aje a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      aje localaje = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.c)
      {
        if (localaje.h == 0) {
          return localaje;
        }
        if (!localaje.a(paramBoolean2))
        {
          d();
          continue;
        }
        return localaje;
      }
    }
  }
  
  private void a(aje paramaje)
  {
    int i2 = paramaje.j.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Reference)paramaje.j.get(i1)).get() == this)
      {
        paramaje.j.remove(i1);
        return;
      }
      i1 += 1;
    }
    throw new IllegalStateException();
  }
  
  private ajf f()
  {
    return aiu.a.a(this.c);
  }
  
  public final ajl a()
  {
    synchronized (this.c)
    {
      ajl localajl = this.g;
      return localajl;
    }
  }
  
  /* Error */
  public final ajl a(ail paramail, aij.a arg2, boolean paramBoolean)
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
    //   25: getfield 223	com/tencent/token/ail:C	I
    //   28: istore 7
    //   30: aload_1
    //   31: getfield 226	com/tencent/token/ail:y	Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 228	com/tencent/token/aji:a	(IIIIZZ)Lcom/tencent/token/aje;
    //   51: astore 9
    //   53: aload 9
    //   55: getfield 231	com/tencent/token/aje:d	Lcom/tencent/token/akc;
    //   58: ifnull +22 -> 80
    //   61: new 233	com/tencent/token/akb
    //   64: dup
    //   65: aload_1
    //   66: aload_2
    //   67: aload_0
    //   68: aload 9
    //   70: getfield 231	com/tencent/token/aje:d	Lcom/tencent/token/akc;
    //   73: invokespecial 236	com/tencent/token/akb:<init>	(Lcom/tencent/token/ail;Lcom/tencent/token/aij$a;Lcom/tencent/token/aji;Lcom/tencent/token/akc;)V
    //   76: astore_1
    //   77: goto +85 -> 162
    //   80: aload 9
    //   82: getfield 239	com/tencent/token/aje:b	Ljava/net/Socket;
    //   85: aload_2
    //   86: invokeinterface 216 1 0
    //   91: invokevirtual 245	java/net/Socket:setSoTimeout	(I)V
    //   94: aload 9
    //   96: getfield 248	com/tencent/token/aje:e	Lcom/tencent/token/ala;
    //   99: invokeinterface 253 1 0
    //   104: aload_2
    //   105: invokeinterface 216 1 0
    //   110: i2l
    //   111: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   114: invokevirtual 264	com/tencent/token/alp:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/alp;
    //   117: pop
    //   118: aload 9
    //   120: getfield 267	com/tencent/token/aje:f	Lcom/tencent/token/akz;
    //   123: invokeinterface 270 1 0
    //   128: aload_2
    //   129: invokeinterface 218 1 0
    //   134: i2l
    //   135: getstatic 259	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   138: invokevirtual 264	com/tencent/token/alp:a	(JLjava/util/concurrent/TimeUnit;)Lcom/tencent/token/alp;
    //   141: pop
    //   142: new 272	com/tencent/token/ajv
    //   145: dup
    //   146: aload_1
    //   147: aload_0
    //   148: aload 9
    //   150: getfield 248	com/tencent/token/aje:e	Lcom/tencent/token/ala;
    //   153: aload 9
    //   155: getfield 267	com/tencent/token/aje:f	Lcom/tencent/token/akz;
    //   158: invokespecial 275	com/tencent/token/ajv:<init>	(Lcom/tencent/token/ail;Lcom/tencent/token/aji;Lcom/tencent/token/ala;Lcom/tencent/token/akz;)V
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 50	com/tencent/token/aji:c	Lcom/tencent/token/ahz;
    //   166: astore_2
    //   167: aload_2
    //   168: monitorenter
    //   169: aload_0
    //   170: aload_1
    //   171: putfield 73	com/tencent/token/aji:g	Lcom/tencent/token/ajl;
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
    //   184: new 277	com/tencent/token/ajg
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 280	com/tencent/token/ajg:<init>	(Ljava/io/IOException;)V
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	aji
    //   0	193	1	paramail	ail
    //   0	193	3	paramBoolean	boolean
    //   6	32	4	i1	int
    //   14	26	5	i2	int
    //   22	20	6	i3	int
    //   28	16	7	i4	int
    //   34	12	8	bool	boolean
    //   51	103	9	localaje	aje
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
        ((aje)localObject).g = true;
      }
      if ((this.g == null) && ((this.n) || (this.f.g)))
      {
        a(this.f);
        if (this.f.j.isEmpty())
        {
          this.f.k = System.nanoTime();
          if (aiu.a.a(this.c, this.f))
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
  
  public final void a(aje paramaje, boolean paramBoolean)
  {
    if ((!h) && (!Thread.holdsLock(this.c))) {
      throw new AssertionError();
    }
    if (this.f == null)
    {
      this.f = paramaje;
      this.m = paramBoolean;
      paramaje.j.add(new a(this, this.j));
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
        if ((paramIOException instanceof akj))
        {
          paramIOException = ((akj)paramIOException).a;
          if (paramIOException == ajx.e)
          {
            this.l += 1;
            if (this.l <= 1) {
              break label220;
            }
          }
          else
          {
            if (paramIOException == ajx.f) {
              break label220;
            }
            this.b = null;
            bool = true;
            continue;
          }
        }
        else
        {
          if ((this.f == null) || ((this.f.a()) && (!(paramIOException instanceof ajw)))) {
            break label230;
          }
          if (this.f.h != 0) {
            break label225;
          }
          if ((this.b != null) && (paramIOException != null))
          {
            ajh localajh = this.k;
            ais localais = this.b;
            if ((localais.b.type() != Proxy.Type.DIRECT) && (localajh.a.g != null)) {
              localajh.a.g.connectFailed(localajh.a.a.a(), localais.b.address(), paramIOException);
            }
            localajh.b.a(localais);
          }
        }
        this.b = null;
        bool = true;
        paramIOException = a(bool, false, true);
        aiw.a(paramIOException);
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
  
  public final void a(boolean paramBoolean, ajl paramajl)
  {
    ahz localahz = this.c;
    if (paramajl != null) {}
    try
    {
      if (paramajl == this.g)
      {
        if (!paramBoolean)
        {
          paramajl = this.f;
          paramajl.h += 1;
        }
        paramajl = a(paramBoolean, false, true);
        aiw.a(paramajl);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("expected ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramajl);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
  }
  
  public final aje b()
  {
    try
    {
      aje localaje = this.f;
      return localaje;
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
      aiw.a(localSocket);
      return;
    }
  }
  
  public final void d()
  {
    synchronized (this.c)
    {
      Socket localSocket = a(true, false, false);
      aiw.a(localSocket);
      return;
    }
  }
  
  public final boolean e()
  {
    if (this.b == null)
    {
      ajh.a locala = this.i;
      if (((locala == null) || (!locala.a())) && (!this.k.a())) {
        return false;
      }
    }
    return true;
  }
  
  public final String toString()
  {
    aje localaje = b();
    if (localaje != null) {
      return localaje.toString();
    }
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<aji>
  {
    public final Object a;
    
    a(aji paramaji, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aji
 * JD-Core Version:    0.7.0.1
 */