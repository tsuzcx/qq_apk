import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufa
  implements View.OnClickListener
{
  ufa(uez paramuez, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (uez.a(this.jdField_a_of_type_Uez) != null) {
      uez.a(this.jdField_a_of_type_Uez).a(paramView, 12, this.jdField_a_of_type_Int, uez.a(this.jdField_a_of_type_Uez));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufa
 * JD-Core Version:    0.7.0.1
 */