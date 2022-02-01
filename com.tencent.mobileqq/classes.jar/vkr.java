import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class vkr
  extends vfo<stWeishiDengtaReportRsp>
{
  public vkr(String paramString, Map<String, String> paramMap)
  {
    super("WeishiDengtaReport");
    stWeishiDengtaReportReq localstWeishiDengtaReportReq = new stWeishiDengtaReportReq();
    localstWeishiDengtaReportReq.eventName = paramString;
    localstWeishiDengtaReportReq.params = a(paramMap);
    this.a = localstWeishiDengtaReportReq;
    vmp.b("BeaconSendRequest", "BeaconSendRequest = " + localstWeishiDengtaReportReq.toString());
  }
  
  private Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject;
    if (paramMap == null)
    {
      localObject = new HashMap();
      return localObject;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      localObject = paramMap;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Map.Entry)localIterator.next();
      if (((Map.Entry)localObject).getValue() == null) {
        ((Map.Entry)localObject).setValue("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkr
 * JD-Core Version:    0.7.0.1
 */