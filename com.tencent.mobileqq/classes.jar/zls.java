import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zls
  implements View.OnClickListener
{
  public zls(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    yuk.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Zlu != null)) {
        this.a.jdField_a_of_type_Zlu.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zls
 * JD-Core Version:    0.7.0.1
 */