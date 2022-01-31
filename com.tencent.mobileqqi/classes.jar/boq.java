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
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class boq
  extends Handler
{
  public boq(OfflinePlugin paramOfflinePlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    OfflineUpdateStatus localOfflineUpdateStatus;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.arg1 == 1)
            {
              paramMessage = (String)paramMessage.obj;
              ((CustomWebView)this.a.mRuntime.a()).a(paramMessage);
              if (QLog.isColorLevel()) {
                QLog.i(OfflinePlugin.a(this.a), 2, "mCheckupHandler loadUrl start");
              }
              this.a.a(paramMessage);
              return;
            }
            if (paramMessage.arg1 == 2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.i(OfflinePlugin.a(this.a), 4, "checkOfflineUpBack:" + paramMessage.arg2);
              }
              ((CustomWebView)this.a.mRuntime.a()).a(paramMessage.arg2);
              return;
            }
            if (paramMessage.arg1 == 3) {
              try
              {
                paramMessage = (JSONObject)paramMessage.obj;
                OfflinePlugin.a(this.a, paramMessage);
                return;
              }
              catch (Exception paramMessage)
              {
                paramMessage.printStackTrace();
                return;
              }
            }
            if (paramMessage.arg1 != 4) {
              break;
            }
          } while ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a))));
          localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localOfflineUpdateStatus.e + paramMessage.arg2 + "%");
          return;
        } while ((paramMessage.arg1 != 5) || (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      } while (localOfflineUpdateStatus == null);
      if (paramMessage.arg2 != 0) {
        break;
      }
      localOfflineUpdateStatus.c(3);
      paramMessage = this.a.mRuntime.a();
    } while (paramMessage == null);
    paramMessage = paramMessage.getResources().getDrawable(2130837841);
    paramMessage.setBounds(0, 0, 40, 40);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localOfflineUpdateStatus.d);
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localOfflineUpdateStatus.c(4);
      return;
    }
    QRUtils.a(1, 2131560618);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localOfflineUpdateStatus.c(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     boq
 * JD-Core Version:    0.7.0.1
 */