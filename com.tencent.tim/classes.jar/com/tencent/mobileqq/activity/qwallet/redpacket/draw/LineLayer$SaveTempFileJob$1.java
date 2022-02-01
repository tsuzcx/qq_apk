package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aafc;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    aafc localaafc;
    if (LineLayer.SaveTempFileJob.a(this.a) != null)
    {
      localaafc = (aafc)LineLayer.SaveTempFileJob.a(this.a).get();
      if (localaafc != null) {
        if (TextUtils.isEmpty(this.TD)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localaafc.b(bool, LineLayer.SaveTempFileJob.a(this.a), LineLayer.SaveTempFileJob.b(this.a), this.TD);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */