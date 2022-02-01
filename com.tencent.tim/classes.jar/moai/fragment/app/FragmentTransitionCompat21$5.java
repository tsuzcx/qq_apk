package moai.fragment.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

final class FragmentTransitionCompat21$5
  implements Transition.TransitionListener
{
  FragmentTransitionCompat21$5(Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {}
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition)
  {
    if (this.val$enterTransition != null) {
      FragmentTransitionCompat21.replaceTargets(this.val$enterTransition, this.val$enteringViews, null);
    }
    if (this.val$exitTransition != null) {
      FragmentTransitionCompat21.replaceTargets(this.val$exitTransition, this.val$exitingViews, null);
    }
    if (this.val$sharedElementTransition != null) {
      FragmentTransitionCompat21.replaceTargets(this.val$sharedElementTransition, this.val$sharedElementsIn, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransitionCompat21.5
 * JD-Core Version:    0.7.0.1
 */