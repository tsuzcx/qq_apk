package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import apqk;
import apqk.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qphone.base.util.QLog;
import xqa.b;

public class TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1
  implements Runnable
{
  public TroopGiftMsgItemBuilder$TroopGiftMsgHolder$1(xqa.b paramb, apqk.a parama) {}
  
  public void run()
  {
    if (this.a.isFinish)
    {
      this.this$0.c.isLoading = false;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "GONE uniseq = " + this.this$0.c.uniseq);
      }
      ((apqk)xqa.b.a(this.this$0).getManager(223)).e(this.this$0);
      this.this$0.loadingView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + this.this$0.c.uniseq);
    }
    this.this$0.c.isLoading = true;
    this.this$0.loadingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1
 * JD-Core Version:    0.7.0.1
 */