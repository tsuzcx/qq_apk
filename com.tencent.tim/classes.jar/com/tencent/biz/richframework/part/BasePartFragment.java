package com.tencent.biz.richframework.part;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import ovd;
import rxi;
import rxk;
import rxl;
import rze;

public abstract class BasePartFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  public static final String TAG = BasePartFragment.class.getSimpleName();
  protected TopGestureLayout a;
  private rxl a;
  public View mContentView;
  private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore mViewModelStore;
  
  private void bxj()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void bxk()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      long l = getActivity().getIntent().getLongExtra("key_bundle_open_page_time", 0L);
      if (l != 0L) {
        QLog.i(TAG, 1, "openPageTime = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  protected boolean HG()
  {
    return true;
  }
  
  protected boolean HJ()
  {
    return false;
  }
  
  public void L(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public <T extends rxi> T a(BasePartFragment paramBasePartFragment, String paramString, Class<T> paramClass)
  {
    ViewModelProvider localViewModelProvider = new ViewModelProvider(paramBasePartFragment, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
    if (paramString == null) {}
    for (paramString = "android.arch.lifecycle.ViewModelProvider.DefaultKey";; paramString = paramString + paramClass.getCanonicalName())
    {
      paramString = (rxi)localViewModelProvider.get(paramString, paramClass);
      paramString.setContextHashCode(paramBasePartFragment.getActivity().hashCode());
      return paramString;
    }
  }
  
  public <T extends rxi> T a(String paramString, Class<T> paramClass)
  {
    return a(this, paramString, paramClass);
  }
  
  public rxl a()
  {
    return this.jdField_a_of_type_Rxl;
  }
  
  protected abstract List<rxk> bw();
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Rxl != null)
    {
      this.jdField_a_of_type_Rxl.dX(this.mContentView);
      this.jdField_a_of_type_Rxl.onActivityCreated(getActivity(), paramBundle);
    }
    paramLayoutInflater = getActivity().mSystemBarComp;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarVisible(2, 0);
    }
    if (HJ()) {
      getActivity().getWindow().setFlags(1024, 1024);
    }
    for (;;)
    {
      bxk();
      return;
      if (((getActivity() instanceof QCircleFragmentActivity)) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ovd.k(getActivity(), getStatusBarColor());
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      }
    }
  }
  
  protected abstract int getContentLayoutId();
  
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  protected abstract int getStatusBarColor();
  
  public <T extends rxi> T getViewModel(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.mViewModelStore == null) {
      this.mViewModelStore = new ViewModelStore();
    }
    return this.mViewModelStore;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((rze.Mp()) && (HG())) {
      bxj();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (a().onBackEvent()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_Rxl = new rxl(this, getView());
    this.jdField_a_of_type_Rxl.fc(bw());
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.mContentView = paramLayoutInflater.inflate(getContentLayoutId(), paramViewGroup, false);
      doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater = this.mContentView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e(TAG, 1, localThrowable, new Object[0]);
      }
    }
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.jdField_a_of_type_Rxl.onActivityDestroyed(getActivity());
      if (this.mViewModelStore != null) {
        this.mViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.jdField_a_of_type_Rxl.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.jdField_a_of_type_Rxl.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.jdField_a_of_type_Rxl.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.jdField_a_of_type_Rxl.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.BasePartFragment
 * JD-Core Version:    0.7.0.1
 */