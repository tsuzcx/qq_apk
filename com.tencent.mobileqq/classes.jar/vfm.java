import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;

public class vfm
  implements View.OnLongClickListener
{
  public vfm(CellTextView paramCellTextView) {}
  
  public boolean onLongClick(View paramView)
  {
    this.a.jdField_a_of_type_Boolean = true;
    this.a.postInvalidate();
    boolean bool = false;
    if (this.a.jdField_a_of_type_Vgs != null) {
      bool = this.a.jdField_a_of_type_Vgs.a(this.a, this.a.jdField_a_of_type_Vfo);
    }
    if (!bool) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfm
 * JD-Core Version:    0.7.0.1
 */