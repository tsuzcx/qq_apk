package com.tencent.biz.richframework.part.block;

import rxn;
import rxq;
import rxr;

public class MultiViewBlock$1$5
  implements Runnable
{
  public MultiViewBlock$1$5(rxr paramrxr, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.a.c.getBlockMerger().notifyItemRangeRemoved(this.a.c.getGlobalPosition(this.bvN), this.bvO);
    this.a.c.getBlockMerger().notifyItemRangeChanged(this.a.c.getGlobalPosition(this.bvN), this.a.c.getBlockMerger().getItemCount() - this.a.c.getGlobalPosition(this.bvN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.5
 * JD-Core Version:    0.7.0.1
 */