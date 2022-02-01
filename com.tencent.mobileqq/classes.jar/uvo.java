import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class uvo
{
  private ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static uvo a()
  {
    return uvq.a();
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.a.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null)) {
      this.a.put(paramString, new Gson().toJson(paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvo
 * JD-Core Version:    0.7.0.1
 */