package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRespSetPushConfig
  extends JceStruct
{
  public byte cReplyCode = 0;
  public byte cType = 0;
  public long lUin = 0L;
  public String strResult = "";
  
  public SvcRespSetPushConfig() {}
  
  public SvcRespSetPushConfig(long paramLong, byte paramByte1, byte paramByte2, String paramString)
  {
    this.lUin = paramLong;
    this.cType = paramByte1;
    this.cReplyCode = paramByte2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespSetPushConfig
 * JD-Core Version:    0.7.0.1
 */