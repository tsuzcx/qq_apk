import android.view.View;
import android.view.View.OnLongClickListener;

class auwq
  implements View.OnLongClickListener
{
  auwq(auwo paramauwo, auwn paramauwn) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Auwn.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Auwo.a.N(this.jdField_a_of_type_Auwn.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwq
 * JD-Core Version:    0.7.0.1
 */