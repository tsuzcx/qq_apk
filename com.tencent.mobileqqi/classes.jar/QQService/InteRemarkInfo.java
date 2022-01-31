package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InteRemarkInfo
  extends JceStruct
{
  public long Source = 0L;
  public String StrValue = "";
  
  public InteRemarkInfo() {}
  
  public InteRemarkInfo(String paramString, long paramLong)
  {
    this.StrValue = paramString;
    this.Source = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.StrValue = paramJceInputStream.readString(0, true);
    this.Source = paramJceInputStream.read(this.Source, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.StrValue, 0);
    paramJceOutputStream.write(this.Source, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.InteRemarkInfo
 * JD-Core Version:    0.7.0.1
 */