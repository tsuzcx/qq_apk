package cooperation.vip.ar.controller;

import android.text.TextUtils;
import awlb;
import awle;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.io.File;

public class VipQGThreeController$3
  implements Runnable
{
  public VipQGThreeController$3(awlb paramawlb) {}
  
  public void run()
  {
    if ((awlb.a(this.this$0) != null) && (!TextUtils.isEmpty(awlb.a(this.this$0).cRd)) && (awlb.a(this.this$0) != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("VipARQGThreeController", 2, "js model runnable path = " + awlb.a(this.this$0).cRd);
      }
      awlb.a(this.this$0).setExtResPath(awlb.a(this.this$0).cRd);
      awlb.a(this.this$0).addJavaScriptFileFromSDCard(awlb.a(this.this$0).cRd + File.separator + "qg.js");
      awlb.a(this.this$0).addJavaScriptFileFromSDCard(awlb.a(this.this$0).cRd + File.separator + "index.js");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.3
 * JD-Core Version:    0.7.0.1
 */