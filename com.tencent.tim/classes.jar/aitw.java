import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aitw
  implements View.OnClickListener
{
  public aitw(LocationShareFragment paramLocationShareFragment, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (LocationShareFragment.a(this.this$0).apG()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LocationPickFragment.a(this.this$0.getActivity(), this.deX, this.bfK, LocationShareFragment.a(this.this$0).b());
      anot.a(null, "CliOper", "", "", "0X800A95C", "0X800A95C", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitw
 * JD-Core Version:    0.7.0.1
 */