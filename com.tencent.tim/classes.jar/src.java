import android.text.TextUtils;
import com.tencent.oskplayer.util.Singleton;
import java.util.List;

public class src
{
  private static src.a jdField_a_of_type_Src$a = new src.a();
  private sqz jdField_a_of_type_Sqz = new sqy();
  private sqz b = new sre();
  
  public static src a()
  {
    return (src)jdField_a_of_type_Src$a.getInstance();
  }
  
  public aiwn a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Sqz.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public aiwp a(aiwn paramaiwn, long paramLong)
  {
    Object localObject;
    if (paramaiwn == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramaiwn.fw();
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
      paramaiwn = (aiwp)localList.get(i);
      localObject = (aiwp)localList.get(i + 1);
      if ((paramLong < paramaiwn.mStartTime) || (((aiwp)localObject).mStartTime < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramaiwn;
      if (paramaiwn != null) {
        break;
      }
      return (aiwp)localList.get(j - 1);
      i += 1;
      break label43;
      paramaiwn = null;
    }
  }
  
  public static class a
    extends Singleton<src>
  {
    protected src b()
    {
      return new src();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     src
 * JD-Core Version:    0.7.0.1
 */