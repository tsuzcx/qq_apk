package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BrowserPluginEngine
{
  private static final String TAG = "BrowserPluginEngine";
  public Activity mActivity;
  Fragment mBrowserFragment;
  private volatile WebView mWebview;
  private final ConcurrentHashMap<String, BrowserPlugin> pluginEventHashMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, BrowserPlugin> pluginHashMap = new ConcurrentHashMap();
  
  public BrowserPluginEngine(Activity paramActivity, WebView paramWebView)
  {
    this.mActivity = paramActivity;
    this.mWebview = paramWebView;
    preCreatePlugin();
  }
  
  private BrowserPlugin createPlugin(String paramString)
  {
    BrowserPlugin localBrowserPlugin = BrowserPluginFactory.createWebViewPlugin(paramString);
    insertPlugin(paramString, localBrowserPlugin);
    initPlugin(localBrowserPlugin);
    return localBrowserPlugin;
  }
  
  private static boolean handleJsBridgeUrlRequest(BrowserPluginEngine paramBrowserPluginEngine, WebView paramWebView, String paramString)
  {
    int i = 0;
    Object localObject1 = (paramString + "/#").split("/");
    if (localObject1.length < 5)
    {
      QMLog.e("BrowserPluginEngine", "illegal jsbridge:" + paramString);
      return true;
    }
    String str = localObject1[2];
    Object localObject3;
    String[] arrayOfString;
    Object localObject2;
    int j;
    if (localObject1.length == 5)
    {
      localObject1 = localObject1[3].split("#");
      if (localObject1.length > 1) {}
      for (;;)
      {
        try
        {
          i = Integer.parseInt(localObject1[1]);
          long l = i;
          localObject1 = localObject1[0].split("\\?");
          localObject3 = localObject1[0];
          if (localObject1.length <= 1) {
            break label427;
          }
          arrayOfString = localObject1[1].split("&");
          localObject1 = arrayOfString;
          localObject2 = localObject3;
          if (arrayOfString.length <= 0) {
            break label355;
          }
          localObject1 = new ArrayList();
          j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            break;
          }
          int k = arrayOfString[i].indexOf('=');
          if (k != -1)
          {
            if (!"mqq_tt".equals(arrayOfString[i].substring(0, k)))
            {
              new StringBuilder().append(str).append(".").append((String)localObject3).toString();
              ((List)localObject1).add(URLDecoder.decode(arrayOfString[i].substring(k + 1)));
            }
            i += 1;
          }
          else
          {
            ((List)localObject1).add("");
          }
        }
        catch (NumberFormatException paramBrowserPluginEngine)
        {
          QMLog.e("BrowserPluginEngine", "" + new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramBrowserPluginEngine.toString()));
          return true;
        }
      }
      localObject1 = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
      localObject2 = localObject3;
    }
    for (;;)
    {
      label355:
      paramWebView.getUrl();
      new StringBuilder().append(str).append(".").append(localObject2).toString();
      localObject3 = paramBrowserPluginEngine.getPluginByNameSpace(str);
      paramWebView = (WebView)localObject3;
      if (localObject3 == null) {
        paramWebView = paramBrowserPluginEngine.createPlugin(str);
      }
      if (paramWebView == null) {
        break;
      }
      handleJsRequest(paramWebView, paramString, str, localObject2, (String[])localObject1);
      return true;
      label427:
      localObject1 = new String[0];
      localObject2 = localObject3;
      continue;
      localObject3 = localObject1[3];
      try
      {
        Long.parseLong(localObject1[4]);
        j = localObject1.length - 6;
        arrayOfString = new String[j];
        System.arraycopy(localObject1, 5, arrayOfString, 0, j);
        j = arrayOfString.length;
        for (;;)
        {
          localObject1 = arrayOfString;
          localObject2 = localObject3;
          if (i >= j) {
            break;
          }
          arrayOfString[i] = URLDecoder.decode(arrayOfString[i]);
          i += 1;
        }
        return true;
      }
      catch (Exception paramBrowserPluginEngine)
      {
        QMLog.e("BrowserPluginEngine", "" + new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(paramBrowserPluginEngine.toString()));
      }
    }
  }
  
  private static boolean handleJsRequest(BrowserPlugin paramBrowserPlugin, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (paramBrowserPlugin == null) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = System.currentTimeMillis();
        long l2;
        if (paramBrowserPlugin.handleJsRequest(paramString1, paramString2, paramString3, paramArrayOfString))
        {
          l2 = System.currentTimeMillis();
          if (QMLog.isColorLevel()) {
            QMLog.d("BrowserPluginEngine", "" + new StringBuilder("plugin[").append(paramBrowserPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms."));
          }
        }
        else
        {
          if (!QMLog.isColorLevel()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          QMLog.d("BrowserPluginEngine", "" + new StringBuilder("plugin[").append(paramBrowserPlugin.getClass().getSimpleName()).append("] ignore JsApi[").append(paramString2).append(".").append(paramString3).append("] cost ").append(l2 - l1).append(" ms."));
          return false;
        }
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        QMLog.e("BrowserPluginEngine", "" + new StringBuilder("plugin[").append(paramBrowserPlugin.getClass().getSimpleName()).append("] handle JsApi[").append(paramString2).append(".").append(paramString3).append("] error:").append(paramString1.toString()));
        return false;
      }
      finally {}
    }
    return true;
  }
  
  private void initPlugin(BrowserPlugin paramBrowserPlugin)
  {
    if (paramBrowserPlugin != null)
    {
      paramBrowserPlugin.initRuntime(this.mActivity);
      paramBrowserPlugin.setFragment(this.mBrowserFragment);
      paramBrowserPlugin.onCreate();
      if (this.mWebview != null) {
        paramBrowserPlugin.onWebViewCreated(this.mWebview);
      }
    }
  }
  
  private void insertPlugin(String paramString, BrowserPlugin paramBrowserPlugin)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBrowserPlugin == null)) {
      return;
    }
    if (this.pluginHashMap.containsKey(paramString))
    {
      QMLog.e("BrowserPluginEngine", "insertPlugin:namespace " + paramString + " already exists!");
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.i("BrowserPluginEngine", "insertPlugin:add pair [" + paramString + "] -> " + paramBrowserPlugin.getClass().getSimpleName());
    }
    this.pluginHashMap.put(paramString, paramBrowserPlugin);
  }
  
  private boolean internalShouldOverrideUrlRequest(String paramString)
  {
    String str = BrowserUtils.getSchemeFromUrl(paramString);
    if (TextUtils.isEmpty(str)) {}
    while (!"jsbridge".equals(str)) {
      return false;
    }
    return handleJsBridgeUrlRequest(this, this.mWebview, paramString);
  }
  
  private void preCreatePlugin()
  {
    createPlugin("miniApp");
  }
  
  public void bindFragment(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      return;
      this.mBrowserFragment = paramFragment;
      Iterator localIterator = this.pluginHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        BrowserPlugin localBrowserPlugin = (BrowserPlugin)localIterator.next();
        if (localBrowserPlugin != null) {
          localBrowserPlugin.setFragment(paramFragment);
        }
      }
    }
  }
  
  public BrowserPlugin getPluginByNameSpace(String paramString)
  {
    if (this.pluginHashMap.containsKey(paramString)) {
      return (BrowserPlugin)this.pluginHashMap.get(paramString);
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.pluginHashMap.values();
    if (QMLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder(((Collection)localObject).size() * 64);; localStringBuilder = new StringBuilder())
    {
      localObject = ((Collection)localObject).iterator();
      BrowserPlugin localBrowserPlugin;
      long l;
      do
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localBrowserPlugin = (BrowserPlugin)((Iterator)localObject).next();
        } while (localBrowserPlugin == null);
        l = System.currentTimeMillis();
      } while (!localBrowserPlugin.handleEvent(paramString, paramLong, paramMap));
      if (QMLog.isColorLevel())
      {
        paramLong = System.currentTimeMillis() - l;
        if (paramLong > 50L)
        {
          localStringBuilder.append("plugin[").append(localBrowserPlugin.getClass().getSimpleName()).append("] handled event[").append("] success cost ").append(paramLong).append(" ms.");
          QMLog.i("BrowserPluginEngine", localStringBuilder.toString());
        }
      }
      return true;
    }
    if ((QMLog.isColorLevel()) && (localStringBuilder.length() > 0))
    {
      localStringBuilder.append("handleEvent error: no plugin can handleEvent(").append(")");
      QMLog.i("BrowserPluginEngine", localStringBuilder.toString());
    }
    return false;
  }
  
  public void onDestroy()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.pluginHashMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        BrowserPlugin localBrowserPlugin = (BrowserPlugin)localIterator.next();
        if ((localBrowserPlugin == null) || (localHashMap.containsKey(localBrowserPlugin))) {
          continue;
        }
        long l = System.currentTimeMillis();
        try
        {
          localBrowserPlugin.onDestroy();
          localHashMap.put(localBrowserPlugin, Boolean.valueOf(true));
          if (QMLog.isColorLevel())
          {
            l = System.currentTimeMillis() - l;
            if (l > 50L) {
              QMLog.d("BrowserPluginEngine", "" + new StringBuilder("plugin[").append(localBrowserPlugin.getClass().getSimpleName()).append("] onDestroy cost ").append(l).append(" ms."));
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QMLog.isColorLevel()) {
              QMLog.d("BrowserPluginEngine", "", localException);
            }
          }
        }
      }
    }
    this.pluginHashMap.clear();
    this.mWebview = null;
    this.mActivity = null;
    this.mBrowserFragment = null;
  }
  
  public boolean shouldOverrideUrlRequest(String paramString)
  {
    return internalShouldOverrideUrlRequest(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserPluginEngine
 * JD-Core Version:    0.7.0.1
 */