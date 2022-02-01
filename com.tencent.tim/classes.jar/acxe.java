import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import java.util.HashMap;

public class acxe
  extends acuk
{
  public acxe(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acT()
  {
    String str = (String)this.attrs.get("groupcode");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.context instanceof Activity))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label302;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label302;
      }
    }
    label302:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopManagerAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", apuh.ai(this.context, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new awjk(this.app);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.context);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, (Activity)this.context, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("TroopManagerAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("TroopManagerAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acT();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TroopManagerAction", 1, "doAction error: " + localException.getMessage());
      Ge("TroopManagerAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */