package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mye;
import mzj;

public class VideoVolumeControl$1
  implements Runnable
{
  public VideoVolumeControl$1(mzj parammzj) {}
  
  public void run()
  {
    if (mzj.a(this.this$0)) {
      if (mzj.a(this.this$0) != null)
      {
        mzj.a(this.this$0).requestAudioFocus(null, 3, 2);
        break label71;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + mzj.a(this.this$0));
      }
      label71:
      return;
      if (mzj.a(this.this$0) != null)
      {
        Iterator localIterator = mzj.a(this.this$0).keySet().iterator();
        Object localObject;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (mye)localIterator.next();
            if ((localObject != null) && (((mye)localObject).isPlaying()) && (!((mye)localObject).isMute()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        localIterator = mzj.b(this.this$0).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (VideoFeedsPlayManager)localIterator.next();
            if ((localObject != null) && (((VideoFeedsPlayManager)localObject).isPlaying()) && (!((VideoFeedsPlayManager)localObject).isMute()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + localObject);
              return;
            }
          }
        }
        mzj.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1
 * JD-Core Version:    0.7.0.1
 */