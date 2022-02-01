import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import java.util.Map;

public class onl
  extends okw<stWeishiDengtaReportRsp>
{
  public onl(String paramString, Map<String, String> paramMap)
  {
    super("WeishiDengtaReport");
    stWeishiDengtaReportReq localstWeishiDengtaReportReq = new stWeishiDengtaReportReq();
    localstWeishiDengtaReportReq.eventName = paramString;
    localstWeishiDengtaReportReq.params = paramMap;
    this.req = localstWeishiDengtaReportReq;
    ooz.d("BeaconSendRequest", "BeaconSendRequest = " + localstWeishiDengtaReportReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onl
 * JD-Core Version:    0.7.0.1
 */