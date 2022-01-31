import android.text.TextUtils;
import java.util.List;

public class zbe
{
  private static zbf jdField_a_of_type_Zbf = new zbf();
  private zaz jdField_a_of_type_Zaz = new zay();
  private zaz b = new zbh();
  
  public static zbe a()
  {
    return (zbe)jdField_a_of_type_Zbf.getInstance();
  }
  
  public atwl a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Zaz.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public atwn a(atwl paramatwl, long paramLong)
  {
    Object localObject;
    if (paramatwl == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramatwl.a();
    if (localList == null) {
      return null;
    }
    int j = localList.size();
    if (j < 1) {
      return null;
    }
    int i = 0;
    label43:
    if (i < j - 1)
    {
      paramatwl = (atwn)localList.get(i);
      localObject = (atwn)localList.get(i + 1);
      if ((paramLong < paramatwl.a) || (((atwn)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramatwl;
      if (paramatwl != null) {
        break;
      }
      return (atwn)localList.get(j - 1);
      i += 1;
      break label43;
      paramatwl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbe
 * JD-Core Version:    0.7.0.1
 */