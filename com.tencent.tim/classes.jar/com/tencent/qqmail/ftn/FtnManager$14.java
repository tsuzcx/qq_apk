package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.util.ArrayList;
import java.util.HashMap;

class FtnManager$14
  extends FtnDefine.FtnCallback
{
  FtnManager$14(FtnManager paramFtnManager, ArrayList paramArrayList1, ArrayList paramArrayList2, FtnDefine.FtnCallback paramFtnCallback) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onError(paramInt1, paramInt2, paramInt3, paramString);
    }
    QMLog.log(6, "FtnManager", "Ftn renew error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actionrenewfileerror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    HashMap localHashMap1 = new HashMap();
    int j = this.val$fids.size();
    int i = 0;
    while (i < j)
    {
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("expiretime", ((Integer)this.val$expiretimes.get(i)).toString());
      localHashMap1.put(this.val$fids.get(i), localHashMap2);
      i += 1;
    }
    this.this$0.updateFtn(localHashMap1);
    QMLog.log(4, "FtnManager", "Ftn renew " + this.val$fids.size() + " files success");
    if (this.val$ftnCallback != null) {
      this.val$ftnCallback.onSuccess(paramArrayOfByte1, paramArrayOfByte2);
    }
    QMNotification.postNotification("actionrenewfilesucc", QMNotification.createNotification(new Object[] { "paramfid", this.val$fids }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.14
 * JD-Core Version:    0.7.0.1
 */