import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class npr
{
  private static Map<String, npr.a> eM = new ConcurrentHashMap();
  
  static
  {
    init();
  }
  
  public static npt a(String paramString)
  {
    if (eM.containsKey(paramString))
    {
      paramString = (npr.a)eM.get(paramString);
      if ((paramString != null) && (paramString.a != null)) {
        return paramString.a.a();
      }
    }
    return null;
  }
  
  public static void a(npr.a parama)
  {
    if ((parama.ani == null) || (parama.anm == null)) {
      return;
    }
    eM.put(parama.ani, parama);
  }
  
  public static void bN(String paramString1, String paramString2)
  {
    QLog.d("RealTimeController", 1, "serviceKey:" + paramString1 + " styles:" + paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    npr.a locala;
    do
    {
      return;
      locala = (npr.a)eM.get(paramString1);
    } while (locala == null);
    paramString1 = npt.a(paramString1, true);
    if (paramString1 == null)
    {
      QLog.d("RealTimeController", 1, "realTimeTemplateFactory == null styles:" + paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        paramString1.setId(npm.qO());
        localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).getString("businessID");
        QLog.d("RealTimeController", 1, "realTimeBusinessID: " + paramString2);
        paramString2 = ((JSONObject)localObject).getJSONArray("styleList");
        if (!((JSONObject)localObject).has("deleteList")) {
          break label282;
        }
        localObject = ((JSONObject)localObject).getJSONArray("deleteList");
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localArrayList.add(str);
          paramString1.ox(str);
          i += 1;
          continue;
        }
        locala.a.dn(localArrayList);
      }
      catch (Exception paramString1)
      {
        Object localObject;
        QLog.d("RealTimeController", 1, "", paramString1);
        return;
      }
      if (i >= paramString2.length()) {
        break;
      }
      localObject = (JSONObject)paramString2.get(i);
      locala.a.a(paramString1, (JSONObject)localObject, true);
      i += 1;
      continue;
      label282:
      int i = 0;
    }
  }
  
  public static String eY(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    try
    {
      localObject = (npr.a)eM.get(paramString);
      localJSONObject.put("app", "QQ");
      localJSONObject.put("appVersion", "3.4.4");
      localJSONObject.put("businessID", ((npr.a)localObject).anm);
      localJSONObject.put("os", "android");
      localObject = new JSONObject();
      paramString = npt.a(paramString, false);
      if (paramString != null)
      {
        paramString = paramString.J().entrySet().iterator();
        while (paramString.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramString.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return localJSONObject.toString();
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.d("RealTimeController", 1, "", paramString);
    }
    for (;;)
    {
      localJSONObject.put("styles", localObject);
      QLog.d("RealTimeController", 1, "styles: " + localJSONObject);
    }
  }
  
  private static void init()
  {
    a(new npr.a("default_feeds", "1"));
  }
  
  public static class a
  {
    public final nps a;
    public final String ani;
    public final String anm;
    
    public a(String paramString1, String paramString2)
    {
      this.ani = paramString1;
      this.anm = paramString2;
      this.a = new nps(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npr
 * JD-Core Version:    0.7.0.1
 */