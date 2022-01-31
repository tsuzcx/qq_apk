import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class thg
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
  
  public static tfi a(@NonNull List<tfi> paramList1, @NonNull List<tfi> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    tfi localtfi = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localtfi;
    if (localIterator.hasNext())
    {
      localtfi = (tfi)localIterator.next();
      if (a(localtfi)) {
        paramList2.add(localtfi);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localtfi.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localtfi;
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
  
  public static boolean a(tfi paramtfi)
  {
    return (paramtfi.jdField_a_of_type_Int == 5) || (paramtfi.jdField_a_of_type_Int == 6) || (paramtfi.jdField_a_of_type_Int == 7) || (paramtfi.jdField_a_of_type_Int == 8) || (paramtfi.jdField_a_of_type_Int == 9) || (paramtfi.jdField_a_of_type_Int == 12) || (paramtfi.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thg
 * JD-Core Version:    0.7.0.1
 */