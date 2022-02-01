package com.tencent.mobileqq.activity.aio.helper;

import acms;
import aprg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import wxk;

public class TroopRobotHelper$5
  implements Runnable
{
  public TroopRobotHelper$5(wxk paramwxk, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!aprg.bQ((QQAppInterface)localObject));
      localObject = (acms)((QQAppInterface)localObject).getBusinessHandler(20);
    } while (localObject == null);
    ((acms)localObject).hW(this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.5
 * JD-Core Version:    0.7.0.1
 */