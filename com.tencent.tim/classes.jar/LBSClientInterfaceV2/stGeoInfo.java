package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGeoInfo
  extends JceStruct
{
  public int iDistrictCode = 0;
  public int iRange = -1;
  public String strCity = "";
  public String strCountry = "";
  public String strDisplayName = "";
  public String strDistrict = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  public String strVillage = "";
  
  public stGeoInfo() {}
  
  public stGeoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.iDistrictCode = paramInt1;
    this.iRange = paramInt2;
    this.strCountry = paramString1;
    this.strProvince = paramString2;
    this.strCity = paramString3;
    this.strDistrict = paramString4;
    this.strTown = paramString5;
    this.strVillage = paramString6;
    this.strRoad = paramString7;
    this.strDisplayName = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 0, true);
    this.iRange = paramJceInputStream.read(this.iRange, 1, true);
    this.strCountry = paramJceInputStream.readString(2, true);
    this.strProvince = paramJceInputStream.readString(3, true);
    this.strCity = paramJceInputStream.readString(4, true);
    this.strDistrict = paramJceInputStream.readString(5, true);
    this.strTown = paramJceInputStream.readString(6, true);
    this.strVillage = paramJceInputStream.readString(7, true);
    this.strRoad = paramJceInputStream.readString(8, true);
    this.strDisplayName = paramJceInputStream.readString(9, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iDistrictCode, 0);
    paramJceOutputStream.write(this.iRange, 1);
    paramJceOutputStream.write(this.strCountry, 2);
    paramJceOutputStream.write(this.strProvince, 3);
    paramJceOutputStream.write(this.strCity, 4);
    paramJceOutputStream.write(this.strDistrict, 5);
    paramJceOutputStream.write(this.strTown, 6);
    paramJceOutputStream.write(this.strVillage, 7);
    paramJceOutputStream.write(this.strRoad, 8);
    paramJceOutputStream.write(this.strDisplayName, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     LBSClientInterfaceV2.stGeoInfo
 * JD-Core Version:    0.7.0.1
 */