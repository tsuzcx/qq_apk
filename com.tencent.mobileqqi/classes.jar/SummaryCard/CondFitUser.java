package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class CondFitUser
  extends JceStruct
{
  static byte[] cache_vRichSign;
  public byte cSex = 0;
  public long dwAge = 0L;
  public long dwCity = 0L;
  public long dwCountry = 0L;
  public long dwProvince = 0L;
  public long lUIN = 0L;
  public String locDesc;
  public RichStatus richStatus;
  public String strNick = "";
  public byte[] vRichSign = null;
  
  public CondFitUser() {}
  
  public CondFitUser(long paramLong1, String paramString, byte[] paramArrayOfByte, byte paramByte, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.lUIN = paramLong1;
    this.strNick = paramString;
    this.vRichSign = paramArrayOfByte;
    this.cSex = paramByte;
    this.dwAge = paramLong2;
    this.dwCountry = paramLong3;
    this.dwProvince = paramLong4;
    this.dwCity = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.strNick = paramJceInputStream.readString(1, false);
    if (cache_vRichSign == null)
    {
      cache_vRichSign = (byte[])new byte[1];
      ((byte[])cache_vRichSign)[0] = 0;
    }
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 2, false));
    this.cSex = paramJceInputStream.read(this.cSex, 3, false);
    this.dwAge = paramJceInputStream.read(this.dwAge, 4, false);
    this.dwCountry = paramJceInputStream.read(this.dwCountry, 5, false);
    this.dwProvince = paramJceInputStream.read(this.dwProvince, 6, false);
    this.dwCity = paramJceInputStream.read(this.dwCity, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 1);
    }
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 2);
    }
    paramJceOutputStream.write(this.cSex, 3);
    paramJceOutputStream.write(this.dwAge, 4);
    paramJceOutputStream.write(this.dwCountry, 5);
    paramJceOutputStream.write(this.dwProvince, 6);
    paramJceOutputStream.write(this.dwCity, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SummaryCard.CondFitUser
 * JD-Core Version:    0.7.0.1
 */