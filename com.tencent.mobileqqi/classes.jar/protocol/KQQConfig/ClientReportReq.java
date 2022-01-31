package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientReportReq
  extends JceStruct
{
  static byte[] cache_sContentBytes;
  public byte bType = 0;
  public String sContent = "";
  public byte[] sContentBytes = null;
  
  public ClientReportReq() {}
  
  public ClientReportReq(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.bType = paramByte;
    this.sContent = paramString;
    this.sContentBytes = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bType = paramJceInputStream.read(this.bType, 1, true);
    this.sContent = paramJceInputStream.readString(3, true);
    if (cache_sContentBytes == null)
    {
      cache_sContentBytes = (byte[])new byte[1];
      ((byte[])cache_sContentBytes)[0] = 0;
    }
    this.sContentBytes = ((byte[])paramJceInputStream.read(cache_sContentBytes, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bType, 1);
    paramJceOutputStream.write(this.sContent, 3);
    if (this.sContentBytes != null) {
      paramJceOutputStream.write(this.sContentBytes, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ClientReportReq
 * JD-Core Version:    0.7.0.1
 */