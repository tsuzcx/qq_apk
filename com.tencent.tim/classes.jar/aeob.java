import java.util.HashMap;
import org.json.JSONObject;

public class aeob
{
  private HashMap<String, aeoc> jY = new HashMap();
  
  public aeob()
  {
    aeoc localaeoc = new aeoc();
    localaeoc.Ht(true);
    localaeoc.setPath("pages/detail/detail");
    this.jY.put("s_qq_mini_importing", localaeoc);
  }
  
  public static aeob a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    for (;;)
    {
      aeob localaeob;
      int i;
      JSONObject localJSONObject;
      try
      {
        localaeob = new aeob();
        i = 0;
        if (i >= paramArrayOfaeic.length) {
          break label516;
        }
        localJSONObject = new JSONObject(paramArrayOfaeic[i].content);
        if (localJSONObject.has("MiniCodeConfigAioMsg"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioMsg");
          localaeob.jY.put("docs_miniapp_config_aio_msg", aeoc.a(localJSONObject));
        }
        else if (localJSONObject.has("MiniCodeConfigAioEdit"))
        {
          localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioEdit");
          localaeob.jY.put("docs_miniapp_config_aio_edit", aeoc.a(localJSONObject));
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
        return null;
      }
      if (localJSONObject.has("MiniCodeConfigBottomEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigBottomEdit");
        localaeob.jY.put("docs_miniapp_config_bottom_edit", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMyFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMyFile");
        localaeob.jY.put("docs_miniapp_config_my_file", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTroopFile"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTroopFile");
        localaeob.jY.put("docs_miniapp_config_troop_file", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigGrayBar"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigGrayBar");
        localaeob.jY.put("docs_miniapp_config_gray_bar", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigMenuEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigMenuEdit");
        localaeob.jY.put("docs_miniapp_config_menu_edit", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigDownloadEdit"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigDownloadEdit");
        localaeob.jY.put("docs_miniapp_config_download_edit", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("docs_miniapp_config_online_preview"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("docs_miniapp_config_online_preview");
        localaeob.jY.put("docs_miniapp_config_online_preview", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigTemplateList"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigTemplateList");
        localaeob.jY.put("docs_miniapp_config_templatelist", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigOcrSave"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigOcrSave");
        localaeob.jY.put("docs_miniapp_config_ocr_save", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigUrl2Doc"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigUrl2Doc");
        localaeob.jY.put("docs_miniapp_config_url_2_doc", aeoc.a(localJSONObject));
      }
      else if (localJSONObject.has("MiniCodeConfigAioArkH5"))
      {
        localJSONObject = (JSONObject)localJSONObject.get("MiniCodeConfigAioArkH5");
        localaeob.jY.put("docs_miniapp_config_aio_ark_h5", aeoc.a(localJSONObject));
        break label518;
        label516:
        return localaeob;
      }
      label518:
      i += 1;
    }
  }
  
  public HashMap<String, aeoc> F()
  {
    return this.jY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeob
 * JD-Core Version:    0.7.0.1
 */