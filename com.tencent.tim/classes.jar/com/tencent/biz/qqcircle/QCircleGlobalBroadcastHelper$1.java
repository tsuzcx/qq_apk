package com.tencent.biz.qqcircle;

import acks;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class QCircleGlobalBroadcastHelper$1
  implements Runnable
{
  QCircleGlobalBroadcastHelper$1(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void run()
  {
    Object localObject = QCircleGlobalBroadcastHelper.b();
    if (localObject != null)
    {
      localObject = (acks)((AppInterface)localObject).getBusinessHandler(87);
      if (localObject != null)
      {
        QLog.i(QCircleGlobalBroadcastHelper.access$000(), 1, "handleQQCirclePush sendRedpointReq");
        ((acks)localObject).bJ(true, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.1
 * JD-Core Version:    0.7.0.1
 */