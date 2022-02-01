import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import dov.com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;

public class azaz
{
  private static int dHA;
  private static int dHB;
  private static int dHw;
  private static int dHx;
  private static int dHy;
  private static int dHz;
  
  public static int a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    int i = 0;
    QLog.i("GifProcessor", 1, "generateGifFromVFile vfPath=" + paramString1 + " output=" + paramString3);
    loadConfig();
    GifCoder localGifCoder = new GifCoder();
    localGifCoder.Xa(true);
    localGifCoder.acm(dHw);
    boolean bool;
    int k;
    int j;
    VideoSourceHelper localVideoSourceHelper;
    Bitmap localBitmap;
    if (dHx == 1)
    {
      bool = true;
      localGifCoder.WY(bool);
      k = aniq.dHk * 1000 / aniq.bQi / dHy;
      j = k;
      if (k <= 0) {
        j = 1;
      }
      localVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
      localVideoSourceHelper.initHelperParam();
      paramString1 = localVideoSourceHelper.getSourceVideoParam();
      localBitmap = Bitmap.createBitmap(paramString1[0], paramString1[1], Bitmap.Config.RGB_565);
      k = 0;
    }
    for (;;)
    {
      if (k < aniq.dHk)
      {
        i = localVideoSourceHelper.getVideoFrameByIndex(localBitmap, k);
        if (QLog.isColorLevel()) {
          QLog.d("GifProcessor", 2, "getVideoFrameByIndex from vffile. index=" + k + " ret=" + i);
        }
        if (i == 0) {
          break label229;
        }
      }
      for (;;)
      {
        localGifCoder.eDi();
        return i;
        bool = false;
        break;
        label229:
        paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
        paramString1 = paramString2;
        if (paramInt != 0)
        {
          paramString1 = paramString2;
          if (!ayvu.hG(paramInt)) {
            paramString1 = RecordThumbnailUtils.e(paramString2, paramInt);
          }
        }
        if (localGifCoder.a(paramString1, paramString3, dHz, true)) {
          break label280;
        }
        i = -1;
      }
      label280:
      k += j;
    }
  }
  
  private static void loadConfig()
  {
    dHw = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSize", 720);
    dHx = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSizeForLongEdge", 0);
    dHy = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFps", 5);
    dHz = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifTimePerFrame", 200);
    dHA = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifMaxFrame", 10);
    dHB = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFirstNSecond", 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azaz
 * JD-Core Version:    0.7.0.1
 */