package cooperation.vip.widget;

import android.text.TextUtils;
import awnr;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;

public class VipGeneralGdtShowView$2
  implements Runnable
{
  public VipGeneralGdtShowView$2(awnr paramawnr, String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.rM)) {
        return;
      }
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.rM).openConnection();
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.connect();
      i = localHttpURLConnection.getResponseCode();
      if (i != 200) {
        break label149;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      int i;
      boolean bool;
      while (QZLog.isColorLevel())
      {
        QZLog.w("VipGeneralGdtShowView", 2, new Object[] { localException.toString() });
        return;
        label149:
        bool = false;
      }
    }
    if (QZLog.isColorLevel())
    {
      QZLog.i("VipGeneralGdtShowView", "@getGdtInfo exporsure rspCode " + i + "， request thirdparty" + bool + " url =" + this.rM);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralGdtShowView.2
 * JD-Core Version:    0.7.0.1
 */