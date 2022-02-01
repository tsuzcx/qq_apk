package com.qflutter.log.qflutter_log;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class QflutterLogPlugin
  implements MethodChannel.MethodCallHandler
{
  private static Log sLog;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/log_channel").setMethodCallHandler(new QflutterLogPlugin());
  }
  
  public static void setLog(Log paramLog)
  {
    if (sLog != null) {
      sLog.e("changing logger!");
    }
    sLog = paramLog;
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if ("printLog".equals(paramMethodCall.method))
    {
      if (sLog != null) {
        paramResult = (String)paramMethodCall.argument("logContent");
      }
      switch (((Integer)paramMethodCall.argument("logLevel")).intValue())
      {
      default: 
        return;
      case 5: 
        sLog.v(paramResult);
        return;
      case 4: 
        sLog.d(paramResult);
        return;
      case 3: 
        sLog.i(paramResult);
        return;
      case 2: 
        sLog.w(paramResult);
        return;
      }
      sLog.e(paramResult);
      return;
    }
    if ("getLogLevel".equals(paramMethodCall.method))
    {
      if (sLog != null)
      {
        paramResult.success(Integer.valueOf(sLog.getLogLevel()));
        return;
      }
      paramResult.success(Integer.valueOf(1));
      return;
    }
    paramResult.notImplemented();
  }
  
  public static abstract interface Log
  {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int OFF = 0;
    public static final int VERBOSE = 5;
    public static final int WARN = 2;
    
    public abstract void d(String paramString);
    
    public abstract void e(String paramString);
    
    public abstract int getLogLevel();
    
    public abstract void i(String paramString);
    
    public abstract void v(String paramString);
    
    public abstract void w(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qflutter.log.qflutter_log.QflutterLogPlugin
 * JD-Core Version:    0.7.0.1
 */