import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aulp
  implements View.OnClickListener
{
  aulp(auln paramauln) {}
  
  public void onClick(View paramView)
  {
    if (auln.a(this.this$0).isShowing())
    {
      auln.b(this.this$0).cancel();
      auln.c(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulp
 * JD-Core Version:    0.7.0.1
 */