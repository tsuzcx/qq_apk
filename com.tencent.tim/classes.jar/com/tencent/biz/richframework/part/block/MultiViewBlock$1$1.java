package com.tencent.biz.richframework.part.block;

import rxn;
import rxq;
import rxr;
import spp;

public class MultiViewBlock$1$1
  implements Runnable
{
  public MultiViewBlock$1$1(rxr paramrxr) {}
  
  public void run()
  {
    if (((Integer)spp.a().getValue("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.c.getBlockMerger().notifyItemRangeChanged(this.a.c.getGlobalPosition(0), this.a.c.getItemCount());
      return;
    }
    this.a.c.getBlockMerger().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.1
 * JD-Core Version:    0.7.0.1
 */