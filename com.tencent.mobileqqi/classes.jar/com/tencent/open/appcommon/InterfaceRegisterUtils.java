package com.tencent.open.appcommon;

import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.open.appcommon.js.AsyncMethodMap;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterfaceRegisterUtils
{
  protected static Map a = new HashMap();
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator1 = a.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        Object localObject = (Integer)localIterator1.next();
        localObject = (List)a.get(localObject);
        Iterator localIterator2 = ((List)localObject).iterator();
        if (localIterator2.hasNext()) {
          ((BaseInterface)localIterator2.next()).destroy();
        } else {
          ((List)localObject).clear();
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("destoryAll", "destoryAll", localException);
        return;
      }
    }
    a.clear();
  }
  
  public static void a(WebView paramWebView)
  {
    int i;
    try
    {
      i = paramWebView.hashCode();
      paramWebView = (List)a.get(Integer.valueOf(i));
      if (paramWebView == null) {
        return;
      }
      Iterator localIterator = paramWebView.iterator();
      while (localIterator.hasNext()) {
        ((BaseInterface)localIterator.next()).destroy();
      }
      paramWebView.clear();
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
      return;
    }
    a.remove(Integer.valueOf(i));
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    try
    {
      int i = paramWebView.hashCode();
      paramWebView = ((List)a.get(Integer.valueOf(i))).iterator();
      while (paramWebView.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)paramWebView.next();
        if (localBaseInterface != null) {
          localBaseInterface.setCurrentUrl(paramString);
        }
      }
      return;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public static void a(List paramList, WebView paramWebView, String paramString, JsBridge paramJsBridge)
  {
    if (!StringAddition.a(paramString))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)localIterator.next();
        paramJsBridge.a(localBaseInterface, localBaseInterface.getInterfaceName());
        AsyncMethodMap.a.put(localBaseInterface.getInterfaceName(), localBaseInterface.getClass());
        localBaseInterface.setCurrentUrl(paramString);
      }
    }
    a.put(Integer.valueOf(paramWebView.hashCode()), paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.InterfaceRegisterUtils
 * JD-Core Version:    0.7.0.1
 */