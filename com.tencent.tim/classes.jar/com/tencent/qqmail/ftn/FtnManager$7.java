package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.CreateFileOutput;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$7
  extends FtnDefine.FtnCallback
{
  FtnManager$7(FtnManager paramFtnManager, FtnUploadInfo paramFtnUploadInfo, FtnDefine.FtnCallback paramFtnCallback) {}
  
  public void onComplete()
  {
    super.onComplete();
  }
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn create file error, file: " + this.val$uploadItemData.getName() + ", size: " + this.val$uploadItemData.getFileSize() + ", error: " + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actioncreatefileerror", FtnManager.access$200(this.val$uploadItemData.getRid(), paramInt1, paramInt2, paramInt3, paramString, this.val$uploadItemData));
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onError(paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      CreateFileOutput localCreateFileOutput = new CreateFileOutput();
      localCreateFileOutput.parseFrom(paramArrayOfByte2);
      this.val$uploadItemData.setAborted(false);
      this.val$uploadItemData.setFid(localCreateFileOutput.fid);
      this.val$uploadItemData.setUploadedSize(0L);
      this.val$uploadItemData.setIp(localCreateFileOutput.ip);
      this.val$uploadItemData.setPort(localCreateFileOutput.port);
      this.val$uploadItemData.setKey(localCreateFileOutput.key);
      this.val$uploadItemData.setShakey(localCreateFileOutput.shakey);
      this.val$uploadItemData.setIsCreateFile(true);
      FtnManager.access$400(this.this$0, this.val$uploadItemData, 2);
      this.val$uploadItemData.setState(2);
      if (this.val$ftnCallback != null) {
        this.val$ftnCallback.onSuccess(paramArrayOfByte1, paramArrayOfByte2);
      }
      this.this$0.uploadFile(this.val$uploadItemData, localCreateFileOutput.ip, localCreateFileOutput.port, localCreateFileOutput.key, localCreateFileOutput.shakey, this.val$ftnCallback);
      QMLog.log(4, "FtnManager", "Ftn create file success, file: " + this.val$uploadItemData.getName() + ", size: " + this.val$uploadItemData.getFileSize());
      QMNotification.postNotification("actioncreatefilesucc", QMNotification.createNotification(new Object[] { "actioncreatefileuploaditemdata", this.val$uploadItemData, "actioncreatefileoutput", localCreateFileOutput }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn create file error, file: " + this.val$uploadItemData.getName() + ", size: " + this.val$uploadItemData.getFileSize(), paramArrayOfByte1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.7
 * JD-Core Version:    0.7.0.1
 */