package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.List;
import mqq.manager.Manager;

public abstract interface EmoticonManager
  extends Manager
{
  public abstract Emoticon a(String paramString1, String paramString2);
  
  public abstract EmoticonPackage a(String paramString);
  
  public abstract List a();
  
  public abstract List a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Emoticon paramEmoticon);
  
  public abstract void a(EmoticonPackage paramEmoticonPackage);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, int paramInt2);
  
  public abstract void a(String paramString, Boolean paramBoolean);
  
  public abstract void a(List paramList);
  
  public abstract EmoticonPackage b(String paramString);
  
  public abstract List b();
  
  public abstract List b(String paramString);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void b(String paramString1, int paramInt1, String paramString2, int paramInt2);
  
  public abstract void b(List paramList);
  
  public abstract void c();
  
  public abstract void c(String paramString);
  
  public abstract void c(List paramList);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager
 * JD-Core Version:    0.7.0.1
 */