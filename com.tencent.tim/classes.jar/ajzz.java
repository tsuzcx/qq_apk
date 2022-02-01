import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajzz
  implements View.OnClickListener
{
  ajzz(ajzv paramajzv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hm(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzz
 * JD-Core Version:    0.7.0.1
 */