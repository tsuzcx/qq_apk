package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_uncare_rsp
  extends JceStruct
{
  static s_uncare cache_uncare;
  public s_uncare uncare;
  
  public mobile_sub_uncare_rsp() {}
  
  public mobile_sub_uncare_rsp(s_uncare params_uncare)
  {
    this.uncare = params_uncare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uncare == null) {
      cache_uncare = new s_uncare();
    }
    this.uncare = ((s_uncare)paramJceInputStream.read(cache_uncare, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uncare != null) {
      paramJceOutputStream.write(this.uncare, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_uncare_rsp
 * JD-Core Version:    0.7.0.1
 */