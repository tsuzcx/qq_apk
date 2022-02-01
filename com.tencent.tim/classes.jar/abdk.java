import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "onWebCallArk", "", "argument", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdk
  extends WebViewPlugin
{
  public static final abdk.a a = new abdk.a(null);
  
  private final void Bs(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebViewPlugin", 2, "onWebCallArk -> argument : " + paramString);
    }
    ark.arkNotify("com.tencent.weather_v2", "receive_web_msg", paramString, "json");
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebViewPlugin", 2, "handleJsRequest -> url : " + paramString1 + ",pkgName : " + paramString2 + ",method : " + paramString3 + ",args[0 : " + paramVarArgs[0]);
    }
    if (TextUtils.equals((CharSequence)paramString2, (CharSequence)"weather"))
    {
      if (paramVarArgs.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label147;
        }
      }
      label147:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!TextUtils.equals((CharSequence)paramString3, (CharSequence)"notify_ark_msg"))) {
          break label153;
        }
        paramJsBridgeListener = paramVarArgs[0];
        if (paramJsBridgeListener != null) {
          ((abdk)this).Bs(paramJsBridgeListener);
        }
        return true;
        i = 0;
        break;
      }
    }
    label153:
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebViewPlugin$Companion;", "", "()V", "METHOD_NOTIFY_ARK", "", "METHOD_RECEIVE_WEB", "NAME_SPACE", "TAG", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdk
 * JD-Core Version:    0.7.0.1
 */