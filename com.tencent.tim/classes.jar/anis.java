import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class anis
{
  private static boolean aNM;
  private static int dHA;
  private static int dHB;
  private static int dHw;
  private static int dHx;
  private static int dHy;
  private static int dHz;
  
  public static int T(String paramString1, String paramString2)
  {
    return V(paramString1, paramString2);
  }
  
  public static int U(String paramString1, String paramString2)
  {
    QLog.i("GifProcessor", 1, "getFrameFromVideoByRetriever input=" + paramString1 + " output=" + paramString2);
    loadConfig();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString1);
        long l1 = Long.valueOf(localMediaMetadataRetriever.extractMetadata(9)).longValue();
        if (l1 > dHB * 1000)
        {
          l1 = dHB * 1000;
          long l2 = 1000L / dHy;
          l3 = l1 / dHA;
          if (l2 > l3)
          {
            break label326;
            if (l3 <= l1)
            {
              long l4 = System.currentTimeMillis();
              paramString1 = localMediaMetadataRetriever.getFrameAtTime(1000L * l3, 3);
              long l5 = System.currentTimeMillis();
              if (paramString1 != null) {
                aqhu.a(paramString1.copy(Bitmap.Config.ARGB_8888, true), new File(paramString2 + File.separator + l3 + ".jpg"));
              }
              long l6 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("GifProcessor", 2, "getFrameFromVideoByRetriever currentTime=" + l3 + " duration=" + l1 + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
              }
              l3 += l2;
              continue;
            }
          }
          else
          {
            l2 = l3;
            break label326;
          }
          return 0;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("GifProcessor", 1, "getFrameFromVideoByRetriever error:", paramString1);
        return -501;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      continue;
      label326:
      long l3 = 0L;
    }
  }
  
  private static int V(String paramString1, String paramString2)
  {
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    String str1 = String.format("fps=%d", new Object[] { Integer.valueOf(dHy) });
    Object localObject1 = null;
    try
    {
      String str2 = TrimNative.getRealProperties(paramString1, dHw, dHx);
      localObject1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label108;
      }
      return -12;
      switch (Integer.valueOf(localObject1[3]).intValue())
      {
      default: 
        localObject1 = str1;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    label108:
    str1 = new File(paramString2).getParent();
    str1 = str1 + File.separator + "tempPics";
    Object localObject2 = new File(str1);
    label221:
    int i;
    long l2;
    if (((File)localObject2).exists())
    {
      if (((File)localObject2).isDirectory()) {
        aqhq.cn(str1);
      }
    }
    else
    {
      ((File)localObject2).mkdir();
      String str3 = str1 + File.separator + "%03d.jpg";
      long l1 = System.currentTimeMillis();
      i = awdv.c(new String[] { "-i", paramString1, "-vf", localObject1, "-y", str3 });
      l2 = System.currentTimeMillis();
      QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate temp pics input=" + paramString1 + " output=" + paramString2 + " cost=" + (l2 - l1) + " ret=" + i);
      if (i != 0) {
        break label652;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 != null) && (localObject2.length != 0)) {
        break label476;
      }
      i = -233;
    }
    label649:
    label652:
    for (;;)
    {
      aqhq.cn(str1);
      return i;
      localObject1 = str1 + ",transpose=1";
      break;
      localObject1 = str1 + ",vflip,hflip";
      break;
      localObject1 = str1 + ",transpose=2";
      break;
      ((File)localObject2).delete();
      break label221;
      label476:
      localObject1 = new ArrayList();
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        ((ArrayList)localObject1).add(localObject2[j].getAbsolutePath());
        j += 1;
      }
      localObject2 = new GifCoder();
      ((GifCoder)localObject2).Xa(true);
      ((GifCoder)localObject2).acm(dHw);
      boolean bool;
      if (dHx == 1)
      {
        bool = true;
        label551:
        ((GifCoder)localObject2).WY(bool);
        if (((GifCoder)localObject2).a(paramString2, (ArrayList)localObject1, dHz, true)) {
          break label649;
        }
        i = -234;
      }
      for (;;)
      {
        ((GifCoder)localObject2).eDi();
        QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate gif input=" + paramString1 + " output=" + paramString2 + " cost=" + (System.currentTimeMillis() - l2) + " ret=" + i);
        break;
        bool = false;
        break label551;
      }
    }
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    loadConfig();
    return a(paramString1, paramInt1, paramInt2, paramLong, paramString2, dHy, dHA, dHz);
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    return b(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramInt4, paramInt5);
  }
  
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
          break label231;
        }
      }
      for (;;)
      {
        localGifCoder.eDi();
        return i;
        bool = false;
        break;
        label231:
        paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
        paramString1 = paramString2;
        if (paramInt != 0)
        {
          paramString1 = paramString2;
          if (!CameraFilterGLView.hG(paramInt)) {
            paramString1 = RecordThumbnailUtils.e(paramString2, paramInt);
          }
        }
        if (localGifCoder.a(paramString1, paramString3, dHz, true)) {
          break label282;
        }
        i = -1;
      }
      label282:
      k += j;
    }
  }
  
  private static int b(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("GifProcessor", 1, "convertByFrameFatcher input=" + paramString1 + " width=" + paramInt1 + " height=" + paramInt2 + " duration=" + paramLong + " output=" + paramString2 + ", gifFps=" + paramInt3);
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    Object localObject1 = null;
    try
    {
      String str = TrimNative.getRealProperties(paramString1, dHw, dHx);
      localObject1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label164;
      }
      return -12;
      label164:
      i = Integer.valueOf(localObject1[3]).intValue();
      paramInt2 = Integer.valueOf(localObject1[1]).intValue();
      paramInt1 = Integer.valueOf(localObject1[2]).intValue();
      if (i == 1) {
        break label210;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    int i;
    if (i == 3)
    {
      label210:
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      aaut.a(paramString1, paramInt2, i, 0, 0, paramInt2, i);
      long l1;
      long l3;
      long l2;
      long l4;
      label292:
      Object localObject2;
      if (paramLong > dHB * 1000)
      {
        l1 = dHB * 1000;
        paramString1 = new GifCoder();
        paramString1.WZ(true);
        l3 = 0L;
        l2 = 1000L / paramInt3;
        l4 = l1 / paramInt4;
        if (l2 <= l4) {
          break label438;
        }
        localObject1 = new File(paramString2).getParent();
        localObject1 = (String)localObject1 + File.separator + "tempPics";
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          if (!((File)localObject2).isDirectory()) {
            break label445;
          }
          aqhq.cn((String)localObject1);
        }
        label366:
        ((File)localObject2).mkdir();
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if (l3 <= l1)
        {
          l4 = System.currentTimeMillis();
          l5 = l3 + l2;
          if (l5 < l1) {}
        }
        else
        {
          paramString1.a(paramString2, (ArrayList)localObject2, paramInt5, true);
          paramString1.eDi();
          aqhq.cn((String)localObject1);
          return 0;
          l1 = paramLong;
          break;
          label438:
          l2 = l4;
          break label292;
          label445:
          ((File)localObject2).delete();
          break label366;
        }
        Bitmap localBitmap = aaut.b(l3, l5);
        long l5 = System.currentTimeMillis();
        if (localBitmap != null) {}
        try
        {
          aqhu.a(localBitmap, new File((String)localObject1 + File.separator + l3 + ".jpg"));
          ((ArrayList)localObject2).add((String)localObject1 + File.separator + l3 + ".jpg");
          long l6 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("GifProcessor", 2, "convertByFrameFatcher currentTime=" + l3 + " duration=" + paramLong + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
          }
          l3 += l2;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      i = paramInt1;
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
  
  private static boolean loadSo()
  {
    if (aNM) {
      return true;
    }
    try
    {
      String str2 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      String str1 = VideoEnvironment.zQ();
      str2 = str2 + str1;
      File localFile = new File(str2);
      if ((str1 != null) && (localFile.exists()))
      {
        GlobalInit.loadLibraryWithFullPath(str2);
        aNM = true;
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GifProcessor", 1, "loadLibrary error", localThrowable);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anis
 * JD-Core Version:    0.7.0.1
 */