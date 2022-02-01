import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import common.config.service.QzoneConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awdh
{
  private static long aAX;
  private static String cPo;
  private static final int eAg = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneRegLruMapSize", 50);
  private static LRULinkedHashMap<String, Pattern> t;
  
  private static String GO()
  {
    long l = System.currentTimeMillis();
    if (l - aAX >= 180000L)
    {
      cPo = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneUrlBanList", "[{'domains':['^.*\\.douyin\\.com/.*'],'items':['^https?://d\\.douyin\\.com/.+']},{'domains':['^.*\\.huoshan\\.com/.*'],'items':['^https?://d\\.huoshan\\.com/.+']},{'domains':['^.*\\.toutiao\\.com/.*','^.*\\.xiguaapp\\.cn/.*','^.*\\.xiguashipin\\.cn/.*','^.*\\.365yg\\.com/.*','^.*\\.snssdk\\.com/.*','^.*\\.ixigua\\.com/.*','^.*\\.toutiaocdn\\.net/.*'],'items':['^https?://d\\.toutiao\\.com/.+','^https?://d\\.ixigua\\.com/.+']},{'domains':['^http.*'],'items':['^snssdk[0-9]+://.*','^changba://.*','^orpheus://.*']}]");
      aAX = l;
    }
    return cPo;
  }
  
  public static boolean k(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    String str1 = GO();
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    int i;
    label102:
    int j;
    try
    {
      localJSONArray = new JSONArray(str1);
      if (localJSONArray.length() > 0) {
        break label291;
      }
      return false;
    }
    catch (JSONException paramString1)
    {
      JSONArray localJSONArray;
      Object localObject1;
      Object localObject2;
      String str2;
      label147:
      QLog.e("QzoneStringMatcher", 1, "config is not valid json. " + str1);
    }
    if (i < localJSONArray.length())
    {
      localObject1 = localJSONArray.getJSONObject(i);
      localObject2 = ((JSONObject)localObject1).optJSONArray("domains");
      if (localObject2 == null) {
        break label296;
      }
      if (((JSONArray)localObject2).length() != 0) {
        break label303;
      }
      break label296;
      if (j >= ((JSONArray)localObject2).length()) {
        break label285;
      }
      str2 = (String)((JSONArray)localObject2).get(j);
      if ((TextUtils.isEmpty(str2)) || (!n(paramString1, str2))) {
        break label309;
      }
      j = 1;
      if (j == 0) {
        break label296;
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("items");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0)) {
        break label296;
      }
      j = 0;
    }
    for (;;)
    {
      if (j < ((JSONArray)localObject1).length())
      {
        localObject2 = (String)((JSONArray)localObject1).get(j);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!n(paramString2, (String)localObject2))) {
          break label318;
        }
        QLog.d("QzoneStringMatcher", 2, "match url:" + paramString2 + ",item=" + (String)localObject2);
        return true;
        return false;
        label285:
        j = 0;
        break label147;
        label291:
        i = 0;
        break;
      }
      label296:
      i += 1;
      break;
      label303:
      j = 0;
      break label102;
      label309:
      j += 1;
      break label102;
      label318:
      j += 1;
    }
  }
  
  public static boolean n(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    if (t == null) {
      t = new LRULinkedHashMap(eAg);
    }
    Pattern localPattern1 = null;
    try
    {
      if (eAg > 0) {
        localPattern1 = (Pattern)t.get(paramString2);
      }
      Pattern localPattern2 = localPattern1;
      if (localPattern1 == null)
      {
        localPattern1 = Pattern.compile(paramString2);
        localPattern2 = localPattern1;
        if (eAg > 0)
        {
          t.put(paramString2, localPattern1);
          localPattern2 = localPattern1;
        }
      }
      boolean bool = localPattern2.matcher(paramString1).lookingAt();
      return bool;
    }
    catch (Exception paramString1)
    {
      QLog.e("QzoneStringMatcher", 1, "isMatch reg error.", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdh
 * JD-Core Version:    0.7.0.1
 */