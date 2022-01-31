package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GPS_V2
  extends JceStruct
{
  public int eType = 2;
  public int iAlt = -10000000;
  public int iLat = 900000000;
  public int iLon = 900000000;
  
  public GPS_V2() {}
  
  public GPS_V2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.eType = paramInt3;
    this.iAlt = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.eType = paramJceInputStream.read(this.eType, 2, true);
    this.iAlt = paramJceInputStream.read(this.iAlt, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.eType, 2);
    paramJceOutputStream.write(this.iAlt, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GPS_V2
 * JD-Core Version:    0.7.0.1
 */