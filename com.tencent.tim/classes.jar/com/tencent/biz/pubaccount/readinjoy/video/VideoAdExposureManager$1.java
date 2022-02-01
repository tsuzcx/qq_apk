package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import jys;
import lbz;
import mss;

public class VideoAdExposureManager$1
  implements Runnable
{
  public VideoAdExposureManager$1(mss parammss, int paramInt1, int paramInt2, jys paramjys) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd refreshChannelAdvertisementFormServer reqType=" + this.JC);
    }
    lbz.a().a(this.aHH, this.JC, 0, 10000, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1
 * JD-Core Version:    0.7.0.1
 */