package com.huawei.updatesdk.service.a;

public class c
  extends com.huawei.updatesdk.a.b.d.a.c
{
  private int isUpdateSdk_ = 1;
  private String locale_ = null;
  private int serviceType_ = 0;
  private String ts_ = null;
  
  private void d(String paramString)
  {
    this.ts_ = paramString;
  }
  
  public void c()
  {
    d(String.valueOf(System.currentTimeMillis()));
  }
  
  public void n(String paramString)
  {
    this.locale_ = paramString;
  }
  
  public String toString()
  {
    return getClass().getName() + " {\n\tmethod_: " + a() + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.a.c
 * JD-Core Version:    0.7.0.1
 */