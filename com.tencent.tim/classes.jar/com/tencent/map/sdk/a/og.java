package com.tencent.map.sdk.a;

public final class og<D extends nz>
  extends oj<D>
{
  private a a;
  private oa.a<D> b;
  
  og(a parama)
  {
    this.a = parama;
    int j = (int)(0.5F * (float)Runtime.getRuntime().maxMemory());
    int k = (int)(0.15F * (float)Runtime.getRuntime().maxMemory());
    int i = j;
    if (this.a != null) {
      i = Math.min(Math.max(this.a.a, k), j);
    }
    this.b = new oa.a(i, parama.b);
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    return (nz)this.b.b(paramString);
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(String paramString, D paramD)
  {
    this.b.a(paramString, paramD);
  }
  
  public static final class a
    implements ny.a
  {
    public int a;
    public ny.b b;
    
    public final String toString()
    {
      return "Options{mMaxCacheSize=" + this.a + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.og
 * JD-Core Version:    0.7.0.1
 */