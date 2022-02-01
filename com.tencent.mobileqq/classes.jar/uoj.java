import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import java.util.Map;

public class uoj
  extends ukl<stWeishiDengtaReportRsp>
{
  public uoj(String paramString, Map<String, String> paramMap)
  {
    super("WeishiDengtaReport");
    stWeishiDengtaReportReq localstWeishiDengtaReportReq = new stWeishiDengtaReportReq();
    localstWeishiDengtaReportReq.eventName = paramString;
    localstWeishiDengtaReportReq.params = paramMap;
    this.a = localstWeishiDengtaReportReq;
    uqf.b("BeaconSendRequest", "BeaconSendRequest = " + localstWeishiDengtaReportReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */