import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class ulb
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
    return bjty.a(paramString);
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
  
  public static uld a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int j = 0;
    uld localuld = new uld();
    Object localObject = paramstSimpleMetaFeed.video;
    localuld.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localuld.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localuld.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localuld.jdField_c_of_type_Int = i;
      if (localObject == null) {
        break label223;
      }
      i = paramstSimpleMetaFeed.video.width;
      label70:
      localuld.jdField_a_of_type_Int = i;
      if (localObject == null) {
        break label228;
      }
      i = paramstSimpleMetaFeed.video.height;
      label88:
      localuld.jdField_b_of_type_Int = i;
      localuld.jdField_c_of_type_JavaLangString = uqt.b(paramstSimpleMetaFeed, false);
      localuld.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
      localuld.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label233;
      }
      localObject = paramstSimpleMetaFeed.poster.id;
      label137:
      localuld.jdField_e_of_type_JavaLangString = ((String)localObject);
      localuld.jdField_f_of_type_JavaLangString = paramstSimpleMetaFeed.traceId;
      localuld.jdField_g_of_type_JavaLangString = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      if (paramstSimpleMetaFeed.opVideo == null) {
        break label239;
      }
    }
    label223:
    label228:
    label233:
    label239:
    for (int i = paramstSimpleMetaFeed.opVideo.videoType;; i = 0)
    {
      localuld.jdField_f_of_type_Int = i;
      i = j;
      if (paramstSimpleMetaFeed.videoTag != null) {
        i = paramstSimpleMetaFeed.videoTag.tagId;
      }
      localuld.jdField_g_of_type_Int = i;
      return localuld;
      i = 0;
      break;
      i = 0;
      break label70;
      i = 0;
      break label88;
      localObject = "";
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulb
 * JD-Core Version:    0.7.0.1
 */