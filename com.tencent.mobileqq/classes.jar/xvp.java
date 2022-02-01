import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xvp
  implements View.OnClickListener
{
  xvp(xvo paramxvo, xvn paramxvn, yml paramyml) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xvn != null) {
      this.jdField_a_of_type_Xvn.a(this.jdField_a_of_type_Yml);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvp
 * JD-Core Version:    0.7.0.1
 */