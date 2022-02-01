package dov.com.qq.im.ptv;

import aybp;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class LightWeightSoDownloadUnit$3
  implements Runnable
{
  public LightWeightSoDownloadUnit$3(aybp paramaybp, String paramString) {}
  
  public void run()
  {
    this.this$0.f.setProgress(aybp.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "" + this.val$tag + " setProgress=" + aybp.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightSoDownloadUnit.3
 * JD-Core Version:    0.7.0.1
 */