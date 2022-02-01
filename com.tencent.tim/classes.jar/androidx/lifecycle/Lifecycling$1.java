package androidx.lifecycle;

import androidx.annotation.NonNull;

final class Lifecycling$1
  implements GenericLifecycleObserver
{
  Lifecycling$1(LifecycleEventObserver paramLifecycleEventObserver) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    this.val$observer.onStateChanged(paramLifecycleOwner, paramEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.Lifecycling.1
 * JD-Core Version:    0.7.0.1
 */