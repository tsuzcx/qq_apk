package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_host_hb_info_rsp
  extends JceStruct
{
  static callback_info cache_hb_info = new callback_info();
  public int auth_res;
  public long channel;
  public String encryp_key = "";
  public String err_msg = "";
  public String feeds_id = "";
  public boolean has_available = true;
  public String hb_id = "";
  public callback_info hb_info;
  
  public mobile_host_hb_info_rsp() {}
  
  public mobile_host_hb_info_rsp(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, long paramLong, callback_info paramcallback_info, String paramString4)
  {
    this.has_available = paramBoolean;
    this.hb_id = paramString1;
    this.feeds_id = paramString2;
    this.auth_res = paramInt;
    this.encryp_key = paramString3;
    this.channel = paramLong;
    this.hb_info = paramcallback_info;
    this.err_msg = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.has_available = paramJceInputStream.read(this.has_available, 0, true);
    this.hb_id = paramJceInputStream.readString(1, false);
    this.feeds_id = paramJceInputStream.readString(2, false);
    this.auth_res = paramJceInputStream.read(this.auth_res, 3, false);
    this.encryp_key = paramJceInputStream.readString(4, false);
    this.channel = paramJceInputStream.read(this.channel, 5, false);
    this.hb_info = ((callback_info)paramJceInputStream.read(cache_hb_info, 6, false));
    this.err_msg = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.has_available, 0);
    if (this.hb_id != null) {
      paramJceOutputStream.write(this.hb_id, 1);
    }
    if (this.feeds_id != null) {
      paramJceOutputStream.write(this.feeds_id, 2);
    }
    paramJceOutputStream.write(this.auth_res, 3);
    if (this.encryp_key != null) {
      paramJceOutputStream.write(this.encryp_key, 4);
    }
    paramJceOutputStream.write(this.channel, 5);
    if (this.hb_info != null) {
      paramJceOutputStream.write(this.hb_info, 6);
    }
    if (this.err_msg != null) {
      paramJceOutputStream.write(this.err_msg, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_host_hb_info_rsp
 * JD-Core Version:    0.7.0.1
 */