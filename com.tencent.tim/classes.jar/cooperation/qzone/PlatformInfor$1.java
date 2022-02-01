package cooperation.qzone;

import android.content.Context;
import avpp;
import common.config.service.QzoneConfig;

public class PlatformInfor$1
  implements Runnable
{
  public PlatformInfor$1(avpp paramavpp, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneSharppGate", 1) == 1)
    {
      avpp.a(this.this$0, SharpPDec.bD(this.val$context));
      return;
    }
    avpp.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor.1
 * JD-Core Version:    0.7.0.1
 */