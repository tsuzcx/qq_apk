package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShuoshuoInfoRsp
  extends JceStruct
{
  static byte[] cache_vBusiNessDataRsp = (byte[])new byte[1];
  public byte[] vBusiNessDataRsp = null;
  
  static
  {
    ((byte[])cache_vBusiNessDataRsp)[0] = 0;
  }
  
  public ShuoshuoInfoRsp() {}
  
  public ShuoshuoInfoRsp(byte[] paramArrayOfByte)
  {
    this.vBusiNessDataRsp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vBusiNessDataRsp = ((byte[])paramJceInputStream.read(cache_vBusiNessDataRsp, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vBusiNessDataRsp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FileUpload.ShuoshuoInfoRsp
 * JD-Core Version:    0.7.0.1
 */