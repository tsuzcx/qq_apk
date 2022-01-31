package com.tencent.mobileqq.msf.core.net.a;

public abstract class i
{
  protected c[] f = { new d("http://3gimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new d("http://3gimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2") };
  
  protected a a(c paramc, int paramInt, a.a parama)
  {
    switch (paramc.d)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    return new b(paramInt, ((d)paramc).f, paramc.e, 10000, parama);
  }
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.i
 * JD-Core Version:    0.7.0.1
 */