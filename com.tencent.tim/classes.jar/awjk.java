import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

public class awjk
  extends RemoteCommand
{
  private QQAppInterface mApp;
  
  public awjk(QQAppInterface paramQQAppInterface)
  {
    super("troop.manage.get_app_interface_data");
    this.mApp = paramQQAppInterface;
  }
  
  protected Bundle C()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_upgrade_troop_url", aqqj.getUrl("vipUpGroupLimit"));
    return localBundle;
  }
  
  protected Bundle a(Bundle paramBundle, int paramInt)
  {
    String str = null;
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    if (paramInt == 5) {
      str = aqgv.h(this.mApp, paramBundle.getString("req_troop_uin"), paramBundle.getString("memUin"));
    }
    for (;;)
    {
      localBundle.putString("param_rsp_nick", str);
      return localBundle;
      if (paramInt == 6) {
        str = aqgv.n(this.mApp, paramBundle.getString("memUin"));
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if ((paramBundle == null) || (this.mApp == null)) {
      return null;
    }
    try
    {
      paramOnInvokeFinishLinstener = new Bundle();
      i = paramBundle.getInt("req_sub_cmd", 0);
      switch (i)
      {
      case 1: 
        paramBundle = t(paramBundle);
      }
    }
    catch (Exception paramBundle)
    {
      int i;
      if (!QLog.isColorLevel()) {
        break label198;
      }
      QLog.d("TroopManageCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + paramBundle.getClass().getName() + "msg = " + paramBundle.getMessage());
      anot.a(this.mApp, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
      return null;
    }
    return a(paramBundle, i);
    return u(paramBundle);
    return s(paramBundle);
    paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
    ((TroopManager)this.mApp.getManager(52)).i(paramBundle);
    return paramOnInvokeFinishLinstener;
    return C();
    label198:
    paramBundle = paramOnInvokeFinishLinstener;
    return paramBundle;
  }
  
  protected Bundle s(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_rsp_troop_owmer_field", ((apsw)this.mApp.getManager(48)).lO(paramBundle.getString("req_troop_uin")));
    return localBundle;
  }
  
  protected Bundle t(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle = new Bundle();
    paramBundle.putInt("rep_unique_title_flag", ((TroopManager)this.mApp.getManager(52)).Bb());
    return paramBundle;
  }
  
  protected Bundle u(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("set_unique_title_flag");
    paramBundle = new Bundle();
    ((TroopManager)this.mApp.getManager(52)).JZ(i);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjk
 * JD-Core Version:    0.7.0.1
 */