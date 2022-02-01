package com.tencent.qqmail.model.task;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

class QMSendMailTask$9
  extends FtnDefine.FtnCallback
{
  QMSendMailTask$9(QMSendMailTask paramQMSendMailTask, ArrayList paramArrayList, int paramInt) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMSendMailTask.access$1200(this.this$0);
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = QMSendMailTask.access$800(this.this$0).getInformation().getBigAttachList().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (MailBigAttach)paramArrayOfByte1.next();
      if ((paramArrayOfByte2.getFid() != null) && (this.val$tmpFids.contains(paramArrayOfByte2.getFid())))
      {
        long l = System.currentTimeMillis() + this.val$tmpRenewDay * 3600 * 24 * 1000;
        QMLog.log(4, "QMSendMailTask", "renew bigAttach " + paramArrayOfByte2.getName() + " new expireTime " + l);
        paramArrayOfByte2.setExpire(l);
        QMAttachManager.sharedInstance().updateBigAttachExpire(paramArrayOfByte2.getHashId(), l);
        FtnManager.sharedInstance().updateFtn(paramArrayOfByte2.getFid(), "expiretime", l / 1000L + "");
      }
    }
    QMSendMailTask.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.9
 * JD-Core Version:    0.7.0.1
 */