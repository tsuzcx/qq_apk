import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy=RequestStrategyProxy.class)
public class aswn
  implements RequestStrategyProxy
{
  public String addHttpForwardingInfo(String paramString, Map<String, String> paramMap)
  {
    return RequestStrategy.g.addHttpForwardingInfo(paramString, paramMap);
  }
  
  public void addHttpForwardingInfo(JSONObject paramJSONObject)
  {
    RequestStrategy.g.addHttpForwardingInfo(paramJSONObject);
  }
  
  public boolean isIPV6Only()
  {
    return RequestStrategy.g.isIPv6Only();
  }
  
  public void notifyNetWorkStatusChange()
  {
    RequestStrategy.g.notifyNetWorkStatusChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswn
 * JD-Core Version:    0.7.0.1
 */