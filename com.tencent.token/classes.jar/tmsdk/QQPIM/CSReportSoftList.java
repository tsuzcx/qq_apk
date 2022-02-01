package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSReportSoftList
  extends JceStruct
{
  static PhoneType dG = new PhoneType();
  static UserInfo dH = new UserInfo();
  static ReqSoftReportInfo dJ = new ReqSoftReportInfo();
  public PhoneType phoneType = null;
  public ReqSoftReportInfo softReportInfo = null;
  public UserInfo userInfo = null;
  
  public JceStruct newInit()
  {
    return new CSReportSoftList();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.phoneType = ((PhoneType)paramJceInputStream.read(dG, 0, false));
    this.userInfo = ((UserInfo)paramJceInputStream.read(dH, 1, false));
    this.softReportInfo = ((ReqSoftReportInfo)paramJceInputStream.read(dJ, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.phoneType;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.userInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.softReportInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CSReportSoftList
 * JD-Core Version:    0.7.0.1
 */