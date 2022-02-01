package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import aweh;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class QZoneDNSAnalyzeJsPlugin$1
  implements Runnable
{
  public QZoneDNSAnalyzeJsPlugin$1(aweh paramaweh, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    try
    {
      String str = InetAddress.getByName(this.val$host).getHostAddress();
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "Analyze " + this.val$host + " ip address : " + str);
        localObject = str;
        aweh.a(this.this$0, this.val$callback, 0, str);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "UnknownHostException:Analyze " + this.val$host + " ip address failed");
      aweh.a(this.this$0, this.val$callback, -1, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */