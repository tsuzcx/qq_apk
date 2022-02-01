package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.ftn.callback.SaveFtnFileCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$17
  extends FtnDefine.FtnCallback
{
  FtnManager$17(FtnManager paramFtnManager, SaveFtnFileCallback paramSaveFtnFileCallback) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn save file error");
    QMNotification.postNotification("actionsavefileerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
    if (this.val$callback != null) {
      this.val$callback.onError(paramInt1);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new StoreFileOutput().parseFrom(paramArrayOfByte2);
      QMLog.log(4, "FtnManager", "Ftn save file success");
      QMNotification.postNotification("actionsavefilesucc", QMNotification.createNotification(new Object[] { "paramsavefileinfo", paramArrayOfByte1 }));
      if (this.val$callback != null) {
        this.val$callback.onSuccess(paramArrayOfByte1);
      }
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn save file error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.17
 * JD-Core Version:    0.7.0.1
 */