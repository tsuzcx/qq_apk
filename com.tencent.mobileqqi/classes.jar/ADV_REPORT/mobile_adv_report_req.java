package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_adv_report_req
  extends JceStruct
{
  static s_anti_cheat cache_anti_cheat;
  static Map cache_cookie;
  public int action_expectation = 0;
  public int action_type = 0;
  public s_anti_cheat anti_cheat = null;
  public long client_time = 0L;
  public Map cookie = null;
  public long feed_index = 0L;
  public int report_posi = 0;
  public int write_return_code = 0;
  
  public mobile_adv_report_req() {}
  
  public mobile_adv_report_req(Map paramMap, int paramInt1, int paramInt2, long paramLong1, long paramLong2, s_anti_cheat params_anti_cheat, int paramInt3, int paramInt4)
  {
    this.cookie = paramMap;
    this.report_posi = paramInt1;
    this.write_return_code = paramInt2;
    this.client_time = paramLong1;
    this.feed_index = paramLong2;
    this.anti_cheat = params_anti_cheat;
    this.action_type = paramInt3;
    this.action_expectation = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_cookie == null)
    {
      cache_cookie = new HashMap();
      cache_cookie.put(Integer.valueOf(0), "");
    }
    this.cookie = ((Map)paramJceInputStream.read(cache_cookie, 0, false));
    this.report_posi = paramJceInputStream.read(this.report_posi, 1, false);
    this.write_return_code = paramJceInputStream.read(this.write_return_code, 2, false);
    this.client_time = paramJceInputStream.read(this.client_time, 3, false);
    this.feed_index = paramJceInputStream.read(this.feed_index, 4, false);
    if (cache_anti_cheat == null) {
      cache_anti_cheat = new s_anti_cheat();
    }
    this.anti_cheat = ((s_anti_cheat)paramJceInputStream.read(cache_anti_cheat, 5, false));
    this.action_type = paramJceInputStream.read(this.action_type, 6, false);
    this.action_expectation = paramJceInputStream.read(this.action_expectation, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 0);
    }
    paramJceOutputStream.write(this.report_posi, 1);
    paramJceOutputStream.write(this.write_return_code, 2);
    paramJceOutputStream.write(this.client_time, 3);
    paramJceOutputStream.write(this.feed_index, 4);
    if (this.anti_cheat != null) {
      paramJceOutputStream.write(this.anti_cheat, 5);
    }
    paramJceOutputStream.write(this.action_type, 6);
    paramJceOutputStream.write(this.action_expectation, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ADV_REPORT.mobile_adv_report_req
 * JD-Core Version:    0.7.0.1
 */