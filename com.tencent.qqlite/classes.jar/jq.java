import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class jq
  implements BusinessObserver
{
  jq(jp paramjp) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "onReceive whitelist:" + paramBoolean);
    }
    if (paramBoolean)
    {
      Object localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.WebviewWhiteListResponse();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.ret_info.ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "sso status code: " + String.valueOf(paramInt));
          }
          if (paramInt == 0)
          {
            localObject = new JSONObject(paramBundle.data.get());
            ThreadManager.b().post(new jr(this, (JSONObject)localObject, paramBundle));
            return;
          }
          if (paramInt == 304)
          {
            AuthorizeConfig.b = 2;
            this.a.a.a.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
            ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 0, 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "update error: " + paramBundle);
          }
        }
      }
    }
    AuthorizeConfig.b = 0;
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     jq
 * JD-Core Version:    0.7.0.1
 */