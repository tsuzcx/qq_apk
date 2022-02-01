import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ygz
  implements View.OnClickListener
{
  ygz(ygp paramygp, yjw paramyjw) {}
  
  public void onClick(View paramView)
  {
    ykv.a("home_page", "guide_close", 0, 0, new String[0]);
    this.jdField_a_of_type_Yjw.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygz
 * JD-Core Version:    0.7.0.1
 */