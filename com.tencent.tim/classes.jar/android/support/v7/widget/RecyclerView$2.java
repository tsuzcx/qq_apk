package android.support.v7.widget;

class RecyclerView$2
  implements Runnable
{
  RecyclerView$2(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (this.this$0.mItemAnimator != null) {
      this.this$0.mItemAnimator.runPendingAnimations();
    }
    RecyclerView.access$602(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.2
 * JD-Core Version:    0.7.0.1
 */