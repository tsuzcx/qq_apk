package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGroupInArea
  extends JceStruct
{
  public long dwGroupStartIdx = 0L;
  public int iCount = 0;
  public int iLat = 0;
  public int iLon = 0;
  public String strAreaName = "";
  
  public ReqGetGroupInArea() {}
  
  public ReqGetGroupInArea(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.strAreaName = paramString;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.dwGroupStartIdx = paramLong;
    this.iCount = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAreaName = paramJceInputStream.readString(0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.dwGroupStartIdx = paramJceInputStream.read(this.dwGroupStartIdx, 3, false);
    this.iCount = paramJceInputStream.read(this.iCount, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strAreaName, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.dwGroupStartIdx, 3);
    paramJceOutputStream.write(this.iCount, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyGroup.ReqGetGroupInArea
 * JD-Core Version:    0.7.0.1
 */