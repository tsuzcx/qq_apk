package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_visit_noright_req
  extends JceStruct
{
  public String page = "";
  public long uin = 0L;
  
  public mobile_sub_get_visit_noright_req() {}
  
  public mobile_sub_get_visit_noright_req(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.page = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.page = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_noright_req
 * JD-Core Version:    0.7.0.1
 */