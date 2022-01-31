package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_setblack_req
  extends JceStruct
{
  static s_black cache_black;
  public int action = 0;
  public s_black black = null;
  
  public mobile_sub_setblack_req() {}
  
  public mobile_sub_setblack_req(int paramInt, s_black params_black)
  {
    this.action = paramInt;
    this.black = params_black;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    if (cache_black == null) {
      cache_black = new s_black();
    }
    this.black = ((s_black)paramJceInputStream.read(cache_black, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    if (this.black != null) {
      paramJceOutputStream.write(this.black, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_setblack_req
 * JD-Core Version:    0.7.0.1
 */