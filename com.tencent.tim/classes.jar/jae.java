import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jae
  implements View.OnClickListener
{
  public jae(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong, Intent paramIntent, iiv paramiiv) {}
  
  public void onClick(View paramView)
  {
    this.this$0.a(this.kQ, this.val$intent, this.g);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jae
 * JD-Core Version:    0.7.0.1
 */