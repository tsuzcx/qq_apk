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
  static Map<Integer, String> cache_busi_param;
  static Map<Integer, String> cache_cookie = new HashMap();
  public int action_expectation;
  public int action_type;
  public s_anti_cheat anti_cheat;
  public String antispam_info = "";
  public Map<Integer, String> busi_param;
  public long client_time;
  public Map<Integer, String> cookie;
  public long cost_time;
  public long error_code;
  public long feed_index;
  public String feeds_click_attachinfo = "";
  public boolean is_filter;
  public boolean is_impression = true;
  public boolean is_installed;
  public boolean is_repeated;
  public boolean is_report_gdt = true;
  public boolean is_trace;
  public int report_posi;
  public long stay_time;
  public String video_playinfo = "";
  public int write_return_code;
  
  static
  {
    cache_cookie.put(Integer.valueOf(0), "");
    cache_anti_cheat = new s_anti_cheat();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public mobile_adv_report_req() {}
  
  public mobile_adv_report_req(Map<Integer, String> paramMap1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, s_anti_cheat params_anti_cheat, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, long paramLong3, boolean paramBoolean3, boolean paramBoolean4, long paramLong4, boolean paramBoolean5, String paramString3, Map<Integer, String> paramMap2, long paramLong5, boolean paramBoolean6)
  {
    this.cookie = paramMap1;
    this.report_posi = paramInt1;
    this.write_return_code = paramInt2;
    this.client_time = paramLong1;
    this.feed_index = paramLong2;
    this.anti_cheat = params_anti_cheat;
    this.action_type = paramInt3;
    this.action_expectation = paramInt4;
    this.is_impression = paramBoolean1;
    this.is_installed = paramBoolean2;
    this.antispam_info = paramString1;
    this.video_playinfo = paramString2;
    this.stay_time = paramLong3;
    this.is_repeated = paramBoolean3;
    this.is_trace = paramBoolean4;
    this.cost_time = paramLong4;
    this.is_filter = paramBoolean5;
    this.feeds_click_attachinfo = paramString3;
    this.busi_param = paramMap2;
    this.error_code = paramLong5;
    this.is_report_gdt = paramBoolean6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cookie = ((Map)paramJceInputStream.read(cache_cookie, 0, false));
    this.report_posi = paramJceInputStream.read(this.report_posi, 1, false);
    this.write_return_code = paramJceInputStream.read(this.write_return_code, 2, false);
    this.client_time = paramJceInputStream.read(this.client_time, 3, false);
    this.feed_index = paramJceInputStream.read(this.feed_index, 4, false);
    this.anti_cheat = ((s_anti_cheat)paramJceInputStream.read(cache_anti_cheat, 5, false));
    this.action_type = paramJceInputStream.read(this.action_type, 6, false);
    this.action_expectation = paramJceInputStream.read(this.action_expectation, 7, false);
    this.is_impression = paramJceInputStream.read(this.is_impression, 8, false);
    this.is_installed = paramJceInputStream.read(this.is_installed, 9, false);
    this.antispam_info = paramJceInputStream.readString(10, false);
    this.video_playinfo = paramJceInputStream.readString(11, false);
    this.stay_time = paramJceInputStream.read(this.stay_time, 12, false);
    this.is_repeated = paramJceInputStream.read(this.is_repeated, 13, false);
    this.is_trace = paramJceInputStream.read(this.is_trace, 14, false);
    this.cost_time = paramJceInputStream.read(this.cost_time, 15, false);
    this.is_filter = paramJceInputStream.read(this.is_filter, 16, false);
    this.feeds_click_attachinfo = paramJceInputStream.readString(17, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 18, false));
    this.error_code = paramJceInputStream.read(this.error_code, 19, false);
    this.is_report_gdt = paramJceInputStream.read(this.is_report_gdt, 20, false);
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
    paramJceOutputStream.write(this.is_impression, 8);
    paramJceOutputStream.write(this.is_installed, 9);
    if (this.antispam_info != null) {
      paramJceOutputStream.write(this.antispam_info, 10);
    }
    if (this.video_playinfo != null) {
      paramJceOutputStream.write(this.video_playinfo, 11);
    }
    paramJceOutputStream.write(this.stay_time, 12);
    paramJceOutputStream.write(this.is_repeated, 13);
    paramJceOutputStream.write(this.is_trace, 14);
    paramJceOutputStream.write(this.cost_time, 15);
    paramJceOutputStream.write(this.is_filter, 16);
    if (this.feeds_click_attachinfo != null) {
      paramJceOutputStream.write(this.feeds_click_attachinfo, 17);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 18);
    }
    paramJceOutputStream.write(this.error_code, 19);
    paramJceOutputStream.write(this.is_report_gdt, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ADV_REPORT.mobile_adv_report_req
 * JD-Core Version:    0.7.0.1
 */