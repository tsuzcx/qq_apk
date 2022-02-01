import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ygx
  implements View.OnClickListener
{
  ygx(ygp paramygp, yjw paramyjw) {}
  
  public void onClick(View paramView)
  {
    ykv.a("home_page", "guide_shoot", 0, 0, new String[0]);
    this.jdField_a_of_type_Ygp.a.a(false, true, 13, null);
    this.jdField_a_of_type_Yjw.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygx
 * JD-Core Version:    0.7.0.1
 */