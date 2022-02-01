import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wnv
  implements View.OnClickListener
{
  wnv(wnu paramwnu, wnt paramwnt) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wnt.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wnu.a.a(this.jdField_a_of_type_Wnt.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnv
 * JD-Core Version:    0.7.0.1
 */