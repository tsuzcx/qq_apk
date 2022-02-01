package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$29
  implements LoadMailAttachCallBack
{
  QMMailProtocolManager$29(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    if (this.val$callback != null)
    {
      this.val$callback.handleError(paramQMProtocolError);
      this.val$callback.handleComplete(paramQMProtocolError);
    }
  }
  
  public boolean onProgress(long paramLong1, long paramLong2)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSendData(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
    return false;
  }
  
  public void onSuccess(String paramString, Attach paramAttach)
  {
    if (this.val$callback != null)
    {
      this.val$callback.handleSuccess(paramString, paramAttach);
      this.val$callback.handleComplete(paramAttach);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.29
 * JD-Core Version:    0.7.0.1
 */