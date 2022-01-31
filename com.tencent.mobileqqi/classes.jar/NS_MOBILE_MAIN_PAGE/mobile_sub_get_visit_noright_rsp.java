package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_visit_noright_rsp
  extends JceStruct
{
  static yellow_info cache_user_yellow_info;
  static s_visit cache_visit;
  public boolean end = true;
  public String page = "";
  public yellow_info user_yellow_info = null;
  public s_visit visit = null;
  
  public mobile_sub_get_visit_noright_rsp() {}
  
  public mobile_sub_get_visit_noright_rsp(s_visit params_visit, String paramString, boolean paramBoolean, yellow_info paramyellow_info)
  {
    this.visit = params_visit;
    this.page = paramString;
    this.end = paramBoolean;
    this.user_yellow_info = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_visit == null) {
      cache_visit = new s_visit();
    }
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 0, false));
    this.page = paramJceInputStream.readString(1, false);
    this.end = paramJceInputStream.read(this.end, 2, false);
    if (cache_user_yellow_info == null) {
      cache_user_yellow_info = new yellow_info();
    }
    this.user_yellow_info = ((yellow_info)paramJceInputStream.read(cache_user_yellow_info, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 0);
    }
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
    paramJceOutputStream.write(this.end, 2);
    if (this.user_yellow_info != null) {
      paramJceOutputStream.write(this.user_yellow_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_noright_rsp
 * JD-Core Version:    0.7.0.1
 */