package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

final class FragmentTransition$4
  implements Runnable
{
  FragmentTransition$4(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject1, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList paramArrayList1, View paramView, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayList paramArrayList2, Object paramObject2, Rect paramRect) {}
  
  public void run()
  {
    Object localObject = FragmentTransition.access$300(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
    if (localObject != null)
    {
      this.val$sharedElementsIn.addAll(((ArrayMap)localObject).values());
      this.val$sharedElementsIn.add(this.val$nonExistentView);
    }
    FragmentTransition.access$200(this.val$inFragment, this.val$outFragment, this.val$inIsPop, (ArrayMap)localObject, false);
    if (this.val$finalSharedElementTransition != null)
    {
      this.val$impl.swapSharedElementTargets(this.val$finalSharedElementTransition, this.val$sharedElementsOut, this.val$sharedElementsIn);
      localObject = FragmentTransition.access$400((ArrayMap)localObject, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
      if (localObject != null) {
        this.val$impl.getBoundsOnScreen((View)localObject, this.val$inEpicenter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransition.4
 * JD-Core Version:    0.7.0.1
 */