package com.tencent.mobileqq.activity.aio.photo;

import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import xsk;
import xto;
import xuf;
import xuf.a;
import ztk;
import ztn;

public class AIOGalleryScene$3
  implements Runnable
{
  public AIOGalleryScene$3(xsk paramxsk) {}
  
  public void run()
  {
    Object localObject;
    if ((this.this$0.jdField_b_of_type_Xto.c() != null) && (this.this$0.jdField_b_of_type_Xto.c().e != null))
    {
      localObject = this.this$0.jdField_b_of_type_Xto.c().e;
      if (!(localObject instanceof AIOShortVideoData)) {
        break label373;
      }
      localObject = (AIOShortVideoData)localObject;
      if (((AIOShortVideoData)localObject).mBusiType != 0) {
        break label361;
      }
      if ((this.this$0.c != null) && (this.this$0.c.VL())) {}
    }
    else
    {
      return;
    }
    long l1;
    label168:
    long l2;
    if (this.this$0.jdField_b_of_type_Xto.c().a.bjt)
    {
      l1 = this.this$0.c.eE();
      String str = ShortVideoUtils.g(xsk.a(this.this$0), l1 * 1024L);
      this.this$0.Ko.setText(str + "/s");
      if ((this.this$0.c == null) || (this.this$0.c.a == null) || (!this.this$0.c.a.btf)) {
        break label465;
      }
      l1 = this.this$0.c.eF();
      l2 = ((AIOShortVideoData)localObject).size;
    }
    label465:
    for (float f = (int)((float)l1 / (float)l2 * 10000.0F);; f = 10000.0F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "mProgressChecker, 长视频，cacheProgress =  " + f);
      }
      this.this$0.m.setSecondaryProgress((int)f);
      for (;;)
      {
        this.this$0.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.this$0.eu, 100L);
        return;
        l1 = this.this$0.c.getProgress();
        int i = (int)(l1 / this.this$0.c.getDuration() * 10000.0D);
        this.this$0.Km.setText(ShortVideoUtils.stringForTime(l1));
        this.this$0.m.setProgress(i);
        break label168;
        label361:
        if (((AIOShortVideoData)localObject).mBusiType == 1)
        {
          continue;
          label373:
          if (AIOFileVideoData.class.isInstance(localObject))
          {
            if ((this.this$0.c == null) || (!this.this$0.c.VL())) {
              break;
            }
            l1 = this.this$0.c.getProgress();
            i = (int)(l1 / this.this$0.c.getDuration() * 10000.0D);
            this.this$0.Km.setText(ShortVideoUtils.stringForTime(l1));
            this.this$0.m.setProgress(i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.3
 * JD-Core Version:    0.7.0.1
 */