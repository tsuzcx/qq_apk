import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserActionReportReq;
import NS_USER_ACTION_REPORT.UserCommReport;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class avui
  extends QzoneExternalRequest
{
  private final JceStruct req;
  
  public avui(UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    this.req = new UserActionReportReq(1, paramUserCommReport, paramArrayList);
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "MobileReport.UserActionReport";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "UserActionReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avui
 * JD-Core Version:    0.7.0.1
 */