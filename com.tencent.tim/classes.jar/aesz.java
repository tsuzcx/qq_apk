import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aesz
{
  private HashMap<String, aesz.a> kd = new HashMap();
  
  public static aesz a(aeic paramaeic)
  {
    aesz localaesz = new aesz();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    try
    {
      paramaeic = new JSONObject(paramaeic.content);
      Object localObject;
      if (paramaeic.has("emoji"))
      {
        localObject = paramaeic.optJSONObject("emoji");
        if (localObject != null)
        {
          aesz.a locala = new aesz.a();
          locala.display = ((JSONObject)localObject).optInt("switch", 0);
          locala.iconUrl = ((JSONObject)localObject).optString("iconUrl", "");
          locala.url = ((JSONObject)localObject).optString("url", "");
          localaesz.kd.put("emoji", locala);
        }
      }
      if (paramaeic.has("wiki"))
      {
        paramaeic = paramaeic.optJSONObject("wiki");
        if (paramaeic != null)
        {
          localObject = new aesz.a();
          ((aesz.a)localObject).display = paramaeic.optInt("switch", 0);
          ((aesz.a)localObject).iconUrl = paramaeic.optString("iconUrl", "");
          ((aesz.a)localObject).url = paramaeic.optString("url", "");
          localaesz.kd.put("wiki", localObject);
        }
      }
    }
    catch (Exception paramaeic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaeic.toString());
    }
    return localaesz;
    return localaesz;
  }
  
  public String km(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aesz.a)this.kd.get(paramString);
    if (paramString != null) {
      return paramString.url;
    }
    return "";
  }
  
  public String kn(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aesz.a)this.kd.get(paramString);
    if (paramString != null) {
      return paramString.iconUrl;
    }
    return "";
  }
  
  public boolean lH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = (aesz.a)this.kd.get(paramString);
    } while (paramString == null);
    if (paramString.display == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    if (this.kd != null) {}
    for (String str = this.kd.toString();; str = "null") {
      return String.format("mConfigData:%s ", new Object[] { str });
    }
  }
  
  public static class a
  {
    public int display;
    public String iconUrl;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesz
 * JD-Core Version:    0.7.0.1
 */