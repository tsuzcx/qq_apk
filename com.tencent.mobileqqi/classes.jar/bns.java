import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bns
  implements TroopMemberApiClient.Callback
{
  public bns(TroopMemberApiPlugin paramTroopMemberApiPlugin, int paramInt, List paramList, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    do
    {
      return;
      localObject = paramBundle.getParcelableArray("resultList");
    } while ((localObject == null) || (localObject.length != this.jdField_a_of_type_Int - 1000));
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_OrgJsonJSONArray != null) {}
    for (paramBundle = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_OrgJsonJSONArray;; paramBundle = new JSONArray())
    {
      int i = 1000;
      while (i < this.jdField_a_of_type_Int)
      {
        JSONObject localJSONObject = TroopMemberApiPlugin.a((TroopMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), (Bundle)localObject[(i - 1000)]);
        if (localJSONObject != null) {
          paramBundle.put(localJSONObject);
        }
        i += 1;
      }
    }
    if ((!TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) || ((TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) && (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopMember", 2, "send data to web and size is jsonArray size is " + paramBundle.length());
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
    }
    if ((!TroopMemberApiPlugin.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) || (TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin))) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_OrgJsonJSONArray = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bns
 * JD-Core Version:    0.7.0.1
 */