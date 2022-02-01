package com.tencent.mobileqq.activity.weather.webpage;

import acja;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class WeatherWebPageHelperKt$hasFollowWeather$1
  implements Runnable
{
  public WeatherWebPageHelperKt$hasFollowWeather$1(Ref.ObjectRef paramObjectRef, acja paramacja, Function1 paramFunction1) {}
  
  public final void run()
  {
    this.a.element = this.c.a("2658655094");
    ThreadManager.getUIHandler().post((Runnable)new WeatherWebPageHelperKt.hasFollowWeather.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.hasFollowWeather.1
 * JD-Core Version:    0.7.0.1
 */