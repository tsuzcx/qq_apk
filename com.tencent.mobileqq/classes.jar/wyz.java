import android.text.TextUtils;
import java.util.List;

public class wyz
{
  private static wza jdField_a_of_type_Wza = new wza();
  private wyu jdField_a_of_type_Wyu = new wyt();
  private wyu b = new wzc();
  
  public static wyz a()
  {
    return (wyz)jdField_a_of_type_Wza.getInstance();
  }
  
  public arey a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Wyu.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public arfa a(arey paramarey, long paramLong)
  {
    Object localObject;
    if (paramarey == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramarey.a();
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
      paramarey = (arfa)localList.get(i);
      localObject = (arfa)localList.get(i + 1);
      if ((paramLong < paramarey.a) || (((arfa)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramarey;
      if (paramarey != null) {
        break;
      }
      return (arfa)localList.get(j - 1);
      i += 1;
      break label43;
      paramarey = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyz
 * JD-Core Version:    0.7.0.1
 */