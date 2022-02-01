package com.tencent.mobileqq.activity.aio.doodle;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import wsh;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    wsh localwsh;
    if (LineLayer.SaveTempFileJob.a(this.a) != null)
    {
      localwsh = (wsh)LineLayer.SaveTempFileJob.a(this.a).get();
      if (localwsh != null) {
        if (TextUtils.isEmpty(this.TD)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localwsh.b(bool, LineLayer.SaveTempFileJob.a(this.a), LineLayer.SaveTempFileJob.b(this.a), this.TD);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */