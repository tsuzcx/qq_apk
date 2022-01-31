package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BindUinResult
  extends JceStruct
{
  public int iResult = 0;
  public long lUin = 0L;
  public String strResult = "";
  
  public BindUinResult() {}
  
  public BindUinResult(long paramLong, int paramInt, String paramString)
  {
    this.lUin = paramLong;
    this.iResult = paramInt;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.strResult = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iResult, 1);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.BindUinResult
 * JD-Core Version:    0.7.0.1
 */