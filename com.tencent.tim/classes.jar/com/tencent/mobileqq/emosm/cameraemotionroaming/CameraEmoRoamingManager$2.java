package com.tencent.mobileqq.emosm.cameraemotionroaming;

import accj;
import afgw;
import afhc;
import java.util.List;

public class CameraEmoRoamingManager$2
  implements Runnable
{
  public CameraEmoRoamingManager$2(afgw paramafgw, afhc paramafhc, accj paramaccj) {}
  
  public void run()
  {
    List localList = this.b.ar("needDel");
    if (localList.size() > 0) {
      this.a.ai(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.cYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2
 * JD-Core Version:    0.7.0.1
 */