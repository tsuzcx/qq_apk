import android.animation.Animator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class auwf
  extends auwd.c
{
  auwf(auwd paramauwd, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramauwd, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.is) {}
    for (;;)
    {
      return;
      if (this.wk <= 0) {
        this.this$0.mCallback.clearView(this.this$0.mRecyclerView, this.i);
      }
      while (this.this$0.mOverdrawChild == this.i.itemView)
      {
        this.this$0.removeChildDrawingOrderCallbackIfNecessary(this.i.itemView);
        return;
        this.this$0.mPendingCleanup.add(this.i.itemView);
        this.ir = true;
        if (this.wk > 0) {
          this.this$0.postDispatchSwipe(this, this.wk);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwf
 * JD-Core Version:    0.7.0.1
 */