package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfSmpInfoRes
  extends JceStruct
{
  public byte cResult = 0;
  public byte cSex = 0;
  public long dwBirthday = 0L;
  public long dwCityID = 0L;
  public long dwCounrtyID = 0L;
  public int dwLevelOnline = 0;
  public int dwLevelRemain = 0;
  public long dwLoginDay = 0L;
  public long dwPhoneQQXManDay = 0L;
  public long dwProvinceID = 0L;
  public long dwUin = 0L;
  public long dwZoneID = 0L;
  public int isShowXMan = -1;
  public String sCity = "";
  public String sCountry = "";
  public String sProvince = "";
  public String strNick = "";
  public String strSignature = "";
  public byte wAge = 0;
  public short wFace = 0;
  public short wLevel = 0;
  
  public ProfSmpInfoRes() {}
  
  public ProfSmpInfoRes(long paramLong1, short paramShort1, byte paramByte1, byte paramByte2, String paramString1, byte paramByte3, String paramString2, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString3, String paramString4, String paramString5, short paramShort2, int paramInt1, int paramInt2, int paramInt3, long paramLong7, long paramLong8)
  {
    this.dwUin = paramLong1;
    this.wFace = paramShort1;
    this.cSex = paramByte1;
    this.wAge = paramByte2;
    this.strNick = paramString1;
    this.cResult = paramByte3;
    this.strSignature = paramString2;
    this.dwBirthday = paramLong2;
    this.dwCounrtyID = paramLong3;
    this.dwProvinceID = paramLong4;
    this.dwCityID = paramLong5;
    this.dwZoneID = paramLong6;
    this.sCountry = paramString3;
    this.sProvince = paramString4;
    this.sCity = paramString5;
    this.wLevel = paramShort2;
    this.dwLevelOnline = paramInt1;
    this.dwLevelRemain = paramInt2;
    this.isShowXMan = paramInt3;
    this.dwLoginDay = paramLong7;
    this.dwPhoneQQXManDay = paramLong8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, true);
    this.wFace = paramJceInputStream.read(this.wFace, 2, true);
    this.cSex = paramJceInputStream.read(this.cSex, 3, true);
    this.wAge = paramJceInputStream.read(this.wAge, 4, true);
    this.strNick = paramJceInputStream.readString(5, true);
    this.cResult = paramJceInputStream.read(this.cResult, 6, false);
    this.strSignature = paramJceInputStream.readString(7, false);
    this.dwBirthday = paramJceInputStream.read(this.dwBirthday, 8, false);
    this.dwCounrtyID = paramJceInputStream.read(this.dwCounrtyID, 9, false);
    this.dwProvinceID = paramJceInputStream.read(this.dwProvinceID, 10, false);
    this.dwCityID = paramJceInputStream.read(this.dwCityID, 11, false);
    this.dwZoneID = paramJceInputStream.read(this.dwZoneID, 12, false);
    this.sCountry = paramJceInputStream.readString(13, false);
    this.sProvince = paramJceInputStream.readString(14, false);
    this.sCity = paramJceInputStream.readString(15, false);
    this.wLevel = paramJceInputStream.read(this.wLevel, 16, false);
    this.dwLevelOnline = paramJceInputStream.read(this.dwLevelOnline, 17, false);
    this.dwLevelRemain = paramJceInputStream.read(this.dwLevelRemain, 18, false);
    this.isShowXMan = paramJceInputStream.read(this.isShowXMan, 19, false);
    this.dwLoginDay = paramJceInputStream.read(this.dwLoginDay, 20, false);
    this.dwPhoneQQXManDay = paramJceInputStream.read(this.dwPhoneQQXManDay, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwUin, 1);
    paramJceOutputStream.write(this.wFace, 2);
    paramJceOutputStream.write(this.cSex, 3);
    paramJceOutputStream.write(this.wAge, 4);
    paramJceOutputStream.write(this.strNick, 5);
    paramJceOutputStream.write(this.cResult, 6);
    if (this.strSignature != null) {
      paramJceOutputStream.write(this.strSignature, 7);
    }
    paramJceOutputStream.write(this.dwBirthday, 8);
    paramJceOutputStream.write(this.dwCounrtyID, 9);
    paramJceOutputStream.write(this.dwProvinceID, 10);
    paramJceOutputStream.write(this.dwCityID, 11);
    paramJceOutputStream.write(this.dwZoneID, 12);
    if (this.sCountry != null) {
      paramJceOutputStream.write(this.sCountry, 13);
    }
    if (this.sProvince != null) {
      paramJceOutputStream.write(this.sProvince, 14);
    }
    if (this.sCity != null) {
      paramJceOutputStream.write(this.sCity, 15);
    }
    paramJceOutputStream.write(this.wLevel, 16);
    paramJceOutputStream.write(this.dwLevelOnline, 17);
    paramJceOutputStream.write(this.dwLevelRemain, 18);
    paramJceOutputStream.write(this.isShowXMan, 19);
    paramJceOutputStream.write(this.dwLoginDay, 20);
    paramJceOutputStream.write(this.dwPhoneQQXManDay, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.ProfSmpInfoRes
 * JD-Core Version:    0.7.0.1
 */