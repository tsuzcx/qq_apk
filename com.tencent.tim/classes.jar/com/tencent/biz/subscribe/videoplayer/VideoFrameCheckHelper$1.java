package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.TextureView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import sht;
import sht.a;

public class VideoFrameCheckHelper$1
  implements Runnable
{
  public VideoFrameCheckHelper$1(sht paramsht, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame");
    if (System.currentTimeMillis() - sht.a(this.this$0) >= 4000L) {}
    for (boolean bool = true; (this.N.get() == null) || (this.O.get() == null); bool = false)
    {
      QLog.d("VideoFrameCheckHelper", 1, "reference recycled");
      return;
    }
    if ((sht.a(this.this$0, (TextureView)this.O.get())) && (!bool))
    {
      sht.a(this.this$0, (TextureView)this.O.get(), (sht.a)this.N.get());
      QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame again");
      return;
    }
    sht.a(this.this$0).post(new VideoFrameCheckHelper.1.1(this, bool));
    sht.b(this.this$0).removeCallbacksAndMessages(null);
    QLog.d("VideoFrameCheckHelper", 1, "doCheckCurrentFrame stop isReachMaxTime:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1
 * JD-Core Version:    0.7.0.1
 */