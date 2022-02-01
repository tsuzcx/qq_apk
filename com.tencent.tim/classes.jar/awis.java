import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class awis
{
  public static void Y(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4).edit();
    paramQQAppInterface.putInt("hot_shortvideo_multi_video_support_799", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void j(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4).edit().putInt("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION" + paramQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public static int t(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4).getInt("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awis
 * JD-Core Version:    0.7.0.1
 */