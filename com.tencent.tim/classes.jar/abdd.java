import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper$initArkView$1", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "onLoadFailed", "", "state", "", "errCode", "msg", "", "canRetry", "", "onLoadState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdd
  implements ArkViewImplement.LoadCallback
{
  public void onLoadFailed(int paramInt1, int paramInt2, @Nullable String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "initArkView onLoadState : state -> " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      WeatherArkViewWrapper.a(this.this$0);
      return;
    case -1: 
      WeatherArkViewWrapper.b(this.this$0);
      return;
    }
    WeatherArkViewWrapper.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdd
 * JD-Core Version:    0.7.0.1
 */