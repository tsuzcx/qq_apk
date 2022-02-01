import android.view.View;
import android.view.View.OnLongClickListener;

class wrr
  implements View.OnLongClickListener
{
  wrr(wrp paramwrp, wro paramwro) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wro.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wrp.a.b(this.jdField_a_of_type_Wro.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */