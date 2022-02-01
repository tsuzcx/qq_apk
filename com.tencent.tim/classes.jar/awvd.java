import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awvd
  implements View.OnClickListener
{
  awvd(awvc paramawvc, int paramInt, awur.c paramc) {}
  
  public void onClick(View paramView)
  {
    awvc.a(this.this$0, this.val$position, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvd
 * JD-Core Version:    0.7.0.1
 */