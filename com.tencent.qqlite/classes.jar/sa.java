import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class sa
  extends Handler
{
  public sa(OfflinePlugin paramOfflinePlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    Activity localActivity;
    label285:
    OfflineUpdateStatus localOfflineUpdateStatus;
    do
    {
      do
      {
        do
        {
          return;
          Object localObject;
          if (paramMessage.arg1 == 1)
          {
            this.a.c = paramMessage.arg2;
            localObject = (String)paramMessage.obj;
            this.a.mRuntime.a().a((String)localObject);
            this.a.mRuntime.a().requestFocus();
            if (QLog.isColorLevel()) {
              QLog.i(OfflinePlugin.a(this.a), 2, "mCheckupHandler loadUrl start");
            }
            this.a.a((String)localObject);
          }
          for (;;)
          {
            localActivity = this.a.mRuntime.a();
            if ((localActivity == null) || (!(localActivity instanceof QQBrowserActivity))) {
              break;
            }
            if (paramMessage.arg1 != 4) {
              break label285;
            }
            if ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a)))) {
              break;
            }
            localObject = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
            this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
            this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((OfflineUpdateStatus)localObject).e + paramMessage.arg2 + "%");
            return;
            if (paramMessage.arg1 == 2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.i(OfflinePlugin.a(this.a), 4, "checkOfflineUpBack refresh current url");
              }
              this.a.b();
            }
            else if (paramMessage.arg1 == 3)
            {
              try
              {
                localObject = (JSONObject)paramMessage.obj;
                OfflinePlugin.a(this.a, (JSONObject)localObject);
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        } while ((paramMessage.arg1 != 5) || (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      } while (localOfflineUpdateStatus == null);
      if (paramMessage.arg2 != 0) {
        break;
      }
      localOfflineUpdateStatus.b(3);
    } while (localActivity == null);
    paramMessage = localActivity.getResources().getDrawable(2130837751);
    paramMessage.setBounds(0, 0, 40, 40);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localOfflineUpdateStatus.d);
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localOfflineUpdateStatus.b(4);
      return;
    }
    QRUtils.a(1, 2131362503);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localOfflineUpdateStatus.b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sa
 * JD-Core Version:    0.7.0.1
 */