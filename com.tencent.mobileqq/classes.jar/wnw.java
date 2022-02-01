import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class wnw
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
  
  public static wly a(@NonNull List<wly> paramList1, @NonNull List<wly> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    wly localwly = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localwly;
    if (localIterator.hasNext())
    {
      localwly = (wly)localIterator.next();
      if (a(localwly)) {
        paramList2.add(localwly);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localwly.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localwly;
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
  
  public static boolean a(wly paramwly)
  {
    return (paramwly.jdField_a_of_type_Int == 5) || (paramwly.jdField_a_of_type_Int == 6) || (paramwly.jdField_a_of_type_Int == 7) || (paramwly.jdField_a_of_type_Int == 8) || (paramwly.jdField_a_of_type_Int == 9) || (paramwly.jdField_a_of_type_Int == 12) || (paramwly.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */