import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class urv
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
    return bhzn.a(paramString);
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
  
  public static urx a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int j = 0;
    urx localurx = new urx();
    Object localObject = paramstSimpleMetaFeed.video;
    localurx.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localurx.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localurx.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localurx.jdField_c_of_type_Int = i;
      if (localObject == null) {
        break label223;
      }
      i = paramstSimpleMetaFeed.video.width;
      label70:
      localurx.jdField_a_of_type_Int = i;
      if (localObject == null) {
        break label228;
      }
      i = paramstSimpleMetaFeed.video.height;
      label88:
      localurx.jdField_b_of_type_Int = i;
      localurx.jdField_c_of_type_JavaLangString = uyo.b(paramstSimpleMetaFeed, false);
      localurx.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
      localurx.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label233;
      }
      localObject = paramstSimpleMetaFeed.poster.id;
      label137:
      localurx.jdField_e_of_type_JavaLangString = ((String)localObject);
      localurx.jdField_f_of_type_JavaLangString = paramstSimpleMetaFeed.traceId;
      localurx.jdField_g_of_type_JavaLangString = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
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
      localurx.jdField_f_of_type_Int = i;
      i = j;
      if (paramstSimpleMetaFeed.videoTag != null) {
        i = paramstSimpleMetaFeed.videoTag.tagId;
      }
      localurx.jdField_g_of_type_Int = i;
      return localurx;
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
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */