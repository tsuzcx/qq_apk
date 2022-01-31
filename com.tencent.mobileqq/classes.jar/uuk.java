import android.view.View;
import android.view.View.OnLongClickListener;

class uuk
  implements View.OnLongClickListener
{
  uuk(uui paramuui, uuh paramuuh) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Uuh.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Uui.a.b(this.jdField_a_of_type_Uuh.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */