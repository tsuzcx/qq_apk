package io.flutter.plugins.pathprovider;

import android.content.Context;
import android.os.Environment;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.util.PathUtils;
import java.io.File;

public class PathProviderPlugin
  implements MethodChannel.MethodCallHandler
{
  private final PluginRegistry.Registrar mRegistrar;
  
  private PathProviderPlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.mRegistrar = paramRegistrar;
  }
  
  private String getPathProviderApplicationDocumentsDirectory()
  {
    return PathUtils.getDataDirectory(this.mRegistrar.context());
  }
  
  private String getPathProviderStorageDirectory()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  private String getPathProviderTemporaryDirectory()
  {
    return this.mRegistrar.context().getCacheDir().getPath();
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "plugins.flutter.io/path_provider").setMethodCallHandler(new PathProviderPlugin(paramRegistrar));
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramMethodCall = paramMethodCall.method;
    int i = paramMethodCall.hashCode();
    if (i != 1200320591) {
      if (i != 1252916648) {
        if (i != 1711844626) {
          label28:
          i = -1;
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
        if (!paramMethodCall.equals("getTemporaryDirectory")) {
          break label28;
        }
        i = 0;
        continue;
        if (!paramMethodCall.equals("getStorageDirectory")) {
          break label28;
        }
        i = 2;
        continue;
        if (!paramMethodCall.equals("getApplicationDocumentsDirectory")) {
          break label28;
        }
        i = 1;
      }
    }
    paramResult.success(getPathProviderStorageDirectory());
    return;
    paramResult.success(getPathProviderApplicationDocumentsDirectory());
    return;
    paramResult.success(getPathProviderTemporaryDirectory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugins.pathprovider.PathProviderPlugin
 * JD-Core Version:    0.7.0.1
 */