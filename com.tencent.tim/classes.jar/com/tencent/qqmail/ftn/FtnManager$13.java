package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.util.ArrayList;

class FtnManager$13
  extends FtnDefine.FtnCallback
{
  FtnManager$13(FtnManager paramFtnManager, ArrayList paramArrayList) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn del file error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiondelfileerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    FtnManager.access$100(this.this$0).deleteFtn(this.val$fids);
    QMLog.log(4, "FtnManager", "Ftn del file success");
    QMNotification.postNotification("actiondelfilesucc", QMNotification.createNotification(new Object[] { "paramdelfilesuccfids", this.val$fids }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.13
 * JD-Core Version:    0.7.0.1
 */