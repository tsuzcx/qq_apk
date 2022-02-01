package com.tencent.token;

public final class aec
  implements ahk
{
  public aec(Class paramClass, ahh paramahh) {}
  
  public final <T2> ahh<T2> a(ahx paramahx, aek<T2> paramaek)
  {
    paramahx = paramaek.a;
    if (!this.a.isAssignableFrom(paramahx)) {
      return null;
    }
    return new a();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Factory[typeHierarchy=");
    localStringBuilder.append(this.a.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final class a
    extends ahh<T1>
  {
    public a() {}
    
    public final void a(aep paramaep, T1 paramT1)
    {
      aec.this.b.a(paramaep, paramT1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aec
 * JD-Core Version:    0.7.0.1
 */