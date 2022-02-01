import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ile
{
  public static ild a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    if (AudioHelper.aCz()) {
      QLog.w("ARZimuTaskFactory", 1, "create, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new ili(paramLong, paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof ili.a))
      {
        ((ili)paramVideoAppInterface).a((ili.a)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ile
 * JD-Core Version:    0.7.0.1
 */