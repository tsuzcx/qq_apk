import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

public class afsx
  extends WebViewPlugin
{
  public afsx()
  {
    this.mPluginNameSpace = "extendFriend";
  }
  
  private void Ij(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("category");
      String str1 = ((JSONObject)localObject).optString("name");
      String str2 = ((JSONObject)localObject).optString("schoolid");
      int j = ((JSONObject)localObject).optInt("idx");
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", str1);
      ((Bundle)localObject).putInt("category", i);
      ((Bundle)localObject).putString("schoolid", str2);
      ((Bundle)localObject).putInt("idx", j);
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendWebViewPlugin", 2, "onNotifyUpdateSchoolInfo result=" + paramString);
      }
      QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyUpdateSchoolInfo", (Bundle)localObject);
      avzf.a().a().f((Bundle)localObject, this.mRuntime.a().getCurrentAccountUin());
      return;
    }
    catch (JSONException paramString)
    {
      QLog.i("ExtendFriendWebViewPlugin", 1, "onNotifyUpdateSchoolInfo exception", paramString);
    }
  }
  
  private void Ik(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("certificateResult");
      paramString = new Bundle();
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.putBoolean("key_result", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendWebViewPlugin", 2, "onNotifyCampusFriendCertificateResult result=" + i);
        }
        QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyCampusFriendCertificateResult", paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.i("ExtendFriendWebViewPlugin", 1, "onNotifyCampusFriendCertificateResult exception", paramString);
    }
  }
  
  private void Il(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("uploadResult");
      paramString = new Bundle();
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.putBoolean("key_result", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendWebViewPlugin", 2, "onNotifyUploadSutudentIDResult result=" + i);
        }
        QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyUploadSutudentIDResult", paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.i("ExtendFriendWebViewPlugin", 1, "onNotifyUploadSutudentIDResult exception", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendWebViewPlugin", 2, "handleJsRequest url is: " + paramString1 + " method: " + paramString3 + " pkgName: " + paramString2 + " args: " + paramVarArgs);
    }
    if (!"extendFriend".equals(paramString2)) {}
    do
    {
      return false;
      if ("answerResult".equals(paramString3))
      {
        paramJsBridgeListener = this.mRuntime.a().getCurrentAccountUin();
        if (!TextUtils.isEmpty(paramJsBridgeListener)) {
          afsi.ce(paramJsBridgeListener, false);
        }
        return true;
      }
      if ("notifyCampusFriendCertificateResult".equals(paramString3))
      {
        if (paramVarArgs.length >= 1)
        {
          Ik(paramVarArgs[0]);
          avzf.a().a().bA(paramVarArgs[0], "notifyCampusFriendCertificateResult", this.mRuntime.a().getCurrentAccountUin());
        }
        for (;;)
        {
          return true;
          QLog.i("ExtendFriendWebViewPlugin", 1, "NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT arg error");
        }
      }
      if ("notifyUploadSutudentIDResult".equals(paramString3))
      {
        if (paramVarArgs.length >= 1)
        {
          Il(paramVarArgs[0]);
          avzf.a().a().bA(paramVarArgs[0], "notifyUploadSutudentIDResult", this.mRuntime.a().getCurrentAccountUin());
        }
        for (;;)
        {
          return true;
          QLog.i("ExtendFriendWebViewPlugin", 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
        }
      }
    } while (!"notifyUpdateSchoolInfo".equals(paramString3));
    if (paramVarArgs.length >= 1) {
      Ij(paramVarArgs[0]);
    }
    for (;;)
    {
      return true;
      QLog.i("ExtendFriendWebViewPlugin", 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsx
 * JD-Core Version:    0.7.0.1
 */