package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.model.mail.loader.ProtocolInlineImgCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$30
  implements LoadMailAttachCallBack
{
  QMMailProtocolManager$30(QMMailProtocolManager paramQMMailProtocolManager, ProtocolInlineImgCallback paramProtocolInlineImgCallback) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    if (this.val$callback != null) {
      this.val$callback.onError(paramQMProtocolError);
    }
  }
  
  public boolean onProgress(long paramLong1, long paramLong2)
  {
    if (this.val$callback != null) {
      return this.val$callback.onProgress(paramLong1, paramLong2);
    }
    return false;
  }
  
  public void onSuccess(String paramString, Attach paramAttach)
  {
    if (this.val$callback != null) {
      this.val$callback.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.30
 * JD-Core Version:    0.7.0.1
 */