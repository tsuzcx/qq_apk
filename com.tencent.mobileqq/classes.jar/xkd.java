import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class xkd
  implements View.OnClickListener
{
  public xkd(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    wsv.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    while ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Xkf == null)) {
      return;
    }
    this.a.jdField_a_of_type_Xkf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkd
 * JD-Core Version:    0.7.0.1
 */