package com.tencent.token;

public final class ads<T>
  extends ahh<T>
{
  public final aht<T> a;
  public final ahe<T> b;
  public final ahx c;
  public final aek<T> d;
  public final ads<T>.a e = new a((byte)0);
  public ahh<T> f;
  
  public ads(aht<T> paramaht, ahe<T> paramahe, ahx paramahx, aek<T> paramaek)
  {
    this.a = paramaht;
    this.b = paramahe;
    this.c = paramahx;
    this.d = paramaek;
  }
  
  public final void a(aep paramaep, T paramT)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      ahh localahh = this.f;
      localObject = localahh;
      if (localahh == null)
      {
        localObject = this.c.a(null, this.d);
        this.f = ((ahh)localObject);
      }
      ((ahh)localObject).a(paramaep, paramT);
      return;
    }
    if (paramT == null)
    {
      paramaep.e();
      return;
    }
    paramT = ((aht)localObject).a();
    ady.X.a(paramaep, paramT);
  }
  
  public final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ads
 * JD-Core Version:    0.7.0.1
 */