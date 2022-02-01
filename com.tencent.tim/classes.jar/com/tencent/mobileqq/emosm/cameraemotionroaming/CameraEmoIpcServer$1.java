package com.tencent.mobileqq.emosm.cameraemotionroaming;

import afgv;
import afgz;
import java.util.ArrayList;

public class CameraEmoIpcServer$1
  implements Runnable
{
  public CameraEmoIpcServer$1(afgv paramafgv, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    if (this.wd != null)
    {
      afgz.a().a(this.we, this.wf, this.wd, this.sm);
      return;
    }
    afgz.a().b(this.we, this.wf, this.sm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1
 * JD-Core Version:    0.7.0.1
 */