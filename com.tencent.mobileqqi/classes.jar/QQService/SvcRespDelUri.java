package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRespDelUri
  extends JceStruct
{
  public byte cResult = 0;
  public long lUin = 0L;
  public String strPhoneCode = "";
  public String strResult = "";
  
  public SvcRespDelUri() {}
  
  public SvcRespDelUri(long paramLong, String paramString1, byte paramByte, String paramString2)
  {
    this.lUin = paramLong;
    this.strPhoneCode = paramString1;
    this.cResult = paramByte;
    this.strResult = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strPhoneCode = paramJceInputStream.readString(1, true);
    this.cResult = paramJceInputStream.read(this.cResult, 2, true);
    this.strResult = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.strPhoneCode, 1);
    paramJceOutputStream.write(this.cResult, 2);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespDelUri
 * JD-Core Version:    0.7.0.1
 */