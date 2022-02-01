package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$6
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$6(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (this.val$deltaX != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.val$deltaY != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.val$animation.setListener(null);
    this.this$0.dispatchMoveFinished(this.val$holder);
    DefaultItemAnimator.access$1100(this.this$0).remove(this.val$holder);
    DefaultItemAnimator.access$800(this.this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.dispatchMoveStarting(this.val$holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.6
 * JD-Core Version:    0.7.0.1
 */