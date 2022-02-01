package com.idlefish.flutterboost;

import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterBoostPlugin
{
  private static final Set<ActionAfterRegistered> sActions = new HashSet();
  private static FlutterBoostPlugin sInstance;
  private final Map<String, Set<EventListener>> mEventListeners = new HashMap();
  private final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers = new HashSet();
  private final MethodChannel mMethodChannel;
  
  private FlutterBoostPlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.mMethodChannel = new MethodChannel(paramRegistrar.messenger(), "flutter_boost");
    this.mMethodChannel.setMethodCallHandler(new FlutterBoostPlugin.1(this));
    addMethodCallHandler(new BoostMethodHandler());
  }
  
  public static void addActionAfterRegistered(ActionAfterRegistered paramActionAfterRegistered)
  {
    if (paramActionAfterRegistered == null) {
      return;
    }
    if (sInstance == null)
    {
      sActions.add(paramActionAfterRegistered);
      return;
    }
    paramActionAfterRegistered.onChannelRegistered(sInstance);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    sInstance = new FlutterBoostPlugin(paramRegistrar);
    paramRegistrar = sActions.iterator();
    while (paramRegistrar.hasNext()) {
      ((ActionAfterRegistered)paramRegistrar.next()).onChannelRegistered(sInstance);
    }
    sActions.clear();
  }
  
  public static FlutterBoostPlugin singleton()
  {
    if (sInstance != null) {
      return sInstance;
    }
    throw new RuntimeException("FlutterBoostPlugin not register yet");
  }
  
  public void addEventListener(String paramString, EventListener paramEventListener)
  {
    synchronized (this.mEventListeners)
    {
      Set localSet = (Set)this.mEventListeners.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramEventListener);
      this.mEventListeners.put(paramString, localObject);
      return;
    }
  }
  
  public void addMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    synchronized (this.mMethodCallHandlers)
    {
      this.mMethodCallHandlers.add(paramMethodCallHandler);
      return;
    }
  }
  
  public void invokeMethod(String paramString, Serializable paramSerializable)
  {
    invokeMethod(paramString, paramSerializable, new FlutterBoostPlugin.3(this, paramString));
  }
  
  public void invokeMethod(String paramString, Serializable paramSerializable, MethodChannel.Result paramResult)
  {
    if ("__event__".equals(paramString)) {
      Debuger.exception("method name should not be __event__");
    }
    this.mMethodChannel.invokeMethod(paramString, paramSerializable, paramResult);
  }
  
  public void invokeMethodUnsafe(String paramString, Serializable paramSerializable)
  {
    invokeMethod(paramString, paramSerializable, new FlutterBoostPlugin.2(this, paramString));
  }
  
  public void removeEventListener(EventListener paramEventListener)
  {
    synchronized (this.mEventListeners)
    {
      Iterator localIterator = this.mEventListeners.values().iterator();
      if (localIterator.hasNext()) {
        ((Set)localIterator.next()).remove(paramEventListener);
      }
    }
  }
  
  public void removeMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    synchronized (this.mMethodCallHandlers)
    {
      this.mMethodCallHandlers.remove(paramMethodCallHandler);
      return;
    }
  }
  
  public void sendEvent(String paramString, Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString);
    localHashMap.put("arguments", paramMap);
    this.mMethodChannel.invokeMethod("__event__", localHashMap);
  }
  
  public static abstract interface ActionAfterRegistered
  {
    public abstract void onChannelRegistered(FlutterBoostPlugin paramFlutterBoostPlugin);
  }
  
  class BoostMethodHandler
    implements MethodChannel.MethodCallHandler
  {
    BoostMethodHandler() {}
    
    public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
    {
      int i = 1;
      FlutterViewContainerManager localFlutterViewContainerManager = (FlutterViewContainerManager)FlutterBoost.instance().containerManager();
      Object localObject = paramMethodCall.method;
      int j = ((String)localObject).hashCode();
      if (j != -1037220475) {
        if (j != -504772615) {
          if (j != -482608985) {
            if (j != 1791664180) {
              label54:
              i = -1;
            }
          }
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramResult.notImplemented();
          return;
          if (!((String)localObject).equals("pageOnStart")) {
            break label54;
          }
          i = 0;
          continue;
          if (!((String)localObject).equals("closePage")) {
            break label54;
          }
          i = 2;
          continue;
          if (!((String)localObject).equals("openPage")) {
            break label54;
          }
          continue;
          if (!((String)localObject).equals("onShownContainerChanged")) {
            break label54;
          }
          i = 3;
        }
      }
      try
      {
        localFlutterViewContainerManager.onShownContainerChanged((String)paramMethodCall.argument("newName"), (String)paramMethodCall.argument("oldName"));
        paramResult.success(Boolean.valueOf(true));
        return;
      }
      catch (Throwable paramMethodCall)
      {
        paramResult.error("onShownContainerChanged", paramMethodCall.getMessage(), paramMethodCall);
        return;
      }
      try
      {
        localFlutterViewContainerManager.closeContainer((String)paramMethodCall.argument("uniqueId"), (Map)paramMethodCall.argument("result"), (Map)paramMethodCall.argument("exts"));
        paramResult.success(Boolean.valueOf(true));
        return;
      }
      catch (Throwable paramMethodCall)
      {
        paramResult.error("close page error", paramMethodCall.getMessage(), paramMethodCall);
        return;
      }
      try
      {
        localObject = (Map)paramMethodCall.argument("urlParams");
        Map localMap = (Map)paramMethodCall.argument("exts");
        localFlutterViewContainerManager.openContainer((String)paramMethodCall.argument("url"), (Map)localObject, localMap, new FlutterBoostPlugin.BoostMethodHandler.1(this, paramResult));
        return;
      }
      catch (Throwable paramMethodCall)
      {
        paramResult.error("open page error", paramMethodCall.getMessage(), paramMethodCall);
        return;
      }
      localObject = new HashMap();
      for (;;)
      {
        try
        {
          paramMethodCall = localFlutterViewContainerManager.getCurrentTopRecord();
          if (paramMethodCall == null)
          {
            paramMethodCall = localFlutterViewContainerManager.getLastGenerateRecord();
            if (paramMethodCall != null)
            {
              ((Map)localObject).put("name", paramMethodCall.getContainer().getContainerUrl());
              ((Map)localObject).put("params", paramMethodCall.getContainer().getContainerUrlParams());
              ((Map)localObject).put("uniqueId", paramMethodCall.uniqueId());
            }
            paramResult.success(localObject);
            FlutterBoost.instance().setFlutterPostFrameCallTime(new Date().getTime());
            return;
          }
        }
        catch (Throwable paramMethodCall)
        {
          paramResult.error("no flutter page found!", paramMethodCall.getMessage(), paramMethodCall);
          return;
        }
      }
    }
  }
  
  public static abstract interface EventListener
  {
    public abstract void onEvent(String paramString, Map paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin
 * JD-Core Version:    0.7.0.1
 */