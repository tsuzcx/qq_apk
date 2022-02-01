package com.tencent.qqmail.model.sendmail;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class SendMailManager$21
  implements Observable.OnSubscribe<FtnUploadInfo>
{
  SendMailManager$21(SendMailManager paramSendMailManager, Pair paramPair, SendMailManager.BytesWrittenRecord paramBytesWrittenRecord, MailManagerDelegate paramMailManagerDelegate, int paramInt, SendMailFtnCallback paramSendMailFtnCallback) {}
  
  @NonNull
  private FtnDefine.FtnCallback getFtnCallback(Subscriber<? super FtnUploadInfo> paramSubscriber, FtnUploadInfo paramFtnUploadInfo, AttachInfo paramAttachInfo)
  {
    return new SendMailManager.21.1(this, paramFtnUploadInfo, paramAttachInfo, paramSubscriber);
  }
  
  public void call(Subscriber<? super FtnUploadInfo> paramSubscriber)
  {
    FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)this.val$attachInfoFtnUploadInfoPair.second;
    AttachInfo localAttachInfo = (AttachInfo)this.val$attachInfoFtnUploadInfoPair.first;
    Log.d(SendMailManager.access$100(), localAttachInfo.getAttachName() + " fid=" + localFtnUploadInfo.getFid());
    if (TextUtils.isEmpty(localFtnUploadInfo.getFid()))
    {
      QMLog.log(4, SendMailManager.access$100(), "uploadBigAttach, createFile, " + localAttachInfo.getAttachName());
      FtnManager.sharedInstance().createFile(localFtnUploadInfo, getFtnCallback(paramSubscriber, localFtnUploadInfo, localAttachInfo));
      return;
    }
    if ((localFtnUploadInfo.getProgress() >= 100) || (localFtnUploadInfo.getState() == 8))
    {
      QMLog.log(4, SendMailManager.access$100(), "uploadBigAttach, attach finish uploading, " + localAttachInfo.getAttachName() + ", fid:" + localFtnUploadInfo.getFid());
      paramSubscriber.onNext(localFtnUploadInfo);
      return;
    }
    QMLog.log(4, SendMailManager.access$100(), "uploadBigAttach, uploadFile, " + localAttachInfo.getAttachName() + ", fid:" + localFtnUploadInfo.getFid());
    localFtnUploadInfo.setIsCreateFile(true);
    FtnManager.sharedInstance().uploadFile(localFtnUploadInfo, localFtnUploadInfo.getIp(), localFtnUploadInfo.getPort(), localFtnUploadInfo.getKey(), localFtnUploadInfo.getShakey(), getFtnCallback(paramSubscriber, localFtnUploadInfo, localAttachInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.21
 * JD-Core Version:    0.7.0.1
 */