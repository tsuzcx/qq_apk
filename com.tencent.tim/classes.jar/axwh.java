import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class axwh
  implements SeekBar.OnSeekBarChangeListener
{
  public axwh(AdvancedProviderView paramAdvancedProviderView, TextView paramTextView, View paramView1, View paramView2, QIMProviderContainerView paramQIMProviderContainerView, View paramView3) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.c != null)
    {
      this.a.c.aev(paramInt);
      this.ahC.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.val$rootView != null) && ((this.val$rootView instanceof ViewGroup))) {
      ((ViewGroup)this.val$rootView).setMotionEventSplittingEnabled(false);
    }
    int j = 300;
    int i = j;
    if (AdvancedProviderView.a(this.a) != null)
    {
      i = j;
      if (!AdvancedProviderView.a(this.a).hasEnded())
      {
        AdvancedProviderView.a(this.a).cancel();
        i = 0;
      }
    }
    this.MR.setAlpha(1.0F);
    AdvancedProviderView.a(this.a, AdvancedProviderView.a(this.a, this.c, this.MS, AdvancedProviderView.a(this.a), 0.0F));
    AdvancedProviderView.a(this.a).setDuration((AdvancedProviderView.a(this.a) * AdvancedProviderView.a(this.a)));
    AdvancedProviderView.a(this.a).setStartOffset(i);
    this.a.startAnimation(AdvancedProviderView.a(this.a));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.val$rootView != null) && ((this.val$rootView instanceof ViewGroup))) {
      ((ViewGroup)this.val$rootView).setMotionEventSplittingEnabled(true);
    }
    this.a.adD(paramSeekBar.getProgress());
    if ((AdvancedProviderView.a(this.a) != null) && (!AdvancedProviderView.a(this.a).hasEnded())) {
      AdvancedProviderView.a(this.a).cancel();
    }
    AdvancedProviderView.a(this.a, AdvancedProviderView.a(this.a, this.c, this.MS, AdvancedProviderView.a(this.a), 1.0F));
    AdvancedProviderView.a(this.a).setDuration(((1.0F - AdvancedProviderView.a(this.a)) * AdvancedProviderView.a(this.a)));
    this.a.startAnimation(AdvancedProviderView.a(this.a));
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwh
 * JD-Core Version:    0.7.0.1
 */