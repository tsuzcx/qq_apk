import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yzt
  implements View.OnClickListener
{
  yzt(yzr paramyzr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (yzr.a(this.jdField_a_of_type_Yzr) != null) {
      yzr.a(this.jdField_a_of_type_Yzr).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzt
 * JD-Core Version:    0.7.0.1
 */