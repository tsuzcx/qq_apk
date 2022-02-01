package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public final class QQUtils$1
  implements Runnable
{
  public QQUtils$1(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    QQToast.a(this.val$app.getApp(), this.val$tips, 0).show(this.cuo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.1
 * JD-Core Version:    0.7.0.1
 */