import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vze
  implements View.OnClickListener
{
  vze(vzd paramvzd, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (vyz.a(this.jdField_a_of_type_Vzd.a.a) != null) {
      vyz.a(this.jdField_a_of_type_Vzd.a.a).b(this.jdField_a_of_type_Long);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vze
 * JD-Core Version:    0.7.0.1
 */