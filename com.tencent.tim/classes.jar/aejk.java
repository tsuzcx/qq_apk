import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aejk
{
  public JSONObject bt = new JSONObject();
  public String byb = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
  public int cNt = 1;
  
  public static aejk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      aejk localaejk = new aejk();
      localaejk.bt = new JSONObject(paramString).optJSONObject("loverAIOPush");
      return localaejk;
    }
    catch (Exception paramString)
    {
      QLog.e("C2CLovePushGrayConfBean", 2, "C2CLovePushGrayConfBean onParsed erro " + paramString.toString());
    }
    return null;
  }
  
  public aejk b(String paramString)
  {
    aejk localaejk = new aejk();
    try
    {
      if (this.bt != null)
      {
        paramString = this.bt.optJSONObject(paramString);
        if (paramString != null)
        {
          localaejk.cNt = paramString.optInt("linkType", 1);
          localaejk.byb = paramString.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
          return localaejk;
        }
        localaejk.cNt = 1;
        localaejk.byb = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        return localaejk;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", paramString);
      }
      localaejk.cNt = 1;
      localaejk.byb = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
    }
    return localaejk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejk
 * JD-Core Version:    0.7.0.1
 */