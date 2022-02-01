package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import ltx;

public class ProteusPagerSnapHelper$1
  implements Runnable
{
  public ProteusPagerSnapHelper$1(ltx paramltx) {}
  
  public void run()
  {
    if (!ltx.a(this.this$0)) {
      return;
    }
    this.this$0.snapToTargetPosition(this.this$0.getCurrentPosition() + 1);
    ltx.a(this.this$0).postDelayed(this.this$0.cH, ltx.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */