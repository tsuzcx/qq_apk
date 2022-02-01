import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ykk
  implements View.OnClickListener
{
  ykk(ykj paramykj, yki paramyki, zbe paramzbe) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yki != null) {
      this.jdField_a_of_type_Yki.a(this.jdField_a_of_type_Zbe);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykk
 * JD-Core Version:    0.7.0.1
 */