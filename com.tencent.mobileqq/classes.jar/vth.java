import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vth
  implements View.OnClickListener
{
  vth(vtg paramvtg, vtf paramvtf) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Vtf.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Vtg.a.a(this.jdField_a_of_type_Vtf.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vth
 * JD-Core Version:    0.7.0.1
 */