package android.support.v4.app;

import android.view.View;
import java.util.ArrayList;

final class FragmentTransition$2
  implements Runnable
{
  FragmentTransition$2(Object paramObject1, FragmentTransitionImpl paramFragmentTransitionImpl, View paramView, Fragment paramFragment, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Object paramObject2) {}
  
  public void run()
  {
    ArrayList localArrayList;
    if (this.val$enterTransition != null)
    {
      this.val$impl.removeTarget(this.val$enterTransition, this.val$nonExistentView);
      localArrayList = FragmentTransition.access$100(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView);
      this.val$enteringViews.addAll(localArrayList);
    }
    if (this.val$exitingViews != null)
    {
      if (this.val$exitTransition != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.val$nonExistentView);
        this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, localArrayList);
      }
      this.val$exitingViews.clear();
      this.val$exitingViews.add(this.val$nonExistentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransition.2
 * JD-Core Version:    0.7.0.1
 */