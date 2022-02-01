import android.text.TextUtils;
import com.tencent.mobileqq.activity.weather.webpage.WeatherArkNotify.viewModel.2;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.b;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkNotify;", "Lcom/tencent/mobileqq/ark/API/ArkAppNotifyCenter$INotifyReg;", "fragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "(Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;)V", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "notify", "", "appName", "", "eventName", "params", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdc
  implements ArkAppNotifyCenter.b
{
  public static final abdc.a a = new abdc.a(null);
  private final Lazy c;
  
  public abdc(@NotNull LifeCycleFragment paramLifeCycleFragment)
  {
    this.c = LazyKt.lazy((Function0)new WeatherArkNotify.viewModel.2(paramLifeCycleFragment));
  }
  
  private final abdf a()
  {
    return (abdf)this.c.getValue();
  }
  
  public boolean notify(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherArkNotify", 2, "notify --->  appName: " + paramString1 + ", eventName: " + paramString2 + ", params: " + paramString3);
    }
    try
    {
      if (!TextUtils.equals((CharSequence)paramString1, (CharSequence)"com.tencent.weather_v2")) {
        break label150;
      }
      if (paramString2 == null) {
        return true;
      }
      switch (paramString2.hashCode())
      {
      case 6648771: 
        if (!paramString2.equals("notify_client_msg")) {
          break label150;
        }
        a().Bq(paramString3);
        return true;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.d("WeatherArkNotify", 1, paramString1, new Object[0]);
      return true;
    }
    if (paramString2.equals("notify_web_msg")) {
      a().Bp(paramString3);
    }
    label150:
    return true;
    return true;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkNotify$Companion;", "", "()V", "TAG", "", "WEATHER_ARK_APP_NAME", "WEATHER_ARK_METHOD_TO_CLIENT", "WEATHER_ARK_METHOD_TO_WEB", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdc
 * JD-Core Version:    0.7.0.1
 */