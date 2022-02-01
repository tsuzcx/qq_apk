import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class awzr
  implements View.OnClickListener
{
  public awzr(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      rar.a("clk_filter", rar.ea(alwx.dyy), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.e) != 0)
      {
        AEProviderContainerView.b(this.e);
        continue;
        rar.a("clk_beauty", rar.ea(alwx.dyy), 0, false, new String[0]);
        if (AEProviderContainerView.a(this.e) != 1) {
          AEProviderContainerView.c(this.e);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzr
 * JD-Core Version:    0.7.0.1
 */