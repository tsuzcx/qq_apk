import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class vzb
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
  
  public static vxd a(@NonNull List<vxd> paramList1, @NonNull List<vxd> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    vxd localvxd = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localvxd;
    if (localIterator.hasNext())
    {
      localvxd = (vxd)localIterator.next();
      if (a(localvxd)) {
        paramList2.add(localvxd);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localvxd.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localvxd;
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
  
  public static boolean a(vxd paramvxd)
  {
    return (paramvxd.jdField_a_of_type_Int == 5) || (paramvxd.jdField_a_of_type_Int == 6) || (paramvxd.jdField_a_of_type_Int == 7) || (paramvxd.jdField_a_of_type_Int == 8) || (paramvxd.jdField_a_of_type_Int == 9) || (paramvxd.jdField_a_of_type_Int == 12) || (paramvxd.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzb
 * JD-Core Version:    0.7.0.1
 */