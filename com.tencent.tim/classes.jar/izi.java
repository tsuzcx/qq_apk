import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class izi
  implements View.OnClickListener
{
  public izi(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izi
 * JD-Core Version:    0.7.0.1
 */