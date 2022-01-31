package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QuitGrp
  extends JceStruct
{
  public long Mid = 0L;
  
  public QuitGrp() {}
  
  public QuitGrp(long paramLong)
  {
    this.Mid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Mid = paramJceInputStream.read(this.Mid, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Mid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.QuitGrp
 * JD-Core Version:    0.7.0.1
 */