package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

class FragmentTransitionCompat21$4
  extends Transition.EpicenterCallback
{
  FragmentTransitionCompat21$4(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Rect paramRect) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    if ((this.val$epicenter == null) || (this.val$epicenter.isEmpty())) {
      return null;
    }
    return this.val$epicenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.4
 * JD-Core Version:    0.7.0.1
 */