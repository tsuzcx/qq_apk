package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMFtnUploadNotification;

class FtnManager$10
  extends FtnDefine.FtnCallback
{
  FtnManager$10(FtnManager paramFtnManager, FtnDefine.FtnCallback paramFtnCallback, FtnUploadInfo paramFtnUploadInfo) {}
  
  public void onBeforeSend()
  {
    if (this.this$0.isClearUploadNotify()) {
      QMFtnUploadNotification.getInstance().cancel();
    }
    super.onBeforeSend();
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onBeforeSend();
    }
  }
  
  public void onComplete()
  {
    super.onComplete();
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onComplete();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt1 != 5) {
      FtnManager.access$300(this.this$0, this.val$uploadItemData.getFid());
    }
    QMLog.log(6, "FtnManager", "Ftn upload file error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actionuploadfileerror", FtnManager.access$200(this.val$uploadItemData.getRid(), paramInt1, paramInt2, paramInt3, paramString, this.val$uploadItemData));
    if (paramInt1 == 5) {
      this.val$uploadItemData.setState(3);
    }
    for (;;)
    {
      FtnManager.access$400(this.this$0, this.val$uploadItemData, 2);
      this.this$0.checkUploadStAndNotify();
      if (this.val$ftnCallback != null) {
        this.val$ftnCallback.onError(paramInt1, paramInt2, paramInt3, paramString);
      }
      return;
      this.val$uploadItemData.setState(4);
    }
  }
  
  public void onProcessData(long paramLong1, long paramLong2)
  {
    this.val$uploadItemData.setUploadedSize(paramLong1);
    int i = FtnCommonUtils.calcProgress(paramLong1, paramLong2, 1.0D);
    this.this$0.updateUploadInfoProgress(this.val$uploadItemData.getFid(), i);
    this.val$uploadItemData.setProgress(i);
    this.val$uploadItemData.setSchedule(i);
    this.val$uploadItemData.setState(2);
    if (this.val$uploadItemData.getStage() == 2) {}
    QMLog.log(3, "FtnManager", "uploadFile onProcessData:" + this.val$uploadItemData.getUploadedSize() + "," + this.val$uploadItemData.getFileSize() + "," + i);
    QMNotification.postNotification("actionuploadfileprogress", QMNotification.createNotification(new Object[] { "prarmuploadfileprogressuploaditemdata", this.val$uploadItemData, "paramuploadfileloaded", Long.valueOf(paramLong1), "paramuploadfiletotal", Long.valueOf(paramLong2) }));
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onProcessData(paramLong1, paramLong2);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FtnManager.access$300(this.this$0, this.val$uploadItemData.getFid());
    QMLog.log(4, "FtnManager", "Ftn upload file success");
    QMNotification.postNotification("actionuploadfilesucc", QMNotification.createNotification(new Object[] { "paramfid", this.val$uploadItemData.getFid(), "prarmuploadfileprogressuploaditemdata", this.val$uploadItemData }));
    this.val$uploadItemData.setState(8);
    this.this$0.removeUploadData(this.val$uploadItemData.getFid());
    this.this$0.checkUploadStAndNotify();
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onSuccess(paramArrayOfByte1, paramArrayOfByte2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.10
 * JD-Core Version:    0.7.0.1
 */