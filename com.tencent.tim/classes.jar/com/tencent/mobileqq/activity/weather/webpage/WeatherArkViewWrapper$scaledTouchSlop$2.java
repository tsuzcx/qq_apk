package com.tencent.mobileqq.activity.weather.webpage;

import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WeatherArkViewWrapper$scaledTouchSlop$2
  extends Lambda
  implements Function0<Integer>
{
  WeatherArkViewWrapper$scaledTouchSlop$2(WeatherArkViewWrapper paramWeatherArkViewWrapper)
  {
    super(0);
  }
  
  public final int invoke()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(this.this$0.getContext());
    Intrinsics.checkExpressionValueIsNotNull(localViewConfiguration, "ViewConfiguration.get(context)");
    return localViewConfiguration.getScaledTouchSlop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper.scaledTouchSlop.2
 * JD-Core Version:    0.7.0.1
 */