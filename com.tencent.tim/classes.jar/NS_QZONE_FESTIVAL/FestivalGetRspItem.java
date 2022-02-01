package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FestivalGetRspItem
  extends JceStruct
{
  public long festival_mdays;
  public long festival_month;
  public String festival_name = "";
  public long festival_type;
  public long festival_year;
  public int result_code;
  
  public FestivalGetRspItem() {}
  
  public FestivalGetRspItem(int paramInt, String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.result_code = paramInt;
    this.festival_name = paramString;
    this.festival_type = paramLong1;
    this.festival_year = paramLong2;
    this.festival_month = paramLong3;
    this.festival_mdays = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result_code = paramJceInputStream.read(this.result_code, 0, true);
    this.festival_name = paramJceInputStream.readString(1, true);
    this.festival_type = paramJceInputStream.read(this.festival_type, 2, true);
    this.festival_year = paramJceInputStream.read(this.festival_year, 3, false);
    this.festival_month = paramJceInputStream.read(this.festival_month, 4, true);
    this.festival_mdays = paramJceInputStream.read(this.festival_mdays, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result_code, 0);
    paramJceOutputStream.write(this.festival_name, 1);
    paramJceOutputStream.write(this.festival_type, 2);
    paramJceOutputStream.write(this.festival_year, 3);
    paramJceOutputStream.write(this.festival_month, 4);
    paramJceOutputStream.write(this.festival_mdays, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QZONE_FESTIVAL.FestivalGetRspItem
 * JD-Core Version:    0.7.0.1
 */