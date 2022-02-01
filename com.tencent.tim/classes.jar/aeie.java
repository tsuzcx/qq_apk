import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Iterator;
import java.util.Set;

public class aeie
{
  public static aemk a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    aeid.a().k(419, 0L, false);
    aeml localaeml = new aeml();
    paramBaseApplicationImpl = a(419, paramBaseApplicationImpl);
    if (paramBaseApplicationImpl != null) {
      try
      {
        paramBaseApplicationImpl = localaeml.a(paramBaseApplicationImpl);
        if (paramBaseApplicationImpl != null) {
          return paramBaseApplicationImpl;
        }
      }
      catch (Exception paramBaseApplicationImpl) {}
    }
    return new aemk();
  }
  
  private static SharedPreferences a(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    return paramBaseApplicationImpl.getSystemSharedPreferences("conf_" + paramLong + "_sharepref", 4);
  }
  
  private static aeic[] a(int paramInt, BaseApplicationImpl paramBaseApplicationImpl)
  {
    Object localObject1 = a(0L, paramBaseApplicationImpl);
    paramBaseApplicationImpl = b(0L, paramBaseApplicationImpl);
    Object localObject2 = ((SharedPreferences)localObject1).getStringSet(paramInt + "_ids", null);
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    localObject1 = new aeic[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new aeic(Integer.valueOf(str).intValue(), paramBaseApplicationImpl.getString(paramInt + "_" + str, null));
      i += 1;
    }
    return localObject1;
  }
  
  private static SharedPreferences b(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    return paramBaseApplicationImpl.getSystemSharedPreferences("conf_" + paramLong + "_content_sharepref", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeie
 * JD-Core Version:    0.7.0.1
 */