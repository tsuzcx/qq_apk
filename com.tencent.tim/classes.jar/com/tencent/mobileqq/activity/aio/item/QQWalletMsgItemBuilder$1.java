package com.tencent.mobileqq.activity.aio.item;

import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import xlr;

public class QQWalletMsgItemBuilder$1
  implements Runnable
{
  public QQWalletMsgItemBuilder$1(xlr paramxlr, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mContext == null) {}
    while (QWalletHelper.isQWalletProcessExist(this.this$0.mContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(xlr.TAG, 2, "preload qwallet process by qqWalletMsg isTroop=" + this.bUS);
    }
    QWalletHelper.preloadQWallet(this.this$0.app, 0, "qwallet_red");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */