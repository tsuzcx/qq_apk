package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class rtmp_report_basic_info_req
  extends JceStruct
{
  static ArrayList<rtmp_report_basic_info> cache_basic_infos;
  static rtmp_report_comm_info cache_comm_info = new rtmp_report_comm_info();
  static Map<String, String> cache_ext_info;
  public ArrayList<rtmp_report_basic_info> basic_infos;
  public rtmp_report_comm_info comm_info;
  public Map<String, String> ext_info;
  
  static
  {
    cache_basic_infos = new ArrayList();
    rtmp_report_basic_info localrtmp_report_basic_info = new rtmp_report_basic_info();
    cache_basic_infos.add(localrtmp_report_basic_info);
    cache_ext_info = new HashMap();
    cache_ext_info.put("", "");
  }
  
  public rtmp_report_basic_info_req() {}
  
  public rtmp_report_basic_info_req(rtmp_report_comm_info paramrtmp_report_comm_info, ArrayList<rtmp_report_basic_info> paramArrayList, Map<String, String> paramMap)
  {
    this.comm_info = paramrtmp_report_comm_info;
    this.basic_infos = paramArrayList;
    this.ext_info = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.comm_info = ((rtmp_report_comm_info)paramJceInputStream.read(cache_comm_info, 0, false));
    this.basic_infos = ((ArrayList)paramJceInputStream.read(cache_basic_infos, 1, false));
    this.ext_info = ((Map)paramJceInputStream.read(cache_ext_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.comm_info != null) {
      paramJceOutputStream.write(this.comm_info, 0);
    }
    if (this.basic_infos != null) {
      paramJceOutputStream.write(this.basic_infos, 1);
    }
    if (this.ext_info != null) {
      paramJceOutputStream.write(this.ext_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.rtmp_report_basic_info_req
 * JD-Core Version:    0.7.0.1
 */