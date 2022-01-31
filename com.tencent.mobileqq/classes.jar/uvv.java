import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class uvv
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
  
  public static utx a(@NonNull List<utx> paramList1, @NonNull List<utx> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    utx localutx = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localutx;
    if (localIterator.hasNext())
    {
      localutx = (utx)localIterator.next();
      if (a(localutx)) {
        paramList2.add(localutx);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localutx.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localutx;
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
  
  public static boolean a(utx paramutx)
  {
    return (paramutx.jdField_a_of_type_Int == 5) || (paramutx.jdField_a_of_type_Int == 6) || (paramutx.jdField_a_of_type_Int == 7) || (paramutx.jdField_a_of_type_Int == 8) || (paramutx.jdField_a_of_type_Int == 9) || (paramutx.jdField_a_of_type_Int == 12) || (paramutx.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvv
 * JD-Core Version:    0.7.0.1
 */