package com.tencent.android.tpush.stat.b;

import com.tencent.android.tpush.logging.TLogger;

public final class c
{
  private String a = "default";
  private boolean b = true;
  private int c = 2;
  
  public c() {}
  
  public c(String paramString)
  {
    this.a = paramString;
  }
  
  private String b()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return null;
    }
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    label18:
    StackTraceElement localStackTraceElement;
    if (i < j)
    {
      localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.isNativeMethod()) {
        break label43;
      }
    }
    label43:
    while ((localStackTraceElement.getClassName().equals(Thread.class.getName())) || (localStackTraceElement.getClassName().equals(getClass().getName())))
    {
      i += 1;
      break label18;
      break;
    }
    return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
  }
  
  public void a(Object paramObject)
  {
    String str;
    if (this.c <= 4)
    {
      str = b();
      if (str != null) {
        break label31;
      }
    }
    label31:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      TLogger.i(this.a, paramObject);
      return;
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (this.c <= 6) {
      TLogger.e(this.a, "", paramThrowable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(Object paramObject)
  {
    if (a()) {
      a(paramObject);
    }
  }
  
  public void b(Throwable paramThrowable)
  {
    if (a()) {
      a(paramThrowable);
    }
  }
  
  public void c(Object paramObject)
  {
    String str;
    if (this.c <= 5)
    {
      str = b();
      if (str != null) {
        break label31;
      }
    }
    label31:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      TLogger.w(this.a, paramObject);
      return;
    }
  }
  
  public void d(Object paramObject)
  {
    if (a()) {
      c(paramObject);
    }
  }
  
  public void e(Object paramObject)
  {
    String str;
    if (this.c <= 6)
    {
      str = b();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      TLogger.e(this.a, paramObject);
      return;
    }
  }
  
  public void f(Object paramObject)
  {
    if (a()) {
      e(paramObject);
    }
  }
  
  public void g(Object paramObject)
  {
    String str;
    if (this.c <= 3)
    {
      str = b();
      if (str != null) {
        break label31;
      }
    }
    label31:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      TLogger.d(this.a, paramObject);
      return;
    }
  }
  
  public void h(Object paramObject)
  {
    if (a()) {
      g(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.c
 * JD-Core Version:    0.7.0.1
 */