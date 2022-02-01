package com.tencent.mobileqq.ar.ARPromotion;

import adbl;
import adbl.a;
import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(adbl paramadbl) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = adbl.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        adbl.a locala = (adbl.a)((Map.Entry)localIterator.next()).getValue();
        if (locala != null) {
          adbl.a(this.this$0).stop(locala.cBD);
        }
      }
      adbl.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    adbl.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */