package com.tencent.mobileqq.nearby;

import ajqw;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NearbyRedDotFaceController$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRedDotFaceController", 2, "run, mCurIndex=" + this.this$0.mCurIndex);
      }
      if (this.this$0.xY.size() == 0) {
        return;
      }
      if (this.this$0.mCurIndex >= this.this$0.xY.size()) {
        this.this$0.mCurIndex = 0;
      }
      this.this$0.MN((String)this.this$0.xY.get(this.this$0.mCurIndex));
      ajqw localajqw2 = this.this$0;
      localajqw2.mCurIndex += 1;
      if (this.this$0.xY.size() > 1) {
        this.this$0.mUiHandler.postDelayed(this, 3000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController.2
 * JD-Core Version:    0.7.0.1
 */