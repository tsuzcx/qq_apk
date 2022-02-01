package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
      QMLog.i("miniapp-embedded", "createWidgetClient, tagName:" + paramString + ", attributes:" + paramMap.toString());
      if (paramString.equalsIgnoreCase("VIDEO"))
      {
        paramString = new EmbeddedWidgetClientHolder(paramString, paramMap, paramIEmbeddedWidget);
        this.embeddedWidgetClientHolderMap.put(Long.valueOf(paramIEmbeddedWidget.getWidgetId()), paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("miniapp-embedded", "createWidgetClient error.", paramString);
    }
    return null;
  }
  
  public Map<Long, EmbeddedWidgetClientHolder> getEmbeddedWidgetClientHolderMap()
  {
    return this.embeddedWidgetClientHolderMap;
  }
  
  public boolean handleEmbeddedWidgetEvent(String paramString1, IMiniAppContext paramIMiniAppContext, String paramString2, int paramInt)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      int i = paramString2.optInt("viewId", -1);
      if ((this.mappingTableMap != null) && (this.mappingTableMap.containsKey(Integer.valueOf(i))))
      {
        long l = ((Long)this.mappingTableMap.get(Integer.valueOf(i))).longValue();
        if ((this.embeddedWidgetClientHolderMap != null) && (this.embeddedWidgetClientHolderMap.containsKey(Long.valueOf(l))))
        {
          EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)this.embeddedWidgetClientHolderMap.get(Long.valueOf(l));
          if (localEmbeddedWidgetClientHolder != null)
          {
            localEmbeddedWidgetClientHolder.handleEmbeddedWidgetEvent(paramString1, paramIMiniAppContext, paramString2, paramInt);
            return true;
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("miniapp-embedded", "handleEmbeddedWidgetEvent error.", paramString1);
    }
    return false;
  }
  
  public boolean handleInsertEmbeddedWidgetEvent(String paramString1, String paramString2, IJsService paramIJsService1, IJsService paramIJsService2)
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
          localEmbeddedWidgetClientHolder.handleInsertEmbeddedWidgetEvent(paramString1, paramString2, paramIJsService1, paramIJsService2);
          return true;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("miniapp-embedded", "handleInsertEmbeddedWidgetEvent error.", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory
 * JD-Core Version:    0.7.0.1
 */