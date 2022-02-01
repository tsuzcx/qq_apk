package com.tencent.mobileqq.activity.weather.webpage;

import abdf;
import ajos;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "invoke"}, k=3, mv={1, 1, 16})
public final class WeatherArkNotify$viewModel$2
  extends Lambda
  implements Function0<abdf>
{
  public WeatherArkNotify$viewModel$2(LifeCycleFragment paramLifeCycleFragment)
  {
    super(0);
  }
  
  @NotNull
  public final abdf invoke()
  {
    return (abdf)ajos.a((ViewModelStoreOwner)this.$fragment).get(abdf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkNotify.viewModel.2
 * JD-Core Version:    0.7.0.1
 */