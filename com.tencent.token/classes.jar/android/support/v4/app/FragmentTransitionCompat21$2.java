package android.support.v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.View;
import java.util.ArrayList;

class FragmentTransitionCompat21$2
  implements Transition.TransitionListener
{
  FragmentTransitionCompat21$2(FragmentTransitionCompat21 paramFragmentTransitionCompat21, View paramView, ArrayList paramArrayList) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    paramTransition.removeListener(this);
    this.val$fragmentView.setVisibility(8);
    int j = this.val$exitingViews.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.val$exitingViews.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21.2
 * JD-Core Version:    0.7.0.1
 */