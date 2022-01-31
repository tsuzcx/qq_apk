import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class thd
{
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static tff a(@NonNull List<tff> paramList1, @NonNull List<tff> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    tff localtff = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localtff;
    if (localIterator.hasNext())
    {
      localtff = (tff)localIterator.next();
      if (a(localtff)) {
        paramList2.add(localtff);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localtff.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localtff;
    }
    label76:
    for (;;)
    {
      break;
      return paramList1;
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean a(tff paramtff)
  {
    return (paramtff.jdField_a_of_type_Int == 5) || (paramtff.jdField_a_of_type_Int == 6) || (paramtff.jdField_a_of_type_Int == 7) || (paramtff.jdField_a_of_type_Int == 8) || (paramtff.jdField_a_of_type_Int == 9) || (paramtff.jdField_a_of_type_Int == 12) || (paramtff.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thd
 * JD-Core Version:    0.7.0.1
 */