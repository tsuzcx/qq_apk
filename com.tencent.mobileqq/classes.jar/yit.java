import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yit
  implements View.OnClickListener
{
  yit(yis paramyis, yiv paramyiv) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Yiv.a()) {
      this.jdField_a_of_type_Yiv.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Yis.a != null) {
        this.jdField_a_of_type_Yis.a.a(this.jdField_a_of_type_Yis);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Yiv.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yit
 * JD-Core Version:    0.7.0.1
 */