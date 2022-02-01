import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awfj
  extends awfr
{
  private String TAG = awfj.class.getSimpleName();
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {}
    for (;;)
    {
      return false;
      if (("openUrl".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "openUrl=" + paramVarArgs[0]);
        }
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("url");
        this.f.mRuntime.getWebView().loadUrl(paramJsBridgeListener);
        if ((!"shareFriendMsg".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "shareFriendMsg: arg=" + paramVarArgs[0]);
        }
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString3.getString("content");
          paramString1 = paramString3.getString("jumpurl");
          paramString2 = paramString3.getString("uin");
          long l = paramString3.getLong("timestamp");
          paramString3 = new Intent();
          paramString3.putExtra("friend_uin", paramString2);
          paramString3.putExtra("content", paramJsBridgeListener);
          paramString3.putExtra("jumpUrl", paramString1);
          paramString3.putExtra("timestamp", l);
          PublicFragmentActivity.b.start(this.f.mRuntime.getActivity(), paramString3, PublicTransFragmentActivity.class, ActivateFriendShareFragment.class);
          return false;
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e(this.TAG, 1, "handle shareFriendMsg", paramJsBridgeListener);
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, "handle openUrl", paramJsBridgeListener);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfj
 * JD-Core Version:    0.7.0.1
 */