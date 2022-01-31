import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class vtz
{
  private static vtz jdField_a_of_type_Vtz;
  private Context jdField_a_of_type_AndroidContentContext;
  private Map<String, List<vua>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public vtz(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public static vtz a(Context paramContext)
  {
    if (jdField_a_of_type_Vtz == null) {}
    try
    {
      if (jdField_a_of_type_Vtz == null) {
        jdField_a_of_type_Vtz = new vtz(paramContext);
      }
      return jdField_a_of_type_Vtz;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    paramContext = (amwd)ampm.a().a(362);
    if (paramContext != null) {}
    for (paramContext = paramContext.a;; paramContext = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowConfigManager", 2, "SlideShowConfigManager userConfigContents=" + paramContext);
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        try
        {
          paramContext = new JSONArray(paramContext);
          int i = 0;
          while (i < paramContext.length())
          {
            Object localObject = paramContext.getJSONObject(i);
            String str = ((JSONObject)localObject).optString("effectID", "");
            localObject = ((JSONObject)localObject).getJSONArray("musics");
            ArrayList localArrayList = new ArrayList();
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              vua localvua = new vua();
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
              localvua.a = Integer.parseInt(localJSONObject.getString("tagId"));
              localvua.b = Integer.parseInt(localJSONObject.getString("itemId"));
              localArrayList.add(localvua);
              j += 1;
            }
            this.jdField_a_of_type_JavaUtilMap.put(str, localArrayList);
            i += 1;
          }
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowConfigManager", 2, "");
          }
        }
      }
    }
  }
  
  public List<vua> a()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List<vua> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    List localList;
    do
    {
      return paramString;
      localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localList == null) {
        break;
      }
      paramString = localList;
    } while (localList.size() != 0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vtz
 * JD-Core Version:    0.7.0.1
 */