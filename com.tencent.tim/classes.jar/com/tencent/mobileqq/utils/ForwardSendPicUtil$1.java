package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import zsz;

public final class ForwardSendPicUtil$1
  implements Runnable
{
  public ForwardSendPicUtil$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.val$path;
      int i = this.ber;
      QQAppInterface localQQAppInterface = this.w;
      zsz.a(new String[] { str }, i, false, true, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ForwardSendPicUtil.1
 * JD-Core Version:    0.7.0.1
 */