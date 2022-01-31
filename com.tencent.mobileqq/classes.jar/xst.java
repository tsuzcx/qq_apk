import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class xst
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List<xsu> jdField_a_of_type_JavaUtilList;
  
  public static String a(int paramInt)
  {
    b();
    xsu localxsu = a(paramInt);
    if (localxsu != null) {
      return localxsu.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  @Nullable
  private static xsu a(int paramInt)
  {
    b();
    Iterator localIterator = Collections.unmodifiableList(jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      xsu localxsu = (xsu)localIterator.next();
      if (localxsu.jdField_a_of_type_Int == paramInt) {
        return localxsu;
      }
    }
    return null;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilList != null)
      {
        jdField_a_of_type_JavaUtilList.clear();
        jdField_a_of_type_JavaUtilList = null;
      }
      return;
    }
  }
  
  public static String b(int paramInt)
  {
    b();
    xsu localxsu = a(paramInt);
    if (localxsu != null) {
      return localxsu.b;
    }
    return "";
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_a_of_type_JavaUtilList = new ArrayList();
        String str1 = ((uvt)uwa.a(10)).c();
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            Object localObject3 = localJSONObject.getJSONObject(str2);
            String str3 = ((JSONObject)localObject3).optString("jump_url", "");
            localObject3 = ((JSONObject)localObject3).optString("wording", "");
            jdField_a_of_type_JavaUtilList.add(new xsu(Integer.valueOf(str2).intValue(), str3, (String)localObject3));
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          wxe.e("VideoSourceTagInfoHelper", "check read config error : %s, configStr : %s", new Object[] { localJSONException, str1 });
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            wxe.e("VideoSourceTagInfoHelper", "type format error : %s", new Object[] { str1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xst
 * JD-Core Version:    0.7.0.1
 */