import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class aldc
  extends VasWebviewJsPlugin
{
  public aldc()
  {
    this.mPluginNameSpace = "usersummary";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("usersummary"))) {
      return false;
    }
    if ((this.mRuntime.getActivity() instanceof FriendProfileCardActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileThirdWebviewPlugin", 2, "ProfileCardWebviewPlugin handle FriendProfileCardActivity");
      }
      paramJsBridgeListener = (FriendProfileCardActivity)this.mRuntime.getActivity();
      paramJsBridgeListener.a(paramJsBridgeListener.a.d, false);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileThirdWebviewPlugin", 2, "ProfileCardWebviewPlugin handle none");
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileThirdWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
  }
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldc
 * JD-Core Version:    0.7.0.1
 */