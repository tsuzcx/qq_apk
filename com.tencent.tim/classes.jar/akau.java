import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akau
  implements View.OnClickListener
{
  akau(ajzv paramajzv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hp(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akau
 * JD-Core Version:    0.7.0.1
 */