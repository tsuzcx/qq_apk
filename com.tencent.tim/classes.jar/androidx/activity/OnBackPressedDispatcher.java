package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher
{
  @Nullable
  private final Runnable mFallbackOnBackPressed;
  final ArrayDeque<OnBackPressedCallback> mOnBackPressedCallbacks = new ArrayDeque();
  
  public OnBackPressedDispatcher()
  {
    this(null);
  }
  
  public OnBackPressedDispatcher(@Nullable Runnable paramRunnable)
  {
    this.mFallbackOnBackPressed = paramRunnable;
  }
  
  @MainThread
  public void addCallback(@NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    addCancellableCallback(paramOnBackPressedCallback);
  }
  
  @MainThread
  public void addCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    paramLifecycleOwner = paramLifecycleOwner.getLifecycle();
    if (paramLifecycleOwner.getCurrentState() == Lifecycle.State.DESTROYED) {
      return;
    }
    paramOnBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(paramLifecycleOwner, paramOnBackPressedCallback));
  }
  
  @MainThread
  @NonNull
  Cancellable addCancellableCallback(@NonNull OnBackPressedCallback paramOnBackPressedCallback)
  {
    this.mOnBackPressedCallbacks.add(paramOnBackPressedCallback);
    OnBackPressedCancellable localOnBackPressedCancellable = new OnBackPressedCancellable(paramOnBackPressedCallback);
    paramOnBackPressedCallback.addCancellable(localOnBackPressedCancellable);
    return localOnBackPressedCancellable;
  }
  
  @MainThread
  public boolean hasEnabledCallbacks()
  {
    Iterator localIterator = this.mOnBackPressedCallbacks.descendingIterator();
    while (localIterator.hasNext()) {
      if (((OnBackPressedCallback)localIterator.next()).isEnabled()) {
        return true;
      }
    }
    return false;
  }
  
  @MainThread
  public void onBackPressed()
  {
    Iterator localIterator = this.mOnBackPressedCallbacks.descendingIterator();
    while (localIterator.hasNext())
    {
      localOnBackPressedCallback = (OnBackPressedCallback)localIterator.next();
      if (localOnBackPressedCallback.isEnabled()) {
        localOnBackPressedCallback.handleOnBackPressed();
      }
    }
    while (this.mFallbackOnBackPressed == null)
    {
      OnBackPressedCallback localOnBackPressedCallback;
      return;
    }
    this.mFallbackOnBackPressed.run();
  }
  
  class LifecycleOnBackPressedCancellable
    implements Cancellable, LifecycleEventObserver
  {
    @Nullable
    private Cancellable mCurrentCancellable;
    private final Lifecycle mLifecycle;
    private final OnBackPressedCallback mOnBackPressedCallback;
    
    LifecycleOnBackPressedCancellable(@NonNull Lifecycle paramLifecycle, @NonNull OnBackPressedCallback paramOnBackPressedCallback)
    {
      this.mLifecycle = paramLifecycle;
      this.mOnBackPressedCallback = paramOnBackPressedCallback;
      paramLifecycle.addObserver(this);
    }
    
    public void cancel()
    {
      this.mLifecycle.removeObserver(this);
      this.mOnBackPressedCallback.removeCancellable(this);
      if (this.mCurrentCancellable != null)
      {
        this.mCurrentCancellable.cancel();
        this.mCurrentCancellable = null;
      }
    }
    
    public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
    {
      if (paramEvent == Lifecycle.Event.ON_START) {
        this.mCurrentCancellable = OnBackPressedDispatcher.this.addCancellableCallback(this.mOnBackPressedCallback);
      }
      do
      {
        do
        {
          return;
          if (paramEvent != Lifecycle.Event.ON_STOP) {
            break;
          }
        } while (this.mCurrentCancellable == null);
        this.mCurrentCancellable.cancel();
        return;
      } while (paramEvent != Lifecycle.Event.ON_DESTROY);
      cancel();
    }
  }
  
  class OnBackPressedCancellable
    implements Cancellable
  {
    private final OnBackPressedCallback mOnBackPressedCallback;
    
    OnBackPressedCancellable(OnBackPressedCallback paramOnBackPressedCallback)
    {
      this.mOnBackPressedCallback = paramOnBackPressedCallback;
    }
    
    public void cancel()
    {
      OnBackPressedDispatcher.this.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
      this.mOnBackPressedCallback.removeCancellable(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher
 * JD-Core Version:    0.7.0.1
 */