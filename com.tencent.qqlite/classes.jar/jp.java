import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListRequset;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class jp
  implements Runnable
{
  public jp(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      localObject3 = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getString("qqVersion", null);
      AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
      if (localAppRuntime != null)
      {
        str2 = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getString("lastVersion", null);
        localObject2 = new mobileqq_mp.WebviewWhiteListRequset();
        if ((str2 != null) && (str2.length() > 0) && ("2013 3.3.0".equals(localObject3))) {
          ((mobileqq_mp.WebviewWhiteListRequset)localObject2).version.set(str2);
        }
        localObject3 = new NewIntent(this.a.jdField_a_of_type_AndroidContentContext, ProtoServlet.class);
        ((NewIntent)localObject3).setWithouLogin(true);
        ((NewIntent)localObject3).putExtra("cmd", "PubAccountSvc.webview.whitelist");
        ((NewIntent)localObject3).putExtra("data", ((mobileqq_mp.WebviewWhiteListRequset)localObject2).toByteArray());
        ((NewIntent)localObject3).setObserver(new jq(this));
        localAppRuntime.startServlet((NewIntent)localObject3);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      AuthorizeConfig.b = 0;
      return;
    }
    String str2 = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getString("lastMod", null);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str2 != null)
    {
      localObject1 = localObject2;
      if (str2.length() > 0)
      {
        localObject1 = localObject2;
        if ("2013 3.3.0".equals(localObject3))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("If-Modified-Since", str2);
        }
      }
    }
    localObject2 = Uri.parse("http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json").getHost();
    Object localObject3 = MsfSdkUtils.insertMtype("qb_offline", "http://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json");
    int i;
    label421:
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = HttpUtil.a(this.a.jdField_a_of_type_AndroidContentContext, (String)localObject3, (String)localObject2, "GET", null, (Bundle)localObject1);
          if (localObject2 != null)
          {
            i = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
            if (QLog.isColorLevel()) {
              QLog.d("AuthorizeConfig", 2, "status code: " + String.valueOf(i));
            }
            if (i != 200) {
              break;
            }
            localObject1 = ((HttpResponse)localObject2).getFirstHeader("Last-Modified");
            if (localObject1 != null) {
              break label421;
            }
            localObject1 = null;
            localObject2 = HttpUtil.a((HttpResponse)localObject2);
            this.a.a(new JSONObject((String)localObject2), (String)localObject1, "lastMod");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "update error: " + localException);
          }
          AuthorizeConfig.b = 0;
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
          return;
        }
        String str1 = localException.getValue();
      }
    } while (i != 304);
    AuthorizeConfig.b = 2;
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     jp
 * JD-Core Version:    0.7.0.1
 */