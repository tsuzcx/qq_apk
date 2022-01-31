package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_profile_rsp
  extends JceStruct
{
  static s_profile cache_profile;
  public s_profile profile = null;
  
  public mobile_sub_get_profile_rsp() {}
  
  public mobile_sub_get_profile_rsp(s_profile params_profile)
  {
    this.profile = params_profile;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_profile == null) {
      cache_profile = new s_profile();
    }
    this.profile = ((s_profile)paramJceInputStream.read(cache_profile, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.profile != null) {
      paramJceOutputStream.write(this.profile, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_profile_rsp
 * JD-Core Version:    0.7.0.1
 */