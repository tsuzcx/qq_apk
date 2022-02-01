import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doc.jsp.VoiceInputHelper.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public final class afdp
  implements VoiceRecognizerListener
{
  private final WebViewPlugin a;
  private String mCallback;
  private final Context mContext;
  private Handler mHandler;
  private final AtomicLong z;
  
  public afdp(WebViewPlugin paramWebViewPlugin)
  {
    this.a = paramWebViewPlugin;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin = paramWebViewPlugin.mRuntime;
      localObject1 = localObject2;
      if (paramWebViewPlugin != null)
      {
        paramWebViewPlugin = paramWebViewPlugin.getActivity();
        localObject1 = localObject2;
        if (paramWebViewPlugin != null) {
          localObject1 = paramWebViewPlugin.getApplicationContext();
        }
      }
    }
    this.mContext = ((Context)localObject1);
    if (localObject1 == null) {
      QLog.e("VoiceInputHelper", 1, "context is invalid.");
    }
    this.z = new AtomicLong(0L);
  }
  
  private void HH(boolean paramBoolean)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    do
    {
      return;
      localObject = ((Activity)localObject).getWindow();
    } while (localObject == null);
    if (paramBoolean)
    {
      ((Window)localObject).addFlags(128);
      return;
    }
    ((Window)localObject).clearFlags(128);
  }
  
  private boolean aiK()
  {
    AppActivity localAppActivity = b();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0);
  }
  
  private boolean aiM()
  {
    if (!apke.ah(this.mContext, "libWXVoice.so"))
    {
      QLog.e("VoiceInputHelper", 1, "setup error, so lib not exists");
      return false;
    }
    int i = VoiceRecognizer.shareInstance().init(this.mContext, "wxcd8072f67d2d78d4", apke.G(this.mContext, "libWXVoice.so"));
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "setup failed, ret=" + i);
      return false;
    }
    return true;
  }
  
  private boolean aiN()
  {
    int i = VoiceRecognizer.shareInstance().start();
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "start failed, ret=" + i);
      return false;
    }
    HH(true);
    return true;
  }
  
  private AppActivity b()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof AppActivity)) {
      return (AppActivity)localActivity;
    }
    return null;
  }
  
  private void cYy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1);
    }
  }
  
  private Activity getActivity()
  {
    if (this.a == null) {}
    for (WebViewPlugin.a locala = null; locala == null; locala = this.a.mRuntime) {
      return null;
    }
    return locala.getActivity();
  }
  
  public static void p(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceInputHelper", 2, "voice input helper preInit invalid app");
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break;
        }
        new apke(paramAppInterface.getApplication().getApplicationContext(), "3171", "libWXVoice.so", "WXVoice").execute();
      } while (!QLog.isColorLevel());
      QLog.d("VoiceInputHelper", 2, "voice input helper preInit doing");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VoiceInputHelper", 2, "voice input helper preInit app isn't QQAppInterface, app=" + paramAppInterface);
  }
  
  private void requestPermission()
  {
    AppActivity localAppActivity = b();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new afdq(this), 1818, new String[] { "android.permission.RECORD_AUDIO" });
    if (this.mHandler == null) {
      this.mHandler = new afdr(this, Looper.getMainLooper());
    }
    this.mHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  public boolean aiL()
  {
    if (this.mContext == null) {
      return false;
    }
    VoiceRecognizer.shareInstance().setListener(this);
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(1);
    VoiceRecognizer.shareInstance().setSilentTime(1000);
    ThreadManager.excute(new VoiceInputHelper.1(this), 64, null, true);
    return true;
  }
  
  public void destroy()
  {
    this.mCallback = null;
    cYy();
    this.mHandler = null;
    VoiceRecognizer.shareInstance().destroy();
    HH(false);
  }
  
  public void onGetError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceInputHelper", 2, "onGetError:" + paramInt);
    }
    String str = this.mCallback;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("errorCode", paramInt);
      ((JSONObject)localObject2).put("cmd", "error");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onGetError error", localJSONException);
      }
    }
    if ((this.a != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.a.callJs(str, new String[] { localObject1 });
    }
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if (paramVoiceRecognizerResult == null) {}
    for (;;)
    {
      return;
      long l;
      String str;
      if (paramVoiceRecognizerResult.isEnd)
      {
        l = this.z.getAndIncrement();
        str = this.mCallback;
        if (TextUtils.isEmpty(str)) {
          continue;
        }
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("text", paramVoiceRecognizerResult.text);
        localJSONObject.put("voice_id", l);
        localJSONObject.put("startOffset", paramVoiceRecognizerResult.startTime);
        localJSONObject.put("endOffset", paramVoiceRecognizerResult.stopTime);
        localJSONObject.put("cmd", "result");
        paramVoiceRecognizerResult = localJSONObject.toString();
        if ((this.a == null) || (TextUtils.isEmpty(paramVoiceRecognizerResult))) {
          continue;
        }
        this.a.callJs(str, new String[] { paramVoiceRecognizerResult });
        return;
        l = this.z.get();
      }
      catch (JSONException paramVoiceRecognizerResult)
      {
        for (;;)
        {
          QLog.e("VoiceInputHelper", 1, "onGetResult error", paramVoiceRecognizerResult);
          paramVoiceRecognizerResult = "";
        }
      }
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceInputHelper", 2, "onGetVoiceRecordState:" + paramVoiceRecordState);
    }
    String str;
    if ((paramVoiceRecordState == VoiceRecordState.Canceling) || (paramVoiceRecordState == VoiceRecordState.Canceled) || (paramVoiceRecordState == VoiceRecordState.Complete))
    {
      str = this.mCallback;
      if (!TextUtils.isEmpty(str)) {
        paramVoiceRecordState = "";
      }
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "canceled");
      localObject = ((JSONObject)localObject).toString();
      paramVoiceRecordState = (VoiceRecordState)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onGetVoiceRecordState error", localJSONException);
      }
    }
    if ((this.a != null) && (!TextUtils.isEmpty(paramVoiceRecordState))) {
      this.a.callJs(str, new String[] { paramVoiceRecordState });
    }
  }
  
  public void onVolumeChanged(int paramInt)
  {
    String str = this.mCallback;
    Object localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("volume", paramInt);
      ((JSONObject)localObject2).put("cmd", "volume");
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VoiceInputHelper", 1, "onVolumeChanged error", localJSONException);
      }
    }
    if ((this.a != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      this.a.callJs(str, new String[] { localObject1 });
    }
  }
  
  public boolean stop()
  {
    int i = VoiceRecognizer.shareInstance().stop();
    if (i < 0)
    {
      QLog.e("VoiceInputHelper", 1, "stop failed, ret=" + i);
      return false;
    }
    HH(false);
    return true;
  }
  
  public boolean y(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("VoiceInputHelper", 1, "start failed, callback is invalid.");
    }
    while (this.a == null) {
      return false;
    }
    this.mCallback = paramString;
    if (aiK()) {
      return aiN();
    }
    requestPermission();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdp
 * JD-Core Version:    0.7.0.1
 */