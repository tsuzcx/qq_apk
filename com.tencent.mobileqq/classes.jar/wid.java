import android.view.View;
import android.view.View.OnLongClickListener;

class wid
  implements View.OnLongClickListener
{
  wid(wib paramwib, wia paramwia) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wia.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wib.a.b(this.jdField_a_of_type_Wia.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wid
 * JD-Core Version:    0.7.0.1
 */