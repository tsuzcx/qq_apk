import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zyo
  implements View.OnClickListener
{
  zyo(zyl paramzyl, zyr paramzyr) {}
  
  public void onClick(View paramView)
  {
    if (zyl.a(this.jdField_a_of_type_Zyl) != null) {
      zyl.a(this.jdField_a_of_type_Zyl).c(this.jdField_a_of_type_Zyr);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyo
 * JD-Core Version:    0.7.0.1
 */