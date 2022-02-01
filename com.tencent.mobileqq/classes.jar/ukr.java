import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class ukr
{
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setPushId(upb.a().a()).setFlush(true);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
  
  public static void a(ukp paramukp)
  {
    if (paramukp == null) {
      return;
    }
    HashMap localHashMap = new HashMap(30);
    localHashMap.put("video_play_scene", paramukp.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_id", paramukp.jdField_b_of_type_JavaLangString);
    localHashMap.put("video_format", paramukp.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_file_size", String.valueOf(paramukp.jdField_a_of_type_Long));
    localHashMap.put("video_bit_rate", String.valueOf(paramukp.jdField_b_of_type_Long));
    String str;
    if (paramukp.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("is_hit_cache", str);
      if (!paramukp.jdField_b_of_type_Boolean) {
        break label481;
      }
      str = "1";
      label116:
      localHashMap.put("is_pre_download_hit", str);
      localHashMap.put("preload_status", String.valueOf(paramukp.jdField_c_of_type_Int));
      localHashMap.put("second_buffer_time", String.valueOf(paramukp.jdField_c_of_type_Long));
      localHashMap.put("second_buffer_count", String.valueOf(paramukp.jdField_d_of_type_Int));
      localHashMap.put("list_speed_kbs", paramukp.jdField_d_of_type_JavaLangString);
      localHashMap.put("max_speed_kbs", String.valueOf(paramukp.jdField_d_of_type_Long));
      localHashMap.put("min_speed_kbs", String.valueOf(paramukp.jdField_e_of_type_Long));
      localHashMap.put("average_speed_kbs", String.valueOf(paramukp.jdField_f_of_type_Long));
      localHashMap.put("downloaded_duration", String.valueOf(paramukp.jdField_g_of_type_Long));
      localHashMap.put("http_dns_time", String.valueOf(paramukp.jdField_h_of_type_Long));
      localHashMap.put("http_redirect_time", String.valueOf(paramukp.jdField_i_of_type_Long));
      localHashMap.put("http_first_receive_time", String.valueOf(paramukp.j));
      localHashMap.put("http_connect_time", String.valueOf(paramukp.k));
      localHashMap.put("mp4_header_time", String.valueOf(paramukp.l));
      localHashMap.put("cache_frame_time", String.valueOf(paramukp.m));
      localHashMap.put("video_prepare_time", String.valueOf(paramukp.n));
      localHashMap.put("http_connect_quality_json", paramukp.jdField_i_of_type_JavaLangString);
      localHashMap.put("prepare_performance_json", paramukp.jdField_e_of_type_JavaLangString);
      localHashMap.put("skip_frames_total_count", String.valueOf(paramukp.jdField_e_of_type_Int));
      localHashMap.put("error_code", paramukp.jdField_f_of_type_JavaLangString);
      localHashMap.put("error_detail_info", paramukp.jdField_g_of_type_JavaLangString);
      localHashMap.put("hw_codec_error_code", paramukp.jdField_h_of_type_JavaLangString);
      if (!paramukp.jdField_c_of_type_Boolean) {
        break label487;
      }
    }
    label481:
    label487:
    for (paramukp = "1";; paramukp = "0")
    {
      localHashMap.put("is_change_hw_backup", paramukp);
      a(a().addParams(localHashMap));
      return;
      str = "0";
      break;
      str = "0";
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukr
 * JD-Core Version:    0.7.0.1
 */