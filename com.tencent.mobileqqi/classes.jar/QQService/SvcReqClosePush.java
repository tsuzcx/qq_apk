package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqClosePush
  extends JceStruct
{
  public int iPushType = 0;
  public long lUin = 0L;
  public String strOther = "";
  public String strPhoneCode = "";
  
  public SvcReqClosePush() {}
  
  public SvcReqClosePush(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    this.lUin = paramLong;
    this.strPhoneCode = paramString1;
    this.iPushType = paramInt;
    this.strOther = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strPhoneCode = paramJceInputStream.readString(1, true);
    this.iPushType = paramJceInputStream.read(this.iPushType, 2, true);
    this.strOther = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.strPhoneCode, 1);
    paramJceOutputStream.write(this.iPushType, 2);
    if (this.strOther != null) {
      paramJceOutputStream.write(this.strOther, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqClosePush
 * JD-Core Version:    0.7.0.1
 */