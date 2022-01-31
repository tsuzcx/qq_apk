package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResponseNotifyForRecommendUpdate
  extends JceStruct
{
  public long reserved = 0L;
  
  public ResponseNotifyForRecommendUpdate() {}
  
  public ResponseNotifyForRecommendUpdate(long paramLong)
  {
    this.reserved = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reserved = paramJceInputStream.read(this.reserved, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reserved, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponseNotifyForRecommendUpdate
 * JD-Core Version:    0.7.0.1
 */