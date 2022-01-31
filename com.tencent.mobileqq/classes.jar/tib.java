import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class tib
{
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setPushId(tll.a().a()).setFlush(true);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
  
  public static void a(thz paramthz)
  {
    if (paramthz == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_play_scene", paramthz.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_id", paramthz.jdField_b_of_type_JavaLangString);
    localHashMap.put("video_format", paramthz.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_file_size", String.valueOf(paramthz.jdField_a_of_type_Long));
    localHashMap.put("video_bit_rate", String.valueOf(paramthz.jdField_b_of_type_Long));
    String str;
    if (paramthz.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("is_hit_cache", str);
      localHashMap.put("second_buffer_time", String.valueOf(paramthz.jdField_c_of_type_Long));
      localHashMap.put("second_buffer_count", String.valueOf(paramthz.jdField_c_of_type_Int));
      localHashMap.put("list_speed_kbs", paramthz.jdField_d_of_type_JavaLangString);
      localHashMap.put("max_speed_kbs", String.valueOf(paramthz.jdField_d_of_type_Long));
      localHashMap.put("min_speed_kbs", String.valueOf(paramthz.jdField_e_of_type_Long));
      localHashMap.put("average_speed_kbs", String.valueOf(paramthz.jdField_f_of_type_Long));
      localHashMap.put("downloaded_duration", String.valueOf(paramthz.jdField_g_of_type_Long));
      localHashMap.put("http_dns_time", String.valueOf(paramthz.jdField_h_of_type_Long));
      localHashMap.put("http_redirect_time", String.valueOf(paramthz.jdField_i_of_type_Long));
      localHashMap.put("http_first_receive_time", String.valueOf(paramthz.j));
      localHashMap.put("http_connect_time", String.valueOf(paramthz.k));
      localHashMap.put("mp4_header_time", String.valueOf(paramthz.l));
      localHashMap.put("cache_frame_time", String.valueOf(paramthz.m));
      localHashMap.put("video_prepare_time", String.valueOf(paramthz.n));
      localHashMap.put("http_connect_quality_json", paramthz.jdField_i_of_type_JavaLangString);
      localHashMap.put("prepare_performance_json", paramthz.jdField_e_of_type_JavaLangString);
      localHashMap.put("skip_frames_total_count", String.valueOf(paramthz.jdField_d_of_type_Int));
      localHashMap.put("error_code", paramthz.jdField_f_of_type_JavaLangString);
      localHashMap.put("error_detail_info", paramthz.jdField_g_of_type_JavaLangString);
      localHashMap.put("hw_codec_error_code", paramthz.jdField_h_of_type_JavaLangString);
      if (!paramthz.jdField_b_of_type_Boolean) {
        break label443;
      }
    }
    label443:
    for (paramthz = "1";; paramthz = "0")
    {
      localHashMap.put("is_change_hw_backup", paramthz);
      a(a().addParams(localHashMap));
      return;
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tib
 * JD-Core Version:    0.7.0.1
 */