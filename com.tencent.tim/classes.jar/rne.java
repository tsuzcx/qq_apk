import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rne
  implements View.OnClickListener
{
  public rne(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    ram.d("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.b.aIU);
    if (HorizontalSelectColorLayout.a(this.b) > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.b.aIU) && (this.b.a != null)) {
        this.b.a.bum();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rne
 * JD-Core Version:    0.7.0.1
 */