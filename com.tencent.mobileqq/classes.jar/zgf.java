import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zgf
  implements View.OnClickListener
{
  zgf(zgd paramzgd, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (zgd.a(this.jdField_a_of_type_Zgd) != null) {
      zgd.a(this.jdField_a_of_type_Zgd).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgf
 * JD-Core Version:    0.7.0.1
 */