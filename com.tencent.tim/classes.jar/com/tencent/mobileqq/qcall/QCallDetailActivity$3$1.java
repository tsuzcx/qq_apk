package com.tencent.mobileqq.qcall;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class QCallDetailActivity$3$1
  implements Runnable
{
  QCallDetailActivity$3$1(QCallDetailActivity.3 param3, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    if (QCallDetailActivity.a(this.a.this$0) == null) {
      return;
    }
    if ((this.EZ != null) && (this.EZ.size() > 0))
    {
      if (QCallDetailActivity.a(this.a.this$0).records == null) {
        break label131;
      }
      QCallDetailActivity.a(this.a.this$0).records.clear();
    }
    for (;;)
    {
      QCallDetailActivity.a(this.a.this$0).records.addAll(this.EZ);
      QCallDetailActivity.a(this.a.this$0, this.cxw);
      if (QCallDetailActivity.a(this.a.this$0) == null) {
        break;
      }
      QCallDetailActivity.a(this.a.this$0).notifyDataSetChanged();
      return;
      label131:
      QCallDetailActivity.a(this.a.this$0).records = new CopyOnWriteArrayList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.3.1
 * JD-Core Version:    0.7.0.1
 */