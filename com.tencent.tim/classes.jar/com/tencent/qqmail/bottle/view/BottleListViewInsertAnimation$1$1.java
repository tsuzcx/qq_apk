package com.tencent.qqmail.bottle.view;

import android.widget.ImageView;
import android.widget.ListView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.qqmail.utilities.ui.InsertionListView.OnRowAdditionAnimationListener;

class BottleListViewInsertAnimation$1$1
  extends AnimatorListenerAdapter
{
  BottleListViewInsertAnimation$1$1(BottleListViewInsertAnimation.1 param1) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (BottleListViewInsertAnimation.access$200(this.this$1.this$0) != null) {
      BottleListViewInsertAnimation.access$200(this.this$1.this$0).onRowAdditionAnimationEnd();
    }
    BottleListViewInsertAnimation.access$100(this.this$1.this$0).setVisibility(8);
    BottleListViewInsertAnimation.access$000(this.this$1.this$0).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleListViewInsertAnimation.1.1
 * JD-Core Version:    0.7.0.1
 */