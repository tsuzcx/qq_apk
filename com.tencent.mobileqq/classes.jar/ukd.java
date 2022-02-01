import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class ukd
{
  public static int a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_Int = 20191226;
    jdField_a_of_type_JavaLangString = String.valueOf(jdField_a_of_type_Int);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOWN ";
    case 0: 
      return " PLAY_STATE_IDLE ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    }
    return " PLAY_STATE_ERROR ";
  }
  
  public static String a(String paramString)
  {
    return bisz.a(paramString);
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static ukf a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int j = 0;
    ukf localukf = new ukf();
    Object localObject = paramstSimpleMetaFeed.video;
    localukf.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localukf.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localukf.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    int i;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localukf.jdField_c_of_type_Int = i;
      if (localObject == null) {
        break label202;
      }
      i = paramstSimpleMetaFeed.video.width;
      label70:
      localukf.jdField_a_of_type_Int = i;
      if (localObject == null) {
        break label207;
      }
      i = paramstSimpleMetaFeed.video.height;
      label88:
      localukf.jdField_b_of_type_Int = i;
      localukf.jdField_c_of_type_JavaLangString = ups.b(paramstSimpleMetaFeed, false);
      localukf.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
      localukf.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label212;
      }
    }
    label202:
    label207:
    label212:
    for (localObject = paramstSimpleMetaFeed.poster.id;; localObject = "")
    {
      localukf.jdField_e_of_type_JavaLangString = ((String)localObject);
      localukf.jdField_f_of_type_JavaLangString = paramstSimpleMetaFeed.traceId;
      localukf.g = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      i = j;
      if (paramstSimpleMetaFeed.opVideo != null) {
        i = paramstSimpleMetaFeed.opVideo.videoType;
      }
      localukf.jdField_f_of_type_Int = i;
      return localukf;
      i = 0;
      break;
      i = 0;
      break label70;
      i = 0;
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */