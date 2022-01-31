package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqSetUri
  extends JceStruct
{
  public long lUin = 0L;
  public String strImagePath = "";
  public String strOther = "";
  public String strPhoneCode = "";
  public String strUri = "";
  
  public SvcReqSetUri() {}
  
  public SvcReqSetUri(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.lUin = paramLong;
    this.strPhoneCode = paramString1;
    this.strUri = paramString2;
    this.strImagePath = paramString3;
    this.strOther = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strPhoneCode = paramJceInputStream.readString(1, true);
    this.strUri = paramJceInputStream.readString(2, true);
    this.strImagePath = paramJceInputStream.readString(3, true);
    this.strOther = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.strPhoneCode, 1);
    paramJceOutputStream.write(this.strUri, 2);
    paramJceOutputStream.write(this.strImagePath, 3);
    if (this.strOther != null) {
      paramJceOutputStream.write(this.strOther, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqSetUri
 * JD-Core Version:    0.7.0.1
 */