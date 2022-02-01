import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auwp
  implements View.OnClickListener
{
  auwp(auwo paramauwo, auwn paramauwn) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Auwn.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Auwo.a.onItemClick(this.jdField_a_of_type_Auwn.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwp
 * JD-Core Version:    0.7.0.1
 */