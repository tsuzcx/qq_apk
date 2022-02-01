package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class Fragment$2
  implements LifecycleEventObserver
{
  Fragment$2(Fragment paramFragment) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if ((paramEvent == Lifecycle.Event.ON_STOP) && (this.this$0.mView != null)) {
      this.this$0.mView.cancelPendingInputEvents();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.Fragment.2
 * JD-Core Version:    0.7.0.1
 */