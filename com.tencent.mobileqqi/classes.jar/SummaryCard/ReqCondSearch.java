package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCondSearch
  extends JceStruct
{
  static byte[] cache_vCityId;
  static byte[] cache_vHomeId;
  public short cAge = 0;
  public byte cGender = 0;
  public long dwFlag = 0L;
  public long dwSessionID = 0L;
  public int iPage = 0;
  public String strNick = "";
  public byte[] vCityId = null;
  public byte[] vHomeId = null;
  
  public ReqCondSearch() {}
  
  public ReqCondSearch(int paramInt, long paramLong1, long paramLong2, String paramString, byte paramByte, byte[] paramArrayOfByte1, short paramShort, byte[] paramArrayOfByte2)
  {
    this.iPage = paramInt;
    this.dwSessionID = paramLong1;
    this.dwFlag = paramLong2;
    this.strNick = paramString;
    this.cGender = paramByte;
    this.vCityId = paramArrayOfByte1;
    this.cAge = paramShort;
    this.vHomeId = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPage = paramJceInputStream.read(this.iPage, 0, true);
    this.dwSessionID = paramJceInputStream.read(this.dwSessionID, 1, true);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 2, true);
    this.strNick = paramJceInputStream.readString(3, false);
    this.cGender = paramJceInputStream.read(this.cGender, 4, false);
    if (cache_vCityId == null)
    {
      cache_vCityId = (byte[])new byte[1];
      ((byte[])cache_vCityId)[0] = 0;
    }
    this.vCityId = ((byte[])paramJceInputStream.read(cache_vCityId, 5, false));
    this.cAge = paramJceInputStream.read(this.cAge, 6, false);
    if (cache_vHomeId == null)
    {
      cache_vHomeId = (byte[])new byte[1];
      ((byte[])cache_vHomeId)[0] = 0;
    }
    this.vHomeId = ((byte[])paramJceInputStream.read(cache_vHomeId, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPage, 0);
    paramJceOutputStream.write(this.dwSessionID, 1);
    paramJceOutputStream.write(this.dwFlag, 2);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    paramJceOutputStream.write(this.cGender, 4);
    if (this.vCityId != null) {
      paramJceOutputStream.write(this.vCityId, 5);
    }
    paramJceOutputStream.write(this.cAge, 6);
    if (this.vHomeId != null) {
      paramJceOutputStream.write(this.vHomeId, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SummaryCard.ReqCondSearch
 * JD-Core Version:    0.7.0.1
 */