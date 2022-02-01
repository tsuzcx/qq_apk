package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPoiInfo
  extends JceStruct
{
  static stGPS cache_stGps;
  public int iDistance = 0;
  public int iDistrictCode = 0;
  public int iHotValue = 0;
  public int iType = 0;
  public int sorttype = 1;
  public stGPS stGps = null;
  public String strAddress = "";
  public String strCity = "";
  public String strCountry = "";
  public String strName = "";
  public String strPhone = "";
  public String strPoiId = "";
  public String strProvince = "";
  public String strTypeName = "";
  
  public stPoiInfo() {}
  
  public stPoiInfo(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, stGPS paramstGPS, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt5)
  {
    this.strPoiId = paramString1;
    this.strName = paramString2;
    this.iType = paramInt1;
    this.strTypeName = paramString3;
    this.strAddress = paramString4;
    this.iDistrictCode = paramInt2;
    this.stGps = paramstGPS;
    this.iDistance = paramInt3;
    this.iHotValue = paramInt4;
    this.strPhone = paramString5;
    this.strCountry = paramString6;
    this.strProvince = paramString7;
    this.strCity = paramString8;
    this.sorttype = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPoiId = paramJceInputStream.readString(0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.iType = paramJceInputStream.read(this.iType, 2, true);
    this.strTypeName = paramJceInputStream.readString(3, true);
    this.strAddress = paramJceInputStream.readString(4, true);
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 5, true);
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 6, true));
    this.iDistance = paramJceInputStream.read(this.iDistance, 7, true);
    this.iHotValue = paramJceInputStream.read(this.iHotValue, 8, false);
    this.strPhone = paramJceInputStream.readString(9, false);
    this.strCountry = paramJceInputStream.readString(10, false);
    this.strProvince = paramJceInputStream.readString(11, false);
    this.strCity = paramJceInputStream.readString(12, false);
    this.sorttype = paramJceInputStream.read(this.sorttype, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPoiId, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.iType, 2);
    paramJceOutputStream.write(this.strTypeName, 3);
    paramJceOutputStream.write(this.strAddress, 4);
    paramJceOutputStream.write(this.iDistrictCode, 5);
    paramJceOutputStream.write(this.stGps, 6);
    paramJceOutputStream.write(this.iDistance, 7);
    paramJceOutputStream.write(this.iHotValue, 8);
    if (this.strPhone != null) {
      paramJceOutputStream.write(this.strPhone, 9);
    }
    if (this.strCountry != null) {
      paramJceOutputStream.write(this.strCountry, 10);
    }
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 11);
    }
    if (this.strCity != null) {
      paramJceOutputStream.write(this.strCity, 12);
    }
    paramJceOutputStream.write(this.sorttype, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     LBSClientInterfaceV2.stPoiInfo
 * JD-Core Version:    0.7.0.1
 */