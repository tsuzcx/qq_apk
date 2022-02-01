import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class usi
{
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setPushId(uxx.a().a()).setFlush(true);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
  
  public static void a(usg paramusg)
  {
    if (paramusg == null) {
      return;
    }
    HashMap localHashMap = new HashMap(35);
    localHashMap.put("player_type", String.valueOf(paramusg.jdField_a_of_type_Int));
    localHashMap.put("video_play_scene", paramusg.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_id", paramusg.jdField_b_of_type_JavaLangString);
    localHashMap.put("video_format", paramusg.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_file_size", String.valueOf(paramusg.jdField_a_of_type_Long));
    localHashMap.put("video_bit_rate", String.valueOf(paramusg.jdField_b_of_type_Long));
    String str;
    if (paramusg.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("is_hit_cache", str);
      if (!paramusg.jdField_b_of_type_Boolean) {
        break label513;
      }
      str = "1";
      label132:
      localHashMap.put("is_pre_download_hit", str);
      localHashMap.put("preload_status", String.valueOf(paramusg.jdField_d_of_type_Int));
      localHashMap.put("second_buffer_time", String.valueOf(paramusg.jdField_c_of_type_Long));
      localHashMap.put("second_buffer_count", String.valueOf(paramusg.jdField_e_of_type_Int));
      localHashMap.put("list_speed_kbs", paramusg.jdField_d_of_type_JavaLangString);
      localHashMap.put("max_speed_kbs", String.valueOf(paramusg.jdField_d_of_type_Long));
      localHashMap.put("min_speed_kbs", String.valueOf(paramusg.jdField_e_of_type_Long));
      localHashMap.put("average_speed_kbs", String.valueOf(paramusg.jdField_f_of_type_Long));
      localHashMap.put("downloaded_duration", String.valueOf(paramusg.jdField_g_of_type_Long));
      localHashMap.put("play_time", String.valueOf(paramusg.jdField_h_of_type_Long));
      localHashMap.put("http_dns_time", String.valueOf(paramusg.jdField_i_of_type_Long));
      localHashMap.put("http_redirect_time", String.valueOf(paramusg.j));
      localHashMap.put("http_first_receive_time", String.valueOf(paramusg.k));
      localHashMap.put("http_connect_time", String.valueOf(paramusg.l));
      localHashMap.put("mp4_header_time", String.valueOf(paramusg.m));
      localHashMap.put("cache_frame_time", String.valueOf(paramusg.n));
      localHashMap.put("video_prepare_time", String.valueOf(paramusg.o));
      localHashMap.put("http_connect_quality_json", paramusg.jdField_i_of_type_JavaLangString);
      localHashMap.put("prepare_performance_json", paramusg.jdField_e_of_type_JavaLangString);
      localHashMap.put("skip_frames_total_count", String.valueOf(paramusg.jdField_f_of_type_Int));
      localHashMap.put("error_code", paramusg.jdField_f_of_type_JavaLangString);
      localHashMap.put("error_detail_info", paramusg.jdField_g_of_type_JavaLangString);
      localHashMap.put("hw_codec_error_code", paramusg.jdField_h_of_type_JavaLangString);
      if (!paramusg.jdField_c_of_type_Boolean) {
        break label519;
      }
    }
    label513:
    label519:
    for (paramusg = "1";; paramusg = "0")
    {
      localHashMap.put("is_change_hw_backup", paramusg);
      a(a().addParams(localHashMap));
      return;
      str = "0";
      break;
      str = "0";
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usi
 * JD-Core Version:    0.7.0.1
 */