package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_photo_wall_req
  extends JceStruct
{
  public String attachInfo = "";
  public long uin;
  
  public mobile_sub_get_photo_wall_req() {}
  
  public mobile_sub_get_photo_wall_req(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attachInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_req
 * JD-Core Version:    0.7.0.1
 */