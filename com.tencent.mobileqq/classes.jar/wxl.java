import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class wxl
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
  
  public static wvn a(@NonNull List<wvn> paramList1, @NonNull List<wvn> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    wvn localwvn = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localwvn;
    if (localIterator.hasNext())
    {
      localwvn = (wvn)localIterator.next();
      if (a(localwvn)) {
        paramList2.add(localwvn);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localwvn.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localwvn;
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
  
  public static boolean a(wvn paramwvn)
  {
    return (paramwvn.jdField_a_of_type_Int == 5) || (paramwvn.jdField_a_of_type_Int == 6) || (paramwvn.jdField_a_of_type_Int == 7) || (paramwvn.jdField_a_of_type_Int == 8) || (paramwvn.jdField_a_of_type_Int == 9) || (paramwvn.jdField_a_of_type_Int == 12) || (paramwvn.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxl
 * JD-Core Version:    0.7.0.1
 */