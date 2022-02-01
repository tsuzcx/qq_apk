import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akax
  implements View.OnClickListener
{
  akax(ajzv paramajzv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.ht(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akax
 * JD-Core Version:    0.7.0.1
 */