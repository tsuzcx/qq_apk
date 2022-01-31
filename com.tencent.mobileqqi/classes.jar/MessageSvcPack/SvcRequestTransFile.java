package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestTransFile
  extends JceStruct
{
  static byte[] cache_vMsg;
  public byte cOperateType = 0;
  public byte cVerifyType = 0;
  public long lCode = 0L;
  public long lReqSeq = 0L;
  public long lSessionId = 0L;
  public long lToAppId = 0L;
  public long lToInstanceId = 0L;
  public long lToUin = 0L;
  public byte[] vMsg = null;
  
  public SvcRequestTransFile() {}
  
  public SvcRequestTransFile(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte paramByte2, long paramLong5, long paramLong6, byte[] paramArrayOfByte)
  {
    this.cVerifyType = paramByte1;
    this.lToUin = paramLong1;
    this.lToAppId = paramLong2;
    this.lToInstanceId = paramLong3;
    this.lSessionId = paramLong4;
    this.cOperateType = paramByte2;
    this.lReqSeq = paramLong5;
    this.lCode = paramLong6;
    this.vMsg = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, false);
    this.lToUin = paramJceInputStream.read(this.lToUin, 1, true);
    this.lToAppId = paramJceInputStream.read(this.lToAppId, 2, true);
    this.lToInstanceId = paramJceInputStream.read(this.lToInstanceId, 3, true);
    this.lSessionId = paramJceInputStream.read(this.lSessionId, 4, true);
    this.cOperateType = paramJceInputStream.read(this.cOperateType, 5, true);
    this.lReqSeq = paramJceInputStream.read(this.lReqSeq, 6, true);
    this.lCode = paramJceInputStream.read(this.lCode, 7, true);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 8, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.lToUin, 1);
    paramJceOutputStream.write(this.lToAppId, 2);
    paramJceOutputStream.write(this.lToInstanceId, 3);
    paramJceOutputStream.write(this.lSessionId, 4);
    paramJceOutputStream.write(this.cOperateType, 5);
    paramJceOutputStream.write(this.lReqSeq, 6);
    paramJceOutputStream.write(this.lCode, 7);
    paramJceOutputStream.write(this.vMsg, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestTransFile
 * JD-Core Version:    0.7.0.1
 */