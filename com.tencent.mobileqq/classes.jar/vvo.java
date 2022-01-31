import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class vvo
  implements View.OnClickListener
{
  public vvo(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    veg.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    while ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Vvq == null)) {
      return;
    }
    this.a.jdField_a_of_type_Vvq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvo
 * JD-Core Version:    0.7.0.1
 */