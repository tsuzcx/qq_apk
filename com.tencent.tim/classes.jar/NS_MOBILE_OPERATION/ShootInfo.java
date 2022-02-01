package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShootInfo
  extends JceStruct
{
  static LbsInfo cache_shootLbs;
  public LbsInfo shootLbs;
  public long shootTime;
  
  public ShootInfo() {}
  
  public ShootInfo(LbsInfo paramLbsInfo, long paramLong)
  {
    this.shootLbs = paramLbsInfo;
    this.shootTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_shootLbs == null) {
      cache_shootLbs = new LbsInfo();
    }
    this.shootLbs = ((LbsInfo)paramJceInputStream.read(cache_shootLbs, 0, false));
    this.shootTime = paramJceInputStream.read(this.shootTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.shootLbs != null) {
      paramJceOutputStream.write(this.shootLbs, 0);
    }
    paramJceOutputStream.write(this.shootTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ShootInfo
 * JD-Core Version:    0.7.0.1
 */