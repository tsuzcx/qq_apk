package com.tencent.qflutter;

import com.idlefish.flutterboost.FlutterBoost.BoostPluginsRegister;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;

final class QFlutterEngine$1
  implements FlutterBoost.BoostPluginsRegister
{
  QFlutterEngine$1(QFlutterEngine.EventListener paramEventListener) {}
  
  public void registerPlugins(PluginRegistry paramPluginRegistry)
  {
    GeneratedPluginRegistrant.registerWith(paramPluginRegistry);
    paramPluginRegistry = paramPluginRegistry.registrarFor("TextPlatformViewPlugin");
    TextPlatformViewPlugin.register(paramPluginRegistry);
    if (this.val$eventListener != null) {
      this.val$eventListener.onInited(paramPluginRegistry.messenger());
    }
    FlutterBoostPlugin.singleton().addEventListener("test_open_native", new QFlutterEngine.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qflutter.QFlutterEngine.1
 * JD-Core Version:    0.7.0.1
 */