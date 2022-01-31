import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

class xtv
{
  static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(paramContext) + str;
    }
  }
  
  static String b(Context paramContext)
  {
    paramContext = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str = VideoEnvironment.a();
    return paramContext + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */