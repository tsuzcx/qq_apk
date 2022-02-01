package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$5
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$5(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    ViewCompat.setAlpha(paramView, 1.0F);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.val$animation.setListener(null);
    this.this$0.dispatchAddFinished(this.val$holder);
    DefaultItemAnimator.access$900(this.this$0).remove(this.val$holder);
    DefaultItemAnimator.access$800(this.this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.dispatchAddStarting(this.val$holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.5
 * JD-Core Version:    0.7.0.1
 */