import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class aldz
{
  public static String bVY = acfp.m(2131716795);
  public static SparseArray<String> di;
  public static int dsB = 50;
  private static AtomicBoolean dy = new AtomicBoolean(false);
  
  public static void k(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        QLog.e("VipProfileDiyCardConfig", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (dy.compareAndSet(false, true))
      {
        localJSONObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "card.diyFontConfig.json", true, null);
        if (localJSONObject == null) {
          break label217;
        }
        localJSONArray = localJSONObject.optJSONArray("fontList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          if (di == null)
          {
            di = new SparseArray();
            break label227;
          }
        }
      }
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        paramAppRuntime = localJSONArray.optJSONObject(i);
        int j = paramAppRuntime.optInt("id");
        String str = paramAppRuntime.optString("imgUrl");
        if (TextUtils.isEmpty(str)) {
          break label232;
        }
        paramAppRuntime = str;
        if (!str.startsWith("http:"))
        {
          paramAppRuntime = str;
          if (!str.startsWith("https:")) {
            paramAppRuntime = "http:" + str;
          }
        }
        di.put(j, paramAppRuntime);
        break label232;
        di.clear();
      }
      else
      {
        dsB = localJSONObject.optInt("maxTextLength", dsB);
        bVY = localJSONObject.optString("inputTip", bVY);
        label217:
        dy.set(false);
        break;
      }
      label227:
      int i = 0;
      continue;
      label232:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldz
 * JD-Core Version:    0.7.0.1
 */