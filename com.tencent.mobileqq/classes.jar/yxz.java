import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yxz
  implements View.OnClickListener
{
  yxz(yxw paramyxw, yyc paramyyc) {}
  
  public void onClick(View paramView)
  {
    if (yxw.a(this.jdField_a_of_type_Yxw) != null) {
      yxw.a(this.jdField_a_of_type_Yxw).c(this.jdField_a_of_type_Yyc);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxz
 * JD-Core Version:    0.7.0.1
 */