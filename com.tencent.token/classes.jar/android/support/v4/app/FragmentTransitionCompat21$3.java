package android.support.v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

class FragmentTransitionCompat21$3
  implements Transition.TransitionListener
{
  FragmentTransitionCompat21$3(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {}
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition)
  {
    if (this.val$enterTransition != null) {
      this.this$0.replaceTargets(this.val$enterTransition, this.val$enteringViews, null);
    }
    if (this.val$exitTransition != null) {
      this.this$0.replaceTargets(this.val$exitTransition, this.val$exitingViews, null);
    }
    if (this.val$sharedElementTransition != null) {
      this.this$0.replaceTargets(this.val$sharedElementTransition, this.val$sharedElementsIn, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionCompat21.3
 * JD-Core Version:    0.7.0.1
 */