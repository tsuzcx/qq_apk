import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class btn
  implements TroopMemberApiClient.Callback
{
  public btn(TroopMemberApiPlugin paramTroopMemberApiPlugin) {}
  
  public void a(Bundle paramBundle)
  {
    Activity localActivity = this.a.mRuntime.a();
    AppInterface localAppInterface = this.a.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing()) || (localAppInterface == null)) {}
    do
    {
      return;
      long l1 = PreferenceManager.getDefaultSharedPreferences(localActivity).getLong("key_last_update_member_list_time" + this.a.e, 0L);
      long l2 = System.currentTimeMillis();
      paramBundle = TroopMemberApiService.a(paramBundle);
      this.a.g = paramBundle.wMemberNum;
      if ((this.a.g <= TroopMemberApiPlugin.m) && ((l1 == 0L) || ((l1 > 0L) && (Math.abs(l2 - l1) > TroopMemberApiPlugin.n)))) {
        TroopMemberApiPlugin.a(this.a, true);
      }
      if ((this.a.g > TroopMemberApiPlugin.m) && ((l1 == 0L) || ((l1 > 0L) && (Math.abs(l2 - l1) > TroopMemberApiPlugin.o)))) {
        TroopMemberApiPlugin.a(this.a, true);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1));
    } while ((!TroopMemberApiPlugin.a(this.a)) || (this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null));
    if (QLog.isColorLevel()) {
      QLog.d("troopMember", 2, "request server to get member list in web process");
    }
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(true, this.a.e, this.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btn
 * JD-Core Version:    0.7.0.1
 */