import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amkq
  implements View.OnClickListener
{
  amkq(amkp paramamkp, argu paramargu) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Argu.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkq
 * JD-Core Version:    0.7.0.1
 */