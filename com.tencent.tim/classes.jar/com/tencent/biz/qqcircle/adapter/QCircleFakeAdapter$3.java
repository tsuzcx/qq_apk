package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;

class QCircleFakeAdapter$3
  implements Runnable
{
  QCircleFakeAdapter$3(QCircleFakeAdapter paramQCircleFakeAdapter, int paramInt) {}
  
  public void run()
  {
    this.this$0.vd(this.bgu);
    if ((this.this$0.getDataList() != null) && (this.this$0.getDataList().size() == 0) && (this.this$0.getBlockContainer() != null) && ((this.this$0.getBlockContainer() instanceof QCircleBlockContainer)) && (this.this$0.getBlockContainer().a() != null) && (this.this$0.getBlockContainer().a().getVisibility() == 8)) {
      this.this$0.getBlockContainer().a().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.3
 * JD-Core Version:    0.7.0.1
 */