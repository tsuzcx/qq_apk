package com.idlefish.flutterboost;

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

public class BoostPluginRegistry
  implements io.flutter.plugin.common.PluginRegistry
{
  private static final String TAG = "ShimPluginRegistry";
  private final FlutterEngine flutterEngine;
  private final Map<String, Object> pluginMap = new HashMap();
  private final BoostRegistrarAggregate shimRegistrarAggregate;
  
  public BoostPluginRegistry(FlutterEngine paramFlutterEngine)
  {
    this.flutterEngine = paramFlutterEngine;
    this.shimRegistrarAggregate = new BoostRegistrarAggregate(null);
    this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
  }
  
  public BoostRegistrarAggregate getRegistrarAggregate()
  {
    return this.shimRegistrarAggregate;
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
      paramString = new BoostRegistrar(paramString, this.pluginMap);
      this.shimRegistrarAggregate.addPlugin(paramString);
      return paramString;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Plugin key ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is already in use");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public Object valuePublishedByPlugin(String paramString)
  {
    return this.pluginMap.get(paramString);
  }
  
  public static class BoostRegistrarAggregate
    implements FlutterPlugin, ActivityAware
  {
    private ActivityPluginBinding activityPluginBinding;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
    private final Set<BoostRegistrar> shimRegistrars = new HashSet();
    
    public void addPlugin(BoostRegistrar paramBoostRegistrar)
    {
      this.shimRegistrars.add(paramBoostRegistrar);
      if (this.flutterPluginBinding != null) {
        paramBoostRegistrar.onAttachedToEngine(this.flutterPluginBinding);
      }
      if (this.activityPluginBinding != null) {
        paramBoostRegistrar.onAttachedToActivity(this.activityPluginBinding);
      }
    }
    
    public ActivityPluginBinding getActivityPluginBinding()
    {
      return this.activityPluginBinding;
    }
    
    public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
    {
      this.activityPluginBinding = paramActivityPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onAttachedToActivity(paramActivityPluginBinding);
      }
    }
    
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      this.flutterPluginBinding = paramFlutterPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onAttachedToEngine(paramFlutterPluginBinding);
      }
    }
    
    public void onDetachedFromActivity()
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onDetachedFromActivity();
      }
    }
    
    public void onDetachedFromActivityForConfigChanges()
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onDetachedFromActivity();
      }
      this.activityPluginBinding = null;
    }
    
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onDetachedFromEngine(paramFlutterPluginBinding);
      }
      this.flutterPluginBinding = null;
    }
    
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
    {
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((BoostRegistrar)localIterator.next()).onReattachedToActivityForConfigChanges(paramActivityPluginBinding);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.BoostPluginRegistry
 * JD-Core Version:    0.7.0.1
 */