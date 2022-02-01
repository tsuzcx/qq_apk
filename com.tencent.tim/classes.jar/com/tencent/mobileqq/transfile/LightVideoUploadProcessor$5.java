package com.tencent.mobileqq.transfile;

import ambv;
import ambw;
import aolt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class LightVideoUploadProcessor$5
  implements Runnable
{
  public LightVideoUploadProcessor$5(aolt paramaolt, ambv paramambv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "onSendSliceFinish, info:" + this.d + " mSendingInfos:" + this.this$0.nw.size() + " mReadyToSendInfos:" + this.this$0.Bq.size());
    }
    this.this$0.nw.remove(Integer.valueOf(this.d.mIndex));
    if (this.this$0.Bq.size() > 0) {
      this.this$0.dVO();
    }
    while ((this.this$0.Bq.size() != 0) || (this.this$0.nw.size() != 0) || (aolt.a(this.this$0) == null) || (!aolt.a(this.this$0).avo())) {
      return;
    }
    this.this$0.dVN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */