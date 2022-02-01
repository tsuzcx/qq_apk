import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class yqq
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List<yqr> jdField_a_of_type_JavaUtilList;
  
  public static String a(int paramInt)
  {
    b();
    yqr localyqr = a(paramInt);
    if (localyqr != null) {
      return localyqr.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  @Nullable
  private static yqr a(int paramInt)
  {
    b();
    Iterator localIterator = Collections.unmodifiableList(jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext())
    {
      yqr localyqr = (yqr)localIterator.next();
      if (localyqr.jdField_a_of_type_Int == paramInt) {
        return localyqr;
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
    yqr localyqr = a(paramInt);
    if (localyqr != null) {
      return localyqr.b;
    }
    return "";
  }
  
  private static void b()
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_a_of_type_JavaUtilList = new ArrayList();
        String str1 = ((vuq)vux.a(10)).c();
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
            jdField_a_of_type_JavaUtilList.add(new yqr(Integer.valueOf(str2).intValue(), str3, (String)localObject3));
          }
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          xvv.e("VideoSourceTagInfoHelper", "check read config error : %s, configStr : %s", new Object[] { localJSONException, str1 });
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            xvv.e("VideoSourceTagInfoHelper", "type format error : %s", new Object[] { str1 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqq
 * JD-Core Version:    0.7.0.1
 */