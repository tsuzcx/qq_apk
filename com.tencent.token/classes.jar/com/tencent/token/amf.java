package com.tencent.token;

import java.net.ProtocolException;

public final class amf
  implements ale
{
  private final boolean a;
  
  public amf(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final all a(ale.a parama)
  {
    parama = (amk)parama;
    amg localamg = parama.b;
    amd localamd = parama.a;
    alz localalz = (alz)parama.c;
    alj localalj = parama.d;
    long l = System.currentTimeMillis();
    localamg.a(localalj);
    boolean bool = amj.a(localalj.b);
    Object localObject2 = null;
    Object localObject1 = null;
    parama = localObject2;
    if (bool)
    {
      parama = localObject2;
      if (localalj.d != null)
      {
        if ("100-continue".equalsIgnoreCase(localalj.a("Expect")))
        {
          localamg.a();
          localObject1 = localamg.a(true);
        }
        if (localObject1 == null)
        {
          parama = aoc.a(new a(localamg.a(localalj, localalj.d.b())));
          localalj.d.a(parama);
          parama.close();
          parama = (ale.a)localObject1;
        }
        else
        {
          parama = (ale.a)localObject1;
          if (!localalz.a())
          {
            localamd.d();
            parama = (ale.a)localObject1;
          }
        }
      }
    }
    localamg.b();
    localObject1 = parama;
    if (parama == null) {
      localObject1 = localamg.a(false);
    }
    ((all.a)localObject1).a = localalj;
    ((all.a)localObject1).e = localamd.b().c;
    ((all.a)localObject1).k = l;
    ((all.a)localObject1).l = System.currentTimeMillis();
    parama = ((all.a)localObject1).a();
    int j = parama.c;
    int i = j;
    if (j == 100)
    {
      parama = localamg.a(false);
      parama.a = localalj;
      parama.e = localamd.b().c;
      parama.k = l;
      parama.l = System.currentTimeMillis();
      parama = parama.a();
      i = parama.c;
    }
    if ((this.a) && (i == 101))
    {
      parama = parama.a();
      parama.g = alr.c;
      parama = parama.a();
    }
    else
    {
      localObject1 = parama.a();
      ((all.a)localObject1).g = localamg.a(parama);
      parama = ((all.a)localObject1).a();
    }
    if (("close".equalsIgnoreCase(parama.a.a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localamd.d();
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
    extends anx
  {
    long a;
    
    a(aoi paramaoi)
    {
      super();
    }
    
    public final void a_(ant paramant, long paramLong)
    {
      super.a_(paramant, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amf
 * JD-Core Version:    0.7.0.1
 */