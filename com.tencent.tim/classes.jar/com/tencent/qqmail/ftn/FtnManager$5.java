package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.Ftn.GetShareUrlOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.ftn.util.SharedUrlUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$5
  extends FtnDefine.FtnCallback
{
  FtnManager$5(FtnManager paramFtnManager, String paramString1, int paramInt, String paramString2) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn get share url error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiongetshareurlerror", FtnManager.access$200("", paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new GetShareUrlOutput().parseFrom(paramArrayOfByte2);
      SharedUrlUtil.put(this.val$fid, paramArrayOfByte1.shareurl);
      QMLog.log(4, "FtnManager", "Ftn get share url success");
      QMNotification.postNotification("actiongetshareurlsucc", QMNotification.createNotification(new Object[] { "paramfid", this.val$fid, "paramactionid", Integer.valueOf(this.val$actionId), "paramfilename", this.val$fileName }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn get share url error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.5
 * JD-Core Version:    0.7.0.1
 */