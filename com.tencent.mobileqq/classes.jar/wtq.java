import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class wtq
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
  
  public static wrs a(@NonNull List<wrs> paramList1, @NonNull List<wrs> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    wrs localwrs = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localwrs;
    if (localIterator.hasNext())
    {
      localwrs = (wrs)localIterator.next();
      if (a(localwrs)) {
        paramList2.add(localwrs);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localwrs.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localwrs;
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
  
  public static boolean a(wrs paramwrs)
  {
    return (paramwrs.jdField_a_of_type_Int == 5) || (paramwrs.jdField_a_of_type_Int == 6) || (paramwrs.jdField_a_of_type_Int == 7) || (paramwrs.jdField_a_of_type_Int == 8) || (paramwrs.jdField_a_of_type_Int == 9) || (paramwrs.jdField_a_of_type_Int == 12) || (paramwrs.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtq
 * JD-Core Version:    0.7.0.1
 */