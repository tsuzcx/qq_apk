package com.tencent.mobileqq.mvvm;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "Landroid/support/v4/app/Fragment;", "Landroid/arch/lifecycle/LifecycleOwner;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "()V", "mLifecycleRegistry", "Landroid/arch/lifecycle/LifecycleRegistry;", "mViewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "dispatchLifeCycleEvent", "", "event", "Landroid/arch/lifecycle/Lifecycle$Event;", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "getViewModelStore", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class LifeCycleFragment
  extends ReportV4Fragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private HashMap ee;
  private LifecycleRegistry mLifecycleRegistry;
  private final ViewModelStore mViewModelStore = new ViewModelStore();
  
  private final void a(Lifecycle.Event paramEvent)
  {
    try
    {
      if (this.mLifecycleRegistry == null) {
        this.mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
      }
      LifecycleRegistry localLifecycleRegistry = this.mLifecycleRegistry;
      if (localLifecycleRegistry != null) {
        localLifecycleRegistry.handleLifecycleEvent(paramEvent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LifeCycleFragment", 2, "dispatchLifeCycleEvent event -> " + paramEvent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LifeCycleFragment", 1, "handleLifecycleEvent fail : event -> " + paramEvent);
    }
  }
  
  public void aQW()
  {
    if (this.ee != null) {
      this.ee.clear();
    }
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    if (this.mLifecycleRegistry == null) {
      this.mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);
    }
    LifecycleRegistry localLifecycleRegistry = this.mLifecycleRegistry;
    if (localLifecycleRegistry == null) {
      Intrinsics.throwNpe();
    }
    return (Lifecycle)localLifecycleRegistry;
  }
  
  @NotNull
  public ViewModelStore getViewModelStore()
  {
    return this.mViewModelStore;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onCreate() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onDestroy() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_DESTROY);
    Activity localActivity = (Activity)getActivity();
    if ((localActivity != null) && (localActivity.isChangingConfigurations())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mViewModelStore.clear();
      }
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onPause() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onResume() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onStart() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("LifeCycleFragment", 2, "onStop() " + getClass().getSimpleName() + " " + hashCode());
    }
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleFragment
 * JD-Core Version:    0.7.0.1
 */