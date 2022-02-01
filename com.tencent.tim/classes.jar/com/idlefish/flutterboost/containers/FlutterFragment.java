package com.idlefish.flutterboost.containers;

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
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

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
  protected static final String EXTRA_PARAMS = "params";
  protected static final String EXTRA_URL = "url";
  private static final String TAG = "NewFlutterFragment";
  private FlutterActivityAndFragmentDelegate delegate;
  
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
  
  public String getContainerUrl()
  {
    return getArguments().getString("url");
  }
  
  public Map getContainerUrlParams()
  {
    return ((BoostFlutterActivity.SerializableMap)getArguments().getSerializable("params")).getMap();
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
  
  protected XFlutterView getFlutterView()
  {
    return this.delegate.getFlutterView();
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
    return FlutterBoost.instance().engineProvider();
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
    return true;
  }
  
  static @interface ActivityCallThrough {}
  
  public static class NewEngineFragmentBuilder
  {
    private final Class<? extends FlutterFragment> fragmentClass;
    private Map params = new HashMap();
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
    private FlutterShellArgs shellArgs = null;
    private boolean shouldAttachEngineToActivity = true;
    private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
    private String url = "";
    
    public NewEngineFragmentBuilder()
    {
      this.fragmentClass = FlutterFragment.class;
    }
    
    public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass)
    {
      this.fragmentClass = paramClass;
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
        ((StringBuilder)localObject).append("The NewFlutterFragment subclass sent in the constructor (");
        ((StringBuilder)localObject).append(this.fragmentClass.getCanonicalName());
        ((StringBuilder)localObject).append(") does not match the expected return type.");
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not instantiate NewFlutterFragment subclass (");
        localStringBuilder.append(this.fragmentClass.getName());
        localStringBuilder.append(")");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
    
    @NonNull
    protected Bundle createArgs()
    {
      Bundle localBundle = new Bundle();
      if (this.shellArgs != null) {
        localBundle.putStringArray("initialization_args", this.shellArgs.toArray());
      }
      Object localObject = new BoostFlutterActivity.SerializableMap();
      ((BoostFlutterActivity.SerializableMap)localObject).setMap(this.params);
      localBundle.putString("url", this.url);
      localBundle.putSerializable("params", (Serializable)localObject);
      if (this.renderMode != null)
      {
        localObject = this.renderMode;
        localBundle.putString("flutterview_render_mode", ((FlutterView.RenderMode)localObject).name());
        if (this.transparencyMode == null) {
          break label121;
        }
      }
      label121:
      for (localObject = this.transparencyMode;; localObject = FlutterView.TransparencyMode.transparent)
      {
        localBundle.putString("flutterview_transparency_mode", ((FlutterView.TransparencyMode)localObject).name());
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        return localBundle;
        localObject = FlutterView.RenderMode.surface;
        break;
      }
    }
    
    @NonNull
    public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs paramFlutterShellArgs)
    {
      this.shellArgs = paramFlutterShellArgs;
      return this;
    }
    
    public NewEngineFragmentBuilder params(@NonNull Map paramMap)
    {
      this.params = paramMap;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder renderMode(@NonNull FlutterView.RenderMode paramRenderMode)
    {
      this.renderMode = paramRenderMode;
      return this;
    }
    
    @NonNull
    public NewEngineFragmentBuilder transparencyMode(@NonNull FlutterView.TransparencyMode paramTransparencyMode)
    {
      this.transparencyMode = paramTransparencyMode;
      return this;
    }
    
    public NewEngineFragmentBuilder url(@NonNull String paramString)
    {
      this.url = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */