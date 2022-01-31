package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponseMsgReadedReport
  extends JceStruct
{
  static byte[] cache_vSyncCookie;
  public byte cReplyCode = 0;
  public String strResult = "";
  public byte[] vSyncCookie = null;
  
  public SvcResponseMsgReadedReport() {}
  
  public SvcResponseMsgReadedReport(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.vSyncCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
    if (cache_vSyncCookie == null)
    {
      cache_vSyncCookie = (byte[])new byte[1];
      ((byte[])cache_vSyncCookie)[0] = 0;
    }
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
    paramJceOutputStream.write(this.vSyncCookie, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseMsgReadedReport
 * JD-Core Version:    0.7.0.1
 */