package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlutterPluginRegistry
  implements PluginRegistry, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener
{
  private static final String TAG = "FlutterPluginRegistry";
  private Activity mActivity;
  private final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
  private Context mAppContext;
  private FlutterView mFlutterView;
  private FlutterNativeView mNativeView;
  private final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
  private final PlatformViewsController mPlatformViewsController;
  private final Map<String, Object> mPluginMap = new LinkedHashMap(0);
  private final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
  private final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
  private final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);
  
  public FlutterPluginRegistry(FlutterEngine paramFlutterEngine, Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
  }
  
  public FlutterPluginRegistry(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    this.mNativeView = paramFlutterNativeView;
    this.mAppContext = paramContext;
    this.mPlatformViewsController = new PlatformViewsController();
  }
  
  public void attach(FlutterView paramFlutterView, Activity paramActivity)
  {
    this.mFlutterView = paramFlutterView;
    this.mActivity = paramActivity;
    this.mPlatformViewsController.attach(paramActivity, paramFlutterView, paramFlutterView.getDartExecutor());
  }
  
  public void destroy()
  {
    this.mPlatformViewsController.onFlutterViewDestroyed();
  }
  
  public void detach()
  {
    this.mPlatformViewsController.detach();
    this.mPlatformViewsController.onFlutterViewDestroyed();
    this.mFlutterView = null;
    this.mActivity = null;
  }
  
  public PlatformViewsController getPlatformViewsController()
  {
    return this.mPlatformViewsController;
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.mPluginMap.containsKey(paramString);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.mActivityResultListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.ActivityResultListener)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = this.mNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.NewIntentListener)localIterator.next()).onNewIntent(paramIntent)) {
        return true;
      }
    }
    return false;
  }
  
  public void onPreEngineRestart()
  {
    this.mPlatformViewsController.onPreEngineRestart();
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Iterator localIterator = this.mRequestPermissionsResultListeners.iterator();
    while (localIterator.hasNext()) {
      if (((PluginRegistry.RequestPermissionsResultListener)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt)) {
        return true;
      }
    }
    return false;
  }
  
  public void onUserLeaveHint()
  {
    Iterator localIterator = this.mUserLeaveHintListeners.iterator();
    while (localIterator.hasNext()) {
      ((PluginRegistry.UserLeaveHintListener)localIterator.next()).onUserLeaveHint();
    }
  }
  
  public boolean onViewDestroy(FlutterNativeView paramFlutterNativeView)
  {
    Iterator localIterator = this.mViewDestroyListeners.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      if (((PluginRegistry.ViewDestroyListener)localIterator.next()).onViewDestroy(paramFlutterNativeView)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    if (!this.mPluginMap.containsKey(paramString))
    {
      this.mPluginMap.put(paramString, null);
      return new FlutterRegistrar(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Plugin key ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is already in use");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return this.mPluginMap.get(paramString);
  }
  
  class FlutterRegistrar
    implements PluginRegistry.Registrar
  {
    private final String pluginKey;
    
    FlutterRegistrar(String paramString)
    {
      this.pluginKey = paramString;
    }
    
    public Context activeContext()
    {
      if (FlutterPluginRegistry.this.mActivity != null) {
        return FlutterPluginRegistry.this.mActivity;
      }
      return FlutterPluginRegistry.this.mAppContext;
    }
    
    public Activity activity()
    {
      return FlutterPluginRegistry.this.mActivity;
    }
    
    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
    {
      FlutterPluginRegistry.this.mActivityResultListeners.add(paramActivityResultListener);
      return this;
    }
    
    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
    {
      FlutterPluginRegistry.this.mNewIntentListeners.add(paramNewIntentListener);
      return this;
    }
    
    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
    {
      FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
      return this;
    }
    
    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
    {
      FlutterPluginRegistry.this.mUserLeaveHintListeners.add(paramUserLeaveHintListener);
      return this;
    }
    
    public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener)
    {
      FlutterPluginRegistry.this.mViewDestroyListeners.add(paramViewDestroyListener);
      return this;
    }
    
    public Context context()
    {
      return FlutterPluginRegistry.this.mAppContext;
    }
    
    public String lookupKeyForAsset(String paramString)
    {
      return FlutterMain.getLookupKeyForAsset(paramString);
    }
    
    public String lookupKeyForAsset(String paramString1, String paramString2)
    {
      return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
    }
    
    public BinaryMessenger messenger()
    {
      return FlutterPluginRegistry.this.mNativeView;
    }
    
    public PlatformViewRegistry platformViewRegistry()
    {
      return FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
    }
    
    public PluginRegistry.Registrar publish(Object paramObject)
    {
      FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, paramObject);
      return this;
    }
    
    public TextureRegistry textures()
    {
      return FlutterPluginRegistry.this.mFlutterView;
    }
    
    public FlutterView view()
    {
      return FlutterPluginRegistry.this.mFlutterView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.app.FlutterPluginRegistry
 * JD-Core Version:    0.7.0.1
 */