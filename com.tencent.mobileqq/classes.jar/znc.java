import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class znc
  implements View.OnClickListener
{
  znc(zmz paramzmz, znf paramznf) {}
  
  public void onClick(View paramView)
  {
    if (zmz.a(this.jdField_a_of_type_Zmz) != null) {
      zmz.a(this.jdField_a_of_type_Zmz).c(this.jdField_a_of_type_Znf);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znc
 * JD-Core Version:    0.7.0.1
 */