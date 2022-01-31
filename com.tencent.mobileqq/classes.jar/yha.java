import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class yha
{
  private static final String jdField_a_of_type_JavaLangString = yha.class.getSimpleName();
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(32);
  public static final SimpleDateFormat a;
  public static final SimpleDateFormat b;
  public static final SimpleDateFormat c;
  public static final SimpleDateFormat d;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    c = new SimpleDateFormat("yyyyMMddHHmm");
    d = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }
  
  public static String a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    int m;
    int i2;
    try
    {
      str = BaseApplicationImpl.getContext().getString(2131721499);
      localObject2 = BaseApplicationImpl.getContext().getString(2131721500);
      localObject1 = BaseApplicationImpl.getContext().getString(2131721498);
      l2 = (l1 - paramLong) / 1000L;
      if (l2 < 60L) {
        return str;
      }
    }
    catch (Exception localException)
    {
      long l2;
      for (;;)
      {
        String str = alud.a(2131703235);
        localObject2 = "%d分钟前";
        localObject1 = "%d小时前";
        QZLog.d(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
      }
      if (l2 < 3600L) {
        return String.format((String)localObject2, new Object[] { Long.valueOf(l2 / 60L) });
      }
      if (l2 < 86400L) {
        return String.format((String)localObject1, new Object[] { Long.valueOf(l2 / 60L / 60L) });
      }
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(paramLong);
      m = ((Calendar)localObject1).get(5);
      int n = ((Calendar)localObject1).get(11);
      int i1 = ((Calendar)localObject1).get(12);
      int k = ((Calendar)localObject1).get(1);
      i2 = ((Calendar)localObject1).get(2) + 1;
      int i4 = ((Calendar)localObject1).get(6);
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(l1);
      int i3 = ((Calendar)localObject1).get(1);
      int i5 = ((Calendar)localObject1).get(6);
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
        jdField_a_of_type_JavaLangStringBuilder.delete(0, jdField_a_of_type_JavaLangStringBuilder.length());
        if (i != 1) {
          break label459;
        }
        localObject2 = jdField_a_of_type_JavaLangStringBuilder.append("昨天");
        if (n >= 10) {
          break label439;
        }
        localObject1 = "0" + n;
        label376:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(":");
        if (i1 >= 10) {
          break label449;
        }
      }
      label439:
      label449:
      for (localObject1 = "0" + i1;; localObject1 = Integer.valueOf(i1))
      {
        return localObject1;
        i = i5 - i4;
        break;
        localObject1 = Integer.valueOf(n);
        break label376;
      }
      label459:
      if (i == 2)
      {
        localObject2 = jdField_a_of_type_JavaLangStringBuilder.append("前天");
        if (n < 10)
        {
          localObject1 = "0" + n;
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(":");
          if (i1 >= 10) {
            break label567;
          }
        }
        for (localObject1 = "0" + i1;; localObject1 = Integer.valueOf(i1))
        {
          return localObject1;
          localObject1 = Integer.valueOf(n);
          break;
        }
      }
      label567:
      if (i3 != k)
      {
        localObject2 = jdField_a_of_type_JavaLangStringBuilder.append(k).append("-");
        if (i2 < 10)
        {
          localObject1 = "0" + i2;
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append("-");
          if (m >= 10) {
            break label692;
          }
        }
        for (localObject1 = "0" + m;; localObject1 = Integer.valueOf(m))
        {
          return localObject1;
          localObject1 = Integer.valueOf(i2);
          break;
        }
      }
      label692:
      localObject2 = jdField_a_of_type_JavaLangStringBuilder;
      if (i2 >= 10) {
        break label790;
      }
    }
    Object localObject1 = "0" + i2;
    Object localObject2 = ((StringBuilder)localObject2).append(localObject1).append("-");
    if (m < 10) {}
    for (localObject1 = "0" + m;; localObject1 = Integer.valueOf(m))
    {
      return localObject1;
      label790:
      localObject1 = Integer.valueOf(i2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yha
 * JD-Core Version:    0.7.0.1
 */