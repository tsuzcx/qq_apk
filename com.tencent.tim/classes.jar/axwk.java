import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

public class axwk
  implements View.OnClickListener
{
  public axwk(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = ayzr.a().ic();
    if (localList.size() > 1) {
      rpw.a(this.a.mContext, localList.get(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwk
 * JD-Core Version:    0.7.0.1
 */