package com.tencent.token;

public final class adh
  extends ahh<Object>
{
  public static final ahk a = new a();
  public final ahx b;
  
  public adh(ahx paramahx)
  {
    this.b = paramahx;
  }
  
  public final void a(aep paramaep, Object paramObject)
  {
    if (paramObject == null)
    {
      paramaep.e();
      return;
    }
    Object localObject = this.b;
    Class localClass = paramObject.getClass();
    localObject.getClass();
    localObject = ((ahx)localObject).a(new aek(localClass));
    if ((localObject instanceof adh))
    {
      paramaep.c();
      paramaep.d();
      return;
    }
    ((ahh)localObject).a(paramaep, paramObject);
  }
  
  public final class a
    implements ahk
  {
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      if (paramaek.a == Object.class) {
        return new adh(paramahx);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adh
 * JD-Core Version:    0.7.0.1
 */