import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import java.util.Map;

public class tka
  extends thb<stWeishiDengtaReportRsp>
{
  public tka(String paramString, Map<String, String> paramMap)
  {
    super("WeishiDengtaReport");
    stWeishiDengtaReportReq localstWeishiDengtaReportReq = new stWeishiDengtaReportReq();
    localstWeishiDengtaReportReq.eventName = paramString;
    localstWeishiDengtaReportReq.params = paramMap;
    this.a = localstWeishiDengtaReportReq;
    tlo.b("BeaconSendRequest", "BeaconSendRequest = " + localstWeishiDengtaReportReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tka
 * JD-Core Version:    0.7.0.1
 */