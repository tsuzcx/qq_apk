package com.tencent.mobileqq.vas.avatar;

import aqgm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

class VasFaceManager$2
  implements Runnable
{
  VasFaceManager$2(VasFaceManager paramVasFaceManager, String paramString) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.this$0.app.a(this.val$uin, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.faceIdUpdateTime != 0L))
    {
      this.this$0.A(this.val$uin, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.VasFaceManager", 2, "requestFaceId uin: " + this.val$uin);
    }
    aqgm.UC(this.val$uin);
    aqgm.ez(this.this$0.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.2
 * JD-Core Version:    0.7.0.1
 */