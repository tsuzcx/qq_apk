package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_get_rc_tab_rsp
  extends JceStruct
{
  static s_rc_tab_list cache_rc_data;
  public s_rc_tab_list rc_data;
  
  public mobile_get_rc_tab_rsp() {}
  
  public mobile_get_rc_tab_rsp(s_rc_tab_list params_rc_tab_list)
  {
    this.rc_data = params_rc_tab_list;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_rc_data == null) {
      cache_rc_data = new s_rc_tab_list();
    }
    this.rc_data = ((s_rc_tab_list)paramJceInputStream.read(cache_rc_data, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rc_data != null) {
      paramJceOutputStream.write(this.rc_data, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.mobile_get_rc_tab_rsp
 * JD-Core Version:    0.7.0.1
 */