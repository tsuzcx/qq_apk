package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class FlutterFragment
  extends ReportV4Fragment
  implements FlutterActivityAndFragmentDelegate.Host
{
  protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
  protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
  protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
  protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
  protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
  protected static final String ARG_INITIAL_ROUTE = "initial_route";
  protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
  private static final String TAG = "FlutterFragment";
  private FlutterActivityAndFragmentDelegate delegate;
  private final OnFirstFrameRenderedListener onFirstFrameRenderedListener = new FlutterFragment.1(this);
  
  public FlutterFragment()
  {
    setArguments(new Bundle());
  }
  
  @NonNull
  public static FlutterFragment createDefault()
  {
    return new NewEngineFragmentBuilder().build();
  }
  
  @NonNull
  private Context getContextCompat()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return getContext();
    }
    return getActivity();
  }
  
  @NonNull
  public static CachedEngineFragmentBuilder withCachedEngine(@NonNull String paramString)
  {
    return new CachedEngineFragmentBuilder(paramString, null);
  }
  
  @NonNull
  public static NewEngineFragmentBuilder withNewEngine()
  {
    return new NewEngineFragmentBuilder();
  }
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
  }
  
  @NonNull
  public String getAppBundlePath()
  {
    return getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
  }
  
  @Nullable
  public String getCachedEngineId()
  {
    return getArguments().getString("cached_engine_id", null);
  }
  
  @NonNull
  public String getDartEntrypointFunctionName()
  {
    return getArguments().getString("dart_entrypoint", "main");
  }
  
  @Nullable
  public FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString != null) {}
    for (;;)
    {
      return new FlutterShellArgs(arrayOfString);
      arrayOfString = new String[0];
    }
  }
  
  @Nullable
  public String getInitialRoute()
  {
    return getArguments().getString("initial_route");
  }
  
  @NonNull
  public FlutterView.RenderMode getRenderMode()
  {
    return FlutterView.RenderMode.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.RenderMode.surface.name()));
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramContext);
  }
  
  @ActivityCallThrough
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.delegate.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
  }
  
  public void onFirstFrameRendered()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof OnFirstFrameRenderedListener)) {
      ((OnFirstFrameRenderedListener)localFragmentActivity).onFirstFrameRendered();
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.delegate.onLowMemory();
  }
  
  @ActivityCallThrough
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    this.delegate.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.delegate.onPause();
  }
  
  @ActivityCallThrough
  public void onPostResume()
  {
    this.delegate.onPostResume();
  }
  
  @ActivityCallThrough
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.delegate.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.delegate.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.delegate.onStop();
  }
  
  @ActivityCallThrough
  public void onTrimMemory(int paramInt)
  {
    this.delegate.onTrimMemory(paramInt);
  }
  
  @ActivityCallThrough
  public void onUserLeaveHint()
  {
    this.delegate.onUserLeaveHint();
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
    paramContext = getActivity();
    if ((paramContext instanceof FlutterEngineProvider))
    {
      Log.d("FlutterFragment", "Deferring to attached Activity to provide a FlutterEngine.");
      return ((FlutterEngineProvider)paramContext).provideFlutterEngine(getContext());
    }
    return null;
  }
  
  @Nullable
  public PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine)
  {
    if (paramActivity != null) {
      return new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel());
    }
    return null;
  }
  
  @Nullable
  public SplashScreen provideSplashScreen()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof SplashScreenProvider)) {
      return ((SplashScreenProvider)localFragmentActivity).provideSplashScreen();
    }
    return null;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return getArguments().getBoolean("should_attach_engine_to_activity");
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return getArguments().getBoolean("destroy_engine_with_fragment", false);
  }
  
  static @interface ActivityCallThrough {}
  
  public static class CachedEngineFragmentBuilder
  {
    private boolean destroyEngineWithFragment = false;
    private final String engineId;
    private final Class<? extends FlutterFragment> fragmentClass;
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
    private boolean shouldAttachEngineToActivity = true;
    private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
    
    protected CachedEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass, @NonNull String paramString)
    {
      this.fragmentClass = paramClass;
      this.engineId = paramString;
    }
    
    private CachedEngineFragmentBuilder(@NonNull String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    @NonNull
    public <T extends FlutterFragment> T build()
    {
      try
      {
        Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject != null)
        {
          ((FlutterFragment)localObject).setArguments(createArgs());
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("The FlutterFragment subclass sent in the constructor (");
        ((StringBuilder)localObject).append(this.fragmentClass.getCanonicalName());
        ((StringBuilder)localObject).append(") does not match the expected return type.");
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not instantiate FlutterFragment subclass (");
        localStringBuilder.append(this.fragmentClass.getName());
        localStringBuilder.append(")");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
    
    @NonNull
    protected Bundle createArgs()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.engineId);
      localBundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
      if (this.renderMode != null)
      {
        localObject = this.renderMode;
        localBundle.putString("flutterview_render_mode", ((FlutterView.RenderMode)localObject).name());
        if (this.transparencyMode == null) {
          break label91;
        }
      }
      label91:
      for (Object localObject = this.transparencyMode;; localObject = FlutterView.TransparencyMode.transparent)
      {
        localBundle.putString("flutterview_transparency_mode", ((FlutterView.TransparencyMode)localObject).name());
        localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
        return localBundle;
        localObject = FlutterView.RenderMode.surface;
        break;
      }
    }
    
    @NonNull
    public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean paramBoolean)
    {
      this.destroyEngineWithFragment = paramBoolean;
      return this;
    }
    
    @NonNull
    public CachedEngineFragmentBuilder renderMode(@NonNull FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    @NonNull
    public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    @NonNull
    public CachedEngineFragmentBuilder transparencyMode(@NonNull FlutterView.TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
  
  public static class NewEngineFragmentBuilder
  {
    private String appBundlePath = null;
    private String dartEntrypoint = "main";
    private final Class<? extends FlutterFragment> fragmentClass;
    private String initialRoute = "/";
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterFragment.class;
    }
    
    public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass)
    {
      this.fragmentClass = paramClass;
    }
    
    @NonNull
    public NewEngineFragmentBuilder appBundlePath(@NonNull String paramString)
    {
      this.appBundlePath = paramString;
      return this;
    }
    
    @NonNull
    public <T extends FlutterFragment> T build()
    {
      try
      {
        Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localObject != null)
        {
          ((FlutterFragment)localObject).setArguments(createArgs());
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("The FlutterFragment subclass sent in the constructor (");
        ((StringBuilder)localObject).append(this.fragmentClass.getCanonicalName());
        ((StringBuilder)localObject).append(") does not match the expected return type.");
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not instantiate FlutterFragment subclass (");
        localStringBuilder.append(this.fragmentClass.getName());
        localStringBuilder.append(")");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
    
    @NonNull
    protected Bundle createArgs()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.initialRoute);
      localBundle.putString("app_bundle_path", this.appBundlePath);
      localBundle.putString("dart_entrypoint", this.dartEntrypoint);
      if (this.shellArgs != null) {
        localBundle.putStringArray("initialization_args", this.shellArgs.toArray());
      }
      if (this.renderMode != null)
      {
        localObject = this.renderMode;
        localBundle.putString("flutterview_render_mode", ((FlutterView.RenderMode)localObject).name());
        if (this.transparencyMode == null) {
          break label128;
        }
      }
      label128:
      for (Object localObject = this.transparencyMode;; localObject = FlutterView.TransparencyMode.transparent)
      {
        localBundle.putString("flutterview_transparency_mode", ((FlutterView.TransparencyMode)localObject).name());
        localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        return localBundle;
        localObject = FlutterView.RenderMode.surface;
        break;
      }
    }
    
    @NonNull
    public NewEngineFragmentBuilder dartEntrypoint(@NonNull String paramString)
    {
      this.dartEntrypoint = paramString;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs paramFlutterShellArgs)
    {
      this.shellArgs = paramFlutterShellArgs;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder initialRoute(@NonNull String paramString)
    {
      this.initialRoute = paramString;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder renderMode(@NonNull FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
    {
      this.shouldAttachEngineToActivity = paramBoolean;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder transparencyMode(@NonNull FlutterView.TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */