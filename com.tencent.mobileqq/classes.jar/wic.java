import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wic
  implements View.OnClickListener
{
  wic(wib paramwib, wia paramwia) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Wia.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Wib.a.a(this.jdField_a_of_type_Wia.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wic
 * JD-Core Version:    0.7.0.1
 */