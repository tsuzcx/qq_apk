import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avcz
{
  private static final ArrayList<String> EK = new ArrayList(5);
  public static volatile boolean dmH = aKt();
  private static final Map<String, String> pS;
  private static Map<String, avcz.a> pT;
  
  static
  {
    EK.add("index");
    EK.add("fav");
    EK.add("category");
    EK.add("more");
    EK.add("group");
    pS = new HashMap(5);
    pS.put("NavConfig", "index");
    pS.put("FavNavConfig", "fav");
    pS.put("CateNavConfig", "category");
    pS.put("MoreNavConfig", "more");
    pS.put("GroupNavConfig", "group");
  }
  
  public static File N()
  {
    return new File(BaseApplicationImpl.getApplication().getFilesDir(), "comic_config/");
  }
  
  public static File O()
  {
    return new File(N(), "vipComic_nav_config.json");
  }
  
  public static File P()
  {
    return new File(N(), "tab_icons/");
  }
  
  public static Map<String, avcz.a> aI()
  {
    if (pT == null) {
      ezw();
    }
    return pT;
  }
  
  public static boolean aKt()
  {
    return O().exists();
  }
  
  public static boolean aKu()
  {
    dmH = aKv();
    return dmH;
  }
  
  private static boolean aKv()
  {
    Object localObject1 = aI();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      Object localObject2 = P().list();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject2 = Arrays.asList((Object[])localObject2);
        localObject1 = ((Map)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (!((List)localObject2).contains(((avcz.a)((Iterator)localObject1).next()).cJO)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public static JSONObject aj()
    throws JSONException
  {
    String str = aqhq.readFileContent(new File(N(), "vipComic_nav_config.json"));
    if (!TextUtils.isEmpty(str)) {
      return new JSONObject(str);
    }
    return null;
  }
  
  public static void cj(QQAppInterface paramQQAppInterface)
  {
    if (aKt()) {
      ezw();
    }
    for (;;)
    {
      if (!aKu()) {
        ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(100L, "vipComic_nav_tabIcon.zip", "helper");
      }
      return;
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(100L, "vipComic_nav_config.json", "helper");
    }
  }
  
  public static void ezw()
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = aj();
        if (localJSONObject1 != null)
        {
          if (pT != null) {
            pT.clear();
          }
          pT = new HashMap();
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject = localJSONObject1.optJSONArray(str);
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              continue;
            }
            i = ((JSONArray)localObject).length() - 1;
            if (i < 0) {
              continue;
            }
            JSONObject localJSONObject2 = ((JSONArray)localObject).optJSONObject(i);
            if ((localJSONObject2 == null) || (!arcp.b(localJSONObject2, str))) {
              break label251;
            }
            localObject = new avcz.a();
            ((avcz.a)localObject).cJM = localJSONObject2.optString("tabKey");
            if ((TextUtils.isEmpty(((avcz.a)localObject).cJM)) && (pS.containsKey(str))) {
              ((avcz.a)localObject).cJM = ((String)pS.get(str));
            }
            ((avcz.a)localObject).ewJ = localJSONObject2.optInt("sequence");
            ((avcz.a)localObject).tabName = localJSONObject2.optString("tabName");
            ((avcz.a)localObject).cJN = localJSONObject2.optString("tabUrl");
            ((avcz.a)localObject).cJO = localJSONObject2.optString("tabIcon");
            pT.put(str, localObject);
            continue;
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VipComicNavConfigHelper", 1, localJSONException, new Object[0]);
      }
      label251:
      i -= 1;
    }
  }
  
  public static List<avcz.a> hx()
  {
    Object localObject = aI();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        avcz.a locala = (avcz.a)((Iterator)localObject).next();
        if (locala.ewJ >= 0) {
          localArrayList.add(locala);
        }
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public static String rB(String paramString)
  {
    if (dmH) {
      return new File(P(), paramString).getAbsolutePath();
    }
    return null;
  }
  
  public static class a
    implements Comparable<a>
  {
    public String cJM;
    public String cJN;
    public String cJO;
    int ewJ;
    public String tabName;
    
    public int a(@NonNull a parama)
    {
      if (this.ewJ < parama.ewJ) {}
      int i;
      int j;
      do
      {
        return -1;
        if (this.ewJ > parama.ewJ) {
          return 1;
        }
        i = avcz.EK.indexOf(this.cJM);
        j = avcz.EK.indexOf(parama.cJM);
      } while (i < j);
      if (i > j) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcz
 * JD-Core Version:    0.7.0.1
 */