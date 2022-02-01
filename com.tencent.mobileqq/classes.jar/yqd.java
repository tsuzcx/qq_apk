import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yqd
  implements View.OnClickListener
{
  yqd(yqc paramyqc) {}
  
  public void onClick(View paramView)
  {
    ypy localypy = this.a.jdField_a_of_type_Ypy;
    if (localypy != null) {
      localypy.a(this.a.jdField_a_of_type_Yqe, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqd
 * JD-Core Version:    0.7.0.1
 */