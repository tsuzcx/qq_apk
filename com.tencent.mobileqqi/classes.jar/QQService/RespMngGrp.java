package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespMngGrp
  extends JceStruct
{
  static UserAlterGrpInfo cache_AlterGrpInfo;
  static RespHeader cache_stHeader;
  static byte[] cache_vExtResult;
  public UserAlterGrpInfo AlterGrpInfo = null;
  public long GrpId = 0L;
  public int iExtCode = 0;
  public short shMngType = 0;
  public RespHeader stHeader = null;
  public byte[] vExtResult = null;
  
  public RespMngGrp() {}
  
  public RespMngGrp(RespHeader paramRespHeader, long paramLong, short paramShort, UserAlterGrpInfo paramUserAlterGrpInfo, int paramInt, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHeader;
    this.GrpId = paramLong;
    this.shMngType = paramShort;
    this.AlterGrpInfo = paramUserAlterGrpInfo;
    this.iExtCode = paramInt;
    this.vExtResult = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    this.shMngType = paramJceInputStream.read(this.shMngType, 2, true);
    if (cache_AlterGrpInfo == null) {
      cache_AlterGrpInfo = new UserAlterGrpInfo();
    }
    this.AlterGrpInfo = ((UserAlterGrpInfo)paramJceInputStream.read(cache_AlterGrpInfo, 3, true));
    this.iExtCode = paramJceInputStream.read(this.iExtCode, 4, false);
    if (cache_vExtResult == null)
    {
      cache_vExtResult = (byte[])new byte[1];
      ((byte[])cache_vExtResult)[0] = 0;
    }
    this.vExtResult = ((byte[])paramJceInputStream.read(cache_vExtResult, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.shMngType, 2);
    paramJceOutputStream.write(this.AlterGrpInfo, 3);
    paramJceOutputStream.write(this.iExtCode, 4);
    if (this.vExtResult != null) {
      paramJceOutputStream.write(this.vExtResult, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespMngGrp
 * JD-Core Version:    0.7.0.1
 */