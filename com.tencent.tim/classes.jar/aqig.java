import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqig
  implements View.OnClickListener
{
  aqig(aqhv paramaqhv) {}
  
  public void onClick(View paramView)
  {
    if ((aqhv.a(this.this$0) != null) && (aqhv.a(this.this$0).isShowing())) {
      aqhv.a(this.this$0).dismiss();
    }
    aqhv.b(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqig
 * JD-Core Version:    0.7.0.1
 */