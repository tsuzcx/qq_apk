import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "webPageData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "getWebPageData", "()Landroid/arch/lifecycle/MutableLiveData;", "onArkLoadState", "", "state", "", "onArkMsgToClient", "params", "", "onArkMsgToWeb", "requestAndCompareAdCode", "originAdCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdf
  extends ViewModel
{
  public static final abdf.a a = new abdf.a(null);
  @NotNull
  private final MutableLiveData<abdl> C = new MutableLiveData();
  
  public final void Bo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    aczc.a((aczc.b)new abdg(this, paramString, "qq_weather", false));
  }
  
  public final void Bp(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToWeb  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.optInt("type") == 1)
      {
        i = localJSONObject.optJSONObject("data").optInt("height");
        this.C.postValue(new abdl(0, "receive_ark_msg", paramString, null, 0, i, 24, null));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
        int i = 0;
      }
    }
  }
  
  public final void Bq(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToClient  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).optInt("type") == 1)
      {
        localObject = ((JSONObject)localObject).optJSONObject("data").optString("bg_url");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          MutableLiveData localMutableLiveData = this.C;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "bgUrl");
          localMutableLiveData.postValue(new abdl(1, null, null, (String)localObject, 0, 0, 54, null));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
      }
    }
  }
  
  public final void GV(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkLoadComplete  state: " + paramInt);
    }
    this.C.postValue(new abdl(2, null, null, null, paramInt, 0, 46, null));
  }
  
  @NotNull
  public final MutableLiveData<abdl> v()
  {
    return this.C;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$Companion;", "", "()V", "FUNCTION_RECEIVE_ARK_MSG", "", "TAG", "UIN_TYPE_PUBLIC_ACCOUNT", "", "WEATHER_NICK_NAME", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdf
 * JD-Core Version:    0.7.0.1
 */