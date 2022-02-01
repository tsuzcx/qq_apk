package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.mobileqq.data.AccountDetail;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WeatherWebPageHelperKt$hasFollowWeather$1$1
  implements Runnable
{
  WeatherWebPageHelperKt$hasFollowWeather$1$1(WeatherWebPageHelperKt.hasFollowWeather.1 param1) {}
  
  public final void run()
  {
    if ((AccountDetail)this.this$0.a.element == null)
    {
      this.this$0.$callback.invoke(Boolean.valueOf(false));
      return;
    }
    Function1 localFunction1 = this.this$0.$callback;
    if (((AccountDetail)this.this$0.a.element).followType == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localFunction1.invoke(Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.hasFollowWeather.1.1
 * JD-Core Version:    0.7.0.1
 */