package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CityInfoRes
  extends JceStruct
{
  public String city = "";
  public String province = "";
  public byte result = 0;
  
  public CityInfoRes() {}
  
  public CityInfoRes(byte paramByte, String paramString1, String paramString2)
  {
    this.result = paramByte;
    this.city = paramString1;
    this.province = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.city = paramJceInputStream.readString(2, true);
    this.province = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.city, 2);
    if (this.province != null) {
      paramJceOutputStream.write(this.province, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.CityInfoRes
 * JD-Core Version:    0.7.0.1
 */