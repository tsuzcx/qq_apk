package cooperation.qzone.util;

import android.content.Context;
import android.text.TextUtils;
import anol;
import awcp;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.Properties;

public class PanoramaUtil$1
  implements Runnable
{
  public PanoramaUtil$1(awcp paramawcp, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.pC != null) && (!TextUtils.isEmpty(this.pC)))
    {
      Properties localProperties = new Properties();
      localProperties.put(this.pD, this.pC);
      Context localContext = BaseApplication.getContext();
      if (localContext != null) {
        anol.a(localContext).reportTimeKVEvent("qzone_panorama", localProperties, this.AW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */