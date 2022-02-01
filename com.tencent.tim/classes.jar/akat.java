import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akat
  implements View.OnClickListener
{
  akat(ajzv paramajzv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.ho(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akat
 * JD-Core Version:    0.7.0.1
 */