import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

public class wcn
  implements HttpWebCgiAsyncTask.Callback
{
  public wcn(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = (TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    paramInt = paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramJSONObject.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, paramInt & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcn
 * JD-Core Version:    0.7.0.1
 */