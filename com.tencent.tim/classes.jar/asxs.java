import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;

@ProxyService(proxy=WnsConfigProxy.class)
public class asxs
  extends WnsConfigProxy
{
  public List<String> getApiReportConfig()
  {
    aeks localaeks = aekt.a();
    if (localaeks != null) {
      return localaeks.er();
    }
    return null;
  }
  
  public String getConfig(String paramString1, String paramString2)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxs
 * JD-Core Version:    0.7.0.1
 */