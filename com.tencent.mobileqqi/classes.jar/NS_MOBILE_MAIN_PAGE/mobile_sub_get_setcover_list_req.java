package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_setcover_list_req
  extends JceStruct
{
  public String attachInfo = "";
  public String id = "";
  public long uin = 0L;
  
  public mobile_sub_get_setcover_list_req() {}
  
  public mobile_sub_get_setcover_list_req(long paramLong, String paramString1, String paramString2)
  {
    this.uin = paramLong;
    this.id = paramString1;
    this.attachInfo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.id = paramJceInputStream.readString(1, false);
    this.attachInfo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 1);
    }
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_setcover_list_req
 * JD-Core Version:    0.7.0.1
 */