import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jdy
  implements View.OnClickListener
{
  public jdy(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(View paramView)
  {
    jjk.onClick(paramView.getId());
    AVActivity localAVActivity = this.this$0.a();
    if (localAVActivity != null) {
      localAVActivity.BtnOnClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdy
 * JD-Core Version:    0.7.0.1
 */