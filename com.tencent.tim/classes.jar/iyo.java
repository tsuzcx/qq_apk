import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class iyo
  implements View.OnClickListener
{
  public iyo(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.this$0.TAG, 1, "onClick R.id.qav_btn_accept_video");
    this.this$0.asz();
    this.this$0.a.b().Rb = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyo
 * JD-Core Version:    0.7.0.1
 */