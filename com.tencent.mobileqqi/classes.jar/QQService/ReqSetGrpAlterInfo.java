package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetGrpAlterInfo
  extends JceStruct
{
  static UserAlterGrpInfo cache_AlterGrpInfo;
  static ReqHeader cache_stHeader;
  public UserAlterGrpInfo AlterGrpInfo = null;
  public ReqHeader stHeader = null;
  
  public ReqSetGrpAlterInfo() {}
  
  public ReqSetGrpAlterInfo(ReqHeader paramReqHeader, UserAlterGrpInfo paramUserAlterGrpInfo)
  {
    this.stHeader = paramReqHeader;
    this.AlterGrpInfo = paramUserAlterGrpInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_AlterGrpInfo == null) {
      cache_AlterGrpInfo = new UserAlterGrpInfo();
    }
    this.AlterGrpInfo = ((UserAlterGrpInfo)paramJceInputStream.read(cache_AlterGrpInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.AlterGrpInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqSetGrpAlterInfo
 * JD-Core Version:    0.7.0.1
 */