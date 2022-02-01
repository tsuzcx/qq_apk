import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yqj
  implements View.OnClickListener
{
  yqj(yqi paramyqi, yqh paramyqh, zhq paramzhq) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yqh != null) {
      this.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Zhq);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqj
 * JD-Core Version:    0.7.0.1
 */