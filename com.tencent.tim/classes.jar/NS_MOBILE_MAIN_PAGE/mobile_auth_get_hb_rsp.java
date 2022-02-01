package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_auth_get_hb_rsp
  extends JceStruct
{
  static callback_info cache_hb_info = new callback_info();
  static Map<Long, String> cache_uin_nick = new HashMap();
  public int auth_res;
  public long channel;
  public String encryp_key = "";
  public String err_msg = "";
  public callback_info hb_info;
  public int operate_type;
  public Map<Long, String> uin_nick;
  
  static
  {
    cache_uin_nick.put(Long.valueOf(0L), "");
  }
  
  public mobile_auth_get_hb_rsp() {}
  
  public mobile_auth_get_hb_rsp(int paramInt1, String paramString1, long paramLong, callback_info paramcallback_info, String paramString2, int paramInt2, Map<Long, String> paramMap)
  {
    this.auth_res = paramInt1;
    this.encryp_key = paramString1;
    this.channel = paramLong;
    this.hb_info = paramcallback_info;
    this.err_msg = paramString2;
    this.operate_type = paramInt2;
    this.uin_nick = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.auth_res = paramJceInputStream.read(this.auth_res, 0, true);
    this.encryp_key = paramJceInputStream.readString(1, false);
    this.channel = paramJceInputStream.read(this.channel, 2, false);
    this.hb_info = ((callback_info)paramJceInputStream.read(cache_hb_info, 3, false));
    this.err_msg = paramJceInputStream.readString(4, false);
    this.operate_type = paramJceInputStream.read(this.operate_type, 5, false);
    this.uin_nick = ((Map)paramJceInputStream.read(cache_uin_nick, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.auth_res, 0);
    if (this.encryp_key != null) {
      paramJceOutputStream.write(this.encryp_key, 1);
    }
    paramJceOutputStream.write(this.channel, 2);
    if (this.hb_info != null) {
      paramJceOutputStream.write(this.hb_info, 3);
    }
    if (this.err_msg != null) {
      paramJceOutputStream.write(this.err_msg, 4);
    }
    paramJceOutputStream.write(this.operate_type, 5);
    if (this.uin_nick != null) {
      paramJceOutputStream.write(this.uin_nick, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_auth_get_hb_rsp
 * JD-Core Version:    0.7.0.1
 */