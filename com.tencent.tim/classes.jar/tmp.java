import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tmp
  implements View.OnClickListener
{
  public tmp(GdtVideoCeilingTitleBar paramGdtVideoCeilingTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (GdtVideoCeilingTitleBar.a(this.a) != null) {
      GdtVideoCeilingTitleBar.a(this.a).er(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmp
 * JD-Core Version:    0.7.0.1
 */