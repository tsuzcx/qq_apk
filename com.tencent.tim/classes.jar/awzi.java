import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awzi
  implements View.OnClickListener
{
  awzi(awzh paramawzh, awzh.b paramb) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Awzh$b.getLayoutPosition();
    awzh.a(this.jdField_a_of_type_Awzh).onItemClick(this.jdField_a_of_type_Awzh$b.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzi
 * JD-Core Version:    0.7.0.1
 */