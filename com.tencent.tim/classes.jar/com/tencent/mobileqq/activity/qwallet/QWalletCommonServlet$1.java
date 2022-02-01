package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import mqq.observer.BusinessObserver;
import zyb;

public class QWalletCommonServlet$1
  implements Runnable
{
  public QWalletCommonServlet$1(zyb paramzyb, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    this.val$observer.onReceive(this.val$type, this.val$isSuccess, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet.1
 * JD-Core Version:    0.7.0.1
 */