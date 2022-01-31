import android.text.TextUtils;
import java.util.List;

public class ywp
{
  private static ywq jdField_a_of_type_Ywq = new ywq();
  private ywk jdField_a_of_type_Ywk = new ywj();
  private ywk b = new yws();
  
  public static ywp a()
  {
    return (ywp)jdField_a_of_type_Ywq.getInstance();
  }
  
  public atsc a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Ywk.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public atse a(atsc paramatsc, long paramLong)
  {
    Object localObject;
    if (paramatsc == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramatsc.a();
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
      paramatsc = (atse)localList.get(i);
      localObject = (atse)localList.get(i + 1);
      if ((paramLong < paramatsc.a) || (((atse)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramatsc;
      if (paramatsc != null) {
        break;
      }
      return (atse)localList.get(j - 1);
      i += 1;
      break label43;
      paramatsc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywp
 * JD-Core Version:    0.7.0.1
 */