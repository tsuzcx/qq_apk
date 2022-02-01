import android.text.TextUtils;
import java.util.List;

public class zyk
{
  private static zyl jdField_a_of_type_Zyl = new zyl();
  private zyf jdField_a_of_type_Zyf = new zye();
  private zyf b = new zyn();
  
  public static zyk a()
  {
    return (zyk)jdField_a_of_type_Zyl.getInstance();
  }
  
  public avjt a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Zyf.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public avjv a(avjt paramavjt, long paramLong)
  {
    Object localObject;
    if (paramavjt == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramavjt.a();
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
      paramavjt = (avjv)localList.get(i);
      localObject = (avjv)localList.get(i + 1);
      if ((paramLong < paramavjt.a) || (((avjv)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramavjt;
      if (paramavjt != null) {
        break;
      }
      return (avjv)localList.get(j - 1);
      i += 1;
      break label43;
      paramavjt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyk
 * JD-Core Version:    0.7.0.1
 */