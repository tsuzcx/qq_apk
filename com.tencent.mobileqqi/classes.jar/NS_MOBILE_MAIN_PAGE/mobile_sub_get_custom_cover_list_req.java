package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_custom_cover_list_req
  extends JceStruct
{
  public String attachInfo = "";
  
  public mobile_sub_get_custom_cover_list_req() {}
  
  public mobile_sub_get_custom_cover_list_req(String paramString)
  {
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_custom_cover_list_req
 * JD-Core Version:    0.7.0.1
 */