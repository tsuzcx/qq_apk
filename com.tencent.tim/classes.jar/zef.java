import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class zef
  extends WebViewPlugin
{
  public BroadcastReceiver aQ = new zeg(this);
  private String aZZ;
  private String mCallBack;
  
  public zef()
  {
    this.mPluginNameSpace = "faceUnblockCamera";
  }
  
  private void A(Activity paramActivity, String paramString)
  {
    if (alwy.auJ())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("edit_video_type", 10025);
      localBundle.putInt("entrance_type", 132);
      localBundle.putBoolean("enable_local_video", false);
      localBundle.putLong("capture_max_duration", 5000L);
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
      localBundle.putString("key_face_unlock_code", paramString);
      paramString = new Intent();
      paramString.setAction("from_webtool_launchshortvideo");
      paramString.setClass(paramActivity, JumpActivity.class);
      paramString.putExtras(localBundle);
      paramActivity.startActivity(paramString);
      return;
    }
    QLog.d("FaceUnblockCameraJsApiPlugin", 1, "openQIMCameraCaptureActivity failed: not support media codec");
    this.aZZ = ShortVideoUtils.zL();
    paramActivity = new Intent("android.media.action.VIDEO_CAPTURE");
    paramActivity.putExtra("output", Uri.fromFile(new File(this.aZZ)));
    paramActivity.putExtra("android.intent.extra.videoQuality", 1);
    startActivityForResult(paramActivity, (byte)0);
  }
  
  private void zu(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ThreadManager.excute(new FaceUnblockCameraJsApiPlugin.2(this, paramString), 64, null, true);
      return;
    }
    QLog.d("FaceUnblockCameraJsApiPlugin", 1, "onActivityResult failed: media url is null");
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call FaceUnblockCameraJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("faceUnblockCamera".equals(paramString2))
    {
      if ("startPTVActivity".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call startPTVActivity, args:" + paramVarArgs);
        }
        this.mCallBack = paramString1.split("#")[1];
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          A(this.mRuntime.getActivity(), paramVarArgs[0]);
        }
      }
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == 0) && (paramInt == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceUnblockCameraJsApiPlugin", 2, "onActivityResult: RESULT_OK, doParseData");
      }
      zu(this.aZZ);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    this.mRuntime.getActivity().registerReceiver(this.aQ, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.getActivity().unregisterReceiver(this.aQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zef
 * JD-Core Version:    0.7.0.1
 */