package com.tencent.mobileqq.troop.utils;

import aptw;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.qphone.base.util.QLog;

public class TroopRobotManager$1
  implements Runnable
{
  public TroopRobotManager$1(aptw paramaptw) {}
  
  public void run()
  {
    oidb_0x496.Robot localRobot = new oidb_0x496.Robot();
    byte[] arrayOfByte = this.this$0.ay();
    if (arrayOfByte != null) {}
    try
    {
      localRobot.mergeFrom(arrayOfByte);
      this.this$0.a(localRobot);
      aptw.a(this.this$0);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopRobotManager", 2, "file data error");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.1
 * JD-Core Version:    0.7.0.1
 */