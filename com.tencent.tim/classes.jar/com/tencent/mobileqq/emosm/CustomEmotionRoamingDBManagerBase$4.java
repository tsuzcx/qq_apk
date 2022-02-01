package com.tencent.mobileqq.emosm;

import affx;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class CustomEmotionRoamingDBManagerBase$4
  implements Runnable
{
  public void run()
  {
    List localList = this.this$0.eB();
    ThreadManager.getUIHandler().post(new CustomEmotionRoamingDBManagerBase.4.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.4
 * JD-Core Version:    0.7.0.1
 */