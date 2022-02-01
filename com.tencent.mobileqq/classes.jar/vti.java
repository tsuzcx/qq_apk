import android.view.View;
import android.view.View.OnLongClickListener;

class vti
  implements View.OnLongClickListener
{
  vti(vtg paramvtg, vtf paramvtf) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Vtf.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Vtg.a.b(this.jdField_a_of_type_Vtf.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vti
 * JD-Core Version:    0.7.0.1
 */