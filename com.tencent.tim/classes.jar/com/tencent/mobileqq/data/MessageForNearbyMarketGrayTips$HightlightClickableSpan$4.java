package com.tencent.mobileqq.data;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan$4
  implements Runnable
{
  MessageForNearbyMarketGrayTips$HightlightClickableSpan$4(MessageForNearbyMarketGrayTips.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "0X80052C4");
    }
    anot.a(this.val$app, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, MessageForNearbyMarketGrayTips.a.a(this.this$0).frienduin, "", "", "");
    QQAppInterface localQQAppInterface;
    if ((MessageForNearbyMarketGrayTips.a.a(this.this$0).AioType == 1) || (MessageForNearbyMarketGrayTips.a.a(this.this$0).AioType == 3))
    {
      localQQAppInterface = this.val$app;
      if (MessageForNearbyMarketGrayTips.a.a(this.this$0).AioType != 0) {
        break label122;
      }
    }
    label122:
    for (String str = "0";; str = "1")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_blue", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.4
 * JD-Core Version:    0.7.0.1
 */