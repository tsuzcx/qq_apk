import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abop
  implements View.OnClickListener
{
  abop(aboo paramaboo) {}
  
  public void onClick(View paramView)
  {
    aboo.a(this.this$0, true);
    this.this$0.cDx();
    aboo.a(this.this$0, -1, -1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abop
 * JD-Core Version:    0.7.0.1
 */