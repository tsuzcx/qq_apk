package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.WebViewWizardBase;

public class CookieManager
{
  private static CookieManager mInstance;
  private android.webkit.CookieManager sysCookieManager = android.webkit.CookieManager.getInstance();
  
  public static CookieManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new CookieManager();
      }
      CookieManager localCookieManager = mInstance;
      return localCookieManager;
    }
    finally {}
  }
  
  public boolean acceptCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().cookieManager_acceptCookie();
    }
    return this.sysCookieManager.acceptCookie();
  }
  
  public String getCookie(String paramString)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().getCookie(paramString);
    }
    return this.sysCookieManager.getCookie(paramString);
  }
  
  public boolean hasCookies()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      return localSDKEngine.wizard().cookieManager_hasCookies();
    }
    return this.sysCookieManager.hasCookies();
  }
  
  public void removeAllCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().cookieManager_removeAllCookie();
      return;
    }
    this.sysCookieManager.removeAllCookie();
  }
  
  public void removeExpiredCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().cookieManager_removeExpiredCookie();
      return;
    }
    this.sysCookieManager.removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().cookieManager_removeSessionCookie();
      return;
    }
    this.sysCookieManager.removeSessionCookie();
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 32	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +21 -> 29
    //   11: aload_2
    //   12: invokevirtual 35	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   15: ifeq +14 -> 29
    //   18: aload_2
    //   19: invokevirtual 39	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/export/external/WebViewWizardBase;
    //   22: iload_1
    //   23: invokevirtual 80	com/tencent/smtt/export/external/WebViewWizardBase:cookieManager_setAcceptCookie	(Z)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 20	com/tencent/smtt/sdk/CookieManager:sysCookieManager	Landroid/webkit/CookieManager;
    //   33: iload_1
    //   34: invokevirtual 82	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	CookieManager
    //   0	45	1	paramBoolean	boolean
    //   6	13	2	localSDKEngine	SDKEngine
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	40	finally
    //   11	26	40	finally
    //   29	37	40	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().cookieManager_setCookie(paramString1, paramString2);
      return;
    }
    this.sysCookieManager.setCookie(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */