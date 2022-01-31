package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.ReflectionUtils;

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
  
  /* Error */
  public void acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 32	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +52 -> 60
    //   11: aload_2
    //   12: invokevirtual 35	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   15: ifeq +45 -> 60
    //   18: aload_2
    //   19: invokevirtual 39	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   22: invokevirtual 52	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   25: astore_2
    //   26: aload_1
    //   27: invokevirtual 58	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   30: astore_1
    //   31: aload_2
    //   32: ldc 60
    //   34: ldc 62
    //   36: iconst_1
    //   37: anewarray 64	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: ldc 4
    //   44: aastore
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokevirtual 70	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: getstatic 76	android/os/Build$VERSION:SDK_INT	I
    //   63: bipush 21
    //   65: if_icmplt -8 -> 57
    //   68: aload_0
    //   69: getfield 20	com/tencent/smtt/sdk/CookieManager:sysCookieManager	Landroid/webkit/CookieManager;
    //   72: astore_2
    //   73: aload_1
    //   74: invokevirtual 58	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 77
    //   81: iconst_1
    //   82: anewarray 64	java/lang/Class
    //   85: dup
    //   86: iconst_0
    //   87: ldc 79
    //   89: aastore
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: aastore
    //   98: invokestatic 85	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: goto -45 -> 57
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	CookieManager
    //   0	110	1	paramWebView	WebView
    //   6	73	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	105	finally
    //   11	57	105	finally
    //   60	102	105	finally
  }
  
  public void flush()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(this.sysCookieManager, "flush", new Class[0], new Object[0]);
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
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(this.sysCookieManager, "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    this.sysCookieManager.removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    this.sysCookieManager.removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(this.sysCookieManager, "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
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
    //   8: ifnull +49 -> 57
    //   11: aload_2
    //   12: invokevirtual 35	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   15: ifeq +42 -> 57
    //   18: aload_2
    //   19: invokevirtual 39	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   22: invokevirtual 52	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   25: ldc 60
    //   27: ldc 133
    //   29: iconst_1
    //   30: anewarray 64	java/lang/Class
    //   33: dup
    //   34: iconst_0
    //   35: getstatic 139	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   38: aastore
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload_1
    //   46: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: aastore
    //   50: invokevirtual 70	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 20	com/tencent/smtt/sdk/CookieManager:sysCookieManager	Landroid/webkit/CookieManager;
    //   61: iload_1
    //   62: invokevirtual 145	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   65: goto -11 -> 54
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	CookieManager
    //   0	73	1	paramBoolean	boolean
    //   6	13	2	localSDKEngine	SDKEngine
    //   68	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	68	finally
    //   11	54	68	finally
    //   57	65	68	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: invokestatic 32	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +69 -> 77
    //   11: aload_3
    //   12: invokevirtual 35	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   15: ifeq +62 -> 77
    //   18: aload_3
    //   19: invokevirtual 39	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   22: invokevirtual 52	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   25: astore_3
    //   26: getstatic 139	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   29: astore 4
    //   31: aload_1
    //   32: invokevirtual 58	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   35: astore_1
    //   36: aload_3
    //   37: ldc 60
    //   39: ldc 149
    //   41: iconst_2
    //   42: anewarray 64	java/lang/Class
    //   45: dup
    //   46: iconst_0
    //   47: ldc 4
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 4
    //   54: aastore
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_2
    //   66: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: aastore
    //   70: invokevirtual 70	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: getstatic 76	android/os/Build$VERSION:SDK_INT	I
    //   80: bipush 21
    //   82: if_icmplt -8 -> 74
    //   85: aload_0
    //   86: getfield 20	com/tencent/smtt/sdk/CookieManager:sysCookieManager	Landroid/webkit/CookieManager;
    //   89: astore_3
    //   90: getstatic 139	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   93: astore 4
    //   95: aload_1
    //   96: invokevirtual 58	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   99: astore_1
    //   100: aload_3
    //   101: ldc 150
    //   103: iconst_2
    //   104: anewarray 64	java/lang/Class
    //   107: dup
    //   108: iconst_0
    //   109: ldc 79
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload 4
    //   116: aastore
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_1
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: iload_2
    //   128: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   131: aastore
    //   132: invokestatic 85	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: goto -62 -> 74
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	CookieManager
    //   0	144	1	paramWebView	WebView
    //   0	144	2	paramBoolean	boolean
    //   6	95	3	localObject	Object
    //   29	86	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	7	139	finally
    //   11	74	139	finally
    //   77	136	139	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      return;
    }
    this.sysCookieManager.setCookie(paramString1, paramString2);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(this.sysCookieManager, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */