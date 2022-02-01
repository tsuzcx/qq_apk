package cooperation.qzone.video;

import android.content.Intent;

public class QzoneVerticalVideoConst
{
  public static final int BUSINESS_TYPE_AIO = 7;
  public static final int BUSINESS_TYPE_PASS_FEED = 6;
  public static final int BUSINESS_TYPE_QQ_PROFILE_CARD = 3;
  public static final int BUSINESS_TYPE_QQ_SETTING = 4;
  public static final int BUSINESS_TYPE_QZONE_BANNER = 1;
  public static final int BUSINESS_TYPE_QZONE_PERSONAL_PAGE = 2;
  public static final int BUSINESS_TYPE_VIDEO_STORY_AGGREGATE = 5;
  public static final int BUSINESS_TYPE_VIDEO_STORY_PUSH = 8;
  public static final int DEFAULT_REQUEST_FROM_FEEDS = 0;
  public static final int DEFAULT_REQUEST_FROM_RECENT_VIDEO = 1;
  public static final String KEY_REQUEST_BUSINESS_TYPE = "key_request_business_type";
  public static final String KEY_REQUEST_FROM = "key_request_from";
  public static final String KEY_REQUEST_SUB_BUSINESS_TYPE = "key_request_sub_business_type";
  public static final String KEY_SCHEME_REQUEST_FROM_BUSINESS_TYPE = "key_scheme_request_from_business_type";
  public static final String KEY_WEISHI_PUSH_MSG_DATA = "key_weishi_push_msg_data";
  public static final int REQUEST_FROM_FRIEND_VIDEO_STORY = 2;
  public static final int REQUEST_FROM_MINI_APP_CONTAINER = 6;
  public static final int REQUEST_FROM_PERSONAL_VIDEO_STORY_AGGREGATE = 4;
  public static final int REQUEST_FROM_PERSONAL_VIDEO_STORY_FLOW = 3;
  public static final int REQUEST_FROM_WEISHI = 5;
  public static final String WEISHI_KEY_SCENE_TYPE = "key_weishi_scene_type";
  public static final int WEISHI_SCENE_PUBLIC_ACCOUNT = 2;
  public static final int WEISHI_SCENE_TRENDS_TAB = 6;
  
  public static boolean isRequestVideoStoryBusiness(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.hasExtra("key_request_business_type"))
      {
        int i = paramIntent.getIntExtra("key_request_business_type", 0);
        if ((i >= 1) && (i <= 7)) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  public static boolean isRequestVideoWeishiPublicAccount(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramIntent.hasExtra("key_request_from"))
      {
        int i = paramIntent.getIntExtra("key_request_from", 0);
        bool1 = bool2;
        if (i == 5) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramIntent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoConst
 * JD-Core Version:    0.7.0.1
 */