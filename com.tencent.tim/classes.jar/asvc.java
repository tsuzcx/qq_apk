import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import org.json.JSONException;
import org.json.JSONObject;

class asvc
  implements IActivityResultListener
{
  asvc(asuz paramasuz, AsyncResult paramAsyncResult) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("MiniAppProxyImpl", 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 3)
    {
      String str1;
      String str2;
      double d1;
      double d2;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        str1 = paramIntent.getStringExtra("name");
        str2 = paramIntent.getStringExtra("address");
        d1 = paramIntent.getIntExtra("latitude", 0) / 1000000.0D;
        d2 = paramIntent.getIntExtra("longitude", 0) / 1000000.0D;
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppProxyImpl", 2, "doOnActivityResult name=" + str1 + ",address=" + str2 + ",latitude=" + d1 + ",longitude=" + d2);
        }
        paramIntent = new JSONObject();
      }
      try
      {
        paramIntent.put("name", str1);
        paramIntent.put("address", str2);
        paramIntent.put("latitude", d1);
        paramIntent.put("longitude", d2);
        this.val$asyncResult.onReceiveResult(true, paramIntent);
        AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
        return true;
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          QLog.e("MiniAppProxyImpl", 1, " error, ", paramIntent);
          this.val$asyncResult.onReceiveResult(false, new JSONObject());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvc
 * JD-Core Version:    0.7.0.1
 */