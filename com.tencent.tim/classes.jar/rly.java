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

public class rly
{
  private static rly a;
  private Map<String, List<rly.a>> gi = new ConcurrentHashMap();
  private Context mContext;
  
  public rly(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    cH(paramContext);
  }
  
  public static rly a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new rly(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void cH(Context paramContext)
  {
    paramContext = (aeny)aeif.a().o(362);
    if (paramContext != null) {}
    for (paramContext = paramContext.bzX;; paramContext = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowConfigManager", 2, "SlideShowConfigManager userConfigContents=" + paramContext);
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        this.gi.clear();
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
              rly.a locala = new rly.a();
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
              locala.tagId = Integer.parseInt(localJSONObject.getString("tagId"));
              locala.itemId = Integer.parseInt(localJSONObject.getString("itemId"));
              localArrayList.add(locala);
              j += 1;
            }
            this.gi.put(str, localArrayList);
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
  
  public List<rly.a> S(String paramString)
  {
    if (this.gi.size() == 0) {
      cH(this.mContext);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    List localList;
    do
    {
      return paramString;
      localList = (List)this.gi.get(paramString);
      if (localList == null) {
        break;
      }
      paramString = localList;
    } while (localList.size() != 0);
    return null;
  }
  
  public List<rly.a> ch()
  {
    if (this.gi.size() == 0) {
      cH(this.mContext);
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.gi.values().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
    }
    return localArrayList;
  }
  
  public static class a
  {
    public int itemId;
    public int tagId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rly
 * JD-Core Version:    0.7.0.1
 */