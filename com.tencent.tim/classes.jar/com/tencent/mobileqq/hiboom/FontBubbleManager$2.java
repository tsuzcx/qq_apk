package com.tencent.mobileqq.hiboom;

import acle;
import ahxg;
import ahyf;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FontBubbleManager$2
  implements Runnable
{
  public FontBubbleManager$2(ahxg paramahxg, BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ahyf localahyf = ahxg.a(this.this$0);
    if (localahyf != null)
    {
      acle localacle = (acle)ahxg.a(this.this$0).getBusinessHandler(13);
      localacle.JK(localahyf.b.bubbleId);
      localacle.gZ(localahyf.b.fontId, localahyf.b.engine);
      ahxg.a(this.this$0).obtainMessage(1001, this.j).sendToTarget();
      return;
    }
    QLog.e("FontBubbleManager", 1, "auth ok but mClick is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.2
 * JD-Core Version:    0.7.0.1
 */