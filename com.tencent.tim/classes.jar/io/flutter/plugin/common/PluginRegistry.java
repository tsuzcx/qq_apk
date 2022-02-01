package io.flutter.plugin.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;

public abstract interface PluginRegistry
{
  public abstract boolean hasPlugin(String paramString);
  
  public abstract Registrar registrarFor(String paramString);
  
  public abstract <T> T valuePublishedByPlugin(String paramString);
  
  public static abstract interface ActivityResultListener
  {
    public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static abstract interface NewIntentListener
  {
    public abstract boolean onNewIntent(Intent paramIntent);
  }
  
  public static abstract interface PluginRegistrantCallback
  {
    public abstract void registerWith(PluginRegistry paramPluginRegistry);
  }
  
  public static abstract interface Registrar
  {
    public abstract Context activeContext();
    
    public abstract Activity activity();
    
    public abstract Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener);
    
    public abstract Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener);
    
    public abstract Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
    
    public abstract Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
    
    public abstract Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener);
    
    public abstract Context context();
    
    public abstract String lookupKeyForAsset(String paramString);
    
    public abstract String lookupKeyForAsset(String paramString1, String paramString2);
    
    public abstract BinaryMessenger messenger();
    
    public abstract PlatformViewRegistry platformViewRegistry();
    
    public abstract Registrar publish(Object paramObject);
    
    public abstract TextureRegistry textures();
    
    public abstract FlutterView view();
  }
  
  public static abstract interface RequestPermissionsResultListener
  {
    public abstract boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public static abstract interface UserLeaveHintListener
  {
    public abstract void onUserLeaveHint();
  }
  
  public static abstract interface ViewDestroyListener
  {
    public abstract boolean onViewDestroy(FlutterNativeView paramFlutterNativeView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.PluginRegistry
 * JD-Core Version:    0.7.0.1
 */