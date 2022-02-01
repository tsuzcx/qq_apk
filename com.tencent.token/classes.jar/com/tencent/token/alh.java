package com.tencent.token;

import java.net.ProtocolException;

public final class alh
  implements akg
{
  private final boolean a;
  
  public alh(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final akn a(akg.a parama)
  {
    parama = (alm)parama;
    ali localali = parama.b;
    alf localalf = parama.a;
    alb localalb = (alb)parama.c;
    akl localakl = parama.d;
    long l = System.currentTimeMillis();
    localali.a(localakl);
    boolean bool = all.a(localakl.b);
    Object localObject2 = null;
    Object localObject1 = null;
    parama = localObject2;
    if (bool)
    {
      parama = localObject2;
      if (localakl.d != null)
      {
        if ("100-continue".equalsIgnoreCase(localakl.a("Expect")))
        {
          localali.a();
          localObject1 = localali.a(true);
        }
        if (localObject1 == null)
        {
          parama = ane.a(new a(localali.a(localakl, localakl.d.b())));
          localakl.d.a(parama);
          parama.close();
          parama = (akg.a)localObject1;
        }
        else
        {
          parama = (akg.a)localObject1;
          if (!localalb.a())
          {
            localalf.d();
            parama = (akg.a)localObject1;
          }
        }
      }
    }
    localali.b();
    localObject1 = parama;
    if (parama == null) {
      localObject1 = localali.a(false);
    }
    ((akn.a)localObject1).a = localakl;
    ((akn.a)localObject1).e = localalf.b().c;
    ((akn.a)localObject1).k = l;
    ((akn.a)localObject1).l = System.currentTimeMillis();
    parama = ((akn.a)localObject1).a();
    int j = parama.c;
    int i = j;
    if (j == 100)
    {
      parama = localali.a(false);
      parama.a = localakl;
      parama.e = localalf.b().c;
      parama.k = l;
      parama.l = System.currentTimeMillis();
      parama = parama.a();
      i = parama.c;
    }
    if ((this.a) && (i == 101))
    {
      parama = parama.a();
      parama.g = akt.c;
      parama = parama.a();
    }
    else
    {
      localObject1 = parama.a();
      ((akn.a)localObject1).g = localali.a(parama);
      parama = ((akn.a)localObject1).a();
    }
    if (("close".equalsIgnoreCase(parama.a.a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localalf.d();
    }
    if (((i != 204) && (i != 205)) || (parama.g.a() <= 0L)) {
      return parama;
    }
    localObject1 = new StringBuilder("HTTP ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" had non-zero Content-Length: ");
    ((StringBuilder)localObject1).append(parama.g.a());
    throw new ProtocolException(((StringBuilder)localObject1).toString());
  }
  
  static final class a
    extends amz
  {
    long a;
    
    a(ank paramank)
    {
      super();
    }
    
    public final void a_(amv paramamv, long paramLong)
    {
      super.a_(paramamv, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alh
 * JD-Core Version:    0.7.0.1
 */