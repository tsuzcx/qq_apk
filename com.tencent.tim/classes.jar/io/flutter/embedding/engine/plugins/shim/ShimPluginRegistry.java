package io.flutter.embedding.engine.plugins.shim;

import android.support.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShimPluginRegistry
  implements io.flutter.plugin.common.PluginRegistry
{
  private static final String TAG = "ShimPluginRegistry";
  private final FlutterEngine flutterEngine;
  private final Map<String, Object> pluginMap = new HashMap();
  private final ShimRegistrarAggregate shimRegistrarAggregate;
  
  public ShimPluginRegistry(@NonNull FlutterEngine paramFlutterEngine)
  {
    this.flutterEngine = paramFlutterEngine;
    this.shimRegistrarAggregate = new ShimRegistrarAggregate(null);
    this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.pluginMap.containsKey(paramString);
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Creating plugin Registrar for '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("ShimPluginRegistry", localStringBuilder.toString());
    if (!this.pluginMap.containsKey(paramString))
    {
      this.pluginMap.put(paramString, null);
      paramString = new ShimRegistrar(paramString, this.pluginMap);
      this.shimRegistrarAggregate.addPlugin(paramString);
      return paramString;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Plugin key ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is already in use");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return this.pluginMap.get(paramString);
  }
  
  static class ShimRegistrarAggregate
    implements FlutterPlugin, ActivityAware
  {
    private ActivityPluginBinding activityPluginBinding;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
    private final Set<ShimRegistrar> shimRegistrars = new HashSet();
    
    public void addPlugin(@NonNull ShimRegistrar paramShimRegistrar)
    {
      this.shimRegistrars.add(paramShimRegistrar);
      if (this.flutterPluginBinding != null) {
        paramShimRegistrar.onAttachedToEngine(this.flutterPluginBinding);
      }
      if (this.activityPluginBinding != null) {
        paramShimRegistrar.onAttachedToActivity(this.activityPluginBinding);
      }
    }
    
    public void onAttachedToActivity(@NonNull ActivityPluginBinding paramActivityPluginBinding)
    {
      this.activityPluginBinding = paramActivityPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onAttachedToActivity(paramActivityPluginBinding);
      }
    }
    
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      this.flutterPluginBinding = paramFlutterPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onAttachedToEngine(paramFlutterPluginBinding);
      }
    }
    
    public void onDetachedFromActivity()
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
      }
    }
    
    public void onDetachedFromActivityForConfigChanges()
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
      }
      this.activityPluginBinding = null;
    }
    
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromEngine(paramFlutterPluginBinding);
      }
      this.flutterPluginBinding = null;
    }
    
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding paramActivityPluginBinding)
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onReattachedToActivityForConfigChanges(paramActivityPluginBinding);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry
 * JD-Core Version:    0.7.0.1
 */