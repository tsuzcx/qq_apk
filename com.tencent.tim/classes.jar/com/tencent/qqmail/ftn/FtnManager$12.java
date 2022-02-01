package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.ItemViewVideoOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$12
  extends FtnDefine.FtnCallback
{
  FtnManager$12(FtnManager paramFtnManager, String paramString) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn get video preview error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiongetfilepreviewerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onProcessData(long paramLong1, long paramLong2)
  {
    super.onProcessData(paramLong1, paramLong2);
    QMNotification.postNotification("actiongetpreviewprogress", QMNotification.createNotification(new Object[] { "paramfid", this.val$fid, "paramgetfilepreviewloaded", Long.valueOf(paramLong1), "paramgetfilepreviewtotal", Long.valueOf(paramLong2) }));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new ItemViewVideoOutput().parseFrom(paramArrayOfByte2);
      QMLog.log(4, "FtnManager", "Ftn get video preview success!");
      QMNotification.postNotification("actiongetfilepreviewsucc", QMNotification.createNotification(new Object[] { "paramtranscodevideoresult", paramArrayOfByte1 }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn get video preview error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.12
 * JD-Core Version:    0.7.0.1
 */