package io.flutter.embedding.engine.plugins;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;

public abstract interface FlutterPlugin
{
  public abstract void onAttachedToEngine(@NonNull FlutterPluginBinding paramFlutterPluginBinding);
  
  public abstract void onDetachedFromEngine(@NonNull FlutterPluginBinding paramFlutterPluginBinding);
  
  public static class FlutterPluginBinding
    implements LifecycleOwner
  {
    private final Context applicationContext;
    private final FlutterEngine flutterEngine;
    private final Lifecycle lifecycle;
    
    public FlutterPluginBinding(@NonNull Context paramContext, @NonNull FlutterEngine paramFlutterEngine, @NonNull Lifecycle paramLifecycle)
    {
      this.applicationContext = paramContext;
      this.flutterEngine = paramFlutterEngine;
      this.lifecycle = paramLifecycle;
    }
    
    @NonNull
    public Context getApplicationContext()
    {
      return this.applicationContext;
    }
    
    @NonNull
    public FlutterEngine getFlutterEngine()
    {
      return this.flutterEngine;
    }
    
    @NonNull
    public Lifecycle getLifecycle()
    {
      return this.lifecycle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.FlutterPlugin
 * JD-Core Version:    0.7.0.1
 */