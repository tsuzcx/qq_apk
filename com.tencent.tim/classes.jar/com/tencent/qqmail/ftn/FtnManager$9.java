package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.callback.FileSignCallback;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import rx.Subscriber;

class FtnManager$9
  implements FileSignCallback
{
  FtnManager$9(FtnManager paramFtnManager, Subscriber paramSubscriber, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void onError()
  {
    FtnManager.access$400(this.this$0, this.val$uploadItemData, 0);
    QMLog.log(6, "FtnManager", "Ftn sign file error");
    QMNotification.postNotification("actionsignfileerror", QMNotification.createNotification(new Object[] { "paramsignfileuploadeditemdata", this.val$uploadItemData }));
    if (this.val$subscriber != null) {
      this.val$subscriber.onError(new QMNetworkError(9, 3, "计算文件摘要失败，请确认文件是否存在"));
    }
  }
  
  public void onSuccess(FtnUploadInfo paramFtnUploadInfo)
  {
    FtnManager.access$400(this.this$0, paramFtnUploadInfo, 1);
    QMLog.log(4, "FtnManager", "Ftn signFile success " + FtnCommonUtils.LogUpload(paramFtnUploadInfo));
    QMNotification.postNotification("actionsignfilesucc", QMNotification.createNotification(new Object[] { "paramsignfileuploadeditemdata", paramFtnUploadInfo }));
    if (this.val$subscriber != null)
    {
      this.val$subscriber.onNext(paramFtnUploadInfo);
      this.val$subscriber.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.9
 * JD-Core Version:    0.7.0.1
 */