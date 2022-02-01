package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;

final class FragmentTransition$3
  implements Runnable
{
  FragmentTransition$3(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap, View paramView, FragmentTransitionImpl paramFragmentTransitionImpl, Rect paramRect) {}
  
  public void run()
  {
    FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
    if (this.val$epicenterView != null) {
      this.val$impl.getBoundsOnScreen(this.val$epicenterView, this.val$epicenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.3
 * JD-Core Version:    0.7.0.1
 */