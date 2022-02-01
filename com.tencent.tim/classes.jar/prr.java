import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class prr
  implements View.OnClickListener
{
  prr(prq paramprq, prp paramprp) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Prp.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Prq.a.onItemClick(this.jdField_a_of_type_Prp.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prr
 * JD-Core Version:    0.7.0.1
 */