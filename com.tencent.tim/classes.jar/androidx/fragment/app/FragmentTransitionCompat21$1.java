package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

class FragmentTransitionCompat21$1
  extends Transition.EpicenterCallback
{
  FragmentTransitionCompat21$1(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Rect paramRect) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    return this.val$epicenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.1
 * JD-Core Version:    0.7.0.1
 */