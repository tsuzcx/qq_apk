package com.tencent.mobileqq.flutter.container;

import ahfk;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class QFlutterFragment
  extends PublicBaseFragment
  implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host
{
  private SplashScreen a;
  private FlutterActivityAndFragmentDelegate delegate;
  @NonNull
  private LifecycleRegistry lifecycle;
  
  public QFlutterFragment()
  {
    setArguments(new Bundle());
    this.lifecycle = new LifecycleRegistry(this);
  }
  
  public void a(SplashScreen paramSplashScreen)
  {
    this.a = paramSplashScreen;
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
  
  @NonNull
  public Context getContext()
  {
    return getActivity();
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
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
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
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
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
  
  public void onPause()
  {
    super.onPause();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    this.delegate.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.delegate.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.delegate.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.delegate.onStop();
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
    if (this.a != null) {
      return this.a;
    }
    return new ahfk(null);
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public static class a
  {
    private final Class<? extends QFlutterFragment> fragmentClass = QFlutterFragment.class;
    private Map params = new HashMap();
    private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
    private FlutterShellArgs shellArgs;
    private boolean shouldAttachEngineToActivity = true;
    private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
    private String url = "";
    
    @NonNull
    private Bundle createArgs()
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
        localObject = this.renderMode.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.transparencyMode == null) {
          break label124;
        }
      }
      label124:
      for (localObject = this.transparencyMode.name();; localObject = FlutterView.TransparencyMode.transparent.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        return localBundle;
        localObject = FlutterView.RenderMode.surface.name();
        break;
      }
    }
    
    public a a(@NonNull String paramString)
    {
      this.url = paramString;
      return this;
    }
    
    public a a(@NonNull Map paramMap)
    {
      this.params = paramMap;
      return this;
    }
    
    @NonNull
    public <T extends QFlutterFragment> T a()
    {
      try
      {
        QFlutterFragment localQFlutterFragment = (QFlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localQFlutterFragment == null) {
          throw new RuntimeException("The NewFlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.fragmentClass.getName() + ")", localException);
      }
      localException.setArguments(createArgs());
      return localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterFragment
 * JD-Core Version:    0.7.0.1
 */