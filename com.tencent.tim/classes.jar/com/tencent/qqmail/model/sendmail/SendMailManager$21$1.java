package com.tencent.qqmail.model.sendmail;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Map;
import rx.Subscriber;

class SendMailManager$21$1
  extends FtnDefine.FtnCallback
{
  SendMailManager$21$1(SendMailManager.21 param21, FtnUploadInfo paramFtnUploadInfo, AttachInfo paramAttachInfo, Subscriber paramSubscriber) {}
  
  public void onBeforeSend() {}
  
  public void onComplete()
  {
    this.val$subscriber.onCompleted();
  }
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, SendMailManager.access$100(), "FtnCallback onError, cgiExceptionCode:" + paramInt1 + ", logicCode:" + paramInt2 + ", errorType:" + paramInt3 + ", description:" + paramString);
    this.val$subscriber.onError(new QMNetworkError(9, paramInt1, SendMailManager.access$1300(this.this$1.this$0, paramInt1, paramString)));
  }
  
  public void onProcessData(long paramLong1, long paramLong2)
  {
    Log.d(SendMailManager.access$100(), "FtnCallback currPos:" + paramLong1 + ", totalLength:" + paramLong2);
    this.this$1.val$bytesWrittenRecord.bytesWrittenByFilePathMap.put(this.val$ftnUploadInfo.getAbsolutePath(), Long.valueOf(paramLong1));
    paramLong1 = this.this$1.val$bytesWrittenRecord.getBytesWritten();
    if (this.this$1.val$callback != null)
    {
      Log.d(SendMailManager.access$100(), "FtnCallback bytesWritten:" + paramLong1 + ", totalBytes:" + this.this$1.val$bytesWrittenRecord.totalBytes);
      this.this$1.val$callback.handleSendData(Long.valueOf(paramLong1), Long.valueOf(this.this$1.val$bytesWrittenRecord.totalBytes));
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    QMLog.log(4, SendMailManager.access$100(), "ftnUploadSuccess " + this.val$ftnUploadInfo.getName() + ", state:" + this.val$ftnUploadInfo.getState() + ", attachId:" + this.val$attachInfo.getHashId() + ", fid:" + this.val$ftnUploadInfo.getFid());
    if (this.val$ftnUploadInfo.getState() == 2) {
      if (!TextUtils.isEmpty(this.val$ftnUploadInfo.getFid()))
      {
        this.val$attachInfo.setFid(this.val$ftnUploadInfo.getFid());
        int i = SendMailManager.access$1200(this.this$1.this$0).updateQMSendMailTask(this.this$1.val$taskId, this.val$attachInfo.getHashId(), this.val$ftnUploadInfo.getFid());
        Log.d(SendMailManager.access$100(), "updateQMSendMailTask, updateAttachFidCnt:" + i);
        if (this.this$1.val$sendMailFtnFidCallback != null) {
          this.this$1.val$sendMailFtnFidCallback.onFtnAttachStratUpload(this.val$ftnUploadInfo);
        }
      }
    }
    do
    {
      return;
      if (this.val$ftnUploadInfo.getState() == 8)
      {
        this.val$subscriber.onNext(this.val$ftnUploadInfo);
        return;
      }
      if (this.val$ftnUploadInfo.getState() == 3)
      {
        this.val$subscriber.onError(new QMCancelError(true));
        return;
      }
    } while (this.val$ftnUploadInfo.getState() != 4);
    this.val$subscriber.onError(new QMNetworkError(9, 0, QMApplicationContext.sharedInstance().getString(2131719540)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.21.1
 * JD-Core Version:    0.7.0.1
 */