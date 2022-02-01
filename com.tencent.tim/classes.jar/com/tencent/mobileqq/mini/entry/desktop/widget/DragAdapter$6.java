package com.tencent.mobileqq.mini.entry.desktop.widget;

import acfp;
import aekv;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class DragAdapter$6
  implements Runnable
{
  DragAdapter$6(DragAdapter paramDragAdapter, int paramInt) {}
  
  public void run()
  {
    QQToast.a(DragAdapter.access$600(this.this$0), acfp.m(2131705297) + aekv.getMaxTopNum() + acfp.m(2131705296), 0).show();
    if (this.val$overTopTargetIndex != -1)
    {
      this.this$0.mData.remove(this.val$overTopTargetIndex);
      this.this$0.notifyItemRemoved(this.val$overTopTargetIndex);
      this.this$0.notifyItemRangeChanged(this.val$overTopTargetIndex, this.this$0.getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.6
 * JD-Core Version:    0.7.0.1
 */