import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class stm
  extends BroadcastReceiver
{
  public stm(NewerGuidePlugin paramNewerGuidePlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive action=%s", new Object[] { paramContext }));
    }
    if ("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      paramIntent = paramIntent.getStringExtra("PhotoConst.SOURCE_FROM");
      if (!TextUtils.isEmpty(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive path=%s syncQZone=%s sourceFrom=%s", new Object[] { paramContext, Boolean.valueOf(bool), paramIntent }));
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("key_action", "setAvatar");
        localBundle.putString("path", paramContext);
        localBundle.putBoolean("PhotoConst.SYNCQZONE", bool);
        localBundle.putString("PhotoConst.SOURCE_FROM", paramIntent);
        paramContext = affz.a("ipc_newer_guide", null, NewerGuidePlugin.a(this.a).key, localBundle);
        afjy.a().cq(paramContext);
        if (NewerGuidePlugin.a(this.a) == null)
        {
          paramContext = this.a.mRuntime.getActivity();
          int i = paramContext.getResources().getDimensionPixelSize(2131299627);
          NewerGuidePlugin.a(this.a, new arhz(paramContext, i));
          NewerGuidePlugin.a(this.a).setMessage(acfp.m(2131708981));
        }
        NewerGuidePlugin.a(this.a).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stm
 * JD-Core Version:    0.7.0.1
 */