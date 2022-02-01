import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wrq
  implements View.OnClickListener
{
  wrq(wrp paramwrp, wro paramwro) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wro.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wrp.a.a(this.jdField_a_of_type_Wro.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrq
 * JD-Core Version:    0.7.0.1
 */