package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserLocaleInfo
  extends JceStruct
{
  public long lLatitude;
  public long lLongitude;
  
  public UserLocaleInfo() {}
  
  public UserLocaleInfo(long paramLong1, long paramLong2)
  {
    this.lLongitude = paramLong1;
    this.lLatitude = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lLongitude = paramJceInputStream.read(this.lLongitude, 1, false);
    this.lLatitude = paramJceInputStream.read(this.lLatitude, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lLongitude, 1);
    paramJceOutputStream.write(this.lLatitude, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.UserLocaleInfo
 * JD-Core Version:    0.7.0.1
 */