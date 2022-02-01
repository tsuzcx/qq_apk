package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.ItemRarPreviewOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$15
  extends FtnDefine.FtnCallback
{
  FtnManager$15(FtnManager paramFtnManager) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn get compress preview error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiongetfilerarpreviewerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new ItemRarPreviewOutput().parseFrom(paramArrayOfByte2);
      QMLog.log(4, "FtnManager", "Ftn get compress preview success");
      QMNotification.postNotification("actiongetfilerarpreviewsucc", QMNotification.createNotification(new Object[] { "actiongetfilerarpreviewprvdata", paramArrayOfByte1 }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn get compress preview error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.15
 * JD-Core Version:    0.7.0.1
 */