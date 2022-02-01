package com.tencent.map.sdk.a;

public abstract class of<D extends nz>
  extends nx<D>
{
  private static b a = new of.1();
  private c b;
  
  public of(c paramc)
  {
    this.b = paramc;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract String a(String paramString);
  }
  
  public static abstract class c
    implements ny.a
  {
    of.a g;
    public int h = 104857600;
    public of.b i = of.d();
    
    public c(of.a parama)
    {
      this.g = parama;
    }
    
    public String toString()
    {
      return "Options{mType=" + this.g + ", mCacheSize=" + this.h + ", keyGenerator=" + this.i + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.of
 * JD-Core Version:    0.7.0.1
 */