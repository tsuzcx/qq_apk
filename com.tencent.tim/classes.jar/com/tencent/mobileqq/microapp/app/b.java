package com.tencent.mobileqq.microapp.app;

import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public final class b
  extends Observable
{
  private static b a;
  private static byte[] b = new byte[0];
  
  public static b a()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppStateManager", 2, "notifyChange...msg=" + paramObject);
    }
    setChanged();
    if (paramObject != null)
    {
      notifyObservers(paramObject);
      return;
    }
    notifyObservers();
  }
  
  public static final class a
  {
    public int a;
    public f b;
    public String c;
    public int d;
    
    public a(int paramInt1, String paramString, int paramInt2, f paramf)
    {
      this.a = paramInt1;
      this.c = paramString;
      this.d = paramInt2;
      this.b = paramf;
    }
    
    public String toString()
    {
      return "MiniAppStateMsg{state=" + this.a + ", apkgInfo=" + this.b + ", appId='" + this.c + '\'' + ", versionType='" + this.d + '\'' + '}';
    }
  }
  
  public static class b
    implements Observer
  {
    public void a(b.a parama) {}
    
    public void a(b.c paramc) {}
    
    public void update(Observable paramObservable, Object paramObject)
    {
      if ((paramObject instanceof b.a)) {
        a((b.a)paramObject);
      }
      while (!(paramObject instanceof b.c)) {
        return;
      }
      a((b.c)paramObject);
    }
  }
  
  public static final class c
  {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    
    public c(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.b = paramInt;
      this.c = paramString2;
      this.d = paramString3;
      this.e = paramString4;
    }
    
    public String toString()
    {
      return "ShareMsg{appId=" + this.a + ", versionType=" + this.b + ", content=" + this.c + ", sharePicPath=" + this.d + ", entryPath='" + this.e + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.b
 * JD-Core Version:    0.7.0.1
 */