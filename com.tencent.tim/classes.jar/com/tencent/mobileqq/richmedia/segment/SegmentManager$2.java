package com.tencent.mobileqq.richmedia.segment;

import alvs;
import ambu;
import android.app.Activity;
import android.media.MediaFormat;
import android.os.Bundle;
import anpc;
import aqhq;
import azbq;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class SegmentManager$2
  implements Runnable
{
  public SegmentManager$2(ambu paramambu, MediaFormat paramMediaFormat) {}
  
  public void run()
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    long l3 = ambu.a(this.this$0) - ambu.b(this.this$0);
    long l4 = ambu.c(this.this$0) - ambu.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "combineVideo,encodeVideoTime:" + l3 + " encodeAudioTime:" + l4);
    }
    Object localObject = this.this$0.yK();
    int j;
    if (ambu.b(this.this$0).equals("AUDIO_PROBLEM"))
    {
      aqhq.copyFile(ambu.c(this.this$0), (String)localObject);
      ambu.a(this.this$0, false);
      localObject = ambu.a(this.this$0);
      i = this.h.getInteger("width");
      j = this.h.getInteger("height");
      ((Bundle)localObject).putInt("video_slice_width", i);
      ((Bundle)localObject).putInt("video_slice_height", j);
      ((Bundle)localObject).putLong("video_duration", ambu.d(this.this$0));
      this.this$0.c.a(203, -1, (Bundle)localObject);
      bool = true;
      if (bool) {
        this.this$0.mM.put("param_succ_flag", "1");
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "LightVideoEncode", bool, l1 - ambu.b(this.this$0), ambu.d(this.this$0), this.this$0.mM, null);
      ((Activity)this.this$0.a.getContext()).finish();
      return;
    }
    int i = azbq.c(ambu.c(this.this$0), ambu.b(this.this$0), (String)localObject, 0);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "HwVideoMerge.merge failed:" + i);
      }
      this.this$0.onError();
      this.this$0.mM.put("param_FailCode", String.valueOf(i));
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "combineVideo,timeCombineDone:" + (l2 - l1) + " timeFinish:" + (l2 - ambu.b(this.this$0)));
      }
      this.this$0.mM.put("param_combine_time", String.valueOf(l2 - l1));
      this.this$0.mM.put("param_video_time", String.valueOf(l3));
      this.this$0.mM.put("param_audio_time", String.valueOf(l4));
      l1 = l2;
      break;
      localObject = ambu.a(this.this$0);
      i = this.h.getInteger("width");
      j = this.h.getInteger("height");
      ((Bundle)localObject).putInt("video_slice_width", i);
      ((Bundle)localObject).putInt("video_slice_height", j);
      ((Bundle)localObject).putLong("video_duration", ambu.d(this.this$0));
      this.this$0.c.a(203, -1, (Bundle)localObject);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.SegmentManager.2
 * JD-Core Version:    0.7.0.1
 */