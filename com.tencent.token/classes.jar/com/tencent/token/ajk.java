package com.tencent.token;

import java.net.ProtocolException;

public final class ajk
  implements aij
{
  private final boolean a;
  
  public ajk(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final aiq a(aij.a parama)
  {
    parama = (ajp)parama;
    ajl localajl = parama.b;
    aji localaji = parama.a;
    aje localaje = (aje)parama.c;
    aio localaio = parama.d;
    long l = System.currentTimeMillis();
    localajl.a(localaio);
    boolean bool = ajo.a(localaio.b);
    Object localObject2 = null;
    Object localObject1 = null;
    parama = localObject2;
    if (bool)
    {
      parama = localObject2;
      if (localaio.d != null)
      {
        if ("100-continue".equalsIgnoreCase(localaio.a("Expect")))
        {
          localajl.a();
          localObject1 = localajl.a(true);
        }
        if (localObject1 == null)
        {
          parama = alh.a(new a(localajl.a(localaio, localaio.d.b())));
          localaio.d.a(parama);
          parama.close();
          parama = (aij.a)localObject1;
        }
        else
        {
          parama = (aij.a)localObject1;
          if (!localaje.a())
          {
            localaji.d();
            parama = (aij.a)localObject1;
          }
        }
      }
    }
    localajl.b();
    localObject1 = parama;
    if (parama == null) {
      localObject1 = localajl.a(false);
    }
    ((aiq.a)localObject1).a = localaio;
    ((aiq.a)localObject1).e = localaji.b().c;
    ((aiq.a)localObject1).k = l;
    ((aiq.a)localObject1).l = System.currentTimeMillis();
    parama = ((aiq.a)localObject1).a();
    int j = parama.c;
    int i = j;
    if (j == 100)
    {
      parama = localajl.a(false);
      parama.a = localaio;
      parama.e = localaji.b().c;
      parama.k = l;
      parama.l = System.currentTimeMillis();
      parama = parama.a();
      i = parama.c;
    }
    if ((this.a) && (i == 101))
    {
      parama = parama.a();
      parama.g = aiw.c;
      parama = parama.a();
    }
    else
    {
      localObject1 = parama.a();
      ((aiq.a)localObject1).g = localajl.a(parama);
      parama = ((aiq.a)localObject1).a();
    }
    if (("close".equalsIgnoreCase(parama.a.a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localaji.d();
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
    extends alc
  {
    long a;
    
    a(aln paramaln)
    {
      super();
    }
    
    public final void a_(aky paramaky, long paramLong)
    {
      super.a_(paramaky, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajk
 * JD-Core Version:    0.7.0.1
 */