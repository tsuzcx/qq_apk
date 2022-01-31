import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class vae
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
  
  public static uyg a(@NonNull List<uyg> paramList1, @NonNull List<uyg> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    uyg localuyg = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localuyg;
    if (localIterator.hasNext())
    {
      localuyg = (uyg)localIterator.next();
      if (a(localuyg)) {
        paramList2.add(localuyg);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localuyg.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
      paramList1 = localuyg;
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
  
  public static boolean a(uyg paramuyg)
  {
    return (paramuyg.jdField_a_of_type_Int == 5) || (paramuyg.jdField_a_of_type_Int == 6) || (paramuyg.jdField_a_of_type_Int == 7) || (paramuyg.jdField_a_of_type_Int == 8) || (paramuyg.jdField_a_of_type_Int == 9) || (paramuyg.jdField_a_of_type_Int == 12) || (paramuyg.jdField_a_of_type_Int == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vae
 * JD-Core Version:    0.7.0.1
 */