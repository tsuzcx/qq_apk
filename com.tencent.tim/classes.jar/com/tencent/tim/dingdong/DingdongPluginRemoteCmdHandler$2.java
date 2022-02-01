package com.tencent.tim.dingdong;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class DingdongPluginRemoteCmdHandler$2
  implements Runnable
{
  DingdongPluginRemoteCmdHandler$2(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, String paramString1, int paramInt, long paramLong, String paramString2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord;
    if (localQQAppInterface != null)
    {
      localMessageRecord = localQQAppInterface.b().a(this.Ub, this.bET, this.rJ);
      if (localMessageRecord != null)
      {
        String str = localMessageRecord.getExtInfoFromExtStr("schedule_msg_accept_status");
        if (QLog.isDebugVersion()) {
          QLog.i("DingdongPluginRemoteCmdHandler", 1, "ScheduleAccept prepare update schedule message through ipc : " + localMessageRecord.uniseq);
        }
        if (str.equals(this.cHI)) {
          break label154;
        }
        localMessageRecord.saveExtInfoToExtStr("schedule_msg_accept_status", this.cHI);
        localQQAppInterface.b().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extStr", localMessageRecord.getExtInfoString());
        localQQAppInterface.b().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extLong", Integer.valueOf(localMessageRecord.extLong));
      }
    }
    label154:
    while (!QLog.isDebugVersion()) {
      return;
    }
    QLog.i("DingdongPluginRemoteCmdHandler", 1, "ScheduleAccept no need to update schedule message through ipc : " + localMessageRecord.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler.2
 * JD-Core Version:    0.7.0.1
 */