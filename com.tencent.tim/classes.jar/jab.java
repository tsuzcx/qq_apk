import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jab
  implements View.OnClickListener
{
  public jab(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mv(2);
    this.this$0.a(this.kQ, "onClickIgnore", true, null, -1);
    this.this$0.kd("onClickIgnore");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jab
 * JD-Core Version:    0.7.0.1
 */