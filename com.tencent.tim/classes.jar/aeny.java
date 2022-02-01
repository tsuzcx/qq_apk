import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aeny
{
  public String bzX = "";
  
  public static aeny a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aeny localaeny = new aeny();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localaeny.bzX = paramString.getJSONArray("contents").toString();
        }
        return localaeny;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeny
 * JD-Core Version:    0.7.0.1
 */