import android.view.View;
import android.view.View.OnLongClickListener;

class uqb
  implements View.OnLongClickListener
{
  uqb(upz paramupz, upy paramupy) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Upy.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Upz.a.b(this.jdField_a_of_type_Upy.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqb
 * JD-Core Version:    0.7.0.1
 */