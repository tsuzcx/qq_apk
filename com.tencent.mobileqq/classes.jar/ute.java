import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.HashMap;
import java.util.Map;

public class ute
  extends usj<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  public int a(int paramInt)
  {
    if (paramInt == 101) {
      return 2;
    }
    return 103;
  }
  
  public TVK_PlayerVideoInfo a()
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, "");
    localTVK_PlayerVideoInfo.setPreLoad(this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_Long > 0L) {
      localTVK_PlayerVideoInfo.setConfigMap("filesize", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (this.jdField_b_of_type_Int > 0) {
      localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(this.jdField_b_of_type_Int / 1000));
    }
    if (this.c) {
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    }
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", urv.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Boolean) {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", "true");
    }
    if ((this.d) && (this.jdField_b_of_type_Boolean)) {
      localTVK_PlayerVideoInfo.setConfigMap("enable_cover_frame", "true");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_weishi_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    return localTVK_PlayerVideoInfo;
  }
  
  public TVK_UserInfo a()
  {
    return new TVK_UserInfo("", "");
  }
  
  public TVK_PlayerVideoInfo b()
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", urv.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_Int > 0) {
      localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(this.jdField_b_of_type_Int));
    }
    return localTVK_PlayerVideoInfo;
  }
  
  public TVK_UserInfo b()
  {
    return new TVK_UserInfo("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ute
 * JD-Core Version:    0.7.0.1
 */