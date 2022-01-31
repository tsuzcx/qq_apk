package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetGrpAlterInfo
  extends JceStruct
{
  static UserAlterGrpInfo cache_AlterGrpInfo;
  static RespHeader cache_stHeader;
  public UserAlterGrpInfo AlterGrpInfo = null;
  public int EndSeq = 0;
  public int TotalNum = 0;
  public RespHeader stHeader = null;
  
  public RespGetGrpAlterInfo() {}
  
  public RespGetGrpAlterInfo(RespHeader paramRespHeader, UserAlterGrpInfo paramUserAlterGrpInfo, int paramInt1, int paramInt2)
  {
    this.stHeader = paramRespHeader;
    this.AlterGrpInfo = paramUserAlterGrpInfo;
    this.TotalNum = paramInt1;
    this.EndSeq = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_AlterGrpInfo == null) {
      cache_AlterGrpInfo = new UserAlterGrpInfo();
    }
    this.AlterGrpInfo = ((UserAlterGrpInfo)paramJceInputStream.read(cache_AlterGrpInfo, 1, true));
    this.TotalNum = paramJceInputStream.read(this.TotalNum, 2, false);
    this.EndSeq = paramJceInputStream.read(this.EndSeq, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.AlterGrpInfo, 1);
    paramJceOutputStream.write(this.TotalNum, 2);
    paramJceOutputStream.write(this.EndSeq, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetGrpAlterInfo
 * JD-Core Version:    0.7.0.1
 */