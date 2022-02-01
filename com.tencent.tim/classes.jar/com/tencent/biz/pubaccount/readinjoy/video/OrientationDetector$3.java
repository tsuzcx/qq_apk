package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import msd;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(msd parammsd, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (msd.a(this.this$0))
    {
      if (msd.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.val$enable) {
        if (msd.a(this.this$0).canDetectOrientation()) {
          msd.a(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        msd.a(this.this$0).disable();
      }
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */