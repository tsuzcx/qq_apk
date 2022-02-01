import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xsd
  implements View.OnClickListener
{
  xsd(xru paramxru, xvb paramxvb) {}
  
  public void onClick(View paramView)
  {
    xwa.a("home_page", "guide_close", 0, 0, new String[0]);
    this.jdField_a_of_type_Xvb.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsd
 * JD-Core Version:    0.7.0.1
 */