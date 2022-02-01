import NS_NEW_MOBILE_REPORT.AccessReqHead;
import NS_NEW_MOBILE_REPORT.AccessRspHead;
import NS_NEW_MOBILE_REPORT.Terminal;
import com.qq.taf.jce.JceStruct;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class awnv
  extends QzoneExternalRequest
{
  private static String Tn = "";
  private static String brk = "";
  private static String cRM = "";
  private AccessReqHead a;
  
  public awnv(long paramLong, ArrayList<String> paramArrayList)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.a = new AccessReqHead();
    this.a.loginType = 1;
    this.a.uin = paramLong;
    this.a.terminal = new Terminal();
    this.a.terminal.imei = String.valueOf(getIMEI());
    this.a.terminal.macAddress = String.valueOf(getMac());
    this.a.terminal.androidId = String.valueOf(aqgz.getAndroidID());
    this.a.terminal.imsi = String.valueOf(getIMSI());
    this.a.terminal.mode = String.valueOf(aqgz.getModel());
    this.a.terminal.manufacture = String.valueOf(aqgz.BY());
    this.a.terminal.qimei = String.valueOf(UserAction.getQIMEI());
    if (QLog.isColorLevel()) {
      QLog.d("YYBInstallPackageReportRequest", 1, "YYBInstallPackageReportRequest qimei=" + this.a.terminal.qimei);
    }
    this.a.uniqueId = String.valueOf(arxr.getImei());
    this.a.uninstallPkgList = new ArrayList();
    this.a.uninstallPkgList.addAll(paramArrayList);
  }
  
  public static AccessRspHead a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramArrayOfInt = (AccessRspHead)decode(paramArrayOfByte, "NewMobileReport", paramArrayOfInt);
      paramArrayOfByte = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return null;
  }
  
  public static String getIMEI()
  {
    if ((Tn != null) && (Tn.length() > 0)) {
      return Tn;
    }
    try
    {
      Tn = auri.getIMEI("b94d1a");
      label27:
      return Tn;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String getIMSI()
  {
    if ((brk != null) && (brk.length() > 0)) {
      return brk;
    }
    try
    {
      brk = auri.ru("b94d1a");
      label27:
      return brk;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String getMac()
  {
    if ((cRM != null) && (cRM.length() > 0)) {
      return cRM;
    }
    try
    {
      cRM = auri.rv("b94d1a");
      label27:
      return cRM;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public String getCmdString()
  {
    return "MobileReport.NewMobileReport";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "NewMobileReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnv
 * JD-Core Version:    0.7.0.1
 */