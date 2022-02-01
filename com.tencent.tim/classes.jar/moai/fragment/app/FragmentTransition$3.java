package moai.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;

final class FragmentTransition$3
  implements Runnable
{
  FragmentTransition$3(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap, View paramView, Rect paramRect) {}
  
  public void run()
  {
    FragmentTransition.access$200(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
    if (this.val$epicenterView != null) {
      FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView, this.val$epicenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransition.3
 * JD-Core Version:    0.7.0.1
 */