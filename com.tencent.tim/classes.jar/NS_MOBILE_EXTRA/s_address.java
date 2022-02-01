package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_address
  extends JceStruct
{
  public String cityid = "";
  public String countryid = "";
  public String provinceid = "";
  
  public s_address() {}
  
  public s_address(String paramString1, String paramString2, String paramString3)
  {
    this.countryid = paramString1;
    this.provinceid = paramString2;
    this.cityid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.countryid = paramJceInputStream.readString(0, false);
    this.provinceid = paramJceInputStream.readString(1, false);
    this.cityid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.countryid != null) {
      paramJceOutputStream.write(this.countryid, 0);
    }
    if (this.provinceid != null) {
      paramJceOutputStream.write(this.provinceid, 1);
    }
    if (this.cityid != null) {
      paramJceOutputStream.write(this.cityid, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.s_address
 * JD-Core Version:    0.7.0.1
 */