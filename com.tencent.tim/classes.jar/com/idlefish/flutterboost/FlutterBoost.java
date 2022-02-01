package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.support.annotation.NonNull;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterMain;

public class FlutterBoost
{
  static FlutterBoost sInstance;
  private long FlutterPostFrameCallTime = 0L;
  private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
  private Activity mCurrentActiveActivity;
  private FlutterEngine mEngine;
  private FlutterViewContainerManager mManager;
  private Platform mPlatform;
  private PluginRegistry mRegistry;
  
  private FlutterEngine createEngine()
  {
    if (this.mEngine == null)
    {
      FlutterMain.startInitialization(this.mPlatform.getApplication());
      FlutterShellArgs localFlutterShellArgs = new FlutterShellArgs(new String[0]);
      FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), localFlutterShellArgs.toArray());
      this.mEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext());
    }
    return this.mEngine;
  }
  
  public static FlutterBoost instance()
  {
    if (sInstance == null) {
      sInstance = new FlutterBoost();
    }
    return sInstance;
  }
  
  public void boostDestroy()
  {
    if (this.mEngine != null) {
      this.mEngine.destroy();
    }
    if (this.mPlatform.lifecycleListener != null) {
      this.mPlatform.lifecycleListener.onEngineDestroy();
    }
    this.mEngine = null;
    this.mRegistry = null;
    this.mCurrentActiveActivity = null;
  }
  
  public void boostPluginRegistry()
  {
    if ((this.mRegistry != null) && (!this.mRegistry.hasPlugin("boostPluginRegistry")))
    {
      this.mPlatform.registerPlugins(this.mRegistry);
      this.mRegistry.registrarFor("boostPluginRegistry");
    }
  }
  
  public FlutterBoostPlugin channel()
  {
    return FlutterBoostPlugin.singleton();
  }
  
  public IContainerManager containerManager()
  {
    return sInstance.mManager;
  }
  
  public Activity currentActivity()
  {
    return sInstance.mCurrentActiveActivity;
  }
  
  public void doInitialFlutter()
  {
    if (this.mEngine != null) {}
    FlutterEngine localFlutterEngine;
    do
    {
      return;
      localFlutterEngine = createEngine();
      if (this.mPlatform.lifecycleListener != null) {
        this.mPlatform.lifecycleListener.onEngineCreated();
      }
    } while (localFlutterEngine.getDartExecutor().isExecutingDart());
    if (this.mPlatform.initialRoute() != null) {
      localFlutterEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
    }
    DartExecutor.DartEntrypoint localDartEntrypoint = new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "main");
    localFlutterEngine.getDartExecutor().executeDartEntrypoint(localDartEntrypoint);
    this.mRegistry = new BoostPluginRegistry(createEngine());
  }
  
  public FlutterEngine engineProvider()
  {
    return this.mEngine;
  }
  
  public IFlutterViewContainer findContainerById(String paramString)
  {
    return this.mManager.findContainerById(paramString);
  }
  
  public long getFlutterPostFrameCallTime()
  {
    return this.FlutterPostFrameCallTime;
  }
  
  public PluginRegistry getPluginRegistry()
  {
    return this.mRegistry;
  }
  
  public void init(Platform paramPlatform)
  {
    this.mPlatform = paramPlatform;
    this.mManager = new FlutterViewContainerManager();
    this.mActivityLifecycleCallbacks = new FlutterBoost.1(this);
    paramPlatform.getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    if (this.mPlatform.whenEngineStart() == ConfigBuilder.IMMEDIATELY) {
      doInitialFlutter();
    }
  }
  
  public Platform platform()
  {
    return sInstance.mPlatform;
  }
  
  public void setFlutterPostFrameCallTime(long paramLong)
  {
    this.FlutterPostFrameCallTime = paramLong;
  }
  
  public static abstract interface BoostLifecycleListener
  {
    public abstract void onEngineCreated();
    
    public abstract void onEngineDestroy();
    
    public abstract void onPluginsRegistered();
  }
  
  public static abstract interface BoostPluginsRegister
  {
    public abstract void registerPlugins(PluginRegistry paramPluginRegistry);
  }
  
  public static class ConfigBuilder
  {
    public static int ANY_ACTIVITY_CREATED = 1;
    public static int APP_EXit = 0;
    public static int All_FLUTTER_ACTIVITY_DESTROY = 1;
    public static final String DEFAULT_DART_ENTRYPOINT = "main";
    public static final String DEFAULT_INITIAL_ROUTE = "/";
    public static int FLUTTER_ACTIVITY_CREATED = 2;
    public static int IMMEDIATELY;
    private FlutterBoost.BoostPluginsRegister boostPluginsRegister;
    private String dartEntrypoint = "main";
    private String initialRoute = "/";
    private boolean isDebug = false;
    private FlutterBoost.BoostLifecycleListener lifecycleListener;
    private Application mApp;
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.texture;
    private INativeRouter router = null;
    private int whenEngineDestory = APP_EXit;
    private int whenEngineStart = ANY_ACTIVITY_CREATED;
    
    public ConfigBuilder(Application paramApplication, INativeRouter paramINativeRouter)
    {
      this.router = paramINativeRouter;
      this.mApp = paramApplication;
    }
    
    public Platform build()
    {
      FlutterBoost.ConfigBuilder.1 local1 = new FlutterBoost.ConfigBuilder.1(this);
      local1.lifecycleListener = this.lifecycleListener;
      local1.pluginsRegister = this.boostPluginsRegister;
      return local1;
    }
    
    public ConfigBuilder dartEntrypoint(@NonNull String paramString)
    {
      this.dartEntrypoint = paramString;
      return this;
    }
    
    public ConfigBuilder initialRoute(@NonNull String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
    
    public ConfigBuilder isDebug(boolean paramBoolean)
    {
      this.isDebug = paramBoolean;
      return this;
    }
    
    public ConfigBuilder lifecycleListener(FlutterBoost.BoostLifecycleListener paramBoostLifecycleListener)
    {
      this.lifecycleListener = paramBoostLifecycleListener;
      return this;
    }
    
    public ConfigBuilder pluginsRegister(FlutterBoost.BoostPluginsRegister paramBoostPluginsRegister)
    {
      this.boostPluginsRegister = paramBoostPluginsRegister;
      return this;
    }
    
    public ConfigBuilder renderMode(FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    public ConfigBuilder whenEngineStart(int paramInt)
    {
      this.whenEngineStart = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost
 * JD-Core Version:    0.7.0.1
 */