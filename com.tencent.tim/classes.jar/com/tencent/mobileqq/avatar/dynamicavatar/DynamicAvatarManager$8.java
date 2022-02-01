package com.tencent.mobileqq.avatar.dynamicavatar;

import advr;
import aqcy;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class DynamicAvatarManager$8
  implements Runnable
{
  public DynamicAvatarManager$8(advr paramadvr) {}
  
  public void run()
  {
    synchronized (aqcy.sPauseLock)
    {
      aqcy.cTz = false;
      ThreadManager.getUIHandler().post(new DynamicAvatarManager.8.1(this));
      this.this$0.resumeAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.8
 * JD-Core Version:    0.7.0.1
 */