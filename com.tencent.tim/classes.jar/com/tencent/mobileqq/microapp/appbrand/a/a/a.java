package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import java.util.Set;

public abstract class a
{
  f a;
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    return "";
  }
  
  public abstract Set a();
  
  protected void a(f paramf)
  {
    this.a = paramf;
  }
  
  public boolean a(String paramString)
  {
    Set localSet = a();
    if (localSet != null) {
      return localSet.contains(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.a
 * JD-Core Version:    0.7.0.1
 */