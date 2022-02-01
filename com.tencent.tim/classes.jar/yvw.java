import android.view.View;
import android.view.View.OnLongClickListener;

class yvw
  implements View.OnLongClickListener
{
  yvw(yvt paramyvt, yvx paramyvx) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Yvt.a != null)
    {
      int i = this.jdField_a_of_type_Yvx.getAdapterPosition();
      return this.jdField_a_of_type_Yvt.a.a(paramView, this.jdField_a_of_type_Yvx, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvw
 * JD-Core Version:    0.7.0.1
 */