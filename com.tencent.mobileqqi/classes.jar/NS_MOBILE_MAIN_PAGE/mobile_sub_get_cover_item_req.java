package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_cover_item_req
  extends JceStruct
{
  public String id = "";
  
  public mobile_sub_get_cover_item_req() {}
  
  public mobile_sub_get_cover_item_req(String paramString)
  {
    this.id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_item_req
 * JD-Core Version:    0.7.0.1
 */