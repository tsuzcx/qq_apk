package com.tencent.mobileqq.app;

import acff;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

final class SignatureManager$2
  implements Runnable
{
  SignatureManager$2(RichStatus paramRichStatus, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        RichStatus localRichStatus = this.e;
        Object localObject1 = (acff)localQQAppInterface.getManager(51);
        boolean bool = ((acff)localObject1).isFriend(this.bps);
        if (!bool) {
          return;
        }
        if (localRichStatus == null)
        {
          localObject1 = ((acff)localObject1).a(this.bps);
          if (localObject1 == null) {
            return;
          }
          bool = ((ExtensionInfo)localObject1).isAdded2C2C;
          if (bool) {
            return;
          }
          localRichStatus = ((ExtensionInfo)localObject1).getRichStatus();
          bool = SignatureManager.b(localRichStatus);
          if (bool) {
            return;
          }
          bool = SignatureManager.b(localQQAppInterface, localRichStatus, this.bps);
          if (bool) {
            return;
          }
          SignatureManager.b(localQQAppInterface, localRichStatus);
          bool = SignatureManager.A(localQQAppInterface, this.bps);
          if (bool) {
            return;
          }
          String str = SignatureManager.b(localRichStatus);
          if (str == null) {
            return;
          }
          SignatureManager.b(localQQAppInterface, localRichStatus, (ExtensionInfo)localObject1, str, this.bps);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("Signature", 2, "insertSignMsgIfNeeded exception:" + localException);
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insert signature cost:" + (System.currentTimeMillis() - l) + " ms");
        }
        SignatureManager.FH(true);
      }
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.2
 * JD-Core Version:    0.7.0.1
 */