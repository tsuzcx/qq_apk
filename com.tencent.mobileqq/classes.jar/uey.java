import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uey
  implements View.OnClickListener
{
  uey(uex paramuex, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (uex.a(this.jdField_a_of_type_Uex) != null) {
      uex.a(this.jdField_a_of_type_Uex).a(paramView, 12, this.jdField_a_of_type_Int, uex.a(this.jdField_a_of_type_Uex));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */