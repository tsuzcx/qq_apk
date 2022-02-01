package com.tencent.biz.richframework.part.block;

import java.util.ArrayList;
import rxn;
import rxq;

public class BlockMerger$1
  implements Runnable
{
  public BlockMerger$1(rxn paramrxn, rxq paramrxq) {}
  
  public void run()
  {
    try
    {
      this.b.onDetachedFromRecyclerView(this.this$0.getBlockContainer().a());
      this.this$0.c(this.b);
      rxn.a(this.this$0).remove(this.b);
      rxn.a(this.this$0, this.b, 2);
      this.this$0.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockMerger.1
 * JD-Core Version:    0.7.0.1
 */