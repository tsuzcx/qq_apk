import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class zkh
  implements View.OnClickListener
{
  zkh(zkl paramzkl, String paramString, bjnw parambjnw) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Zkl.a(false, this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Bjnw.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkh
 * JD-Core Version:    0.7.0.1
 */