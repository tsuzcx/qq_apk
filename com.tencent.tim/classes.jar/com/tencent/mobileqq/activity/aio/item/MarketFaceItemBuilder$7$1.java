package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Set;

class MarketFaceItemBuilder$7$1
  implements Runnable
{
  MarketFaceItemBuilder$7$1(MarketFaceItemBuilder.7 param7, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.a.this$0.bo.isEmpty())
    {
      this.a.this$0.bo.remove(Long.valueOf(this.a.b.uniseq));
      MarketFaceItemBuilder.a(this.a.this$0, this.a.a, this.a.b.uniseq);
      if (!this.aTQ) {
        QQToast.a(this.a.this$0.mContext, 1, 2131690146, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.1
 * JD-Core Version:    0.7.0.1
 */