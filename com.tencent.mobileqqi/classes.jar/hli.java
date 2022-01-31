import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.applist.WebAppActivity.HttpGetAppInfoAsyncTask;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class hli
  extends Handler
{
  public hli(WebAppActivity paramWebAppActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    LogUtility.c("WebAppActivity", "handleMessage >>> " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.d();
        if (TextUtils.isEmpty(CommonDataAdapter.a().a()))
        {
          Toast.makeText(this.a, 2131559992, 0).show();
          this.a.i();
          return;
        }
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.j();
      } while (this.a.jdField_a_of_type_ComTencentSmttSdkWebView == null);
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.a.f);
      return;
    case 5: 
      Toast.makeText(this.a, 2131559993, 0).show();
      this.a.i();
      return;
    case 6: 
      Toast.makeText(this.a, 2131559991, 0).show();
      this.a.i();
      return;
    case 7: 
      Toast.makeText(this.a, 2131559992, 0).show();
      this.a.i();
      return;
    }
    Toast.makeText(this.a, 2131559990, 0).show();
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hli
 * JD-Core Version:    0.7.0.1
 */