package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqMngGrp
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static byte[] cache_vReqMngPack;
  public long GrpId = 0L;
  public short shMngType = 0;
  public ReqHeader stHeader = null;
  public byte[] vReqMngPack = null;
  
  public ReqMngGrp() {}
  
  public ReqMngGrp(ReqHeader paramReqHeader, long paramLong, short paramShort, byte[] paramArrayOfByte)
  {
    this.stHeader = paramReqHeader;
    this.GrpId = paramLong;
    this.shMngType = paramShort;
    this.vReqMngPack = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    this.shMngType = paramJceInputStream.read(this.shMngType, 2, true);
    if (cache_vReqMngPack == null)
    {
      cache_vReqMngPack = (byte[])new byte[1];
      ((byte[])cache_vReqMngPack)[0] = 0;
    }
    this.vReqMngPack = ((byte[])paramJceInputStream.read(cache_vReqMngPack, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.shMngType, 2);
    paramJceOutputStream.write(this.vReqMngPack, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqMngGrp
 * JD-Core Version:    0.7.0.1
 */