import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;

public class ncg
{
  public static final String alf = acbn.bnu;
  
  public static boolean Fh()
  {
    return aqgz.aCH();
  }
  
  public static int U(int paramInt1, int paramInt2)
  {
    int i = 480;
    int n = Math.min(paramInt1, paramInt2);
    int j = Math.abs(n - 480);
    int k = Math.abs(n - 640);
    int m = Math.abs(n - 720);
    n = Math.abs(n - 1080);
    int i1 = Math.min(Math.min(j, k), Math.min(m, n));
    if (i1 == j) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "calculateTargetVideoResolution(): width:" + paramInt1 + ", height:" + paramInt2 + " => resolution:" + i);
      }
      return i;
      if (i1 == k) {
        i = 640;
      } else if (i1 == m) {
        i = 720;
      } else if (i1 == n) {
        i = 1080;
      }
    }
  }
  
  @TargetApi(9)
  public static String X(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = arwu.toMD5(paramString1 + System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder(kD());
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "getVideoCompressedPath: sourcePath=" + paramString1 + "\n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean a(nch paramnch)
  {
    if (paramnch == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return false;
          if (ae(paramnch.width, paramnch.height))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoConvertUtils", 2, "needCompress(): true! isExceedResolutionLimit");
            }
            return true;
          }
          if ((paramnch.fileSize >= qp()) && (paramnch.fileSize <= qq())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoConvertUtils", 2, "needCompress(): false! fileSize not match, size=" + paramnch.fileSize);
        return false;
        if (Fh()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoConvertUtils", 2, "needCompress(): false! not High Profile Device");
      return false;
      l = e(paramnch.width, paramnch.height);
      if ((l > 0L) && (paramnch.bitrate > 3L * l))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoConvertUtils", 2, "needCompress(): true! sourceBitRate:" + paramnch.bitrate + ", targetBitRate:" + l);
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoConvertUtils", 2, "needCompress(): false, bitrate not match, sourceBitRate:" + paramnch.bitrate + ", targetBitRate:" + l);
    return false;
  }
  
  public static boolean ae(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 > 3110400.0F;
  }
  
  public static int dy(int paramInt)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig == null) {
      return 2048;
    }
    switch (paramInt)
    {
    default: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    case 480: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_480p", 1024);
    case 640: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_640p", 1536);
    case 720: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    }
    return localAladdinConfig.getIntegerFromString("compress_bitrate_1080p", 4096);
  }
  
  public static long e(int paramInt1, int paramInt2)
  {
    return dy(U(paramInt1, paramInt2)) * 1024;
  }
  
  public static String kD()
  {
    StringBuilder localStringBuilder = new StringBuilder(alf);
    localStringBuilder.append("convert");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String kE()
  {
    long l = qq();
    if (l < 1073741824L) {
      return l / 1048576L + "MB";
    }
    if (l % 1073741824L == 0L) {
      return l / 1073741824L + "GB";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat(".00");
    return localDecimalFormat.format((float)l / 1.073742E+009F) + "GB";
  }
  
  public static int qp()
  {
    int i = 60;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("compress_size_lower_bound", 60);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeLowerBound(), value = ", Integer.valueOf(i) });
    }
    return i * 1048576;
  }
  
  public static int qq()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    int i = 60;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("compress_size_upper_bound", 1024);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeUpperBound(), value = ", Integer.valueOf(i) });
    }
    return i * 1048576;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncg
 * JD-Core Version:    0.7.0.1
 */