import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yqr
  implements View.OnClickListener
{
  yqr(yqj paramyqj, ytq paramytq) {}
  
  public void onClick(View paramView)
  {
    yup.a("home_page", "guide_shoot", 0, 0, new String[0]);
    this.jdField_a_of_type_Yqj.a.a(false, true, 13, null);
    this.jdField_a_of_type_Ytq.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqr
 * JD-Core Version:    0.7.0.1
 */