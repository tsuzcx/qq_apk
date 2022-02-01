package io.flutter.embedding.engine;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

class FlutterEngineAndroidLifecycle$1
  implements DefaultLifecycleObserver
{
  FlutterEngineAndroidLifecycle$1(FlutterEngineAndroidLifecycle paramFlutterEngineAndroidLifecycle) {}
  
  public void onCreate(@NonNull LifecycleOwner paramLifecycleOwner) {}
  
  public void onDestroy(@NonNull LifecycleOwner paramLifecycleOwner) {}
  
  public void onPause(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.this$0.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.this$0.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.this$0.handleLifecycleEvent(Lifecycle.Event.ON_START);
  }
  
  public void onStop(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.this$0.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineAndroidLifecycle.1
 * JD-Core Version:    0.7.0.1
 */