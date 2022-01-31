package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqDelUri
  extends JceStruct
{
  public long lUin = 0L;
  public String strOther = "";
  public String strPhoneCode = "";
  
  public SvcReqDelUri() {}
  
  public SvcReqDelUri(long paramLong, String paramString1, String paramString2)
  {
    this.lUin = paramLong;
    this.strPhoneCode = paramString1;
    this.strOther = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strPhoneCode = paramJceInputStream.readString(1, true);
    this.strOther = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.strPhoneCode, 1);
    if (this.strOther != null) {
      paramJceOutputStream.write(this.strOther, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqDelUri
 * JD-Core Version:    0.7.0.1
 */