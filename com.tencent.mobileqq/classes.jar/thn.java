import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class thn
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
  
  public static thp a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    thp localthp = new thp();
    Object localObject = paramstSimpleMetaFeed.video;
    localthp.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localthp.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localthp.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    int i;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localthp.jdField_c_of_type_Int = i;
      if (localObject == null) {
        break label163;
      }
      i = paramstSimpleMetaFeed.video.width;
      label63:
      localthp.jdField_a_of_type_Int = i;
      if (localObject == null) {
        break label168;
      }
      i = paramstSimpleMetaFeed.video.height;
      label80:
      localthp.jdField_b_of_type_Int = i;
      localthp.jdField_c_of_type_JavaLangString = tlv.b(paramstSimpleMetaFeed, false);
      localthp.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
      localthp.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label173;
      }
    }
    label163:
    label168:
    label173:
    for (localObject = paramstSimpleMetaFeed.poster.id;; localObject = "")
    {
      localthp.jdField_e_of_type_JavaLangString = ((String)localObject);
      localthp.f = paramstSimpleMetaFeed.traceId;
      localthp.g = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      return localthp;
      i = 0;
      break;
      i = 0;
      break label63;
      i = 0;
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thn
 * JD-Core Version:    0.7.0.1
 */