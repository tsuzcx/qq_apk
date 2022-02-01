package com.tencent.qqmail.ftn;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.ftn.Ftn.ShowUsrOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import java.io.IOException;

class FtnManager$16
  extends FtnDefine.FtnCallback
{
  FtnManager$16(FtnManager paramFtnManager) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn queryAccount error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    this.this$0.triggerFtnQueryAccountError(FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new ShowUsrOutput().parseFrom(paramArrayOfByte2);
      QMLog.log(4, "FtnManager", "Ftn queryAccount success");
      paramArrayOfByte2 = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
      if (paramArrayOfByte2 != null) {
        FtnManager.access$500(this.this$0, paramArrayOfByte1, paramArrayOfByte2.getUin());
      }
      FtnCommonUtils.setFtnLevel(paramArrayOfByte1.vlevel);
      this.this$0.triggerFtnQueryAccountSuccess(QMNotification.createNotification(new Object[] { "paramqueryaccountinfo", paramArrayOfByte1 }));
      return;
    }
    catch (IOException paramArrayOfByte1)
    {
      QMLog.log(6, "FtnManager", "Ftn queryAccount error:" + paramArrayOfByte1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.16
 * JD-Core Version:    0.7.0.1
 */