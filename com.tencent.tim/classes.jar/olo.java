import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class olo
{
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setPushId(oox.a().getPushId()).setFlush(true);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
  
  public static void b(olm paramolm)
  {
    if (paramolm == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_play_scene", paramolm.aqb);
    localHashMap.put("video_id", paramolm.yc);
    localHashMap.put("video_format", paramolm.aqk);
    localHashMap.put("video_file_size", String.valueOf(paramolm.yT));
    localHashMap.put("video_bit_rate", String.valueOf(paramolm.vF));
    String str;
    if (paramolm.axH)
    {
      str = "1";
      localHashMap.put("is_hit_cache", str);
      localHashMap.put("second_buffer_time", String.valueOf(paramolm.xf));
      localHashMap.put("second_buffer_count", String.valueOf(paramolm.aVX));
      localHashMap.put("list_speed_kbs", paramolm.aqp);
      localHashMap.put("max_speed_kbs", String.valueOf(paramolm.yU));
      localHashMap.put("min_speed_kbs", String.valueOf(paramolm.yV));
      localHashMap.put("average_speed_kbs", String.valueOf(paramolm.yW));
      localHashMap.put("downloaded_duration", String.valueOf(paramolm.vH));
      localHashMap.put("http_dns_time", String.valueOf(paramolm.yX));
      localHashMap.put("http_redirect_time", String.valueOf(paramolm.yY));
      localHashMap.put("http_first_receive_time", String.valueOf(paramolm.yZ));
      localHashMap.put("http_connect_time", String.valueOf(paramolm.za));
      localHashMap.put("mp4_header_time", String.valueOf(paramolm.zb));
      localHashMap.put("cache_frame_time", String.valueOf(paramolm.zc));
      localHashMap.put("video_prepare_time", String.valueOf(paramolm.zd));
      localHashMap.put("http_connect_quality_json", paramolm.aqj);
      localHashMap.put("prepare_performance_json", paramolm.aqq);
      localHashMap.put("skip_frames_total_count", String.valueOf(paramolm.bfo));
      localHashMap.put("error_code", paramolm.mErrorCode);
      localHashMap.put("error_detail_info", paramolm.aqr);
      localHashMap.put("hw_codec_error_code", paramolm.aqs);
      if (!paramolm.axI) {
        break label443;
      }
    }
    label443:
    for (paramolm = "1";; paramolm = "0")
    {
      localHashMap.put("is_change_hw_backup", paramolm);
      a(a().addParams(localHashMap));
      return;
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olo
 * JD-Core Version:    0.7.0.1
 */