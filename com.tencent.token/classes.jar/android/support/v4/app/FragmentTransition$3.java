package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.util.ArrayMap;
import android.view.View;

final class FragmentTransition$3
  implements Runnable
{
  FragmentTransition$3(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap, View paramView, FragmentTransitionImpl paramFragmentTransitionImpl, Rect paramRect) {}
  
  public void run()
  {
    FragmentTransition.access$200(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
    if (this.val$epicenterView != null) {
      this.val$impl.getBoundsOnScreen(this.val$epicenterView, this.val$epicenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransition.3
 * JD-Core Version:    0.7.0.1
 */