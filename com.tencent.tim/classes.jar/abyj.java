import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.4;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.6.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class abyj
  implements tzd
{
  final String url = "https://open.hudong.qq.com/devtool/authorize";
  
  public abyj(int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  private String[] f(int paramInt)
  {
    return new String[] { "Content-Type", "application/x-www-form-urlencoded", "Content-Length", "" + paramInt, "Cookie", "uin=" + this.val$uin + ";skey=" + this.val$skey };
  }
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    paramString = "openID=&&accesstoken=&&token=" + this.ctH + "&&gameid=" + this.val$gameId + "&&subcode=2";
    ThreadManager.post(new ApolloGameUtil.6.6(this, paramString, f(paramString.length()), new abym(this)), 8, null, false);
  }
  
  public void onPermission(int paramInt)
  {
    String str = "openID=&&accesstoken=&&token=" + this.ctH + "&&gameid=" + this.val$gameId + "&&subcode=0";
    ThreadManager.post(new ApolloGameUtil.6.2(this, str, f(str.length()), new abyk(this)), 8, null, false);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("ApolloGameUtil", 2, new Object[] { "get openid and accessToken on Success result = ", paramJSONObject.toString() });
    try
    {
      String str = paramJSONObject.optString("openid");
      paramJSONObject = paramJSONObject.optString("access_token");
      paramJSONObject = "openID=" + str + "&&accesstoken=" + paramJSONObject + "&&token=" + this.ctH + "&&gameid=" + this.val$gameId + "&&subcode=1";
      ThreadManager.post(new ApolloGameUtil.6.4(this, paramJSONObject, f(paramJSONObject.length()), new abyl(this)), 8, null, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("ApolloGameUtil", 2, "getOpenIdAndAccessToken failed ", paramJSONObject);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abyj
 * JD-Core Version:    0.7.0.1
 */