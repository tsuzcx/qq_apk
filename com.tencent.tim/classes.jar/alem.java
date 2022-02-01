import SummaryCard.TPraiseInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class alem
{
  public static Vector<String> N;
  public static Vector<alem.a> O;
  public static int dsE = 2000;
  public static int dsF;
  private static AtomicBoolean dy = new AtomicBoolean(false);
  public static int playNum = 10;
  
  public static List<TPraiseInfo> bp(List<TPraiseInfo> paramList)
  {
    Object localObject = paramList;
    if (dsF == 0)
    {
      localObject = paramList;
      if (paramList != null)
      {
        localObject = paramList;
        if (!paramList.isEmpty())
        {
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TPraiseInfo localTPraiseInfo = (TPraiseInfo)paramList.next();
            if (localTPraiseInfo.uCustomId > 0L) {
              ((List)localObject).add(localTPraiseInfo);
            } else {
              localArrayList.add(localTPraiseInfo);
            }
          }
          ((List)localObject).addAll(localArrayList);
        }
      }
    }
    return localObject;
  }
  
  public static void k(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    JSONObject localJSONObject;
    Object localObject2;
    label86:
    int i;
    Object localObject1;
    for (;;)
    {
      try
      {
        QLog.e("PraiseConfigHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (dy.compareAndSet(false, true))
      {
        localJSONObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "praise.config.json", true, null);
        if (localJSONObject == null) {
          break label415;
        }
        localObject2 = localJSONObject.optJSONArray("colorEntries");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          if (N == null)
          {
            N = new Vector();
            break label425;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject1 = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label430;
              }
              paramAppRuntime = (AppRuntime)localObject1;
              if (!((String)localObject1).startsWith("http:")) {
                paramAppRuntime = "http:" + (String)localObject1;
              }
              N.add(paramAppRuntime);
              break label430;
            }
          }
          else
          {
            N.clear();
            break label425;
          }
        }
      }
    }
    paramAppRuntime = localJSONObject.optJSONArray("newEntries");
    if ((paramAppRuntime != null) && (paramAppRuntime.length() > 0)) {
      if (O == null)
      {
        O = new Vector();
        break label437;
      }
    }
    for (;;)
    {
      label204:
      int j;
      if (i < paramAppRuntime.length())
      {
        localObject2 = paramAppRuntime.optJSONObject(i);
        if (localObject2 == null) {
          break label449;
        }
        localObject1 = new alem.a();
        ((alem.a)localObject1).title = ((JSONObject)localObject2).optString("title");
        ((alem.a)localObject1).subTitle = ((JSONObject)localObject2).optString("subtitle");
        ((alem.a)localObject1).alE = ((JSONObject)localObject2).optString("bannerLink");
        ((alem.a)localObject1).Zp = ((JSONObject)localObject2).optString("reportName");
        ((alem.a)localObject1).P = new Vector();
        localObject2 = ((JSONObject)localObject2).optJSONArray("entrys");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          j = 0;
        }
      }
      for (;;)
      {
        if (j < ((JSONArray)localObject2).length())
        {
          String str = ((JSONArray)localObject2).optJSONObject(j).optString("icon");
          if (TextUtils.isEmpty(str)) {
            break label442;
          }
          ((alem.a)localObject1).P.add(str);
          break label442;
          O.clear();
        }
        else
        {
          O.add(localObject1);
          break label449;
          playNum = localJSONObject.optInt("playNum", 10);
          dsE = (int)(localJSONObject.optDouble("downloadTimeLimit", 2.0D) * 1000.0D);
          dsF = localJSONObject.optInt("praiseFlyOrder", 0);
          label415:
          dy.set(false);
          break;
          label425:
          i = 0;
          break label86;
          label430:
          i += 1;
          break label86;
        }
        label437:
        i = 0;
        break label204;
        label442:
        j += 1;
      }
      label449:
      i += 1;
    }
  }
  
  public static class a
  {
    public Vector<String> P;
    public String Zp;
    public String alE;
    public String subTitle;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alem
 * JD-Core Version:    0.7.0.1
 */