import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amtd
  implements View.OnClickListener
{
  amtd(amtc paramamtc, ampg paramampg) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ampg.hD(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtd
 * JD-Core Version:    0.7.0.1
 */