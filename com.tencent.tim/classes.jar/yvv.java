import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yvv
  implements View.OnClickListener
{
  yvv(yvt paramyvt, yvx paramyvx) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yvt.a != null)
    {
      int i = this.jdField_a_of_type_Yvx.getAdapterPosition();
      this.jdField_a_of_type_Yvt.a.a(paramView, this.jdField_a_of_type_Yvx, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvv
 * JD-Core Version:    0.7.0.1
 */