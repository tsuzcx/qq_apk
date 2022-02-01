package com.tencent.imcore.message;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import tos;

public class OnLinePushMessageProcessor$2
  implements Runnable
{
  public OnLinePushMessageProcessor$2(tos paramtos, int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.aBm, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */