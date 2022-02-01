import java.text.SimpleDateFormat;
import java.util.Calendar;

public class sdl
{
  private static StringBuilder A = new StringBuilder(32);
  public static final SimpleDateFormat DEFAULT_FORMAT;
  public static final SimpleDateFormat EXIF_DATE_FORMAT;
  public static final SimpleDateFormat SERVER_DATE_FORMAT;
  private static final String TAG = sdl.class.getSimpleName();
  public static final SimpleDateFormat v;
  
  static
  {
    DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    v = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SERVER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }
  
  public static String aN(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = (l1 - paramLong) / 1000L;
    if (l2 < 60L) {}
    while ((l2 < 3600L) || (l2 < 86400L)) {
      return "";
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject).get(5);
    int n = ((Calendar)localObject).get(11);
    int i1 = ((Calendar)localObject).get(12);
    int k = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2) + 1;
    int i4 = ((Calendar)localObject).get(6);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l1);
    int i3 = ((Calendar)localObject).get(1);
    int i5 = ((Calendar)localObject).get(6);
    int i;
    if (i3 != k)
    {
      i = 0;
      int j = k;
      if (j < i3)
      {
        if (((j % 4 == 0) && (j % 100 != 0)) || (j % 400 == 0)) {
          i += 366;
        }
        for (;;)
        {
          j += 1;
          break;
          i += 365;
        }
      }
      i += i5 - i4;
      A.delete(0, A.length());
      if (i != 1) {
        break label348;
      }
      localStringBuilder = A.append("昨天");
      if (n >= 10) {
        break label328;
      }
      localObject = "0" + n;
      label265:
      localStringBuilder = localStringBuilder.append(localObject).append(":");
      if (i1 >= 10) {
        break label338;
      }
    }
    label328:
    label338:
    for (localObject = "0" + i1;; localObject = Integer.valueOf(i1))
    {
      return localObject;
      i = i5 - i4;
      break;
      localObject = Integer.valueOf(n);
      break label265;
    }
    label348:
    if (i == 2)
    {
      localStringBuilder = A.append("前天");
      if (n < 10)
      {
        localObject = "0" + n;
        localStringBuilder = localStringBuilder.append(localObject).append(":");
        if (i1 >= 10) {
          break label456;
        }
      }
      for (localObject = "0" + i1;; localObject = Integer.valueOf(i1))
      {
        return localObject;
        localObject = Integer.valueOf(n);
        break;
      }
    }
    label456:
    if (i3 != k)
    {
      localStringBuilder = A.append(k).append("-");
      if (i2 < 10)
      {
        localObject = "0" + i2;
        localStringBuilder = localStringBuilder.append(localObject).append("-");
        if (m >= 10) {
          break label581;
        }
      }
      for (localObject = "0" + m;; localObject = Integer.valueOf(m))
      {
        return localObject;
        localObject = Integer.valueOf(i2);
        break;
      }
    }
    label581:
    StringBuilder localStringBuilder = A;
    if (i2 < 10)
    {
      localObject = "0" + i2;
      localStringBuilder = localStringBuilder.append(localObject).append("-");
      if (m >= 10) {
        break label689;
      }
    }
    label689:
    for (localObject = "0" + m;; localObject = Integer.valueOf(m))
    {
      return localObject;
      localObject = Integer.valueOf(i2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdl
 * JD-Core Version:    0.7.0.1
 */