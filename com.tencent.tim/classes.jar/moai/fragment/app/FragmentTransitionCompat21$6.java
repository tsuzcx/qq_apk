package moai.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class FragmentTransitionCompat21$6
  extends Transition.EpicenterCallback
{
  FragmentTransitionCompat21$6(Rect paramRect) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    if ((this.val$epicenter == null) || (this.val$epicenter.isEmpty())) {
      return null;
    }
    return this.val$epicenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransitionCompat21.6
 * JD-Core Version:    0.7.0.1
 */