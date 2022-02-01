package com.tencent.qqmail.animation;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import java.util.Collection;

public class ListViewRemoveItemAnimator
{
  private static final String TAG = ListViewRemoveItemAnimator.class.getSimpleName();
  
  public static void animateRemoval(ListView paramListView, Collection<Integer> paramCollection, Runnable paramRunnable)
  {
    int j = paramListView.getHeaderViewsCount();
    int k = paramListView.getFirstVisiblePosition();
    int m = paramListView.getChildCount();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    int i = 0;
    while (i < m)
    {
      if (paramCollection.contains(Integer.valueOf(i + k - j)))
      {
        arrayOfInt[0] += 1;
        View localView = paramListView.getChildAt(i);
        ListViewRemoveItemAnimator.1 local1 = new ListViewRemoveItemAnimator.1(localView.getMeasuredHeight(), localView);
        local1.setAnimationListener(new ListViewRemoveItemAnimator.2(localView, arrayOfInt, paramRunnable, paramListView));
        local1.setDuration('È');
        localView.setAnimation(local1);
      }
      i += 1;
    }
    if (arrayOfInt[0] > 0)
    {
      paramListView.invalidate();
      paramListView.setEnabled(false);
      return;
    }
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.ListViewRemoveItemAnimator
 * JD-Core Version:    0.7.0.1
 */