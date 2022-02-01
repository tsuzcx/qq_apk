import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.3;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import java.util.Properties;
import mqq.app.MobileQQ;

public class ango
  implements ShortVideoResourceManager.c
{
  public ango(ShortVideoResourceManager.3 param3) {}
  
  public void aFW()
  {
    VideoEnvironment.k("QuicResDownload", "doUserDownloadQuicResourceAsync: [onNetWorkNone]", null);
  }
  
  public void f(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == paramLong2) && (!QuicResDownload.cVt)) {
      QuicResDownload.cVt = true;
    }
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("version", "3.4.4.3058");
      localProperties.put("appid", String.valueOf(AppSetting.getAppId()));
      localProperties.put("release", String.valueOf(true));
      localProperties.put("name", paramString);
      anol.a(this.a.val$app.getApplication().getApplicationContext()).reportKVEvent("msf_quic_resdown", localProperties);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.k("QuicResDownload", "doUserDownloadQuicResourceAsync: [onDownloadFinish]name=" + paramString1 + " filepath=" + paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ango
 * JD-Core Version:    0.7.0.1
 */