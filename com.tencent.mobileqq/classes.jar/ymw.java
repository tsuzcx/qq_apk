import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ymw
  implements View.OnClickListener
{
  ymw(ymo paramymo, ypv paramypv) {}
  
  public void onClick(View paramView)
  {
    yqu.a("home_page", "guide_shoot", 0, 0, new String[0]);
    this.jdField_a_of_type_Ymo.a.a(false, true, 13, null);
    this.jdField_a_of_type_Ypv.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymw
 * JD-Core Version:    0.7.0.1
 */