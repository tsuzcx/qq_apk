import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahtm
{
  public static ahtm a = new ahtm();
  private Set<String> ct = new HashSet();
  
  static ahtm a(String paramString)
  {
    localahtm = new ahtm();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("appid_arr");
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localahtm.ct.add(str);
          }
          i += 1;
        }
        return localahtm;
      }
      catch (Throwable paramString)
      {
        QLog.e("GameShare.confBean", 1, paramString, new Object[0]);
      }
    }
  }
  
  boolean contains(String paramString)
  {
    return this.ct.contains(paramString);
  }
  
  public String toString()
  {
    return "NGConfBean{appidArr=" + this.ct + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtm
 * JD-Core Version:    0.7.0.1
 */