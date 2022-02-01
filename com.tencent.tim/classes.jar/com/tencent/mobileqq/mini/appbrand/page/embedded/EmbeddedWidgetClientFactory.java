package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClientFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class EmbeddedWidgetClientFactory
  implements IEmbeddedWidgetClientFactory
{
  private static final String TAG = "miniapp-embedded";
  private ConcurrentHashMap<Long, EmbeddedWidgetClientHolder> embeddedWidgetClientHolderMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Long> mappingTableMap = new ConcurrentHashMap();
  
  public IEmbeddedWidgetClient createWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    try
    {
      QLog.i("miniapp-embedded", 1, "createWidgetClient, tagName:" + paramString + ", attributes:" + paramMap.toString());
      if (paramString.equalsIgnoreCase("VIDEO"))
      {
        paramString = new EmbeddedWidgetClientHolder(paramString, paramMap, paramIEmbeddedWidget);
        this.embeddedWidgetClientHolderMap.put(Long.valueOf(paramIEmbeddedWidget.getWidgetId()), paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-embedded", 1, "createWidgetClient error.", paramString);
    }
    return null;
  }
  
  public Map<Long, EmbeddedWidgetClientHolder> getEmbeddedWidgetClientHolderMap()
  {
    return this.embeddedWidgetClientHolderMap;
  }
  
  public boolean handleEmbeddedWidgetEvent(JsRuntime paramJsRuntime, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("viewId", -1);
      if ((this.mappingTableMap != null) && (this.mappingTableMap.containsKey(Integer.valueOf(i))))
      {
        Object localObject = (Long)this.mappingTableMap.get(Integer.valueOf(i));
        if ((this.embeddedWidgetClientHolderMap != null) && (this.embeddedWidgetClientHolderMap.containsKey(localObject)))
        {
          localObject = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(localObject);
          if (localObject != null)
          {
            ((EmbeddedWidgetClientHolder)localObject).handleEmbeddedWidgetEvent(paramJsRuntime, paramString1, paramString2, paramInt);
            return true;
          }
        }
      }
    }
    catch (Throwable paramJsRuntime)
    {
      QLog.e("miniapp-embedded", 1, "handleInsertXWebVideo error.", paramJsRuntime);
    }
    return false;
  }
  
  public boolean handleInsertEmbeddedWidgetEvent(String paramString1, String paramString2, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      long l = paramString2.optLong("x5WidgetId", 0L);
      if ((this.embeddedWidgetClientHolderMap != null) && (this.embeddedWidgetClientHolderMap.containsKey(Long.valueOf(l))))
      {
        int i = paramString2.optInt("viewId", -1);
        if ((i != -1) && (this.mappingTableMap != null)) {
          this.mappingTableMap.put(Integer.valueOf(i), Long.valueOf(l));
        }
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(Long.valueOf(l));
        if (localEmbeddedWidgetClientHolder != null)
        {
          localEmbeddedWidgetClientHolder.handleInsertEmbeddedWidgetEvent(paramString1, paramString2, paramJsRuntime, paramBaseAppBrandRuntime);
          return true;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("miniapp-embedded", 1, "handleInsertXWebVideo error.", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory
 * JD-Core Version:    0.7.0.1
 */