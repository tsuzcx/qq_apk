import android.view.View;
import android.view.View.OnLongClickListener;

class wnw
  implements View.OnLongClickListener
{
  wnw(wnu paramwnu, wnt paramwnt) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wnt.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wnu.a.b(this.jdField_a_of_type_Wnt.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */