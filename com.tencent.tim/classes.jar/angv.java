import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class angv
{
  public static angv.a a(angv.c paramc, angv.b paramb, boolean paramBoolean)
  {
    angv.a locala = new angv.a();
    int i;
    if (paramc.fps > 0)
    {
      i = paramc.fps;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      locala.scaleRate = 1.0F;
      locala.dFA = paramc.width;
      locala.dFB = paramc.height;
      locala.alb = i;
      if ((paramc.fileSize <= 0L) || (paramc.fileSize * 8L >= paramb.maxSize)) {
        break label169;
      }
      locala.ala = paramc.ale;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + locala.ala);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return locala;
      i = 30;
      break;
      locala.ala = ((int)(paramb.maxSize / paramc.duration));
      break label124;
      double d2;
      double d1;
      if (paramc.width <= paramc.height)
      {
        i = paramc.height;
        if (i <= paramb.maxLength) {
          break label692;
        }
        locala.scaleRate = (paramb.maxLength / i);
        locala.dFA = ((int)(paramc.width * locala.scaleRate));
        locala.dFB = ((int)(paramc.height * locala.scaleRate));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + locala.scaleRate + ", compressInfo.desWidth = " + locala.dFA + ", compressInfo.desHeight = " + locala.dFB);
        }
        if ((paramc.fps <= 0) || (paramc.fps >= paramb.dFC)) {
          break label719;
        }
        locala.alb = paramc.fps;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + locala.alb);
        }
        d2 = locala.dFA * locala.dFB * locala.alb * paramb.cU;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramc.ale) {
          d1 = paramc.ale;
        }
        d2 = d1;
        if (d1 > paramb.ald) {
          d2 = paramb.ald;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramc.duration * d2 <= paramb.maxSize) {
          break label732;
        }
        d2 = paramb.maxSize / (locala.dFA * locala.dFB * locala.alb * paramc.duration);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramb.cV) {
          d1 = paramb.cV;
        }
      }
      for (locala.ala = ((int)(d1 * (locala.dFA * locala.dFB * locala.alb)));; locala.ala = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + locala.ala);
        return locala;
        i = paramc.width;
        break;
        locala.scaleRate = 1.0F;
        locala.dFA = paramc.width;
        locala.dFB = paramc.height;
        break label263;
        locala.alb = paramb.dFC;
        break label352;
      }
    }
  }
  
  public static angv.b a(QQAppInterface paramQQAppInterface)
  {
    angv.b localb = new angv.b();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localb;
      paramQQAppInterface = aqmj.ah(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getManageConfig, compressConfig = " + paramQQAppInterface);
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length < 5)) {}
      }
      try
      {
        int i = Integer.valueOf(paramQQAppInterface[0]).intValue();
        if (i > 0) {
          localb.maxLength = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localb.dFC = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localb.cU = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localb.cV = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localb.maxSize = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localb.ald = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localb.alc = l;
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressConfig", 2, "getCompressConfigNew -> get VideoCompressConfig Erro", paramQQAppInterface);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localb.maxLength + ", maxFPS = " + localb.dFC + ", maxDensity = " + localb.cU + ", minDensity = " + localb.cV + ", maxSize = " + localb.maxSize + ", maxBitRate = " + localb.ald + ", minBitRate = " + localb.alc);
    return localb;
  }
  
  public static angv.c a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, videoPath is empty.");
      paramString = null;
      return paramString;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, file not exists.");
      return null;
    }
    angv.c localc = new angv.c();
    localc.fileSize = ((File)localObject).length();
    if (Build.VERSION.SDK_INT >= 17) {
      localObject = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        paramString = ((MediaMetadataRetriever)localObject).extractMetadata(18);
        String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
        String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(24);
        String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(9);
        String str4 = ((MediaMetadataRetriever)localObject).extractMetadata(32);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getVideoInfo by MediaMetadataRetriever, width = " + paramString + ", height = " + str1 + ", rotation = " + str2 + ", duration = " + str3 + ", frameCount = " + str4);
        }
        localc.width = Integer.valueOf(paramString).intValue();
        localc.height = Integer.valueOf(str1).intValue();
        localc.rotation = Integer.valueOf(str2).intValue();
        localc.duration = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localc.fps = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localc.duration + 0.5D));
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoProperty:", paramString);
        ((MediaMetadataRetriever)localObject).release();
        continue;
      }
      finally
      {
        ((MediaMetadataRetriever)localObject).release();
      }
      if (localc.duration > 0) {
        localc.ale = (localc.fileSize * 8L / localc.duration);
      }
      paramString = localc;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localc.fileSize + ", width = " + localc.width + ", height = " + localc.height + ", rotation = " + localc.rotation + ", duration = " + localc.duration + ", fps = " + localc.fps + ", videoInfo.bitRate = " + localc.ale);
      return localc;
      try
      {
        paramString = ShortVideoTrimmer.getRealProperties(paramString);
        if (paramString != null)
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            localObject = new int[paramString.length];
            int i = 0;
            while (i < paramString.length)
            {
              localObject[i] = Integer.valueOf(paramString[i]).intValue();
              i += 1;
            }
            localc.width = localObject[1];
            localc.height = localObject[2];
            localc.rotation = Integer.valueOf(ShortVideoTrimmer.fm(localObject[3])).intValue();
            localc.duration = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(angv.c paramc, angv.b paramb)
  {
    if ((paramc == null) || (paramb == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramc.fileSize * 8L > paramb.maxSize)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramc.fileSize);
      }
      return true;
    }
    if (paramc.ale < paramb.alc)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramc.ale + ", minBitRate = " + paramb.alc);
      }
      return false;
    }
    if (paramc.ale > paramb.ald)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramc.ale + ", maxBitRate = " + paramb.ald);
      }
      return true;
    }
    if (paramc.fps > 0) {}
    for (int i = paramc.fps;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramc.ale <= paramc.width * paramc.height * i * paramb.cU * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramc.ale + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramc.width * paramc.height) * paramb.cU * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramc.ale + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramc.width * paramc.height) * paramb.cU * 1.2D);
    }
    return false;
  }
  
  public static class a
  {
    public long ala;
    public long alb;
    public int dFA;
    public int dFB;
    public float scaleRate;
  }
  
  public static class b
  {
    long alc = 1048576L;
    long ald = 4194304L;
    double cU = 0.15D;
    double cV = 0.067D;
    int dFC = 30;
    int maxLength = 1280;
    long maxSize = 754974720L;
  }
  
  public static class c
  {
    public long ale;
    public int duration;
    public long fileSize;
    public int fps;
    public int height;
    public int rotation;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angv
 * JD-Core Version:    0.7.0.1
 */