import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import NS_MOBILE_QBOSS_PROTO.ReportExceptionInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class avyy
  extends QzoneExternalRequest
{
  private JceStruct req;
  
  public avyy(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    ReportExceptionInfo localReportExceptionInfo = new ReportExceptionInfo();
    localReportExceptionInfo.iCode = paramInt3;
    localReportExceptionInfo.iAppid = paramInt1;
    localReportExceptionInfo.iTaskId = paramInt2;
    localReportExceptionInfo.strMsg = paramString;
    localArrayList.add(localReportExceptionInfo);
    this.req = new MobileQbossReportExceptionReq(paramLong, localArrayList);
  }
  
  public static MobileQbossReportExceptionRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    MobileQbossReportExceptionRsp localMobileQbossReportExceptionRsp;
    do
    {
      return paramArrayOfByte;
      localMobileQbossReportExceptionRsp = (MobileQbossReportExceptionRsp)decode(paramArrayOfByte, "reportException");
      paramArrayOfByte = localMobileQbossReportExceptionRsp;
    } while (localMobileQbossReportExceptionRsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.reportException";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "reportException";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyy
 * JD-Core Version:    0.7.0.1
 */