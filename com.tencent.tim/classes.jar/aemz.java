import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aemz
{
  public aemz.a a = new aemz.a();
  
  public static aemz a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aemz localaemz = new aemz();
        paramString = new JSONObject(paramString).optJSONObject("webbundle");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("qqcomic");
          if (paramString != null)
          {
            localaemz.a.enable = paramString.optBoolean("enable", false);
            localaemz.a.preloadUrl = paramString.optString("preload_url", "");
          }
        }
        QLog.d("ConfBean", 2, "confBean = " + localaemz.toString());
        return localaemz;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:").append(this.a);
    return localStringBuilder.toString();
  }
  
  public class a
  {
    public boolean enable;
    public String preloadUrl = "";
    
    public a() {}
    
    public boolean ahm()
    {
      return (this.enable) && (!TextUtils.isEmpty(this.preloadUrl));
    }
    
    public String toString()
    {
      return "WebBundleConfig{enable=" + this.enable + ", preloadUrl='" + this.preloadUrl + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemz
 * JD-Core Version:    0.7.0.1
 */