package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kxm;

public final class ReadInJoyUtils$1
  implements Runnable
{
  public ReadInJoyUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.val$app == null) || (!this.val$app.isLogin())) {}
    do
    {
      do
      {
        return;
      } while (!kxm.access$000());
      kxm.O(this.val$app);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "handNet2Wifi is show conversation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.1
 * JD-Core Version:    0.7.0.1
 */