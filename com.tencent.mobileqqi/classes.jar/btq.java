import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;

public class btq
  extends Handler
{
  public btq(TroopMemberApiPlugin paramTroopMemberApiPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Activity localActivity = this.a.mRuntime.a();
    AppInterface localAppInterface = this.a.mRuntime.a();
    if ((localActivity == null) || (localAppInterface == null)) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        ThreadManager.a(new btr(this));
        return;
      }
    } while (!TroopMemberApiPlugin.b(this.a));
    this.a.callJs(this.a.j, new String[] { "true" });
    return;
    TroopMemberApiPlugin.h = 1;
    TroopMemberApiPlugin.q = this.a.g;
    paramMessage = new Intent();
    paramMessage.putExtra("finish_chat_setting", true);
    localActivity.setResult(-1, paramMessage);
    localActivity.finish();
    return;
    this.a.callJs(this.a.j, new String[] { "true" });
    return;
    paramMessage = (Object[])paramMessage.obj;
    boolean bool = ((Boolean)paramMessage[0]).booleanValue();
    paramMessage = (ArrayList)paramMessage[1];
    ChatSettingForTroop.a(localActivity, this.a.e, bool, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btq
 * JD-Core Version:    0.7.0.1
 */