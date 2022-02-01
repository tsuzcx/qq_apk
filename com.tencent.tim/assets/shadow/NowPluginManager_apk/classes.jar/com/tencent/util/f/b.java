package com.tencent.util.f;

import android.os.Bundle;

public class b
{
  public static String a(String paramString)
  {
    return b.a(b.a(), paramString);
  }
  
  public static void a(a parama)
  {
    b.a(b.a(), parama);
  }
  
  public static void a(String paramString1, long paramLong, String paramString2, String paramString3, a parama)
  {
    b.a(b.a(), paramString1, paramLong, paramString2, paramString3, parama);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return b.a(b.a(), paramBundle);
  }
  
  public static abstract interface a
  {
    public abstract void getRecordInfo(String paramString1, long paramLong, String paramString2, String paramString3, a parama);
    
    public abstract String getUrlByVid(String paramString);
    
    public abstract boolean isNeedGetRecord(Bundle paramBundle);
  }
  
  private static class b
  {
    private static b a = new b();
    private b.a b;
    
    public static b a()
    {
      return a;
    }
    
    private String a(String paramString)
    {
      if (this.b != null) {
        return this.b.getUrlByVid(paramString);
      }
      return "";
    }
    
    private void a(b.a parama)
    {
      this.b = parama;
    }
    
    private void a(String paramString1, long paramLong, String paramString2, String paramString3, a parama)
    {
      if (this.b != null) {
        this.b.getRecordInfo(paramString1, paramLong, paramString2, paramString3, parama);
      }
    }
    
    private boolean a(Bundle paramBundle)
    {
      if (this.b != null) {
        return this.b.isNeedGetRecord(paramBundle);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.util.f.b
 * JD-Core Version:    0.7.0.1
 */