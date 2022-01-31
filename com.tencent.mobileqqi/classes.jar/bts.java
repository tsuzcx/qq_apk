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

public class bts
  implements TroopMemberApiClient.Callback
{
  public bts(TroopMemberApiPlugin paramTroopMemberApiPlugin, int paramInt, List paramList, boolean paramBoolean, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getParcelableArray("resultList");
      } while ((paramBundle == null) || (paramBundle.length != this.jdField_a_of_type_Int));
      localObject = new JSONArray();
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        JSONObject localJSONObject = TroopMemberApiPlugin.a((TroopMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), (Bundle)paramBundle[i]);
        if (localJSONObject != null) {
          ((JSONArray)localObject).put(localJSONObject);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_OrgJsonJSONArray = ((JSONArray)localObject);
        return;
      }
      if ((!TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) || ((TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) && (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.b == null)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("troopMember", 2, "send data to web and size is jsonArray size is " + ((JSONArray)localObject).length());
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONArray)localObject).toString() });
      }
    } while ((TroopMemberApiPlugin.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)) && (!TroopMemberApiPlugin.b(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin)));
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bts
 * JD-Core Version:    0.7.0.1
 */