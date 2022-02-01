package com.tencent.mobileqq.data;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class MessageForQQWalletTips$1$1
  implements Runnable
{
  MessageForQQWalletTips$1$1(MessageForQQWalletTips.1 param1, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.eJ.get();
    if (localQQAppInterface == null) {
      return;
    }
    ((acms)localQQAppInterface.getBusinessHandler(20)).ac(Long.parseLong(this.a.Ub), Long.parseLong(this.bCv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.1.1
 * JD-Core Version:    0.7.0.1
 */