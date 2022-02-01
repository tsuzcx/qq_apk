package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aabz;
import aaca;
import aagd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class NotifyMsgManager$4
  implements Runnable
{
  public NotifyMsgManager$4(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    do
    {
      synchronized (aaca.ca)
      {
        if (aaca.a == null) {
          aaca.a = new aabz(BaseApplicationImpl.getContext());
        }
        ??? = aagd.getQQAppInterface();
        if (??? == null) {
          return;
        }
      }
    } while (aaca.a == null);
    if (this.buY)
    {
      aaca.a.w(((QQAppInterface)???).getCurrentUin(), this.rZ);
      return;
    }
    aaca.a.x(((QQAppInterface)???).getCurrentUin(), this.rZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */