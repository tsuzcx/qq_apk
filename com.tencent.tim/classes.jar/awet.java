import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awet
  extends awfr
{
  private BroadcastReceiver bX = new aweu(this);
  
  private void acn(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 1: 
      eDp();
      return;
    case 2: 
      afY();
      return;
    case 3: 
      afZ();
      return;
    case 4: 
      aga();
      return;
    }
    agb();
  }
  
  private void registerReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncSecretShuoshuoMsg");
      this.f.mRuntime.getActivity().registerReceiver(this.bX, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZonePublishSecretShuoShuoH5Plugin", 1, "registerMsgReceiver----", localException);
    }
  }
  
  public void afY()
  {
    if (this.f != null) {
      this.f.callJs("window.secret.onRightButtonClick()");
    }
  }
  
  public void afZ()
  {
    if (this.f != null) {
      this.f.callJs("window.secret.onEditLeftButtonClick()");
    }
  }
  
  public void aga()
  {
    if (this.f != null) {
      this.f.callJs("window.secret.onEditRightButtonClick()");
    }
  }
  
  public void agb()
  {
    if (this.f != null) {
      this.f.callJs("try { window.QZMoodVoiceJSInterface.onRecordCancel() } catch (error) {}");
    }
  }
  
  public void bF(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.f != null) && (this.f.mRuntime != null) && (this.f.mRuntime.getWebView() != null))
        {
          this.f.mRuntime.getWebView().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void bG(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("voiceTime", paramLong);
        localObject = ((JSONObject)localObject).toString();
        if ((this.f != null) && (this.f.mRuntime != null) && (this.f.mRuntime.getWebView() != null))
        {
          this.f.mRuntime.getWebView().callJs(paramString, new String[] { localObject });
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString.getMessage());
      }
    }
  }
  
  public void c(WebViewPlugin paramWebViewPlugin)
  {
    super.c(paramWebViewPlugin);
    registerReceiver();
  }
  
  public void eDp()
  {
    if (this.f != null) {
      this.f.callJs("window.QZMoodVoiceJSInterface.onRecordDone()");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {}
    do
    {
      return false;
      if (paramString3.equalsIgnoreCase("updateFeedsAndPopup"))
      {
        paramJsBridgeListener = this.f.mRuntime.getActivity();
        if ((paramJsBridgeListener instanceof awfz)) {
          ((awfz)paramJsBridgeListener).aeJ();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("editTitleButtons"))
      {
        paramJsBridgeListener = this.f.mRuntime.getActivity();
        if ((paramJsBridgeListener instanceof awfz)) {
          ((awfz)paramJsBridgeListener).aeK();
        }
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceRecordTime"))
      {
        paramString1 = "";
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          if (paramString2 != null) {
            paramJsBridgeListener = paramString2.optString("callback");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString1;
          }
        }
        avrz.a().a(paramJsBridgeListener, this);
        return true;
      }
      int i;
      if (paramString3.equalsIgnoreCase("playMoodVoice"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = j;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = j;
          }
        }
        avrz.a().a(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("getMoodVoiceData"))
      {
        paramString1 = "";
        paramJsBridgeListener = paramString1;
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          i = k;
          paramJsBridgeListener = paramString1;
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            paramString1 = paramString2.optString("callback");
            paramJsBridgeListener = paramString1;
            i = paramString2.optInt("voiceID");
            paramJsBridgeListener = paramString1;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            i = k;
          }
        }
        avrz.a().b(paramJsBridgeListener, i, this);
        return true;
      }
      if (paramString3.equalsIgnoreCase("stopPlayingMoodVoice"))
      {
        avrz.a().eBK();
        return true;
      }
    } while (!paramString3.equalsIgnoreCase("didPublishMoodVoice"));
    paramJsBridgeListener = this.f.mRuntime.getActivity();
    if ((paramJsBridgeListener instanceof awew)) {
      ((awew)paramJsBridgeListener).afi();
    }
    return true;
  }
  
  public void jy(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, "callback is null");
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("voiceData", paramString2);
        localJSONObject.put("voiceFormat", "amr");
        paramString2 = localJSONObject.toString();
        if ((this.f != null) && (this.f.mRuntime != null) && (this.f.mRuntime.getWebView() != null))
        {
          this.f.mRuntime.getWebView().callJs(paramString1, new String[] { paramString2 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, paramString1.getMessage());
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    default: 
      return;
    }
    if (paramInt == -1)
    {
      avrz.a().s(paramIntent, 0);
      return;
    }
    agb();
  }
  
  public void onDestroy()
  {
    try
    {
      this.f.mRuntime.getActivity().unregisterReceiver(this.bX);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZonePublishSecretShuoShuoH5Plugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awet
 * JD-Core Version:    0.7.0.1
 */