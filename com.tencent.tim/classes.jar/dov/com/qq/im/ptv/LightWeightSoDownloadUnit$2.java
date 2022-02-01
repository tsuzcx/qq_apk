package dov.com.qq.im.ptv;

import android.widget.TextView;
import aybp;
import com.tencent.qphone.base.util.QLog;

public class LightWeightSoDownloadUnit$2
  implements Runnable
{
  public LightWeightSoDownloadUnit$2(aybp paramaybp, String paramString) {}
  
  public void run()
  {
    aybp.a(this.this$0).setText(this.bdY);
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "setTipsTextData: textData=" + this.bdY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightSoDownloadUnit.2
 * JD-Core Version:    0.7.0.1
 */