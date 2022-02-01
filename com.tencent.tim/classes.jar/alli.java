import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import java.io.File;

public class alli
{
  public static boolean a(int paramInt, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramInt == 11022003) && (paramVideoPlayParam.mIsLocal) && (!TextUtils.isEmpty(paramVideoPlayParam.mVideoPath)))
    {
      Object localObject = (aeiq.a)aeif.a().o(537);
      if ((localObject != null) && (((aeiq.a)localObject).bUh)) {
        try
        {
          localObject = new File(paramVideoPlayParam.mVideoPath);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("VideoPlatformUtils", 0, "autoDelBadCache, delete file , path = " + paramVideoPlayParam.mVideoPath);
            }
            return true;
          }
        }
        catch (Exception paramVideoPlayParam)
        {
          QLog.e("VideoPlatformUtils", 1, "autoDelBadCache error.", paramVideoPlayParam);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alli
 * JD-Core Version:    0.7.0.1
 */