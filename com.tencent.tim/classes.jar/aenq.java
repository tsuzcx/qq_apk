import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class aenq
{
  public String auB = "";
  public int cOe;
  public HashMap<String, String> jX = new HashMap();
  public String mIconUrl = "";
  
  public static aenq a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    aenq localaenq;
    try
    {
      localaenq = new aenq();
      localaenq.auB = paramString;
      paramString = new JSONObject(paramString);
      localaenq.cOe = paramString.optInt("isShowEntry");
      localaenq.mIconUrl = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localaenq.mIconUrl)) {
        localaenq.mIconUrl = localaenq.mIconUrl.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaenq.jX.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localaenq.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localaenq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.auB);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenq
 * JD-Core Version:    0.7.0.1
 */