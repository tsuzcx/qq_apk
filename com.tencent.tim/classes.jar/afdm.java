import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final class afdm
{
  private final WebViewPlugin a;
  private String mCallback;
  private Handler mHandler;
  
  public afdm(WebViewPlugin paramWebViewPlugin)
  {
    this.a = paramWebViewPlugin;
  }
  
  private AppActivity a()
  {
    if (this.a == null)
    {
      localObject = null;
      if (localObject != null) {
        break label38;
      }
    }
    label38:
    for (Object localObject = null;; localObject = ((WebViewPlugin.a)localObject).getActivity())
    {
      if (!(localObject instanceof AppActivity)) {
        break label46;
      }
      return (AppActivity)localObject;
      localObject = this.a.mRuntime;
      break;
    }
    label46:
    return null;
  }
  
  private boolean aiK()
  {
    AppActivity localAppActivity = a();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.CAMERA") == 0);
  }
  
  private void bg(boolean paramBoolean, int paramInt)
  {
    String str = this.mCallback;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("granted", paramBoolean);
      ((JSONObject)localObject2).put("errorCode", paramInt);
      ((JSONObject)localObject2).put("cmd", "onPermissionResult");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("CameraHelper", 1, "onPermissionResult error", localJSONException);
      }
    }
    if ((this.a != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.a.callJs(str, new String[] { localObject1 });
    }
  }
  
  private void cYy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
  }
  
  private void requestPermission()
  {
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new afdn(this), 1819, new String[] { "android.permission.CAMERA" });
    if (this.mHandler == null) {
      this.mHandler = new afdo(this, Looper.getMainLooper());
    }
    this.mHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  public void destroy()
  {
    this.mCallback = null;
    cYy();
    this.mHandler = null;
  }
  
  public boolean ij(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("CameraHelper", 1, "checkPermission failed, callback is invalid.");
    }
    while (this.a == null) {
      return false;
    }
    this.mCallback = paramString;
    if (aiK())
    {
      bg(true, 0);
      return true;
    }
    requestPermission();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdm
 * JD-Core Version:    0.7.0.1
 */