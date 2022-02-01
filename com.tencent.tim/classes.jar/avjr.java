import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avjr
  implements View.OnClickListener
{
  avjr(avjq paramavjq, avju paramavju) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Avju.gJ(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjr
 * JD-Core Version:    0.7.0.1
 */