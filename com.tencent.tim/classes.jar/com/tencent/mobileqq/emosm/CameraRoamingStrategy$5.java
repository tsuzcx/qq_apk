package com.tencent.mobileqq.emosm;

import affs;
import afgw;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(affs paramaffs) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (!aqiw.isNetSupport(this.this$0.app.getApp()))) {
      return;
    }
    ((afgw)this.this$0.app.getManager(334)).cYZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */