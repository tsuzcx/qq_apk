package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestResetContactsSetting
  extends JceStruct
{
  public long isRecommend = 0L;
  
  public RequestResetContactsSetting() {}
  
  public RequestResetContactsSetting(long paramLong)
  {
    this.isRecommend = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isRecommend, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestResetContactsSetting
 * JD-Core Version:    0.7.0.1
 */