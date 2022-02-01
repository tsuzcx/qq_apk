import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqih
  implements View.OnClickListener
{
  aqih(aqhv paramaqhv) {}
  
  public void onClick(View paramView)
  {
    if ((aqhv.a(this.this$0) != null) && (aqhv.a(this.this$0).isShowing())) {
      aqhv.a(this.this$0).dismiss();
    }
    ((BaseActivity)this.this$0.context).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqih
 * JD-Core Version:    0.7.0.1
 */