package com.tencent.aekit.api.standard.ai;

import com.tencent.ttpic.openapi.PTFaceDetector;
import java.util.concurrent.CountDownLatch;

class AEDetector$1
  implements Runnable
{
  AEDetector$1(AEDetector paramAEDetector, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    if (AEDetector.access$000(this.this$0) != null) {
      AEDetector.access$000(this.this$0).destroy();
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.1
 * JD-Core Version:    0.7.0.1
 */