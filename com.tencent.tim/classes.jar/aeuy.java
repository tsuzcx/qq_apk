import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class aeuy
{
  private boolean bWB;
  private final Map<String, String> mConfig = new HashMap();
  
  public static aeuy a(aeic[] paramArrayOfaeic)
  {
    Object localObject1;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error, confFiles is no-valid.");
      localObject1 = null;
      return localObject1;
    }
    aeuy localaeuy = new aeuy();
    int j = paramArrayOfaeic.length;
    int i = 0;
    for (;;)
    {
      localObject1 = localaeuy;
      if (i >= j) {
        break;
      }
      localObject1 = paramArrayOfaeic[i];
      try
      {
        localObject1 = new JSONObject(((aeic)localObject1).content);
        if (localObject1 != null)
        {
          if (((JSONObject)localObject1).has("has_gray")) {
            localaeuy.bWB = ((JSONObject)localObject1).optBoolean("has_gray");
          }
          b((JSONObject)localObject1, localaeuy.mConfig);
        }
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("TdsReaderView_TdsReaderConfigBean", 1, "parse error", localJSONException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, aeuy paramaeuy)
  {
    if (paramaeuy == null) {
      QLog.w("TdsReaderView_TdsReaderConfigBean", 1, "source error, configBean is null.");
    }
    int i;
    do
    {
      return;
      if (!paramaeuy.mConfig.isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          TdsReaderGlobal.c(paramBoolean, paramaeuy.mConfig);
        }
        if (!paramaeuy.bWB) {
          break;
        }
        aevb.initConfig();
        return;
      }
    } while (i == 0);
    TdsReaderGlobal.setEnable(true);
  }
  
  public static void b(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if ((paramJSONObject == null) || (paramMap == null)) {}
    do
    {
      return;
      if (paramJSONObject.has("facade_plugin_name")) {
        paramMap.put("facade_plugin_name", paramJSONObject.optString("facade_plugin_name"));
      }
      if (paramJSONObject.has("facade_plugin_name_prefix")) {
        paramMap.put("facade_plugin_name_prefix", paramJSONObject.optString("facade_plugin_name_prefix"));
      }
      if (paramJSONObject.has("facade_plugin_url")) {
        paramMap.put("facade_plugin_url", paramJSONObject.optString("facade_plugin_url"));
      }
      if (paramJSONObject.has("facade_plugin_md5")) {
        paramMap.put("facade_plugin_md5", paramJSONObject.optString("facade_plugin_md5"));
      }
      if (paramJSONObject.has("facade_plugin_entry_class")) {
        paramMap.put("facade_plugin_entry_class", paramJSONObject.optString("facade_plugin_entry_class"));
      }
      if (paramJSONObject.has("pre_load_info")) {
        paramMap.put("pre_load_info", paramJSONObject.optString("pre_load_info"));
      }
      if (paramJSONObject.has("global_required_res_info")) {
        paramMap.put("global_required_res_info", paramJSONObject.optString("global_required_res_info"));
      }
      if (paramJSONObject.has("docs_plugin_info")) {
        paramMap.put("docs_plugin_info", paramJSONObject.optString("docs_plugin_info"));
      }
      if (paramJSONObject.has("docs_font_info")) {
        paramMap.put("docs_font_info", paramJSONObject.optString("docs_font_info"));
      }
      if (paramJSONObject.has("sheets_plugin_info")) {
        paramMap.put("sheets_plugin_info", paramJSONObject.optString("sheets_plugin_info"));
      }
      if (paramJSONObject.has("slides_plugin_info")) {
        paramMap.put("slides_plugin_info", paramJSONObject.optString("slides_plugin_info"));
      }
    } while (!paramJSONObject.has("slides_res_info"));
    paramMap.put("slides_res_info", paramJSONObject.optString("slides_res_info"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuy
 * JD-Core Version:    0.7.0.1
 */