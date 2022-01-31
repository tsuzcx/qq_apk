import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import org.json.JSONArray;

public class bno
  extends TroopObserver
{
  public bno(TroopMemberApiPlugin paramTroopMemberApiPlugin) {}
  
  protected void a(boolean paramBoolean)
  {
    Activity localActivity = this.a.mRuntime.a();
    AppInterface localAppInterface = this.a.mRuntime.a();
    WebView localWebView = this.a.mRuntime.a();
    TroopMemberApiPlugin.b(this.a, true);
    if ((paramBoolean) && (localActivity != null) && (localAppInterface != null) && (localWebView != null) && (localWebView.getUrl() != null))
    {
      PreferenceManager.getDefaultSharedPreferences(localActivity).edit().putLong("key_last_update_member_list_time" + this.a.e, System.currentTimeMillis()).commit();
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1));
      if (QLog.isColorLevel()) {
        QLog.d("troopMember", 2, "get member list from server successful in web process");
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2));
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.a.mRuntime.a();
    if ((localObject != null) && (((WebView)localObject).getUrl() != null) && (!paramBoolean))
    {
      localObject = this.a;
      ((TroopMemberApiPlugin)localObject).f += paramInt;
      this.a.callJs(this.a.k, new String[] { "{count:" + this.a.f + ", total:" + this.a.g + "}" });
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    paramArrayList = this.a.mRuntime.a();
    WebView localWebView = this.a.mRuntime.a();
    if ((paramArrayList == null) || (localWebView == null)) {
      return;
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!paramArrayList.isFinishing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131562986, 1500);
      }
      this.a.callJs(this.a.o, new String[] { "" });
      paramArrayList.setResult(-1);
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!paramArrayList.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562082, 1500);
    }
    this.a.callJs(this.a.o, new String[] { "" });
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong)
  {
    Activity localActivity = this.a.mRuntime.a();
    AppInterface localAppInterface = this.a.mRuntime.a();
    WebView localWebView = this.a.mRuntime.a();
    if ((localActivity == null) || (localAppInterface == null) || (localWebView == null)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          if (!paramString.equalsIgnoreCase("OidbSvc.0x8bb_2")) {
            break;
          }
          if (paramBoolean)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!localActivity.isFinishing())) {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131562987, 1000);
            }
            paramString = new JSONArray();
            i = paramArrayOfLong.length;
            paramInt = 0;
            while (paramInt < i)
            {
              paramString.put(paramArrayOfLong[paramInt]);
              paramInt += 1;
            }
            this.a.callJs(this.a.m, new String[] { "{uinList:" + paramString.toString() + "}" });
            return;
          }
        } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (localActivity.isFinishing()));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562092, 1000);
        return;
      } while (!paramString.equalsIgnoreCase("OidbSvc.0x8bb_3"));
      if (paramBoolean)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!localActivity.isFinishing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, 2131562982, 1000);
        }
        paramString = new JSONArray();
        i = paramArrayOfLong.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramString.put(paramArrayOfLong[paramInt]);
          paramInt += 1;
        }
        this.a.callJs(this.a.n, new String[] { "{uinList:" + paramString.toString() + "}" });
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (localActivity.isFinishing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562055, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bno
 * JD-Core Version:    0.7.0.1
 */