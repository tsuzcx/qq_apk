import android.os.Bundle;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;

class arco
  implements arci.a
{
  arco(arcn paramarcn) {}
  
  public int m(Bundle paramBundle)
  {
    if (this.this$0.cYQ) {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "mScheduler.next:is in real world, stop the preload task.");
    }
    do
    {
      do
      {
        return -1;
        if ((this.this$0.eex & 0x2) != 0)
        {
          if ((this.this$0.eew & 0x400) == 0) {
            this.this$0.dE(paramBundle);
          }
          if ((this.this$0.eew & 0x800) == 0) {
            this.this$0.dF(paramBundle);
          }
          if ((this.this$0.eew & 0x1000) == 0) {
            this.this$0.dG(paramBundle);
          }
          if ((this.this$0.eew & 0x1) == 0) {
            return this.this$0.C(paramBundle);
          }
        }
      } while ((this.this$0.eex & 0x1) == 0);
      if ((this.this$0.eew & 0x2) == 0) {
        return this.this$0.D(paramBundle);
      }
      if (!arbz.aeo)
      {
        arbz.aeo = true;
        if ((WebProcessReceiver.mStartTime > 0L) && (WebProcessReceiver.aud > 0L))
        {
          arbz.avb = WebProcessReceiver.aud - WebProcessReceiver.mStartTime;
          arbz.avc = System.currentTimeMillis() - WebProcessReceiver.aud;
          int i = (int)arbz.avb;
          int j = (int)arbz.avc;
          QLog.i("WebLog_SwiftWebAccelerator", 1, "cross process cost: " + i + "ms, preload cost: " + j + "ms.");
          VasWebviewUtil.reportVasStatus("Preload_Web_Process", "", "", i, j);
        }
      }
      if ((this.this$0.eew & 0x4) == 0) {
        return this.this$0.E(paramBundle);
      }
      if ((this.this$0.eew & 0x8) == 0) {
        return this.this$0.G(paramBundle);
      }
      if ((paramBundle.getBoolean("_should_set_cookie_", false)) && ((this.this$0.eew & 0x10) == 0)) {
        return this.this$0.F(paramBundle);
      }
    } while (arbz.cXX);
    arbz.cXX = true;
    if ((WebProcessReceiver.mStartTime > 0L) && (WebProcessReceiver.aud > 0L))
    {
      arbz.avd = System.currentTimeMillis() - WebProcessReceiver.aud;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "WebProcessReceiver.onReceive cost: " + arbz.avb + "ms, complete preload cost: " + arbz.avd + "ms.");
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arco
 * JD-Core Version:    0.7.0.1
 */