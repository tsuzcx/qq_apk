package com.tencent.widget.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import auwd;
import auwd.a;
import auwd.c;

public class ItemTouchHelper$4
  implements Runnable
{
  public ItemTouchHelper$4(auwd paramauwd, auwd.c paramc, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRecyclerView != null) && (this.this$0.mRecyclerView.isAttachedToWindow()) && (!this.a.is) && (this.a.mViewHolder.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = this.this$0.mRecyclerView.getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!this.this$0.hasRunningRecoverAnim())) {
        this.this$0.mCallback.onSwiped(this.a.mViewHolder, this.wk);
      }
    }
    else
    {
      return;
    }
    this.this$0.mRecyclerView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.4
 * JD-Core Version:    0.7.0.1
 */