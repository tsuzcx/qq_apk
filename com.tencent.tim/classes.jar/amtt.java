import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtt
  implements View.OnClickListener
{
  amtt(amtn paramamtn, amqs paramamqs, amyt paramamyt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Amqs.cR(this.jdField_a_of_type_Amyt.getView());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtt
 * JD-Core Version:    0.7.0.1
 */