package com.tencent.util.h;

public class a
{
  public static void a(a parama)
  {
    b.a().a(parama);
  }
  
  public static void a(String paramString)
  {
    b.a().a(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void jump(String paramString);
  }
  
  public static class b
  {
    private static b a = new b();
    private a.a b;
    
    public static b a()
    {
      return a;
    }
    
    public void a(a.a parama)
    {
      this.b = parama;
    }
    
    public void a(String paramString)
    {
      if (this.b != null) {
        this.b.jump(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.h.a
 * JD-Core Version:    0.7.0.1
 */