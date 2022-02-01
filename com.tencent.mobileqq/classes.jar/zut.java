import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zut
  implements View.OnClickListener
{
  zut(zuq paramzuq, zuw paramzuw) {}
  
  public void onClick(View paramView)
  {
    if (zuq.a(this.jdField_a_of_type_Zuq) != null) {
      zuq.a(this.jdField_a_of_type_Zuq).c(this.jdField_a_of_type_Zuw);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zut
 * JD-Core Version:    0.7.0.1
 */