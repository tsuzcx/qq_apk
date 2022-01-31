package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserDetailLocalInfo
  extends JceStruct
{
  static byte[] cache_SOSOUrl;
  static byte[] cache_cityId;
  public byte[] SOSOUrl = null;
  public byte[] cityId = null;
  public String strCity = "";
  public String strDistrict = "";
  public String strPremises = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  
  public UserDetailLocalInfo() {}
  
  public UserDetailLocalInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.strProvince = paramString1;
    this.strCity = paramString2;
    this.strDistrict = paramString3;
    this.strTown = paramString4;
    this.strRoad = paramString5;
    this.strPremises = paramString6;
    this.SOSOUrl = paramArrayOfByte1;
    this.cityId = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strProvince = paramJceInputStream.readString(0, true);
    this.strCity = paramJceInputStream.readString(1, true);
    this.strDistrict = paramJceInputStream.readString(2, true);
    this.strTown = paramJceInputStream.readString(3, true);
    this.strRoad = paramJceInputStream.readString(4, true);
    this.strPremises = paramJceInputStream.readString(5, true);
    if (cache_SOSOUrl == null)
    {
      cache_SOSOUrl = (byte[])new byte[1];
      ((byte[])cache_SOSOUrl)[0] = 0;
    }
    this.SOSOUrl = ((byte[])paramJceInputStream.read(cache_SOSOUrl, 6, false));
    if (cache_cityId == null)
    {
      cache_cityId = (byte[])new byte[1];
      ((byte[])cache_cityId)[0] = 0;
    }
    this.cityId = ((byte[])paramJceInputStream.read(cache_cityId, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strProvince, 0);
    paramJceOutputStream.write(this.strCity, 1);
    paramJceOutputStream.write(this.strDistrict, 2);
    paramJceOutputStream.write(this.strTown, 3);
    paramJceOutputStream.write(this.strRoad, 4);
    paramJceOutputStream.write(this.strPremises, 5);
    if (this.SOSOUrl != null) {
      paramJceOutputStream.write(this.SOSOUrl, 6);
    }
    if (this.cityId != null) {
      paramJceOutputStream.write(this.cityId, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NeighborSvc.UserDetailLocalInfo
 * JD-Core Version:    0.7.0.1
 */