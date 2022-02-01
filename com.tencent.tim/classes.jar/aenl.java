import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aenl
{
  public String bzT = "";
  public String bzU = "";
  public String bzV = "";
  public String bzW = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  public int cOd = 1;
  
  public static aenl a(String paramString)
  {
    aenl localaenl = new aenl();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localaenl.bzT = localJSONObject.optString("kQQPASearchDiscoverPageUrl");
      localaenl.bzU = localJSONObject.optString("kQQPASearchListTitleIconUrl");
      localaenl.bzV = localJSONObject.optString("kQQPAClickAssociationalWordWebUrl");
      localaenl.cOd = localJSONObject.optInt("kQQPAClickAssociationalWordToWebSearch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, new Object[] { "loadConfig292Data json = ", paramString });
      }
      localaenl.bzW = localJSONObject.optString("kQQPASearchJumpUrl", "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). readinjoy_search_jump_url=" + localaenl.bzW + ", discoveryPageUrl = " + localaenl.bzT);
      }
    }
    catch (Exception paramString)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInjoySearchJumpurlConfBean", 2, "loadPublicAccountCenterUrlConfig error", paramString);
        }
        localaenl.bzW = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
      } while (!QLog.isColorLevel());
      QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). use the default url. exception=" + paramString.getStackTrace());
    }
    return localaenl;
    return localaenl;
  }
  
  public String toString()
  {
    return "kQQPASearchDiscoverPageUrl = " + this.bzT + "kQQPASearchListTitleIconUrl = " + this.bzU + "kQQPAClickAssociationalWordWebUrl = " + this.bzV + "kQQPAClickAssociationalWordToWebSearch = " + this.cOd + "kQQPASearchJumpUrl = " + this.bzW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenl
 * JD-Core Version:    0.7.0.1
 */