import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiss
  implements View.OnClickListener
{
  public aiss(LocationPickFragment paramLocationPickFragment) {}
  
  public void onClick(View paramView)
  {
    if (LocationPickFragment.a(this.this$0).aQZ()) {
      LocationPickFragment.a(this.this$0).hidePanel();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LocationPickFragment.a(this.this$0).displayPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiss
 * JD-Core Version:    0.7.0.1
 */