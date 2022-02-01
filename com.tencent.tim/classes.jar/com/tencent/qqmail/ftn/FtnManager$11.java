package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.ItemAddVideoTaskOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$11
  extends FtnDefine.FtnCallback
{
  FtnManager$11(FtnManager paramFtnManager) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn trans code video error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiontranscodevideoerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new ItemAddVideoTaskOutput().parseFrom(paramArrayOfByte2);
      QMLog.log(4, "FtnManager", "Ftn trans code video success!");
      QMNotification.postNotification("actiontranscodevideosucc", QMNotification.createNotification(new Object[] { "paramtranscodevideoresult", Integer.valueOf(paramArrayOfByte1.result) }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn trans code video error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.11
 * JD-Core Version:    0.7.0.1
 */