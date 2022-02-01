package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;

class SendMailManager$1
  implements SendMailFtnCallback
{
  SendMailManager$1(SendMailManager paramSendMailManager, SendMailRequest paramSendMailRequest) {}
  
  public void onFtnAttachStratUpload(FtnUploadInfo paramFtnUploadInfo)
  {
    Log.d(SendMailManager.access$100(), "onFtnAttachStratUpload, fid: " + paramFtnUploadInfo.getFid());
    this.val$sendMailRequest.addFtnUploadInfo(paramFtnUploadInfo);
  }
  
  public void onNormalAttachStratUpload(long paramLong)
  {
    Log.d(SendMailManager.access$100(), "onNormalAttachStratUpload, ftnTaskId: " + paramLong);
    this.val$sendMailRequest.addFtnTaskId(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.1
 * JD-Core Version:    0.7.0.1
 */