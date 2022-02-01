package com.tencent.mobileqq.emotionintegrate;

import afrp;
import afrp.a;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class EmotionDownGIFCallback$2
  implements Runnable
{
  public EmotionDownGIFCallback$2(afrp paramafrp, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownloadProgress:", Integer.valueOf(this.val$progress) });
    }
    if (afrp.a(this.this$0).get() != null) {
      ((afrp.a)afrp.a(this.this$0).get()).a(this.val$progress, afrp.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2
 * JD-Core Version:    0.7.0.1
 */