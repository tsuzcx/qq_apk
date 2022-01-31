import android.text.TextUtils;
import java.util.List;

public class xhw
{
  private static xhx jdField_a_of_type_Xhx = new xhx();
  private xhr jdField_a_of_type_Xhr = new xhq();
  private xhr b = new xhz();
  
  public static xhw a()
  {
    return (xhw)jdField_a_of_type_Xhx.getInstance();
  }
  
  public asbc a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Xhr.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public asbe a(asbc paramasbc, long paramLong)
  {
    Object localObject;
    if (paramasbc == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramasbc.a();
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
      paramasbc = (asbe)localList.get(i);
      localObject = (asbe)localList.get(i + 1);
      if ((paramLong < paramasbc.a) || (((asbe)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramasbc;
      if (paramasbc != null) {
        break;
      }
      return (asbe)localList.get(j - 1);
      i += 1;
      break label43;
      paramasbc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhw
 * JD-Core Version:    0.7.0.1
 */