import com.idlefish.flutterboost.FlutterBoost.BoostPluginsRegister;
import com.tencent.qflutter.TextPlatformViewPlugin;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;

class ahgb
  implements FlutterBoost.BoostPluginsRegister
{
  ahgb(ahfz paramahfz) {}
  
  public void registerPlugins(PluginRegistry paramPluginRegistry)
  {
    GeneratedPluginRegistrant.registerWith(paramPluginRegistry);
    paramPluginRegistry = paramPluginRegistry.registrarFor("TextPlatformViewPlugin");
    TextPlatformViewPlugin.register(paramPluginRegistry);
    ahev.a().a(paramPluginRegistry.messenger(), paramPluginRegistry.textures());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgb
 * JD-Core Version:    0.7.0.1
 */