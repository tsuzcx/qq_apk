import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class aldw
{
  public static aldw a;
  public SparseArray<aldw.a> dh;
  
  public static boolean bp(QQAppInterface paramQQAppInterface)
  {
    if (a == null) {
      return iU(aldx.aE(paramQQAppInterface.getApp()) + "xydata.json");
    }
    return true;
  }
  
  public static boolean iU(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VipWZRYTemplateConfig", 2, "configPath = " + paramString);
      }
      return false;
    }
    Object localObject = new File(paramString);
    try
    {
      localObject = aqhq.readFileToString((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("VipWZRYTemplateConfig", 1, paramString + " content is empty.");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("VipWZRYTemplateConfig", 1, paramString.getMessage());
      return false;
    }
    paramString = new aldw();
    localObject = new JSONObject((String)localObject).optJSONArray("cardWZResourceGrade");
    int i;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      paramString.dh = new SparseArray();
      i = 0;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject != null)
        {
          aldw.a locala = new aldw.a();
          locala.id = localJSONObject.optInt("wz_id");
          locala.name = localJSONObject.optString("wz_name");
          locala.format = localJSONObject.optString("wz_format");
          locala.positionType = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            aldw.b localb = new aldw.b();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localb.src = localJSONObject.optString("src");
            localb.size = localJSONObject.optInt("size");
            localb.md5 = localJSONObject.optString("md5");
            localb.width = localJSONObject.optInt("width");
            localb.height = localJSONObject.optInt("height");
            localb.bVW = localJSONObject.optString("mainColor");
            locala.a = localb;
          }
          paramString.dh.put(locala.id, locala);
        }
      }
      else
      {
        a = paramString;
        return true;
      }
      i += 1;
    }
  }
  
  public static class a
  {
    public aldw.b a;
    public String format;
    public int id;
    public String name;
    public int positionType;
  }
  
  public static class b
  {
    public String bVW;
    public int height;
    public String md5;
    public int size;
    public String src;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldw
 * JD-Core Version:    0.7.0.1
 */