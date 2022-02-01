import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yue
  implements View.OnClickListener
{
  yue(yud paramyud, yuc paramyuc, zll paramzll) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yuc != null) {
      this.jdField_a_of_type_Yuc.a(this.jdField_a_of_type_Zll);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yue
 * JD-Core Version:    0.7.0.1
 */