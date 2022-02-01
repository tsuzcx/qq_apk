package com.tencent.util.d;

public class a
{
  public static abstract interface a
  {
    public abstract String a(String paramString);
    
    public abstract boolean a();
  }
  
  public static class b
  {
    private static b a = new b();
    private a.a b = null;
    
    public static b a()
    {
      return a;
    }
    
    public String a(String paramString)
    {
      if (this.b != null) {
        return this.b.a(paramString);
      }
      return "";
    }
    
    public boolean b()
    {
      if (this.b != null) {
        return this.b.a();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.d.a
 * JD-Core Version:    0.7.0.1
 */