package io.flutter.embedding.engine;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

final class FlutterEngineAndroidLifecycle
  extends LifecycleRegistry
{
  private static final String TAG = "FlutterEngineAndroidLifecycle";
  @Nullable
  private Lifecycle backingLifecycle;
  @NonNull
  private final LifecycleObserver forwardingObserver = new FlutterEngineAndroidLifecycle.1(this);
  private boolean isDestroyed = false;
  
  FlutterEngineAndroidLifecycle(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    super(paramLifecycleOwner);
  }
  
  private void ensureNotDestroyed()
  {
    if (!this.isDestroyed) {
      return;
    }
    throw new IllegalStateException("Tried to invoke a method on a destroyed FlutterEngineAndroidLifecycle.");
  }
  
  public void destroy()
  {
    ensureNotDestroyed();
    setBackingLifecycle(null);
    markState(Lifecycle.State.DESTROYED);
    this.isDestroyed = true;
  }
  
  public void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    ensureNotDestroyed();
    super.handleLifecycleEvent(paramEvent);
  }
  
  public void setBackingLifecycle(@Nullable Lifecycle paramLifecycle)
  {
    ensureNotDestroyed();
    if (this.backingLifecycle != null) {
      this.backingLifecycle.removeObserver(this.forwardingObserver);
    }
    handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    this.backingLifecycle = paramLifecycle;
    if (this.backingLifecycle != null) {
      paramLifecycle.addObserver(this.forwardingObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineAndroidLifecycle
 * JD-Core Version:    0.7.0.1
 */