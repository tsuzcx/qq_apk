package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;

class KandianMergeManager$32
  implements Runnable
{
  KandianMergeManager$32(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.b(this.this$0) != null)
    {
      Iterator localIterator = KandianMergeManager.b(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.e)localIterator.next()).aIZ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.32
 * JD-Core Version:    0.7.0.1
 */