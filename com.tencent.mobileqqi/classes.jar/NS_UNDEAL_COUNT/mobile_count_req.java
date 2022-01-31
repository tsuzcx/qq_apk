package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_count_req
  extends JceStruct
{
  public int iRelationType = 0;
  public int iVisitQZoneType = 0;
  public long uMask = 0L;
  
  public mobile_count_req() {}
  
  public mobile_count_req(long paramLong, int paramInt1, int paramInt2)
  {
    this.uMask = paramLong;
    this.iRelationType = paramInt1;
    this.iVisitQZoneType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    this.iRelationType = paramJceInputStream.read(this.iRelationType, 1, false);
    this.iVisitQZoneType = paramJceInputStream.read(this.iVisitQZoneType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    paramJceOutputStream.write(this.iRelationType, 1);
    paramJceOutputStream.write(this.iVisitQZoneType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_req
 * JD-Core Version:    0.7.0.1
 */