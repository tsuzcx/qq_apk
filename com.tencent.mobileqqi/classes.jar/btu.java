import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;

public class btu
  implements TroopMemberApiClient.Callback
{
  public btu(TroopMemberApiPlugin paramTroopMemberApiPlugin, TroopMemberInfo paramTroopMemberInfo, String paramString1, String paramString2, String paramString3) {}
  
  public void a(Bundle paramBundle)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      return;
      paramBundle = paramBundle.getParcelableArray("resultList");
    } while ((paramBundle == null) || (paramBundle.length != 1));
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b != null)
    {
      if (TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b.add(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
    }
    for (;;)
    {
      paramBundle = TroopMemberApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo, (Bundle)paramBundle[0]);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.b, this.c, String.valueOf(paramBundle) });
      return;
      label129:
      if (!this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin))
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b.clear();
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     btu
 * JD-Core Version:    0.7.0.1
 */