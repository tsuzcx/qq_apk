package android.support.v7.widget;

import android.support.annotation.NonNull;

class RecyclerView$4
  implements ViewInfoStore.ProcessCallback
{
  RecyclerView$4(RecyclerView paramRecyclerView) {}
  
  public void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    RecyclerView.access$800(this.this$0, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void processDisappeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    this.this$0.mRecycler.unscrapView(paramViewHolder);
    RecyclerView.access$700(this.this$0, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void processPersistent(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (RecyclerView.access$900(this.this$0)) {
      if (this.this$0.mItemAnimator.animateChange(paramViewHolder, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
        RecyclerView.access$1000(this.this$0);
      }
    }
    while (!this.this$0.mItemAnimator.animatePersistence(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      return;
    }
    RecyclerView.access$1000(this.this$0);
  }
  
  public void unused(RecyclerView.ViewHolder paramViewHolder)
  {
    this.this$0.mLayout.removeAndRecycleView(paramViewHolder.itemView, this.this$0.mRecycler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.4
 * JD-Core Version:    0.7.0.1
 */