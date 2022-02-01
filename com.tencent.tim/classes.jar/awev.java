import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class awev
  extends awfr
{
  public static awev a;
  
  public awev()
  {
    a = this;
  }
  
  public static void aaO(String paramString)
  {
    if ((a != null) && (a.f != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onDeleteAudioVoice");
      a.f.callJs("window.moodVoice.onVoiceDelete('" + paramString + "')");
    }
  }
  
  public static void afj()
  {
    if ((a != null) && (a.f != null))
    {
      QLog.d("QZonePublishVoiceShuoShuoH5Plugin", 2, "onNotifyH5CutCancel");
      a.f.callJs("window.moodVoice.cutCancel()");
    }
  }
  
  public static void eDp()
  {
    if ((a != null) && (a.f != null)) {
      a.f.callJs("window.QZMoodVoiceJSInterface.notifyGetVoiceRecordTime()");
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  public void onDestroy()
  {
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awev
 * JD-Core Version:    0.7.0.1
 */