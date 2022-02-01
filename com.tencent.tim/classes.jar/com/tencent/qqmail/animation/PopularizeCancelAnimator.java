package com.tencent.qqmail.animation;

import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;

public class PopularizeCancelAnimator
{
  public static int duration = 200;
  
  public static void animateRemoval(LinearLayout paramLinearLayout, int[] paramArrayOfInt, Runnable paramRunnable)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    int i = 0;
    if (i < paramLinearLayout.getChildCount())
    {
      j = 0;
      label23:
      if (j >= paramArrayOfInt.length) {
        break label155;
      }
      if (paramArrayOfInt[j] != i) {}
    }
    label155:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        arrayOfInt[0] += 1;
        View localView = paramLinearLayout.getChildAt(i);
        PopularizeCancelAnimator.1 local1 = new PopularizeCancelAnimator.1(localView.getMeasuredHeight(), localView);
        local1.setAnimationListener(new PopularizeCancelAnimator.2(arrayOfInt, paramRunnable, paramLinearLayout));
        local1.setDuration(duration);
        localView.setAnimation(local1);
      }
      i += 1;
      break;
      j += 1;
      break label23;
      if (arrayOfInt[0] > 0)
      {
        paramLinearLayout.invalidate();
        paramLinearLayout.setEnabled(false);
      }
      while (paramRunnable == null) {
        return;
      }
      paramRunnable.run();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.PopularizeCancelAnimator
 * JD-Core Version:    0.7.0.1
 */