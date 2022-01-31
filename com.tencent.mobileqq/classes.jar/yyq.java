import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.GamePartyPlugin;

public class yyq
  extends aphy
{
  public yyq(GamePartyPlugin paramGamePartyPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey") == GamePartyPlugin.a(this.a).key) && ("batchGetUserInfo".equals(paramBundle.getString("cmd"))))
    {
      String str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response").getString("result");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle))) {
        this.a.callJs(str, new String[] { paramBundle });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyq
 * JD-Core Version:    0.7.0.1
 */