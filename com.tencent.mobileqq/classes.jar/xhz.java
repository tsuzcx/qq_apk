import android.text.TextUtils;
import java.util.List;

public class xhz
{
  private static xia jdField_a_of_type_Xia = new xia();
  private xhu jdField_a_of_type_Xhu = new xht();
  private xhu b = new xic();
  
  public static xhz a()
  {
    return (xhz)jdField_a_of_type_Xia.getInstance();
  }
  
  public asba a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Xhu.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public asbc a(asba paramasba, long paramLong)
  {
    Object localObject;
    if (paramasba == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramasba.a();
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
      paramasba = (asbc)localList.get(i);
      localObject = (asbc)localList.get(i + 1);
      if ((paramLong < paramasba.a) || (((asbc)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramasba;
      if (paramasba != null) {
        break;
      }
      return (asbc)localList.get(j - 1);
      i += 1;
      break label43;
      paramasba = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhz
 * JD-Core Version:    0.7.0.1
 */