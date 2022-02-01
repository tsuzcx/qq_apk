package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$1
  implements Runnable
{
  QCircleFakeAdapter$1(QCircleFakeAdapter paramQCircleFakeAdapter, List paramList) {}
  
  public void run()
  {
    try
    {
      if (((this.this$0.getBlockContainer() instanceof QCircleBlockContainer)) && (this.this$0.getBlockContainer().a() != null) && (this.this$0.getBlockContainer().a().getVisibility() == 0))
      {
        this.this$0.getBlockContainer().a().setVisibility(8);
        QLog.i("QCircleFakeAdapter", 1, "onPublishFeedReload   StatusView == gone");
      }
      if (QCircleFakeAdapter.a(this.this$0).size() != this.lm.size())
      {
        if (QCircleFakeAdapter.a(this.this$0).size() == 0) {
          this.this$0.getDataList().addAll(0, this.lm);
        }
        for (;;)
        {
          QCircleFakeAdapter.a(this.this$0).clear();
          QCircleFakeAdapter.a(this.this$0).addAll(this.lm);
          this.this$0.notifyDataSetChanged();
          return;
          QCircleFakeAdapter.a(this.this$0);
          this.this$0.getDataList().addAll(0, this.lm);
        }
      }
      if (QCircleFakeAdapter.a(this.this$0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QCircleFakeAdapter", 1, "onPublishFeedReload exception:" + localException.toString());
      return;
    }
    this.this$0.getDataList().addAll(0, this.lm);
    QCircleFakeAdapter.a(this.this$0).addAll(this.lm);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.1
 * JD-Core Version:    0.7.0.1
 */