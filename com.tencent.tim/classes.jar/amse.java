import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amse
  implements View.OnClickListener
{
  amse(amsd paramamsd, ampx paramampx) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ampx.cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amse
 * JD-Core Version:    0.7.0.1
 */