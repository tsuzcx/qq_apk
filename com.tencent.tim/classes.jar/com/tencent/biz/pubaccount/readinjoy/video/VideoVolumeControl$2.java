package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import mzj;
import mzj.a;

public class VideoVolumeControl$2
  implements Runnable
{
  public VideoVolumeControl$2(mzj parammzj) {}
  
  public void run()
  {
    mzj.a locala = mzj.a(this.this$0);
    if (locala != null) {
      ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(locala, 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.2
 * JD-Core Version:    0.7.0.1
 */