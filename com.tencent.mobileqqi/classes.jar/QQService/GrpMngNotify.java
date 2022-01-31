package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GrpMngNotify
  extends JceStruct
{
  static UserAlterGrpInfo cache_AlterGrpInfo;
  static byte[] cache_vMngPack;
  public UserAlterGrpInfo AlterGrpInfo = null;
  public short shMngType = 0;
  public byte[] vMngPack = null;
  
  public GrpMngNotify() {}
  
  public GrpMngNotify(short paramShort, byte[] paramArrayOfByte, UserAlterGrpInfo paramUserAlterGrpInfo)
  {
    this.shMngType = paramShort;
    this.vMngPack = paramArrayOfByte;
    this.AlterGrpInfo = paramUserAlterGrpInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMngType = paramJceInputStream.read(this.shMngType, 0, true);
    if (cache_vMngPack == null)
    {
      cache_vMngPack = (byte[])new byte[1];
      ((byte[])cache_vMngPack)[0] = 0;
    }
    this.vMngPack = ((byte[])paramJceInputStream.read(cache_vMngPack, 1, true));
    if (cache_AlterGrpInfo == null) {
      cache_AlterGrpInfo = new UserAlterGrpInfo();
    }
    this.AlterGrpInfo = ((UserAlterGrpInfo)paramJceInputStream.read(cache_AlterGrpInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMngType, 0);
    paramJceOutputStream.write(this.vMngPack, 1);
    paramJceOutputStream.write(this.AlterGrpInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpMngNotify
 * JD-Core Version:    0.7.0.1
 */