import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class aejg
{
  private static volatile aejg a;
  private LinkedHashMap<String, aejf> O;
  
  public static int F(String paramString1, String paramString2)
  {
    if (("com.tencent.structmsg".equals(paramString1)) && ("news".equals(paramString2))) {
      return 11;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("video".equals(paramString2))) {
      return 12;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("music".equals(paramString2))) {
      return 13;
    }
    if (("com.tencent.map".equals(paramString1)) && ("LocationShare".equals(paramString2))) {
      return 14;
    }
    return 10;
  }
  
  private JSONObject Y()
  {
    Object localObject = adph.jT("kArkMsgReplyConfig");
    try
    {
      localObject = new JSONObject((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      ArkAppCenter.r("ArkMsgReplyConfigMgr", "loadConfig exception");
    }
    return null;
  }
  
  private aejf a(String paramString1, String paramString2)
  {
    aejf localaejf = new aejf();
    localaejf.app = paramString1;
    localaejf.view = paramString2;
    if (!localaejf.isValid()) {
      return null;
    }
    return (aejf)this.O.get(localaejf.key());
  }
  
  public static aejg a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new aejg();
        a.O = new LinkedHashMap();
        a.parseConfig(a.Y());
      }
      return a;
    }
    finally {}
  }
  
  private void aW(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    adph.fs("kArkMsgReplyConfig", paramJSONObject);
  }
  
  private String e(JSONObject paramJSONObject, String paramString)
  {
    String str = paramString;
    try
    {
      if (lG(paramString)) {
        str = paramString.substring("jsonpath:".length());
      }
      paramJSONObject = new aeiz(str).a(awki.e(paramJSONObject)).toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      ArkAppCenter.r("ArkMsgReplyConfigMgr", "getContentByPath exception");
    }
    return "";
  }
  
  private boolean lG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("jsonpath:")) {
      return false;
    }
    return true;
  }
  
  private void parseConfig(JSONObject paramJSONObject)
  {
    this.O.clear();
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("messageReplyConfig");
      QLog.i("ArkMsgReplyConfigMgr", 1, "ArkMsgReplyConfigMgr=" + paramJSONObject);
    } while (paramJSONObject == null);
    int i = 0;
    label47:
    aejf localaejf;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localaejf = new aejf();
      localaejf.app = localJSONObject.optString("app", "");
      localaejf.view = localJSONObject.optString("view", "");
      localaejf.title = localJSONObject.optString("title", "");
      localaejf.tag = localJSONObject.optString("tag", "");
      localaejf.icon = localJSONObject.optString("icon", "");
      localaejf.action = localJSONObject.optString("action", "");
      localaejf.jumpUrl = localJSONObject.optString("jumpURL", "");
      if (localaejf.isValid()) {
        break label183;
      }
      ArkAppCenter.r("ArkMsgReplyConfigMgr", "parseConfig, item is invalid");
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label183:
      this.O.put(localaejf.key(), localaejf);
    }
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    aejf localaejf = a(str1, str2);
    Object localObject1;
    if (lG(localaejf.title))
    {
      localObject1 = e(paramJSONObject, localaejf.title);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localaejf.tag);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localaejf.icon);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localaejf.action);
      if (!lG(localaejf.jumpUrl)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = e(paramJSONObject, localaejf.jumpUrl);; paramJSONObject = localaejf.jumpUrl)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localaejf.title;
      break;
    }
  }
  
  public boolean aS(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2) != null;
  }
  
  public void aV(JSONObject paramJSONObject)
  {
    parseConfig(paramJSONObject);
    aW(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejg
 * JD-Core Version:    0.7.0.1
 */