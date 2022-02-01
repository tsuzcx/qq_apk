import android.view.View;
import android.view.View.OnLongClickListener;

class prs
  implements View.OnLongClickListener
{
  prs(prq paramprq, prp paramprp) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Prp.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Prq.a.N(this.jdField_a_of_type_Prp.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prs
 * JD-Core Version:    0.7.0.1
 */