import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.b;

class stc
  extends Client.b
{
  stc(ssx paramssx) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == ssx.a(this.this$0).key))
    {
      String str1 = paramBundle.getString("cmd");
      String str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("request");
      if ((str1 != null) && ("ipc_hotchat_plugin".equals(str1)) && (paramBundle.getString("key_action").endsWith("updateFavoriteFlag")))
      {
        int i = paramBundle.getInt("result", 1);
        this.this$0.callJs(str2, new String[] { Integer.toString(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stc
 * JD-Core Version:    0.7.0.1
 */