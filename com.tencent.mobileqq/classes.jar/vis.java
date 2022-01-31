import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class vis
  implements View.OnClickListener
{
  public vis(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    urk.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    while ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_Viu == null)) {
      return;
    }
    this.a.jdField_a_of_type_Viu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vis
 * JD-Core Version:    0.7.0.1
 */