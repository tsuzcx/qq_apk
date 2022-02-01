package androidx.activity;

import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements OnBackPressedDispatcherOwner, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner
{
  @LayoutRes
  private int mContentLayoutId;
  private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity.1(this));
  private final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create(this);
  private ViewModelStore mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() == null) {
      throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getLifecycle().addObserver(new ComponentActivity.2(this));
    }
    getLifecycle().addObserver(new ComponentActivity.3(this));
    if ((19 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 23)) {
      getLifecycle().addObserver(new ImmLeaksCleaner(this));
    }
  }
  
  @ContentView
  public ComponentActivity(@LayoutRes int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  @Deprecated
  @Nullable
  public Object getLastCustomNonConfigurationInstance()
  {
    NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      return localNonConfigurationInstances.custom;
    }
    return null;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @NonNull
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.mOnBackPressedDispatcher;
  }
  
  @NonNull
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.mViewModelStore == null)
    {
      NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
      if (localNonConfigurationInstances != null) {
        this.mViewModelStore = localNonConfigurationInstances.viewModelStore;
      }
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new ViewModelStore();
      }
    }
    return this.mViewModelStore;
  }
  
  @MainThread
  public void onBackPressed()
  {
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSavedStateRegistryController.performRestore(paramBundle);
    ReportFragment.injectIfNeededIn(this);
    if (this.mContentLayoutId != 0) {
      setContentView(this.mContentLayoutId);
    }
  }
  
  @Deprecated
  @Nullable
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  @Nullable
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject3 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mViewModelStore;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
      localObject1 = localObject2;
      if (localNonConfigurationInstances != null) {
        localObject1 = localNonConfigurationInstances.viewModelStore;
      }
    }
    if ((localObject1 == null) && (localObject3 == null)) {
      return null;
    }
    localObject2 = new NonConfigurationInstances();
    ((NonConfigurationInstances)localObject2).custom = localObject3;
    ((NonConfigurationInstances)localObject2).viewModelStore = ((ViewModelStore)localObject1);
    return localObject2;
  }
  
  @CallSuper
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    Lifecycle localLifecycle = getLifecycle();
    if ((localLifecycle instanceof LifecycleRegistry)) {
      ((LifecycleRegistry)localLifecycle).setCurrentState(Lifecycle.State.CREATED);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
  }
  
  static final class NonConfigurationInstances
  {
    Object custom;
    ViewModelStore viewModelStore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.activity.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */