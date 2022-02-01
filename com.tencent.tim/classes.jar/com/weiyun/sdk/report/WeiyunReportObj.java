package com.weiyun.sdk.report;

import android.os.Build;
import android.os.Build.VERSION;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.Global.HostInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunReportObj
{
  public static final int ACTION_DOWNLOAD = 1;
  public static final int ACTION_UPLOAD = 2;
  private static final String REPORT_REFER = "weiyun";
  private static final String REPORT_TERMINAL = "Android";
  public int action;
  public String app_ver;
  public String client_ip;
  public long conn_time;
  public String device_id;
  public String dns_ip;
  public int err_code;
  public String err_msg;
  public String exception;
  public String file_id;
  public String file_md5;
  public String file_name;
  public String file_path;
  public String file_sha;
  public long file_size;
  public long file_speed;
  public int file_type;
  public boolean flash_upload;
  public int flow_id;
  public int network;
  public String platform_name;
  public int platform_ver;
  public long recv_data;
  public long recv_rsp;
  public String referer;
  public long report_time;
  public int retry_times;
  public String server_ip;
  public String server_port;
  public String terminal;
  public long total_delay;
  public long total_size;
  public long uin;
  public String url;
  
  private WeiyunReportObj() {}
  
  public WeiyunReportObj(int paramInt)
  {
    init();
    this.action = paramInt;
  }
  
  private void init()
  {
    this.terminal = ("Android_" + Global.getHostInterface().getAppName());
    this.referer = "weiyun";
    this.uin = Global.getHostInterface().getUin();
    this.report_time = (System.currentTimeMillis() / 1000L);
    this.platform_name = Build.MODEL;
    this.platform_ver = Build.VERSION.SDK_INT;
    this.device_id = Global.getDeviceId();
    this.app_ver = Global.getHostInterface().getVersionCode();
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("t_terminal", this.terminal);
    localJSONObject.put("t_network", this.network);
    localJSONObject.put("t_action", this.action);
    localJSONObject.put("t_err_code", this.err_code);
    localJSONObject.put("t_uin", this.uin);
    localJSONObject.put("t_report_time", this.report_time);
    localJSONObject.put("t_isp", 0);
    localJSONObject.put("t_province", "");
    label119:
    int i;
    if (this.dns_ip == null)
    {
      str = "";
      localJSONObject.put("t_dns_ip", str);
      if (this.client_ip != null) {
        break label721;
      }
      str = "";
      localJSONObject.put("t_client_ip", str);
      if (this.server_ip != null) {
        break label729;
      }
      str = "";
      label137:
      localJSONObject.put("t_server_ip", str);
      if (this.server_port != null) {
        break label737;
      }
      str = "";
      label155:
      localJSONObject.put("t_server_port", str);
      localJSONObject.put("t_ip_srctype", "");
      if (this.platform_name != null) {
        break label745;
      }
      str = "";
      label182:
      localJSONObject.put("t_platform_name", str);
      localJSONObject.put("t_platform_ver", this.platform_ver);
      if (this.device_id != null) {
        break label753;
      }
      str = "";
      label211:
      localJSONObject.put("t_device_id", str);
      if (this.app_ver != null) {
        break label761;
      }
      str = "";
      label229:
      localJSONObject.put("t_app_ver", str);
      localJSONObject.put("t_idc", "");
      localJSONObject.put("t_referer", this.referer);
      localJSONObject.put("t_flow_id", this.flow_id);
      localJSONObject.put("t_retry_times", this.retry_times);
      localJSONObject.put("t_batch_num", 0);
      localJSONObject.put("t_batch_id", 0L);
      localJSONObject.put("t_total_size", this.total_size);
      if (this.url != null) {
        break label769;
      }
      str = "";
      label316:
      localJSONObject.put("t_url", str);
      if (this.file_name != null) {
        break label777;
      }
      str = "";
      label334:
      localJSONObject.put("t_file_name", str);
      if (this.file_id != null) {
        break label785;
      }
      str = "";
      label352:
      localJSONObject.put("t_file_id", str);
      localJSONObject.put("t_file_size", this.file_size);
      localJSONObject.put("t_file_type", this.file_type);
      if (this.file_md5 != null) {
        break label796;
      }
      str = "";
      label392:
      localJSONObject.put("t_file_md5", str);
      if (this.file_sha != null) {
        break label804;
      }
      str = "";
      label410:
      localJSONObject.put("t_file_sha", str);
      localJSONObject.put("t_file_speed", this.file_speed);
      if (this.file_path != null) {
        break label812;
      }
      str = "";
      label439:
      localJSONObject.put("t_file_path", str);
      localJSONObject.put("t_wait_time", 0L);
      localJSONObject.put("t_prepare_time", 0L);
      localJSONObject.put("t_conn_time", this.conn_time);
      localJSONObject.put("t_send_req", 0L);
      localJSONObject.put("t_recv_rsp", this.recv_rsp);
      localJSONObject.put("t_recv_data", this.recv_data);
      localJSONObject.put("t_process_time", 0L);
      localJSONObject.put("t_conn_num", 0L);
      localJSONObject.put("t_total_delay", this.total_delay);
      localJSONObject.put("t_flag", 0);
      if (this.err_msg != null) {
        break label820;
      }
      str = "";
      label557:
      localJSONObject.put("t_err_msg", str);
      if (!this.flash_upload) {
        break label828;
      }
      i = 1;
      label575:
      localJSONObject.put("t_flash_upload", i);
      localJSONObject.put("t_flash_upnum", 0);
      localJSONObject.put("t_is_compressed", false);
      localJSONObject.put("t_compressed_size", 0L);
      localJSONObject.put("t_compressed_delay", 0L);
      localJSONObject.put("t_ctl_packet_delay", 0L);
      localJSONObject.put("t_data_packet_dalay", 0L);
      localJSONObject.put("t_ack_packet_delay", 0L);
      localJSONObject.put("t_nssel_ipset", "");
      localJSONObject.put("t_nsconn_step", 0);
      if (this.err_msg != null)
      {
        localJSONObject.put("t_extend1", this.err_msg);
        if (this.exception != null) {
          break label833;
        }
      }
    }
    label769:
    label777:
    label785:
    label796:
    label804:
    label812:
    label820:
    label828:
    label833:
    for (String str = "";; str = this.exception)
    {
      localJSONObject.put("t_extend2", str);
      return localJSONObject;
      str = this.dns_ip.replace(',', ';');
      break;
      label721:
      str = this.client_ip;
      break label119;
      label729:
      str = this.server_ip;
      break label137;
      label737:
      str = this.server_port;
      break label155;
      label745:
      str = this.platform_name;
      break label182;
      label753:
      str = this.device_id;
      break label211;
      label761:
      str = this.app_ver;
      break label229;
      str = this.url;
      break label316;
      str = this.file_name;
      break label334;
      str = this.file_id.toLowerCase();
      break label352;
      str = this.file_md5;
      break label392;
      str = this.file_sha;
      break label410;
      str = this.file_path;
      break label439;
      str = this.err_msg;
      break label557;
      i = 0;
      break label575;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.report.WeiyunReportObj
 * JD-Core Version:    0.7.0.1
 */