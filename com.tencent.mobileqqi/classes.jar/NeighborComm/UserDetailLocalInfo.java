package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserDetailLocalInfo
  extends JceStruct
{
  public String strCity = "";
  public String strDistrict = "";
  public String strPremises = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  
  public UserDetailLocalInfo() {}
  
  public UserDetailLocalInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.strProvince = paramString1;
    this.strCity = paramString2;
    this.strDistrict = paramString3;
    this.strTown = paramString4;
    this.strRoad = paramString5;
    this.strPremises = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strProvince = paramJceInputStream.readString(0, false);
    this.strCity = paramJceInputStream.readString(1, false);
    this.strDistrict = paramJceInputStream.readString(2, false);
    this.strTown = paramJceInputStream.readString(3, false);
    this.strRoad = paramJceInputStream.readString(4, false);
    this.strPremises = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 0);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 1);
    }
    if (this.strDistrict != null) {
      paramJceOutputStream.write(this.strDistrict, 2);
    }
    if (this.strTown != null) {
      paramJceOutputStream.write(this.strTown, 3);
    }
    if (this.strRoad != null) {
      paramJceOutputStream.write(this.strRoad, 4);
    }
    if (this.strPremises != null) {
      paramJceOutputStream.write(this.strPremises, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborComm.UserDetailLocalInfo
 * JD-Core Version:    0.7.0.1
 */