import NS_MOBILE_QBOSS_PROTO.MobileQbossReportReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class avza
  extends QzoneExternalRequest
{
  private JceStruct req;
  
  public avza(ArrayList<tMobileQbossFeedBackInfo> paramArrayList)
  {
    MobileQbossReportReq localMobileQbossReportReq = new MobileQbossReportReq();
    localMobileQbossReportReq.vecMobileQbossFeedBackInfo = paramArrayList;
    this.req = localMobileQbossReportReq;
  }
  
  public static MobileQbossReportRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    MobileQbossReportRsp localMobileQbossReportRsp;
    do
    {
      return paramArrayOfByte;
      localMobileQbossReportRsp = (MobileQbossReportRsp)decode(paramArrayOfByte, "report");
      paramArrayOfByte = localMobileQbossReportRsp;
    } while (localMobileQbossReportRsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.report";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avza
 * JD-Core Version:    0.7.0.1
 */