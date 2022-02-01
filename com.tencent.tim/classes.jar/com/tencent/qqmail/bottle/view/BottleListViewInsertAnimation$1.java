package com.tencent.qqmail.bottle.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListView;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.qqmail.utilities.ui.InsertionListView.OnRowAdditionAnimationListener;
import java.util.ArrayList;

class BottleListViewInsertAnimation$1
  implements ViewTreeObserver.OnPreDrawListener
{
  BottleListViewInsertAnimation$1(BottleListViewInsertAnimation paramBottleListViewInsertAnimation, ViewTreeObserver paramViewTreeObserver) {}
  
  public boolean onPreDraw()
  {
    this.val$observer.removeOnPreDrawListener(this);
    ArrayList localArrayList = new ArrayList();
    int i = BottleListViewInsertAnimation.access$000(this.this$0).getHeaderViewsCount();
    Object localObject = BottleListViewInsertAnimation.access$000(this.this$0).getChildAt(i);
    i = ((View)localObject).getHeight();
    localArrayList.add(ObjectAnimator.ofFloat(localObject, "translationY", new float[] { -(BottleListViewInsertAnimation.access$000(this.this$0).getDividerHeight() + i), 0.0F }).setDuration(200L));
    int j = BottleListViewInsertAnimation.access$000(this.this$0).getDividerHeight();
    localArrayList.add(ObjectAnimator.ofFloat(BottleListViewInsertAnimation.access$100(this.this$0), "translationY", new float[] { 0.0F, j + i }).setDuration(200L));
    if (BottleListViewInsertAnimation.access$200(this.this$0) != null) {
      BottleListViewInsertAnimation.access$200(this.this$0).onRowAdditionAnimationStart();
    }
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localArrayList);
    ((AnimatorSet)localObject).addListener(new BottleListViewInsertAnimation.1.1(this));
    ((AnimatorSet)localObject).start();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleListViewInsertAnimation.1
 * JD-Core Version:    0.7.0.1
 */