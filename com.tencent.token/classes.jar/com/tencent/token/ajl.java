package com.tencent.token;

import java.net.ProtocolException;

public final class ajl
  implements aik
{
  private final boolean a;
  
  public ajl(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final air a(aik.a parama)
  {
    parama = (ajq)parama;
    ajm localajm = parama.b;
    ajj localajj = parama.a;
    ajf localajf = (ajf)parama.c;
    aip localaip = parama.d;
    long l = System.currentTimeMillis();
    localajm.a(localaip);
    boolean bool = ajp.a(localaip.b);
    Object localObject2 = null;
    Object localObject1 = null;
    parama = localObject2;
    if (bool)
    {
      parama = localObject2;
      if (localaip.d != null)
      {
        if ("100-continue".equalsIgnoreCase(localaip.a("Expect")))
        {
          localajm.a();
          localObject1 = localajm.a(true);
        }
        if (localObject1 == null)
        {
          parama = ali.a(new a(localajm.a(localaip, localaip.d.b())));
          localaip.d.a(parama);
          parama.close();
          parama = (aik.a)localObject1;
        }
        else
        {
          parama = (aik.a)localObject1;
          if (!localajf.a())
          {
            localajj.d();
            parama = (aik.a)localObject1;
          }
        }
      }
    }
    localajm.b();
    localObject1 = parama;
    if (parama == null) {
      localObject1 = localajm.a(false);
    }
    ((air.a)localObject1).a = localaip;
    ((air.a)localObject1).e = localajj.b().c;
    ((air.a)localObject1).k = l;
    ((air.a)localObject1).l = System.currentTimeMillis();
    parama = ((air.a)localObject1).a();
    int j = parama.c;
    int i = j;
    if (j == 100)
    {
      parama = localajm.a(false);
      parama.a = localaip;
      parama.e = localajj.b().c;
      parama.k = l;
      parama.l = System.currentTimeMillis();
      parama = parama.a();
      i = parama.c;
    }
    if ((this.a) && (i == 101))
    {
      parama = parama.a();
      parama.g = aix.c;
      parama = parama.a();
    }
    else
    {
      localObject1 = parama.a();
      ((air.a)localObject1).g = localajm.a(parama);
      parama = ((air.a)localObject1).a();
    }
    if (("close".equalsIgnoreCase(parama.a.a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localajj.d();
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
    extends ald
  {
    long a;
    
    a(alo paramalo)
    {
      super();
    }
    
    public final void a_(akz paramakz, long paramLong)
    {
      super.a_(paramakz, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajl
 * JD-Core Version:    0.7.0.1
 */